package selenium.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import selenium.Abstractcomponents.AbstractComponent;


public class Productcatalogue extends AbstractComponent{
	
	WebDriver driver;
	
	public Productcatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By productsby=By.cssSelector(".mb-3");
	By addtocartby=By.cssSelector(".card-body button:last-of-type");
	By toastmessage=By.cssSelector("#toast-container");
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	public List<WebElement> getproductlist() {
		
		waitForVisibilityOFElementAppear(productsby);
		return products;
		}

	public WebElement getProductByName(String productname) {
		WebElement prod=getproductlist().stream()
		.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst()
		.orElse(null);
		return prod;
	}
	


	public void addproducttocart(String productName) {
		WebElement prod =getProductByName(productName);
		
		prod.findElement(addtocartby).click();
		waitForVisibilityOFElementAppear(toastmessage);
		
		waitForinVisibilityOFElement(spinner);
	}
	

}
