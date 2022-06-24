package com.nexsoft.newcontact.pom;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class NewContact_Test {
	protected AndroidDriver driver;
	
	@Test
	public void init () throws MalformedURLException {

		
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("appActivity", "com.apozas.contactdiary.MainActivity");
			capabilities.setCapability("appPackage", "com.apozas.contactdiary");
			capabilities.setCapability("deviceName", "emulator-5554");
			capabilities.setCapability("platformVersion", "11.0");
			
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		  
			driver.findElement(By.id("com.apozas.contactdiary:id/fab")).click();
			
			TouchAction touchNewEvent = new TouchAction(driver);
			touchNewEvent.tap(PointOption.point(948, 1774)).perform();
			
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			
			NewContact contact = new NewContact(driver);
			contact.txtName.sendKeys("Graduation");
			contact.txtPlace.sendKeys("JSC Hall");
			contact.setTxtDate("01072022");
			contact.setTxtEndDate("06072022");
			contact.setTxtTime("08", "20", "am");
			contact.setTxtEndTime("10", "30", "pm");
			contact.cYes.click();
			contact.cOutdoor.click();
			List<String> choice = new ArrayList<String>();
			choice.add("1");
			choice.add("2");
			contact.setMitigation(choice);

			
			contact.txtNote.sendKeys("Testing data ");
			contact.save();
			
			List<WebElement> lstElement =driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.apozas.contactdiary:id/list_item']"));
			
//			String unknownChar ="👤   ";
//			boolean checkData = false;
//			for (WebElement webElement : lstElement) {
//				String nama = webElement.getText().replace(unknownChar,"");
//				if (nama.equalsIgnoreCase("Graduation")) {
//					checkData = true;
//					break;
//				}
//			}
//			assertTrue(checkData);
		}
	

}