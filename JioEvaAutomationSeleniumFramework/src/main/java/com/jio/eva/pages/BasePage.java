package com.jio.eva.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.jio.eva.constants.FrameworkConstants;
import com.jio.eva.driver.DriverManager;
import com.jio.eva.reports.ExtentLogger;
import com.jio.eva.reports.ExtentManager;

public class BasePage {

	protected void click(By by) {
		waitTillElementClickable(by);
		DriverManager.getDriver().findElement(by).click();
		System.out.println("Clicked on "+by+" element");
		ExtentLogger.log(Status.INFO, "Clicked on "+by+" element");
	}

	protected boolean isDisplayed(By by, boolean toWait) {
		boolean displayed = false;
		if(toWait) {
			waitTillElementDisplayed(by);
		}
		displayed = DriverManager.getDriver().findElement(by).isDisplayed();
		if(displayed) {
			System.out.println(by + " element is displayed");
			ExtentLogger.log(Status.INFO, by + " element is displayed");
		}
		else {
			System.out.println(by + " element is not displayed");
			ExtentLogger.log(Status.INFO, by + " element is not displayed");
		}
		return displayed;
	}

	protected boolean isEnabled(By by) {
		boolean enabled = false;
		enabled = DriverManager.getDriver().findElement(by).isEnabled();
		if(enabled) {
			System.out.println(by + " element is enabled");
			ExtentLogger.log(Status.INFO, by + " element is enabled");
		}
		else {
			System.out.println(by + " element is disabled");
			ExtentLogger.log(Status.INFO, by + " element is disabled");
		}
		return enabled;
	}

	protected void sendKeys(By by, String value) {
		waitTillElementDisplayed(by);
		DriverManager.getDriver().findElement(by).sendKeys(value);
		System.out.println("Entered '"+ value +"' in "+by+" element");
		ExtentLogger.log(Status.INFO, by + "Entered '"+ value +"' in "+by+" element");
	}


	protected String getPageTitle() {
		String title = DriverManager.getDriver().getTitle();
		System.out.println("Title of page: " + title);
		ExtentLogger.log(Status.INFO, "Title of page: " + title);
		return title;
	}

	protected String getPageURL() {
		String currentUrl =  DriverManager.getDriver().getCurrentUrl();
		System.out.println("Current url of page: " + currentUrl);
		ExtentLogger.log(Status.INFO, "Current url of page: " + currentUrl);
		return currentUrl;
	}


	private void waitTillElementClickable(By by) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()));
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	private void waitTillElementDisplayed(By by) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()));
		wait.until(d->d.findElement(by).isDisplayed());		// Java 8
	}

	protected void switchToNewlyOpenedWindow() {
		// Switch to new window opened
		for(String winHandle : DriverManager.getDriver().getWindowHandles()){
			DriverManager.getDriver().switchTo().window(winHandle);
			ExtentLogger.log(Status.INFO, "Switched to new window: " + winHandle);
		}
	}
}
