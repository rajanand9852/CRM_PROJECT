package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
		
	
	}
	@FindBy(xpath = "//img[@title=\"Create Organization...\"]")
	private WebElement  createOrgButton;
	
	@FindBy(name = "search_text")
	private WebElement searchTextField;
	
	@FindBy(name = "search_field")
	private WebElement searchDropDown;
	
	@FindBy(name = "submit")
	private WebElement clickSubmitButton;
	
	
	public WebElement getClickSubmitButton() {
		return clickSubmitButton;
	}


	public WebElement getSearchDropDown() {
		return searchDropDown;
	}


	public WebElement getSearchTextField() {
		return searchTextField;
	}


	public WebElement getCreateOrgButton() {
		return createOrgButton;
	}


}
