package comBplHRMObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadFilePage {
	public UploadFilePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="upload-file")
	private WebElement chooseFileButton;
	
	@FindBy(xpath = "//button[text()='Upload File']")
	private WebElement uploadFileButton;
	
	public WebElement getchooseFileButton() {
		return chooseFileButton;
	}

	public WebElement getuploadFileButton() {
		return uploadFileButton;
	}
}
