package com_BPL_HRM_GenericBaseTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import comBplHRMGenericFileUtility.ExcelUtility;
import comBplHRMGenericFileUtility.FileUtility;
import comBplHRMGenericWebdriverUtility.UtilityClassObject;
import comBplHRMGenericWebdriverUtility.WebDriverUtility;
import comBplHRMObjectRepository.HomePage;
import comBplHRMObjectRepository.LoginPage;

@Listeners(comBplHRMGenericListenerUtility.ListenerImpClass.class)
public class BaseClass {
	
	public FileUtility flib=new FileUtility();
	public	ExcelUtility elib= new ExcelUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public static WebDriver sdriver=null;	
	public WebDriver driver=null;
	

//	@Parameters("Browser")
	@BeforeClass(alwaysRun = true)
	public void configBC() throws Throwable{
//	public void configBC(String browser) throws Throwable {
		String Browser=System.getProperty("browser",flib.getDataFromPropertyFile("browser"));
	 // String Browser=flib.getDataFromPropertyFile("browser");
	//	String Browser=browser;
		if(Browser.equals("chrome")) {
		 driver=new ChromeDriver();
	}
		else if(Browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(Browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
		}
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable {
		LoginPage lp=new LoginPage(driver);
		String URL=System.getProperty("url",flib.getDataFromPropertyFile("url"));
		String Username=System.getProperty("username",flib.getDataFromPropertyFile("username"));
		String Password=System.getProperty("password",flib.getDataFromPropertyFile("password"));
		lp.loginToApplication(URL, Username, Password);		
	}
	@AfterMethod(alwaysRun = true)
	public void configAM() throws Throwable {
		Thread.sleep(5000);		
		HomePage hp=new HomePage(driver);
		WebElement signOutButton = hp.getSignOutButton();
		wlib.waitForVisibilityOfElement(driver, signOutButton);
		signOutButton.click();
		
		
	}
	@AfterClass(alwaysRun = true)
	public void configAC() {
		driver.quit();
	}

}
