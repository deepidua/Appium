/**
 * 
 * Basic selenium set up
 */
package one;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {

	WebDriver driver;

	@Test
	public void f() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("lst-ib")).sendKeys("testing");
		driver.findElement((By.xpath(".//*[@id='_fZl']"))).click();
		driver.findElement(
				(By.xpath(".//*[@id='rso']/div/div/div[1]/div/div/h3/a")))
				.click();

	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\\\Users\\dedua\\Downloads\\geckodriver-v0.16\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://google.com");

	}

	@AfterTest
	public void afterTest() {
		driver.close();

	}

}
