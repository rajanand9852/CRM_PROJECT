package practiceSample;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
	ExtentReports report;
	@BeforeSuite
	public void config() {
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
	@AfterSuite
	public void configAS() {
		report.flush();
		//System.out.println("login to app");
		
	}
	@Test
	public void CreateContactTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
	
		
		ExtentTest test = report.createTest("CreateContactTest");
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"contact is created");
		}else {
			test.addScreenCaptureFromBase64String(filepath,"ErrorFile");
			//test.log(Status.FAIL,"contact is not created");
		}
		//report.flush();
		driver.close();
		
		
	}

}
