package javaSeleniumFreamwork.freamwork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	static WebDriver driver;
	@FindBy(xpath="//a[text()='Cameras']")
	private WebElement cameraButton;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ProductPage homePageAction() {
		
		cameraButton.click();
		ProductPage pg = new ProductPage(driver);
		return pg;
		
	}

}
