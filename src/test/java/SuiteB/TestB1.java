package SuiteB;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qtpselenium.selenium.TV9Part56.ErrorUtil;

public class TestB1 {
	
	@Test
	public void testB1_1(){
		System.out.println("- "+this.getClass().getName()+" -");
		try{
			Assert.assertEquals("xxxx", "yyyy");
		}catch(Throwable t){
			System.out.println("Error");
		//write some listener code to fail this TC else using TryCatch block passes the TC even if assertion fails
			ErrorUtil.addVerificationFailure(t);
		}
	}
	
	@Test
	public void testB1_2(){
		System.out.println("- "+this.getClass().getName()+" -");
	}
	
	@Test
	public void testB1_3(){
		System.out.println("- "+this.getClass().getName()+" -");
	}

}
