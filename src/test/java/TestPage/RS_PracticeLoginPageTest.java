package TestPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AppConfiguration.AppConstants;
import AppConfiguration.Utilityclass;
import BasePackage.BasePage;
import PageClasses.RS_PracticeLoginPage;
import PageClasses.RS_HomePage;

public class RS_PracticeLoginPageTest {

	WebDriver driver;
	Utilityclass action;
	BasePage bp;
	RS_PracticeLoginPage practice;
	RS_HomePage rs_homepage;
	

	@BeforeTest

	public void setUp() throws IOException {
		bp = new BasePage();
		driver = bp.init_Driver();
		action = new Utilityclass(driver);
		rs_homepage = new RS_HomePage(driver);
		practice = rs_homepage.clickPracticeTab();
	}

	@Test

	public void verifytermsandconditionText() {
		Assert.assertEquals(practice.gettingtermsandconditionText(), AppConstants.PRACTICEPAGE_TERMS);
	}
	
	@Test
	public void Loginto_PractiePage() {
		practice.getIntoPractice("Vijay Dhage", "vijaydhage.003@gmail.com");
	}
	
	@AfterTest
	public void tearDownpage() {
		action.closeBrowser();
	}

}
