package selenium.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.Abstractcomponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	//List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));

	//Boolean match = cartproducts.stream()
	//		.anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productName));
	
	// driver.findElement(By.cssSelector(".totalRow button")).click();
	
	
	@FindBy(css=".cartSection h3")
	List<WebElement> productstitles;
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	public Boolean cartsection(String Productname) {
		
		Boolean match =productstitles.stream().anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(Productname));
		return match;
	}
	
	public CheckoutPage cartcheckout()
	{
		checkout.click();
		
		return new CheckoutPage(driver);
	}
	
}
