package resources;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsClasses {
	
	public static ExtentReports reporting() {
		
		String path = System.getProperty("user.dir")+"//reports//index.html";
		
		// ExtentSparkReporter
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Reports");
		reporter.config().setReportName("Automation Test Report");
		
		// ExtentReporter
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Shubham Palve");
		
		return extent;
		
	}
	
	

}


