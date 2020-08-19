package caseStudy.Framework;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.Key;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.ScrollAction;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import caseStudy.Framework.pom.Capabilities;
import caseStudy.Framework.pom.objectDefinitions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TestCase extends Capabilities{
	AndroidDriver<AndroidElement> driver=null;
	objectDefinitions obj=null;
		
		@BeforeClass
		public void beforeTest() throws IOException {
			System.out.println("*****************  In BeforeTest *************");
			driver = capability(appPackage, appActivity, deviceName, chromeDriver);
			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
			obj=new objectDefinitions(driver);
		}
		
		@Test(enabled=true,priority=0)
		  public void TC01_openApp() throws InterruptedException {
			  Thread.sleep(1000);
			  obj.dismissLink().click();
			  obj.dismissLink().click();
		}
		
		@Test(enabled=true,priority=1)
		  public void TC02_signIn() throws InterruptedException {
			  Thread.sleep(1000);
			  obj.signIn1().click();
			  obj.signIn2().click();
			  obj.signIn3().click();
		}
		
		@Test (enabled=true,priority=2) 
		  public void TC03_selectLanguage() throws InterruptedException {
			  Thread.sleep(1000);
			  obj.selectlanguage().click();
			  driver.findElements(By.className("android.view.ViewGroup")).get(14).click();
			  driver.navigate().back();
			  driver.findElement(By.id("org.khanacademy.android:id/tab_bar_button_home")).click();
		}
		
		@Test (enabled=true,priority=3)
		public void TC04_openCourses() throws InterruptedException {
			obj.openCourse().click();
			Thread.sleep(15000);
		}
		
		@Test (enabled=true,priority=4)
		public void TC05_chromeActions() throws InterruptedException {
			Set<String> contextNames=driver.getContextHandles();
			for (String contextName : contextNames) {
			System.out.println(contextName);
			}
			Thread.sleep(8000);
			driver.context("WEBVIEW_chrome");
			obj.ChromeAct().click();
		}
		
		@Test (enabled=true,priority=5)
		public void TC06_switchToNative() throws InterruptedException {
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.context("NATIVE_APP");
			driver.findElement(By.id("org.khanacademy.android:id/tab_bar_button_home")).click();
		}
		
		@Test (enabled=true,priority=6)
		public void TC07_signOut() throws InterruptedException {
			driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Settings\"]")).click();
			driver.findElement(By.xpath("//*[@text='Sign out']")).click();
			boolean signin=driver.findElement(By.xpath("//*[@text='Sign in']")).isDisplayed();
			if (signin==true) {
				System.out.println("***Successfully Signed Out of the Application***");
			}
			driver.pressKey(new KeyEvent(AndroidKey.HOME));
			}
}