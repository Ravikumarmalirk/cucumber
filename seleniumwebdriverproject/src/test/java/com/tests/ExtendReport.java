package com.tests;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReport {

 WebDriver driver;
 ExtentHtmlReporter htmlreporter;
 ExtentReports reports;
 ExtentTest logger;
 
 
 @BeforeClass
 public void beforeClass()
 {
 
  
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
  
  
  
 }
 
 
 @Test
 public void passTest()
 {
  logger=reports.createTest("passTest");
  logger.log(Status.INFO,"pass test started");
  Assert.assertTrue(true);
 }
 
 @Test
 public void failTest()
 {
  logger=reports.createTest("failTest");
  logger.log(Status.INFO,"fail test started");
  Assert.assertTrue(false);
 }
 
 @Test
 public void skipTest()
 {
  logger=reports.createTest("skipTest");
  logger.log(Status.INFO,"skip test started");
  throw new SkipException("SKIP");
 }
 
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
 }
 
 
 
 
}
                   
 