package api.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public FileInputStream fi;
	public FileOutputStream fO;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	public String path;
	
	public ExcelUtility(String path) {
			this.path = path;
	}
	
	public int getRowCount(String sheetName) throws IOException 
	{	
		
			fi= new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
			sheet= workbook.getSheet(sheetName);
			int rowcount= sheet.getLastRowNum();
			workbook.close();
			fi.close();
			return rowcount;
		
	}
	
	public int getCellCount(String sheetName, int rowNum) throws IOException {
		
		int cellcount;
		fi= new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet= workbook.getSheet(sheetName);
		row= sheet.getRow(rowNum);
		cellcount=row.getLastCellNum();
		return cellcount; 
	}
	
	public String getCellData(String sheetName, int rowNum, int ColNum) throws IOException {
		
		String data;
		
		fi= new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet= workbook.getSheet(sheetName);
		row= sheet.getRow(rowNum);
		cell= row.getCell(ColNum);
		
		DataFormatter formatter= new DataFormatter();
		
		data=formatter.formatCellValue(cell);
		workbook.close();
		fi.close();
		
		return data;
		
	}
	
	public String[][] getAllData(String sheetName) throws IOException {
			
		String[][] testdata;
			fi=new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
			sheet= workbook.getSheet(sheetName);
		
		testdata= new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				testdata[i][j]= sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		return testdata;
	}
	
	public String[] getDataFromColumn(String sheetName, int colNum) throws IOException {
		
		String[] data;
		fi=new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet= workbook.getSheet(sheetName);
		
		data= new String[sheet.getLastRowNum()];
		for (int i = 0; i < data.length; i++) {
			data[i]=sheet.getRow(i+1).getCell(colNum).toString();
		}
		
		return data;
		
	}
	
	
	

}
