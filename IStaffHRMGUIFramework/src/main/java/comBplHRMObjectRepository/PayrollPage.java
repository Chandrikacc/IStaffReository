package comBplHRMObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayrollPage {
	public PayrollPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}


	@FindBy(xpath="//tr/td[text()='Shivansh kaspadi_7871230']/following-sibling::td/a[@class='edit']")
	private WebElement editButton;

}
