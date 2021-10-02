package TestPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AppConfiguration.Utilityclass;
import BasePackage.BasePage;
import PageClasses.OurProjectPage;
import PageClasses.PracticeLoginPage;
import PageClasses.RS_HomePage;

public class RS_ProjectPageTest {
	
	WebDriver driver;
	Utilityclass action;
	BasePage bp;
	PracticeLoginPage practice;
	RS_HomePage rs_homepage;
	OurProjectPage projectpage_instance;
	
	@BeforeTest

	public void setUp() throws IOException {
		bp = new BasePage();
		driver = bp.init_Driver();
		action = new Utilityclass(driver);
		rs_homepage = new RS_HomePage(driver);
		practice = rs_homepage.clickPracticeTab();
		projectpage_instance = practice.getIntoPractice("Vijay Dhage", "vijaydhage.003@gmail.com");
	}
	
	@Test
	
	public void verifyPractiseLink1() {
		projectpage_instance.clickOnPractise1link();
	}


}
