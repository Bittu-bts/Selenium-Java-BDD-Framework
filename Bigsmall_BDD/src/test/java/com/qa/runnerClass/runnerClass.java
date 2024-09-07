package com.qa.runnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "Features",
		glue = "com.qa.stepDefinations")
public class runnerClass extends AbstractTestNGCucumberTests {

}
