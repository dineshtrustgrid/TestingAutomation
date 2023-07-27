package com.seleniumproject.mavenproject;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ecommercecart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		
		String[] itemsNeedtoadd = { "Cucumber", "Carrot", "Beetroot", "Brocolli" };

		List<WebElement> productNameList = driver.findElements(By.xpath("//h4[@class='product-name']"));
		int j = 0;
		for (int i = 0; i < productNameList.size(); i++) {

			String[] formatedProductList = productNameList.get(i).getText().split("-");

			String formatedproducts = formatedProductList[0].trim();

			System.out.println(formatedproducts);

			List itemsNeededlist = Arrays.asList(itemsNeedtoadd);
			
			System.out.println(itemsNeededlist);
			

			if (itemsNeededlist.contains(formatedproducts)) {
				
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if (j == itemsNeedtoadd.length)
				{
					break;
				}
			}

		}

		

	}

}
