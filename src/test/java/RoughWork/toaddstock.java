package RoughWork;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;
import com.sun.jna.platform.win32.Wdm.KEY_BASIC_INFORMATION;

public class toaddstock {public static WebDriver driver;

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		//WebDriver driver= new ChromeDriver();
				 driver=new FirefoxDriver();
				driver.get("http://in.rediff.com/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//*[@id='homewrapper']/div[5]/a[3]/div/u")).click();
				
				driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/ul/li[2]/a")).click();
				driver.findElement(By.xpath("//*[@id='useremail']")).sendKeys("anjalimarch24@gmail.com");
				driver.findElement(By.xpath("//*[@id='emailsubmit']")).click();
				driver.findElement(By.xpath("//*[@id='userpass']")).sendKeys("rudransh");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(By.xpath("//*[@id='loginsubmit']")).click();
				System.out.println(driver.findElements(By.xpath("//*[@id='signin_info']/a")).size());
				System.out.println("login complete");
				driver.findElement(By.xpath("//*[@id='addStock']")).click();
				driver.findElement(By.xpath("//*[@id='addstockname']")).sendKeys("Asian Paints Ltd.");
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
	selectDate("11-04-2016");
	//String y="11-04-2016";
	
	
	
	//driver.findElement(By.xpath("//*[@id='addStockButton']")).click();
	//*[@id='addStockButton']
	driver.findElement(By.xpath("//*[@id='addstockqty']")).sendKeys("10");
	driver.findElement(By.xpath("//*[@id='addstockprice']")).sendKeys("11");
	driver.findElement(By.xpath("//*[@id='exchange_tab']/label[3]")).click();
	driver.findElement(By.xpath("//input[@id='addStockButton']")).click();
	
	}//*[@id='addStockButton']

public static void selectDate(String date) throws java.text.ParseException {

	SimpleDateFormat df = new 	SimpleDateFormat("dd-MM-yyyy");
	 
		Date date_to_be_selected =df.parse(date);
	
     Date currentday=new Date();
     driver.findElement(By.xpath("//*[@id='stockPurchaseDate']")).click();
		
		String  month_year=driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[3]/div")).getText();
	
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
((JavascriptExecutor)driver).executeScript("updateDateField('stockAddDate', '"+dayone+"');");

		System.out.println("found and selected");
	break;
	
	
	}
		else{ 
			
			if(date_to_be_selected .after(currentday))
			{
				driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[4]/button")).click();
				
				
			}else
			{
			driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[2]/button")).click();
		
			}
			
			
			
		    }
//again initialize becaz in cache memory these strings will be lost	
	 month_year=driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[3]/div")).getText();

	}
}}
	
	
	
	

	
	
	
