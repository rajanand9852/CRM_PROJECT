package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver=null;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement adminImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutButton;
	
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;
	
	public void logout() {
		System.out.println("hii");
		Actions actions=new Actions(driver);
		actions.moveToElement(adminImg).perform();
		signOutButton.click();
		
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignOutButton() {
		return signOutButton;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}
	
	

}
