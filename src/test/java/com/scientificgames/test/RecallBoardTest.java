package com.scientificgames.test;

import org.testng.annotations.Test;

import com.scientificgames.base.WebDriverWrapper;
import com.scientificgames.pages.DashboardPage;
import com.scientificgames.pages.LoginPage;
import com.scientificgames.utilities.DataProviderUtils;

public class RecallBoardTest extends WebDriverWrapper {

	@Test(dataProvider = "dataProvider",dataProviderClass = DataProviderUtils.class)
	public void appointmentBookingTest(String username, String password, String language,String patientName)
	{
//		LoginPage.enterUsername(driver, username);
//		LoginPage.enterPassword(driver, password);
//		LoginPage.selectLanguageByText(driver, language);
//		LoginPage.clickOnLogin(driver);	
//		
//		DashboardPage.mouseHoverOnPatientClient(driver);
//		DashboardPage.ClickOnPatients(driver);
	}
	
}
