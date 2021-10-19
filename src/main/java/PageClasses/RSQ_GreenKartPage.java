package PageClasses;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AppConfiguration.AppConstants;
import AppConfiguration.Utilityclass;

public class RSQ_GreenKartPage {

	Utilityclass action;
	WebDriver driver;
	List <WebElement> All_Product_Lists;
	List<String> listofvegies;
	public String numberofCartItems;
	
	By Products = By.cssSelector("div.products div.product");
	By Add_To_Cart = By.cssSelector("div.product-action");
	By Increment_sign = By.xpath("//a[@class='increment']");
	By Decrement_Sign = By.xpath("//a[@class='decrement']");
	By Product_Name = By.xpath("//h4[@class='product-name']");
	By Product_Price = By.xpath("//p[@class='product-price']");
	By Cart_Icon = By.cssSelector("a.cart-icon");
	By Cart_numbers = By.cssSelector("span.cart-count");
	By Proceed_To_CheckOut = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	
//	By Cart_Items = By.xpath("//div[@class='cart-preview active']//li//p[@class='product-name']");
//	By Cart_Item_BasicPrice = By.xpath("//div[@class='cart-preview active']//li//p[@class='product-price']");
//	By Cart_ItemNumbers = By.xpath("//div[@class='cart-preview active']//li//p[@class='quantity']");
//	By Cart_Item_Proce = By.xpath("//div[@class='cart-preview active']//li//p[@class='amount']");
	By Cart_RemoveItems = By.xpath("(//li//a[@href='#'])[4]");

	public RSQ_GreenKartPage(WebDriver driver) {
		this.driver = driver;
		action = new Utilityclass(driver);
	}
	
	public String gettingGreenKartTitle() {
		return action.gettingTitle();
	}
	
	public void fetch_Veggie_names() {
		
		All_Product_Lists = action.doFindmorethanoneElements(Products);
		listofvegies = Arrays.asList(AppConstants.Selected_vegiess);
		
		for(int i=0; i<All_Product_Lists.size(); i++) {
			int j = 0;
			action.waitForSpecificWebelement(Add_To_Cart);
			
			String[] productName_list = action.doFindElements(Product_Name).get(i).getText().split("-");
			String productname = productName_list[0].trim();
			
			if(listofvegies.contains(productname)) {
				j++;
				action.doFindElements(Increment_sign).get(i).click();
				action.doFindElements(Add_To_Cart).get(i).click();
				
				if (j == AppConstants.Selected_vegiess.length)
					break;
			}
			
		}
		
		action.doClickOnWebElement(Cart_Icon);
		action.doClickOnWebElement(Cart_RemoveItems);
		
	}

}
