package kmdv.Report;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.ExceptionInfo;
import com.aventstack.extentreports.model.service.ExceptionInfoService;

import kmdv.Common.BaseUtil;

public class ScreenShot extends BaseUtil {

	public void ExtentFailShot(WebDriver ScDriver, ITestResult result, ExtentTest Exetest) {
		String Time = new java.util.Date().getTime() + "";

		File screenShotLocation = new File(pathRoot.fileFromFailedShot(result.getName() + "-" + Time + ".png"));
		try {
			File screenShot = ((TakesScreenshot) ScDriver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenShot, screenShotLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Throwable throwable = result.getThrowable();
		String exceptionMessage = "<details><summary><span style=\"font-size:14px\" class=\"badge log fail-bg\">"+throwable.toString()+"</span></summary>" + Arrays.toString(throwable.getStackTrace()).replaceAll(",", "<br>")
				+ "</details> \n";
		Exetest.fail(exceptionMessage,MediaEntityBuilder.createScreenCaptureFromPath(screenShotLocation.getAbsolutePath()).build());

	}
	
	

	public void ExtentSkipShot(WebDriver ScDriver, ITestResult result, ExtentTest Exetest) {
		String Time = new java.util.Date().getTime() + "";

		File screenShotLocation = new File(pathRoot.fileFromSkippedShot(result.getName() + "-" + Time + ".png"));
		try {
			File screenShot = ((TakesScreenshot) ScDriver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenShot, screenShotLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Throwable throwable = result.getThrowable();
		String exceptionMessage = "<details><summary><span style=\"font-size:14px\" class=\"badge log fail-bg\">"+throwable.toString()+"</span></summary>" + Arrays.toString(throwable.getStackTrace()).replaceAll(",", "<br>")
				+ "</details> \n";
		Exetest.skip(exceptionMessage,MediaEntityBuilder.createScreenCaptureFromPath(screenShotLocation.getAbsolutePath()).build());

	}

	public void ExtentPassShot(WebDriver ScDriver, ExtentTest Exetest, String tstName) {
		String Time = new java.util.Date().getTime() + "";

		File screenShotLocation = new File(pathRoot.fileFromPassedShot(tstName + "-" + Time + ".png"));
		try {
			File screenShot = ((TakesScreenshot) ScDriver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenShot, screenShotLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Exetest.pass(MediaEntityBuilder.createScreenCaptureFromPath(screenShotLocation.getAbsolutePath()).build());

	}

	public void ExtentElementShot(WebElement ele, ExtentTest Exetest, String tstName) {
		String Time = new java.util.Date().getTime() + "";

		File screenShotLocation = new File(
				pathRoot.fileFromPassedShot(tstName + "-Element-" + ele.getText() + "-" + Time + ".png"));
		try {
			File screenShot = ((TakesScreenshot) ele).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenShot, screenShotLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Exetest.pass(MediaEntityBuilder.createScreenCaptureFromPath(screenShotLocation.getAbsolutePath()).build());

	}

	public void deleteReportScreenShot() {
		File mainFolder = new File(pathRoot.getReportScreenShotPath());
		File[] files = mainFolder.listFiles();
		if (files != null) {
			for (File f : files) {
				if (f.isDirectory()) {
					deleteFolder(f);
				} else {
					f.delete();
				}
			}
		}
	}

	public void deleteFolder(File folder) {
		File[] files = folder.listFiles();
		if (files != null) {
			for (File f : files) {
				if (f.isDirectory()) {
					deleteFolder(f);
				} else {
					f.delete();
				}
			}
		}
	}

	public void deleteTestOutput() {
		File mainFolder = new File(pathRoot.getTestOutputPath());
		File[] files = mainFolder.listFiles();
		if (files != null) {
			for (File f : files) {
				if (f.isDirectory()) {
					deleteFolder(f);
				} else {
					f.delete();
				}
			}
		}
	}

	public void cleanFolders() {
		deleteReportScreenShot();
		deleteTestOutput();
	}
	
	
	public void afterMethods(WebDriver ScDriver,ITestResult result, ExtentTest Exetest) {
		TakesScreenshot scrShot =((TakesScreenshot)ScDriver);
		String base64img = "data:image/png;base64,"+scrShot.getScreenshotAs(OutputType.BASE64);

		if(result.getStatus() == ITestResult.FAILURE) {
			Throwable throwable = result.getThrowable();
			String getErrorMessage = "<strong>"+throwable.toString()+"</strong>";
			String base64imgA = "<a href=\""+base64img+"\" data-featherlight=\"image\"><span class=\"badge log fail-bg\">Screenshot Click Here</span></a>";
			
	        ExceptionInfo exceptionInfo = ExceptionInfoService.createExceptionInfo(throwable);
	        String stackTrace = "<textarea readonly=\"\" class=\"code-block\">"+exceptionInfo.getStackTrace()+"</textarea>";
	        Exetest.fail(getErrorMessage+"<br>"+base64imgA+"<br>"+stackTrace);			


		}
		
		if(result.getStatus() == ITestResult.SUCCESS) {
			String base64imgA = "<a href=\""+base64img+"\" data-featherlight=\"image\"><span class=\"badge log pass-bg\">Screenshot Click Here</span></a>";
			Exetest.pass("<strong>Testcase Successfully Completed</strong><br>"+base64imgA);			

		}
		
		ScDriver.quit();
	}
}
