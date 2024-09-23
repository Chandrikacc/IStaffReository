package comBplHRMObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comBplHRMGenericWebdriverUtility.WebDriverUtility;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement usernameTextField;
	
	@FindBy(id="inputPassword")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement signUpButton;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getSignUpButton() {
		return signUpButton;
	}
	
	
	public void loginToApplication(String url,String username,String password) {
		WebDriverUtility wlib=new WebDriverUtility();
		driver.get(url);
		wlib.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		
		getUsernameTextField().sendKeys(username);
		getPasswordTextField().sendKeys(password);
		getSignUpButton().click();
		
	}
	
	

}
