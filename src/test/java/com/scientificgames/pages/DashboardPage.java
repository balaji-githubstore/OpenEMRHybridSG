package com.scientificgames.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	private static By logoutLocator=By.xpath("//*[text()='Logout']");
	private static By patientClientLocator=By.xpath("//*[text()='Patient/Client']");
	private static By patientsLocator=By.xpath("//*[text()='Patients']");
	
	public static void waitForPresenceOfLogout(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(logoutLocator));
	}
	
	public static String getCurrentTitle(WebDriver driver)
	{
		return driver.getTitle().trim();
	}
	
	public static void mouseHoverOnPatientClient(WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(patientClientLocator)).perform();
	}
	
	public static void ClickOnPatients(WebDriver driver)
	{
		driver.findElement(patientsLocator).click();
	}
}
