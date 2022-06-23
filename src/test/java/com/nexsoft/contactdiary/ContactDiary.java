package com.nexsoft.contactdiary;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactDiary {

	public  AndroidDriver driver;
	private TouchAction touchAct;
	private DateHandler dateHdl;

	@AndroidFindBy(id = "com.apozas.contactdiary:id/eventname_input")
	public WebElement inputName;

	@AndroidFindBy(id = "com.apozas.contactdiary:id/eventplace_input")
	public WebElement inputPlace;

	@AndroidFindBy(id = "com.apozas.contactdiary:id/eventpeople_input")
	public WebElement inputCompany;

	@AndroidFindBy(id = "com.apozas.contactdiary:id/eventphone_input")
	public WebElement inputPhone;
	
	
	@AndroidFindBy(id = "com.apozas.contactdiary:id/event_indoor_outdoor")
	private List<WebElement> pTypeRadio;

	@AndroidFindBy(id = "com.apozas.contactdiary:id/event_indoors")
	public WebElement btnIndoors;

	@AndroidFindBy(id = "com.apozas.contactdiary:id/event_outdoors")
	public WebElement btnOutdoors;

	@AndroidFindBy(id = "com.apozas.contactdiary:id/event_mitigation")
	public WebElement selectOpt;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[1]")
	private WebElement check1;
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[2]")
	private WebElement check2;
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[3]")
	private WebElement check3;
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[4]")
	private WebElement check4;

	@AndroidFindBy(id = "com.apozas.contactdiary:id/eventnotes_input")
	public WebElement inputNotes;

	@AndroidFindBy(id = "com.apozas.contactdiary:id/okButton_AddEvent")
	public WebElement submit;
	
	@AndroidFindBy(id = "android:id/button1")
	private WebElement btnOk;

	public ContactDiary(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		touchAct = new TouchAction(driver);
		dateHdl = new DateHandler(driver);

	}

	public void addNewEvent(String inputNameUser, String inputPlaceUser, String inputCompanyUser,
			String inputPhoneUser, String inputNotesUser) {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		inputName.clear();
		inputName.sendKeys(inputNameUser);
		inputPlace.clear();
		inputPlace.sendKeys(inputPlaceUser);
		dateHdl.dateStartHandler(196, 583, 183, 1036, 290, 448, "20", "Juni", "2016");
		dateHdl.dateEndHandler(290, 448, "30", "Juni", "2016");
		inputCompany.clear();
		inputCompany.sendKeys(inputCompanyUser);
		inputPhone.clear();
		inputPhone.sendKeys(inputPhoneUser);
		btnIndoors.click();
		selectOpt.click();
		check1.click();
		check2.click();
		btnOk.click();
		inputNotes.sendKeys(inputNotesUser);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		submit.click();
		
	}
}
