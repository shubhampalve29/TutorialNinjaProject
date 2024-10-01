package utilitiesClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClassOfUtilities {
	
	@FindBy(xpath = "//div[@id='cart']//button")
	static WebElement checkItems;
	
	static WebDriver driver;
	
	public BaseClassOfUtilities(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public static void visibilityOfElementLocated(By Findby) {
		
		WebDriverWait wd = new WebDriverWait(driver, Duration.ofSeconds(10));
		wd.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Findby));
	}
	
	public static void commonCartButton() {
		
		checkItems.click();
	}

}
