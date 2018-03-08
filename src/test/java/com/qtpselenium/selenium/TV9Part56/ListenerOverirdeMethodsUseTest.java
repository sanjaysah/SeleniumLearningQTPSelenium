package com.qtpselenium.selenium.TV9Part56;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ListenerOverirdeMethodsUseTest {
	
	@Test
	public void testA(){
		System.out.println("testA starts");
		System.out.println("testA ends");
	}
	
	@Test
	public void testB(){
		System.out.println("testB starts");
		//Assert.fail("TestB failed");
//Using try catch block, lets the statement run written after assertion statement but it passes the test case in result - issue
		try{
			Assert.fail("TestB failed");//.assertFalse(3<4, "Test Failed");
		}catch(Throwable t){
			System.out.println("Error");
		//write some listener code to fail this TC else using TryCatch block passes the TC even if assertion fails
			ErrorUtil.addVerificationFailure(t);
		}
		System.out.println("testB ends");
	}
	
	@Test//(enabled=false)
	public void testC(){
		System.out.println("testC starts");
		//using try catch block, in result TC is not shown skipped
		/*try{*/
			throw new SkipException("TestC Skipped");
		/*}catch(Throwable e){
			e.getMessage();
		}*/
		//after skipException is thrown, no statement is accepted by compiler, unreachable code error
		//System.out.println("testC ends");
	}

}
