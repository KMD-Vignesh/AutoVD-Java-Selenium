package kmdv.Common;

import java.time.LocalDate;
import java.util.Random;

public class GeneralUtil {

	public static String IntToString(int value) {
		return Integer.toString(value);
	}

	public static int StringToInt(String value) {
		return Integer.parseInt(value);
	}

	public static boolean StringEquals(String value1, String value2) {
		return value1.equalsIgnoreCase(value2);
	}

	public static LocalDate Today() {
		return LocalDate.now();
	}

	public static LocalDate Yesterday() {
		return LocalDate.now().minusDays(1);
	}

	public static LocalDate Tomorrow() {
		return LocalDate.now().plusDays(1);
	}

	public static LocalDate localDate(int Year, int Month, int day) {
		return LocalDate.of(Year, Month, day);
	}

	public static String[] toCharArray(String StringArray) {
		char[] charArray = StringArray.toCharArray();
		String[] stringArray = new String[charArray.length];
		for (int i = 0; i < charArray.length; i++) {
			stringArray[i] = String.valueOf(charArray[i]);
		}
		return stringArray;
	}

	public static int[] toCharArray(int IntArray) {
		String StringInt = Integer.toString(IntArray);
		char[] charArray = StringInt.toCharArray();
		int[] intArray = new int[charArray.length];
		for (int i = 0; i < charArray.length; i++) {
			intArray[i] = Integer.parseInt(String.valueOf(charArray[i]));
		}
		return intArray;
	}

	public static int getRandom(int min, int max) {
		return new Random().nextInt(max - min + 1) + min;
	}

	public static int getRandom(int[] array) {
		return array[new Random().nextInt(array.length)];
	}

	public static String getRandom(String[] array) {
		return array[new Random().nextInt(array.length)];
	}
}