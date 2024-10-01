package javaSeleniumFreamwork.freamwork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	static WebDriver driver;
	@FindBy(id = "input-email")
	private WebElement email;

	@FindBy(id = "input-password")//input[@type="submit"]
	private WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitButton;

	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage loginViaUserDetails(String userName, String userPassword) {

		email.sendKeys(userName);
		password.sendKeys(userPassword);
		submitButton.click();
		HomePage hp = new HomePage(driver);
		return hp;

	}
}
