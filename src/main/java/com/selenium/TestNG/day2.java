package com.selenium.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class day2 {
	
	
	@BeforeSuite
	public void beforesuite() {
		System.out.println("Before Suite");
	}
	
	@BeforeClass
	public void beforeclass() {
		System.out.println("beforeclass");
	}
	@Test(enabled=false)
	public void homesignup() {
		System.out.println("homesignup"+"this is skipped");
	}

	
	@Test(groups= {"smoke"})
	public void homesignin() {
		System.out.println("homesignin");
	}
	
	@Test (groups= {"smoke"})
	public void homesignout() {
		System.out.println("homesignout");
	}

	@AfterClass
	public void afterclass() {
		System.out.println("afterclass");
	}
	@AfterSuite
	public void aftersuite() {
		System.out.println("aftersuite");
	}
	
	
	@BeforeGroups("smoke")
	public void  beforegroup() {
		System.out.println("beforegroup");
	}
	
	@AfterGroups("smoke")
	public void aftergroup() {
		System.out.println("aftergroup");
	}
}
