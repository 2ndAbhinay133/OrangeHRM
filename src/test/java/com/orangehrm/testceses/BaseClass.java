package com.orangehrm.testceses;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.orangehrm.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass{
	
	
	
	public static  WebDriver driver;
	public static Logger Logger;
	ReadConfig readConfig;  
	
	    @BeforeClass
	    public void setup() {
	        readConfig = new ReadConfig();
			String projectName=new File(System.getProperty("user.dir")).getName();
			Logger=LogManager.getLogger(projectName);
			String browser=readConfig.getBrowser();
	        
	        switch (browser) {
	            case "chrome":
	                WebDriverManager.chromedriver().setup();
	                driver = new ChromeDriver();
	                break;
	            case "msedge":
	                WebDriverManager.edgedriver().setup();
	                driver = new EdgeDriver();
	                break;
	            case "firefox":
	                WebDriverManager.firefoxdriver().setup();
	                driver = new FirefoxDriver();
	                break;
	            default:
	                Logger.error("Invalid browser name provided: " + browser);
	                break;
	        }
	        
	        if (driver != null) {
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	            Logger.info("Browser setup complete.");
	            driver.get(readConfig.getBaseUrl());
	            Logger.info("URL opened: " + readConfig.getBaseUrl());
	        }
	    }
	    
	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	
		public void captureScreenShot(WebDriver driver,String testName)  
		{
		        if (driver instanceof TakesScreenshot) {
		            TakesScreenshot screenshot = (TakesScreenshot) driver;
		            File src = screenshot.getScreenshotAs(OutputType.FILE);
		            File dest = new File("./ScreenShots/ScreenShot" + testName + ".png");           
		            try {
		                FileUtils.copyFile(src, dest);
		                Logger.info("Screenshot captured: " + dest.getAbsolutePath());
		            } catch (IOException e) {
		                Logger.error("Failed to capture screenshot: " + e.getMessage());
		            }
		        } else {
		            Logger.error("Driver does not support taking screenshots.");
		        }
		}

		
}
		
