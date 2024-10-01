package Selenium.Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		
		features = "src\\test\\java\\Selenium\\Cucumber" ,
		glue = "Selenium\\Step_Defination" ,
		monochrome = true ,
		plugin = {"html:target/cucumber.html"}
		
)


public class E2ETestRunner extends AbstractTestNGCucumberTests {

}
