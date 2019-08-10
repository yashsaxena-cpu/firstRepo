package reporting;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Report2 {
	static ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	Report2 report;
	
	public static ExtentReports getInstance() {
		if(extent == null){
			extent = new ExtentReports();
			return extent;
		}else {   
		return extent;
		}
	}
	

	public  void startReport(){
		//ExtentReports(String filePath,Boolean replaceExisting) 
		//filepath - path of the file, in .htm or .html format - path where your report needs to generate. 
		//replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
		//True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
		//False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
		extent = new ExtentReports ();
		//extent.addSystemInfo("Environment","Environment Name")
		extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "Rajkumar SM");
                //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
                //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
         //      extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}

        //This method is to capture the screenshot and return the path of the screenshot.
	
	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
		
	
	public void passTest(){
		//extent.startTest("TestCaseName", "Description")
		//TestCaseName – Name of the test
		//Description – Description of the test
		//Starting test
		logger = extent.createTest("passTest");
		Assert.assertTrue(true);
		//To generate the log when the test case is passed
		logger.log(Status.PASS, "Test Case Passed is passTest");
	}
	
	
	public void failTest(){
                //My intention is to fail this method
                //If this method fails, then it goes to the @AfterMethod and calls the getScreenshot method and captures a screenshot and place it in the extent reports
		logger = extent.createTest("failTest");
		 System.setProperty("webdriver.gecko.driver","D://Selenium//Drivers//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.softwaretestingmaterial.com");
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, "NoTitle");
		logger.log(Status.PASS, "Test Case (failTest) Status is passed");
	}
	
	
	public void skipTest(){
		logger = extent.createTest("skipTest");
		throw new SkipException("Skipping - This is not ready for testing ");
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws Throwable{
		if(result.getStatus() == ITestResult.FAILURE){
			logger.log(Status.FAIL, "Test Case Failed is "+result.getName());
			logger.log(Status.FAIL, "Test Case Failed is "+result.getThrowable());
			//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
                        //We do pass the path captured by this mehtod in to the extent reports using "logger.addScreenCapture" method. 			
                        String screenshotPath = getScreenhot(driver, result.getName());
			//To add it in the extent report
                  
                       logger.log(Status.FAIL, "details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                        
		//	logger.log(Status.FAIL, logger.addScreenCaptureFromPath(screenshotPath));
		}else if(result.getStatus() == ITestResult.SKIP){
			logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
		}
		// ending test
		//endTest(logger) : It ends the current test and prepares to create HTML report
	//	extent.endTest(logger);
	}

	
}

