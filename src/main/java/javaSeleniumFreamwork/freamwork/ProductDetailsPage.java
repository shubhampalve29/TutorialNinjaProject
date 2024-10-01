package javaSeleniumFreamwork.freamwork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitiesClasses.BaseClassOfUtilities;

public class ProductDetailsPage extends BaseClassOfUtilities{
	
	static WebDriver driver;
	@FindBy(xpath = "(//h1[text()='Nikon D300']/..//following-sibling::ul)[2]//h2")     
	private WebElement price;

	@FindBy(id = "input-quantity")
	private WebElement quantityNumber;

	@FindBy(id = "button-cart")
	private WebElement addToCart;

	@FindBy(xpath = "//strong[text()='Total']/../following-sibling::td")
	private WebElement TotalPrice;

	public ProductDetailsPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String getPrice() {

		return price.getText();

	}

	public String getTotalprice() {

		return TotalPrice.getText();

	}

	public CartPage addToCartAction(String qunNumber) throws InterruptedException {

		quantityNumber.clear();
		quantityNumber.sendKeys(qunNumber);
		addToCart.click(); 
		Thread.sleep(2000);
		commonCartButton();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
		

	}

}
