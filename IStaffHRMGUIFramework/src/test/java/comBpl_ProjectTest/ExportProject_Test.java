package comBpl_ProjectTest;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import comBplHRMGenericWebdriverUtility.SelectUtility;
import comBplHRMGenericWebdriverUtility.UtilityClassObject;
import comBplHRMObjectRepository.ExportProjectDataPage;
import comBplHRMObjectRepository.HomePage;
import comBplHRMObjectRepository.ProjectPage;
import com_BPL_HRM_GenericBaseTest.BaseClass;

public class ExportProject_Test extends BaseClass{
	@Test(groups="smokeTest")
	public void exportProjectDetailsinExcel_Test() {
		HomePage hp=new HomePage(driver);
		ProjectPage pp=new ProjectPage(driver);
		
		ExportProjectDataPage epp=new ExportProjectDataPage(driver);
		SelectUtility slib=new SelectUtility();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Project");
		hp.getProjectLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Export the project");
		pp.getExportProjectButton().click();;
		WebElement fileTypeDropdown = epp.getFileTypeDropDown();
		slib.selectByIndex(fileTypeDropdown, 1);
		epp.getDownloadFileButton().click();
		UtilityClassObject.getTest().log(Status.INFO, "File Downloaded");
	}

}
