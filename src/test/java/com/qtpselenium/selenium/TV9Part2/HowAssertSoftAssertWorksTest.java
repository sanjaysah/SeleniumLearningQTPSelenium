package com.qtpselenium.selenium.TV9Part2;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HowAssertSoftAssertWorksTest {
	SoftAssert softAst;
	@Test//(priority=1)
	public void asserttest1(){
		softAst = new SoftAssert();
		//Assert.assertFalse(3<4, "AssertFalse returned true");
		softAst.assertFalse(3<4, "SoftAssertFalse returned true");
		System.out.println("asserttest1 running. ");
		softAst.assertAll();
	}
	
	@Test//(dependsOnMethods={"ftest"})//priority=2, 
	public void asserttest2(){
		System.out.println("asserttest2 running. ");
	}
	
	@Test//(dependsOnMethods={"ftest","xtest"})//priority=3, 
	public void asserttest3(){
		System.out.println("asserttest3 running. ");
	}
	
	@Test//(priority=4)
	public void asserttest4(){
		softAst = new SoftAssert();
		//Assert.assertTrue(3>4, "AssertTrue returned false");
		softAst.assertTrue(3>4, "softAssertTrue returned false");
		System.out.println("asserttest1 running. ");
		softAst.assertAll();
	}
	
}
