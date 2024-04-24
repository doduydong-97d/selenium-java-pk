package test07;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S_02_Authentication_Alert {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");

		String basicAuthUrl = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");

		String userBasicAuthUrl = getUserBasicAuthUrl(basicAuthUrl, "admin", "admin");

		System.out.println("User Basic Auth Url: " + userBasicAuthUrl);

		driver.get(userBasicAuthUrl);

		System.out.println(driver.findElement(By.xpath("//h3[text()='Basic Auth']/following-sibling::p")).getText());

		driver.quit();
	}

	static String getUserBasicAuthUrl(String basicAuthUrl, String userName, String password) {
		String[] urls = basicAuthUrl.split("//");
		return basicAuthUrl = urls[0] + "//" + userName + ":" + password + "@" + urls[1];
	}

}
