package test01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S_01_Check_Environment {

	public static void main(String[] args) {
		WebDriver driver;

		driver = new FirefoxDriver();

		driver.get("https://demo.opencart.com/");

		System.out.println(driver.getCurrentUrl());

		driver.quit();
	}

}
