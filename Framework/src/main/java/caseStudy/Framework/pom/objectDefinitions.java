package caseStudy.Framework.pom;
import java.net.MalformedURLException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class objectDefinitions {
	public static AndroidDriver <AndroidElement> driver=null;
	
	public objectDefinitions(AndroidDriver <AndroidElement> driver) throws MalformedURLException {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public WebElement dismissLink() {
		return driver.findElement(By.xpath("//*[@text='Dismiss']"));
		//driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Dismiss\"]/android.widget.TextView")).click();
	}
	
	
	
	public WebElement signIn1() {
		return driver.findElement(By.xpath("//*[@text='Sign in']"));
	}
	public WebElement signIn2() {
		return driver.findElement(By.xpath("//*[@text='Continue with Google']"));
	}
	public WebElement signIn3() {
		return driver.findElement(By.id("com.google.android.gms:id/account_display_name"));
	}
	
	
	public WebElement selectlanguage() {
		return driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Select language\").instance(0))");
	}
	
	public WebElement openCourse() {
		return driver.findElement(By.xpath("//*[@text='Computer programming']"));
	}
	
	public WebElement ChromeAct() {
		return driver.findElement(By.xpath("//a[@class='_1emc3m49']"));
	}
}