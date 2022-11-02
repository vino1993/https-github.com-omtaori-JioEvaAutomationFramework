package com.jio.eva.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jio.eva.pages.HeadersSection;
import com.jio.eva.pages.HeadersSection.HeaderIcons;
import com.jio.eva.pages.LoginPage;
import com.jio.eva.utils.ReadPropertyFile;

public final class HeadersSectionTests {

	HeadersSection headerSection;
	LoginPage loginPage;
	
	private HeadersSectionTests() {
		
	}
	
//	@Test()
	public void Logout()
	{
		try {
			System.out.println("***** This is Logout Test Case ***** ");

			headerSection = new HeadersSection();

			// verify user logged in 
			Assert.assertTrue(headerSection.isIconDisplayed(HeaderIcons.evaProductIcon, true), "Product icon should be displayed");
			Assert.assertTrue(headerSection.isIconDisplayed(HeaderIcons.notificationIcon, false), "Notification icon should be displayed");
			Assert.assertTrue(headerSection.isIconDisplayed(HeaderIcons.userIcon, false), "User icon should be displayed");

			// Signout
			headerSection.signOut();

			// verify login page title
			String actualTitle = loginPage.getLoginPageTitle();
			Assert.assertEquals(actualTitle, "Engage Video Assistant");

			// verify login page url
			loginPage = new LoginPage();
			String actualUrl = loginPage.getLoginPageUrl();
			Assert.assertEquals(actualUrl, ReadPropertyFile.get("loginPageUrl"));
			
			// navigate to home page
			headerSection.navigateToHomePage();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
