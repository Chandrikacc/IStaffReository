package comBplHRMObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {
	public  SettingsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);		
	}

	@FindBy(xpath = "//label[text()='Token Lifespan']/following-sibling::select[@class='form-control']")
	private WebElement tokenLifeSpanDropdown;
	
	@FindBy(id="read")
	private WebElement readCheckBox;
	
	@FindBy(id="Create")
	private WebElement createCheckBox;
	
	@FindBy(id="update")
	private WebElement updateCheckBox;
	
	@FindBy(id="delete")
	private WebElement deleteCheckBox;
	
	@FindBy(xpath = "//button[text()='Generate New Token']")
	private WebElement generateNewTokenButton;

	public WebElement getTokenLifeSpanDropdown() {
		return tokenLifeSpanDropdown;
	}

	public WebElement getReadCheckBox() {
		return readCheckBox;
	}

	public WebElement getCreateCheckBox() {
		return createCheckBox;
	}

	public WebElement getUpdateCheckBox() {
		return updateCheckBox;
	}

	public WebElement getDeleteCheckBox() {
		return deleteCheckBox;
	}

	public WebElement getGenerateNewTokenButton() {
		return generateNewTokenButton;
	}
	

}
