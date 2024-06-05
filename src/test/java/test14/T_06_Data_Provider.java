package test14;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class T_06_Data_Provider {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "UserData")
	public void Test(String emailAddress, String password) {
		driver.get("https://demo.nopcommerce.com/");

		driver.findElement(By.xpath("//a[@class='ico-login']")).click();

		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);

		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);

		driver.findElement(By.xpath("//button[contains(@class,'login-button')]")).click();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@DataProvider(name = "UserData")
	public Object[][] Data() {
		return new Object[][] {
				// #1
				{ "dongauto@gmail.com", "Se3Java11" },
				// #2
				{ "dongtester@gmail.com", "Qae2024" },
				// #3
				{ "dongsdet@gmail.com", "Sdet2024" } };
	}

}
