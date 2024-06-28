import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
	public ArrayList getData(String testcaseName) throws IOException {
//	testcaseName="Purchase";
		//Identify the testcase column by scannjng the entire 1st row
				//once column is identified then scan entire testcase column to identify purcase testcase row
				//after you grab purchase testcase row pull all the data of that row and feed into test
				ArrayList<String> a=new ArrayList();
				
				//FileInputstream argument
				FileInputStream fis=new FileInputStream("C://Users//885576//OneDrive - Cognizant//Demodata.xlsx/");
				//created object of the class and gave permission/patch of the file
				XSSFWorkbook workbook=new XSSFWorkbook(fis);
				//getting count of the sheet
				int sheets=workbook.getNumberOfSheets();
				for(int i=0;i<sheets;i++)
				{
					if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
					{
						XSSFSheet sheet = workbook.getSheetAt(i);
						//Identify the testcase column by scannjng the entire 1st row
						Iterator<Row> rows=sheet.iterator();//sheet is collection of rows
						Row firstrow=rows.next();
						Iterator<Cell> cell=firstrow.cellIterator();//row is collection of cells
						int k=0;
						int column=0;
						while(cell.hasNext())
						{
							Cell value=cell.next();
							if(value.getStringCellValue().equalsIgnoreCase("testcase")) 
							{
								//desired column
								column=k;
							}
							k++;
						}System.out.println(column);
						
						//once column is identified then scan entire testcase column to identify purchase test row
						while(rows.hasNext()) {
							Row value1=rows.next();
							if(value1.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)){
								//after you grab purchase testcase row pull all the data of that row and feed into test
								Iterator<Cell> cellvalue=value1.cellIterator();
								while(cellvalue.hasNext())
								{
									//Cell c=cellvalue.next();
									a.add(cellvalue.next().getStringCellValue());
									/*if(c.getCellType()==CellType.STRING) {
									a.add(cellvalue.next().getStringCellValue());
									}
									else
									{
										a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
									}*/
							
							}
						}
					}
					
				}
			}
				return a;
	}

	public static void main (String args[]) throws IOException {
		
		
}}
