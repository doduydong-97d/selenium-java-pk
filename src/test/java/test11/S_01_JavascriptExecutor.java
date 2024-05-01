package test11;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S_01_JavascriptExecutor {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		// SendKeys
		WebElement searchTextbox = driver.findElement(By.xpath("//input[@class='wikipedia-search-input']"));
		jsExecutor.executeScript("arguments[0].value='Selenium';", searchTextbox);

		// Click
		WebElement searchButton = driver.findElement(By.xpath("//input[@class='wikipedia-search-button']"));
		jsExecutor.executeScript("arguments[0].click();", searchButton);

		// Scroll
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight);");

		jsExecutor.executeScript("window.scrollBy(0,-document.body.scrollHeight);");

		WebElement searchSearch = driver.findElement(By.xpath("//div[text()='Search results']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView();", searchSearch);

		// Get text
		List<WebElement> results = driver.findElements(By.xpath("//div[@class='wikipedia-search-results']//a"));
		for (WebElement result : results) {
			System.out.println(jsExecutor.executeScript("return arguments[0].innerText;", result));
		}

		driver.quit();
	}

}
