package com.orangehrm.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent1 implements ITestListener {
	
	
		private ExtentReports htmlreports;
		private ExtentSparkReporter sparkReporter;
		private ExtentTest test;
		
	
		public void reportConfig() {
			
			ReadConfigg readConfigg=new ReadConfigg();
			String projectName=new File(System.getProperty("user.dir")).getName();
			String timeStamp=new SimpleDateFormat().format(new Date());
			htmlreports=new ExtentReports();
			sparkReporter=new ExtentSparkReporter("./ExtentReports/report"+projectName+timeStamp+".html");
			htmlreports.attachReporter(sparkReporter);
			
			htmlreports.setSystemInfo("OS", "Windows");
			htmlreports.setSystemInfo("Machine", "* GB RAM HP");
			htmlreports.setSystemInfo("User", "abhinay");
			htmlreports.setSystemInfo("browser", readConfigg.getBrowser());
			
			sparkReporter.config().setDocumentTitle(projectName);
			sparkReporter.config().setReportName("extent report of "+projectName);
			sparkReporter.config().setTheme(Theme.DARK);
				
		}

		public void	onStart​(ITestContext context) {
			reportConfig();
			System.out.println("on start method is invoke...");	
		}
		
		public void	onFinish​(ITestContext context) {
			System.out.println("on finish method is invoke..");
			htmlreports.flush();
			
		}
		public void	onTestStart​(ITestResult result) {
			
			System.out.println("Name of test method started :"+result.getName());
			
		}
		public void onTestFailure​(ITestResult result) {
			
			test=htmlreports.createTest(result.getName());
			test.log(Status.FAIL,MarkupHelper.createLabel("Name of Failed method is : "+result.getName(),ExtentColor.RED));
	
		}
		public void onTestSkipped​(ITestResult result) {
			test=htmlreports.createTest(result.getName());
			test.log(Status.SKIP,MarkupHelper.createLabel("the name of skipped methos is"+result.getName(), ExtentColor.YELLOW));
			
		}
		public void	onTestSuccess​(ITestResult result) {
			test=htmlreports.createTest(result.getName());
			test.log(Status.PASS, MarkupHelper.createLabel("the name of passed method is : "+result.getName(), ExtentColor.GREEN));
			
		}
	

}
