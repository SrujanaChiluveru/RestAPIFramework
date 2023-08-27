package api.Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "UserAlldata")
	public String[][] getUserData() throws IOException
	{
		String[][] data;
		
		String path=System.getProperty("user.dir")+"//testdata//UserData.xlsx";
		
		ExcelUtility exceldata = new ExcelUtility(path);
		data= exceldata.getAllData("User");
		
		return data;
	}
	
	@DataProvider(name = "UserName")
	public String[] getUserNames() throws IOException 
	{
		String[] data;
		String path=System.getProperty("user.dir")+"//testdata//UserData.xlsx";
		
		ExcelUtility exceldata = new ExcelUtility(path);
		data= exceldata.getDataFromColumn("User", 1);
		return data;
	}

}

