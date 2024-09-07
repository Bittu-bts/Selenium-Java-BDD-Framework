package com.qa.stepDefinations;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;

import com.qa.Utilities.Exceltakesvalue;
import com.qa.Utilities.ExtentLogUtilities;
import com.qa.baseClass.baseClass;
import com.qa.pageObject.searchBarpageObject;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class searchBarstepDefinations extends baseClass {
    
	searchBarpageObject sb = new searchBarpageObject (driver);
    public static Logger log=Logger.getLogger(baseClass.class.getName());
	
	@Before("@Searchbar")
	public void Init() {
		test = report.startTest("Home page searcbar");
		
	}
	
	@When("User will click on search icon and enter the keyword")
	public void user_will_click_on_search_icon_and_enter_the_keyword() throws IOException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		sb.clicksearhicon().click();
		Thread.sleep(4000);
		
		String path=System.getProperty("user.dir");
		Exceltakesvalue exc = null;
		try {
			exc=new Exceltakesvalue(path+"\\ExcelSheet\\ExcelComp1.xlsx","Sheet1");
			log.info("ExcelSheet opened");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Excel sheet accessible");
		}
		
		
		String key=exc.getData(0, 0);
		log.info("Entering Keyword");
		sb.searchbar().sendKeys(key, Keys.ENTER);
		test.log(LogStatus.PASS, "Entering Keyword");
		ExtentLogUtilities.pass(driver, test, "Task Done", log);
	}
	
	@After("@Searchbar")
	public void getll() {
		report.endTest(test);
		report.flush();
	}

	    
	}

