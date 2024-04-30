package test10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class S_04_Drag_And_Drop {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

		Actions action = new Actions(driver);

		// Capitals
		WebElement srcOslo = driver.findElement(By.xpath("//div[contains(@id,'box') and text()='Oslo']"));
		WebElement srcStockholm = driver.findElement(By.xpath("//div[contains(@id,'box') and text()='Stockholm']"));
		WebElement srcWashington = driver.findElement(By.xpath("//div[contains(@id,'box') and text()='Washington']"));
		WebElement srcCopenhagen = driver.findElement(By.xpath("//div[contains(@id,'box') and text()='Copenhagen']"));
		WebElement srcSeoul = driver.findElement(By.xpath("//div[contains(@id,'box') and text()='Seoul']"));
		WebElement srcRome = driver.findElement(By.xpath("//div[contains(@id,'box') and text()='Rome']"));
		WebElement srcMadrid = driver.findElement(By.xpath("//div[contains(@id,'box') and text()='Madrid']"));

		// Countries
		WebElement tgtItaly = driver.findElement(By.xpath("//div[text()='Italy']"));
		WebElement tgtSpain = driver.findElement(By.xpath("//div[text()='Spain']"));
		WebElement tgtNorway = driver.findElement(By.xpath("//div[text()='Norway']"));
		WebElement tgtDenmark = driver.findElement(By.xpath("//div[text()='Denmark']"));
		WebElement tgtSouthKorea = driver.findElement(By.xpath("//div[text()='South Korea']"));
		WebElement tgtSweden = driver.findElement(By.xpath("//div[text()='Sweden']"));
		WebElement tgtUnitedStates = driver.findElement(By.xpath("//div[text()='United States']"));

		action.dragAndDrop(srcOslo, tgtNorway).perform();
		action.dragAndDrop(srcStockholm, tgtSweden).perform();
		action.dragAndDrop(srcWashington, tgtUnitedStates).perform();
		action.dragAndDrop(srcCopenhagen, tgtDenmark).perform();
		action.dragAndDrop(srcSeoul, tgtSouthKorea).perform();
		action.dragAndDrop(srcRome, tgtItaly).perform();
		action.dragAndDrop(srcMadrid, tgtSpain).perform();

		driver.quit();
	}

}
