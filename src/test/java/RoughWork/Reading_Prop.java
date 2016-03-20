package RoughWork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.rmi.ssl.SslRMIClientSocketFactory;

public class Reading_Prop {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

	Properties prop =new Properties();
	String path ="D:\\RudranshFramework\\DataDrivenFramework_TestNG\\src\\test\\resources\\project.properties";
	FileInputStream fis=new FileInputStream(path);
	try {
		prop.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	System.out.println(prop.getProperty("name"));
	
	System.out.println(System.getProperty("user.dir"));
	
	}

}
