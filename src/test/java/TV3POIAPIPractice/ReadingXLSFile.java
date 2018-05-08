package TV3POIAPIPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingXLSFile {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		InputStream inp = new FileInputStream(System.getProperty("user.dir")+"\\Data\\Test.xlsx");
		Workbook wbook = WorkbookFactory.create(inp);
		Sheet sheet = wbook.getSheet("newsheet");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(0);
		String cellValue = cell.getStringCellValue();
		System.out.println(cellValue);
		cell = row.getCell(1);
		cellValue = cell.getStringCellValue();
		System.out.println(cellValue);
		cell = row.getCell(2);
		cellValue = cell.getStringCellValue();
		System.out.println(cellValue);
	}

}
