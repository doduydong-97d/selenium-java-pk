package test06;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S_02_Autocomplete_DropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");

		driver.findElement(By.xpath("//textarea[@role='combobox']")).sendKeys("Selenium Java");

		Thread.sleep(1000);

		List<WebElement> searchSuggestions = driver.findElements(By.xpath("//div[@class='sbic sb43']/parent::div//div[@class='wM6W7d']/span"));

		for (WebElement suggest : searchSuggestions) {
			if (suggest.getText().equalsIgnoreCase("selenium java tutorial")) {
				suggest.click();
				Thread.sleep(1000);
				break;
			}
		}

		driver.quit();
	}

}
