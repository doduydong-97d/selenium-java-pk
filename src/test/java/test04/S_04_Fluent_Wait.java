package test04;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class S_04_Fluent_Wait {
	static WebDriver driver = new FirefoxDriver();
	static FluentWait<WebDriver> fluentWait;

	public static void main(String[] args) {
		driver.manage().window().maximize();
		driver.get("https://demo.seleniumeasy.com/dynamic-data-loading-demo.html");

		getWebElement("//button[text()='Get New User']").click();

		System.out.println(getWebElement("//img[contains(@src,'randomuser')]/parent::div[@id='loading']").getText());

		driver.quit();
	}

	static WebElement getWebElement(String xpathLocator) {
		fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
		return fluentWait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(xpathLocator));
			}
		});
	}

}
