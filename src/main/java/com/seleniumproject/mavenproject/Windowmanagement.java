package com.seleniumproject.mavenproject;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windowmanagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		
		//open in New Window
		
		//driver.switchTo().newWindow(WindowType.WINDOW);
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.navigate().to("https://www.browserstack.com/");
		
		driver.switchTo().defaultContent();
		
		

	}

}
