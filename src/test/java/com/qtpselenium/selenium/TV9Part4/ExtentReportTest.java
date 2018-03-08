package com.qtpselenium.selenium.TV9Part4;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportTest {
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test;
	SoftAssert softAst= new SoftAssert();
	
	@AfterMethod
	public void aftermethod(){
		rep.endTest(test);//must write this statement for extent report to log properly(stucks at softassret/assert)
		rep.flush();//must write this statement for extent report to log properly(stucks at softassret/assert)
	}
	
	@Test
	public void doLogin(){
		//softAst = new SoftAssert();
		test = rep.startTest("doLogin");
		test.log(LogStatus.INFO, "Login Test Case Start");
		try{
			softAst.assertEquals("expected", "expected");//actual,expected
			softAst.assertAll();
			test.log(LogStatus.INFO, "Login Test Case End");
		}catch(Throwable e){
			test.log(LogStatus.FAIL, "Login Test Case Ends with failures");
			//e.getMessage();
		}
	}
	
	@Test
	public void goHome(){
		//softAst = new SoftAssert();
		test = rep.startTest("goHome");
		test.log(LogStatus.INFO, "Home Test Case Start");
		try{
			softAst.assertFalse(3<4, "Returned true expected false");
			softAst.assertAll();
			test.log(LogStatus.INFO, "Home Test Case End");
		}catch(Throwable e){
			test.log(LogStatus.FAIL, "Home Test Case Ends with failures");
			//e.getMessage();
		}
	}
	
	@Test
	public void goAccount(){
		//softAst = new SoftAssert();
		test = rep.startTest("goAccount");
		test.log(LogStatus.INFO, "Account Test Case Start");
		try{
			softAst.assertTrue(3>4, "Returned False expected true");
			softAst.assertAll();
			test.log(LogStatus.INFO, "Account Test Case Ends");
		}catch(Throwable e){
			//e.getMessage();
			test.log(LogStatus.FAIL, "Account Test Case Ends with failures");
		}
	}

}
