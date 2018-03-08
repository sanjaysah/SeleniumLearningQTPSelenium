package com.qtpselenium.selenium.TV9Part2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterizingDataInTCTestNG {
	
	@Test(dataProvider="getData")
	public void doLogintest(String username,String password,String browser, String OS){
		System.out.println(username+" "+password+" "+browser+" "+OS);
	}
	
	@DataProvider//(parallel=true)
	public Object[][] getData(){
		Object[][] data = new Object[3][4];
		//initialize data into object array.
		//1st Row
		data[0][0]="U1";
		data[0][1]="P1";
		data[0][2]="Mozilla";
		data[0][3]="Windows";
		
		//2nd Row
		data[1][0]="U2";
		data[1][1]="P2";
		data[1][2]="Chrome";
		data[1][3]="Linux";
		
		//3rd Row
		data[2][0]="U3";
		data[2][1]="P3";
		data[2][2]="IE";
		data[2][3]="Ubuntu";
		
		return data;
	}
	
}
