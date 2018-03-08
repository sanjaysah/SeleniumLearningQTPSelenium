package SuiteB;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.qtpselenium.selenium.TV9Part56.ErrorUtil;

public class TestB2 {
	
	@Test
	public void testB2_1(){
		System.out.println("- "+this.getClass().getName()+" -");
	}
	
	@Test
	public void testB2_2(){
		System.out.println("- "+this.getClass().getName()+" -");
		throw new SkipException(this.getClass().getName()+" -  TC Skipped");
	}
	
	@Test
	public void testB2_3(){
		System.out.println("- "+this.getClass().getName()+" -");
		try{
			Assert.assertEquals("xxxx", "yyyy");
		}catch(Throwable t){
			System.out.println("Error");
		//write some listener code to fail this TC else using TryCatch block passes the TC even if assertion fails
			ErrorUtil.addVerificationFailure(t);
		}
	}
	
}
