package test03;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S_01_Browser_Commands {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();

		driver.get("");
		driver.close();
		driver.quit();

		driver.getCurrentUrl();
		driver.getPageSource();
		driver.getTitle();
		driver.getWindowHandle();
		driver.getWindowHandles();

		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}

		driver.manage().window().maximize();
		driver.manage().window().fullscreen();

		Point position = driver.manage().window().getPosition();
		driver.manage().window().setPosition(position);

		Dimension size = driver.manage().window().getSize();
		driver.manage().window().setSize(size);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

		driver.navigate().to("");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();

		driver.switchTo().alert();
		driver.switchTo().frame("");
		driver.switchTo().window("");
	}

}
