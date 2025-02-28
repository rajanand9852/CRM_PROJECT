package com.comcast.crm.Orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.Fileutility.ExcelUtility;
import com.comcast.crm.generic.Fileutility.FileUtility;
import com.comcast.crm.generic.Webdriverutility.JavaUtility;
import com.comcast.crm.objectrepository.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.LoginPage;
import com.comcast.crm.objectrepository.OrganizationInfoPage;
import com.comcast.crm.objectrepository.OrganizationPage;

public class CreateOrganizationTest {

	public static void main(String[] args) throws IOException, Exception {
		//Random random=new Random();
		//int randomInt = random.nextInt(1000);
		//READ THE DATA FROM PROPERTIES FILE
		ExcelUtility elib=new ExcelUtility();
		FileUtility flib=new FileUtility();
		JavaUtility jlib=new JavaUtility();
	    
		String BROWSER = flib.getDataFromPropertiesFile("browser");
	    String URL = flib.getDataFromPropertiesFile("url");
	    String PASSWORD = flib.getDataFromPropertiesFile("password");
	    String USERNAME = flib.getDataFromPropertiesFile("username");
		
		//READ THE DATA FROM EXCEL FILE
         String   orgName= elib.getDataFromStringExcel("org", 1, 2) +jlib.getRandomNumber();
		//String orgName = getSheet("org").getRow(1).getCell(2).toString() +randomInt;
		//String industryName = wb.getSheet("org").getRow(4).getCell(3).toString();
		
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
	
		//varify Header msg Expectedresult
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		
		
		if(actOrgName.contains(orgName)) {
			System.out.println(orgName +" is created==pass");
		}
		else {
			System.out.println("organisation fail");
		}
		
		//logout
		Thread.sleep(3000);
		hp.logout();
		
		
		
		
		
		
		

	}

}
