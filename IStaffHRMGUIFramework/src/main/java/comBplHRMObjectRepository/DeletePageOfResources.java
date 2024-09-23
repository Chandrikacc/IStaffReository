package comBplHRMObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletePageOfResources {
   public DeletePageOfResources(WebDriver driver) {
	   PageFactory.initElements(driver,this);
   }
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deleteButtonOFDFPage;
	
	@FindBy(xpath="//h4[text()='Delete File']")
	private WebElement deleteFilePage;

	public WebElement getDeleteFilePage() {
		return deleteFilePage;
	}

	public WebElement getDeleteButtonOFDFPage() {
		return deleteButtonOFDFPage;
	}

}
