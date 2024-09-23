package comBplHRMObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPayrollPage {
	public  EditPayrollPage(WebDriver driver) {
		PageFactory.initElements(driver,this);		
	}

	@FindBy(xpath = "//label[text()='Basic + VDA']/following-sibling::input[@class='form-control']")
	private WebElement basicVDATextfield;
	
	@FindBy(xpath = "//label[text()='HRA']/following-sibling::input[@class='form-control']")
	private WebElement hraTextField;
	
	@FindBy(xpath = "//label[text()='Stat-Bonus']/following-sibling::input[@class='form-control']")
	private WebElement statBonusTextfield;
	
	@FindBy(xpath="//label[text()='LTA']/following-sibling::input[@class='form-control']")
	private WebElement ltaTextField;
	
	@FindBy(xpath = "//label[text()='PF']/following-sibling::input[@class='form-control']")
	private WebElement pfTextField;
	
	@FindBy(xpath="//label[text()='PT']/following-sibling::input[@class='form-control']")
	private WebElement ptTextField;
	
	
	@FindBy(xpath="//label[text()='Insurance']/following-sibling::input[@class='form-control']")
	private WebElement insuranceTextField;
	
	@FindBy(xpath = "//label[text()='LWF']/following-sibling::input[@class='form-control']")
	private WebElement lwfTextfield;
	
	@FindBy(xpath="//label[text()='Status']/following-sibling::select[@class='form-control']")
	private WebElement statusDropdown;
	
	@FindBy(xpath="//input[@value='Save']")
	private WebElement saveButton;

	public WebElement getBasicVDATextfield() {
		return basicVDATextfield;
	}

	public WebElement getHraTextField() {
		return hraTextField;
	}

	public WebElement getStatBonusTextfield() {
		return statBonusTextfield;
	}

	public WebElement getLtaTextField() {
		return ltaTextField;
	}

	public WebElement getPfTextField() {
		return pfTextField;
	}

	public WebElement getPtTextField() {
		return ptTextField;
	}

	public WebElement getInsuranceTextField() {
		return insuranceTextField;
	}

	public WebElement getLwfTextfield() {
		return lwfTextfield;
	}

	public WebElement getStatusDropdown() {
		return statusDropdown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}	

}
