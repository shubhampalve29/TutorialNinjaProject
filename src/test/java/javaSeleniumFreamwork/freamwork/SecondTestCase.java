package javaSeleniumFreamwork.freamwork;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javaSeleniumFreamwork.freamwork.HomePage;
import javaSeleniumFreamwork.freamwork.LandingPage;
import javaSeleniumFreamwork.freamwork.LoginPage;
import testutilities.BaseTestClass;

public class SecondTestCase extends BaseTestClass {

	@Test(dataProvider = "getData")
	public void verifyLoginSecondTestCase(String userName, String Password) throws IOException {

		WebDriver driver = broswerLunch();
		LandingPage lp = new LandingPage(driver);
		LoginPage lop = lp.loginAction();
		HomePage hp = lop.loginViaUserDetails(userName, Password);
		SoftAssert sa = new SoftAssert();
		String exptecd = "https://tutorialsninja.com/demo/index.php?route=account/account";
		String actual = driver.getCurrentUrl();
		sa.assertEquals(actual, exptecd);
		
		sa.assertAll();
		tearDown();
		
		
		
		

	}

	@DataProvider(name = "getData")
	public String[][] getDtaFromExcel() throws IOException {

		String path = "C:\\Users\\shubh\\eclipse-workspace\\freamwork\\src\\main\\java\\resources\\freamworkexcel.xlsx";
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);

		int row = sheet.getPhysicalNumberOfRows();
		int col = sheet.getRow(0).getLastCellNum();
		System.out.println(row);
		System.out.println(col);

		String[][] userData = new String[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
 
				 if((i == 0 && j == 1) || (i==1 && j ==1)) {
					 
					// String pass = "";
					 String pass = sheet.getRow(i).getCell(j).getRawValue();
					 userData[i][j] = pass;
					 
				 }else {
					 
					 String data = sheet.getRow(i).getCell(j).getStringCellValue();
						userData[i][j] = data;
					 
				 }
				 System.out.println(userData[i][j]);
				
				
			} 
		}
		return userData;

	}

}
