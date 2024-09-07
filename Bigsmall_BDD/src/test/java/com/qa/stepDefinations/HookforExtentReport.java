package com.qa.stepDefinations;

import com.qa.baseClass.baseClass;

import io.cucumber.java.BeforeAll;

public class HookforExtentReport extends baseClass {
	
	@BeforeAll
	public static void init()
	{
		initializeReport();
	}

}
