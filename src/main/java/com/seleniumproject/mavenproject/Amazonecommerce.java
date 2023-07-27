package com.seleniumproject.mavenproject;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazonecommerce {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/s?k=mobile+phone&crid=5P9XR5COEZ6Q&sprefix=mobile+phon%2Caps%2C319&ref=nb_sb_noss_2");
		Thread.sleep(4000);
		List<WebElement> productsNameList =driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> productLinks=driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
		
		System.out.println(productLinks.size());
		int j=0;
		for(int i=0;i<productLinks.size();i++) {
			System.out.println(productLinks.get(i).getText());
			productLinks.get(i).click();
			Thread.sleep(5000);
			j++;
			String parent=driver.getWindowHandle();
			Set<String> s=driver.getWindowHandles();
				//Thread.sleep(5000);
				//driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
			
			
			Iterator<String> I1= s.iterator();

			while(I1.hasNext())
			{

			String child_window=I1.next();


			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);

			System.out.println(driver.switchTo().window(child_window).getTitle());
			
			driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
			Thread.sleep(5000);
			driver.close();
			}

			}
			//switch to the par
			driver.switchTo().window(parent);
			
			if(j==productLinks.size()) {
				driver.navigate().refresh();
				Thread.sleep(5000);
				
			}
		}
	}

}
