package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	private static XSSFWorkbook wBook;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	private static XSSFCell cell;
	
	public static void setExcelPath(String sheetName, String path) throws IOException
	{
		FileInputStream fis= new FileInputStream(path);
		wBook= new XSSFWorkbook(fis);
		sheet= wBook.getSheet(sheetName);
	}
	
	public static String getCellData(int rowNum, int colNum)
	{
		return sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
	}
	
	public static String[][] getExcelTable()
	{
		int rowcount=sheet.getLastRowNum();
		int col=2;
		String[][] table=new String[rowcount+1][col];
		for(int i=0;i<rowcount+1;i++)
		{
			for(int j=0;j<col;j++)
			{
				table[i][j]=getCellData(i,j);
			}
		}
		return table;
	}
	
	public static void setExcelCell(int rownum,int colnum, String cellData) throws IOException
	{
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum, MissingCellPolicy.RETURN_BLANK_AS_NULL);
		if(cell==null)
		{
			cell=row.createCell(colnum);
			cell.setCellValue(cellData);
		}
		else
			cell.setCellValue(cellData);
		FileOutputStream fos=new FileOutputStream("C:\\Users\\A06438_P5.Training\\Desktop\\Training_AdvanceSelenium\\testdata.xlsx");
		wBook.write(fos);
		fos.flush();
		fos.close();
		
	}
}
