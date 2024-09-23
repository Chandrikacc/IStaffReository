package comBplHrmResources_Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import comBplHRMGenericWebdriverUtility.UtilityClassObject;
import comBplHRMObjectRepository.DeletePageOfResources;
import comBplHRMObjectRepository.HomePage;
import comBplHRMObjectRepository.ResourcesModulePage;
import comBplHRMObjectRepository.UploadFilePage;
import com_BPL_HRM_GenericBaseTest.BaseClass;

public class DowloadResources_Test extends BaseClass  {
	@Test(groups ="integrationTest")
	public void downloadFileFromResources_Test() throws InterruptedException{
		HomePage hp=new HomePage(driver);
		ResourcesModulePage rmp=new ResourcesModulePage(driver);
		UploadFilePage ufp=new UploadFilePage(driver);
		DeletePageOfResources dpr=new DeletePageOfResources(driver);
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Resources module");
		hp.getResourcesLink().click();
		rmp.getUploadButton().click();
		ufp.getchooseFileButton().sendKeys("C:\\Users\\whosc\\eclipse\\ExcelInput_Chandrika\\Educational documents.xlsx");
		WebElement uploadFile = ufp.getuploadFileButton();
		wlib.waitForVisibilityOfElement(driver, uploadFile);
		uploadFile.click();
//		WebElement uploadFileAklertMsg = rmp.getUploadFileAlert();
//		wlib.waitForInvisibilityOfElement(driver, uploadFileAklertMsg);
		WebElement downloadButton=rmp.getDownloadButton();
		wlib.waitForVisibilityOfElement(driver, downloadButton);
		downloadButton.click();
		driver.findElement(By.xpath("//b[text()=' Resources']"));
		UtilityClassObject.getTest().log(Status.INFO, "Download the uploaded file");
		WebElement deleteButton=rmp.getDeleteButton();
		wlib.waitForVisibilityOfElement(driver, deleteButton);
		deleteButton.click();	
		WebElement deleteButtonofDfPage=dpr.getDeleteButtonOFDFPage();
		wlib.waitForVisibilityOfElement(driver, deleteButtonofDfPage);
		
		
		deleteButtonofDfPage.click();
//		WebElement deleteFileAlert = rmp.getDeleteFileAlert();
//		wlib.waitForInvisibilityOfElement(driver, deleteFileAlert);
		UtilityClassObject.getTest().log(Status.INFO, "File is deleted");
		
	}

}
 