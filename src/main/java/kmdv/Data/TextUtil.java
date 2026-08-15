package kmdv.Data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kmdv.Common.BaseUtil;

public class TextUtil extends BaseUtil {
	private final String filePath;

	public TextUtil(String filePath) {
		this.filePath = filePath;
	}

	public List<String> readLines() {
		List<String> lines = new ArrayList<String>();

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

	public void writeLine(String stringValue) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			writer.write(stringValue);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeLine(int intValue) {
		writeLine(String.valueOf(intValue));
	}

}
