package Selenium.Step_Defination;

import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Then;
import testutilities.BaseTestClass;

public class invalidTestCase extends BaseTestClass {
	
	@Then ("I verify details valid or not")
	public void vary() {
		
		SoftAssert sa = new SoftAssert();
		String exptecd = "https://tutorialsninja.com/demo/index.php?route=account/account";
		String actual = driver.getCurrentUrl();
		sa.assertEquals(actual, exptecd);
		
		sa.assertAll();
		tearDown();
		
	}

}
