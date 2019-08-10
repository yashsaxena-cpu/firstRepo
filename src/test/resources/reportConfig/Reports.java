package reportConfig;
public class Reports {

	public class ExtentTestNGIReporterListener implements IReporter {
	    
	    private static final String OUTPUT_FOLDER = "test-output/";
	    private static final String FILE_NAME = "Extent.html";
	    
	    private ExtentReports extent;

	    @Override
	    public void generateReport(List xmlSuites, List suites, String outputDirectory) {
	        init();
	        
	        for (ISuite suite : suites) {
	            Map result = suite.getResults();
	            
	            for (ISuiteResult r : result.values()) {
	                ITestContext context = r.getTestContext();
	                
	                buildTestNodes(context.getFailedTests(), Status.FAIL);
	                buildTestNodes(context.getSkippedTests(), Status.SKIP);
	                buildTestNodes(context.getPassedTests(), Status.PASS);
	                
	            }
	        }
	        
	        for (String s : Reporter.getOutput()) {
	            extent.setTestRunnerOutput(s);
	        }
	        
	        extent.flush();
	    }
	    
}
