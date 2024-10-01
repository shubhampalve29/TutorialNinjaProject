package javaSeleniumFreamwork.freamwork;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javaSeleniumFreamwork.freamwork.CartPage;
import javaSeleniumFreamwork.freamwork.HomePage;
import javaSeleniumFreamwork.freamwork.LandingPage;
import javaSeleniumFreamwork.freamwork.LoginPage;
import javaSeleniumFreamwork.freamwork.ProductDetailsPage;
import javaSeleniumFreamwork.freamwork.ProductPage;
import testutilities.BaseTestClass;

public class FirstTest extends BaseTestClass {

	@Test(dataProvider = "data")
	public void test(String uName, String Upass) throws InterruptedException, IOException {

		WebDriver driver = broswerLunch();
		LandingPage lp = new LandingPage(driver);
		LoginPage lop = lp.loginAction();
		HomePage hp = lop.loginViaUserDetails(uName, Upass);
		ProductPage pg = hp.homePageAction();
		// List<WebElement> products = pg.getDtaList();
		ProductDetailsPage pdg = pg.clickOnProd("Nikon D300");
		CartPage cartPage = pdg.addToCartAction("2");
		// Validation number 1
		System.out.println("total price of product : " + pdg.getPrice());
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(pdg.getPrice(), "$98.00");
		
		// validation number 2
		System.out.println("total price of product : " + pdg.getTotalprice());
		sa.assertEquals(pdg.getTotalprice(), "$196.00");
		
		cartPage.checkoutAction();
		Boolean result = cartPage.getStarText().equalsIgnoreCase("***");
		Assert.assertTrue(result);
		
		sa.assertAll();
		tearDown();
		
		

	}

	@DataProvider(name = "data")

	public Object[][] gertdata() {

		return new Object[][] {

				{ "Sam@1.com", "12345" } };

	}
}
