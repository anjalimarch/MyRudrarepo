package com.selenium.framework.datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.SkipException;

import com.selenium.framework.datadriven.util.Constants;
import com.selenium.framework.datadriven.util.Utility;
import com.selenium.framework.datadriven.util.Xls_Reader;

public class TestBase {
	
	public static Properties prop;
	//public static Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
	public WebDriver driver;
	public  Logger APPLICATION_LOGS=null;;
	//= Logger.getLogger("devpinoyLogger");
	public void initLogs(Class<?> class1){
//Separate log for each test in my custom report function
		FileAppender appender = new FileAppender();
		// configure the appender here, with file location, etc
		appender.setFile(System.getProperty("user.dir")+"//target//reports//"+CustomListener.resultFolderName+"//"+class1.getName()+".log");
		appender.setLayout(new PatternLayout("%d %-5p [%c{1}] %m%n"));
		appender.setAppend(false);
		appender.activateOptions();

		APPLICATION_LOGS = Logger.getLogger(class1);
		APPLICATION_LOGS.setLevel(Level.DEBUG);
		APPLICATION_LOGS.addAppender(appender);
	}
	public static void init() {
		
		//APPLICATION_LOGS.debug("st case xy test");
		if(prop==null){
			        String path =	System.getProperty("user.dir")+"\\src\\test\\resources\\project.properties";
			
		              prop =new Properties();
		           
					try {
						 FileInputStream	fis = new FileInputStream(path);
					     prop.load(fis);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		
	}
		}
		
		
	

	public void validateRunmodes(String suiteName,String testName,String dataRunmode ){
	
		APPLICATION_LOGS.debug("validting runmode for "+testName+"in suite "+suiteName);
		init();
		boolean suiteRunmode=Utility.isSuiteRunnable(suiteName,new Xls_Reader(prop.getProperty("xlsFileLocation")+"Suite.xlsx"));
	
		
	    boolean testRunmode  = Utility. isTestCaseRunnable(testName,new Xls_Reader(prop.getProperty("xlsFileLocation")+suiteName+".xlsx"));
		boolean dataSetRunmode=false;
		if(dataRunmode.equals(Constants.RUNMODE_YES_NAME))
		
		{
			dataSetRunmode= true;
			
			}
		
		if(!(suiteRunmode&&testRunmode&&dataSetRunmode))
		{
			
			throw new SkipException ("Skipping the test "+testName+"inside the"+suiteName);
		}
		
		
		
		
	}
	
	/*<<<<<-----generic functions----------------------->>>>>>>>>>>>>>>>>>>>*/
	public void openBrowser(String browserName)
	{
		/*
		 * if(browserName.equals("Mozilla"))
		{
			
			driver=new FirefoxDriver();
		}else if(browserName.equals("Chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver",prop.getProperty("chromedriverexe"));
		driver= new ChromeDriver();
		}
			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		*/
		try{
		DesiredCapabilities cap = new DesiredCapabilities();
		if(browserName.equals("Mozilla")){
			cap.setBrowserName("firefox");
		}else if(browserName.equals("Chrome")){
			cap.setBrowserName("chrome"); // iexplore
		}
		   cap.setPlatform(Platform.ANY);
	
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}catch(Exception e){
			Assert.fail("Not able to open browser - "+e.getMessage());
			//Assert.fail("Not able to open browser - ");
			}

		
	
	}
		
	
public void navigate(String UrlKey){
	driver.get(prop.getProperty(UrlKey));
}
public void click(String identifire){
	
	if(identifire.endsWith("_xpath")){
		driver.findElement(By.xpath(prop.getProperty(identifire))).click();
		
	}else if(identifire.endsWith("_id")){
		driver.findElement(By.id(prop.getProperty(identifire))).click();
		
	}else if(identifire.endsWith("_name")){
		driver.findElement(By.name(prop.getProperty(identifire))).click();
		
	}}
	public void input(String identifire,String data ){
		if(identifire.endsWith("_xpath")){
			driver.findElement(By.xpath(prop.getProperty(identifire))).sendKeys(data);
			//driver.findElement(By.xpath(prop.getProperty(identifire))).sendKeys(Keys.ENTER);
		}else if(identifire.endsWith("_id")){
			driver.findElement(By.id(prop.getProperty(identifire))).sendKeys(data);
			
		}else if(identifire.endsWith("_name")){
			driver.findElement(By.name(prop.getProperty(identifire))).sendKeys(data);
			
		}
	}
	
	public boolean isElementpresent(String identifire){
		int size=0;
	if(identifire.endsWith("_xpath"))
			size=driver.findElements(By.xpath(prop.getProperty(identifire))).size();
	else if(identifire.endsWith("_id"))
			size=driver.findElements(By.id(prop.getProperty(identifire))).size();
	else if(identifire.endsWith("_name"))
		size=	driver.findElements(By.name(prop.getProperty(identifire))).size();
	else
		size=	driver.findElements(By.xpath(identifire)).size();
	if(size>0)
         return true;
	else
		return false;
}	
	public void quit(){
		if(driver!=null){
			driver.quit();
			driver=null;
		}
	}

public boolean verifyTitle(String expectedTitleKey){
	String ExpectedTitle=prop.getProperty(expectedTitleKey);
	System.out.println(ExpectedTitle);
String actualTitle=driver.getTitle();
System.out.println(actualTitle);
if (ExpectedTitle.equals(actualTitle))
	       return true;
else
		return false;
}


/**********Application specific functions **********/
public void doLogin(String browser,String username,String password)
{
	openBrowser(browser);
	 navigate("testSiteUrl");
	  //verify money link
   Assert.assertTrue(isElementpresent("moneyLink_xpath"), "Element not found-moneyLink_xpath-not working");
	click("moneyLink_xpath");
	click("myPortfolio_xpath");
	Assert.assertTrue(verifyTitle("expectingportfoliotitle"), "title did not match");
	input("loginusername_xpath",username);
	click("loginusernamecontinue_xpath");
	input("loginpassword_xpath",password);
	click("logincontinue_xpath");

try {
	Thread.sleep(3000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}}

public void doDefaultLogin(String browser){
	doLogin(browser,prop.getProperty("defaultLogin"),prop.getProperty("defaultPassword"));
}

public String getText(String identifire){
	String text="";
	if(identifire.endsWith("_xpath")){
		
		text=driver.findElement(By.xpath(prop.getProperty(identifire))).getText();
	
	}
	else if(identifire.endsWith("_id")){
		text=driver.findElement(By.id(prop.getProperty(identifire))).getText();
		
	}
	else if(identifire.endsWith("_name")){
		text=driver.findElement(By.name(prop.getProperty(identifire))).getText();
		
	}
return text ;
}
public List<WebElement> AllListElement(String identifire){
	
	List<WebElement> allElements =null;
        if(identifire.endsWith("_css")){	
        	    allElements=driver.findElements(By.cssSelector(prop.getProperty(identifire)));
         }
		
     
	if(identifire.endsWith("_xpath")){
		
		allElements=driver.findElements(By.xpath(prop.getProperty(identifire)));
	
	}
	else if(identifire.endsWith("_id")){
		allElements=driver.findElements(By.id(prop.getProperty(identifire)));
		
	}
	else if(identifire.endsWith("_name")){
		allElements=driver.findElements(By.name(prop.getProperty(identifire)));
		
	}
return allElements ;
}
public boolean CheckTopPerAsset(){
	List<WebElement>allAssests=AllListElement("AllAssests_css");
	List<WebElement> allPercentages = AllListElement("AllPercentge_css");
	//By.cssSelector("span[id^='companyname'] a
	String topperAsset=getText("topperasset_xpath");
	System.out.println(topperAsset);
	String temp []= topperAsset.split("\\(") ;
	String compName=temp[0].trim();
	System.out.println(compName);
	String percentagechange=temp[1].split("\\)")[0].split("\\%")[0];
	System.out.println(percentagechange);
	System.out.println("Total names = "+ allAssests.size());
	
	boolean flag=false ;
	int prodCount=0;
	for(int i=0;i< allAssests.size();i++){
		System.out.println("-- " +allAssests.get(i).getText());
		
		
		 if( (compName.equals(allAssests.get(i).getText()))&& (percentagechange.equals(allPercentages.get(i).getText())) ){
			  flag= true;
			 System.out.println("FOUND --- " +allAssests.get(i).getText());
			 System.out.println("FOUND --- " +allPercentages.get(i).getText());
			 Assert.assertTrue(flag, "Not fount"+allAssests.get(i).getText());
		     Assert.assertTrue(flag, "Not fount"+allPercentages.get(i).getText());
			      prodCount++;
			      }
			     
		 
		 }
	return flag;	

}

public void AddStock(String date ,String Purchaseprice,String quantity,String stockname){
	//driver.findElement(By.xpath("//*[@id='addStock']")).click();
	click("AddStock_xpath");
	//driver.findElement(By.xpath("//*[@id='addstockname']")).sendKeys("Asian Paints Ltd.");
	input("AddStockname_xpath",stockname);
	//*[@id='addstockname']
	//*[@id='stockPurchaseDate']
	//driver.findElement(By.xpath("//*[@id='stockPurchaseDate']")).click();
	
//String  month_year=driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[3]/div")).getText();

//System.out.println( month_year);


//driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[4]/button")).click();

//Actions act=new Actions (driver);

//act.moveToElement(driver.findElement(By.xpath("//td[@class='dpTDHover']"))).build().perform();
//System.out.println(driver.findElements(By.xpath("//td[@class='dpTDHover']")).size());
//act.click().build().perform();
//((JavascriptExecutor)driver).executeScript("updateDateField('stockAddDate', '11-04-2016');");//changeTripType() this is onclick functionto move mouse

//((JavascriptExecutor)driver).executeScript(" document.getElementsByClassName('dpTDHover').click()");
//driver.findElement(By.xpath("//*[@id='addStockButton']")).click();
//((JavascriptExecutor)driver).executeScript("document.getElementById('oneway').click()")
//Making_Date  sel=new Making_Date();
try {
	selectDate(date);
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
//String y="11-04-2016";



//driver.findElement(By.xpath("//*[@id='addStockButton']")).click();
//*[@id='addStockButton']
input("AddStockqty_xpath",quantity);   
//driver.findElement(By.xpath("//*[@id='addstockqty']")).sendKeys("10");
input("AddStockprice_xpath",Purchaseprice);
//driver.findElement(By.xpath("//*[@id='addstockprice']")).sendKeys("11");
click("Addexchange_xpath");
//driver.findElement(By.xpath("//*[@id='exchange_tab']/label[3]")).click();
click("AddStockButton_xpath");
//driver.findElement(By.xpath("//input[@id='addStockButton']")).click();
}//*[@id='addStockButton']

public  void selectDate(String date) throws ParseException  {

SimpleDateFormat df = new 	SimpleDateFormat("dd-MM-yyyy");

Date date_to_be_selected =df.parse(date);

Date currentday=new Date();
click("stockPurchaseDate_xpath");
String  month_year=getText("datepicker_xpath");

System.out.println( month_year);


System.out.println(month_year);

//this line will return the date in string format
String day=new 	SimpleDateFormat("dd").format(date_to_be_selected );
//this line will return month in string format
String month= new SimpleDateFormat("MMMMMMM").format(date_to_be_selected);
//similarly return year
String year=new SimpleDateFormat("yyyy").format(date_to_be_selected);

System.out.println(day+month+year);
//put the given date month and year in one string to compare
String month_year_Exracted=month+" "+year;
System.out.println(month_year_Exracted);

String monthone= new SimpleDateFormat("MM").format(date_to_be_selected);
System.out.println(monthone);

//int monthcoversiontoint=Integer.parseInt(monthone);
//monthcoversiontoint=monthcoversiontoint-1;
//String conversiontostring=String.valueOf(monthcoversiontoint);
String dayone=day+"-"+monthone+"-"+year;
System.out.println(dayone);


while(true){

if(month_year_Exracted.equals(month_year))
{
//((JavascriptExecutor)driver).executeScript("updateDateField('stockAddDate', '"+dayone+"');");
	//above  javascript is also woking fine
	driver.findElement(By.xpath("//td[text()='"+day+"']")).click();
	//td[text()=day]
	//click("day_xpath");
System.out.println("found and selected");
break;


}
else{ 

if(date_to_be_selected .after(currentday))
{
click("datepickerright_xpath");
	
	
}else
{
click("datepickerleft_xpath");

}



}
//again initialize becaz in cache memory these strings will be lost	

month_year=getText("datepicker_xpath");
}
}

	
	
	
	
	
	
}










	
	
	

