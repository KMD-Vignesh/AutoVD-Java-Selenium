package kmdv.config.TestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import kmdv.Common.BaseUtil;

public class Listener extends BaseUtil implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {

	}

	@Override
	public void onTestSuccess(ITestResult result) {
	}

	@Override
	public void onTestFailure(ITestResult result) {
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}

}
