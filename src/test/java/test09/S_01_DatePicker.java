package test09;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S_01_DatePicker {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demos.telerik.com/kendo-ui/datepicker/index");

		String month = "October";
		String date = "13";
		String year = "1997";

		driver.findElement(By.xpath("//span[contains(@class,'calendar')]")).click();

		while (true) {
			String[] textMonthYear = driver.findElement(By.xpath("//a[@title='Navigate to year view']")).getText().split(" ");
			if (month.equals(textMonthYear[0]) && year.equals(textMonthYear[1])) {
				break;
			}

			driver.findElement(By.xpath("//a[@title='Navigate to year view']")).click();

			if (Integer.parseInt(driver.findElement(By.xpath("//a[@title='Navigate to decade view']")).getText()) > Integer.parseInt(year)) {
				while (Integer.parseInt(driver.findElement(By.xpath("//a[@title='Navigate to decade view']")).getText()) != Integer.parseInt(year)) {
					driver.findElement(By.xpath("//span[contains(@class,'left k-button-icon')]")).click();
				}
				driver.findElement(By.xpath("//a[@aria-label='October']")).click();
			} else {
				while (Integer.parseInt(driver.findElement(By.xpath("//a[@title='Navigate to decade view']")).getText()) != Integer.parseInt(year)) {
					driver.findElement(By.xpath("//span[contains(@class,'right k-button-icon')]")).click();
				}
				driver.findElement(By.xpath("//a[@aria-label='" + month + "']")).click();
			}
		}

		List<WebElement> allDates = driver.findElements(By.xpath("//a[@class='k-link ']"));
		for (WebElement eachDate : allDates) {
			if (eachDate.getText().equals(date)) {
				eachDate.click();
				break;
			}
		}

		String selectedDate = driver.findElement(By.xpath("//input[@id='datepicker']")).getAttribute("value");
		System.out.println("Month-Day-Year: " + selectedDate);

		driver.quit();
	}

}
