package caseStudy.Framework.pom;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Capabilities {
	
	protected static String appPackage;
	protected static String appActivity; 
	protected static String deviceName; 
	protected static String chromeDriver;
	public static AndroidDriver<AndroidElement> capability(String appPackage, String appActivity, String deviceName, String chromeDriver) throws IOException {
		
		FileReader input = new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\caseStudy\\Framework\\pom\\global.properties");
		Properties property=new Properties();
		property.load(input);
		
		appPackage = property.getProperty("appPackage");
		appActivity = property.getProperty("appActivity");
		deviceName = property.getProperty("deviceName");
		chromeDriver = property.getProperty("chromeDriver");
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
		//cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, chromeDriver);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		return driver;
	}

}
