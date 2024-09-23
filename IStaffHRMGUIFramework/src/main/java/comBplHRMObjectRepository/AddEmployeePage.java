package comBplHRMObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	
	


}
