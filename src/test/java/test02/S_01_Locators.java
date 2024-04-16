package test02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S_01_Locators {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/");

		driver.findElement(By.id("logo"));

		driver.findElement(By.className("navbar-nav"));

		driver.findElement(By.name("search"));

		driver.findElements(By.tagName("input"));

		driver.findElement(By.linkText("Laptops & Notebooks"));

		driver.findElement(By.partialLinkText("Laptops"));

		driver.quit();
	}

}
