package test05;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S_02_RadioButton_CheckBox {
	static WebDriver driver = new FirefoxDriver();

	public static void main(String[] args) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

		// Radio Button
		checkCheckboxOrRadioButton("//input[@id='male' and @type='radio']");

		// CheckBox
		checkCheckboxOrRadioButton("//label[text()='Days:']/parent::div//input[@id='saturday']");

		uncheckCheckbox("//label[text()='Days:']/parent::div//input[@id='saturday']");

		driver.quit();
	}

	static void checkCheckboxOrRadioButton(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}
	}

	static void uncheckCheckbox(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}
	}

}
