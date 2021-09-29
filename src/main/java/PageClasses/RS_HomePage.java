package PageClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AppConfiguration.Utilityclass;
import BasePackage.BasePage;

public class RS_HomePage extends BasePage{
	
	Utilityclass action;
	WebDriver driver;
	
	By REGISTER_TAB = By.xpath("//a[text()='Register']");
	By LOGIN_Tab = By.cssSelector(".icon.fa.fa-lock");
	By Navigator_Tab = By.cssSelector(".navigation.clearfix li");
	By App_LOGO = By.cssSelector("div.logo");
	By PRACTICE_Tab = By.xpath("(//a[text()='Practice'])[1]");
	By JOINNOW_Link = By.linkText("https://courses.rahulshettyacademy.com/sign_up");
	By VIEWALLCOURCES = By.xpath("//a[text()='VIEW ALL COURSES']");
	By contact_Email = By.xpath("//li[text()=' contact@rahulshettyacademy.com']");
	By featured_COURSES = By.xpath("//h2[text()='Featured Courses']");
	By COURSES_NAME = By.cssSelector("div.container-fluid div.row.clearfix div.inner-box");
	By Courses_Names = By.cssSelector(".row.course-list.list div.col-xs-12.col-sm-6.col-md-4");
	
	
// Always Create constructor of page class because it will always be called in other class while object creation.

		public RS_HomePage(WebDriver driver) {
			this.driver = driver;
			action = new Utilityclass(driver);
		}
		
		public String getTitleOfHomePage() {
			return action.gettingTitle();
		}
		
		public TeachingLoginPage clickLogin() {
			action.doClickOnWebElement(LOGIN_Tab);
			return new TeachingLoginPage(driver);
		}
		
		public PracticeLoginPage clickPracticeTab() {
			action.doClickOnWebElement(PRACTICE_Tab);
			return new PracticeLoginPage(driver);
		}
		
		public String getText() {
			return action.gettingText(featured_COURSES);
		}

		public String getTextonHomePage() {
			String[] splitStrinfg = action.gettingText(contact_Email).split(" ");
			String emailText = splitStrinfg[0].trim();
			return emailText;
		}

		public boolean doGetLogo() {
			return action.doFindElement(App_LOGO).isDisplayed();
		}

		public int getNumberofCourses() {
			int numberOfCourses=0;
			numberOfCourses = action.doFindmorethanoneElements(COURSES_NAME).size();
			action.doClickOnWebElement(VIEWALLCOURCES);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
			numberOfCourses = action.doFindmorethanoneElements(Courses_Names).size();
			return numberOfCourses;
		}


}
