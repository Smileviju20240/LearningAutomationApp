package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AppConfiguration.Utilityclass;

public class OurProjectPage {
	
	Utilityclass action;
	WebDriver driver;
	
	By Practice1 = By.cssSelector("a[href='https://rahulshettyacademy.com/seleniumPractise/#/']");
	
	
	// Always Create constructor of page class because it will always be called in other class while object creation.
	
	public OurProjectPage(WebDriver driver) {
		this.driver = driver;
		action = new Utilityclass(driver);
	}
	
	public void clickOnPractise1link() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		action.doClickOnWebElement(Practice1);
	}

}
