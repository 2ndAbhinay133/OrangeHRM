package com.orangehrm.testceses;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.orangehrm.utilities.ReadConfigg;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TodayWork19_8_2023 {
	
	WebDriver driver;
	Logger Log;
	Logger lo;
	ReadConfigg readConfigg;
	public void setup() {
		
		String projectName=new File(System.getProperty("user.dir")).getName();
		String timeStamp=new SimpleDateFormat().format(new Date());
		Log=LogManager.getLogger(projectName);
		String browser=readConfigg.getBrowser();
		
		switch(browser) {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		default:
			Log.error("invalid browser name provided");
			break;
			
		}
		
		if(driver!=null) {
			
			Log.info("browser setup is completed");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(readConfigg.getBaseUrl());
			Log.info("Base Url is opened"+ readConfigg.getBaseUrl());
			
			
		}
	}
	
	public void tearDown() {
		
		if(driver!=null) {
			driver.close();
			driver.quit();
		}
	}
	public void captureScreenSHot(WebDriver driver ,String testName) {
		if(driver instanceof TakesScreenshot) {
			
			TakesScreenshot take=(TakesScreenshot)driver;
			File src=take.getScreenshotAs(OutputType.FILE);
			File dest=new File("./ScreenShots/capture"+testName+".png");
			try {
				FileUtils.copyFile(src, dest);
				Log.info("ScreenShot captured :"+dest.getAbsolutePath());
			} catch (IOException e) {
				Log.error("Cscreen capturing failed"+e.getMessage());				
			}
			
		}else {
			Log.error("driver not supprted to take screen shot");
		}
		
		
	}

}
