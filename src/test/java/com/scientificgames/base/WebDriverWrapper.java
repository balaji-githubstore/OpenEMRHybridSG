package com.scientificgames.base;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class WebDriverWrapper {
	protected WebDriver driver;

	@BeforeMethod
	@Parameters({"browser","url"})
	public void setup(@Optional("ch") String browserName,@Optional("https://demo.openemr.io/b/openemr/index.php") String url)
	{
		switch (browserName.toLowerCase()) {
		case "ff":
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
			driver=new FirefoxDriver();
			break;
		case "ie":
		case "internetexplorer":
			System.setProperty("webdriver.ie.driver", "driver/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
			driver=new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 	
		driver.get(url);
	}
	
	@AfterMethod
	public void teardown(Method method)
	{
		System.out.println(method.getName());
		driver.quit();
	}

}
