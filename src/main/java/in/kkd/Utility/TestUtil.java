package in.kkd.Utility;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {


    public String getCellData(String filePath,String fileName,String sheetName,int rowNum,int colNum) throws IOException{

        File file =    new File(filePath+"\\"+fileName);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook guru99Workbook = null;
        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        if(fileExtensionName.equals(".xlsx")){
            guru99Workbook = new XSSFWorkbook(inputStream);

        }
        else if(fileExtensionName.equals(".xls")){
            guru99Workbook = new HSSFWorkbook(inputStream);
        }

        Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);
        int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
        Row row = guru99Sheet.getRow(rowNum);
        String cellVal = row.getCell(colNum).toString();
        return cellVal;
    }
    public static ArrayList<Object[]> getDataFromExcell() throws IOException{
        ArrayList<Object[]> myData = new ArrayList<Object[]>();

        TestUtil objExcelFile = new TestUtil();
        String filePath = "C:\\Users\\kaushal.kanjariya\\Documents\\shopizer-postman";
        String fileName = "test-data.xls";
//        objExcelFile.readExcel(filePath,"test-data.xls","Sheet1");

        File file = new File(filePath+"\\"+fileName);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook guru99Workbook = null;
        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        if(fileExtensionName.equals(".xlsx")){
            guru99Workbook = new XSSFWorkbook(inputStream);

        }
        else if(fileExtensionName.equals(".xls")){
            guru99Workbook = new HSSFWorkbook(inputStream);
        }

        Sheet guru99Sheet = guru99Workbook.getSheet("Sheet1");
        int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
        Row row;
        for (int i = 1;i<=rowCount;i++){
            String firstname = objExcelFile.getCellData(filePath,"test-data.xls","Sheet1",i,0);
            String password = objExcelFile.getCellData(filePath,"test-data.xls","Sheet1",i,1);

            Object ob[] = {firstname,password};
            myData.add(ob);
        }

        return myData;

    }

}