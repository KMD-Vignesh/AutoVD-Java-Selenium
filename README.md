<div align="center">

<h1>AutoVD-Java-Selenium</h1>

<p><strong>Hybrid UI + API test automation framework for Java</strong><br>
Selenium WebDriver · TestNG · REST Assured · Page Objects · ExtentReports</p>

<p>
  <a href="https://github.com/KMD-Vignesh/AutoVD-Java-Selenium"><img src="https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 17"></a>
  <a href="https://github.com/KMD-Vignesh/AutoVD-Java-Selenium"><img src="https://img.shields.io/badge/Selenium-4.47.0-43B02A?style=for-the-badge&logo=selenium&logoColor=white" alt="Selenium 4.47.0"></a>
  <a href="https://github.com/KMD-Vignesh/AutoVD-Java-Selenium"><img src="https://img.shields.io/badge/TestNG-7.10.2-FF6F00?style=for-the-badge" alt="TestNG 7.10.2"></a>
  <a href="https://github.com/KMD-Vignesh/AutoVD-Java-Selenium/blob/main/LICENSE"><img src="https://img.shields.io/badge/License-MIT-2EA44F?style=for-the-badge" alt="MIT License"></a>
</p>

</div>

<div align="center">

<h3>Author : Vignesh D</h3>

<p><strong>Senior Software Quality Analyst</strong><br>Chennai, India</p>

<p>
    <a href="https://www.linkedin.com/in/kmd-vignesh/"><img src="https://img.shields.io/badge/LinkedIn-0A75AD?style=for-the-badge" alt="LinkedIn"></a>
    <a href="https://github.com/KMD-Vignesh"><img src="https://img.shields.io/badge/GitHub-F0E0D0?style=for-the-badge" alt="GitHub"></a>
    <a href="mailto:KMD.Vignesh@outlook.com"><img src="https://img.shields.io/badge/KMD.Vignesh@Outlook-FF6A80?style=for-the-badge" alt="Email"></a>

</p>

</div>

## What It Is

A Selenium + TestNG framework that keeps the boilerplate out of your tests. Extend `TestBase`, call `Selenium(url)` or `RestAPI(baseURI)`, and you get a thread-safe browser or API client, an Extent test, automatic screenshots, and an Excel result row when the method finishes.

- **One line to start** — `Selenium(url)` sets up the driver, report entry, and helper object.
- **Page objects that stay small** — `PageBase` injects the driver and helper, then initialises `@FindBy` fields.
- **Parallel by default** — drivers and helpers live in `ThreadLocal`s; the bundled suite runs 5 methods at a time.
- **Output you can use** — ExtentReports HTML, Excel results, and failure/skip screenshots on every run.

## Framework Family

Seven implementations of the same layered idea. Pick the stack your team already uses; the concepts and reports stay familiar.

| Framework                       | Stack                         | Covers    | Repository                                                                                  |
| :------------------------------ | :---------------------------- | :-------- | :------------------------------------------------------------------------------------------ |
| **Java + Selenium** — this repo | Java 17 · Selenium 4 · TestNG | UI + REST | [AutoVD-Java-Selenium](https://github.com/KMD-Vignesh/AutoVD-Java-Selenium)                 |
| **Java + Playwright**           | Java · Playwright · TestNG    | UI + REST | [AutoVD-Java-Playwright](https://github.com/KMD-Vignesh/AutoVD-Java-Playwright)             |
| **C# + Playwright**             | C# · Playwright · NUnit       | UI + REST | [AutoVD-CS-Playwright](https://github.com/KMD-Vignesh/AutoVD-CS-Playwright)                 |
| **Python + Selenium**           | Python · Selenium · pytest    | UI + REST | [AutoVD-Python-Selenium](https://github.com/KMD-Vignesh/AutoVD-Python-Selenium)             |
| **Python + Playwright**         | Python · Playwright · pytest  | UI + REST | [AutoVD-Python-Playwright](https://github.com/KMD-Vignesh/AutoVD-Python-Playwright)         |
| **TypeScript + Playwright**     | TypeScript · Playwright       | UI + REST | [AutoVD-Typescript-Playwright](https://github.com/KMD-Vignesh/AutoVD-Typescript-Playwright) |
| **TypeScript + Cypress**        | TypeScript · Cypress          | UI (E2E)  | [AutoVD-Typescript-Cypress](https://github.com/KMD-Vignesh/AutoVD-Typescript-Cypress)       |

## Quick Start

**Prerequisites:** JDK 17+, Maven 3.8+, and Chrome (or another supported browser). Drivers download themselves via Selenium Manager.

```bash
git clone https://github.com/KMD-Vignesh/AutoVD-Java-Selenium.git
cd AutoVD-Java-Selenium
mvn clean test
```

The default suite runs three scenarios: two SauceDemo UI tests and one ReqRes API call. Headless Chrome is the default, so no window opens.

Open the results:

```bash
open Report-ScreenShot/ExtentReport/ExtentReport.html
open Report-ScreenShot/ExcelReport/ExcelResult.xlsx
```

On Linux use `xdg-open`; on Windows open the files from Explorer.

## Configuration

Everything runtime lives in `src/test/resources/Properties/`.

`browser.properties`:

```properties
BrowserName=chromeheadless
waitTime=15
BrowserStack=off
```

| Key            | Default          | What it does                                                               |
| :------------- | :--------------- | :------------------------------------------------------------------------- |
| `BrowserName`  | `chromeheadless` | `chrome`, `firefox`, `edge`, `safari`, `chromeheadless`, `firefoxheadless` |
| `waitTime`     | `15`             | Implicit wait, helper retry budget, and `WaitUtil` timeout, in seconds     |
| `BrowserStack` | `off`            | `on` sends the same tests to BrowserStack                                  |

`locators.properties` maps readable names to Selenium locators:

```properties
Username_id = user-name
Cart_cssSelector = .shopping_cart_link
```

Keys must be `<name>_<strategy>` with exactly one underscore. Strategies: `id`, `name`, `className`, `tagName`, `xpath`, `cssSelector`, `linkText`, `partialLinkText`. Use them with `selenium.getElement(Locators.get("Username_id"))`.

For BrowserStack, fill in `browserStack.properties` and set `BrowserStack=on`. Credentials stay out of Git.

## Writing Tests

A web test — extend `TestBase`, call `Selenium(url)`, and use a page object:

```java
public class demo1 extends TestBase {

    @Author(Name = "Vignesh")
    @Test
    public void saucedemo1() {
        SeleniumUtil selenium = Selenium("https://www.saucedemo.com/");

        HomePage home = new LoginPage().Login();
        int count = home.AddProduct("Sauce Labs Onesie").Check_Cart_item_count();
        selenium.Log("Cart count: " + count);
    }
}
```

An API test — same lifecycle, different helper:

```java
@Test
public void getUser() {
    RestAPIUtil restAPI = RestAPI("https://reqres.in/");
    restAPI.Log(restAPI.getStatusCode("api/users/2"));
    restAPI.Log(restAPI.getBody("api/users/2"));
}
```

A page object — fields are injected, `selenium` and `driver` are already available:

```java
public class LoginPage extends PageBase {

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public HomePage Login() {
        selenium.type(Locators.get("Username_id"), "standard_user");
        selenium.type(password, "secret_sauce");
        selenium.click(loginButton);
        return new HomePage();
    }
}
```

## Framework Map

Read these in order. Everything else is a helper around them.

| Package              | Key classes                                                           | What it does                                                     |
| :------------------- | :-------------------------------------------------------------------- | :--------------------------------------------------------------- |
| `kmdv.Base`          | `TestBase`, `PageBase`                                                | Suite/thread lifecycle and the page-object base. **Start here.** |
| `kmdv.Capability`    | `ClassConfig`, `DriverConfig`, `PathConfig`                           | Suite setup, thread-local driver creation, folder paths          |
| `kmdv.Common`        | `SeleniumUtil`, `WaitUtil`, `RestAPIUtil`                             | Browser, wait, and API helpers your tests call                   |
| `kmdv.Data`          | `ExcelUtil`, `JsonUtil`, `PropertiesUtil`, `TextUtil`, `LocatorsUtil` | Test data and locator loading                                    |
| `kmdv.Report`        | `ExtentReportManger`, `ScreenShot`, `SendMail`                        | Extent reports, screenshots, optional email                      |
| `kmdv.config.TestNG` | `Author`, `TestID`, `RetryAnalyser`, `RetryTransform`                 | Test metadata and automatic retry                                |
| `pages.*`            | SauceLabs examples                                                    | Where your page objects go                                       |
| `testCase.*`         | `demo1`, `demo2`, `demo3`                                             | Where your tests go                                              |

The helper surface is large (185 methods in `SeleniumUtil`, 44 in `WaitUtil`), but a few carry most tests:

| Helper                                      | Use                                        |
| :------------------------------------------ | :----------------------------------------- |
| `Selenium(url)` / `RestAPI(baseURI)`        | Start a browser or API session             |
| `getElement(locator)`                       | Find one element with retry                |
| `click(element)` / `type(element, text)`    | Interact, with stale-element recovery      |
| `getText(element)` / `isDisplayed(element)` | Read state                                 |
| `waitUNtil(condition)`                      | Explicit wait for any `ExpectedConditions` |
| `Log(message)`                              | Write to the Extent report                 |
| `elementScreenShot(element)`                | Attach an element image to the report      |

For the complete inventory, read the class: [`SeleniumUtil.java`](src/main/java/kmdv/Common/SeleniumUtil.java), [`WaitUtil.java`](src/main/java/kmdv/Common/WaitUtil.java).

## How a Run Works

1. `@BeforeSuite` creates the folders, loads properties, starts ExtentReports, and opens the Excel workbook.
2. Your test calls `Selenium(url)` or `RestAPI(baseURI)`, which creates a thread-local driver and an Extent test.
3. Page objects wait for `document.readyState` and initialise `@FindBy` fields.
4. `@AfterMethod` writes the Excel row, captures failure/skip screenshots, quits the driver, and clears the thread.
5. `@AfterSuite` flushes the Extent report and closes the workbook.

## Project Layout

```text
AutoVD-Java-Selenium/
├── pom.xml                  # dependencies, Java 17, Surefire
├── SuitesXML/               # TestNG suite files
├── src/main/java/kmdv/      # framework: Base, Capability, Common, Data, Report
├── src/test/java/pages/     # page objects (example: SauceLabs)
├── src/test/java/testCase/  # demo tests
├── src/test/resources/      # properties, locators, Excel/JSON/text data
├── Report-ScreenShot/       # generated: Extent, Excel, screenshots
└── target/                  # generated: Maven + Surefire output
```

`Report-ScreenShot/` and `target/` are gitignored and recreated on each run.

## Reports

| Output             | Location                                                 |
| :----------------- | :------------------------------------------------------- |
| ExtentReports HTML | `Report-ScreenShot/ExtentReport/ExtentReport.html`       |
| Excel results      | `Report-ScreenShot/ExcelReport/ExcelResult.xlsx`         |
| Screenshots        | `Report-ScreenShot/ScreenShots/{Passed,Failed,Skipped}/` |
| Surefire HTML      | `target/surefire-reports/index.html`                     |

Reports are cleaned at suite start, so each run reflects only that run.

## Troubleshooting

| Symptom                                               | Fix                                                                                                  |
| :---------------------------------------------------- | :--------------------------------------------------------------------------------------------------- |
| `IllegalArgumentException: Update Proper BrowserName` | Use one of the six supported browser values.                                                         |
| Locator from `locators.properties` is ignored         | The key must have exactly one underscore and a valid strategy suffix.                                |
| `NullPointerException` in `JsonUtil.getPojo`          | Put the JSON under `src/test/resources/TestData/JSON/` and load it with `fileFromJsonTestData(...)`. |
| Empty or partial Extent report                        | The JVM exited before `@AfterSuite`; let the suite finish so the report can flush.                   |
| Safari session fails                                  | Run `safaridriver --enable` once on macOS.                                                           |
| BrowserStack session fails                            | Check credentials, platform values, and that `BrowserStack=on`.                                      |

## License

MIT. See [`LICENSE`](LICENSE).

---
