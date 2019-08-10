package reporting;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentRept {
	protected static ExtentTest extentTest;
	protected static ExtentReports report;

	@BeforeSuite
	public static void startTest()
	{
	report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
	
	}
	
	@AfterSuite
	public static void endTest()
	{
	report.endTest(extentTest);
	report.flush();
	}
	}