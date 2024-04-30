package test10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class S_06_Keyboard_Actions {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://text-compare.com/");

		Actions action = new Actions(driver);

		WebElement field1 = driver.findElement(By.xpath("//textarea[@id='inputText1']"));

		field1.sendKeys("Selenium Java");

		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

		action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();

		action.sendKeys(Keys.TAB).perform();

		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

		driver.findElement(By.xpath("//button[@id='compareButton']")).click();

		String result = driver.findElement(By.xpath("//span[@class='messageForUser' and text()='The two texts are identical!']")).getText();

		if (result.equals("The two texts are identical!")) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}

		driver.quit();
	}

}
