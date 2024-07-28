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
		Etest.pass(stringMessage.toString());
		Reporter.log(stringMessage.toString());
	}

	public void logC(Object stringMessage) {
		System.out.println(stringMessage);
	}

	public void logE(Object message) {
		Etest.pass(message.toString());
	}


	public String IntToString(int value) {
		return Integer.toString(value);
	}

	public int StringToInt(String value) {
		return Integer.parseInt(value);
	}

	public boolean StringEquals(String value1, String value2) {
		return value1.equalsIgnoreCase(value2);
	}

	public LocalDate Today() {
		return LocalDate.now();
	}

	public LocalDate Yesterday() {
		return LocalDate.now().minusDays(1);
	}

	public LocalDate Tomorrow() {
		return LocalDate.now().plusDays(2);
	}

	public LocalDate localDate(int Year, int Month, int day) {
		return LocalDate.of(Year, Month, day);
	}

	public String[] toCharArray(String StringArray) {
		char[] charArray = StringArray.toCharArray();
		String[] stringArray = new String[charArray.length];
		for (int i = 0; i < charArray.length; i++) {
			stringArray[i] = String.valueOf(charArray[i]);
		}
		return stringArray;
	}

	public int[] toCharArray(int IntArray) {
		String StringInt = Integer.toString(IntArray);
		char[] charArray = StringInt.toCharArray();
		int[] intArray = new int[charArray.length];
		for (int i = 0; i < charArray.length; i++) {
			intArray[i] = Integer.parseInt(String.valueOf(charArray[i]));
		}
		return intArray;
	}

	public int getRandom(int min, int max) {
		return (int) (Math.random() * (max - min + 1) + min);
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
