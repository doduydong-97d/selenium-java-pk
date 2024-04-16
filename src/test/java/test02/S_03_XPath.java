package test02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S_03_XPath {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/");

		driver.findElement(By.xpath("//div[@id='logo']"));

		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']"));

		driver.findElement(By.xpath("//input[@name='search']"));

		driver.findElements(By.xpath("//input"));

		driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));

		driver.findElement(By.xpath("//li/a[contains(text(),'Notebooks')]"));

		driver.findElement(By.xpath("//li/a[starts-with(text(),'Laptops')]"));

		driver.findElement(By.xpath("//input[@type='text' and @name='search']"));

		driver.findElement(By.xpath("//a[text()='MacBook' or text()='iPhone']"));

		driver.findElement(By.xpath("//img[@title='MacBook']/ancestor::div[@class='image']/following-sibling::div[@class='content']/parent::div"));

		driver.quit();
	}

}
