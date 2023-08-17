package com.orangehrm.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	
	String path="G:\\EclipseWorkspace\\SeleFramWrk_ORANGE_HRM\\Configuration\\config.properties";
	
	public ReadConfig() {
		
		properties=new Properties();
		try {
			FileInputStream fis=new FileInputStream(path);
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
			throw new RuntimeException("Base Url not specified in configuration files");
		}
	}
	
	public String getBrowser() {	
		String value=properties.getProperty("browser");
		if(value!=null) {
			return value;
		}else {
			throw new RuntimeException("browser not specified in url");
		}
	}

}
