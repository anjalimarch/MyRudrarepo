package RoughWork;

import com.selenium.framework.datadriven.util.Constants;
import com.selenium.framework.datadriven.util.Xls_Reader;

public class ReadingData {
public static void main (String args[])

{
	Xls_Reader xls= new 	Xls_Reader ("D:\\files_frameworks\\SuiteA.xlsx");
	int rows= xls.getRowCount(Constants.DATA_SHEET_NAME);
	System.out.println(rows);
	String testName="Test4";
	
	//finding the row no of  the given  testcaseinthis case test3
	int testCaseRowNum=1;
	for (testCaseRowNum=1;testCaseRowNum<=rows;testCaseRowNum++)
	{
		String testnamexls=xls.getCellData(Constants.DATA_SHEET_NAME, 0, testCaseRowNum);
		
	
	if ( testnamexls.equals(testName)){
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


//we have testrows and test cols for the data sheet for particular test sheet so now find out the data
for(int rNUM=datastartRowNum;rNUM<=(datastartRowNum+testRows);rNUM++){
	for(int cNUM=0;cNUM<testCols;cNUM++)
	{
		
		System.out.println (xls.getCellData(Constants.DATA_SHEET_NAME, cNUM, rNUM));
		
	}
	
	
	
}
/*26
17
2
3
Y

C11
Y

C31
*/





}









}





