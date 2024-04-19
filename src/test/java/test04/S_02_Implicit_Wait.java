package test04;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S_02_Implicit_Wait {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.seleniumeasy.com/dynamic-data-loading-demo.html");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//button[text()='Get New User']")).click();

		System.out.println(driver.findElement(By.xpath("//img[contains(@src,'randomuser')]/parent::div[@id='loading']")).getText());

		driver.quit();
	}

}
