package com.qa.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	
	ExtentHtmlReporter htmlreporter;
	ExtentReports xreports;
	ExtentTest xtest;
	
	
	
	
	 public void onStart(ITestContext testContext) {
		 
		 
		 String timestamp=new SimpleDateFormat("yyyy.MM.DD.HH.mm.ss").format(new Date());
		 String RepName="Test-execution-report"+timestamp+".html";
		 
		 String dest=System.getProperty("user.dir")+"/Reports/"+RepName;
		 
		 
		 htmlreporter=new ExtentHtmlReporter(dest);
		 htmlreporter.config().setDocumentTitle("Automation testing");
		 htmlreporter.config().setReportName("Functional testing");
		 htmlreporter.config().setTheme(Theme.DARK);
		 htmlreporter.config().setAutoCreateRelativePathMedia(true);
		 
		 xreports=new ExtentReports();
		 xreports.attachReporter(htmlreporter);
		 xreports.setSystemInfo("hostname", "localhost");
		 xreports.setSystemInfo("QA Name", "sandeep");
		 
		 
		 
	  }

	 
	  public void onFinish(ITestContext testContext) {
		  
		  xreports.flush();
		  
		  
	  }

	
 
	  public void onTestSuccess(ITestResult tr) {
		  
		  xtest=xreports.createTest(tr.getName());
		  xtest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		  xtest.log(Status.PASS, "Test is passed");
	   
	  }

	 
	  public void onTestFailure(ITestResult tr) {
		  
		  xtest=xreports.createTest(tr.getName());
		  xtest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		  xtest.log(Status.FAIL, "Test is failed");
		  xtest.log(Status.FAIL, tr.getThrowable());
		  
		  String path = System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
		  File file = new File(path);
		  if(file.exists()) {
			  try {
				  xtest.fail("Screenshot for the failed test is ;"+ xtest.addScreenCaptureFromPath(path));
			  }catch(IOException e) {
				  e.printStackTrace();
			  }
		  }
	   
	  }

	  
	  public void onTestSkipped(ITestResult tr) {
	   
		  xtest=xreports.createTest(tr.getName());
		  xtest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));
		  xtest.log(Status.SKIP, "Test is Skipped");
		  xtest.log(Status.SKIP, tr.getThrowable());
	  }
}