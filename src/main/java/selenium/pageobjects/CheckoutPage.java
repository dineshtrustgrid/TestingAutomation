package selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.Abstractcomponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{

	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement selectcountry;
	
	By results=By.cssSelector(".ta-results");
	
	@FindBy(css=".actions a")
	WebElement placeordersubmit;
	
	public void selectcountry(String countryname) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryname).build().perform();
		
		waitForVisibilityOFElementAppear(results);
		selectcountry.click();
	}
	
	
	public ConfirmationPage submitorder() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		//WebElement placeorder = driver.findElement(By.cssSelector(".actions a"));

		js.executeScript("arguments[0].scrollIntoView();", placeordersubmit);
		

		Thread.sleep(3000);
		placeordersubmit.click();
		
		return new ConfirmationPage(driver);
		
		
	}
	
	
	
}
