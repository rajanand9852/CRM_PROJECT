package com.comcast.crm.ContactTest;

import org.testng.annotations.Test;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.generic.Fileutility.BaseClass;
import com.comcast.crm.objectrepository.CreatingNewContactPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.contactPage;


public class CreateContactWithBaseClassTest extends BaseClass {
	@Test
	public void createContact() throws EncryptedDocumentException, IOException {

	
	
    
    String lastName = eutil.getDataFromStringExcel("contact", 1, 2) +jutil.getRandomNumber();
    
  
    
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
