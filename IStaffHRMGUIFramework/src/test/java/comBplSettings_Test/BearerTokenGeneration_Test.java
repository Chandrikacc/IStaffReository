package comBplSettings_Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import comBplHRMGenericWebdriverUtility.SelectUtility;
import comBplHRMGenericWebdriverUtility.UtilityClassObject;
import comBplHRMObjectRepository.HomePage;
import comBplHRMObjectRepository.SettingsPage;
import com_BPL_HRM_GenericBaseTest.BaseClass;

public class BearerTokenGeneration_Test extends BaseClass {
	@Test(groups = "systemTest")
	public void toGenerateBearerToke_Test() {
		HomePage hp=new HomePage(driver);
		SettingsPage sp= new SettingsPage(driver);
		SelectUtility slib=new SelectUtility();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to settings");
		hp.getSettingsLink().click();
		WebElement tokenDropDown = sp.getTokenLifeSpanDropdown();
		slib.selectByIndex(tokenDropDown,2);
		UtilityClassObject.getTest().log(Status.INFO, "select the token Life span from dropdown and select");
		sp.getReadCheckBox().click();
		sp.getCreateCheckBox().click();
		sp.getUpdateCheckBox().click();
		sp.getDeleteCheckBox().click();
		UtilityClassObject.getTest().log(Status.INFO, "Generate the token");
		sp.getGenerateNewTokenButton().click();	
		String textOfTokenGeneration = driver.findElement(By.xpath("//div[@class='form-content']/descendant::span[contains(text(),'Token Gene')]")).getText();
		assertEquals(textOfTokenGeneration, "Token Generated Successfully");
		
		
		
		
		
		
		
	}

}
