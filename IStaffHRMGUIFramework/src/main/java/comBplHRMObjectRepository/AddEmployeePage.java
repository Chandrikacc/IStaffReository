package comBplHRMObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comBplHRMGenericFileUtility.ExcelUtility;
import comBplHRMGenericWebdriverUtility.JavaUtility;
import comBplHRMGenericWebdriverUtility.SelectUtility;
import comBplHRMGenericWebdriverUtility.WebDriverUtility;

public class AddEmployeePage {
	WebDriver driver;
	public AddEmployeePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);		
	}
	
	@FindBy(xpath = "//label[text()='Name*']/following-sibling::input[@class='form-control']")
	private WebElement nameTextField;
	
	@FindBy(xpath = "//label[text()='Email*']/following-sibling::input[@class='form-control']")
	private WebElement emailTextField;
	
	@FindBy(xpath = "//label[text()='Phone*']/following-sibling::input[@class='form-control']")
	private WebElement phoneTextField;
	
	@FindBy(xpath = "//label[text()='Username*']/following-sibling::input[@class='form-control']")
	private WebElement usernameTextField;
	
	@FindBy(xpath = "//label[text()='Designation*']/following-sibling::input[@class='form-control']")
	private WebElement designationTextField;
	
	@FindBy(xpath = "//label[text()='Experience*']/following-sibling::input[@class='form-control']")
	private WebElement experienceTextField;
	
	@FindBy(xpath="//select[@name='project']")
	private WebElement projectDropdown;
	
	@FindBy(xpath="//input[@value='Add']")
	private WebElement addButton;
	public WebElement getNameTextField() {
		return nameTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPhoneTextField() {
		return phoneTextField;
	}

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getDesignationTextField() {
		return designationTextField;
	}

	public WebElement getExperienceTextField() {
		return experienceTextField;
	}

	public WebElement getProjectDropdown() {
		return projectDropdown;
	}

	public WebElement getAddButton() {
		return addButton;
	}
	
	
	public String createNewEmpWithDetails() throws Throwable {
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		SelectUtility slib=new SelectUtility();
		
		String nameOFEmp=elib.getDataFromExcel("EmpDetails", 1,0)+jlib.getRandomNumber();
		String name=nameOFEmp+jlib.getRandomNumber();
		String email=elib.getDataFromExcel("EmpDetails", 1,1)+jlib.getRandomNumber()+"@gmail.com";
		String phone=elib.getDataFromExcel("EmpDetails", 1,2);
		String username=elib.getDataFromExcel("EmpDetails", 1,3)+jlib.getRandomNumber();
		String Designation=elib.getDataFromExcel("EmpDetails", 1,4);
		String experience=elib.getDataFromExcel("EmpDetails", 1,5);

		WebElement nameTextField = getNameTextField();
		wlib.waitForVisibilityOfElement(driver, nameTextField);	
		nameTextField.sendKeys(name);
		getEmailTextField().sendKeys(email);
		getPhoneTextField().sendKeys(phone);
		getUsernameTextField().sendKeys(username);
		getDesignationTextField().sendKeys(Designation);
		getExperienceTextField().sendKeys(experience);
		WebElement dropdownOfProject =getProjectDropdown();

		slib.selectByIndex(dropdownOfProject, 6);
		getAddButton().click();
		return name;

	}


}
