package com.qtpselenium.selenium.TV9Part56;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.internal.Utils;
import org.testng.xml.XmlSuite;

public class CustomListener extends TestListenerAdapter implements IInvokedMethodListener, IReporter{
	
	void onTestFailed(ITestResult tr){
		System.out.println("Failed TC Name is - "+tr.getName());
	}
	
	public void onTestSkipped(ITestResult tr){
		System.out.println("Skipped TC Name is - "+tr.getName());
	}
	
	public void onTestSuccess(ITestResult tr){
		System.out.println("Passed TC Name is - "+tr.getName());
	}
	
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		
	}
	
	public void afterInvocation(IInvokedMethod method, ITestResult result) {
		Reporter.setCurrentTestResult(result);

		if (method.isTestMethod()) {
			List<Throwable> verificationFailures = ErrorUtil.getVerificationFailures();
			//if there are verification failures...
			if (verificationFailures.size() != 0) {
				//set the test to failed
				result.setStatus(ITestResult.FAILURE);
				
				//if there is an assertion failure add it to verificationFailures
				if (result.getThrowable() != null) {
					verificationFailures.add(result.getThrowable());
				}
 
				int size = verificationFailures.size();
				//if there's only one failure just set that
				if (size == 1) {
					result.setThrowable(verificationFailures.get(0));
				} else {
					//create a failure message with all failures and stack traces (except last failure)
					StringBuffer failureMessage = new StringBuffer("Multiple failures (").append(size).append("):nn");
					for (int i = 0; i < size-1; i++) {
						failureMessage.append("Failure ").append(i+1).append(" of ").append(size).append(":n");
						Throwable t = verificationFailures.get(i);
						String fullStackTrace = Utils.stackTrace(t, false)[1];
						failureMessage.append(fullStackTrace).append("nn");
					}
 
					//final failure
					Throwable last = verificationFailures.get(size-1);
					failureMessage.append("Failure ").append(size).append(" of ").append(size).append(":n");
					failureMessage.append(last.toString());
 
					//set merged throwable
					Throwable merged = new Throwable(failureMessage.toString());
					merged.setStackTrace(last.getStackTrace());
 
					result.setThrowable(merged);
					
				}
			}
		
		}
		
	}

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
			String outputDirectory) {
		
		System.out.println("******************INSIDE CUSTOM REPORTS CLASS******************");
		
		for(int suiteNum=0;suiteNum<suites.size();suiteNum++){
			ISuite suite = suites.get(suiteNum);
			System.out.println("SUITE - "+suite.getName());
			Map<String, ISuiteResult> suitesResults = suite.getResults();
			Set<String> suitesTestsList = suitesResults.keySet();
			Iterator<String> suitesTestsListItr = suitesTestsList.iterator();
			while(suitesTestsListItr.hasNext()){
				String testName = suitesTestsListItr.next();
				System.out.println("TESTS - "+testName);
				ISuiteResult testResults = suitesResults.get(testName);
				
				ITestNGMethod[] allTests = testResults.getTestContext().getAllTestMethods();
				IResultMap failedTests = testResults.getTestContext().getFailedTests();
				IResultMap skippedTests = testResults.getTestContext().getSkippedTests();
				IResultMap passedTests = testResults.getTestContext().getPassedTests();
				System.out.println("TESTS METHOD Names - ");
				for(int testNum=0;testNum<allTests.length;testNum++){
					String methodName = allTests[testNum].getMethodName(); 
					System.out.println(methodName);
					if(failedTests.getAllMethods().contains(allTests[testNum])){
						System.out.println("TC - "+methodName+" - FAILED.");
						
						//code to print reason of failing - IMP
						Collection<ITestNGMethod> allFailedMethods = failedTests.getAllMethods();
						Iterator<ITestNGMethod> allFailedMethodsItr = allFailedMethods.iterator();
						while(allFailedMethodsItr.hasNext()){
							ITestNGMethod failedMethod = allFailedMethodsItr.next();
							if(methodName.equals(failedMethod.getMethodName())){
								Set<ITestResult> failedMethodResults = failedTests.getResults(failedMethod);
								Iterator<ITestResult> failedMethodResultsItr = failedMethodResults.iterator();
								while(failedMethodResultsItr.hasNext()){
									System.out.println(failedMethodResultsItr.next().getThrowable().getMessage());
								}
							}
						}
						
					}else if(skippedTests.getAllMethods().contains(allTests[testNum])){
						System.out.println("TC - "+methodName+" - SKIPPED.");
						
						//code to print reason of skipping - IMP
						Collection<ITestNGMethod> allSkippedMethods = skippedTests.getAllMethods();
						Iterator<ITestNGMethod> allSkippedMethodsItr = allSkippedMethods.iterator();
						while(allSkippedMethodsItr.hasNext()){
							ITestNGMethod skippedMethod = allSkippedMethodsItr.next();
							if(methodName.equals(skippedMethod.getMethodName())){
								Set<ITestResult> skippedMethodResults = skippedTests.getResults(skippedMethod);
								Iterator<ITestResult> skippedMethodResultsItr = skippedMethodResults.iterator();
								while(skippedMethodResultsItr.hasNext()){
									System.out.println(skippedMethodResultsItr.next().getThrowable().getMessage());
								}
							}
						}
						
					}else if(passedTests.getAllMethods().contains(allTests[testNum])){
						System.out.println("TC - "+methodName+" - PASSED.");
					}
				}
				
				
			}
			
		}
		
		
	}
	
	
}
