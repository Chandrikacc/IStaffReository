package comBplHRMGenericWebdriverUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains reusable methods of selenium
 * @author whosc
 *
 */
public class WebDriverUtility {
	
		public void waitForPageToLoad(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		
		
		public void waitForVisibilityOfElement(WebDriver driver,WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		public void waitForElementToBeClickAble(WebDriver driver,WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		
			
		}
		public void waitForInvisibilityOfElement(WebDriver driver,WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
			wait.until(ExpectedConditions.invisibilityOf(element));	
		}
		//Switch to new tab based on URL
		public void switchToTabOnUrl(WebDriver driver,String partialUrl) {
			Set<String> allWindowID = driver.getWindowHandles();


			for(String win:allWindowID) {
				driver.switchTo().window(win);
				String actualUrl = driver.getCurrentUrl();
				if(actualUrl.contains(partialUrl)) {
					break;
				}
			}
		}
		
		//Switch to new tab based on URL
		public void switchToTabOnTitle(WebDriver driver,String partialTitle) {
			Set<String> allWindowID = driver.getWindowHandles();


			for(String win:allWindowID) {
				driver.switchTo().window(win);
				String actualUrl = driver.getTitle();
				if(actualUrl.contains(partialTitle)) {
					break;
				}
			}
		}
		
		public void switchToParentTab(WebDriver driver,String parentId) {
			driver.switchTo().window(parentId);
		}
		
		public void switchToFrame(WebDriver driver,int index) {
			driver.switchTo().frame(index);
		}
		
		public void switchToFrame(WebDriver driver,String nameId) {
			driver.switchTo().frame(nameId);
		}
		
		public void switchToFrame(WebDriver driver,WebElement element) {
			driver.switchTo().frame(element);
		}
		
		public void switchToAlertAndAccept(WebDriver driver) {
			driver.switchTo().alert().accept();
			
		}
		
		public void switchToAlertAndDismiss(WebDriver driver) {
			driver.switchTo().alert().dismiss();	
		}
		
		public void zoomOut() throws AWTException {
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		

	}


