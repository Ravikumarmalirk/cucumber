package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Registraition_page
{
	
	WebDriver driver;
	
	@Test
	public void  Reg_page() throws InterruptedException
	{
	WebDriver driver=Driverutility.getDriver("chrome");
	
	driver.get("http://10.232.237.143:443/TestMeApp/RegisterUser.htm");
	driver.manage().window().maximize();
	
	
	driver.findElement(By.id("userName")).sendKeys("rav");
	//String text=driver.findElement(By.id("err")).getText();
	//Assert.assertEquals(text,"New");
	
		
			
	
		
		
		
		
		driver.findElement(By.id("firstName")).sendKeys("RAVIe");
		driver.findElement(By.id("lastName")).sendKeys("MALIe");
		
		driver.findElement(By.cssSelector("input[data-validation-length='6-15']")).sendKeys("abc123");
		
		driver.findElement(By.id("pass_confirmation")).sendKeys("abc123");
		driver.findElement(By.cssSelector("input[value='Male']")).click();
		
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("ravikumarmalirk@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Mobile Number']")).sendKeys("8105825262");
		
		
		driver.findElement(By.className("ui-datepicker-trigger")).click();
		
		Select month=new  Select(driver.findElement(By.className("ui-datepicker-month")));
		month.selectByIndex(5);
		Select year=new Select(driver.findElement(By.className("ui-datepicker-year")));
		year.selectByValue("1996");
		
		driver.findElement(By.linkText("5")).click();
		Select ques=new  Select(driver.findElement(By.id("securityQuestion")));
		ques.selectByIndex(0);

		
		driver.findElement(By.id("address")).sendKeys("malali mudhol");
		driver.findElement(By.id("answer")).sendKeys("malali");
		
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("input[value='Register']")).click();
		
		
	
	}
}
			
	
		


