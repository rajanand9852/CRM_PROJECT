package com.comcast.crm.ContactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithOrg {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		Random random=new Random();
		int randomInt = random.nextInt(1000);
		//READ THE DATA FROM PROPERTIES FILE
		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String BROWSER = pro.getProperty("browser");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		//READ THE DATA FROM EXCEL FILE
		FileInputStream fis1=new FileInputStream("./src/test/resources/TestData1.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		String orgName = wb.getSheet("org").getRow(1).getCell(2).toString() +randomInt;
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
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName) ;
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		//varify Header msg Expectedresult
		
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(orgName)) {
			System.out.println(orgName +" is created==pass");
		}
		else {
			System.out.println("organisation fail");
		}
		
		//varify Header orgName info ExpectedResult


	}

}
