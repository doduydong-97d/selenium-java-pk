package test05;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S_01_TextBox_TextArea {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Dong");

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("dongpk@gmail.com");

		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("0123456789");

		driver.findElement(By.xpath("//label[text()='Address:']/following-sibling::textarea")).sendKeys("Da Nang\nViet Nam");

		driver.quit();
	}

}
