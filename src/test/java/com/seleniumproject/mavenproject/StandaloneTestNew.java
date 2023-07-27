package com.seleniumproject.mavenproject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.pageobjects.CartPage;

import selenium.pageobjects.CheckoutPage;
import selenium.pageobjects.ConfirmationPage;
import selenium.pageobjects.Landingpage;
import selenium.pageobjects.Productcatalogue;

public class StandaloneTestNew {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// https://rahulshettyacademy.com/client/
		// Username: dinesh93@gmail.com
		// password:Dinesh@123

		String productName = "ZARA COAT 3";
		String uname="dinesh93@gmail.com";
		String password="Dinesh@123";
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
				
		Landingpage landingpage = new Landingpage(driver);

		landingpage.goToURL();
		Productcatalogue productcatalogue=landingpage.login(uname, password);
		
		//List<WebElement> products =productcatalogue.getproductlist();
		
		
		productcatalogue.addproducttocart(productName);
		
		productcatalogue.gotocartpage();
		
		CartPage cartpage= new CartPage(driver);
		
		Boolean match=cartpage.cartsection(productName);
		Assert.assertTrue(match);
		
		CheckoutPage checkout=cartpage.cartcheckout();
		checkout.selectcountry("india");
		
		
		ConfirmationPage confirmpage=checkout.submitorder();
		
		String confirmmessage = confirmpage.confirmmessage();
		
		Assert.assertTrue(confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		System.out.println("Execution completed");

		driver.close();

	}
}
