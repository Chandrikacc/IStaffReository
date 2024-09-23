package comBpl_ProjectTest;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import comBplHRMGenericFileUtility.ExcelUtility;
import comBplHRMGenericWebdriverUtility.JavaUtility;
import comBplHRMGenericWebdriverUtility.SelectUtility;
import comBplHRMGenericWebdriverUtility.UtilityClassObject;
import comBplHRMObjectRepository.CreateProjectPage;
import comBplHRMObjectRepository.DeleteOfProjectPage;
import comBplHRMObjectRepository.HomePage;
import comBplHRMObjectRepository.ProjectPage;
import com_BPL_HRM_GenericBaseTest.BaseClass;

public class DeleteProject extends BaseClass {
	@Test(groups="smokeTest")
	public void userShouldAbleToDeleteProject_Test() throws Throwable {
		HomePage hp=new HomePage(driver);
		ProjectPage pp=new ProjectPage(driver);
		CreateProjectPage cpp= new CreateProjectPage(driver);
		DeleteOfProjectPage dpp=new DeleteOfProjectPage(driver);
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		SelectUtility slib=new SelectUtility();
				
		String projectName = elib.getDataFromExcel("Project", 1, 0)+jlib.getRandomNumber();
		String projManager = elib.getDataFromExcel("Project", 1, 1);
		String projectManager=projManager+jlib.getRandomNumber();
		String projectStatus = elib.getDataFromExcel("Project", 1, 2);
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Project");
		hp.getProjectLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Create new Project");
		pp.getCreateProjectButton().click();
		cpp.getProjectNameTextField().sendKeys(projectName);
		cpp.getProjectManagerTextField().sendKeys(projectManager);
		WebElement projectStatusDropdown = cpp.getProjectStatusDropDown();
		slib.selectByValue(projectStatusDropdown,projectStatus);

		cpp.getAddProjectButton().click();
		WebElement projectAddedConfirmMsg = driver.findElement(By.xpath("//div[@class='Toastify__toast Toastify__toast--success']/div[@role='alert']"));
		wlib.waitForInvisibilityOfElement(driver, projectAddedConfirmMsg);
		WebElement searchProjectDropdown = pp.getSearchByDropdown();
		wlib.waitForVisibilityOfElement(driver, searchProjectDropdown);
		slib.selectByIndex(searchProjectDropdown,2);
		
		pp.getSearchByTextField().sendKeys(projectManager);	
		UtilityClassObject.getTest().log(Status.INFO, "Delete project");
		driver.findElement(By.xpath("//td[text()='"+projectManager+"']/following-sibling::td/a[@class='delete']")).click();
		WebElement deleteButton=dpp.getDeleteButton();
		wlib.waitForVisibilityOfElement(driver, deleteButton);
		deleteButton.click();
		WebElement conmes= driver.findElement(By.xpath("//div[@class='Toastify__toast Toastify__toast--success']/div[contains(text(),'Project')]"));
		wlib.waitForVisibilityOfElement(driver, conmes);
		String confirmMsg=conmes.getText();
		System.out.println("Deleted:"+confirmMsg);
		assertEquals(confirmMsg,projectName+" Project Successfully Deleted");
	}

}
