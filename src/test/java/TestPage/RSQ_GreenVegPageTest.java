package TestPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AppConfiguration.Utilityclass;
import BasePackage.BasePage;
import PageClasses.RSQ_GreenKartPage;
import PageClasses.RSQ_GreenVegPage;
import PageClasses.RS_HomePage;
import PageClasses.RS_PracticeLoginPage;
import PageClasses.RS_ProjectPage;

public class RSQ_GreenVegPageTest {
	
	WebDriver driver;
	Utilityclass action;
	BasePage bp;
	RS_HomePage rs_homepage;
	RS_PracticeLoginPage practice;
	RS_ProjectPage projectpage_instance;
	RSQ_GreenKartPage greenkart;
	RSQ_GreenVegPage greenveg;

	
	@BeforeMethod

	public void setUp() throws IOException {
		bp = new BasePage();
		driver = bp.init_Driver();
		action = new Utilityclass(driver);
		rs_homepage = new RS_HomePage(driver);
		practice = rs_homepage.clickPracticeTab();
		projectpage_instance = practice.getIntoPractice("Vijay Dhage", "vijaydhage.003@gmail.com");
		greenkart = projectpage_instance.clickOnPractise1link();
		greenveg = greenkart.fetch_Veggie_names();

}
	
	@Test

	public void verify_Order_Isplaced() throws InterruptedException {
		greenveg.placing_Order_WithCartItem();
		
	}

	
}