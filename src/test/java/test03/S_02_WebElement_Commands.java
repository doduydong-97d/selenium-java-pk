package test03;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S_02_WebElement_Commands {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();

		WebElement element = driver.findElement(By.xpath(""));
		List<WebElement> elements = driver.findElements(By.xpath(""));

		element.click();

		element.clear();
		element.sendKeys("");

		element.getAttribute("attributeName");
		element.getCssValue("propertyName");
		element.getTagName();
		element.getText();

		element.getLocation();
		element.getSize();
		element.getRect();

		element.getScreenshotAs(OutputType.BASE64);
		element.getScreenshotAs(OutputType.BYTES);
		element.getScreenshotAs(OutputType.FILE);

		element.isDisplayed();
		element.isEnabled();
		element.isSelected();

		element.submit();

		elements.size();
	}

}
