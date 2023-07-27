package com.seleniumproject.mavenproject;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//label[@for='departure']")).click();

		
		
		String month ="June 2023";
		String day = "29";
		
		
		
		
		while(true) {
			
			String textmonth=driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
			System.out.println(textmonth);
			if(textmonth.equalsIgnoreCase(month)) {
				break;
			}
			else {
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			}
		}
		
		
		List<WebElement> alldates =driver.findElements(By.xpath("//div[@class='DayPicker-Day']"));
		
		int countdates=alldates.size();
		System.out.println(countdates);
		for(int i=0;i<countdates;i++) {
			
			String datetext=driver.findElements(By.xpath("//div[@class='DayPicker-Day']/div/p[1]")).get(i).getText();
			System.out.println(datetext);
			if(datetext.equals(day)) {
				driver.findElements(By.xpath("//div[@class='DayPicker-Day']")).get(i).click();			
				break;
			}
			
		}
		
		
		}
}