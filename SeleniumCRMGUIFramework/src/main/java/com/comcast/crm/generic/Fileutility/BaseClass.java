package com.comcast.crm.generic.Fileutility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.Databaseutility.DataBaseUtility;
import com.comcast.crm.generic.Webdriverutility.JavaUtility;
import com.comcast.crm.generic.Webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.Webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.LoginPage;

public class BaseClass {
	DataBaseUtility dbLib=new DataBaseUtility();
	public FileUtility futil=new FileUtility();
	public ExcelUtility eutil=new ExcelUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	public JavaUtility jutil=new JavaUtility();
	public WebDriver driver=null;
	public static WebDriver sDriver=null;
	
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBaseClass() throws SQLException {
		
		System.out.println("====Connect to DB=======");
		dbLib.getDataBaseConnection();
		
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBeforeClass() throws IOException {
		String BROWSER = futil.getDataFromPropertiesFile("browser");
		String URL = futil.getDataFromPropertiesFile("url");
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			
		}
		else if (BROWSER.equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
		}
		sDriver=driver;
		UtilityClassObject.setDriver(driver);
		driver.get(URL);
		
		}
	
	
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configBeforeMethod() throws IOException {
		String USERNAME = futil.getDataFromPropertiesFile("username");
		String PASSWORD = futil.getDataFromPropertiesFile("password");
		LoginPage lg=new LoginPage(driver);
		lg.loginToApp(USERNAME, PASSWORD);
	}
	
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAfterMethod() {
		HomePage hp=new HomePage(driver);
		hp.logout();
	}
	
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAfterClass() {
	driver.quit();
		
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void configAfterSuite() {
		System.out.println("====Disconnect to DB====");
	}

}
