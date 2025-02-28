package com.comcast.crm.ContactTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.generic.Fileutility.ExcelUtility;
import com.comcast.crm.generic.Fileutility.FileUtility;
import com.comcast.crm.generic.Webdriverutility.JavaUtility;
import com.comcast.crm.objectrepository.CreatingNewContactPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.LoginPage;
import com.comcast.crm.objectrepository.contactPage;

public class CreateContactWithSupportDateWithPom {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ExcelUtility elib=new ExcelUtility();
		FileUtility flib=new FileUtility();
		JavaUtility jlib=new JavaUtility();
	    
		String BROWSER = flib.getDataFromPropertiesFile("browser");
	    String URL = flib.getDataFromPropertiesFile("url");
	    String PASSWORD = flib.getDataFromPropertiesFile("password");
	    String USERNAME = flib.getDataFromPropertiesFile("username");
	    
		
		//read the testscript data from Excel file
	    String lastName = elib.getDataFromStringExcel("contact", 1, 2) +jlib.getRandomNumber();
		
		WebDriver driver=null;//use method override
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
        String startDate = jlib.getSystemDateYYYYDDMM();
        String lastDate = jlib.getRequriedDateYYYYDDMM(30);
        
        cncp.getLastNametext().sendKeys(lastName);
        Actions actions=new Actions(driver);
		actions.scrollByAmount(0, 500).perform();
        
        cncp.getStartDateButton().clear();
        cncp.getStartDateButton().sendKeys(startDate);
        
        cncp.getEndDateButton().clear();
        
        cncp.getEndDateButton().sendKeys(lastDate);
	}

}
