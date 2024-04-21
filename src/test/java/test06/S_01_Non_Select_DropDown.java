package test06;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S_01_Non_Select_DropDown {
	static WebDriver driver = new FirefoxDriver();

	public static void main(String[] args) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

		selectOptionInDropdown("//span[@id='speed-button']", "//ul[@id='speed-menu']//div", "Fast");

		selectOptionInDropdown("//span[@id='files-button']", "//ul[@id='files-menu']//div", "ui.jQuery.js");

		selectOptionInDropdown("//span[@id='number-button']", "//ul[@id='number-menu']//div", "13");

		selectOptionInDropdown("//span[@id='salutation-button']", "//ul[@id='salutation-menu']//div", "Prof.");

		driver.quit();
	}

	static void selectOptionInDropdown(String dropdownXPath, String allOptionsXPath, String expectedOptionText) throws InterruptedException {
		driver.findElement(By.xpath(dropdownXPath)).click();
		Thread.sleep(1000);
		List<WebElement> speedOptions = driver.findElements(By.xpath(allOptionsXPath));
		for (WebElement speed : speedOptions) {
			if (speed.getText().equals(expectedOptionText)) {
				speed.click();
				Thread.sleep(1000);
				break;
			}
		}
	}

}
