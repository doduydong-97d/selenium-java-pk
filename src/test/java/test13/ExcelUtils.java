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

	public static int getMaxRowIndex(String excelFile, String sheetName) throws IOException {
		fileInput = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(fileInput);
		sheet = workbook.getSheet(sheetName);
		int maxRowIndex = sheet.getLastRowNum();
		workbook.close();
		fileInput.close();
		return maxRowIndex;
	}

	public static int getMaxCellIndex(String excelFile, String sheetName, int rowIndex) throws IOException {
		fileInput = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(fileInput);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowIndex);
		int maxCellIndex = row.getLastCellNum();
		workbook.close();
		fileInput.close();
		return maxCellIndex - 1;
	}

	public static String getCellData(String excelFile, String sheetName, int rowIndex, int cellIndex) throws IOException {
		fileInput = new FileInputStream(excelFile);
		workbook = new XSSFWorkbook(fileInput);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowIndex);
		cell = row.getCell(cellIndex);

		String data;
		try {
			data = new DataFormatter().formatCellValue(cell);
			return data;
		} catch (Exception e) {
			data = "";
		}
		workbook.close();
		fileInput.close();
		return data;
	}

	public static void setCellData(String excelFile, String sheetName, int rowIndex, int cellIndex, String data) throws IOException {
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
	}

	public static void fillGreenColor(String excelFile, String sheetName, int rowIndex, int cellIndex) throws IOException {
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
	}

	public static void fillRedColor(String excelFile, String sheetName, int rowIndex, int cellIndex) throws IOException {
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
	}

}
