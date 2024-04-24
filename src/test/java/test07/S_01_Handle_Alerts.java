package test07;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class S_01_Handle_Alerts {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");

		// JS Alert
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Alert jsAlert = explicitWait.until(ExpectedConditions.alertIsPresent());
		System.out.println(jsAlert.getText());
		jsAlert.accept();
		System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());

		// JS Confirm
		WebElement jsConfirmBtn = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));

		jsConfirmBtn.click();
		Alert jsConfirm = explicitWait.until(ExpectedConditions.alertIsPresent());
		System.out.println(jsConfirm.getText());
		jsConfirm.dismiss();
		System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());

		jsConfirmBtn.click();
		jsConfirm = explicitWait.until(ExpectedConditions.alertIsPresent());
		System.out.println(jsConfirm.getText());
		jsConfirm.accept();
		System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());

		// JS Prompt
		WebElement jsPromptBtn = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));

		jsPromptBtn.click();
		Alert jsPrompt = explicitWait.until(ExpectedConditions.alertIsPresent());
		System.out.println(jsPrompt.getText());
		jsPrompt.dismiss();
		System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());

		jsPromptBtn.click();
		jsPrompt = explicitWait.until(ExpectedConditions.alertIsPresent());
		System.out.println(jsPrompt.getText());
		jsPrompt.sendKeys("Selenium Java");
		jsPrompt.accept();
		System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());

		driver.quit();
	}

}
