import java.util.Map;

import org.testng.annotations.Test;

import testData.DataExcel;

public class TestCase {
	
	
	@Test(dataProvider= "data-provider", dataProviderClass = DataExcel.class)
	public void test(Map testMap)
	{
				System.out.println(testMap.get("A"));
				System.out.println(testMap.get("B"));
	}
}
