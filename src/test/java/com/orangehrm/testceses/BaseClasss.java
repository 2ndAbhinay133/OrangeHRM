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

import com.orangehrm.utilities.ReadConfigg;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClasss {
	
	WebDriver driver;
	ReadConfigg readConfigg;
	Logger Logger;
	
	public void setup() {
		
		readConfigg=new ReadConfigg();
		String projectName=new File(System.getProperty("user.dir")).getName();
		Logger=LogManager.getLogger(projectName);
		String browser=readConfigg.getBrowser();
		
		switch(browser){
		
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
			Logger.error("Invalid browser name provided"+browser);
			break;
			
		}
		
		if(driver!=null) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Logger.info("Borwser setup is completed");
			driver.get(readConfigg.getBaseUrl());
			Logger.info("Base URl Opened"+browser);
		}
		
	}
	public void tesrDown() {
		if(driver!=null) {
			driver.close();
			driver.quit();
		}
	}
	public void captureScreenShot(WebDriver driver, String testName) {
		
		if(driver instanceof TakesScreenshot) {
				TakesScreenshot take= (TakesScreenshot)driver;
				File src=take.getScreenshotAs(OutputType.FILE);
				File dest=new File("./ScreenShots/capture"+testName+".png");
			
				try {
					FileUtils.copyFile(src, dest);
					Logger.info("ScreenShot captured"+dest.getAbsolutePath());
				} catch (IOException e) {
					Logger.error("Screen capturing failed"+e.getMessage());
				}
				
		}else {
			Logger.error("driver not supprted to takesscren shot");
		}
		
		
	}

}
