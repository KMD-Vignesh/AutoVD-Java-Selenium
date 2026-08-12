package kmdv.Common;

import static io.restassured.RestAssured.given;
import java.time.LocalDate;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentTest;

import io.restassured.RestAssured;

public class RestAPIUtil {
	private ExtentTest Etest;
	private String testNAme;

	public RestAPIUtil(String baseURI, ExtentTest ext) {
		RestAssured.baseURI = baseURI;
		this.Etest = ext;
		this.testNAme = Reporter.getCurrentTestResult().getName();

	}

	public String getMethodName() {
		return testNAme;
	}

	public void Log(Object stringMessage) {
		System.out.println(stringMessage);
		Etest.info(stringMessage.toString());
		Reporter.log(stringMessage.toString());
	}

	public void logC(Object stringMessage) {
		System.out.println(stringMessage);
	}

	public void logE(Object message) {
		Etest.info(message.toString());
	}


	public String IntToString(int value) {
		return GeneralUtil.IntToString(value);
	}

	public int StringToInt(String value) {
		return GeneralUtil.StringToInt(value);
	}

	public boolean StringEquals(String value1, String value2) {
		return GeneralUtil.StringEquals(value1, value2);
	}

	public LocalDate Today() {
		return GeneralUtil.Today();
	}

	public LocalDate Yesterday() {
		return GeneralUtil.Yesterday();
	}

	public LocalDate Tomorrow() {
		return GeneralUtil.Tomorrow();
	}

	public LocalDate localDate(int Year, int Month, int day) {
		return GeneralUtil.localDate(Year, Month, day);
	}

	public String[] toCharArray(String StringArray) {
		return GeneralUtil.toCharArray(StringArray);
	}

	public int[] toCharArray(int IntArray) {
		return GeneralUtil.toCharArray(IntArray);
	}

	public int getRandom(int min, int max) {
		return GeneralUtil.getRandom(min, max);
	}

	public int getStatusCode(String getURI) {
		return given().when().get(getURI).statusCode();
	}

	public int getStatusCode() {
		return given().when().get().statusCode();
	}

	public String getBody(String getURI) {
		return given().when().get(getURI).body().asPrettyString();
	}

	public String getBody() {
		return given().when().get().body().asPrettyString();
	}
	
}
