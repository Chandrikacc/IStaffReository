package comBplHRMObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPage {
	WebDriver driver;
	public EditPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//label[text()='Email']/following-sibling::input[@class='form-control']")
	private WebElement emailTextField;
	
	@FindBy(xpath = "//input[@value='Save']")
	private WebElement saveButton;
	
	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	

}
