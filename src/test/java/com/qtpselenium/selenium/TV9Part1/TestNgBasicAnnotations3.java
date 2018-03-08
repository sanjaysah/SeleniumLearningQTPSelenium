package com.qtpselenium.selenium.TV9Part1;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasicAnnotations3 {
	
/*	@BeforeMethod
	public void bmethod(){
		System.out.println("Before Method TestNgBasicAnnotations3");
	}
	
	@AfterMethod
	public void amethod(){
		System.out.println("After Method TestNgBasicAnnotations3");
	}
	
	@BeforeClass
	public void bclass(){
		System.out.println("Before Class TestNgBasicAnnotations3");
	}
	
	@AfterClass
	public void aclass(){
		System.out.println("After Class TestNgBasicAnnotations3");
	}
	
	@BeforeTest
	public void beforetest(){
		System.out.println("Before Test TestNgBasicAnnotations3");
	}
	
	@AfterTest
	public void aftertest(){
		System.out.println("After Test TestNgBasicAnnotations3");
	}
	
	@BeforeSuite
	public void bsuite(){
		System.out.println("Before Suite TestNgBasicAnnotations3");
	}
	
	@AfterSuite
	public void asuite(){
		System.out.println("After Suite TestNgBasicAnnotations3");
	}
*/	
	@Test//(priority=1)
	public void xtest(){
		//Assert.assertFalse(3<4, "AssertFalse returned true");
		System.out.println("xtest TestNgBasicAnnotations3 "+ Thread.currentThread().getId());
	}
	
	@Test//(dependsOnMethods={"ftest"})//priority=2, 
	public void etest(){
		System.out.println("etest TestNgBasicAnnotations3 "+ Thread.currentThread().getId());
	}
	
	@Test//(dependsOnMethods={"ftest","xtest"})//priority=3, 
	public void ltest(){
		System.out.println("ltest TestNgBasicAnnotations3 "+ Thread.currentThread().getId());
	}
	
	@Test//(priority=4)
	public void ftest(){
		//Assert.assertTrue(3>4, "AssertTrue returned false");
		System.out.println("ftest TestNgBasicAnnotations3 "+ Thread.currentThread().getId());
	}
}
