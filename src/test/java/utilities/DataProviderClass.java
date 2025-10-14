package utilities;
import java.io.IOException;
import org.testng.annotations.DataProvider;
public class DataProviderClass {
   
	    @DataProvider(name = "LoginData")
	    public Object[][] getLoginData() throws IOException {
	        String filePath = ".//testData//logindata.xlsx";
	        ExcelUtility excel = new ExcelUtility(filePath);
	        String sheetName = "LoginCredentials";
	        int rows = excel.getRowCount(sheetName);
	        int cols = excel.getCellCount(sheetName, 1);
	        Object[][] data = new Object[rows][cols];

	        for (int i = 1; i <= rows; i++) { 
	            for (int j = 0; j < cols; j++) {
	                data[i - 1][j] = excel.getCellData(sheetName, i, j);
	            }
	        }

	        return data;
	    }
	}
	


