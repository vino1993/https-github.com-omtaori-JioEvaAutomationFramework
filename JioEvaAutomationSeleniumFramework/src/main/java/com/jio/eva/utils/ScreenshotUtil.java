package com.jio.eva.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.jio.eva.driver.DriverManager;

public final class ScreenshotUtil {

	private ScreenshotUtil() {}
	
	public static String getBase64Image() {
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

	
}
