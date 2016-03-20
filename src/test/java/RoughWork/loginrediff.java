package RoughWork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class loginrediff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		//WebDriver driver= new ChromeDriver();
		WebDriver driver=new FirefoxDriver();
		driver.get("http://in.rediff.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='homewrapper']/div[5]/a[3]/div/u")).click();
		
		driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id='useremail']")).sendKeys("anjalimarch24@gmail.com");
		driver.findElement(By.xpath("//*[@id='emailsubmit']")).click();
		driver.findElement(By.xpath("//*[@id='userpass']")).sendKeys("Rudransh");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id='loginsubmit']")).click();
		System.out.println(driver.findElements(By.xpath("//*[@id='signin_info']/a")).size());
		System.out.println("login complete");
		
	
	}

}
