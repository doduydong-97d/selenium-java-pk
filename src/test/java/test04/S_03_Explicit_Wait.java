package test04;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class S_03_Explicit_Wait {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.seleniumeasy.com/dynamic-data-loading-demo.html");

		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Get New User']"))).click();

		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loading' and contains(text(),' loading...')]")));

		System.out.println(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='loading']"))).getText());

		driver.quit();
	}

}
