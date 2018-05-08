package TV3POIAPIPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreatingWorkbookSheetCells {

	public static void main(String[] args) throws InvalidFormatException, IOException {

		OutputStream out = new FileOutputStream(System.getProperty("user.dir")+"\\Data\\Test.xlsx");
		Workbook wbook = new XSSFWorkbook();
		Sheet sheet = wbook.createSheet("newsheet");
		Row row = sheet.createRow(1);
		Cell cell = row.createCell(0);
		cell.setCellValue("My First XLS File creation");
		CreationHelper ch = wbook.getCreationHelper();
		row.createCell(1).setCellValue(ch.createRichTextString("2nd Colmn Value RIch Text String"));
		row.createCell(2).setCellValue("true");
		wbook.write(out);
		out.close();
		

	}

}
