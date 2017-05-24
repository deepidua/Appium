/**
 * Launching Whatsapp application from appium.
 * 
 */
package one;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);

		dr.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		Thread.sleep(1000);
		System.out.println(dr.getPageSource());
		Set<String> contextNames = ((AppiumDriver) dr).getContextHandles();
		for (String contextName : contextNames) {
		System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
		}
//(AppiumDriver)dr.findElement((By.id("")).tap();
		WebElement e =dr.findElement(By.xpath("android.widget.TextView[1]"));
		e.click();
		e.sendKeys("testtt");
		Thread.sleep(400);
		//	dr.findElement((By.xpath("//android.widget.FrameLayout[@resource-id = 'com.whatsapp:id/conversations_row_contact_name_holder']"))).click();
		//dr.findElement((By.id("com.whatsapp:id/conversations_row_contact_name_holder"))).click();
		//dr.findElement((By.id("com.whatsapp:id/input_layout_content"))).sendKeys("helloosssss");
	//dr.findElement((By.xpath("//android.widget.EditText[@resource-id ='com.whatsapp:id/input_layout_content']"))).sendKeys("hhhh");
		Thread.sleep(10000);

	}

	@After
	public void quit() {
		dr.quit();

	}

}
