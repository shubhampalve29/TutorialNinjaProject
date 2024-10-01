package testutilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportsClasses;

public class ListenersClasses extends BaseTestClass implements ITestListener {

	ExtentReports extent = ExtentReportsClasses.reporting();
	ExtentTest test;


	@Override
	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		// test.log(Status.PASS, "This Test Case is Passed");
		if (test != null) {
			test.log(Status.PASS, "This Test Case is Passed");
		}

	}

	@Override
	public void onTestFailure(ITestResult result) {

		// test.fail(result.getThrowable());
		if (test != null) {
			test.fail(result.getThrowable());

			// get instance of driver

			String filePath = null;
			try {

				driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
				

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Generate a custom screenshot name
//	        String methodName = result.getMethod().getMethodName();
//	        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//	        String screenshotName = methodName + "_" + timestamp + ".png";

			// ScreenShot
			try {

				filePath = getScreenshot(result.getMethod().getMethodName(), driver);
				test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// attach screenshot to extent report
			
			
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

		extent.flush();

	}

}
