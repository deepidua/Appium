/**
 * Launching Whatsapp application from appium.
 * 
 */
package one;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Whatsapp_launch {

	WebDriver dr;

	@Test
	public void testApp() throws MalformedURLException, InterruptedException {

		File app = new File(System.getProperty("user.dir")
				+ "\\apks\\com.whatsapp_2.17.138-45.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities().android();
		capabilities.setCapability("deviceName", "Redmi 3s");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.whatsapp");
		capabilities.setCapability("appActivity", "com.whatsapp.Main");
		Thread.sleep(1000);
		dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);

		dr.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		dr.findElement((By.xpath("//*[@text='Test']"))).click();
	
		Thread.sleep(10000);

	}

	@After
	public void quit() {
		dr.quit();

	}

}
