package com.comcast.crm.generic.Webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * This method is used to maximise the browser
	 * @param driver
	 */
	public void toMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to minimise
	 * @param driver
	 */
	public void toMinimize(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will wait until webelement are loaded in webpage(implicitly wait)
	 * 
	 */
	public void toWaitForWebElement(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	/**
	 * This method will wait until the elements is visiable
	 * @param driver
	 * @param element
	 */
	public void visibilityOfelement(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait until the element is clickable
	 * @param driver
	 * @param element
	 */
	public void elementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method is used to handle dropdown by using index
	 * @param element
	 * @param index
	 */
	public void toHandleDropDown(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
        
	}
	/**
	 * This method is used to handle dropdown by using value
	 * @param element
	 * @param value
	 */
	public void tohandleDropDown(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	/**
	 * This method is used to handle dropdown by using visiableText
	 * @param element
	 * @param visiableText
	 */
	public void toHandleDropDown(WebElement element,String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	/**
	 * this method is used switch driver control to frame by using index
	 * @param driver
	 * @param index
	 */
	public void toHandleFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * this method is used switch to frame by using id or name
	 * @param driver
	 * @param id_name
	 */
	public void toHandleFrame(WebDriver driver,String id_name) {
		driver.switchTo().frame(id_name);
	}
	/**
	 * this method is used to switch to frame by using Webelement
	 * @param driver
	 * @param webelement
	 */
	public void toHandleFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * this method is used to switch driver control back from frame
	 * param driver
	 */
	public void toSwitchBackFromFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method is used to perform double click on element
	 * @param driver
	 * @param element
	 */
	public void toDoubleClick(WebDriver driver,WebElement element) {
		Actions actions=new Actions(driver);
		actions.doubleClick(element).perform();
	}
	/**
	 * this method is used to perform right click
	 * @param driver
	 * @param element
	 */
	public void toRightClick(WebDriver driver,WebElement element) {
		Actions actions=new Actions(driver);
		actions.contextClick(element).perform();
	}
	/**
	 * this method is used to mousehover on element
	 * @param driver
	 * @param element
	 */
	public void toMouseHover(WebDriver driver,WebElement element) {
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}
	/**
	 * this method is used to perform drag and drop
	 * @param driver
	 * @param element
	 */
	public void toDragAndDrop(WebDriver driver,WebElement src,WebElement target) {
		Actions actions=new Actions(driver);
		actions.dragAndDrop(src, target).perform();
		
	}
	/**
	 * this method is used handle alert popup by Accepting
	 * @param driver
	 */
	public void toHandleAlertPopupByAccepting(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * this method is used handle Alert popup by Dismissing it
	 * @param driver
	 */
	public void toHandlePopByDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this is method is used to handle Alert popup and capture the alert
	 * @param driver
	 * @return 
	 */
	public String toHandleAlertPopupAndCaptureMessage(WebDriver driver) {
		Alert alertPopup = driver.switchTo().alert();
		String alertMessage = alertPopup.getText();
		return alertMessage;
	}
	/**
	 * this methode is used to capture Screenshot
	 * @param driver
	 * @return 
	 * @return
	 * @throws IOException 
	 */
	public File toTakeScreenShot(WebDriver driver,String screenshotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File src=new File("./ErrorShots"+ screenshotName +".jpeg");
		FileHandler.copy(temp, src);
		return src.getAbsoluteFile();
		
	}
	/**
	 * this method is used to switch driver control to particular window
	 * @param driver
	 * @param particularTitle
	 */
	public void toSwitchWindow(WebDriver driver,String particularTitle) {
		Set<String> allWindowsTitle = driver.getWindowHandles();
		for(String id:allWindowsTitle) {
			String windowTitle = driver.switchTo().window(id).getTitle();
			if(windowTitle.contains(particularTitle)) {
				break;
				}
			}
			
		
	}
	/**
	 * This method is used to close the Browser
	 * @param 
	 */
	public void toCloseTheBrowser(WebDriver driver) {
		driver.close();
	}
	/**
	 * This method is used to clear the Text
	 * @param webelement
	 */
	public void toClearTheText(WebElement ele) {
		ele.clear();	
		}
	/**
	 * This method is used to Capture screenshot of particular Element
	 * @return 
	 * @throws IOException 
	 */
	public File toTakeScreeShotForParticularElement(WebDriver driver,String screenShot,WebElement element) throws IOException {
		
		File temp = element.getScreenshotAs(OutputType.FILE);
		File src=new File("./ErrorShots"+ screenShot +".jpeg");
		FileHandler.copy(temp, src);
		return src.getAbsoluteFile();
		
		
	}
	/**
	 * @return 
	 * 
	 */
	public boolean toValidateLogo(WebDriver driver,WebElement element){
		  
		  return element.isDisplayed();
		 
		
	}
	/**
	 * this method is used to scroll by using JavaScriptExecutor
	 */
	
	public void drawBorderByJavaScriptExecutor(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red",element);
		
		
	}
	/**
	 * this method is used to getTitle by JavaScriptExecutor
	 */
	public static void getTitleByJavaScriptExecutor(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("return document.title;").toString();
	}
	
	/**
	 * this method is used to handle alert
	 */

     public void handleAlertByJavaScriptExecutor(WebDriver driver,String message) {
    	 JavascriptExecutor js=(JavascriptExecutor)driver;
    	 js.executeScript("alert('"+ message +"')");
     }
     /**
      * this method is used to enter text by using javaScriptExecutor
      * @param driver
      * @param element
      */
     public void sendTextByUsingJavaScriptExecutor(WebDriver driver,String text,WebElement element) {
    	 JavascriptExecutor js=(JavascriptExecutor)driver;
    	 js.executeScript("document.element.value=text");
     }
     
     /**
      * this method is used to zoom the application
      * @param driver
      */
     public void toZoombyusingJavaScript(WebDriver driver) {
    	 JavascriptExecutor js=(JavascriptExecutor)driver;
    	 js.executeScript("document.body.style.zoom='50%'");
     }
     /**
      * this method is used to Scroll on an application till end
      * @param driver
      */
     public void scrollPageTillEndByUsingJavaScript(WebDriver driver) {
    	 JavascriptExecutor js=(JavascriptExecutor)driver;
    	 js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    	 
     }
     /**
      * this method is used to Scroll vertically pageUp
      */
     public void scrollPageupByUsingJavaScript(WebDriver driver) {
    	 JavascriptExecutor js=(JavascriptExecutor)driver;
    	 js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
     }
     /**
 	 * this method is used to click the element by javaScriptExecutor
 	 */
 	public void clickElementByJavaScriptExecutor(WebDriver driver,WebElement element) {
 		JavascriptExecutor js=(JavascriptExecutor)driver;
 		js.executeScript("arguments[0].click();", element);
 		
 	}
}



