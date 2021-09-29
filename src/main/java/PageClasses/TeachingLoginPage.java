package PageClasses;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AppConfiguration.Utilityclass;
import BasePackage.BasePage;

public class TeachingLoginPage extends BasePage{
	
	Utilityclass action;
	WebDriver driver;
	Properties prop;
	
	By EMAIL_ADDRESS = By.cssSelector("#user_email");
	By password = By.cssSelector("#user_password");
	By Login_Tab = By.name("commit");
	By FORGOT_PASSWORD = By.cssSelector(".link-below-button");
	By CREATE_NEW_ACCOUNT = By.xpath("//a[text()='Create an Account']");
	By error_Message = By.cssSelector(".alert.alert-danger");
	
	public TeachingLoginPage(WebDriver driver) {
		this.driver = driver;
		action = new Utilityclass(driver);
	}
	
	public void dNTLoginWithInvalid_Data(String emailID, String pwd) {
		action.doSendValues(EMAIL_ADDRESS, emailID);
		action.doSendValues(password, pwd);
		action.doClickOnWebElement(Login_Tab);
	}
	
	public void doLoginWithValid_Data() {
		action.doSendValues(EMAIL_ADDRESS, "vijaydhage.003@gmail.com");
		action.doSendValues(password, "Rahul@Vijay");
		action.doClickOnWebElement(Login_Tab);
	}
	
	public void clickOnForgot_Password() {
		action.doClickOnWebElement(FORGOT_PASSWORD);
	}
	
	public void clickOnCreate_New_account() {
		action.doClickOnWebElement(CREATE_NEW_ACCOUNT);
	}

}
