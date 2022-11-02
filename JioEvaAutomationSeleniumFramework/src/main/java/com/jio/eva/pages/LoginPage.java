package com.jio.eva.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.Uninterruptibles;
import com.jio.eva.constants.FrameworkConstants;
import com.jio.eva.driver.DriverManager;
import com.jio.eva.utils.GMail;

public final class LoginPage extends BasePage {

	//region WebElements

	private final By appLoginFom = By.tagName("app-login");
	private final By emailIdFld = By.cssSelector("input#mat-input-0");
	private final By pwdFld = By.cssSelector("input#mat-input-1");
	private final By signInBtn = By.cssSelector("button.btn-actions-sign-in");
	private final By otpFld = By.cssSelector("input#mat-input-2");

	//endregion


	//region Page Methods
	public String getLoginPageTitle()
	{
		return getPageTitle();
	}

	public String getLoginPageUrl()
	{
		return getPageURL();
	}

	public boolean isLoginFormExists()
	{
		return isDisplayed(appLoginFom, true);
	}

	public boolean isElementExists(LoginFormElements loginFormElement, boolean toWait)
	{
		try {
			switch (loginFormElement) {
			case emailIdField:
				return isDisplayed(emailIdFld, toWait);	
			case pwdField:
				return isDisplayed(pwdFld, toWait);	
			case otpField:
				return isDisplayed(otpFld, toWait);	
			case signInBtn:
				return isDisplayed(signInBtn, toWait);
			default:
				return false;
			}
		} catch (Exception e) {
			System.out.println(loginFormElement + " element is not displayed");
			//e.printStackTrace();
		}
		return false;
	}

	public DashboardPage login(String userName, String password, String subject)
	{
		try {
			System.out.println("App credentials: " + userName + "/" + password);
			sendKeys(emailIdFld, userName);
			sendKeys(pwdFld, password);

			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait()));
			wait.until(d->d.findElement(signInBtn).isEnabled());		// Java 8 way

			if(isEnabled(signInBtn))
			{
				click(signInBtn);
				Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);	// instead of Thread.Sleep(10000);
				wait.until(d->d.findElement(otpFld).isDisplayed());

				// verify otp field is displayed
				// verify Sign in button is disabled
				if (isElementExists(LoginFormElements.otpField, true) && !isEnabled(signInBtn))
				{
					// fetch otp from email
					String emailBody = GMail.getEmailDetails(subject).get("body").toString();
					String otp = emailBody.substring(emailBody.indexOf("OTP"), emailBody.indexOf("Note"))	// crop/trim the content
							.replaceAll("[^0-9]", "");														// fetch digits from string

					// enter otp
					sendKeys(otpFld, otp);

					// verify Sign in button is enabled
					if (isEnabled(signInBtn))
					{
						// click on Signin button
						click(signInBtn);
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new DashboardPage();
	}

	//endregion


	//region Enums
	public enum LoginFormElements
	{
		emailIdField,
		pwdField,
		otpField,
		signInBtn
	}

	//endregion

}
