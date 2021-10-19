package TestPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import AppConfiguration.AppConstants;
import AppConfiguration.Utilityclass;
import BasePackage.BasePage;
import PageClasses.RSQ_GreenKartPage;
import PageClasses.RS_HomePage;
import PageClasses.RS_PracticeLoginPage;
import PageClasses.RS_ProjectPage;

public class RSQ_GreenKartPageTest {

	WebDriver driver;
	Utilityclass action;
	BasePage bp;
	RS_HomePage rs_homepage;
	RS_PracticeLoginPage practice;
	RS_ProjectPage projectpage_instance;
	RSQ_GreenKartPage greenkart;
	SoftAssert softAssert;

	@BeforeMethod

	public void setUp() throws IOException {
		bp = new BasePage();
		driver = bp.init_Driver();
		action = new Utilityclass(driver);
		rs_homepage = new RS_HomePage(driver);
		practice = rs_homepage.clickPracticeTab();
		projectpage_instance = practice.getIntoPractice("Vijay Dhage", "vijaydhage.003@gmail.com");
		greenkart = projectpage_instance.clickOnPractise1link();
		softAssert = new SoftAssert();
	}

	@Test

	public void verifyPractiseLink1() {
		Assert.assertEquals(greenkart.gettingGreenKartTitle(), AppConstants.GREENKART_TITLE);
	}
	
	@Test

	public void verifyVeggieSelection() {
		greenkart.fetch_Veggie_names();
		softAssert.assertEquals(greenkart.numberofCartItems, AppConstants.Actual_Item_Count);
	}

}
