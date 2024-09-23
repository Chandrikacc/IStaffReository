package comBpl_ProjectTest;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import comBplHRMGenericWebdriverUtility.JavaUtility;
import comBplHRMGenericWebdriverUtility.SelectUtility;
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
		JavaUtility jlib=new JavaUtility();
		SelectUtility slib=new SelectUtility();

		String projectName = elib.getDataFromExcel("Project", 1, 0);
		String projectManager = elib.getDataFromExcel("Project", 1, 1);
		String projectStatus = elib.getDataFromExcel("Project", 1, 2);
				
        UtilityClassObject.getTest().log(Status.INFO,"Navigate to Project and create new Project");
		hp.getProjectLink().click();		
		pp.getCreateProjectButton().click();
		String projName=projectManager+jlib.getRandomNumber();
		cpp.getProjectNameTextField().sendKeys(projectName+jlib.getRandomNumber());
		cpp.getProjectManagerTextField().sendKeys(projName);
		WebElement projectStatusDropdown = cpp.getProjectStatusDropDown();
		slib.selectByValue(projectStatusDropdown,projectStatus);
		cpp.getAddProjectButton().click();
		
		WebElement employee = hp.getEmployeesLink();
		wlib.waitForVisibilityOfElement(driver, employee);
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to employee");
		employee.click();		
		ep.getAddNewEmplyoyeeButton().click();
		UtilityClassObject.getTest().log(Status.INFO, "Add new employee by providing mandatory data");
				
		wlib.zoomOut();
		String nameOFEmp=elib.getDataFromExcel("EmpDetails", 1,0)+jlib.getRandomNumber();
		String name=nameOFEmp+jlib.getRandomNumber();
		String email=elib.getDataFromExcel("EmpDetails", 1,1)+jlib.getRandomNumber()+"@gmail.com";
		String phone=elib.getDataFromExcel("EmpDetails", 1,2);
		String username=elib.getDataFromExcel("EmpDetails", 1,3)+jlib.getRandomNumber();
		String Designation=elib.getDataFromExcel("EmpDetails", 1,4);
		String experience=elib.getDataFromExcel("EmpDetails", 1,5);

		WebElement nameTextField = aep.getNameTextField();
		wlib.waitForVisibilityOfElement(driver, nameTextField);	
		nameTextField.sendKeys(name);
		aep.getEmailTextField().sendKeys(email);
		aep.getPhoneTextField().sendKeys(phone);
		aep.getUsernameTextField().sendKeys(username);
		aep.getDesignationTextField().sendKeys(Designation);
		aep.getExperienceTextField().sendKeys(experience);
		WebElement dropdownOfProject = aep.getProjectDropdown();

		slib.selectByIndex(dropdownOfProject, 6);
		aep.getAddButton().click();
		WebElement confirmMsg = driver.findElement(By.xpath("//div[@class='Toastify__toast Toastify__toast--success']/div[contains(text(),'Successfully Created')]"));
		wlib.waitForVisibilityOfElement(driver, confirmMsg);
		
		String confirmationMsg = confirmMsg.getText();
		System.out.println(confirmationMsg);
		assertEquals(confirmationMsg,"User "+name+" Successfully Created");
	}

}
