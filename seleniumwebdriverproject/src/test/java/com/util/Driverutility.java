package com.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driverutility {

	public static WebDriver getDriver(String browser)

	{
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\project\\chromedriver.exe");
			return new ChromeDriver();

		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webDriver.gecko.driver","C:\\project\\geckodriver.exe");
			return new FirefoxDriver();
		}
		else if(browser.equals("ie"))
		{
			System.setProperty("webDriver.ie.driver","C:\\project\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		else 
			return null;
	}


}


