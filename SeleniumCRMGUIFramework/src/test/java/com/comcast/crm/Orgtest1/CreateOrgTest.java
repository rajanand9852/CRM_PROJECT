package com.comcast.crm.Orgtest1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.Fileutility.BaseClass;
import com.comcast.crm.generic.Webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepository.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.OrganizationPage;

public class CreateOrgTest extends BaseClass{
	
	 @Test(groups={"smokeTest","regressionTest"})
	    public void createOrgTest() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO,"read data from Excel");
		
		//read testscript data from Excel Data
		String orgName = eutil.getDataFromStringExcel("org", 1, 2) + jutil.getRandomNumber();
		
		//step:2 Navigate to organization modules
		UtilityClassObject.getTest().log(Status.INFO,"navigate to create org page");
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		//step:3 click on "create Organisation" Button
		
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateOrgButton().click();
		
		CreatingNewOrganizationPage cno=new CreatingNewOrganizationPage(driver);
		cno.createOrg(orgName);
		
		
	}
	
	@Test(groups="regressionTest")
	 public void createOrgwithPhone() throws EncryptedDocumentException, IOException {
		String orgName = eutil.getDataFromStringExcel("org", 1, 2) + jutil.getRandomNumber();
		String mob = eutil.getDataFromStringExcel("org", 7, 3) +jutil.getRandomNumber();
		
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		//step:3 click on "create Organisation" Button
		
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateOrgButton().click();
		
		CreatingNewOrganizationPage cno=new CreatingNewOrganizationPage(driver);
		cno.createOrg(orgName);
		cno.getPhoneText().sendKeys(mob);
		
	}
	
            
}
