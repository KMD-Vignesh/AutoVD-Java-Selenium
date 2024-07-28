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
	private BufferedReader reader;
	private BufferedWriter writer;

	public TextUtil(String filePath) {
		try {
			reader = new BufferedReader(new FileReader(filePath));
			writer = new BufferedWriter(new FileWriter(filePath));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<String> readLines() {
		List<String> lines = new ArrayList<String>();

		try {
			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

	public void writeLine(String stringValue) {
		try {
			writer.write(stringValue);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeLine(int intValue) {
		try {
			writer.write(intValue);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
