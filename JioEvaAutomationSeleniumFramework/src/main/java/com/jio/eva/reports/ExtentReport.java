package com.jio.eva.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.jio.eva.constants.FrameworkConstants;

public final class ExtentReport {

	private ExtentReport() {	
	}

	private static ExtentReports extent;

	public static void initReports() {
		if(Objects.isNull(extent)) {
			extent = new ExtentReports();

			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Jio Eva Automation Report");
			spark.config().setReportName("Eva Execution");
		}
	}

	public static void flushReports() {
		try {
			if(Objects.nonNull(extent)) {
				extent.flush();
			}
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createTest(String testCaseName) {
		ExtentManager.setExtTest(extent.createTest(testCaseName));
	}

}
