package com.techproed.seleniumPractice.day9;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;

import java.io.IOException;

public class GetDataFromExcel {

    @Test
    public void getData() throws IOException {
        String path = "./src/test/java/resources/medal table.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("medal");
//        Sheet sheet1=workbook.getSheetAt(1);
//        System.out.println(sheet.getRow(6).getCell(1));
//        System.out.println(sheet.getRow(7).getCell(1));

        System.out.println(sheet.getRow(9).getCell(1));

        int lastRow=sheet.getLastRowNum();
//
//        for (int i = 0; i < lastRow; i++) {
//            System.out.println(sheet.getRow(i).getCell(1));
//        }

        int lastCell= sheet.getRow(1).getLastCellNum();
        for (int i = 0; i < lastRow; i++) {
            for (int j = 0; j < lastCell; j++) {
                System.out.print(sheet.getRow(i).getCell(j)+" \t |");
            }
            System.out.println();
        }
        fileInputStream.close();
        workbook.close();
    }
}
