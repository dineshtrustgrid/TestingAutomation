package com.selenium.TestNG;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listerners implements ITestListener{
	
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test is failure"+ result);
	}

	
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test is success"+result);
	}
}
