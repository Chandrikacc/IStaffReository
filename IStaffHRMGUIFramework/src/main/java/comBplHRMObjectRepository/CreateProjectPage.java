package comBplHRMObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	

}
