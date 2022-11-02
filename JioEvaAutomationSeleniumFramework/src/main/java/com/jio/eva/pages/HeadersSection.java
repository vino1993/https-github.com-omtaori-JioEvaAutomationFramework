package com.jio.eva.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.google.common.util.concurrent.Uninterruptibles;
import com.jio.eva.driver.DriverManager;
import com.jio.eva.utils.ReadPropertyFile;

public class HeadersSection extends BasePage{

	//region selectors
	
	private final By productIcn = By.cssSelector("app-header img[src*='EVA']");
	private final By notificationIcn = By.cssSelector("app-header img[src*='notification']");
	private final By userIcn = By.cssSelector("app-header img[src*='user']");
	private final By signOutBtn = By.cssSelector("span.logout");
	
	//endregion
	
	//region Methods
	
	public boolean isIconDisplayed(HeaderIcons headerIcon, boolean toWait)
	{
		boolean isDisplayed = false;
		
		switch (headerIcon) {
		case evaProductIcon:
			isDisplayed = isDisplayed(productIcn, toWait);
			break;
		case notificationIcon:
			isDisplayed = isDisplayed(notificationIcn, toWait);
			break;
		case userIcon:
			isDisplayed = isDisplayed(userIcn, toWait);
			break;
		default:
			System.out.println("Select correct header icon");
			break;
		}
		
		return isDisplayed;
	}
	
	public void signOut()
	{

		try {
			//Creating object of an Actions class
			Actions action = new Actions(DriverManager.getDriver());

			//Performing the mouse hover and click actions on respective target elements
			//build()- used to compile all the actions into a single step
			action.moveToElement(DriverManager.getDriver().findElement(userIcn)).perform();
			
			Thread.sleep(1000);
			
			action.click(DriverManager.getDriver().findElement(signOutBtn)).perform();
			
			System.out.println("Clicked on Signout button");
			
			Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);	// instead of Thread.Sleep(10000);
			
			//DriverManager.getDriver().get(ReadPropertyFile.get("url"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void navigateToHomePage() {
		DriverManager.getDriver().get(ReadPropertyFile.get("url"));
		System.out.println("back to home page");
	}			
	
	//endregion
	
	public enum HeaderIcons
	{
		evaProductIcon,
		notificationIcon,
		userIcon
	}

	
	
}
