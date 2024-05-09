package test13;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class S_03_DataDrivenTesting {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

		String file = System.getProperty("user.dir") + File.separator + "testData" + File.separator + "dataTesting.xlsx";
		String sheetName = "Sheet1";

		int maxRowIndex = ExcelUtils.getMaxRowIndex(file, sheetName);

		for (int r = 1; r <= maxRowIndex; r++) {
			String principle = ExcelUtils.getCellData(file, sheetName, r, 0);
			String rateOfInterest = ExcelUtils.getCellData(file, sheetName, r, 1);
			String period1 = ExcelUtils.getCellData(file, sheetName, r, 2);
			String period2 = ExcelUtils.getCellData(file, "Sheet1", r, 3);
			String frequency = ExcelUtils.getCellData(file, sheetName, r, 4);
			String expectedMaturityValue = ExcelUtils.getCellData(file, sheetName, r, 5);

			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principle);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateOfInterest);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period1);
			new Select(driver.findElement(By.id("tenurePeriod"))).selectByVisibleText(period2);
			new Select(driver.findElement(By.id("frequency"))).selectByVisibleText(frequency);

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")));

			String actualMaturityValue = driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();

			if (Double.parseDouble(actualMaturityValue) == Double.parseDouble(expectedMaturityValue)) {
				System.out.println("Pass");
				ExcelUtils.setCellData(file, sheetName, r, 7, "Pass");
				ExcelUtils.fillGreenColor(file, sheetName, r, 7);
			} else {
				System.out.println("Faile");
				ExcelUtils.setCellData(file, sheetName, r, 7, "Fail");
				ExcelUtils.fillRedColor(file, sheetName, r, 7);
			}

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@class='cal_div']//a[2]")));
		}

		driver.quit();
	}

}
