package com.jio.eva.pages;

import org.openqa.selenium.By;

import com.jio.eva.driver.DriverManager;

public final class HomePage extends BasePage {

	// WebElements

	private final By loginBtn = By.cssSelector("button.login-button");
	private final By jioEvaLogo = By.xpath("//img[@alt='Jio Eva Portal']/following-sibling::span[.='EVA']");


	//region Page Methods

	public String getHomePageTitle()
	{
		return getPageTitle();
	}

	public String getHomePageUrl()
	{
		return getPageURL();
	}

	public LoginPage navigateToLoginPage()
	{
		try {
			click(loginBtn);

			// Switch to new window opened
			switchToNewlyOpenedWindow();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new LoginPage();
	}

	public boolean isHeaderElementDisplayed(HeaderElements headerElement)
	{
		boolean isDisplayed = false;

		try {
			switch (headerElement) {
			case jioEvaLogo:
				isDisplayed = isDisplayed(jioEvaLogo, true);
				break;
			case LoginBtn:
				isDisplayed = isDisplayed(loginBtn, true);
				break;

			default:
				System.out.println("Select proper element from header of home page");
				break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isDisplayed;
	}

	//endregion


	public enum HeaderElements
	{
		jioEvaLogo,
		LoginBtn
	}

}
