package test12;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S_01_Broken_Link {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");

		List<WebElement> links = driver.findElements(By.xpath("//a"));

		int brokenLink = 0;

		for (WebElement link : links) {
			String url = link.getAttribute("href");

			if (url == null || url.isEmpty()) {
				continue;
			}

			URL linkUrl = new URL(url);

			HttpURLConnection linkConnect = (HttpURLConnection) linkUrl.openConnection();

			linkConnect.connect();

			if (linkConnect.getResponseCode() >= 400) {
				System.out.println("Broken link - " + url);
				brokenLink++;
			} else {
				System.out.println("Not broken link - " + url);
			}
		}

		System.out.println(brokenLink);

		// driver.quit();
	}

}
