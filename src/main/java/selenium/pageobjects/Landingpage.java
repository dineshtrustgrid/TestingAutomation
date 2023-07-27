package selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.Abstractcomponents.AbstractComponent;


public class Landingpage  extends AbstractComponent{
	
	WebDriver driver;
	
	public Landingpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElement username=driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userEmail")
	WebElement username;
	
	//WebElement password=driver.findElement(By.id("userPassword"));
	@FindBy(id="userPassword")
	WebElement passwords;
	
	//driver.findElement(By.id("login")).click();
	@FindBy(id="login")
	WebElement login;
	
	
	
	public Productcatalogue login(String email,String password)
	{
		username.sendKeys(email);
		passwords.sendKeys(password);
		login.click();
		
		return new Productcatalogue(driver);
		
	}
	
	public void goToURL()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
}
	