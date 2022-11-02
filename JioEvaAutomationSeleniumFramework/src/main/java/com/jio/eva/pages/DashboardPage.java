package com.jio.eva.pages;

import org.openqa.selenium.By;

import com.jio.eva.driver.DriverManager;

public final class DashboardPage {

	//region WebElements
	private final By dashboardOptsBar = By.tagName("app-dashboard-options-bar");
	//endregion


	//region Methods

	public String getDashboardPageTitle()
	{
		return DriverManager.getDriver().getTitle();
	}

	public String getDashboardPageUrl()
	{
		return DriverManager.getDriver().getCurrentUrl();
	}

	public boolean isDashboardPageDisplayed()
	{
		return DriverManager.getDriver().findElement(dashboardOptsBar).isDisplayed();
	}

}
