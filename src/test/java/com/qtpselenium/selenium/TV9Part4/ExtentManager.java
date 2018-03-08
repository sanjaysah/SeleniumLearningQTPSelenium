package com.qtpselenium.selenium.TV9Part4;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	private static ExtentReports extent;
	//path where reports are created by ExtentReports object created in getInstance() method
	static String reportPath=System.getProperty("user.dir")+"\\target\\report.html";
//this method will create extent reports class which actually will create report as per reportsConfig.xml and return the Ereport object
	public static ExtentReports getInstance(){
		//If ExtentReports object is not created, create a new one, load ReportsConfig.xml to it.
		if(extent==null){
			extent = new ExtentReports(reportPath, true, DisplayOrder.NEWEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\ReportsConfig.xml"));
			//Optional add system, selenium information to be shown in reports
			extent.addSystemInfo("Selenium Version", "3.9.0").addSystemInfo("Environment","QA").addSystemInfo("OS","Windows10");
		}
//return ExtentReports object back, so that loggin reporting can be done where this method getInstance() is called
		return extent;
	}

}
