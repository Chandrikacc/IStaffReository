package comBplHRMObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResourcesModulePage {
	public ResourcesModulePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//tr[@class='tr']/td[text()='Educational documents.xlsx']/following-sibling::td/a[@class='download']")
	private WebElement downloadButton;
	
	@FindBy(xpath="//span[text()='Upload File']")
	private WebElement uploadButton;
	
	@FindBy(xpath="//tr[@class='tr']/td[text()='Educational documents.xlsx']/following-sibling::td/a[@class='delete']")
	private WebElement deleteButton;
	
	@FindBy(xpath="//div[@class='Toastify__toast Toastify__toast--success']/div[@role='alert']")
	private WebElement uploadFileAlert;
	
	@FindBy(xpath="//div[@class='Toastify__toast Toastify__toast--success']/div[@role='alert']")
	private WebElement deleteFileAlert;
	
	public WebElement getDeleteFileAlert() {
		return deleteFileAlert;
	}

	public WebElement getUploadFileAlert() {
		return uploadFileAlert;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public WebElement getDownloadButton() {
		return downloadButton;
	}

	public WebElement getUploadButton() {
		return uploadButton;
	}
	
	
	
	
	

}
