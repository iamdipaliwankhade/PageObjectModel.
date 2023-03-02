package com.listenerproject;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.facebook.qa.base.TestBase;
public class MyTestListener extends TestBase implements ITestListener{ 
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" :onTestStart");
		extent.attachReporter(spark);
		extent.flush();
	}
		
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("My test case passed... Name of test case: "+ result.getName());
		extent.flush();
	}
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("My test case failed... Name of test case: "+ result.getName());
		extent.flush();
	}
	
	

}
