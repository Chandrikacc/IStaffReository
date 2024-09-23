package comBplHRMObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeePage {
	WebDriver driver;
	public EmployeePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Add New Employee']")
	private WebElement addNewEmplyoyeeButton;
	
	@FindBy(xpath = "//span[text()='Delete']")
	private WebElement deleteButton;
	
	public WebElement getAddNewEmplyoyeeButton() {
		return addNewEmplyoyeeButton;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}
	
	
	
}
