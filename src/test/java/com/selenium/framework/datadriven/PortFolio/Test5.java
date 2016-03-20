package com.selenium.framework.datadriven.PortFolio;



import java.util.Hashtable;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.framework.datadriven.TestBase;
import com.selenium.framework.datadriven.util.Constants;
import com.selenium.framework.datadriven.util.TestDataProvider;
import com.selenium.framework.datadriven.util.Utility;
import com.selenium.framework.datadriven.util.Xls_Reader;

public class Test5 extends TestBase
{@BeforeTest
	public void initLogs(){
	initLogs(this.getClass());
}

	
	@Test(dataProviderClass=TestDataProvider.class,dataProvider="suiteADataProvider")
	public void test5(Hashtable<String,String> table)// if 100 testcase then we will have to pass 100 paramters so use concept of hashtablew.....
	//..where column is one multiple rows n each row has column key with value as data 
	{
		/*Xls_Reader xls=new Xls_Reader("D:\\files_frameworks\\Suite.xlsx");
	
	Utility.isSuiteRunnable("SuiteA",xls);
	Utility.isSuiteRunnable("SuiteB",xls);
    Utility.isSuiteRunnable("SuiteC",xls);
	
    Xls_Reader xlsl=new Xls_Reader("D:\\files_frameworks\\SuiteA.xlsx");
	
    Utility. isTestCaseRunnable("Test5",xlsl);
	
   // Utility. getData("Test5",xlsl);
	
	//System.out.println(Utility. getData("Test5",xlsl));*/
		APPLICATION_LOGS.debug("We are wrinting in  file");
		validateRunmodes(Constants.First_Suite_NAME,"Test5",table.get(Constants.RUNMODE_COL_NAME));
	}
	
	
	
	
	/*@DataProvider
	public Object[][] getData()
	{
		
		Xls_Reader xlsl=new Xls_Reader("D:\\files_frameworks\\SuiteA.xlsx");
		
	return	Utility.getData("Test5", xlsl);
		
		
	}/*on including hashtable output is
	PASSED: test1({Col6=C63, Col5=C53, Col4=C43, Col3=C33, Col2=C22, Col1=C11, Runmode=Y, Result=})
PASSED: test1({Col6=C64, Col5=C54, Col4=C45, Col3=C34, Col2=C23, Col1=C21, Runmode=N, Result=})
PASSED: test1({Col6=C65, Col5=C55, Col4=C46, Col3=C35, Col2=C24, Col1=C31, Runmode=Y, Result=})*/
	
	
}