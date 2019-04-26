package com.tests;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Sample1 {
	WebDriver driver;
	ExtentHtmlReporter htmlreporter;
	ExtentTest logger;
	ExtentReports reports;



	@BeforeClass
	public void beforeClass() {




		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-ms");
		String path=System.getProperty("user.dir")+"/extent-reports/"+sdf.format(new Date())+".html";

		htmlreporter=new ExtentHtmlReporter(path);
		reports=new ExtentReports();
		reports.attachReporter(htmlreporter);
		reports.setSystemInfo("Username", "battula.devakeeswar");
		reports.setSystemInfo("host", "localhost");
		reports.setSystemInfo("Environment", "Test Environment");
		htmlreporter.config().setReportName("Test Me App Report");
		htmlreporter.config().setTheme(Theme.DARK);


		driver=Driverutility.getDriver("chrome");
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@Test(priority=1)
	public void testRegistration() throws  InterruptedException{

		driver.findElement(By.partialLinkText("SignUp")).click();

		driver.findElement(By.id("userName")).sendKeys("ravimal");
		//	Assert.assertEquals(driver.findElement(By.id("err")).getText(),"Available");
		driver.findElement(By.id("firstName")).sendKeys("RAVIKUMAR");
		driver.findElement(By.id("lastName")).sendKeys("MALI");
		driver.findElement(By.id("password")).sendKeys("RAVI1996");
		driver.findElement(By.id("pass_confirmation")).sendKeys("RAVI1996");
		driver.findElement(By.cssSelector("input[value='Male']")).click();

		driver.findElement(By.id("emailAddress")).sendKeys("ravikumarmalik@gamil.com");
		driver.findElement(By.id("mobileNumber")).sendKeys("1234567890");
		driver.findElement(By.cssSelector("img[src='images/calendar.png']")).click();
		Select bmonth=new Select(driver.findElement(By.className("ui-datepicker-month")));
		bmonth.selectByVisibleText("Apr");
		Select byear=new Select(driver.findElement(By.className("ui-datepicker-year")));
		byear.selectByVisibleText("1996");
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[2]/a")).click();
		Thread.sleep(300);
		driver.findElement(By.id("address")).sendKeys("malali malali");
		driver.findElement(By.id("securityQuestion")).click();
		driver.findElement(By.id("answer")).sendKeys("Malali");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[value='Register']")).click();
		/*String text2=driver.findElement(By.xpath("//from@role='form'/fieldset/div[8]")).getText();
		Assert.assertEquals(text2, " USERNAME already exists.. please register again with different USERNAME..");
		String title=driver.getTitle();
		Assert.assertEquals(title,"login");
		*/System.out.println("registatraition successful");
		logger=reports.createTest("Registation page");
		logger.log(Status.INFO,"pass test started");
		/*String regsuccess=driver.findElement(By.xpath("//from@role='form'/fieldset/div[8]")).getText();
		Assert.assertTrue(true);*/

	}
	//--------------------------------------------------------------------------------------------------------------//	

	@Test(priority=2)
	public void testLogin()
	{
		WebDriverWait wait=new WebDriverWait(driver,500);

		driver.findElement(By.id("userName")).sendKeys("lalitha");
		driver.findElement(By.id("password")).sendKeys("Password123");

		driver.findElement(By.cssSelector("input[value='Login']")).click();


	}
	//----------------------------------------------------------------------------------------------------------//

	@Test(priority=3)
	public void testCart() 
	{
		Actions act1=new  Actions(driver);
		act1.moveToElement(driver.findElement(By.partialLinkText("All Categories"))).perform();
		act1.moveToElement(driver.findElement(By.partialLinkText("Electronics"))).click().perform();
		act1.moveToElement(driver.findElement(By.partialLinkText("Head Phone"))).click().perform();

		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
		logger=reports.createTest("cart");
		logger.log(Status.INFO,"product is added");
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[5]/a")).click();
		driver.findElement(By.xpath("/html/body/b/div/div/div[1]/div/div[2]/div[3]/div/form[2]/input")).click();



	}	

	//--------------------------------------------------------------------------------------------------------------//
	@Test(priority=4)
	public void tesPayment() throws InterruptedException
	{	


		driver.findElement(By.xpath("//*[@id=\"swit\"]/div[1]/div/label")).click();
		driver.findElement(By.cssSelector("a[id='btn']")).click();
		logger=reports.createTest("payment");
		logger.log(Status.INFO,"bank added");


		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("123456");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Pass@456");
		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();

		driver.findElement(By.cssSelector("input[value='PASSWORD']")).sendKeys("Trans@456");
		driver.findElement(By.cssSelector("input[value='PayNow']")).click();
		logger=reports.createTest("paymentStatus");
	logger.log(Status.INFO,"payment processed");


		String texts=driver.findElement(By.xpath("/html/body/b/section/div/div/div/div[2]/p")).getText();
		Assert.assertEquals(texts, "Your order has been confirmed");
		String title1=driver.getTitle();
		Assert.assertEquals(title1,"Order Details");
		System.out.println("Order Details");
		driver.findElement(By.linkText("Home")).click();


	}
	//-----------------------------------------------------------------------------------------------------------//

	@AfterMethod
	public void afterMethod(ITestResult result)

	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(Status.FAIL,"THE TEST IS FAILED");
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.log(Status.PASS,"THE TEST IS PASSED");
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.log(Status.SKIP,"THE TEST IS SKIPPED");
		}
	}

	@AfterClass
	public void afterClass()
	{
		reports.flush();
	driver.close();
	}
}







