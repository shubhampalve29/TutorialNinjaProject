package testutilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class BaseTestClass {

	public  WebDriver driver;

	public WebDriver broswerLunch() throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\shubh\\eclipse-workspace\\freamwork\\src\\main\\java\\resources\\properties.properties");
		Properties prod = new Properties();
		prod.load(fis);
		
		String browserName = System.getProperty("broswer") != null ? System.getProperty("broswer") : prod.getProperty("browser");
		
		String url = prod.getProperty("basedUrl");

		if (browserName.equalsIgnoreCase("Chrome")) {

			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("Firefox")) {

			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("Edge")) {

			driver = new EdgeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);

		return driver;

	}

	public void tearDown() {

		driver.close();
	}

	public static String getScreenshot(String methodName, WebDriver driver) throws IOException {
		if (driver == null) {
			throw new IllegalArgumentException("WebDriver instance is null. Cannot take screenshot.");
		}

		TakesScreenshot ts = (TakesScreenshot) driver;

		// Checking if TakesScreenshot is null
		if (ts == null) {
			throw new IllegalStateException(
					"Unable to cast WebDriver to TakesScreenshot. Ensure the WebDriver is correctly initialized.");
		}

		String path = System.getProperty("user.dir") + "//reports//" + methodName + ".png";
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileHandler.copy(source, destination);
		return path;
	}

}
