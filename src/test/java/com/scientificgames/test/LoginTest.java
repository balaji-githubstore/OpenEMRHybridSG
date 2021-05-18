package com.scientificgames.test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.scientificgames.base.WebDriverWrapper;
import com.scientificgames.pages.DashboardPage;
import com.scientificgames.pages.LoginPage;
import com.scientificgames.utilities.DataProviderUtils;

public class LoginTest extends WebDriverWrapper {
	
	@Test(dataProvider = "validCredentialData",dataProviderClass = DataProviderUtils.class)
	public void validCredentialTest(String username, String password, String language, String expectedValue) {
		LoginPage.enterUsername(driver, username);
		LoginPage.enterPassword(driver, password);
		LoginPage.selectLanguageByText(driver, language);
		LoginPage.clickOnLogin(driver);

		DashboardPage.waitForPresenceOfLogout(driver);

		Assert.assertEquals(DashboardPage.getCurrentTitle(driver), expectedValue);
		Reporter.log("completed validCredentialData");
	}

	@Test(dataProvider = "dataProvider",dataProviderClass = DataProviderUtils.class)
	public void invalidCredentialTest(String username, String password, String language, String expectedValue) {
		LoginPage.enterUsername(driver, username);
		LoginPage.enterPassword(driver, password);
		LoginPage.selectLanguageByText(driver, language);
		LoginPage.clickOnLogin(driver);
		Assert.assertEquals(LoginPage.getLoginErrorMessage(driver), expectedValue);
		Reporter.log("completed invalidCredentialTest");
	}
	
	
}





