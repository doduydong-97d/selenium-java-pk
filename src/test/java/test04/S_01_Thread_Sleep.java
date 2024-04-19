package test04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S_01_Thread_Sleep {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.seleniumeasy.com/dynamic-data-loading-demo.html");

		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[text()='Get New User']")).click();

		Thread.sleep(5000);

		System.out.println(driver.findElement(By.xpath("//div[@id='loading']")).getText());

		driver.quit();
	}

}
