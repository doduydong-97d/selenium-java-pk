package test13;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class S_01_Reading_Excel {

	public static void main(String[] args) throws IOException {
		// File - Workbook - Sheets - Rows - Cells

		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + File.separator + "testData" + File.separator + "getDataSJPK.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int maxRowIndex = sheet.getLastRowNum(); // Gets the last row on the sheet - Count from 0
		int maxCellIndex = sheet.getRow(1).getLastCellNum() - 1; // Gets the index of the last cell contained in this row PLUS ONE

		System.out.println("Number of rows: " + (maxRowIndex + 1));
		System.out.println("Number of cells: " + maxCellIndex + 1);

		for (int r = 0; r <= maxRowIndex; r++) {
			XSSFRow currentRow = sheet.getRow(r);
			for (int c = 0; c <= maxCellIndex; c++) {
				String value = currentRow.getCell(c).toString();
				System.out.print(value + "| ");
			}
			System.out.println();
		}

		workbook.close();
		file.close();
	}

}
