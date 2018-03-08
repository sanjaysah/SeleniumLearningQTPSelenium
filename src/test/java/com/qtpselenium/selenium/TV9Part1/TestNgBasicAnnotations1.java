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

public class TestNgBasicAnnotations1 {
	
	/*@BeforeMethod
	public void bmethod(){
		System.out.println("Before Method TestNgBasicAnnotations1");
	}
	
	@AfterMethod
	public void amethod(){
		System.out.println("After Method TestNgBasicAnnotations1");
	}
	
	@BeforeClass
	public void bclass(){
		System.out.println("Before Class TestNgBasicAnnotations1");
	}
	
	@AfterClass
	public void aclass(){
		System.out.println("After Class TestNgBasicAnnotations1");
	}
	
	@BeforeTest
	public void beforetest(){
		System.out.println("Before Test TestNgBasicAnnotations1");
	}
	
	@AfterTest
	public void aftertest(){
		System.out.println("After Test TestNgBasicAnnotations1");
	}
	
	@BeforeSuite
	public void bsuite(){
		System.out.println("Before Suite TestNgBasicAnnotations1");
	}
	
	@AfterSuite
	public void asuite(){
		System.out.println("After Suite TestNgBasicAnnotations1");
	}*/
	
	@Test//(priority=1)
	public void ztest(){
		//Assert.assertFalse(3<4, "AssertFalse returned true");
		System.out.println("ztest TestNgBasicAnnotations1 "+ Thread.currentThread().getId());
	}
	
	@Test//(priority=2, dependsOnMethods={"btest"})
	public void atest(){
		System.out.println("atest TestNgBasicAnnotations1 "+ Thread.currentThread().getId());
	}
	
	@Test//(priority=3, dependsOnMethods={"btest","ztest"})
	public void jtest(){
		System.out.println("jtest TestNgBasicAnnotations1 "+ Thread.currentThread().getId());
	}
	
	@Test//(priority=4)
	public void btest(){
		//Assert.assertTrue(3>4, "AssertTrue returned false");
		System.out.println("btest TestNgBasicAnnotations1 "+ Thread.currentThread().getId());
	}
}
