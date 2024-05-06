package test12;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S_02_Screenshot {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

		String projectPath = System.getProperty("user.dir");

		TakesScreenshot tSc = (TakesScreenshot) driver;
		File scrFileSc = tSc.getScreenshotAs(OutputType.FILE);
		File destFileSc = new File(projectPath + File.separator + "screenshot" + File.separator + "fullPageSc.png");
		FileUtils.copyFile(scrFileSc, destFileSc);

		WebElement featureProducts = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File srcProdFileSc = featureProducts.getScreenshotAs(OutputType.FILE);
		File destProdFileSc = new File(projectPath + File.separator + "screenshot" + File.separator + "productsSc.png");
		FileUtils.copyFile(srcProdFileSc, destProdFileSc);
	}

}
