package kmdv.Capability;

import java.io.File;

public class PathConfig {
	private File projectPathRoot = new File(System.getProperty("user.dir"));
	private File resourcesMainRoot = new File(projectPathRoot, "src/main/resources");
	private File imagesRoot = new File(resourcesMainRoot, "Images");

	private File testoutputRoot = new File(projectPathRoot, "test-output");
	private File suitesRoot = new File(projectPathRoot, "SuitesXML");

	private File resourcesRoot = new File(projectPathRoot, "src/test/resources");
	private File propertiesRoot = new File(resourcesRoot, "Properties");
	private File testdataRoot = new File(resourcesRoot, "TestData");
	private File excelDataRoot = new File(testdataRoot, "Excel");
	private File jsonDataRoot = new File(testdataRoot, "JSON");
	private File textDataRoot = new File(testdataRoot, "Text");
	private File otherDataRoot = new File(testdataRoot, "Others");

	private File rsRoot = new File(projectPathRoot, "Report-ScreenShot");
	private File excelReportRoot = new File(rsRoot, "ExcelReport");
	private File extentReportRoot = new File(rsRoot, "ExtentReport");
	private File screenShotsRoot = new File(rsRoot, "ScreenShots");
	private File passedShotsRoot = new File(screenShotsRoot, "Passed");
	private File failedShotsRoot = new File(screenShotsRoot, "Failed");
	private File skippedShotsRoot = new File(screenShotsRoot, "Skipped");

	// Project Root
	public String getProjectPath() {
		return projectPathRoot.getAbsolutePath();
	}

	public String fileFromProject(String fileName) {
		File file = new File(projectPathRoot, fileName);
		return file.getAbsolutePath();
	}

	// Test Output Root
	public String getTestOutputPath() {
		return testoutputRoot.getAbsolutePath();
	}

	public String fileFromTestOutput(String fileName) {
		File file = new File(testoutputRoot, fileName);
		return file.getAbsolutePath();
	}

	// Test Suite XML Root
	public String getSuitesXMLPath() {
		return suitesRoot.getAbsolutePath();
	}

	public String fileFromSuitesXML(String fileName) {
		File file = new File(suitesRoot, fileName);
		return file.getAbsolutePath();
	}

	// Test Resources Root
	public String getResourcesPath() {
		return resourcesRoot.getAbsolutePath();
	}

	public String fileFromResources(String fileName) {
		File file = new File(resourcesRoot, fileName);
		return file.getAbsolutePath();
	}

	// Images Root
	public String getImagesPath() {
		return imagesRoot.getAbsolutePath();
	}

	public String fileFromImages(String fileName) {
		File file = new File(imagesRoot, fileName);
		return file.getAbsolutePath();
	}

	// Properties Root
	public String getPropertiesPath() {
		return propertiesRoot.getAbsolutePath();
	}

	public String fileFromProperties(String fileName) {
		File file = new File(propertiesRoot, fileName);
		return file.getAbsolutePath();
	}

	// Test Data Root
	public String getTestDataPath() {
		return testdataRoot.getAbsolutePath();
	}

	public String fileFromTestData(String fileName) {
		File file = new File(testdataRoot, fileName);
		return file.getAbsolutePath();
	}

	public String getExcelTestDataPath() {
		return excelDataRoot.getAbsolutePath();
	}

	public String fileFromExcelTestData(String fileName) {
		File file = new File(excelDataRoot, fileName);
		return file.getAbsolutePath();
	}

	public String getJsonTestDataPath() {
		return jsonDataRoot.getAbsolutePath();
	}

	public String fileFromJsonTestData(String fileName) {
		File file = new File(jsonDataRoot, fileName);
		return file.getAbsolutePath();
	}

	public String getTextTestDataPath() {
		return textDataRoot.getAbsolutePath();
	}

	public String fileFromTextTestData(String fileName) {
		File file = new File(textDataRoot, fileName);
		return file.getAbsolutePath();
	}

	public String getOtherTestDataPath() {
		return otherDataRoot.getAbsolutePath();
	}

	public String fileFromOtherTestData(String fileName) {
		File file = new File(otherDataRoot, fileName);
		return file.getAbsolutePath();
	}

	// Report - ScreenShot Root
	public String getReportScreenShotPath() {
		return rsRoot.getAbsolutePath();
	}

	public String fileFromReportScreenShot(String fileName) {
		File file = new File(rsRoot, fileName);
		return file.getAbsolutePath();
	}

	// Extent Report Root
	public String getExtentReportPath() {
		return extentReportRoot.getAbsolutePath();
	}

	public String fileFromExtentReport(String fileName) {
		File file = new File(extentReportRoot, fileName);
		return file.getAbsolutePath();
	}

	// Extent Report Root
	public String getExcelReportPath() {
		return excelReportRoot.getAbsolutePath();
	}

	public String fileFromExcelReport(String fileName) {
		File file = new File(excelReportRoot, fileName);
		return file.getAbsolutePath();
	}

	// Screen Shots Root
	public String getScreenShotPath() {
		return screenShotsRoot.getAbsolutePath();
	}

	public String fileFromScreenShot(String fileName) {
		File file = new File(screenShotsRoot, fileName);
		return file.getAbsolutePath();
	}

	public String getPassedShotPath() {
		return passedShotsRoot.getAbsolutePath();
	}

	public String fileFromPassedShot(String fileName) {
		File file = new File(passedShotsRoot, fileName);
		return file.getAbsolutePath();
	}

	public String getFailedShotPath() {
		return failedShotsRoot.getAbsolutePath();
	}

	public String fileFromFailedShot(String fileName) {
		File file = new File(failedShotsRoot, fileName);
		return file.getAbsolutePath();
	}

	public String getSkippedShotPath() {
		return skippedShotsRoot.getAbsolutePath();
	}

	public String fileFromSkippedShot(String fileName) {
		File file = new File(skippedShotsRoot, fileName);
		return file.getAbsolutePath();
	}

}
