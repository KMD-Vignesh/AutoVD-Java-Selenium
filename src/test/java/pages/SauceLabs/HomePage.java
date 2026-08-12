package pages.SauceLabs;

import java.util.Locale;

import org.openqa.selenium.By;
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

	public HomePage AddProduct(String ProNam) {
		String slug = ProNam.toLowerCase(Locale.ROOT).replaceAll("\\s+", "-");
		By addToCart = By.cssSelector("[data-test='add-to-cart-" + slug + "']");
		selenium.waitUNtil().elementToBeClickable(addToCart).click();
		selenium.Log(ProNam + " - AddCart Button Clicked");
		return this;

	}

	public int Check_Cart_item_count() {
		WebElement badge = selenium.waitUNtil().visibilityOf(Cart_item_count);
		return selenium.StringToInt(badge.getText());

	}

	public void clickonCart() {
		selenium.jsClick(clickonCart);

	}

}
