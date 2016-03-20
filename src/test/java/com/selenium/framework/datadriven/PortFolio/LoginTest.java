package com.selenium.framework.datadriven.PortFolio;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.framework.datadriven.TestBase;
import com.selenium.framework.datadriven.util.Constants;
import com.selenium.framework.datadriven.util.ErrorUtil;
import com.selenium.framework.datadriven.util.TestDataProvider;
import com.selenium.framework.datadriven.util.Utility;
import com.selenium.framework.datadriven.util.Xls_Reader;

public class LoginTest extends TestBase
{
	@BeforeTest
	public void initLogs(){
		initLogs(this.getClass());
	}

	
	@Test(dataProviderClass=TestDataProvider.class,dataProvider="suiteADataProvider")
	public void logintest(Hashtable<String,String> table)// if 100 testcase then we will have to pass 100 paramters so use concept of hashtablew.....
	//..where column is one multiple rows n each row has column key with value as data 
	{
		APPLICATION_LOGS.debug("Weng in  file");
		init();
		
	
		validateRunmodes(Constants.First_Suite_NAME,"LoginTest",table.get(Constants.RUNMODE_COL_NAME));
	
	/*openBrowser(table.get(Constants.Browser_Col_Name));
	 navigate("testSiteUrl");
	 // verify money link
   Assert.assertTrue(isElementpresent("moneyLink_xpath"), "Element not found-moneyLink_xpath-not working");
	click("moneyLink_xpath");
	click("myPortfolio_xpath");
	Assert.assertTrue(verifyTitle("expectingportfoliotitle"), "title did not match");
	input("loginusername_xpath",table.get(Constants.Username_Col_Name));
	click("loginusernamecontinue_xpath");
	input("loginpassword_xpath",table.get(Constants.Password_Col_Name));
	click("logincontinue_xpath");*/
	doLogin(table.get(Constants.Browser_Col_Name),table.get(Constants.Username_Col_Name),table.get(Constants.Password_Col_Name));
	
		boolean signoutLink=isElementpresent("signout_xpath");
	System.out.println(signoutLink);
	if(!(table.get(Constants.EXPECTEDRESULT_Col_Name).equals("SUCCESS")&& signoutLink))
	        Assert.fail("Not able to login with correct credential ");
	if(table.get(Constants.EXPECTEDRESULT_Col_Name).equals("FAILURE")){
	        if(signoutLink)
               Assert.fail(" login with incorrect credential ");
	}
	try{
			Assert.assertTrue(verifyTitle("titlefor"), "Title does not match");
			}catch(Throwable t){
				ErrorUtil.addVerificationFailure(t);
			}
	}
	@AfterMethod
	public void close(){
		quit();
	}
	
	
	
	
	




}
