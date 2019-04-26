package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestKeyboardAction {

	@Test
	public void testkeyboard()
	{

		WebDriver driver=Driverutility.getDriver("chrome");
		driver.get("http://10.232.237.143:443/TestMeApp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement search = driver.findElement(By.id("myInput"));
		Actions ac=new Actions(driver);
		ac.keyDown(search,Keys.SHIFT).perform();
		ac.sendKeys("b").pause(3000).sendKeys("a").pause(3000).sendKeys("g").perform();
		ac.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Hand bag')]"))).click().perform();
		driver.findElement(By.cssSelector("input[value='FIND DETAILS']")).click();
		String result= driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[1]/center[1]/h4")).getText();
		Assert.assertTrue(result.contains("Hand bag"));







	}

}
