package comBplHrmEmployee_Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import comBplHRMGenericWebdriverUtility.JavaUtility;
import comBplHRMGenericWebdriverUtility.SelectUtility;
import comBplHRMGenericWebdriverUtility.UtilityClassObject;
import comBplHRMObjectRepository.AddEmployeePage;
import comBplHRMObjectRepository.EditPage;
import comBplHRMObjectRepository.EmployeePage;
import comBplHRMObjectRepository.HomePage;
import com_BPL_HRM_GenericBaseTest.BaseClass;

public class ModifyEmployeedetails_Test extends BaseClass {
	@Test(groups = "systemTest" )
	public void modifyEmployeeDetails_Test() throws IOException, Throwable {
		HomePage hp=new HomePage(driver);
		EmployeePage ep=new EmployeePage(driver);
		AddEmployeePage aep=new AddEmployeePage(driver);
		EditPage edtp=new EditPage(driver);
		JavaUtility jlib=new JavaUtility();
		SelectUtility slib=new SelectUtility();

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Employee");
		hp.getEmployeesLink().click();
		ep.getAddNewEmplyoyeeButton().click();
		UtilityClassObject.getTest().log(Status.INFO, "Create new Employee");
		wlib.zoomOut();						
		String name=elib.getDataFromExcel("EmpDetails", 1,0)+jlib.getRandomNumber();
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
		
		slib.selectByIndex(dropdownOfProject, 2);
		aep.getAddButton().click();	
		UtilityClassObject.getTest().log(Status.INFO,"Emplyoyee "+name+" is created");
		WebElement confirmMsg = driver.findElement(By.xpath("//div[@class='Toastify__toast Toastify__toast--success']/div[contains(text(),'Successfully Created')]"));
		wlib.waitForInvisibilityOfElement(driver, confirmMsg);
		driver.findElement(By.xpath("//td[text()='"+name+"']/following-sibling::td/a[@class='edit']")).click();
		edtp.getEmailTextField().clear();
		edtp.getEmailTextField().sendKeys("whosanshu@gmail.com");
		edtp.getSaveButton().click();
		WebElement successfullyUpdatedMsg = driver.findElement(By.xpath("//div[@class='Toastify__toast Toastify__toast--success']/div[@role='alert']"));
		wlib.waitForInvisibilityOfElement(driver, successfullyUpdatedMsg);
		String updatedEmail = driver.findElement(By.xpath("//td[text()='"+name+"']/following-sibling::td[2]")).getText();
		assertEquals(updatedEmail, "whosanshu@gmail.com");
		UtilityClassObject.getTest().log(Status.INFO,"Emplyoyeev"+name+" email id is edited");
		
	}
}
