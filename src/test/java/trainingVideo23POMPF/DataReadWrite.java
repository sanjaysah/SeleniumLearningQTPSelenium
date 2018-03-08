package trainingVideo23POMPF;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataReadWrite {
	
	@Test(dataProvider="getData")
	public void testA(Hashtable<String,String> data){
		
	}
	
	@DataProvider
	public Object[][] getData(){
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"\\Data\\"+"DataTest.xlsx");
		String testCaseName="TestB";
		String sheetName = "DataRunmode";
		
		//Find Row No from where Test Case details starts
		int testStartRowNo = 1;
		while(!xls.getCellData(sheetName, 0, testStartRowNo).equals(testCaseName)){
			testStartRowNo++;
		}
		
		int colStartRowNo = testStartRowNo+1;
		int dataStartRowNo = testStartRowNo+2;
		System.out.println(colStartRowNo+" - "+dataStartRowNo);
		
		//Count No of rows of Data in mentioned TC
		int rows=0;
		while(!xls.getCellData(sheetName, 0, dataStartRowNo+rows).equals("")){
			rows++;
		}
		System.out.println("No of rows of Data are - "+rows);
		
		//Count No of rows of Data in mentioned TC
		int cols=0;
		while(!xls.getCellData(sheetName, cols, colStartRowNo).equals("")){
			cols++;
		}
		System.out.println("No of cols of Data are - "+cols);
		Object[][] data = new Object[rows][1];
		Hashtable<String, String> table;
		int dataRow=0;
		for(int rNum=dataStartRowNo;rNum<dataStartRowNo+rows;rNum++){
			table=new Hashtable<String, String>();
			for(int cNum=0;cNum<cols;cNum++){
				String key = xls.getCellData(sheetName, cNum, colStartRowNo);
				String value = xls.getCellData(sheetName, cNum, rNum);
				//System.out.println("Row No - "+rNum+" Colm No - "+cols+" - Data is - "+data);
				// OR you can store data into 2 dimensional array from HashTable
				table.put(key, value);
			}
			data[dataRow][0]=table;
			dataRow++;
		}
		return data;
	}

}
