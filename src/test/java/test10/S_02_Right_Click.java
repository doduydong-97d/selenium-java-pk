package test10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class S_02_Right_Click {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

		Actions action = new Actions(driver);

		action.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();

		action.click(driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit')]"))).perform();

		driver.switchTo().alert().accept();

		driver.quit();
	}

}
