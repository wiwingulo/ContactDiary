package com.nexsoft.newcontact.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="",
				 features = "src/test/resources/Contact.feature",
				 glue = "com.nexsoft.newcontact.definitions")
public class CucumberRunner extends AbstractTestNGCucumberTests{
}
