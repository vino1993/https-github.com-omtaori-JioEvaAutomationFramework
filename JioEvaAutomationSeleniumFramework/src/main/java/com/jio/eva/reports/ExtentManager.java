package com.jio.eva.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

	private ExtentManager() {
	}
	
	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

	static ExtentTest getExtentTest() {		// default -> it can only be accessed within the package -> private packages
		return extTest.get();
	}

	static void setExtTest(ExtentTest test) {
		extTest.set(test);
	}
	
	static void unload() {
		extTest.remove();
	}
}
