package appium.GeneralStore;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class validatingCheckOutPage extends base {

	@Test
	public void checkOutValidation() throws IOException, InterruptedException {
		
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
        
       
        
    String checkoutitem= driver.findElementByAndroidUIAutomator("text(\"Air Jordan 1 Mid SE\")").getText();
     
     System.out.println(checkoutitem);
    
     Assert.assertEquals("Air Jordan 1 Mid SE", checkoutitem);
     
     
     String amount1= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();  // getting item price at 0th index.
	
     amount1 = amount1.substring(1);  // removing $ sign so we can sum it.
   Double value1= Double.parseDouble(amount1); 
   
   String amount2= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();  // getting item price at 1th index.
	
   amount2 = amount2.substring(1);                         // removing $ sign so we can sum it.
   Double value2= Double.parseDouble(amount2);              // converting to double as they have decimal values.
	
	
	     Double totallOfProducts= value1+value2;
	  
	     System.out.println(totallOfProducts);
	     
	    String total= driver.findElements(By.id("com.androidsample.generalstore:id/totalAmountLbl")).get(0).getText();
	
	  total= total.substring(1);
	  
	Double totalvalue=  Double.parseDouble(total);
	
	System.out.println(totalvalue);
	
	Assert.assertEquals(totalvalue, totallOfProducts);
	
	
	
	   WebElement terms= driver.findElementByAndroidUIAutomator("text(\"Please read our terms of conditions\")");
		 
	      TouchAction ta = new TouchAction(driver);
	      ta.longPress(longPressOptions().withElement(element(terms)).withDuration(ofSeconds(2))).release().perform();
	      
	      driver.findElementByAndroidUIAutomator("text(\"CLOSE\")").click();
	
	
	}

	}


