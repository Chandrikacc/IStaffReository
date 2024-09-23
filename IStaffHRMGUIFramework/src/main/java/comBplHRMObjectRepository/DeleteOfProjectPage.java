package comBplHRMObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteOfProjectPage {
	public DeleteOfProjectPage(WebDriver driver) {
		PageFactory.initElements(driver,this);		
	}
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deleteButton;

	public WebElement getDeleteButton() {
		return deleteButton;
	}
	
	
	

}
