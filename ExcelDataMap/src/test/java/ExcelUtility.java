import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static Object[][] excelData() throws Exception{
		
		  final FileInputStream file = new FileInputStream(new File("src//main//resources//ysh.xlsx"));
	        final XSSFWorkbook workbook = new XSSFWorkbook((InputStream)file);
	        final Sheet sheet = (Sheet)workbook.getSheetAt(0);
	        int rowCount = sheet.getLastRowNum();
	        int colCount = sheet.getRow(0).getLastCellNum();
	        
	        Object[][] obj = new Object[rowCount][1];
	        
	        for(int i =0; i<rowCount;i++) {
	        	Map<Object,Object> dataMap = new HashMap<Object,Object>();
	        	for(int j =0;j<colCount;j++) {
	        		dataMap.put(sheet.getRow(0).getCell(j), sheet.getRow(i+1).getCell(j));
	        	}
	        	obj[i][0]=dataMap;
	        }
	        
	       return obj;
	}

}
