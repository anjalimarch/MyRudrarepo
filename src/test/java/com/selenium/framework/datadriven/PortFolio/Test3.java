package com.selenium.framework.datadriven.PortFolio;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selenium.framework.datadriven.TestBase;
import com.selenium.framework.datadriven.util.Constants;
import com.selenium.framework.datadriven.util.ErrorUtil;
import com.selenium.framework.datadriven.util.TestDataProvider;

public class Test3 extends TestBase{
	@BeforeTest
	public void initLogs(){
		initLogs(this.getClass());
	}
	@Test(dataProviderClass=TestDataProvider.class,dataProvider="suiteADataProvider")
	public void test3(Hashtable<String,String> table)// if 100 testcase then we will have to pass 100 paramters so use concept of hashtablew.....
	//..where column is one multiple rows n each row has column key with value as data 
	{
		APPLICATION_LOGS.debug("Login in to third test ");
		init();
		validateRunmodes(Constants.First_Suite_NAME,"test3",table.get(Constants.RUNMODE_COL_NAME));
	doDefaultLogin(table.get(Constants.Browser_Col_Name));
         try{
  			Assert.assertTrue(verifyTitle("titlefor"), "Title does not match");
  			}catch(Throwable t){
  				ErrorUtil.addVerificationFailure(t);
  			}
	AddStock(table.get(Constants.Date_Col_Name) ,table.get(Constants.PurchasePrice_Col_Name),table.get(Constants.Quantity_Col_Name),table.get(Constants.StockName_Col_Name));

	
}
	
	@AfterMethod
	public void close(){
		quit();
	}




}
