package javaSeleniumFreamwork.freamwork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	static WebDriver driver;
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myAccountButton;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginButton;
	
	public LandingPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage loginAction() {
		
		myAccountButton.click();
		loginButton.click();
		LoginPage lop = new LoginPage(driver);
		return lop;
	}


}
