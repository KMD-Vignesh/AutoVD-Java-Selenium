<a href="#"><h1 align="center">KMDV Java Framework <img src="https://img.shields.io/badge/Version-1.0.6-blue?style=plastic&logo=appveyor" alt="version" ><p align="center"><img src="https://img.shields.io/badge/Java-v1.8-yellowgreen" alt="Java Version"/> <img src="https://img.shields.io/badge/Maven-v3.8-yellowgreen" alt="Maven Version"/> <img src="https://img.shields.io/badge/Selenium-v4.1.0-yellowgreen" alt="Selenium Version"/> <img src="https://img.shields.io/badge/RestAssured-v4.4.0-yellowgreen" alt="RestAssured Version"/> <img src="https://img.shields.io/badge/TestNG-v7.4.0-yellowgreen" alt="TestNG Version"/> <img src="https://img.shields.io/badge/ExtentReport-v5.0.9-yellowgreen" alt="ExtentReport Version"/><br><a href="https://github.com/VigneshDhakshnamoorthy/KMDV-Automation-Framework/actions/workflows/maven.yml"></a></p></h1><h5><p align="center"><a href="https://www.linkedin.com/in/vigneshdhakshnamoorthy/"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="Vignesh | LinkedIn" width="120px"/></a><br>✍️ : <a href="https://github.com/VigneshDhakshnamoorthy">Vignesh Dhakshnamoorthy</a> ( Senior Software Quality Analyst )<br>📧 : <a href="mailto:KMD.Vignesh@outlook.com">KMD.Vignesh@outlook.com</a> / <a href="mailto:VigneshDhakshnamoorthy@gmail.com">VigneshDhakshnamoorthy@gmail.com </a></a></p> </h5></a>

<hr>

> <h5> <a href="https://github.com/VigneshDhakshnamoorthy/KMDV-Automation-Framework/raw/master/KMDVFramework.jar"><img src="https://img.shields.io/badge/Download-KMDV%20Framework.jar-red" alt="Download JAR"/></a></h5>

```python
// download KMDVFramework.jar from above link and save in Project folder
// add that as a dependency
```

> #### 🤝 Dependencies
> 
> <h5> <a href="#">KMDVFramework dependency</a></h5>

```xml
<dependency>
	<groupId>org.KMDV</groupId>
	<artifactId>KMDV-Java-Framework</artifactId>
	<version>1.0.6</version>
	<scope>system</scope>
	<systemPath>${project.basedir}/KMDVFramework.jar</systemPath>
</dependency>
```

> <h5> <a href="/pom.xml">Other dependencies (Link)</a></h5>

<table>
<tr>
    <td><b>GroupId</b></td>
    <td><b>ArtifactId</b></td>
    <td><b>Version</b></td>
  </tr>
  <tr>
    <td>org.testng</td>
    <td>testng</td>
    <td>7.5</td>
  </tr>
  <tr>
    <td>org.seleniumhq.selenium</td>
    <td>selenium-java</td>
    <td>4.1.1</td>
  </tr>
  <tr>
    <td>io.github.bonigarcia</td>
    <td>webdrivermanager</td>
    <td>5.1.1</td>
  </tr>  
  <tr>
    <td>org.apache.poi</td>
    <td>poi</td>
    <td>5.2.2</td>
  </tr>  
  <tr>
    <td>org.apache.poi</td>
    <td>poi-ooxml</td>
    <td>5.2.2</td>
  </tr>  
  <tr>
    <td>com.aventstack</td>
    <td>extentreports</td>
    <td>5.0.9</td>
  </tr>  
  <tr>
    <td>org.projectlombok</td>
    <td>lombok</td>
    <td>1.18.24</td>
  </tr>

<a href="#"><h2 align="center">`API` Automation</h2></a>

> <h4> <a href="#">API</a> : TestCase</h4>

```java
public class demo extends TestBase {

	@Author(Name = "Dhakshna")
	@Test
	public void demoAPI() {
		String baseURI ="https://reqres.in/";
		RestAPIUtil restAPI= RestAPI(baseURI);
		restAPI.Log( restAPI.getStatusCode() );
    }

}
```

> <h4> <a href="#">API</a> : Helper Methods</h4>

```java
restAPI.getStatusCode
restAPI.getBody
restAPI.getMethodName
restAPI.Log
restAPI.logC
restAPI.logE
restAPI.IntToString
restAPI.StringToInt
restAPI.StringEquals
restAPI.Today
restAPI.Yesterday
restAPI.Tomorrow
restAPI.localDate
restAPI.toCharArray
restAPI.getRandom
```

<hr>

<a href="#"><h2 align="center">`WEB` Automation</h2></a>

> #### browser.properties ( src / test / resources / Properties )

```properties
BrowserName = chrome
waitTime = 15
BrowserStack = off
```

<table>

> #### browserStack.properties ( src / test / resources / Properties )

```properties
USERNAME = 
ACCESS_KEY = 

os = Windows
os_version = 10

browser = Chrome
browser_version = latest
```

> #### locators.properties ( src / test / resources / Properties )

```properties
Username_id = user-name
```

to get the value : Locators.get("Username_id")

<h1></h1>

> <h4> <a href="#">WEB</a> : PageObject</h4>

```java
public class LoginPage extends PageBase {

	private final By password = By.xpath("*//[@id='password']");
	@FindBy(id="login-button") private WebElement loginbutton;

	public LoginPage Login() {
		selenium.type(Locators.get("Username_id"), "standard_user");
		selenium.type(password, "secret_sauce");
		selenium.click(loginbutton);
		return this;
	}
```

> <h4> <a href="#">WEB</a> : TestCase</h4>

```java
public class demo extends TestBase {

	@Author(Name = "Vignesh")
	@Test
	public void demoWEB() {
		String webURL ="https://www.saucedemo.com/";
		SeleniumUtil selenium = Selenium(webURL);
	
		new LoginPage().Login();
		selenium.Log("Logged in successfully");
    }

}
```

> <h4> <a href="#">WEB</a> : Helper Methods</h4>

```java
selenium.Log()
selenium.logConsole()
selenium.logExtent()
selenium.logList()
selenium.logCList()
selenium.logEList()

selenium.findBy_ClassName()
selenium.findBy_CssSelector()
selenium.findBy_ID()
selenium.findBy_LinkText()
selenium.findBy_Name()
selenium.findBy_PartialLinkText()
selenium.findBy_Xpath()

selenium.findAll_ClassName()
selenium.findAll_CssSelector()
selenium.findAll_ID()
selenium.findAll_LinkText()
selenium.findAll_Name()
selenium.findAll_PartialLinkText()
selenium.findAll_Xpath()

selenium.getShadowRoot()
selenium.getShadowContent()

selenium.getElement()
selenium.getElements()
selenium.getList()

selenium.getBY()
selenium.refreshElement()
selenium.getLocatorString()

selenium.getAttribute()
selenium.setAttribute()

selenium.click()
selenium.type()
selenium.typeENTER()
selenium.typeTAB()
selenium.back()
selenium.clear()
selenium.clickList()
selenium.clickSleep()
selenium.forward()
selenium.getCurrentUrl()
selenium.getDriver()
selenium.getLocation()
selenium.getMethodName()
selenium.getPageSource()
selenium.getText()
selenium.getTitle()
selenium.isDisplayed()
selenium.isEnabled()
selenium.isSelected()
selenium.maximize()
selenium.minimize()
selenium.navigateTo()
selenium.refresh()
selenium.screenHeight()
selenium.screenWidth()
selenium.windowDimension()

selenium.getDropDownSelectValue()
selenium.selectDropDown()

selenium.sleep()
selenium.sleepMilliSeconds()
selenium.waitDisplayed()
selenium.waitEnabled()
selenium.waitPageLoad()
selenium.waitSelected()

selenium.elementScreenShot()
selenium.pageScreenShot()

selenium.defaultFrame()
selenium.parentFrame()
selenium.switchFrame()
selenium.getTabs()
selenium.switchTab()
selenium.countTabs()
selenium.currentTab()

selenium.acceptAlert()
selenium.dismissAlert()
selenium.getAlert()
selenium.textAlert()
selenium.typeAlert()

selenium.jsClick()
selenium.jsType()
selenium.scrollTO_XY()
selenium.scrollBY_XY()
selenium.scrollIntoView()
selenium.executeScript()

selenium.actionClick()
selenium.actionDOWN()
selenium.actionENTER()
selenium.actionESCAPE()
selenium.actionLEFT()
selenium.actionRETURN()
selenium.actionRIGHT()
selenium.actionTAB()
selenium.actionType()
selenium.actionUP()
selenium.contextClick()
selenium.doubleClick()
selenium.dragAndDrop()

selenium.mouseLeftClick()
selenium.mouseMove()
selenium.mouseRightClick()
selenium.moveTo()
selenium.robotBACKSPACE()
selenium.robotCOPY()
selenium.robotCUT()
selenium.robotDOWN()
selenium.robotENTER()
selenium.robotESCAPE()
selenium.robotLEFT()
selenium.robotPASTE()
selenium.robotRIGHT()
selenium.robotSELECT()
selenium.robotTAB()
selenium.robotUP()

selenium.countList()
selenium.compare()
selenium.IntToString()
selenium.getRandom()
selenium.localDate()
selenium.listContains()
selenium.StringEquals()
selenium.StringToInt()
selenium.toCharArray()
selenium.Today()
selenium.Tomorrow()
selenium.Yesterday()

selenium.waitUNtil().alertIsPresent()
selenium.waitUNtil().attributeContains()
selenium.waitUNtil().attributeToBe()
selenium.waitUNtil().attributeToBeNotEmpty()
selenium.waitUNtil().elementSelectionStateToBe()
selenium.waitUNtil().elementToBeClickable()
selenium.waitUNtil().elementToBeSelected()
selenium.waitUNtil().frameToBeAvailableAndSwitchToIt()
selenium.waitUNtil().invisibilityOf()
selenium.waitUNtil().invisibilityOfAllElements()
selenium.waitUNtil().invisibilityOfElementLocated()
selenium.waitUNtil().invisibilityOfElementWithText()
selenium.waitUNtil().javaScriptThrowsNoExceptions()
selenium.waitUNtil().jsReturnsValue()
selenium.waitUNtil().numberOfElementsToBe()
selenium.waitUNtil().numberOfElementsToBeLessThan()
selenium.waitUNtil().numberOfElementsToBeMoreThan()
selenium.waitUNtil().numberOfWindowsToBe()
selenium.waitUNtil().presenceOfAllElementsLocatedBy()
selenium.waitUNtil().presenceOfElementLocated()
selenium.waitUNtil().presenceOfNestedElementLocatedBy()
selenium.waitUNtil().presenceOfNestedElementsLocatedBy()
selenium.waitUNtil().stalenessOf()
selenium.waitUNtil().textToBe()
selenium.waitUNtil().textToBePresentInElementLocated()
selenium.waitUNtil().textToBePresentInElement()
selenium.waitUNtil().textToBePresentInElementValue()
selenium.waitUNtil().titleContains()
selenium.waitUNtil().titleIs()
selenium.waitUNtil().urlContains()
selenium.waitUNtil().urlToBe()
selenium.waitUNtil().visibilityOf()
selenium.waitUNtil().visibilityOfAllElements()
selenium.waitUNtil().visibilityOfElementLocated()
selenium.waitUNtil().visibilityOfAllElementsLocatedBy()
selenium.waitUNtil().visibilityOfNestedElementsLocatedBy()
```

<hr>

> #### 📁 Folders

<table> 
<tr>
	  <td>
	    <b>SuitesXML</b> <br>
	    <a href="/SuitesXML"><i>can store testRunner XML files </i></a>
	</td>
	<td>
	    <b>src / test / resources / Properties</b> <br>
	    <a href="/src/test/resources/Properties"><i>First Time Auto Generate : browser.properties, browserStack.properties, locators.properties</i></a>
	</td>
</tr>
<tr>
	<td><img src="/src/main/resources/Images/folders.png" alt="folders" width="270" height="430"> </td> 
 	<td> 
	   <b> src / test / resources / TestData </b><i><br>Excel<br>JSON<br>Others<br>Text<br></i>
	    <a href="/src/test/resources/TestData"><i>can store xlsx, json, txt, etc...</i></a> <hr>
	    <b>Report-Screenshot / ExtentReport</b> <br>
	    <a href="/Report-ScreenShot/ExtentReport"><i>Each Time Auto Generate : Extent.Html</i></a>  <hr>
	    <b>Report-Screenshot / Screenshots</b> <i><br>Failed<br>Passed<br>Skipped<br></i>
	    <a href="/Report-ScreenShot/ScreenShots"><i>Passed - Manual , Failed - Auto , Skipped - Auto</i></a>
		</td>
</tr>

> #### SuiteXML

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="KMDV Automation" parallel="methods" thread-count="5">
 
  <test name="KMDV Test">
  	<classes>
     	<class name="testCase.demo"></class>
  	</classes>
  </test>
  
</suite>
```

<hr>

<a href="#"><h2 align="center">`Helper` Classes</h2></a>

> <h4> Helper Class : <a href="/src/main/java/util/Data/ExcelUtil.java">ExcelUtil</a></h4>

```java
String path = Path.fileFromExcelTestData("sample.xlsx");
ExcelUtil excelUtil = new ExcelUtil (path) ;
```

```java
excelUtil.getCellDataByValue
excelUtil.getFullExcelData
excelUtil.getRowColNumbers
excelUtil.getRowNumber
excelUtil.getColumnNumber
excelUtil.getRowCount
excelUtil.getCellCount
excelUtil.getCellDataByNum
excelUtil.setCellData
excelUtil.fillGreenColor
excelUtil.fillRedColor
```

> <h4> Helper Class : <a href="/src/main/java/util/Data/JsonUtil.java">JsonUtil</a></h4>

```java
String path = Path.fileFromJsonTestData("sample.json");
JsonUtil jsonUtil = new JsonUtil (path) ;
```

```java
jsonUtil.getPojo
jsonUtil.getObject
jsonUtil.getValue
jsonUtil.getKeys
jsonUtil.getArray
jsonUtil.getObjFromArray
```

> <h4> Helper Class : <a href="/src/main/java/util/Data/PropertiesUtil.java">PropertiesUtil</a></h4>

```java
String path = Path.fileFromProperties("sample.properties");
PropertiesUtil propertiesUtil = new PropertiesUtil (path) ;
```

```java
propertiesUtil.getValue
propertiesUtil.getKeys
propertiesUtil.getMAP
```

> <h4> Helper Class : <a href="/src/main/java/util/Data/TextUtil.java">TextUtil</a></h4>

```java
String path = Path.fileFromTextTestData("sample.txt");
TextUtil textUtil = new TextUtil (path) ;
```

```java
textUtil.readLines
textUtil.writeLine
```

