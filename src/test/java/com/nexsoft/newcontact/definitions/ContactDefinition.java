package com.nexsoft.newcontact.definitions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;


import com.nexsoft.newcontact.pom.NewContact;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactDefinition {

	protected AndroidDriver driver;
	protected NewContact newContact;

	@Before
	public void init() throws MalformedURLException {


		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appActivity", "com.apozas.contactdiary.MainActivity");
		capabilities.setCapability("appPackage", "com.apozas.contactdiary");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("platformVersion", "11.0");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		newContact = new NewContact(driver);
	}

	@Given("User berada di halaman MainActivity")
	public void gotoMainActivity() throws Throwable {
		driver.findElement(By.id("com.apozas.contactdiary:id/fab")).click();
		
		TouchAction touchNewEvent = new TouchAction(driver);
		touchNewEvent.tap(PointOption.point(948, 1774)).perform();
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
	}

	@When("User memasukkan username {string}")
	public void inputUsername(String username) {
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		System.out.println(username);
		newContact.txtName.sendKeys(username);
	}

	@And("User memasukkan place {string}")
	public void inputPlace(String place) {
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		System.out.println("place");
		newContact.txtPlace.sendKeys(place);
	}

	@And("User memasukkan date")
	public void inputDate() throws Throwable {
		System.out.println("User dapat memasukkan date");
	}

	@And("User memasukkan phone {string}")
	public void inputPhone(String phone) throws Throwable {
		System.out.println("User memasukkan phone <phone>");
		newContact.txtPhone.sendKeys(phone);
	}

	@And("User memilih relatif or close friend")
	public void inputRelatifOrClose() throws Throwable {
		System.out.println("User memilih relatif or close friend");
	}

	@And("User memilih encounter type")
	public void inputEncounter() throws Throwable {
		System.out.println("User memilih encounter type");
	}

	@And("User mengisi notes {string}")

	public void inputNotes(String notes) throws Throwable {
		System.out.println(notes);
		newContact.txtNote.sendKeys(notes);
	}

	@And("User menekan tombol save")
	public void clickSave() throws Throwable {
		System.out.println("User menekan tombol save");
		newContact.btnSave.click();;
	}

	@Then("User kembali ke menu MainActivity")
	public void backMainActivity() throws Throwable {
		System.out.println("User kembali ke menu MainActivity");
	}
}
