package com.comcast.crm.ContactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.Fileutility.ExcelUtility;
import com.comcast.crm.generic.Fileutility.FileUtility;
import com.comcast.crm.generic.Webdriverutility.JavaUtility;

public class CreateContact {

	public static void main(String[] args) throws IOException {
		//create an object
		ExcelUtility elib=new ExcelUtility();
		FileUtility flib=new FileUtility();
		JavaUtility jlib=new JavaUtility();
	    
		//read common data from properties file
		String BROWSER = flib.getDataFromPropertiesFile("browser");
	    String URL = flib.getDataFromPropertiesFile("url");
	    String PASSWORD = flib.getDataFromPropertiesFile("password");
	    String USERNAME = flib.getDataFromPropertiesFile("username");
	    
	    //read testscriptData from excel file
		String lastName = elib.getDataFromStringExcel("contact", 1, 2) +jlib.getRandomNumber();
		
		WebDriver driver=null;//use method overloading
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if (BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		//verify Header phone 
		String actLastName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actLastName.contains(lastName)) {
			System.out.println(lastName+" information is varified pass");
		}
		else {
			System.out.println(lastName+"information is varified failed");
		}
		

	}

}
