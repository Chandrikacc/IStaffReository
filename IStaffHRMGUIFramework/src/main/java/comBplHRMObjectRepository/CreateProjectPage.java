package comBplHRMObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import comBplHRMGenericFileUtility.ExcelUtility;
import comBplHRMGenericWebdriverUtility.JavaUtility;
import comBplHRMGenericWebdriverUtility.SelectUtility;

public class CreateProjectPage {
	public CreateProjectPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@name='projectName']")
	private WebElement projectNameTextField;
	
	@FindBy(xpath = "//input[@name='createdBy']")
	private WebElement projectManagerTextField;
	
	@FindBy(xpath ="//label[text()='Project Status* ']/following-sibling::select[@name='status']")
	private WebElement projectStatusDropDown;
	
	
	@FindBy(xpath= "//input[@value='Add Project']")
	private WebElement addProjectButton;


	public WebElement getProjectNameTextField() {
		return projectNameTextField;
	}


	public WebElement getProjectManagerTextField() {
		return projectManagerTextField;
	}


	public WebElement getProjectStatusDropDown() {
		return projectStatusDropDown;
	}


	public WebElement getAddProjectButton() {
		return addProjectButton;
	}
	
	public void createNewProjectWithDetails() throws Throwable{
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		SelectUtility slib=new SelectUtility();
		
		String projectName = elib.getDataFromExcel("Project", 1, 0);
		String projectManager = elib.getDataFromExcel("Project", 1, 1);
		String projectStatus = elib.getDataFromExcel("Project", 1, 2);
		String projName=projectManager+jlib.getRandomNumber();
		getProjectNameTextField().sendKeys(projectName+jlib.getRandomNumber());
		getProjectManagerTextField().sendKeys(projName);
		WebElement projectStatusDropdown = getProjectStatusDropDown();
		slib.selectByValue(projectStatusDropdown,projectStatus);
		getAddProjectButton().click();
	}
	

}
