package RoughWork;

import java.util.Arrays;

public class string_split {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	String text="HDFC Bank (8,348.75%)";
	
	String temp []= text.split("\\(") ;
	System.out.println(temp[0].trim());
	
	
	
	System.out.println(temp[1].split("\\)")[0].split("\\%")[0]);
	
	
	
	
	
	
	}

}
