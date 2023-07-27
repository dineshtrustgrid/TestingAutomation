package com.selenium.TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day1 {
	
	@Parameters({"URL"})
	@Test
	public void carsignup(String url) 
	{
		System.out.println("carsignup"+ url);
	}

	
	@Test
	public void carsignin() 
	{
		System.out.println("carsignin");
	}
	
	@Test
	public void carsignout() 
	{
		System.out.println("carsignout");
	}
}
