package AppConfiguration;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePackage.BasePage;

public class Utilityclass extends BasePage {
	
	WebDriver driver;
	WebDriverWait wait;


	public Utilityclass(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}

	public WebElement doFindElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("WebElement is not found" +locator);
		}
		return element;
	}
	
	public void navigateToOtherSite() {
		driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/");
	}

	public void doClickOnWebElement(By locator) {
		doFindElement(locator).click();
	}
	
	public void doClickonPopUpWindow() {
		//driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
	}

	public void doSendValues(By locator, String value) {
		doFindElement(locator).sendKeys(value);
	}

	public String gettingTitle() {
		return driver.getTitle();
	}

	public String gettingText(By locator) {
		return doFindElement(locator).getText();
	}

	public boolean isDisplayed(By locator) {
		return doFindElement(locator).isDisplayed();
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void waitForSpecificWebelement(By locator) {
		wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public List<WebElement> doFindElements(By locator) {
		List<WebElement> element = null;
		try {
			element = driver.findElements(locator);
		} catch (Exception e) {
			System.out.println("WebElement is not found" +locator);
		}
		return element;
	}
	
	public List<WebElement> doFindElementsByRelativeLocator(By locator) {
		List<WebElement> element = null;
		try {
			element = driver.findElements(RelativeLocator.with(locator).toRightOf(locator));
		} catch (Exception e) {
			System.out.println("WebElement is not found" +locator);
		}
		return element;
	}

}
