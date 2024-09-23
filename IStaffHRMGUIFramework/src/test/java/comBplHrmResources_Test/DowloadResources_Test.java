package comBplHrmResources_Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import comBplHRMGenericFileUtility.ExcelUtility;
import comBplHRMGenericWebdriverUtility.UtilityClassObject;
import comBplHRMObjectRepository.DeletePageOfResources;
import comBplHRMObjectRepository.HomePage;
import comBplHRMObjectRepository.ResourcesModulePage;
import comBplHRMObjectRepository.UploadFilePage;
import com_BPL_HRM_GenericBaseTest.BaseClass;

public class DowloadResources_Test extends BaseClass  {
	@Test(groups ="integrationTest")
	public void downloadFileFromResources_Test() throws Throwable{
		HomePage hp=new HomePage(driver);
		ResourcesModulePage rmp=new ResourcesModulePage(driver);
		UploadFilePage ufp=new UploadFilePage(driver);
		DeletePageOfResources dpr=new DeletePageOfResources(driver);
		ExcelUtility elib=new ExcelUtility();
		
		String fileName = elib.getDataFromExcel("Resources", 1, 0);
		String pathOfFile = elib.getDataFromExcel("Resources", 1, 1);
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Resources module");
		hp.getResourcesLink().click();
		rmp.getUploadButton().click();
		ufp.getchooseFileButton().sendKeys(pathOfFile);
		WebElement uploadFile = ufp.getuploadFileButton();
		wlib.waitForVisibilityOfElement(driver, uploadFile);
		uploadFile.click();
		
		WebElement downloadButton=driver.findElement(By.xpath("//tr[@class='tr']/td[text()='"+fileName+"']/following-sibling::td/a[@class='download']"));		
		wlib.waitForVisibilityOfElement(driver, downloadButton);
		downloadButton.click();
		WebElement rources = driver.findElement(By.xpath("//b[text()=' Resources']"));
		rources.click();
		UtilityClassObject.getTest().log(Status.INFO, "Download the uploaded file");
		WebElement deleteButton=rmp.getDeleteButton();
		wlib.waitForVisibilityOfElement(driver, deleteButton);
		deleteButton.click();	
		WebElement deleteButtonofDfPage=dpr.getDeleteButtonOFDFPage();
		wlib.waitForVisibilityOfElement(driver, deleteButtonofDfPage);
		
		
		deleteButtonofDfPage.click();

		UtilityClassObject.getTest().log(Status.INFO, "File is deleted");
		
	}

}
 