package Excel_config;

/*
 *  All the Excel_config manipulating excel files and do excel operations will be handling through this class.
 */

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;
import Logs_config.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {

    public static final String testDataExcelFileName = "testdata.xlsx";

    //Main Directory of the project
    private static final String currentDir = System.getProperty("user.dir");

    //Location of Test data excel file
    private static String testDataExcelPath = null;

    //Excel_config WorkBook
    private static XSSFWorkbook excelWBook;

    //Excel_config Sheet
    private static XSSFSheet excelWSheet;

    //Excel_config cell
    private static XSSFCell cell;

    //Excel_config row
    private static XSSFRow row;

    //Row Number
    private static int rowNumber;

    //Column Number
    private static int columnNumber;

    //Setter and Getters of row and columns
    public static void setRowNumber(int pRowNumber) {
        rowNumber = pRowNumber;
    }

    public static int getRowNumber() {
        return rowNumber;
    }

    public static void setColumnNumber(int pColumnNumber) {
        columnNumber = pColumnNumber;
    }

    public static int getColumnNumber() {
        return columnNumber;
    }

    /*This method has two parameters: "Test data excel file name" and "Excel_config sheet name"
    It creates FileInputStream and set excel file and excel sheet to excelWBook and excelWSheet variables.
    */
    public static void setExcelFileSheet(String sheetName) throws Exception {

        //MAC or Windows Selection for excel path
        if (Platform.getCurrent().toString().equalsIgnoreCase("MAC")) {
            testDataExcelPath = currentDir + "//src//main//resources//";
        } else if (Platform.getCurrent().toString().contains("WIN")) {
            testDataExcelPath = currentDir + "AutoTest\\src\\main\\resources\\";
        }
        try {
            // Open the Excel_config file
            FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + testDataExcelFileName);
            excelWBook = new XSSFWorkbook(ExcelFile);
            excelWSheet = excelWBook.getSheet(sheetName);
        } catch (Exception e) {
            try {
                throw (e);
            } catch (IOException e1) {
                e1.printStackTrace();
                Log.error("File not be able located: " + e );
            }
        }
    }

    /*This method reads the test data from the Excel_config cell.
    We are passing row number and column number as parameters.
    */
    public static String getCellData(int RowNum, int ColNum) {
        try {
            cell = excelWSheet.getRow(RowNum).getCell(ColNum);
            DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
        } catch (Exception e) {
            Log.error("Unable to read data from the Excel_config cell: " + e);
            throw new RuntimeException(e);
        }
    }

    //This method takes row number as a parameter and returns the data of given row number.
    public static XSSFRow getRowData(int RowNum) {
        try {
            row = excelWSheet.getRow(RowNum);
            return row;
        } catch (Exception e) {
            Log.error("Unable to return data for the given row number: " + e);
            throw new RuntimeException(e);
        }
    }

    //This method gets excel file, row and column number and set a value to the that cell.
    public static void setCellData(String value, int RowNum, int ColNum) throws Exception{
        try {
            row = excelWSheet.getRow(RowNum);
            cell = row.getCell(ColNum);
            if (cell == null) {
                cell = row.createCell(ColNum);
                cell.setCellValue(value);
            } else {
                cell.setCellValue(value);
            }
            // Constant variables Test Data path and Test Data file name
            FileOutputStream fileOut = new FileOutputStream(testDataExcelPath + testDataExcelFileName);
            excelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            try {
                throw (e);
            } catch (IOException e1) {
                Log.error("Unable to return values: " + e);
                e1.printStackTrace();
            }
        }
    }
}
