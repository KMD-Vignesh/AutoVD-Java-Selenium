package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import kmdv.Base.TestBase;
import kmdv.Common.RestAPIUtil;
import kmdv.Common.SeleniumUtil;
import kmdv.config.TestNG.Author;
import pages.SauceLabs.HomePage;
import pages.SauceLabs.LoginPage;

public class demo1 extends TestBase {

	@Author(Name = "Vignesh")
	@Test
	public void saucedemo1() {
		String webURL = "https://www.saucedemo.com/";
		SeleniumUtil selenium = Selenium(webURL);

		HomePage HomePage = new LoginPage().Login();

		int check_Cart_item_count = HomePage.AddProduct("Sauce Labs Onesie").Check_Cart_item_count();
		selenium.Log(Integer.toString(check_Cart_item_count));
		selenium.elementScreenShot(HomePage.Cart_item_count);

		check_Cart_item_count = HomePage.AddProduct("Sauce Labs Backpack").Check_Cart_item_count();
		selenium.Log(selenium.IntToString(check_Cart_item_count));
		selenium.pageScreenShot();
		Assert.assertTrue(true);

	}
	
	@Author(Name = "Dhakshna")
	@Test
	public void saucedemo2() {
		String webURL = "https://www.saucedemo.com/";
		SeleniumUtil selenium = Selenium(webURL);

		HomePage HomePage = new LoginPage().Login();

		int check_Cart_item_count = HomePage.AddProduct("Sauce Labs Backpack").Check_Cart_item_count();
		selenium.Log(Integer.toString(check_Cart_item_count));
		selenium.elementScreenShot(HomePage.Cart_item_count);

		check_Cart_item_count = HomePage.AddProduct("Sauce Labs Onesie").Check_Cart_item_count();
		selenium.Log(selenium.IntToString(check_Cart_item_count));
		Assert.assertTrue(true);

	}
	
	@Author(Name = "Dhakshna")
	@Test
	public void getUser() {
		String baseURI = "https://reqres.in/";
		RestAPIUtil restAPI = RestAPI(baseURI);
		
		restAPI.Log(restAPI.getStatusCode("api/users/2"));
		restAPI.Log(restAPI.getBody("api/users/2"));

	}

}
