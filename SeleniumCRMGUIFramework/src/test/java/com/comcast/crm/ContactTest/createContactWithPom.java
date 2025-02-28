package com.comcast.crm.ContactTest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.Fileutility.ExcelUtility;
import com.comcast.crm.generic.Fileutility.FileUtility;
import com.comcast.crm.generic.Webdriverutility.JavaUtility;
import com.comcast.crm.objectrepository.CreatingNewContactPage;
import com.comcast.crm.objectrepository.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.LoginPage;
import com.comcast.crm.objectrepository.contactPage;

public class createContactWithPom {
	public static void main(String[] args) throws IOException {
		ExcelUtility elib=new ExcelUtility();
		FileUtility flib=new FileUtility();
		JavaUtility jlib=new JavaUtility();
		
		String BROWSER = flib.getDataFromPropertiesFile("browser");
	    String URL = flib.getDataFromPropertiesFile("url");
	    String PASSWORD = flib.getDataFromPropertiesFile("password");
	    String USERNAME = flib.getDataFromPropertiesFile("username");
	    
	    String lastName = elib.getDataFromStringExcel("contact", 1, 2) +jlib.getRandomNumber();
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
        hp.getContactsLink().click();
        
        contactPage cp=new contactPage(driver);
        cp.getCreateContactButton().click();
        
        CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
        cncp.getLastNametext().sendKeys(lastName);
        cncp.getSaveButton().click();
        
        hp.logout();
        
	
	}
	
	
	
	
      

}
