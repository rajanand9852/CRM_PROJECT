package practiceSample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetProductInfoTest {
@Test
public void getProductInfoTest(String brandName,String productName) {
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://amazon.in");
	 
	//search product
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
	String price = driver.findElement(By.xpath("//span[text()='Apple iPhone 15 (128 GB) - Black']/../../../..//span[@class=\"a-price\"]")).getText();
	System.out.println(price);
}
}
