package PageClasses;

import org.openqa.selenium.WebDriver;

import AppConfiguration.Utilityclass;

public class OurProjectPage {
	
	Utilityclass action;
	WebDriver driver;
	
	// Always Create constructor of page class because it will always be called in other class while object creation.
	
	public OurProjectPage(WebDriver driver) {
		this.driver = driver;
		action = new Utilityclass(driver);
	}

}
