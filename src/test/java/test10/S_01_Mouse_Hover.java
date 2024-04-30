package test10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class S_01_Mouse_Hover {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/");

		Actions action = new Actions(driver);

		WebElement desktops = driver.findElement(By.xpath("//a[text()='Desktops']"));

		WebElement mac = driver.findElement(By.xpath("//a[text()='Desktops']/parent::li//a[contains(text(),'Mac')]"));

		action.moveToElement(desktops).moveToElement(mac).click().perform();

		driver.quit();
	}

}
