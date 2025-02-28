package com.comcast.crm.ContactTest;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.comcast.crm.generic.Fileutility.ExcelUtility;
import com.comcast.crm.generic.Fileutility.FileUtility;
import com.comcast.crm.generic.Webdriverutility.JavaUtility;
import com.comcast.crm.generic.Webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepository.CreatingNewContactPage;
import com.comcast.crm.objectrepository.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.LoginPage;
import com.comcast.crm.objectrepository.OrganizationPage;
import com.comcast.crm.objectrepository.contactPage;

public class CreateContactWithOrgTeat {
	
	@Test
	public void createContactWithOrg() throws IOException {
		FileUtility futil=new FileUtility();
		ExcelUtility eutil=new ExcelUtility();
		JavaUtility  jutil=new JavaUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
		String BROWSER = futil.getDataFromPropertiesFile("browser");
		String URL = futil.getDataFromPropertiesFile("url");
		String PASSWORD = futil.getDataFromPropertiesFile("password");
		String USERNAME = futil.getDataFromPropertiesFile("username");
		
		String ORG = eutil.getDataFromStringExcel("org", 7, 2) +jutil.getRandomNumber();
		String lastName = eutil.getDataFromStringExcel("contact", 1, 2) +jutil.getRandomNumber();
		
		WebDriver driver=null;
		if (BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if (BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		wutil.toWaitForWebElement(driver);
		driver.get(URL);
		
		LoginPage lg=new LoginPage(driver);
		lg.loginToApp(USERNAME,PASSWORD);
		
		HomePage hp=new HomePage(driver);
		hp.getContactsLink().click();
		
		
		contactPage cp=new contactPage(driver);
		cp.getCreateContactButton().click();
		
		CreatingNewContactPage ccp=new CreatingNewContactPage(driver);
		ccp.getLastNametext().sendKeys(lastName);
		ccp.getPlusIcon().click();
		String title = driver.findElement(By.xpath("//td[text()='vtiger']")).getText();
		
	    wutil.toSwitchWindow(driver,title);
	    System.out.println(title);
	    driver.findElement(By.xpath("//a[text()='instagram3993']")).click();
	
		
		//hp.getContactsLink().click();
		
		
		
		
		
		
		
		
		
	}
    
}
