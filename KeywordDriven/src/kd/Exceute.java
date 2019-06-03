package kd;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Exceute {

@Test
    
public void testLogin() throws Exception {
	
WebDriver webdriver = new FirefoxDriver();
ReadGuru99ExcelFile file = new ReadGuru99ExcelFile();
ReadObject object = new ReadObject();
Properties allObjects = object.getObjectRepository();
UI operation = new UI(webdriver);
    
    Sheet guru99Sheet = file.readExcel(System.getProperty("user.dir")+"\\","TestCase.xlsx" , "KeywordFramework");
   
    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
   
    for (int i = 1; i < rowCount+1; i++) {
     
        Row row = guru99Sheet.getRow(i);
      
        String operationName = row.getCell(0) == null ? "" : row.getCell(0).toString();
		String objectName = row.getCell(1) == null ? "" : row.getCell(1).toString();
		String objectType = row.getCell(2) == null ? "" : row.getCell(2).toString();
		String value = row.getCell(3) == null ? "" : row.getCell(3).toString();
		
		System.out.println("Show Begins....");
        
		String rowvalue = row.getCell(4) == null ? "" : row.getCell(4).toString();
        if(rowvalue.toString().length()==0){
        
        	operation.perform(allObjects, operationName, objectName, objectType, value);
    
        }
        else{
            
                System.out.println("New Testcase->" + row.getCell(0).toString() + " Started");
                
            }
        }
    }
}
