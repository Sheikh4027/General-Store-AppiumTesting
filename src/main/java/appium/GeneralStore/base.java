package appium.GeneralStore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {
	public static AndroidDriver<AndroidElement>Capabilities (String app) throws IOException{

		
      FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\appium\\GeneralStore\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String device=(String) prop.get("device");
		
		
		File f = new File ("src");
		File apk = new File(f,(String) prop.get(app));
		
		
		
		
		
		DesiredCapabilities cap = new DesiredCapabilities(); 
      cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
      cap.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
      cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
      
      
      AndroidDriver<AndroidElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      return driver;

}
}



