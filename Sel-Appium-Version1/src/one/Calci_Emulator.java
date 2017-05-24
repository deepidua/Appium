
/**
 * Before running , launch the AVD in eclipse
 * Launching Calculator using AVD and performing basic operation.
 * 
 */
package one;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Calci_Emulator {

	WebDriver driver;
	
	@Before
	public void setUp() throws MalformedURLException 
	{
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		
		capabilities.setCapability("BROWSER_NAME","Android");
		capabilities.setCapability("deviceName","AVD_for_Redmi_Prime");
		capabilities.setCapability("PLATFORM","Android");
		capabilities.setCapability("VERSION","6.0.1");
		capabilities.setCapability("appPackage","com.android.calculator2");
		capabilities.setCapability("appActivity","com.android.calculator2.Calculator");
		
		driver = new AndroidDriver( new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}
	@Test
	public void testcal(){
		
		driver.findElement(By.xpath("//*[@text='2']")).click();
		driver.findElement(By.xpath("//*[@text='+']")).click();
		driver.findElement(By.xpath("//*[@text='7']")).click();
		driver.findElement(By.xpath("//*[@text='=']")).click();
		WebElement rs= driver.findElement(By.className("android.widget.EditText"));
		System.out.println("results are "+rs);
		
	}
	
	@After
	public void teardown(){
		
		driver.quit();
	}
	
	
	
}
