package com.techproed.seleniumPractice.day9;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SendDataToExcel {

    @Test
    public void sendData() throws IOException {
        String path ="src/test/java/resources/medal table.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(1);
        List<String> Australia =new ArrayList<>();
        int lastRow=sheet.getLastRowNum();
        int lastCell= sheet.getRow(1).getLastCellNum();
        for (int j = 0; j < lastCell; j++) {
            Australia.add(sheet.getRow(11).getCell(j).toString());
        }
        System.out.println(Australia);
        Sheet sheet1 =workbook.getSheetAt(0);
        sheet1.getRow(1).createCell(1).setCellValue(Australia.get(0));
        for (int i = 1; i < Australia.size(); i++) {
            sheet1.getRow(0).createCell(i).setCellValue(Australia.get(i));
        }
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();
    }
}
