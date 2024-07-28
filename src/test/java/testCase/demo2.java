package testCase;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import kmdv.Base.TestBase;
import kmdv.Common.SeleniumUtil;
import kmdv.Common.SeleniumUtil.locatorType;
import kmdv.config.TestNG.Author;

public class demo2 extends TestBase {

	@Author(Name = "Vignesh")
	@Test()
	public void saucedemo3() {
		String webURL = "https://www.saucedemo.com/";
		SeleniumUtil selenium = Selenium(webURL);

		
		WebElement Username = selenium.getElement(Locators.get("Username_id"));
		WebElement password = selenium.findBy_ID("password");
		
		selenium.Log(selenium.getLocatorString(Username));
		Username = selenium.refreshElement(Username);
		selenium.type(Username, "standard_use");
		selenium.type(password, "secret_sauce");
		selenium.click(locatorType.ID, "login-button");
		selenium.pageScreenShot();

		selenium.Log("Direct Login not successfully");
		selenium.sleep(2);



	
	}
	
}
