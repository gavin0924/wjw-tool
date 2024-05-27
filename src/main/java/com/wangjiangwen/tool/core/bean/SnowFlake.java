package com.wangjiangwen.tool.core.bean;

import com.wangjiangwen.tool.core.date.SystemClock;
import com.wangjiangwen.tool.core.util.DateUtil;

/**
 * @author Gavin
 * @since 2021/8/5 17:18
 */
public class SnowFlake {
    private final long workerId;
    private long sequence;

    private final long workerIdBits = 10L;
    private final long sequenceBits = 12L;

    private final long workerIdShift = sequenceBits;
    private final long timestampShift = sequenceBits + workerIdBits;

    private final long maxWorkerId = ~(-1 << workerIdBits);
    private final long maxSequence = ~(-1 << sequenceBits);

    private static final long twepoch = 1288834974657L;
    private long lastTimestamp = 0;

    public SnowFlake(long workerId) {
        if (workerId < 0 || workerId > maxWorkerId) {
            throw new IllegalArgumentException("workerId不合法");
        }
        this.workerId = workerId;
    }

    public synchronized long nextId() {
        long timestamp = genTime();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException("时钟出现错误");
        }
        if (timestamp == lastTimestamp) {
            sequence = (sequence + 1) & (maxSequence);
            if (sequence == 0) {
                timestamp = nextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }
        lastTimestamp = timestamp;
        return (timestamp - twepoch << timestampShift) | (workerId << workerIdShift) | sequence;
    }

    private long nextMillis(long lastTimestamp) {
        long timestamp = genTime();
        while (timestamp <= lastTimestamp) {
            timestamp = genTime();
        }
        return timestamp;
    }

    private long genTime() {
        return SystemClock.now();
    }
}
