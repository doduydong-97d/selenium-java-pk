package test05;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class S_03_Select_DropDown {
	static WebDriver driver = new FirefoxDriver();
	static Select select;

	public static void main(String[] args) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

		selectOptionInDropdown("//select[@id='country']", "Japan");
		if (getSelectedOptionTextInDropdown("//select[@id='country']").equals("Japan")) {
			System.out.println("Country: Japan");
		}

		selectOptionInDropdown("//select[@id='colors']", "Green");
		if (getSelectedOptionTextInDropdown("//select[@id='colors']").equals("Green")) {
			System.out.println("Color: Green");
		}

		driver.quit();
	}

	static void selectOptionInDropdown(String xpathLocator, String optionText) {
		new Select(driver.findElement(By.xpath(xpathLocator))).selectByVisibleText(optionText);
	}

	static String getSelectedOptionTextInDropdown(String xpathLocator) {
		return new Select(driver.findElement(By.xpath(xpathLocator))).getFirstSelectedOption().getText();
	}

}
