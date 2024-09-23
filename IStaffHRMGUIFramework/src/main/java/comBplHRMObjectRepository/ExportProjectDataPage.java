package comBplHRMObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExportProjectDataPage {
	
	public ExportProjectDataPage(WebDriver driver) {
		PageFactory.initElements(driver,this);		
	}
	
	@FindBy(xpath= "//select[@id='fileType']")
	private WebElement fileTypeDropDown;
	
	@FindBy(xpath="//button[text()='Download File']")
	private WebElement downloadFileButton;

	public WebElement getFileTypeDropDown() {
		return fileTypeDropDown;
	}

	public WebElement getDownloadFileButton() {
		return downloadFileButton;
	}

}
