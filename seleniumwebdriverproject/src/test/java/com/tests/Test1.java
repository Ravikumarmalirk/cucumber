package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
	
     @Test
	public void  testgooglehomepage()
	{
	

     WebDriver driver=Driverutility.getDriver("chrome");
     driver.manage().window().maximize();
     driver.get("https://www.google.co.in");
    String title=driver.getTitle();
    Assert.assertEquals(title, "Google");
	driver.close();
	
	}

}
