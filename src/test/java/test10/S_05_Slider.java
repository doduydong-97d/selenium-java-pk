package test10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class S_05_Slider {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");

		Actions action = new Actions(driver);

		WebElement minSlider = driver.findElement(By.xpath("//span[1]"));
		WebElement maxSlider = driver.findElement(By.xpath("//span[2]"));

		Point minLocation = minSlider.getLocation();
		Point maxLocation = maxSlider.getLocation();

		System.out.println("Min slider before moving: " + minLocation);
		System.out.println("Max Slider before moving: " + maxLocation);

		action.dragAndDropBy(minSlider, minLocation.getX() + 50, minLocation.getY()).perform();
		action.dragAndDropBy(maxSlider, maxLocation.getX() - (maxLocation.getX() + 50), maxLocation.getY()).perform();

		minLocation = minSlider.getLocation();
		maxLocation = maxSlider.getLocation();

		System.out.println("Min slider after moving: " + minLocation);
		System.out.println("Max Slider after moving: " + maxLocation);

		driver.quit();
	}

}
