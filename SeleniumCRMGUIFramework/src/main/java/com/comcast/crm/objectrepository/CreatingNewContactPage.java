package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	
	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//tr[@style=\"height:25px\"][3]//td[2]//img[@title=\"Select\"]")
	private WebElement plusIcon;
	
	public WebElement getPlusIcon() {
		return plusIcon;
	}
	@FindBy(name = "lastname")
	private WebElement lastNametext;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//input[@name='support_start_date']")
	private WebElement startDateButton;
	
	@FindBy(xpath = "//input[@name='support_end_date']")
	private WebElement endDateButton;

	public WebElement getStartDateButton() {
		return startDateButton;
	}

	public WebElement getEndDateButton() {
		return endDateButton;
	}

	public WebElement getLastNametext() {
		return lastNametext;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	

}
