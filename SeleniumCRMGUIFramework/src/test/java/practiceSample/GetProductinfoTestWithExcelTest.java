package practiceSample;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.Fileutility.ExcelUtility;
public class GetProductinfoTestWithExcelTest {
	
	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandName,String productName) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://amazon.in");
		
		//search the product
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		
		//capture product info
		String price = driver.findElement(By.xpath("//span[text()='"+productName+"']/../../../..//span[@class=\"a-price\"]")).getText();
		System.out.println(price);
	}
	  @DataProvider
	  public Object[][] getData() throws EncryptedDocumentException, IOException{
		
		ExcelUtility elib=new ExcelUtility();
		int rowcount = elib.getRowCount("product");
		
		Object[][] objArr=new Object[rowcount][2];
		for(int i=0;i<rowcount;i++) {
			objArr[i][0]=elib.getDataFromStringExcel("product",i+1,0);
			objArr[i][1]=elib.getDataFromStringExcel("product",i+1,1);

		}
		
	    return objArr;
		
	}
	
	
	}




