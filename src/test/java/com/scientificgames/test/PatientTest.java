package com.scientificgames.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.scientificgames.base.WebDriverWrapper;
import com.scientificgames.pages.DashboardPage;
import com.scientificgames.pages.LoginPage;
import com.scientificgames.utilities.DataProviderUtils;

public class PatientTest extends WebDriverWrapper {	
	
	@Test(dataProvider = "dataProvider",dataProviderClass = DataProviderUtils.class)
	public void addPatientTest(String username, String password, String language,String firstname,String lastname,String dob,String gender,String alertExpectedValue,String expectedValue)	
	{
		LoginPage.enterUsername(driver, username);
		LoginPage.enterPassword(driver, password);
		LoginPage.selectLanguageByText(driver, language);
		LoginPage.clickOnLogin(driver);	
		
		DashboardPage.mouseHoverOnPatientClient(driver);
		DashboardPage.ClickOnPatients(driver);
		
		//PatientFinderPage
		driver.switchTo().frame("fin");
		driver.findElement(By.id("create_patient_btn1")).click();
		driver.switchTo().defaultContent();
		
		//SearchOrAddPatientPage
		driver.switchTo().frame("pat");
		driver.findElement(By.id("form_fname")).sendKeys(firstname);
		driver.findElement(By.id("form_lname")).sendKeys(lastname);
		driver.findElement(By.id("form_DOB")).sendKeys(dob);
		Select selectGender=new Select(driver.findElement(By.id("form_sex")));
		selectGender.selectByVisibleText(gender);
		driver.findElement(By.id("create")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'popup')]")));
		driver.findElement(By.xpath("//*[@value='Confirm Create New Patient']")).click();
		driver.switchTo().defaultContent();
		
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.alertIsPresent());
		
		String actualValue1=driver.switchTo().alert().getText();
		System.out.println(actualValue1);
		
		Assert.assertTrue(actualValue1.contains(alertExpectedValue)); //expected value --> true
		
		//Assert.assertEquals(actualValue1.contains("Assessment: Tobacco"), true);
		
		driver.switchTo().alert().accept();
		if(driver.findElements(By.xpath("//*[@class='closeDlgIframe']")).size()>0)
		{
			driver.findElement(By.xpath("//*[@class='closeDlgIframe']")).click();
		}
		
		//MedicalRecordDashboardPage
		driver.switchTo().frame("pat");
		String actualValue2=driver.findElement(By.xpath("//*[contains(text(),'Medical Record')]")).getText();
		System.out.println(actualValue2);
		
		//assertion 2
		Assert.assertEquals(actualValue2, expectedValue);
		
		driver.switchTo().defaultContent();
	}

}
