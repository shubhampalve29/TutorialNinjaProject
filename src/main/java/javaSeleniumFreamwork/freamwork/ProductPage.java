package javaSeleniumFreamwork.freamwork;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitiesClasses.BaseClassOfUtilities;

public class ProductPage extends BaseClassOfUtilities {
	
	static WebDriver driver;
	@FindBy(css = ("div.product-layout.product-grid"))
	private List<WebElement> products;
	
	By productofCamera = By.cssSelector("div h4");
	By clickOnCameraProduct = By.cssSelector("a");

	public ProductPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public List<WebElement> getDtaList() {
		
		visibilityOfElementLocated(productofCamera);
		return products;

	}

	public WebElement getElementByList(String camName) {
		
		WebElement clickProduct= null;
		
		for (WebElement product : products) {
			
			
			WebElement targetProdcut = product.findElement(productofCamera);
			String productName = targetProdcut.getText();

			if (productName.equalsIgnoreCase(camName)) {

				 clickProduct = targetProdcut.findElement(clickOnCameraProduct);
				 return clickProduct;

			}
			
			
			
			
		}
		return clickProduct;
		
	}
	
	public ProductDetailsPage clickOnProd(String camName) {
		
		WebElement prod = getElementByList(camName);
		prod.click();
		ProductDetailsPage pdg = new ProductDetailsPage(driver);
		return pdg;
		
	}

}
