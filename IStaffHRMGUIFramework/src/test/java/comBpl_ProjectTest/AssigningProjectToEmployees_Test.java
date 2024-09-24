package comBpl_ProjectTest;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import comBplHRMGenericWebdriverUtility.UtilityClassObject;
import comBplHRMObjectRepository.AddEmployeePage;
import comBplHRMObjectRepository.CreateProjectPage;
import comBplHRMObjectRepository.EmployeePage;
import comBplHRMObjectRepository.HomePage;
import comBplHRMObjectRepository.ProjectPage;
import com_BPL_HRM_GenericBaseTest.BaseClass;

public class AssigningProjectToEmployees_Test extends BaseClass {
	@Test(groups ="integrationTest")
	public void userShouldAbleToAssignProjectsToEmp_Test() throws Throwable {
		HomePage hp=new HomePage(driver);
		ProjectPage pp=new ProjectPage(driver);
		CreateProjectPage cpp= new CreateProjectPage(driver);
		EmployeePage ep=new EmployeePage(driver);
		AddEmployeePage aep=new AddEmployeePage(driver);
				
        UtilityClassObject.getTest().log(Status.INFO,"Navigate to Project and create new Project");
		hp.getProjectLink().click();		
		pp.getCreateProjectButton().click();
		cpp.createNewProjectWithDetails();
		
		WebElement employee = hp.getEmployeesLink();
		wlib.waitForVisibilityOfElement(driver, employee);
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to employee");
		employee.click();		
		ep.getAddNewEmplyoyeeButton().click();
		UtilityClassObject.getTest().log(Status.INFO, "Add new employee by providing mandatory data");				
		wlib.zoomOut();		
		String name=aep.createNewEmpWithDetails();
		
		WebElement confirmMsg = driver.findElement(By.xpath("//div[@class='Toastify__toast Toastify__toast--success']/div[contains(text(),'Successfully Created')]"));
		wlib.waitForVisibilityOfElement(driver, confirmMsg);
		
		String confirmationMsg = confirmMsg.getText();
		System.out.println(confirmationMsg);
		assertEquals(confirmationMsg,"User "+name+" Successfully Created");
	}

}
