package com.jio.eva.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jio.eva.dataprovider.DataProviderWithExcel;
import com.jio.eva.pages.DashboardPage;
import com.jio.eva.pages.HomePage;
import com.jio.eva.pages.LoginPage;
import com.jio.eva.pages.LoginPage.LoginFormElements;
import com.jio.eva.utils.ReadPropertyFile;

public final class LoginPageTests extends BaseTest{

	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	private LoginPageTests() {

	}

	//@Test(dataProvider = "getData", dataProviderClass = DataProviderWithExcel.class)
	public void Login(Map<String, String> data)
		{
			try {

				System.out.println("***** This is Login Test Case ***** ");
				
				homePage = new HomePage();
				
				// navigate to login page
				loginPage = homePage.navigateToLoginPage();

				// verify login page title
				String actualTitle = loginPage.getLoginPageTitle();
				Assert.assertEquals(actualTitle, "Engage Video Assistant");

				// verify login page url
				String actualUrl = loginPage.getLoginPageUrl();
				Assert.assertEquals(actualUrl, ReadPropertyFile.get("loginPageUrl"));

				// Thread.sleep(5000);

				// verify login form is displayed
				Assert.assertTrue(loginPage.isLoginFormExists(), "Login form should be displayed");

				// verify emailId field is displayed
				Assert.assertTrue(loginPage.isElementExists(LoginFormElements.emailIdField, true), "EmailId field should be displayed");

				// verify pwd field is displayed
				Assert.assertTrue(loginPage.isElementExists(LoginFormElements.pwdField, false), "Password field should be displayed");

				// verify otp field is not displayed
				Assert.assertFalse(loginPage.isElementExists(LoginFormElements.otpField, false), "OTP field should not be displayed");

				// verify Sign in button is displayed
				Assert.assertTrue(loginPage.isElementExists(LoginFormElements.signInBtn, true), "Sign in button should be displayed");

				// verify Sign in button is disabled
				// Assert.assertFalse(loginPage.isSignInButtonEnabled(), "Sign in button should be disabled");

				// before entering credentials, delete all emails from inbox
				// GMail.deleteAllEmails();

				// enter email id, pwd, otp to login
				dashboardPage = loginPage.login(data.get("username"), data.get("password"), ReadPropertyFile.get("subject"));

				Thread.sleep(5000);

				// verify dashboard title
				actualTitle = dashboardPage.getDashboardPageTitle();
				Assert.assertEquals(actualTitle, "Engage Video Assistant");

				// verify dashboard url
				actualUrl = dashboardPage.getDashboardPageUrl();
				Assert.assertEquals(actualUrl, ReadPropertyFile.get("dashboardPageUrl"));

				// verify dashboard page is displayed
				Assert.assertTrue(dashboardPage.isDashboardPageDisplayed(), "Dashboard page should be displayed");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
