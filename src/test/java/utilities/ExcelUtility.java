package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public String filePath;
	
	public ExcelUtility(String filePath) {
		this.filePath = filePath;
	}

	public Workbook getWorkbook() throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		return new XSSFWorkbook(fis);
	}

	// Get Row Count
	public int getRowCount(String sheetName) throws IOException {
		Workbook workbook = getWorkbook();
		Sheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		return rowCount;
	}

	// Get Cell Count (columns) in a row
	public int getCellCount(String sheetName, int rowNum) throws IOException {
		Workbook workbook = getWorkbook();
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		return cellCount;
	}

	// Get Cell Data
	public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
		Workbook workbook = getWorkbook();
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(colNum);

		DataFormatter formatter = new DataFormatter();
		String data = formatter.formatCellValue(cell);

		workbook.close();
		return data;
	}
}
