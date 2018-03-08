package SuiteA;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestA2 {
	
	@Test
	public void testA2_1(){
		System.out.println("- "+this.getClass().getName()+" -");
		throw new SkipException(this.getClass().getName()+" -  TC Skipped");
	}
	
	@Test
	public void testA2_2(){
		System.out.println("- "+this.getClass().getName()+" -");
	}
	
	@Test
	public void testA2_3(){
		System.out.println("- "+this.getClass().getName()+" -");
	}
	
}
