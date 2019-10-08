package testData;

import org.testng.annotations.DataProvider;

import utility.ExcelUtility;


public class DataExcel {
	
	 @DataProvider(name = "data-provider")
	    public Object[][] dataProviderMethod() throws Exception {
		 return(ExcelUtility.excelData());
	    }

}
