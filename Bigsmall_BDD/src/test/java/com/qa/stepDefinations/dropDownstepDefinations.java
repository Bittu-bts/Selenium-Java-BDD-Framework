package com.qa.stepDefinations;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.qa.Utilities.ExtentLogUtilities;
import com.qa.baseClass.baseClass;
import com.qa.pageObject.dropDownpageObject;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class dropDownstepDefinations extends baseClass {
	
	dropDownpageObject dd = new dropDownpageObject (driver);
	public static Logger log=Logger.getLogger(baseClass.class.getName());
	
	@Before("@Dropdown")
	public void Init() {
		test = report.startTest("Home page dropdown");
		
	}
	
	@Given("Initialize the browser")
	public void initialize_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
		driver = BaseSettings();
		driver.get(prop.getProperty("url"));
		log.info("driver initilaize");
	}
	
	@Given("User will land to Home Page")
	public void user_will_land_to_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		log.info("Land on Home page");
	}
	
	@When("User will click on dropdown")
	public void user_will_click_on_dropdown() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    dd.getdropdown().click();
		test.log(LogStatus.PASS, "Click on drodown");
		log.info("Click on drodown");
		ExtentLogUtilities.pass(driver, test, "Task Done", log);
	}
	
	@After("@Dropdown")
	public void getll() {
		report.endTest(test);
		report.flush();
	}
	
	@Then("browser close")
	public void browser_close() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.close();
	}

}
