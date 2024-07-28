package kmdv.Report;

import java.nio.file.Paths;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import kmdv.Common.BaseUtil;

public class ExtentReportManger extends BaseUtil {
	private ExtentReports Ereport;
	private ExtentSparkReporter Espark;

	public void StartExtentReport() {
		Ereport = new ExtentReports();
		Espark = new ExtentSparkReporter(pathRoot.fileFromExtentReport("ExtentReport.html"));
		Espark.config().setDocumentTitle(Paths.get(System.getProperty("user.dir")).getFileName().toString());
		Espark.config().setReportName("KMDV Automation Framework");
		Espark.config().setTimelineEnabled(false);
		Espark.config().setEncoding("utf-8");
		Espark.config().setTimeStampFormat("dd MMM yyyy hh:mm:ss a");
		Ereport.attachReporter(Espark);
	}

	ThreadLocal<ExtentTest> testThread = new ThreadLocal<ExtentTest>();

	public ExtentTest getTestThread() {
		return testThread.get();
	}

	public void StartExtentTest(String[] infoNames) {
		String userName = System.getProperty("user.name");
		String osName = System.getProperty("os.name");
		if(infoNames.length==3) {
			testThread.set(Ereport.createTest(infoNames[0]).assignCategory(infoNames[1]).assignAuthor(infoNames[2])
					.assignDevice(userName+" # "+osName));
		}else {
			testThread.set(Ereport.createTest(infoNames[0]).assignCategory(infoNames[1])
					.assignDevice(userName+" # "+osName));
		}
		
	}
	
	public void StartExtentTest(String TestName) {
		testThread.set(Ereport.createTest(TestName));
	}

	public void removeThread() {
		testThread.remove();
	}

	public void EndExtentReport() {
		Ereport.flush();
	}

}
