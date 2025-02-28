package practiceSample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetProductInfoTest1 {
	
	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandName,String productName) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://amazon.in");
		 
		//search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		
		//capture product info
		String price = driver.findElement(By.xpath("//span[text()='"+productName+"']/../../../..//span[@class=\"a-price\"]")).getText();
		System.out.println(price);
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr=new Object[3][2];
		objArr[0][0]="iphone";
		objArr[0][1]="Apple iPhone 15 (128 GB) - Black";
				
		
		objArr[1][0]="iphone";
		objArr[1][1]="Apple iPhone 13 (128GB) - Blue";
		
		objArr[2][0]="iphone";
		objArr[2][1]="Apple iPhone 15 (128 GB) - Black";
		return objArr;
	}

}
