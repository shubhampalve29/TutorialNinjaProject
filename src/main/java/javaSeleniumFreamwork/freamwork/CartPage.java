package javaSeleniumFreamwork.freamwork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	@FindBy(xpath = "//strong [text()='Checkout']")
	private WebElement checkOutClick;
	
	@FindBy(xpath = "//span[text()='***']")
	private WebElement starT;
	
	@FindBy(css="button.close")
	private WebElement erorMsg;
	
	public CartPage(WebDriver driver) {
	
		PageFactory.initElements(driver, this);
		
	}
	
	public void checkoutAction() {
		
		checkOutClick.click();
		erorMsg.click();
		
	}
	
	public String getStarText() {
		
		return starT.getText();
		
	}
	
	

}
