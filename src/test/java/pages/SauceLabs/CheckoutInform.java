package pages.SauceLabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import kmdv.Base.PageBase;

public class CheckoutInform extends PageBase {

	public CheckoutInform() {
		super();
	}

	@FindBy(id = "first-name")
	WebElement firstname;
	@FindBy(id = "last-name")
	WebElement lastname;
	@FindBy(id = "postal-code")
	WebElement postalcode;
	@FindBy(xpath = "//input[@id='continue']")
	WebElement ClickContinue;

	public void EnterFirstName(String Fname) {
		selenium.type(firstname, Fname);

	}

	public void EnterLastName(String Lname) {
		selenium.type(lastname, Lname);

	}

	public void EnterZipCode(String Zipcode) {
		selenium.type(postalcode, Zipcode);

	}

	public void ClickContinue() {
		selenium.jsClick(ClickContinue);
	}

}
