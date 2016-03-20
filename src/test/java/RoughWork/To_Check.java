package RoughWork;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class To_Check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new FirefoxDriver();
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
		List<WebElement> allAssests = driver.findElements(By.cssSelector("span[id^='companyname'] a"));
		List<WebElement> allPercentages = driver.findElements(By.cssSelector("span[id^='totalgainper']"));
		String topperAsset=driver.findElement(By.xpath("//*[@id='perf']/div[1]/div/div[1]/h4")).getText();
		System.out.println(topperAsset);
		String temp []= topperAsset.split("\\(") ;
		String compName=temp[0].trim();
		System.out.println(compName);
		String percentagechange=temp[1].split("\\)")[0].split("\\%")[0];
		System.out.println(percentagechange);
		System.out.println("Total names = "+ allAssests.size());
		
		//System.out.println("Total buttons = "+ allButtons.size());
		int prodCount=0;
		for(int i=0;i< allAssests.size();i++){
			System.out.println("-- " +allAssests.get(i).getText());
			if( (compName.equals(allAssests.get(i).getText()))&& (percentagechange.equals(allPercentages.get(i).getText())) ){
				System.out.println("FOUND --- " +allAssests.get(i).getText());
			//	Assert.assertTrue(if((compName.equals(allAssests.get(i).getText()))), "Not fount"+allAssests.get(i).getText());
				 prodCount++;
				  System.out.println("FOUND --- " +allPercentages.get(i).getText());
				// Assert.assertTrue(if((compName.equals(allAssests.get(i).getText()))), "Not fount"+allAssests.get(i).getText());
			 }
	}//css=a[id*='id_pattern']css=span[id^='companyname'] a
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
