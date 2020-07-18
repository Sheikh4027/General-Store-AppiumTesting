package appium.GeneralStore;


import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class GeneralStoreHomePage extends base {

	@Test
	public void TotalValidation() throws IOException, InterruptedException {
		
		AndroidDriver<AndroidElement> driver = Capabilities("GeneralStoreApp");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		driver.findElementByClassName("android.widget.Spinner").click();
		
	    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bangladesh\"));").click();
		
		driver.findElementByAndroidUIAutomator("text(\"Enter name here\")").sendKeys("Tufail");
		
		driver.hideKeyboard();
		
		driver.findElementByAndroidUIAutomator("text(\"Male\")").click();
		

		driver.findElementByAndroidUIAutomator("text(\"Let's  Shop\")").click();
		
         driver.findElementsByAndroidUIAutomator("text(\"ADD TO CART\")").get(1).click();
		
         driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"PG 3\"));").click();
         driver.findElementsByAndroidUIAutomator("text(\"ADD TO CART\")").get(1).click(); 
         
        Thread.sleep(2000);
		
        Assert.assertTrue(driver.findElementByAndroidUIAutomator("text(\"ADDED TO CART\")").isDisplayed());
     
      
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        
       
        
        driver.findElementByClassName("android.widget.CheckBox").click();
        
      WebElement terms= driver.findElementByAndroidUIAutomator("text(\"Please read our terms of conditions\")");
	 
      TouchAction ta = new TouchAction(driver);
     
      ta.longPress(longPressOptions().withElement(element(terms)).withDuration(ofSeconds(2))).release().perform();
      
      driver.findElementByAndroidUIAutomator("text(\"CLOSE\")").click();
      
       
        
	   driver.findElementByAndroidUIAutomator("text(\"Visit to the website to complete purchase\")").click();
	   
	  Thread.sleep(1000);
	  
	  File src = driver.findElementByClassName("android.webkit.WebView").getScreenshotAs(OutputType.FILE);
	   
	   FileUtils.copyFile(src, new File("webpage.png"));
	
	
	Set<String> context =driver.getContextHandles();
	
	for(String contextName : context)
	{
		System.out.println(contextName);
	}
	   
	   
	/*Thread.sleep(1000);
	
	driver.context("WEBVIEW_com.androidsample.generalstore");
	
	Thread.sleep(2000);
	driver.findElementByName("q").sendKeys("Tufail", Keys.ENTER);           // inssue while try to switch to web. chromedriver error.
	
	System.out.println(driver.getCurrentUrl());
	
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	driver.context("NATIVE_APP").close();
	
	
	*/
	
	}

	}


