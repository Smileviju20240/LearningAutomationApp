package PageClasses;

import org.openqa.selenium.WebDriver;

import AppConfiguration.Utilityclass;

public class RSQ_GreenVegPage {
	
	Utilityclass action;
	WebDriver driver;

	public RSQ_GreenVegPage(WebDriver driver) {
		this.driver = driver;
		action = new Utilityclass(driver);
	}
	
	

}
