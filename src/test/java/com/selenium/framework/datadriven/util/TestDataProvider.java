package com.selenium.framework.datadriven.util;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.selenium.framework.datadriven.TestBase;

public class TestDataProvider {

@DataProvider(name="suiteADataProvider",parallel=true)
public static Object [][] getDataSuiteA(Method m){
	TestBase.init();
	Xls_Reader xlsl=new Xls_Reader(TestBase.prop.getProperty("xlsFileLocation")+Constants.First_Suite_NAME+".xlsx");
	return Utility.getData(m.getName(), xlsl);
	
	
}


@DataProvider(name="suiteBDataProvider",parallel=true)
public Object [][] getDataSuiteB(Method m){
	TestBase.init();
	Xls_Reader xlsl=new Xls_Reader(TestBase.prop.getProperty("xlsFileLocation")+Constants.Second_Suite_NAME+".xlsx");
	return Utility.getData(m.getName(), xlsl);
	
	
	
	
	
}





}
