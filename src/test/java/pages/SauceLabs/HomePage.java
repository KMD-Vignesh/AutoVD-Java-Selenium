package pages.SauceLabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import kmdv.Base.PageBase;

public class HomePage extends PageBase {

	public HomePage() {
		super();
	}

	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	public WebElement Cart_item_count;

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	public WebElement clickonCart;

	@FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")
	public WebElement AddCart;

	@FindBy(xpath = "//button[@class='btn btn_secondary back btn_large inventory_details_back_button']")
	public WebElement Back;

	public HomePage AddProduct(String ProNam) {
		WebElement productName = selenium.findBy_LinkText(ProNam);
		selenium.scrollBY_XY(productName);
		selenium.sleep(1);
		selenium.jsClick(productName);
		selenium.Log(ProNam + " - Product Clicked");
		selenium.sleep(1);
		selenium.actionClick(selenium.waitUNtil().elementToBeClickable(AddCart));
		selenium.Log(ProNam + " - AddCart Button Clicked");
		selenium.sleep(1);
		selenium.actionClick(Back);
		selenium.Log(ProNam + " - Back Button Clicked");
		selenium.sleep(1);
		return this;

	}

	public int Check_Cart_item_count() {
		selenium.sleep(1);
		return selenium.StringToInt(Cart_item_count.getText());

	}

	public void clickonCart() {
		selenium.jsClick(clickonCart);

	}

}
