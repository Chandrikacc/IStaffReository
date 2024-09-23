package comBplHRMObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public  HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);		
	}

	@FindBy(xpath = "//*[local-name()='svg' and @data-icon='right-from-bracket']")
	private WebElement signOutButton;

	@FindBy(linkText = "Dashboard")
	private WebElement dashboardLink;

	@FindBy(linkText = "Projects")
	private WebElement projectLink;

	@FindBy(linkText = "Employees")
	private WebElement employeesLink;

	@FindBy(linkText = "Payroll")
	private WebElement payrollLink;

	@FindBy(linkText = "Settings")
	private WebElement settingsLink;

	@FindBy(linkText = "Resources")
	private WebElement resourcesLink;

	public WebElement getSignOutButton() {
		return signOutButton;
	}

	public WebElement getDashboardLink() {
		return dashboardLink;
	}

	public WebElement getProjectLink() {
		return projectLink;
	}

	public WebElement getEmployeesLink() {
		return employeesLink;
	}

	public WebElement getPayrollLink() {
		return payrollLink;
	}

	public WebElement getSettingsLink() {
		return settingsLink;
	}

	public WebElement getResourcesLink() {
		return resourcesLink;
	}

	

}
