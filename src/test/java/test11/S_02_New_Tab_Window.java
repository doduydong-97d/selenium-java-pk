package test11;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S_02_New_Tab_Window {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		driver.switchTo().newWindow(WindowType.TAB).get("https://demo.opencart.com/");

		driver.switchTo().newWindow(WindowType.WINDOW).get("https://opensource-demo.orangehrmlive.com");

		jsExecutor.executeScript("window.open('https://demo.nopcommerce.com/','_blank');");

		jsExecutor.executeScript("window.open('http://live.techpanda.org/','myWindow','width=500,height=500');");

		driver.quit();
	}

}
