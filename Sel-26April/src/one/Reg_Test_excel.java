/**
 * 
 * Read and Write from excel in selenium
 */
package one;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Reg_Test_excel {
	WebDriver driver;
	
	  @Test
	  public void f() {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	  driver.findElement((By.xpath(".//*[@id='wiz_username']"))).sendKeys("test");
	  driver.findElement((By.xpath(".//*[@id='wiz_email']"))).sendKeys("etstt@gmail.com");
	 WebElement wd= driver.findElement((By.xpath(".//*[@id='CountrySelect']")));
	 Select s = new Select(wd);
	 s.selectByVisibleText("India");
	 driver.findElement((By.xpath(".//*[@id='wiz_phone']"))).sendKeys("12345678911");
	 WebElement wd1 =driver.findElement((By.xpath(".//*[@id='UserType']")));
	 Select s1 = new Select(wd1);
	 s1.selectByVisibleText("Learner or student");
	 driver.findElement((By.xpath(".//*[@id='main']/div/article/div/div/div[1]/div/div/div/div/form/button"))).click();
	  }
	  @BeforeTest
	  public void beforeTest() {
	 
		  System.setProperty("webdriver.gecko.driver",
					"C:\\\\Users\\dedua\\Downloads\\geckodriver-v0.16\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get("https://www.wiziq.com/signup/");
	  }

	  @AfterTest
	  public void afterTest() {
	 
	  driver.close();
	  }

	}
