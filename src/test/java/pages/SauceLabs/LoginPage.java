package pages.SauceLabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import kmdv.Base.PageBase;

public class LoginPage extends PageBase {

	public LoginPage() {
		super();
	}

	@FindBy(id = "password") private WebElement password;
	@FindBy(id = "login-button") private WebElement loginbutton;

	public LoginPage Login(String UserNa, String UserPas) {
		selenium.type(Locators.get("Username_id"), UserNa);
		selenium.type(password, UserPas);
		selenium.click(loginbutton);
		selenium.Log("Login Failed");
		return this;

	}

	public HomePage Login() {
		selenium.type(Locators.get("Username_id"), "standard_user");
		selenium.type(password, "secret_sauce");
		selenium.click(loginbutton);
		selenium.Log("Direct Login successfully");
		return new HomePage();

	}

}
