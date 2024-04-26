package test08;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S_01_Static_Table {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

		int noOfDataRows = driver.findElements(By.xpath("//table[@name='BookTable']//th/parent::tr/following-sibling::tr")).size();
		System.out.println("Number of data rows: " + noOfDataRows);

		int noOfColumns = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("Number of columns: " + noOfColumns);

		for (int r = 1; r <= noOfDataRows; r++) {
			System.out.print("Row " + r + ":");
			for (int c = 1; c <= noOfColumns; c++) {
				System.out.print(" - " + driver.findElement(By.xpath("//table[@name='BookTable']//th/parent::tr/following-sibling::tr[" + r + "]/td[" + c + "]")).getText());
			}
			System.out.println();
		}

		for (int r = 1; r <= noOfDataRows; r++) {
			String author = driver.findElement(By.xpath("//table[@name='BookTable']//th/parent::tr/following-sibling::tr[" + r + "]/td[2]")).getText();
			if (author.equals("Mukesh")) {
				System.out.println("The book of Mukesh: " + driver.findElement(By.xpath("//table[@name='BookTable']//th/parent::tr/following-sibling::tr[" + r + "]/td[1]")).getText());
			}
		}

		int sum = 0;
		for (int r = 1; r <= noOfDataRows; r++) {
			String price = driver.findElement(By.xpath("//table[@name='BookTable']//th/parent::tr/following-sibling::tr[" + r + "]/td[4]")).getText();
			sum += Integer.parseInt(price);
		}
		System.out.println("Sum of prices for all the books: " + sum);

		driver.quit();
	}

}
