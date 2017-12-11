package com.hmtmcse.advanced.converter;

import java.io.*;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class ExcelToCSV {

    static void convertToXlsx(File inputFile, File outputFile) {
        StringBuffer cellValue = new StringBuffer();
        try {
            FileOutputStream fos = new FileOutputStream(outputFile);
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(inputFile));
            XSSFSheet sheet = wb.getSheetAt(0);

            Row row;
            Cell cell;
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    cell = cellIterator.next();
                    String value = "";
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            Integer number =  (int) cell.getNumericCellValue();
                            value = number.toString();
                            break;
                        default:
                            value = cell.toString();
                    }
                    if (cellIterator.hasNext()){
                        value += ",";
                    }else{
                        value += "\n";
                    }
                    cellValue.append(value);
                }
            }
            fos.write(cellValue.toString().getBytes());
            fos.close();
        } catch (Exception e) {
            System.err.println("Exception :" + e.getMessage());
        }
    }

    static void convertToXls(File inputFile, File outputFile) {
// For storing data into CSV files
        StringBuffer cellDData = new StringBuffer();
        try {
            FileOutputStream fos = new FileOutputStream(outputFile);

            // Get the workbook instance for XLS file
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(inputFile));
            // Get first sheet from the workbook
            HSSFSheet sheet = workbook.getSheetAt(0);
            Cell cell;
            Row row;

            // Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                row = rowIterator.next();

                // For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    cell = cellIterator.next();

                    switch (cell.getCellType()) {

                        case Cell.CELL_TYPE_BOOLEAN:
                            cellDData.append(cell.getBooleanCellValue() + ",");
                            break;

                        case Cell.CELL_TYPE_NUMERIC:
                            cellDData.append(cell.getNumericCellValue() + ",");
                            break;

                        case Cell.CELL_TYPE_STRING:
                            cellDData.append(cell.getStringCellValue() + ",");
                            break;

                        case Cell.CELL_TYPE_BLANK:
                            cellDData.append("" + ",");
                            break;

                        default:
                            cellDData.append(cell + ",");

                    }
                }
            }

            fos.write(cellDData.toString().getBytes());
            fos.close();

        } catch (FileNotFoundException e) {
            System.err.println("Exception" + e.getMessage());
        } catch (IOException e) {
            System.err.println("Exception" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        File inputFile2 = new File("W:\\cloud\\Google\\English Learning\\E2B Words\\ADJECTIVE.xlsx");
        File outputFile2 = new File("C:\\Users\\Touhid Mia\\Desktop\\vm\\output2.csv");
        convertToXlsx(inputFile2, outputFile2);
    }
}