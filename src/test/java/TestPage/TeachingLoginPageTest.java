package TestPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AppConfiguration.Utilityclass;
import BasePackage.BasePage;
import PageClasses.RS_HomePage;
import PageClasses.TeachingLoginPage;

public class TeachingLoginPageTest {

	WebDriver driver;
	BasePage bp;
	Utilityclass action;
	TeachingLoginPage tlp;
	RS_HomePage rs_homepage;

	@BeforeMethod
	public void setUp() throws IOException {

		bp = new BasePage();
		driver = bp.init_Driver();
		rs_homepage = new RS_HomePage(driver);
		tlp = rs_homepage.clickLogin();
		action = new Utilityclass(driver);
	}

	@Test(priority=1)

	public void testwith_ValidData() {
		tlp.doLoginWithValid_Data();
	}
	
	@DataProvider
	public Object[][] getInvalidLoginData() {
		Object dataarray[][] = {
				{"test@xcx.com","test"},
				{"","test"},
				{"test@xcx.com",""},
				{"",""}
		};
		return dataarray;
	}

	@Test(priority=2,dataProvider = "getInvalidLoginData")

	public void testwith_InvalidData(String login, String pass) {
		tlp.dNTLoginWithInvalid_Data(login, pass);
	}
	
	@AfterMethod
	public void tearDownpage() {
		action.closeBrowser();
	}

}
