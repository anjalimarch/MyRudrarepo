package com.selenium.framework.datadriven.PortFolio;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.framework.datadriven.TestBase;
import com.selenium.framework.datadriven.util.Constants;
import com.selenium.framework.datadriven.util.TestDataProvider;
import com.selenium.framework.datadriven.util.Utility;
import com.selenium.framework.datadriven.util.Xls_Reader;

public class TopAssetsperTest  extends TestBase
{
	@BeforeTest
	public void initLogs(){
		initLogs(this.getClass());
	}
	
	@Test(dataProviderClass=TestDataProvider.class,dataProvider="suiteADataProvider")
	public void topperformingassetstest(Hashtable<String,String> table)// if 100 testcase then we will have to pass 100 paramters so use concept of hashtablew.....
	//..where column is one multiple rows n each row has column key with value as data 
	{
		APPLICATION_LOGS.debug("Login in to second test ");
		init();
		validateRunmodes(Constants.First_Suite_NAME,"TopPerformingAssetsTest",table.get(Constants.RUNMODE_COL_NAME));
	doDefaultLogin(table.get(Constants.Browser_Col_Name));
            boolean result=CheckTopPerAsset();
	System.out.println(result);
	
	
	}
	@AfterMethod
	public void close(){
		quit();
	}
	
	
	
	}
	
	
	
	
	





