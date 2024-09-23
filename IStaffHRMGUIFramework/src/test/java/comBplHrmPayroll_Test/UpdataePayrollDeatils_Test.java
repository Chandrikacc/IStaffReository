package comBplHrmPayroll_Test;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import comBplHRMGenericWebdriverUtility.JavaUtility;
import comBplHRMGenericWebdriverUtility.SelectUtility;
import comBplHRMGenericWebdriverUtility.UtilityClassObject;
import comBplHRMObjectRepository.AddEmployeePage;
import comBplHRMObjectRepository.EditPayrollPage;
import comBplHRMObjectRepository.EmployeePage;
import comBplHRMObjectRepository.HomePage;
import com_BPL_HRM_GenericBaseTest.BaseClass;
public class UpdataePayrollDeatils_Test extends BaseClass {
	@Test(groups = "systemTest" )
	public void updatePayrollDetailsOfEmp_Test() throws Throwable{
		HomePage hp=new HomePage(driver);
		EmployeePage ep=new EmployeePage(driver);
		EditPayrollPage epp=new EditPayrollPage(driver);
		AddEmployeePage aep=new AddEmployeePage(driver);
		SelectUtility slib= new SelectUtility();
		JavaUtility jlib=new JavaUtility();

		hp.getEmployeesLink().click();
		UtilityClassObject.getTest().log(Status.INFO," navigate to Employee module");
		ep.getAddNewEmplyoyeeButton().click();
		wlib.zoomOut();

		String name=elib.getDataFromExcel("EmpDetails", 1,0)+jlib.getRandomNumber();
		String email=elib.getDataFromExcel("EmpDetails", 1,1)+jlib.getRandomNumber()+"@gmail.com";
		String phone=elib.getDataFromExcel("EmpDetails", 1,2);
		String username=elib.getDataFromExcel("EmpDetails", 1,3)+jlib.getRandomNumber();
		String Designation=elib.getDataFromExcel("EmpDetails", 1,4);
		String experience=elib.getDataFromExcel("EmpDetails", 1,5);

		UtilityClassObject.getTest().log(Status.INFO," Enter mandatory details");
		WebElement nameTextfield=aep.getNameTextField();
		wlib.waitForVisibilityOfElement(driver, nameTextfield);
		nameTextfield.sendKeys(name);
		aep.getEmailTextField().sendKeys(email);
		aep.getPhoneTextField().sendKeys(phone);
		aep.getUsernameTextField().sendKeys(username);
		aep.getDesignationTextField().sendKeys(Designation);
		aep.getExperienceTextField().sendKeys(experience);
		WebElement dropdownOfProject = aep.getProjectDropdown();
		slib.selectByIndex(dropdownOfProject, 2);
		aep.getAddButton().click();
		UtilityClassObject.getTest().log(Status.INFO,name+"  is created ");
		
		UtilityClassObject.getTest().log(Status.INFO," Navigate to Payroll module ");
		WebElement payroll=hp.getPayrollLink();
		wlib.waitForVisibilityOfElement(driver, payroll);
		payroll.click();
		driver.findElement(By.xpath("//tr/td[text()='"+name+"']/following-sibling::td/a[@class='edit']")).click();

		UtilityClassObject.getTest().log(Status.INFO," Enter mandatory details");
		String basicVDA=elib.getDataFromExcel("PayrolDetails", 1,0);
		String hra=elib.getDataFromExcel("PayrolDetails", 1,1);
		String statBonus=elib.getDataFromExcel("PayrolDetails", 1,2);
		String LTA=elib.getDataFromExcel("PayrolDetails", 1,3);
		String PF=elib.getDataFromExcel("PayrolDetails", 1,4);
		String PT=elib.getDataFromExcel("PayrolDetails", 1,5);
		String insurance=elib.getDataFromExcel("PayrolDetails", 1,6);
		String LWF=elib.getDataFromExcel("PayrolDetails", 1,7);		
		epp.getBasicVDATextfield().sendKeys(basicVDA);
		epp.getHraTextField().sendKeys(hra);
		epp.getStatBonusTextfield().sendKeys(statBonus);
		epp.getLtaTextField().sendKeys(LTA);
		epp.getPfTextField().sendKeys(PF);
		epp.getPtTextField().sendKeys(PT);
		epp.getInsuranceTextField().sendKeys(insurance);
		epp.getLwfTextfield().sendKeys(LWF);

		WebElement statusDropDown = epp.getStatusDropdown();
		UtilityClassObject.getTest().log(Status.INFO," change the status to active ");
		slib.selectByValue(statusDropDown,"Active");
		epp.getSaveButton().click();
		WebElement payrollupdateMsg = driver.findElement(By.xpath("//div[@class='Toastify__toast Toastify__toast--success']/div[@role='alert']"));
		wlib.waitForInvisibilityOfElement(driver, payrollupdateMsg);
		String status=driver.findElement(By.xpath("//tbody/tr/td[text()='"+name+"']/following-sibling::td[4]")).getText();
		assertEquals(status, "Active");
		UtilityClassObject.getTest().log(Status.PASS, name+" is Active");









	}

}
