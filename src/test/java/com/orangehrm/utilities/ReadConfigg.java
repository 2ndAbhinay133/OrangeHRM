package com.orangehrm.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfigg {
	
	
	private Properties properties;
	public static void main(String[] args) {
		ReadConfigg r=new  ReadConfigg();
		System.out.println(r.getBrowser());
	}
	
	public ReadConfigg() {
		
		properties=new Properties();
		
		try {
			FileInputStream fis=new FileInputStream("./Configuration/config.properties");
			properties.load(fis);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
	public String getBaseUrl() {
		
		String value=properties.getProperty("baseUrl");
		if(value!=null) {
			return value;
		}else {
			throw new RuntimeException("base url not specified in config file");
		}
		
	}
	public String getBrowser() {
		String value=properties.getProperty("browser");
		if(value!=null) {
			return value;
		}else {
			throw new RuntimeException("browser not specified in file");
		}
	}
	

}
