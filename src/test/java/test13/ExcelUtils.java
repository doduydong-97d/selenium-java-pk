package test13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream fileInput;
	public static FileOutputStream fileOutput;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	public static int maxRowIndex;
	public static int maxCellIndex;
	public static String data;

	public static int getMaxRowIndex(String excelFile, String sheetName) {
		try {
			fileInput = new FileInputStream(excelFile);
			workbook = new XSSFWorkbook(fileInput);
			sheet = workbook.getSheet(sheetName);
			maxRowIndex = sheet.getLastRowNum();
			workbook.close();
			fileInput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return maxRowIndex;
	}

	public static int getMaxCellIndex(String excelFile, String sheetName, int rowIndex) {
		try {
			fileInput = new FileInputStream(excelFile);
			workbook = new XSSFWorkbook(fileInput);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowIndex);
			maxCellIndex = row.getLastCellNum();
			workbook.close();
			fileInput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return maxCellIndex - 1;
	}

	public static String getCellData(String excelFile, String sheetName, int rowIndex, int cellIndex) {
		try {
			fileInput = new FileInputStream(excelFile);
			workbook = new XSSFWorkbook(fileInput);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowIndex);
			cell = row.getCell(cellIndex);
			try {
				data = new DataFormatter().formatCellValue(cell);
				return data;
			} catch (Exception e) {
				data = "";
			}
			workbook.close();
			fileInput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}

	public static void setCellData(String excelFile, String sheetName, int rowIndex, int cellIndex, String data) {
		try {
			fileInput = new FileInputStream(excelFile);
			workbook = new XSSFWorkbook(fileInput);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowIndex);
			cell = row.createCell(cellIndex);
			cell.setCellValue(data);
			fileOutput = new FileOutputStream(excelFile);
			workbook.write(fileOutput);
			workbook.close();
			fileInput.close();
			fileOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void fillGreenColor(String excelFile, String sheetName, int rowIndex, int cellIndex) {
		try {
			fileInput = new FileInputStream(excelFile);
			workbook = new XSSFWorkbook(fileInput);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowIndex);
			cell = row.getCell(cellIndex);

			style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

			cell.setCellStyle(style);
			fileOutput = new FileOutputStream(excelFile);
			workbook.write(fileOutput);
			workbook.close();
			fileInput.close();
			fileOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void fillRedColor(String excelFile, String sheetName, int rowIndex, int cellIndex) {
		try {
			fileInput = new FileInputStream(excelFile);
			workbook = new XSSFWorkbook(fileInput);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowIndex);
			cell = row.getCell(cellIndex);

			style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

			cell.setCellStyle(style);
			fileOutput = new FileOutputStream(excelFile);
			workbook.write(fileOutput);
			workbook.close();
			fileInput.close();
			fileOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
