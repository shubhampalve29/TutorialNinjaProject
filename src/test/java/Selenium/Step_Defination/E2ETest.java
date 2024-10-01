package Selenium.Step_Defination;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javaSeleniumFreamwork.freamwork.CartPage;
import javaSeleniumFreamwork.freamwork.HomePage;
import javaSeleniumFreamwork.freamwork.LandingPage;
import javaSeleniumFreamwork.freamwork.LoginPage;
import javaSeleniumFreamwork.freamwork.ProductDetailsPage;
import javaSeleniumFreamwork.freamwork.ProductPage;
import testutilities.BaseTestClass;

public class E2ETest extends  BaseTestClass{
	
	LandingPage lp;
	LoginPage lop;
	HomePage hp;
	ProductPage pg;
	ProductDetailsPage pdg;
	CartPage cartPage;
	SoftAssert sa;
	
	@Given ("navigate to based url")
	public void landingPage() throws IOException {
		
		 broswerLunch();
		 lp = new LandingPage(driver);
		 lop = lp.loginAction();
		
	}
	
	@Given ("^login with username (.+) and password (.+)$")
	public void login(String name , String password ) {
		
		
		hp = lop.loginViaUserDetails(name, password);
		
		
	}
	
	@When ("^add product (.+) to cart and checkout$")
	public void addProduct(String product) throws InterruptedException {
		
		pg = hp.homePageAction();
		// List<WebElement> products = pg.getDtaList();
		pdg = pg.clickOnProd(product);
		cartPage = pdg.addToCartAction("2");
		// Validation number 1
		System.out.println("total price of product : " + pdg.getPrice());
		
		sa = new SoftAssert();
		sa.assertEquals(pdg.getPrice(), "$98.00");
		
		// validation number 2
		System.out.println("total price of product : " + pdg.getTotalprice());
		sa.assertEquals(pdg.getTotalprice(), "$196.00");
		
		cartPage.checkoutAction();
		
		
	}
	
	@Then ("verfiy details{string}")
	public void varifyDetails(String string) {
		
		Boolean result = cartPage.getStarText().equalsIgnoreCase("***");
		Assert.assertTrue(result);
		
		sa.assertAll();
		tearDown();
		
	}

}