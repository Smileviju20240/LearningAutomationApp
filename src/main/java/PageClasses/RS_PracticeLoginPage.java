package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AppConfiguration.Utilityclass;
import BasePackage.BasePage;

public class RS_PracticeLoginPage extends BasePage{
	
	Utilityclass action;
	WebDriver driver;
	
	By Your_Name = By.xpath("//input[@type='text' and @name='name']");
	By E_Mail = By.xpath("//input[@type='email' and @name='email']");
	By CHECK_BOX = By.xpath("//input[@id='agreeTerms']");
	By Submit_BTN = By.xpath("//button[@id='form-submit']");
	By Terms = By.xpath("//label[@style='display: inline;']");

	// Always Create constructor of page class because it will always be called in other class while object creation.
	
	public RS_PracticeLoginPage(WebDriver driver) {		
		this.driver = driver;
		action = new Utilityclass(driver);
	}
	
	public RS_ProjectPage getIntoPractice(String name, String email) {
		action.doSendValues(Your_Name, "Vijay Dhage");
		action.doSendValues(E_Mail, "vijaydhage.003@gmail.com");
		action.doClickOnWebElement(CHECK_BOX);
		action.doClickOnWebElement(Submit_BTN);
		
		return new RS_ProjectPage(driver);
	}
	
	public String gettingtermsandconditionText() {
		return action.gettingText(Terms);
		
	}

}
