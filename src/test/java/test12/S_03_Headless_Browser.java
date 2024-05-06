package test12;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class S_03_Headless_Browser {

	public static void main(String[] args) {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless");
		WebDriver driver = new FirefoxDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

		String firstName = "Dong";
		String lastName = "Do";
		String emailAddress = "dongafc" + getRandomNumber() + "@gmail.com";
		String password = "Selenium3@";

		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(firstName);

		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(lastName);

		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);

		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);

		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(password);

		driver.findElement(By.xpath("//button[@id='register-button']")).click();

		if (driver.findElement(By.xpath("//div[@class='result']")).getText().equals("Your registration completed")) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}

		driver.findElement(By.xpath("//a[contains(@class,'register-continue-button')]")).click();

		driver.quit();
	}

	static int getRandomNumber() {
		return new Random().nextInt(99999);
	}

}
