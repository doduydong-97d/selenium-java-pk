package test13;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class S_02_Add_Data_To_Excel {

	public static void main(String[] args) throws IOException {
		// File - Workbook - Sheets - Rows - Cells

		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + File.separator + "testData" + File.separator + "addDataSJPK.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("Sheet1");

		Scanner scanner = new Scanner(System.in);

		for (int r = 0; r <= 1; r++) {
			XSSFRow row = sheet.createRow(r);
			for (int c = 0; c < 2; c++) {
				String value = scanner.next();
				row.createCell(c).setCellValue(value);
			}
		}

		scanner.close();

		workbook.write(file);
		workbook.close();
		file.close();

		System.out.println("Done!");
	}

}
