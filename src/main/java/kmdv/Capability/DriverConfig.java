package kmdv.Capability;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

import kmdv.Common.BaseUtil;
import kmdv.Data.PropertiesUtil;

public class DriverConfig extends BaseUtil {

	ThreadLocal<WebDriver> weDriver = new ThreadLocal<WebDriver>() {
		@Override
		protected WebDriver initialValue() {
			WebDriver dov = null;
			if (BrowserStack.equalsIgnoreCase("on")) {
				dov = browserStackDriver();
			}
			else {
				  switch(BrowserName.toLowerCase()){ 
				  case "firefox" :dov = new FirefoxDriver();break;
				  case "chrome" :dov = new ChromeDriver();break;
				  case "edge" :dov = new EdgeDriver();break;
				  case "safari" :dov = new SafariDriver();break;
				  case "firefoxheadless" :FirefoxOptions firefoxOptions = new FirefoxOptions();firefoxOptions.addArguments("-headless");dov = new FirefoxDriver(firefoxOptions);break;
				  case "chromeheadless" :ChromeOptions chromeOptions = new ChromeOptions();chromeOptions.addArguments("--headless=new");dov = new ChromeDriver(chromeOptions);break;
				  default:System.out.println("Update Proper BrowserName in File");
				  }}
			return dov;
		}
	};

	public WebDriver getDriver() {
		return weDriver.get();
	}

	public void quitDriver() {
		getDriver().quit();
		weDriver.remove();
	}

	public RemoteWebDriver browserStackDriver() {
		PropertiesUtil propertiesUtil = new PropertiesUtil (pathRoot.fileFromProperties("browserStack.properties")) ;
		  final String USERNAME = propertiesUtil.getValue("USERNAME");
		  final String ACCESS_KEY = propertiesUtil.getValue("ACCESS_KEY");
		  final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
		  RemoteWebDriver remoteWebDriver = null;

		  DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("os", propertiesUtil.getValue("os"));
		    caps.setCapability("os_version", propertiesUtil.getValue("os_version"));
		    caps.setCapability("browser", propertiesUtil.getValue("browser"));
		    caps.setCapability("browser_version", propertiesUtil.getValue("browser_version"));
		    caps.setCapability("resolution", "1920x1080");
		    caps.setCapability("name", Reporter.getCurrentTestResult().getName()); 
		    caps.setCapability("build", Reporter.getCurrentTestResult().getTestClass().getName()); 
		    try {
			remoteWebDriver = new RemoteWebDriver(new URL(URL), caps);
			} catch (Exception e) {
				 if (USERNAME.isEmpty()) {
					  System.out.println("BROWSERSTACK_USERNAME is Blank");
				  }
				  
				 else if (ACCESS_KEY.isEmpty()) {
					  System.out.println("BROWSERSTACK_ACCESS_KEY is Blank");
				  } else {
						System.out.println("BROWSERSTACK_ERROR = Check Username / Password / OS / Device");

				  }
				  
				System.out.println("FILE_LOCATION = "+pathRoot.fileFromProperties("browserStack.properties"));
				e.printStackTrace();
			}
		    return remoteWebDriver;
	}
}
