package test07;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class S_04_Handle_Windows {
	static WebDriver driver = new FirefoxDriver();

	public static void main(String[] args) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/%22");

		String homePageID = driver.getWindowHandle();
		String homePageTitle = driver.getTitle();

		driver.findElement(By.xpath("//input[@class='wikipedia-search-input']")).sendKeys("Selenium");

		driver.findElement(By.xpath("//input[@class='wikipedia-search-button']")).click();

		explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[@id='wikipedia-search-result-link']/a"))));

		driver.findElement(By.xpath("//div[@id='wikipedia-search-result-link']/a[text()='Selenium']")).click();

		switchToWindowDifferentFromCurrentByID(driver, homePageID);

		switchToWindowByExpectedTitle(driver, homePageTitle);

		driver.findElement(By.xpath("//div[@id='wikipedia-search-result-link']/a[text()='Selenium (software)']")).click();

		closeAllWindowsExceptWindowByID(driver, homePageID);

		driver.quit();
	}

	static void switchToWindowDifferentFromCurrentByID(WebDriver driver, String currentID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(currentID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	static void switchToWindowByExpectedTitle(WebDriver driver, String expectedTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			String actualTitle = driver.switchTo().window(id).getTitle();
			if (actualTitle.equals(expectedTitle)) {
				break;
			}
		}
	}

	static void closeAllWindowsExceptWindowByID(WebDriver driver, String windowID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(windowID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(windowID);
	}

}
