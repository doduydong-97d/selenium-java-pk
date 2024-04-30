package test10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class S_03_Double_Click {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

		Actions action = new Actions(driver);

		String field1Value = driver.findElement(By.xpath("//input[@id='field1']")).getAttribute("value");

		action.doubleClick(driver.findElement(By.xpath("//button[text()='Copy Text']"))).perform();

		String field2Value = driver.findElement(By.xpath("//input[@id='field2']")).getAttribute("value");

		if (field1Value.equals(field2Value)) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}

		driver.quit();
	}

}
