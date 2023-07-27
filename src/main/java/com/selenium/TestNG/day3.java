package com.selenium.TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class day3 {
	
	@Test
	public void websignup() {
		System.out.println("websignup");
	}
	
	@Test(timeOut=4000)
	public void webtimeout() {
		System.out.println("webtimeout");
		Assert.assertTrue(false);
	}
	
	@Test(dataProvider= "getdata")
	public void weblogindata(String uname,String password) {
		System.out.println("weblogindata");
		System.out.println(uname + ""+ password);
	}
	@BeforeSuite
	public void beforesuite() {
		System.out.println("Before Suite day3");
	}

	@BeforeMethod
	public void beforemethod() {
		System.out.println("beforemethod");
	}
	
	@Test(dependsOnMethods="websignup")
	public void websignin() {
		System.out.println("websignin");
	}
	
	@Test
	public void websignout() {
		System.out.println("websignout");
	}

	@AfterMethod
	public void aftermethod() {
		System.out.println("aftermethod");
	}
	
	@BeforeTest
	public void beforetest() {
		System.out.println("Beforetest day3");
	}
	@AfterTest
	public void aftertest()
	{
		System.out.println("aftertest");
	}
	
	@DataProvider()
	public Object[][] getdata() {
		
		Object[][] data =new Object[2][2];
		
		data[0][0]="firstusername";
		data[0][1]="firstpassword";
		data[1][0]="secondusername";
		data[1][1]="secondpassword";
		
		return data;
	}
	
	
	
}
