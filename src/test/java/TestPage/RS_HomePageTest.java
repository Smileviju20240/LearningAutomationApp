package TestPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AppConfiguration.AppConstants;
import AppConfiguration.Utilityclass;
import BasePackage.BasePage;
import PageClasses.RS_HomePage;

public class RS_HomePageTest{
	
	WebDriver driver;
	BasePage bp;
	Utilityclass action;
	RS_HomePage rs_homepage;
	
	@BeforeTest
	public void setUp() throws IOException {
		
		bp = new BasePage();
		driver = bp.init_Driver();
		rs_homepage = new RS_HomePage(driver);
		action = new Utilityclass(driver);
	}
	
	@Test(priority=1)
	  public void verifyHomePage() {
		    Assert.assertTrue(rs_homepage.doGetLogo());
		    Assert.assertEquals(AppConstants.FEATURED_COURSES, rs_homepage.getText());
			Assert.assertEquals(AppConstants.RS_HOME_PAGE_TITLE, rs_homepage.getTitleOfHomePage());
			Assert.assertEquals(AppConstants.RS_CONATCT_EMAIL, rs_homepage.getTextonHomePage());
			Assert.assertEquals(rs_homepage.getNumberofCourses() >= 12, true);
	  }
	
	@Test(priority=2)
	
	public void clickingonLoginTab() {
		rs_homepage.clickLogin();
		action.closeBrowser();
	}


}
