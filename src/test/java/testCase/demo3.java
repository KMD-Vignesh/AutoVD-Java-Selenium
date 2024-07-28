package testCase;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import kmdv.Base.TestBase;
import kmdv.Common.SeleniumUtil;
import kmdv.Common.SeleniumUtil.locatorType;
import kmdv.Data.JsonUtil;
import kmdv.config.TestNG.Author;
import kmdv.config.TestNG.TestID;

public class demo3 extends TestBase {

	@Test()
	public void demo31TC() throws Exception {
		String webURL = "https://www.google.com/";
		SeleniumUtil selenium = Selenium(webURL);
		selenium.Log(selenium.getTitle());

		JsonUtil jsonUtil = new JsonUtil(pathRoot.fileFromJsonTestData("test.json"));
		PojoJSON pojo = jsonUtil.getPojo(PojoJSON.class);
		selenium.Log(pojo.getLastName());
		pojo.setLastName("Dhakshna");
		selenium.Log(pojo.getLastName());
		
		selenium.Log(jsonUtil.getValue("firstName"));
		selenium.Log(jsonUtil.getKeys());
		selenium.Log(jsonUtil.getAllValues());
	}
	
	@Author(Name = "Vignesh")
	@TestID(Name = "Number2")
	@Test()
	public void demo32TC() throws Exception {
		String webURL = "https://www.saucedemo.com/";
		SeleniumUtil selenium = Selenium(webURL);

		
		WebElement Username = selenium.getElement(Locators.get("Username_id"));
		WebElement password = selenium.findBy_ID("password");
		
		selenium.type(Username, "standard_use");
		selenium.type(password, "secret_sauce");
		selenium.click(locatorType.ID, "login-button");
		selenium.pageScreenShot();
		selenium.Log("Direct Login not successfully");
		selenium.sleep(2);
	}
	
	}