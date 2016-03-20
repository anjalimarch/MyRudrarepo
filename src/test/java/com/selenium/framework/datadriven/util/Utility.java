package com.selenium.framework.datadriven.util;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;

import com.sun.corba.se.impl.orbutil.closure.Constant;

public class Utility {
	

	public static boolean  isSuiteRunnable(String suiteName, Xls_Reader xls) 
	{
		// TODO Auto-generated method stub
		int rows=xls.getRowCount(Constants.SUITE_SHEET_NAME);
	//	System.out.println(xls.getRowCount(Constants.SUITE_SHEET_NAME));
	for(int rNum=2;rNum<=rows;rNum++)
	{
		String data=xls.getCellData(Constants.SUITE_SHEET_NAME,Constants.SUITE_COL_NAME ,rNum);
	
	//System.out.println(data);
	
	  if(data.equals(suiteName))
	    {
		String runmode=xls.getCellData(Constants.SUITE_SHEET_NAME, Constants.RUNMODE_COL_NAME, rNum);
	  
	   if(runmode.equals(Constants.RUNMODE_YES_NAME))
	     {
		  return true;
	        }else 
	             {
		          return false;
	              }
	  
	    }//if
	
	
	}//for
	return false;
	
	}//method
	

	public static boolean  isTestCaseRunnable(String testName, Xls_Reader xls) {
		
		int rows=xls.getRowCount(Constants.TESTCASES_SHEET_NAME);
	//	System.out.println(xls.getRowCount(Constants.TESTCASES_SHEET_NAME));
	for(int rNum=2;rNum<=rows;rNum++)
	{
		String data=xls.getCellData(Constants.TESTCASES_SHEET_NAME,Constants.TESTCASES_COL_NAME ,rNum);
	
	//System.out.println(data);
	
	  if(data.equalsIgnoreCase(testName))
	    {
		String runmode=xls.getCellData(Constants.TESTCASES_SHEET_NAME, Constants.RUNMODE_COL_NAME, rNum);
	  
	   if(runmode.equals(Constants.RUNMODE_YES_NAME))
	     {
		  return true;
	        }else 
	             {
		          return false;
	              }
	  
	    }//if
		
	}//for	
		
	return false;
		
		
	}

public static Object [][] getData(String testName,Xls_Reader xls){
	

	int rows= xls.getRowCount(Constants.DATA_SHEET_NAME);
	System.out.println(rows);
	//String testName="Test4";
	
	//finding the row no of  the given  testcaseinthis case test3
	int testCaseRowNum=1;
	for (testCaseRowNum=1;testCaseRowNum<=rows;testCaseRowNum++)
	{
		String testnamexls=xls.getCellData(Constants.DATA_SHEET_NAME, 0, testCaseRowNum);
		
	
	if ( testnamexls.equalsIgnoreCase(testName)){
		break;
	   }
	
	
	}
		System.out.println( testCaseRowNum);
	
	int datastartRowNum=testCaseRowNum+2;
	int colstartRowNum=testCaseRowNum+1;
	
	//rows of data 
	int testRows=1;
	//iterate from up to down
	while(! xls.getCellData(Constants.DATA_SHEET_NAME, 0, datastartRowNum+testRows).equals(""))
	{
		
		testRows++;
		
	}
System.out.println( testRows);

//cols of data ,remeber in xl columns start from index 0 and row from 1 iterate from left to right

int testCols=0;
// iterate from left to right
while(! xls.getCellData(Constants.DATA_SHEET_NAME, testCols, colstartRowNum).equals(""))
{
	
	testCols++;
	
}

System.out.println(testCols);
Object [][] data= new Object[testRows][1];

//we have testrows and test cols for the data sheet for particular test sheet so now find out the data

int r=0;
for(int rNUM=datastartRowNum;rNUM<(datastartRowNum+testRows);rNUM++){
	Hashtable<String,String> table = new Hashtable<String,String>();
	
	
	for(int cNUM=0;cNUM<testCols;cNUM++)
	{
		
		//System.out.println (xls.getCellData(Constants.DATA_SHEET_NAME, cNUM, rNUM));
		
	//data[r][cNUM]=xls.getCellData(Constants.DATA_SHEET_NAME, cNUM, rNUM);
	
	table.put(xls.getCellData(Constants.DATA_SHEET_NAME, cNUM, colstartRowNum), xls.getCellData(Constants.DATA_SHEET_NAME, cNUM, rNUM));
	
	
	}
	data[r][0]=table;
	r++;
	
	
	}

return data;

}


}


	
