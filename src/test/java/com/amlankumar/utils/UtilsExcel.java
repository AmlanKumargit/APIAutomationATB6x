package com.amlankumar.utils;
//Open the FileInputStream
//Understand the Workbook
//Sheet
//Row
//Column
//Shell
//Close the Stream

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class UtilsExcel {

    //This class would be used by the DataProvider of TestNg
   public static String FILE_NAME = "src/test/resources/DDT.xlsx";
   static Workbook book;
   static Sheet sheet;

public static Object[][] getTestData(String sheetName){
    FileInputStream file = null;

    try {
        file= new FileInputStream(FILE_NAME);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

    try {
        book = WorkbookFactory.create(file);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    sheet=book.getSheet(sheetName);
    Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
    for (int i = 0; i < sheet.getLastRowNum(); i++) {
        for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
            data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
        }
    }
    return data;//i+1 as we're ignoring the first row of data
}

@DataProvider
public Object[][] getData(){

    return getTestData("Sheet2");
    //In future could navigate between different sheets for test data
    //Change sheetnames for PROD, QA env test data etc.
}



}
