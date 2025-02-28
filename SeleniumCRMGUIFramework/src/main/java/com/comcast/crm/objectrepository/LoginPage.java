package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.Webdriverutility.WebDriverUtility;
import com.mysql.jdbc.Driver;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);	
	}
	
	
	
	
	@FindBy(name = "user_name")
	private WebElement userName;
	
	@FindBy(name = "user_password")
	private WebElement passWord;
	
	@FindBy(id = "submitButton")
	private WebElement submitButton;

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return passWord;
	}

	public WebElement getSubmitButton() {
		return submitButton; 
		
	}
	public void loginToApp(String username,String password) {
		userName.sendKeys(username);
		passWord.sendKeys(password);
		submitButton.click();
		
	}

}
