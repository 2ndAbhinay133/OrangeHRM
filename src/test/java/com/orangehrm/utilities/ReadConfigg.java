package com.orangehrm.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfigg {
	
	Properties properties;
	
	public ReadConfigg() {
		try {
			FileInputStream fis=new FileInputStream("./Configuration/config.properties");
			properties=new Properties();
			properties.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String getBaseUrl() {
		
		String value=properties.getProperty("baseUrl");
		if(value!=null) {
			return value;
		}else {
			throw new RuntimeException("Browser not specified in file");
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
