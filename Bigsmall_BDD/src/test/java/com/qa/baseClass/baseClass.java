package com.qa.baseClass;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public static ExtentTest test;
	public static ExtentReports report;
	
	public static void initializeReport()
	{
		if(report==null)
		report = new ExtentReports(System.getProperty("user.dir") + "\\reports\\" + "ExtentReportResults-"
				+ System.currentTimeMillis() + "-.html");
	}


	public WebDriver BaseSettings() {
		try {
			prop = new Properties();

			FileInputStream fis = new FileInputStream(
					"C:\\Users\\vivek\\eclipse-workspace\\Bigsmall_BDD\\src\\test\\java\\com\\qa\\config\\config.properties ");

			prop.load(fis);

			String browserName = prop.getProperty("Browser");
			

			if (browserName.equalsIgnoreCase("chrome")) {
				//System.setProperty("webdriver.chrome.driver", driverPath);
				WebDriverManager.chromedriver().clearDriverCache().setup();
				driver = new ChromeDriver();
			} 
			
			else if (browserName.equalsIgnoreCase("edge")) {
				//System.setProperty("webdriver.chrome.driver", driverPath);
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();		
			}
			
			// Implicit wait to avoid element not found exception
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Maximize browser
			driver.manage().window().maximize();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;

	}

}
