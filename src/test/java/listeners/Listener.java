package listeners;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseTest;
import reporting.Report2;

public class Listener implements ITestListener {

	ExtentTest logger;
	public WebDriver drive;
	ExtentReports extent;
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		logger = Report2.getInstance().createTest(result.getName());
		logger.log(Status.PASS, "Test Case Passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		logger = Report2.getInstance().createTest(result.getName());
		logger.log(Status.FAIL, "Test Case failed. Please refer to screenshot");
		File scrFile = null;
		try {
			scrFile = ((TakesScreenshot)BaseTest.getDriver()).getScreenshotAs(OutputType.FILE);
		} catch (WebDriverException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		File Dest = new File("src/ErrImages/" + System.currentTimeMillis()
		+ ".png");
		try {
			FileUtils.copyFile(scrFile, Dest);
			String errflpath = Dest.getAbsolutePath();
			logger.addScreenCaptureFromPath(errflpath);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/extent.html");
        htmlReporter.config().setDocumentTitle("ExtentReports - Created by TestNG Listener");
        htmlReporter.config().setReportName("ExtentReports - Created by TestNG Listener");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setTheme(Theme.STANDARD);
        extent = Report2.getInstance();
        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);
		extent.setSystemInfo("Host Name", "yash saxena");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "Yash Saxena");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Report2.getInstance().flush();
	}

}
