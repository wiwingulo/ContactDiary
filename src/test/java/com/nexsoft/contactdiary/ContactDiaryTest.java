package com.nexsoft.contactdiary;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ContactDiaryTest {

	protected AndroidDriver driver;
	
	private MainActivity mainAct;
	private ContactDiary conDir;

	@Test
	public void init() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appActivity", "com.apozas.contactdiary.MainActivity");
		capabilities.setCapability("appPackage", "com.apozas.contactdiary");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		mainAct = new MainActivity(driver);
		conDir = new ContactDiary(driver);
	}

	@Test(priority = 0)
	public void masukKePageAddEvent() {
		mainAct.addEvent();
	}
	
	@Test(priority = 1)
	public void addEvent() {
		conDir.addNewEvent("Pesta Rujak", "Newton 5", "Ciwi Newton", "0821261281", "Jan lupa di kamar Intan");
	}

}
