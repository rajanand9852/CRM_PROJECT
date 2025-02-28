package com.comcast.crm.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.Fileutility.BaseClass;
import com.comcast.crm.generic.Webdriverutility.UtilityClassObject;

public class listenerImplementationClass implements ITestListener,ISuiteListener {
	 public ExtentReports report;
	 public ExtentTest test;
	@Override
	
	public void onStart(ISuite suite) {
		
		System.out.println("Report configration");
		/* spark report config */
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM TEST SUITE RESULTS");
		spark.config().setReportName("CRM REPORTER");
		spark.config().setTheme(Theme.DARK);
		
		/* Add environment information */
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","window-10");
		report.createTest("BROWSER","CHROME-100");
	}

	@Override
	public void onFinish(ISuite suite) {
		
		//ISuiteListener.super.onFinish(suite);
		System.out.println("Report backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("===== ===="+result.getMethod().getMethodName()+">====START====");
		 test = report.createTest(result.getMethod().getMethodName());
		 UtilityClassObject.setTest(test);
		 test.log(Status.INFO,result.getMethod().getMethodName()+"==>STARTED<===");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("===== ===>"+result.getMethod().getMethodName()+">====END====");
		test.log(Status.PASS,result.getMethod().getMethodName()+"==>COMPLETED<===");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sDriver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		
		String time = new Date().toString().replace(" ", " ").replace(":", "_");
		System.out.println(time);
		
		test.addScreenCaptureFromBase64String(filepath,testName+ "-" +time);
		test.log(Status.FAIL,result.getMethod().getMethodName()+"==>FAILED<===");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
	
		ITestListener.super.onFinish(context);
	}

	

	
}

