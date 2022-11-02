package com.jio.eva.listeners;

import java.util.Arrays;

import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.jio.eva.reports.ExtentLogger;

public class ListenerClass implements ITestListener, ISuiteListener{

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + " is passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getMethodName() + " is failed", true);		// true to attach screenshot
		ExtentLogger.fail(result.getThrowable().toString());
		ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped", true);
	}
	
}
