package test08;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S_02_Pagination_Table {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

		int noOfDataRows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
		System.out.println("Number of data rows: " + noOfDataRows);

		int noOfColumns = driver.findElements(By.xpath("//table[@id='productTable']//th")).size();
		System.out.println("Number of columns: " + noOfColumns);

		int noOfPaginationLink = driver.findElements(By.xpath("//ul[@id='pagination']/li/a")).size();
		System.out.println("Number of pagination links: " + noOfColumns);

		for (int p = 1; p <= noOfPaginationLink; p++) {
			driver.findElement(By.xpath("//ul[@id='pagination']/li/a[text()='" + p + "']")).click();
			System.out.println("Page " + p + ":");
			for (int r = 1; r <= noOfDataRows; r++) {
				for (int c = 1; c < noOfColumns; c++) {
					System.out.print(driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + r + "]/td[" + c + "]")).getText() + " ");
				}
				System.out.println();
			}
		}

		driver.quit();
	}

}
