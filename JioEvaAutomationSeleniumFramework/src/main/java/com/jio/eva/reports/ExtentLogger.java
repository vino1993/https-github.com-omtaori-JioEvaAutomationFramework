package com.jio.eva.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.jio.eva.utils.ReadPropertyFile;
import com.jio.eva.utils.ScreenshotUtil;

public final class ExtentLogger {

	private ExtentLogger() {}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}

	public static void info(String message) {
		ExtentManager.getExtentTest().info(message);
	}

	public static void log(Status status, String message) {

		switch (status) {
		case PASS:
			ExtentManager.getExtentTest().log(Status.PASS, message);
			break;
		case FAIL:
			ExtentManager.getExtentTest().log(Status.FAIL, message);
			break;
		case INFO:
			ExtentManager.getExtentTest().log(Status.INFO, message);
			break;
		case SKIP:
			ExtentManager.getExtentTest().log(Status.SKIP, message);
			break;
		default:
			break;
		}
	}

	public static void pass(String message, boolean isScreenshotNeeded) {
		if(ReadPropertyFile.get("passedstepsscreenshot").equalsIgnoreCase("yes") && isScreenshotNeeded) {
			ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.getBase64Image()).build());
		}
		else {
			pass(message);
		}
	}

	public static void fail(String message, boolean isScreenshotNeeded) {
		if(ReadPropertyFile.get("passedstepsscreenshot").equalsIgnoreCase("yes") && isScreenshotNeeded) {
			ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.getBase64Image()).build());
		}
		else {
			fail(message);
		}
	}

	public static void skip(String message, boolean isScreenshotNeeded) {
		if(ReadPropertyFile.get("passedstepsscreenshot").equalsIgnoreCase("yes") && isScreenshotNeeded) {
			ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.getBase64Image()).build());
		}
		else {
			skip(message);
		}
	}

	public static void info(String message, boolean isScreenshotNeeded) {
		if(ReadPropertyFile.get("passedstepsscreenshot").equalsIgnoreCase("yes") && isScreenshotNeeded) {
			ExtentManager.getExtentTest().info(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtil.getBase64Image()).build());
		}
		else {
			info(message);
		}
	}

}
