package one;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.chrome.handler.ChromedriverHandler;

public class Web_Test {

	WebDriver dr;

	@Before
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		capabilities.setCapability("BROWSER_NAME","chrome");
		capabilities.setCapability("deviceName","Redmi 3s");
		capabilities.setCapability("PLATFORM","Android");
		capabilities.setCapability("VERSION","6.0.0");
		capabilities.setCapability("appPackage", "com.android.chrome");
		capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		//capabilities.setCapability("autoWebview", "true");
		dr = new AndroidDriver( new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		//ChromedriverHandler.chromeDriverHandlerThread().start();
		dr.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

	}

	@Test
	public void test() throws InterruptedException {

		dr.get("https://www.facebook.com");
		List<WebElement> ls = dr.findElements(By.className("android.widget.EditText"));
		for(WebElement e :ls)
		{
			System.out.println(e.getText());
			
		}
		Thread.sleep(9000);
	WebElement el=	dr.findElement((By.xpath("//android.widget.EditText[@index='0']")));
el.click();
el.clear();el.sendKeys("deepi.dua");

WebElement el1 = dr.findElement((By.xpath("//android.widget.EditText[1]")));
el1.click();el1.clear();el1.sendKeys(("passwordtesting"));
		//dr.findElement((By.xpath("//android.widget.EditText[@content-desc='Password']")));
		//dr.findElement((By.xpath(".//*android.widget.EditText[@index='0' and @text='Email address or phone number']"))).sendKeys("Hanuman g");
		//dr.findElement((By.xpath("//*[@text='Email address or phone number']"))).clear();
		//dr.findElement((By.xpath("//*[@text='Email address or phone number']"))).sendKeys("Hanman G");
		Thread.sleep(9000);
		//System.out.println(dr.getPageSource());
	/*Thread.sleep(6000);
	((AppiumDriver) dr).context("WEBVIEW_com.android.chrome");
		Set<String> contextNames = ((AppiumDriver) dr).getContextHandles();
		for (String contextName : contextNames) {
		System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
		}
		
		String el =dr.getWindowHandle();
		dr.switchTo().window("WEBVIEW");*/

		
	}

	@After
	public void tearDown() {

		//ChromedriverHandler.chromeDriverHandlerThread().stop();
		dr.quit();
	}

}
