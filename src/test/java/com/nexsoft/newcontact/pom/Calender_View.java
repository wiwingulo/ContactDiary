package com.nexsoft.newcontact.pom;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Calender_View {

	AndroidDriver driver;
	WebElement calendar;

	@AndroidFindBy(id = "android:id/date_picker_header_year")
	WebElement headerYear;

	@AndroidFindBy(id = "android:id/prev")
	WebElement prevYearBtn;

	@AndroidFindBy(id = "android:id/next")
	WebElement nextYearBtn;

	public Calender_View(AndroidDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	public void setDate(String dateUser) {
		
		 
		String  date =  driver.findElement(By.id("android:id/date_picker_header_date")).getText();
		String  year =  driver.findElement(By.id("android:id/date_picker_header_year")).getText();
		
		Date dateCalendar = null;
		try {
			dateCalendar = new SimpleDateFormat("EEE, MMM d yyyy", Locale.US).parse(date+" "+year);
//			dateCalendar = new SimpleDateFormat("yyyy-MM-dd").parse(date+" "+year);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		Date dateUsers = null;
		try {
			dateUsers = new SimpleDateFormat("ddMMyyyy", Locale.US).parse(dateUser);
//			dateUsers = new SimpleDateFormat("dd.MM.yyyy").parse(dateUser);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

		int currentYear = dateCalendar.getYear();
		int currentMonth = dateCalendar.getMonth();
	
		
		int targetYear = dateUsers.getYear();
		int targetMonth = dateUsers.getMonth();
		

		int stepYear = Math.abs(((currentYear-targetYear)*12));
		int stepMonth = Math.abs(((currentMonth-targetMonth)));
		
		int step = stepYear+stepMonth;
		
		

		if (currentYear < targetYear) {

			for (int z = 0; z < step; z++) {
				nextYearBtn.click();
			}

		} else if (currentYear > targetYear) {
			for (int y = 0; y < step; y++) {
				prevYearBtn.click();
			}
		}
		
		if(stepYear == 0 ) {
			if (currentMonth< targetMonth) {

				for (int z = 0; z < step; z++) {
					nextYearBtn.click();
				}

			} else if (currentMonth > targetMonth) {
				for (int y = 0; y < step; y++) {
					prevYearBtn.click();
				}
			}
		}
		
		
		DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.US);  
		
		driver.findElement(By.xpath("//android.view.View[@content-desc=\""+dateFormat.format(dateUsers)+"\"]")).click();
		driver.findElement(By.id("android:id/button1")).click();
	}}