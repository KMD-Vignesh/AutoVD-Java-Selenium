package pages.SauceLabs;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import kmdv.Base.PageBase;

public class CheckoutOverview extends PageBase {

	public CheckoutOverview() {
		super();
	}

	double ItemEachTotal = 0, ItemTotal, ItemEachTotalTax, ItemTotalTax;
	@FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[5]")
	WebElement Total;
	@FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]")
	WebElement TotalTax;
	@FindBy(xpath = "//*[contains(@class,'inventory_item_price')]")
	List<WebElement> itemValue;

	public void itemTotal() {

		for (int i = 0; i < itemValue.size(); i++) {
			selenium.Log(
					"Item " + (i + 1) + " Price : " + Double.parseDouble(itemValue.get(i).getText().replace("$", "")));
			ItemEachTotal = ItemEachTotal + Double.parseDouble(itemValue.get(i).getText().replace("$", ""));

		}

		selenium.Log("ItemEachTotal: " + ItemEachTotal);
		ItemTotal = Double.parseDouble(Total.getText().replace("Item total: $", ""));
		selenium.Log("ItemTotal: " + ItemTotal);
		if (Double.compare(ItemEachTotal, ItemTotal) == 0) {
			selenium.Log("ItemTotal Value is Correct");
		} else {
			selenium.Log("ItemTotal Value is NOT Correct");
		}
	}

	public void CheckTax() {
		ItemEachTotalTax = Math.round((ItemEachTotal * 8) / 100 * 100.0) / 100.0;
		selenium.Log("ItemEachTotal Tax: " + ItemEachTotalTax);
		ItemTotalTax = Double.parseDouble(TotalTax.getText().replace("Tax: $", ""));
		selenium.Log("ItemTotalTax Tax: " + ItemTotalTax);
		if (Double.compare(ItemEachTotalTax, ItemTotalTax) == 0) {
			selenium.Log("ItemTotal Tax is Correct");
		} else {
			selenium.Log("ItemTotal Tax is NOT Correct");
		}

	}
}
