package PageClasses;

import org.openqa.selenium.WebDriver;

import AppConfiguration.Utilityclass;

public class SelectCountryPage {
	
	Utilityclass action;
	WebDriver driver;

	public SelectCountryPage(WebDriver driver) {
		this.driver = driver;
		action = new Utilityclass(driver);
	}

}
