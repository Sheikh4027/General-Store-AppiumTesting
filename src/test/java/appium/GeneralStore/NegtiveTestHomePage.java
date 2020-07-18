package appium.GeneralStore;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class NegtiveTestHomePage extends base {

	@Test
	public void HomePageValidation() throws IOException{
		
		AndroidDriver<AndroidElement> driver = Capabilities("GeneralStoreApp");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		driver.findElementByClassName("android.widget.Spinner").click();
		
	    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bangladesh\"));").click();
		
		//driver.findElementByAndroidUIAutomator("text(\"Enter name here\")").sendKeys("Tufail");
		
		driver.hideKeyboard();
		
		driver.findElementByAndroidUIAutomator("text(\"Male\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Let's  Shop\")").click();
	
		String toast=	driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		
		System.out.println(toast);
			
		Assert.assertEquals("Please enter your name", toast);

		
		
		
	}
		
		
	}


