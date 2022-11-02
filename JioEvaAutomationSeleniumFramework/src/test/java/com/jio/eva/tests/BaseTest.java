package com.jio.eva.tests;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.jio.eva.driver.Driver;
import com.jio.eva.reports.ExtentLogger;
import com.jio.eva.reports.ExtentReport;

public class BaseTest {
	
	

	/**
	1. Never hardcode
	2. Keep right thing at right place
	3. class or interface name should be UpperCamelCase
	4. final constant values - FINALCONSTANTVALUES or FINAL_CONSTANT_VALUES
	5. method name should be lowerCamelCase
	6. package should be in lowercase
	*/
	
	// not to create object of this class but should be extended by child classes
	protected BaseTest() {
		
	}

	
	@BeforeSuite
	protected void beforeSuite()
	{
		System.out.println("Driver is in before suite method");
		
		ExtentReport.initReports();
		
		// know the current configuration
		// update the sheet
	}
	
	
	@BeforeTest
	protected void beforeTest()
	{
		System.out.println("Driver is in before test method");
		Driver.initDriver();
	}
	
	
	@BeforeClass
	protected void beforeClass()
	{
		System.out.println("Driver is in before class method");
	}
	
	@BeforeMethod
	protected void setUp(Method m)
	{
		System.out.println("Driver is in before method");
		ExtentReport.createTest(m.getName());
	}
	
	
	@AfterMethod
	protected void tearDown(ITestResult result)
	{
		System.out.println("Driver is in after method");
	}

	@AfterClass
	protected void afterClass()
	{
		System.out.println("Driver is in after class method");
	}

	@AfterTest
	protected void afterTest()
	{
		System.out.println("Driver is in after test method");
		Driver.quitDriver();
	}
	
	@AfterSuite
	protected void afterSuite()
	{
		System.out.println("Driver is in after suite method");
		ExtentReport.flushReports();
	}
	
	
}
