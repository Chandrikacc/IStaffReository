package comBplHRMObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectPage {
	public ProjectPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath= "//span[text()='Create Project']")
	private WebElement createProjectButton;
	
	@FindBy(xpath="//span[text()='Export Projects']")
	private WebElement exportProjectButton;
	
	@FindBy(xpath = "//div[@class='col-sm-6']/select[@class='form-control']")
	private WebElement searchByDropdown;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search by Project')]")
	private WebElement searchByTextField;

	public WebElement getExportProjectButton() {
		return exportProjectButton;
	}


	public WebElement getCreateProjectButton() {
		return createProjectButton;
	}
	
	public WebElement getsearchByDropdown() {
		return searchByDropdown;
	}
	
	public WebElement getSearchByDropdown() {
		return searchByDropdown;
	}

	public WebElement getSearchByTextField() {
		return searchByTextField;
	}
		

}
