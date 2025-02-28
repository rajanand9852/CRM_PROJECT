package com.comcast.crm.ContactTest1;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;

import com.comcast.crm.generic.Fileutility.BaseClass;
import com.comcast.crm.objectrepository.CreatingNewContactPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.contactPage;
/**
 * 
 * @author Anand raj
 * 
 */
public class CreateContactTest extends BaseClass {
	
	
	@Test(groups="smokeTest")
	public void createContactTest() throws EncryptedDocumentException, IOException {
		/* read testscript data from excel file */
		String lastName = eutil.getDataFromStringExcel("contact", 1, 2) +jutil.getRandomNumber();
		
		//step2:navigate to contact module
		HomePage hp=new HomePage(driver);
		hp.getContactsLink().click();
		
		//step3:click on "create contact" button
		contactPage cp=new contactPage(driver);
		cp.getCreateContactButton().click();
		
		//step4:enter all the details & create new Contact
		CreatingNewContactPage ccp=new CreatingNewContactPage(driver);
		ccp.getLastNametext().sendKeys(lastName);
		
		//verify Header last Name info expected result
	
		String actLastName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actLastName, lastName);
		
	    }
	
	@Test(groups="regressionTest")
	public void createContactWithsupportDateTest() throws EncryptedDocumentException, IOException {
		//read testscript data from excel file
		String lastName = eutil.getDataFromStringExcel("contact", 1, 2) +jutil.getRandomNumber();
		
		//step2:navigate to contact module
		HomePage hp=new HomePage(driver);
		hp.getContactsLink().click();
		
		//step3:click on "create contact" button
		contactPage cp=new contactPage(driver);
		cp.getCreateContactButton().click();
		
		//step4:enter all the details & create new Contact
		CreatingNewContactPage ccp=new CreatingNewContactPage(driver);
		ccp.getLastNametext().sendKeys(lastName);
		
		//
		String endDate = jutil.getSystemDateYYYYDDMM();
		String startData = jutil.getRequriedDateYYYYDDMM(30);
		
		ccp.getStartDateButton().clear();
		ccp.getStartDateButton().sendKeys(startData);
		
		ccp.getEndDateButton().clear();
		ccp.getEndDateButton().sendKeys(endDate);
		
	}

}
