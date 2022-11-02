package com.jio.eva.driver;

import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.Status;
import com.jio.eva.constants.FrameworkConstants;
import com.jio.eva.reports.ExtentLogger;
import com.jio.eva.utils.ReadPropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class Driver {

	private Driver() {

	}

	public static void initDriver() {
		try {
			System.out.println("Checking driver if null in initDriver method");
			if(Objects.isNull(DriverManager.getDriver())) {
				System.out.println("Driver is null");

				WebDriverManager.chromedriver().setup();
				DriverManager.setDriver(new ChromeDriver());
			//	ExtentManager.getExtentTest().log(Status.INFO, "Launched Browser");
/*				
				DriverManager.getDriver().get(ReadPropertyFile.get("url"));
				System.out.println("Entered url");
		//		ExtentManager.getExtentTest().log(Status.INFO, "Entered url");
				
				DriverManager.getDriver().manage().window().maximize();
				DriverManager.getDriver().manage().deleteAllCookies();
				DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(FrameworkConstants.getPAGELOADTIMEOUT()));
				DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.getIMPLICITWAIT()));
	*/			
			}
			else {
				System.out.println("Driver is not null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public static void quitDriver() {
		try {
			System.out.println("Checking driver if null in quitDriver method");
			if(Objects.nonNull(DriverManager.getDriver())) {
				System.out.println("Driver is not null");
				DriverManager.getDriver().quit();
				System.out.println("Closed browser");
				ExtentLogger.log(Status.INFO, "Closed browser");
				
				DriverManager.unload();
			}
			else {
				System.out.println("Driver is null");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
