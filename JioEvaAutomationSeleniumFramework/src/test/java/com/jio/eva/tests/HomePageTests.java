package com.jio.eva.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jio.eva.dataprovider.DataProviderWithExcel;
import com.jio.eva.pages.DashboardPage;
import com.jio.eva.pages.HeadersSection;
import com.jio.eva.pages.HeadersSection.HeaderIcons;
import com.jio.eva.pages.HomePage;
import com.jio.eva.pages.HomePage.HeaderElements;
import com.jio.eva.pages.LoginPage;
import com.jio.eva.pages.LoginPage.LoginFormElements;
import com.jio.eva.reports.ExtentLogger;
import com.jio.eva.utils.ReadPropertyFile;

public final class HomePageTests extends BaseTest{

	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	HeadersSection headerSection;


	private HomePageTests() {
	}

	@BeforeMethod
	public void setUp()
	{
		homePage = new HomePage();
	}


	@Test ()
	public void HomePageTest()
	{
		System.out.println("***** This is Home Page Test Case ***** ");
		
		/*		try {
			// Verify title
			String actualTitle = homePage.getHomePageTitle();
			String expectedTitle = "Engage Video Assistant | Telephony Bot | Jio";
			Assert.assertEquals(actualTitle, expectedTitle, "Expected title of Home page should be '"+expectedTitle+"'");
			ExtentLogger.pass("Expected title of Home page should be '"+expectedTitle+"'");

			// verify url
			String actualUrl = homePage.getHomePageUrl();
			String expectedUrl = ReadPropertyFile.get("url");
			Assert.assertEquals(actualUrl, expectedUrl, "Expected url of Home page should be '"+expectedUrl+"'");
			ExtentLogger.pass("Expected url of Home page should be '"+expectedUrl+"'");

			// verify app logo
			Assert.assertTrue(homePage.isHeaderElementDisplayed(HeaderElements.jioEvaLogo), "Jio Eva logo should be displayed on Home page");
			ExtentLogger.pass("Jio Eva logo should be displayed on Home page", true);

			// verify Login button
			Assert.assertTrue(homePage.isHeaderElementDisplayed(HeaderElements.LoginBtn), "Login button should be displayed on Home page");
			ExtentLogger.pass("Login button should be displayed on Home page", true);

		} catch (Exception e) {
			e.printStackTrace();
//			ExtentLogger.fail(e.toString(), true);
		} */
	}

	@Test(
			//dataProvider = "getData", dataProviderClass = DataProviderWithExcel.class
			)
	//public void Login(Map<String, String> data)
	public void Login()
	{
		System.out.println("***** This is Login Test Case ***** ");

		/*		try {
			// navigate to login page
			loginPage = homePage.navigateToLoginPage();

			// verify login page title
			String actualTitle = loginPage.getLoginPageTitle();
			Assert.assertEquals(actualTitle, "Engage Video Assistant");
			ExtentLogger.pass("Login page title should be displayed as : Engage Video Assistant");

			// verify login page url
			String actualUrl = loginPage.getLoginPageUrl();
			Assert.assertEquals(actualUrl, ReadPropertyFile.get("loginPageUrl"));
			ExtentLogger.pass("Login page url should be: " + ReadPropertyFile.get("loginPageUrl"));

			// Thread.sleep(5000);

			// verify login form is displayed
			Assert.assertTrue(loginPage.isLoginFormExists(), "Login form should be displayed");
			ExtentLogger.pass("Login form should be displayed", true);

			// verify emailId field is displayed
			Assert.assertTrue(loginPage.isElementExists(LoginFormElements.emailIdField, true), "EmailId field should be displayed");
			ExtentLogger.pass("EmailId field should be displayed", true);

			// verify pwd field is displayed
			Assert.assertTrue(loginPage.isElementExists(LoginFormElements.pwdField, false), "Password field should be displayed");
			ExtentLogger.pass("Password field should be displayed", true);

			// verify otp field is not displayed
			Assert.assertFalse(loginPage.isElementExists(LoginFormElements.otpField, false), "OTP field should not be displayed");
			ExtentLogger.pass("OTP field should not be displayed", true);

			// verify Sign in button is displayed
			Assert.assertTrue(loginPage.isElementExists(LoginFormElements.signInBtn, true), "Sign in button should be displayed");
			ExtentLogger.pass("Sign in button should be displayed", true);

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
			ExtentLogger.pass("Dashboard page title should be displayed as : Engage Video Assistant");

			// verify dashboard url
			actualUrl = dashboardPage.getDashboardPageUrl();
			Assert.assertEquals(actualUrl, ReadPropertyFile.get("dashboardPageUrl"));
			ExtentLogger.pass("Dashboard page url should be: " + ReadPropertyFile.get("dashboardPageUrl"));

			// verify dashboard page is displayed
			Assert.assertTrue(dashboardPage.isDashboardPageDisplayed(), "Dashboard page should be displayed");
			ExtentLogger.pass("Dashboard page should be displayed", true);

		} catch (Exception e) {
			e.printStackTrace();
	//		ExtentLogger.fail(e.toString(), true);
		}	*/
	}

	@Test(
	// dependsOnMethods = {"Login"}
			)
	public void ModelCreation() {
		System.out.println("***** This is model creation test case *****");
	}

	@Test(
		//				dependsOnMethods = {"Login"}
			)
	public void AddNewUser() {
		System.out.println("***** This is add new user test case *****");
	}

	@Test(
		//	dependsOnMethods = {"Login"}
			)
	public void Logout()
	{
		System.out.println("***** This is Logout Test Case ***** ");

		/*		try {
			headerSection = new HeadersSection();

			// verify user logged in 
			Assert.assertTrue(headerSection.isIconDisplayed(HeaderIcons.evaProductIcon, true), "Product icon should be displayed");
			ExtentLogger.pass("Product icon should be displayed", true);
			Assert.assertTrue(headerSection.isIconDisplayed(HeaderIcons.notificationIcon, false), "Notification icon should be displayed");
			ExtentLogger.pass("Notification icon should be displayed", true);
			Assert.assertTrue(headerSection.isIconDisplayed(HeaderIcons.userIcon, false), "User icon should be displayed");
			ExtentLogger.pass("User icon should be displayed", true);

			// Signout
			headerSection.signOut();

			// verify login page title
			String actualTitle = loginPage.getLoginPageTitle();
			Assert.assertEquals(actualTitle, "Engage Video Assistant");
			ExtentLogger.pass("Login page title should be displayed as : Engage Video Assistant", true);

			// verify login page url
			loginPage = new LoginPage();
			String actualUrl = loginPage.getLoginPageUrl();
			Assert.assertEquals(actualUrl, ReadPropertyFile.get("loginPageUrl"));
			ExtentLogger.pass("Login page url should be: " + ReadPropertyFile.get("loginPageUrl"), true);

			// navigate to home page
			headerSection.navigateToHomePage();

		} catch (Exception e) {
			e.printStackTrace();
	//		ExtentLogger.fail(e.toString(), true);
		}	*/
	}

}
