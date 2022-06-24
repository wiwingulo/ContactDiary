package com.nexsoft.newcontact.pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class NewContact {
	
	private AndroidDriver driver;
	
	@AndroidFindBy(id = "com.apozas.contactdiary:id/name_input")
	public WebElement txtName;
	
	@AndroidFindBy(id = "com.apozas.contactdiary:id/place_input")
	public WebElement txtPlace;
	
	@AndroidFindBy(id = "com.apozas.contactdiary:id/phone_input")
	public WebElement txtPhone;

	@AndroidFindBy(id = "com.apozas.contactdiary:id/notes_input")
	public WebElement txtNote;
	

	@AndroidFindBy(id = "com.apozas.contactdiary:id/date_input")
	public WebElement txtDate;

	@AndroidFindBy(id = "com.apozas.contactdiary:id/enddate_input")
	public WebElement txtEndDate;
	

	@AndroidFindBy(id = "com.apozas.contactdiary:id/inittime_input")
	public WebElement txtTime;

	@AndroidFindBy(id = "com.apozas.contactdiary:id/endtime_input")
	public WebElement txtEndTime;
	
	@AndroidFindBy(id = "com.apozas.contactdiary:id/known_yes")
	public WebElement cYes;

	@AndroidFindBy(id = "com.apozas.contactdiary:id/known_no")
	public WebElement cNo;
	
	@AndroidFindBy(id = "com.apozas.contactdiary:id/contact_indoors")
	public WebElement cIndoors;

	@AndroidFindBy(id = "com.apozas.contactdiary:id/contact_outdoors")
	public WebElement cOutdoor;
	
	
	@AndroidFindBy(id = "com.apozas.contactdiary:id/mitigation")
	public WebElement mitigation;
	
	@AndroidFindBy(id = "com.apozas.contactdiary:id/okButton_AddContact")
	public WebElement btnSave;
	
	public NewContact (AndroidDriver driver){
		this.driver = driver;
		
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	public void setMitigation(List<String> choice ) {
		mitigation.click();
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		for (String no : choice) {
			
			String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/"
					+ "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/"
					+ "android.widget.CheckedTextView["+no+"]";
			
			driver.findElement(By.xpath(xpath)).click();
		}
		driver.findElement(By.id("android:id/button1")).click();
	}

	public String getTxtDate() {
		return txtDate.getText();
	}

	public void setTxtDate(String date) {
		txtDate.click();
		Calender_View calendar = new Calender_View(driver);
		calendar.setDate(date);
	}

	public String getTxtEndDate() {
		return txtEndDate.getText();
	}

	public void setTxtEndDate(String date) {
		txtEndDate.click();
		if(driver.getCapabilities().getCapability("platformVersion").toString().equalsIgnoreCase("11")) {
		Calender_View calendar = new Calender_View(driver);
		calendar.setDate(date);
		}
	}
	
	public void setTxtTime(String time, String minutes, String ampm) {
		txtTime.click();
		setTime(time, minutes, ampm);	
	}

	public String getTxtEndTime() {
		return txtEndTime.getText();
	}

	public void setTxtEndTime(String time, String minutes, String ampm) {
		txtEndTime.click();
		setTime(time, minutes, ampm);
	}
	
	private void setTime(String time, String minutes, String ampm) {
		driver.findElement(By.id("android:id/toggle_mode")).click();
		driver.findElement(By.id("android:id/input_hour")).sendKeys(time);
		driver.findElement(By.id("android:id/input_minute")).sendKeys(minutes);
		driver.findElement(By.id("android:id/am_pm_spinner")).click();
		
		if(ampm.equalsIgnoreCase("am")) {
			driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]")).click();
		}else {
			driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")).click();
		}
		
		driver.findElement(By.id("android:id/button1")).click();
	}

	public void save() {
		btnSave.click();
	}

}

