package excelDataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvide {
	@Test(dataProvider="dataTest")
	public void testData(String greeting,String name,String id) {
		System.out.println(greeting+" "+name+" "+id);
	}
@DataProvider(name="dataTest")
public Object[][] getData() throws IOException
{
	//Object[][] data= {{"Hi","Preethi","1"},{"Bye","Roshan","143"}};
	//every row of excel should be sent as one array
	DataFormatter formatter=new DataFormatter();
	FileInputStream fis=new FileInputStream("C://Users//885576//OneDrive - Cognizant//excelDriven.xlsx/");
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	XSSFSheet sheet=workbook.getSheetAt(0);
	int rowcount=sheet.getPhysicalNumberOfRows();
	XSSFRow row=sheet.getRow(0);
	int colcount=row.getLastCellNum();
	Object[][] data= new Object[rowcount-1][colcount];
	for(int i=0;i<rowcount-1;i++)
	{
		row=sheet.getRow(i+1);
		for(int j=0;j<colcount;j++)
		{
			XSSFCell cell=row.getCell(j);
			data[i][j]=formatter.formatCellValue(cell);
		}
	}
	
	return data;
}
}
