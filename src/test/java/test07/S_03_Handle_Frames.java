package test07;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S_03_Handle_Frames {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/webtest/frames/");

		// Frame 1
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_1.html']")));
		driver.findElement(By.xpath("//div[@align='center' and text()='Frame1']/input")).sendKeys("Frame 1");
		driver.switchTo().defaultContent();

		// Frame 2
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_2.html']")));
		driver.findElement(By.xpath("//div[@align='center' and text()='Frame2']/input")).sendKeys("Frame 2");
		driver.switchTo().defaultContent();

		// Frame 3
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_3.html']")));
		driver.findElement(By.xpath("//div[@align='center' and text()='Frame3']/input")).sendKeys("Frame 3");
		driver.switchTo().defaultContent();

		// Frame 4
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_4.html']")));
		driver.findElement(By.xpath("//div[@align='center' and text()='Frame4']/input")).sendKeys("Frame 4");
		driver.switchTo().defaultContent();

		// Frame 5
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_5.html']")));
		driver.findElement(By.xpath("//div[@align='center' and text()='Frame5']/input")).sendKeys("Frame 5");
		driver.switchTo().defaultContent();

		driver.quit();
	}

}
