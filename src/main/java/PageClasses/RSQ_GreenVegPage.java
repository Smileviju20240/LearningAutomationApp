package PageClasses;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AppConfiguration.AppConstants;
import AppConfiguration.Utilityclass;

public class RSQ_GreenVegPage {

	Utilityclass action;
	WebDriver driver;
	List<WebElement> Final_Item_List;
	RSQ_GreenKartPage greenkart;
	List<String> listofvegies;
	String sAdd_Price;

	By final_Item_List = By.xpath("//p[@class='product-name']"); // By using dynamic path approach - //b[text()='ProductName']/following::p[@class='product-name']
	By final_Item_Basic_Price = By.xpath("//p[@class]/ancestor::tr/td[4]/p");
	By final_Item_Price = By.xpath("//p[@class]/ancestor::tr/td[5]/p");
	By List_Quantity = By.xpath("//p[@class='quantity']");
	By total_After_Discount = By.xpath("//span[@class='discountAmt']");
	By Place_Order = By.xpath("//button[text()='Place Order']");

	public RSQ_GreenVegPage(WebDriver driver) {
		this.driver = driver;
		action = new Utilityclass(driver);
		greenkart = new RSQ_GreenKartPage(driver);
	}

	public SelectCountryPage placing_Order_WithCartItem() throws InterruptedException {

		int add_Price = 0;
		int temp = 0;

		Final_Item_List = action.doFindElements(final_Item_List);
		listofvegies = Arrays.asList(AppConstants.Selected_vegiess);

		for (int i = 0; i < Final_Item_List.size(); i++) {
			int Total_Pric = 0;
			int basic_pric = 0;
			int quantite = 0;

			String[] Item_Name = Final_Item_List.get(i).getText().split("-");
			String Final_Itemname = Item_Name[0].trim();

			if (listofvegies.contains(Final_Itemname)) {
				String sQuantite[] = action.doFindElements(List_Quantity).get(i).getText().split(" ");
				String sQuantity = sQuantite[0].trim();
				String sBasic_price = action.doFindElements(final_Item_Basic_Price).get(i).getText();
				// String sTotal_Price = action.doFindElementsByRelativeLocator(final_Item_Basic_Price).get(i).getText();
				String sTotal_Price = action.doFindElements(final_Item_Price).get(i).getText();

				
					basic_pric = Integer.parseInt(sBasic_price);
					quantite = Integer.parseInt(sQuantity);
					Total_Pric = Integer.parseInt(sTotal_Price);
					
				if (Total_Pric == basic_pric * quantite) {
					temp = Total_Pric + temp;
				}

			}

		}
		sAdd_Price = action.doFindElement(total_After_Discount).getText();
		add_Price = Integer.parseInt(sAdd_Price);

		System.out.println(temp == add_Price);
		action.doClickOnWebElement(Place_Order);
		
		return new SelectCountryPage(driver);
	}


}
