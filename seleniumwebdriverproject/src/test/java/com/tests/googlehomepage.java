package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class googlehomepage {
	@BeforeMethod
	public void  testgooglehomepage()
	{
		//System.setProperty("webdriver.gecko.driver","C:\\project\\geckodriver.exe");

		WebDriver driver=Driverutility.getDriver("chrome");
		driver.manage().window().maximize();
		driver.get("http://www.google.co.in/");
		String title=driver.getTitle();
		Assert.assertEquals(title, "Google");
		//driver.close();


	}
	@AfterMethod
	public void test()
	{
		WebDriver driver=Driverutility.getDriver("chrome");
		driver.close();
	}



	@Test
	public void testdemoWebshop()
	{

		WebDriver driver=Driverutility.getDriver("chrome");
		driver.get("http://demowebshop.tricentis.com/login");
		String url=driver.getCurrentUrl();
		Assert.assertTrue(url.contains("webshop"));
		WebElement email=driver.findElement(By.id("Email"));
		email.sendKeys("askmail@mail.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.cssSelector("input[value='log in']")).click();

	}

}


