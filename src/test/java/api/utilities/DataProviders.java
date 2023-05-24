package api.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

	//DataProvider 1

	/**
	 * For all data
	 * @return
	 * @throws IOException
	 */
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException
	{
		String path="C:\\Users\\Dogan\\IdeaProjects\\RestAssuredPetStoreAPI\\Userdata.xlsx";//taking xl file from testData
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String apidata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				apidata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	return apidata;//returning two dimension array
				
	}
	
	//DataProvider 2

	/**
	 * This will return only User-names !!!
	 * @return
	 * @throws IOException
	 */
	@DataProvider(name = "UserNames")
	public String[] getUserNames() throws IOException{
		String path=System.getProperty("user.dir")+"//Userdata.xlsx";
		ExcelUtility x1=new ExcelUtility(path);

		int rownum=x1.getRowCount("Sheet1");

		String apidata[]=new String[rownum];

		for(int i=1; i<=rownum; i++){
			apidata[i-1]=x1.getCellData("Sheet1",i,1);
		}

		return apidata;
	}
	
	//DataProvider 3
	
	//DataProvider 4
}
