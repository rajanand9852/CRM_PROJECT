package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	
	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "phone")
	private WebElement phoneText;
	
	public WebElement getPhoneText() {
		return phoneText;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	@FindBy(name = "accountname")
	private WebElement orgNameText;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;

	public WebElement getOrgNameText() {
		return orgNameText;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	public void createOrg(String orgName) {
		orgNameText.sendKeys(orgName);
		saveButton.click();
		
		}
	public void createOrg(String orgName,String industry) {
		orgNameText.sendKeys(orgName);
		Select select=new Select(industryDropDown);
		select.selectByVisibleText(industry);
		saveButton.click();
	}

}
