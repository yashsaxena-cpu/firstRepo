package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;

import reporting.Report2;

public class BaseTest {
	public static  WebDriver driver;
	protected String url;
	protected static String browserName = null;
	ExtentReports extent;
	

	
	public static WebDriver getDriver() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\yash\\gitub\\seleniumFramework\\arval\\src\\test\\resources\\config\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);
	//	browserName = prop.getProperty("browser");
		browserName="chrome";
		//BrowserFactory factory = new BrowserFactory("chrome");
//		driver = factory.createDriver();
		String url = prop.getProperty("url");
		System.out.println(url);
		System.out.println(browserName);
		
		if (browserName.trim().equals("chrome")) {
			if (driver == null) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\yash\\gitub\\seleniumFramework\\arval\\src\\test\\resources\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get(url);
				return driver;
			} else {
				return driver;
			}
		} else if (browserName.trim().equals("ie")) {
			if (driver == null) {
				System.setProperty("webdriver.ie.driver",
						"C:\\Users\\yash\\gitub\\seleniumFramework\\arval\\src\\test\\resources\\drivers\\MicrosoftWebDriver.exe");
				driver = new InternetExplorerDriver();
				driver.get(url);
				return driver;
			} else {
				return driver;
			}
		}
		return driver;
	}
	
	public String capture(WebDriver drive) throws IOException {
		File scrFile = ((TakesScreenshot) drive).getScreenshotAs(OutputType.FILE);
		File Dest = new File("src/ErrImages/" + System.currentTimeMillis()
		+ ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
		}
	
	@AfterSuite
	public void close() {
		driver.quit();																																																																																											
	}
	
}
