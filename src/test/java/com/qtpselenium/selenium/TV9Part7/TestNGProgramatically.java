package com.qtpselenium.selenium.TV9Part7;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.collections.Lists;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class TestNGProgramatically {

	public static void main(String[] args) {
		//same as creating main testNg.xml file
		TestNG testng = new TestNG();
		//3 suites or 3 diff testng.xml file each having one suite
		XmlSuite suiteAD = new XmlSuite();
		suiteAD.setName("SuiteAD");
		XmlSuite suiteBC = new XmlSuite();
		suiteBC.setName("SuiteBC");
		XmlSuite suiteEF = new XmlSuite();
		suiteEF.setName("SuiteEF");
		
		XmlTest testAD = new XmlTest(suiteAD);
		testAD.setName("TestAD");
		XmlClass classA = new XmlClass("com.qtpselenium.selenium.TV9Part7.TestA");
		XmlClass classD = new XmlClass("com.qtpselenium.selenium.TV9Part7.TestD");
		List<XmlClass> myClasses = new ArrayList<XmlClass>();
		myClasses.add(classA);
		myClasses.add(classD);
		testAD.setXmlClasses(myClasses);
		
		List<XmlTest> mytestsAD = new ArrayList<XmlTest>();
		mytestsAD.add(testAD);
		//mytests.add(testB);
		
		suiteAD.setTests(mytestsAD);
		
		
		XmlTest testBC = new XmlTest(suiteBC);
		testBC.setName("TestBC");
		XmlClass classB = new XmlClass("com.qtpselenium.selenium.TV9Part7.TestB");
		XmlClass classC = new XmlClass("com.qtpselenium.selenium.TV9Part7.TestC");
		myClasses = new ArrayList<XmlClass>();
		myClasses.add(classB);
		myClasses.add(classC);
		testBC.setXmlClasses(myClasses);
		
		List<XmlTest> mytestsBC = new ArrayList<XmlTest>();
		mytestsBC.add(testBC);
		//mytests.add(testB);
		
		suiteBC.setTests(mytestsBC);
		
		XmlTest testEF = new XmlTest(suiteEF);
		testEF.setName("TestEF");
		XmlClass classE = new XmlClass("com.qtpselenium.selenium.TV9Part7.TestE");
		XmlClass classF = new XmlClass("com.qtpselenium.selenium.TV9Part7.TestF");
		myClasses = new ArrayList<XmlClass>();
		myClasses.add(classE);
		myClasses.add(classF);
		testBC.setXmlClasses(myClasses);
		
		List<XmlTest> mytestsEF = new ArrayList<XmlTest>();
		mytestsEF.add(testEF);
		//mytests.add(testB);
		
		suiteEF.setTests(mytestsEF);
		
		/*XmlTest testCD = new XmlTest(suiteCD);
		testCD.setName("TestCD");
		XmlClass testC = new XmlClass("com.qtpselenium.selenium.TV9Part7.testC");
		XmlClass testD = new XmlClass("com.qtpselenium.selenium.TV9Part7.testD");
		List<XmlClass> myClassesCD = new ArrayList<XmlClass>();
		myClassesCD.add(testC);
		myClassesCD.add(testD);
		testCD.setClasses(myClassesCD);
		suiteCD.addTest(testCD);
		
		XmlTest testEF = new XmlTest(suiteEF);
		testEF.setName("TestEF");
		XmlClass testE = new XmlClass("com.qtpselenium.selenium.TV9Part7.testE");
		XmlClass testF = new XmlClass("com.qtpselenium.selenium.TV9Part7.testF");
		List<XmlClass> myClassesEF = new ArrayList<XmlClass>();
		myClassesEF.add(testE);
		myClassesEF.add(testF);
		testEF.setClasses(myClassesEF);
		suiteEF.addTest(testEF);*/
		
		List<XmlSuite> mysuites = new ArrayList<XmlSuite>();
		mysuites.add(suiteAD);
		//mysuites.add(suiteBC);//multiple suites not working
		//mysuites.add(suiteEF);//multiple suites not working
		
		testng.setXmlSuites(mysuites);
		
		testng.run();
		
	}

}
