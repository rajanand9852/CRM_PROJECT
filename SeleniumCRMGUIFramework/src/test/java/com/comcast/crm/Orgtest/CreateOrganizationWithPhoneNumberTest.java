package com.comcast.crm.Orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.Fileutility.ExcelUtility;
import com.comcast.crm.generic.Fileutility.FileUtility;
import com.comcast.crm.generic.Webdriverutility.JavaUtility;
import com.comcast.crm.objectrepository.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.LoginPage;
import com.comcast.crm.objectrepository.OrganizationPage;

public class CreateOrganizationWithPhoneNumberTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		ExcelUtility elib=new ExcelUtility();
		FileUtility flib=new FileUtility();
		JavaUtility jlib=new JavaUtility();

		String BROWSER = flib.getDataFromPropertiesFile("browser");
	    String URL = flib.getDataFromPropertiesFile("url");
	    String PASSWORD = flib.getDataFromPropertiesFile("password");
	    String USERNAME = flib.getDataFromPropertiesFile("username");
		
		//READ THE DATA FROM EXCEL FILE
	    String   orgName= elib.getDataFromStringExcel("org", 1, 2) +jlib.getRandomNumber();
		String phone = elib.getDataFromStringExcel("org", 7, 3);
		
		WebDriver driver=null;//use method overloading
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if (BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
        LoginPage lp=new LoginPage(driver);
        lp.loginToApp(USERNAME, PASSWORD);
        lp.getSubmitButton().submit();
        
        HomePage hp=new HomePage(driver);
        hp.getOrgLink().click();
        
        OrganizationPage cnp=new OrganizationPage(driver);
        cnp.getCreateOrgButton().click();
        
        CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
        
        cnop.createOrg(orgName);
        cnop.getPhoneText().sendKeys(phone);
        
        Thread.sleep(3000);
        hp.logout();

	}

}
