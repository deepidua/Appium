package one;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javafx.scene.web.WebView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Registartion_excel {

WebDriver driver;

	@Before
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		capabilities.setCapability("BROWSER_NAME","chrome");
		capabilities.setCapability("deviceName","Redmi 3s");
		capabilities.setCapability("PLATFORM","Android");
		capabilities.setCapability("VERSION","6.0.0");
		//capabilities.setCapability(CapabilityType.BROWSER_NAME,"Chrome");
		capabilities.setCapability("appPackage", "com.android.chrome");
		capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		capabilities.setCapability("autoWebview", "true");
		driver = new AndroidDriver( new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		//WebView.setWebContentsDebuggingEnabled(true); 
		
	}
	
	@Test
	public void test_login()
	{
		driver.get("http://automationpractice.com/index.php");   //*[@id="header"]/div[2]/div/div/nav/div[1]/a
		//driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		//driver.findElement((By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a"))).click();
	
		Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();
		for (String contextName : contextNames) {
		System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
		}
		((AppiumDriver) driver).context("WEBVIEW_1");
		//driver.findElement((By.xpath("//login[@text='Sign in']"))).click();
		Set<String> contextNames1 = ((AppiumDriver) driver).getContextHandles();
		for (String contextName : contextNames1) {
		System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
		}
	}
	
	@After
	public void teardown()
	{
		driver.quit();
	}
	
}
