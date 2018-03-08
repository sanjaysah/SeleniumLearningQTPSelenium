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

public class TestNgBasicAnnotations2 {
	
/*	@BeforeMethod
	public void bmethod(){
		System.out.println("Before Method TestNgBasicAnnotations2");
	}
	
	@AfterMethod
	public void amethod(){
		System.out.println("After Method TestNgBasicAnnotations2");
	}
	
	@BeforeClass
	public void bclass(){
		System.out.println("Before Class TestNgBasicAnnotations2");
	}
	
	@AfterClass
	public void aclass(){
		System.out.println("After Class TestNgBasicAnnotations2");
	}
	
	@BeforeTest
	public void beforetest(){
		System.out.println("Before Test TestNgBasicAnnotations2");
	}
	
	@AfterTest
	public void aftertest(){
		System.out.println("After Test TestNgBasicAnnotations2");
	}
	
	@BeforeSuite
	public void bsuite(){
		System.out.println("Before Suite TestNgBasicAnnotations2");
	}
	
	@AfterSuite
	public void asuite(){
		System.out.println("After Suite TestNgBasicAnnotations2");
	}
*/	
	@Test//(priority=1)
	public void ytest(){
		//Assert.assertFalse(3<4, "AssertFalse returned true");
		System.out.println("ytest TestNgBasicAnnotations2 "+ Thread.currentThread().getId());
	}
	
	@Test//(dependsOnMethods={"dtest"})//priority=2, 
	public void ctest(){
		System.out.println("ctest TestNgBasicAnnotations2 "+ Thread.currentThread().getId());
	}
	
	@Test//(dependsOnMethods={"dtest","ytest"})//priority=3, 
	public void ktest(){
		System.out.println("ktest TestNgBasicAnnotations2 "+ Thread.currentThread().getId());
	}
	
	@Test//(priority=4)
	public void dtest(){
		//Assert.assertTrue(3>4, "AssertTrue returned false");
		System.out.println("dtest TestNgBasicAnnotations2 "+ Thread.currentThread().getId());
	}
}
