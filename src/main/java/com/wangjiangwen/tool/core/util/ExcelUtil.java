package com.wangjiangwen.tool.core.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

/**
 * @author gavin
 * @since 2022/3/18
 */
public class ExcelUtil {

    public static void write(List<String> titleNames, List<List<Object>> data, OutputStream outputStream) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();

        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < titleNames.size(); i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(titleNames.get(i));
        }
        for (int i = 0; i < data.size(); i++) {
            HSSFRow dataRow = sheet.createRow(i + 1);
            for (int j = 0; j < data.get(i).size(); j++) {
                HSSFCell cell = dataRow.createCell(j);
                Object o = data.get(i).get(j);
                if (o instanceof Date) {
                    Date date = (Date) o;
                    cell.setCellValue(DateUtil.toString(date));
                } else {
                    cell.setCellValue(o.toString());
                }
            }
        }
        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
