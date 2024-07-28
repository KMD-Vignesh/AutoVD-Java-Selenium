package kmdv.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import kmdv.Common.BaseUtil;
import kmdv.Common.SeleniumUtil;

public class PageBase extends BaseUtil {

	protected SeleniumUtil selenium;
	protected WebDriver driver;

	public PageBase() {
		this.selenium = Selenium.get();
		this.driver = selenium.getDriver();
		selenium.waitPageLoad();
		PageFactory.initElements(driver, this);
	}

}
