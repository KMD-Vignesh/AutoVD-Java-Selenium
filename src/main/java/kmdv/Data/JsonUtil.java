package kmdv.Data;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;

import org.json.simple.JSONObject;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kmdv.Common.BaseUtil;

public class JsonUtil extends BaseUtil {

	private Object obj;
	private String resourceLocation;

	public JsonUtil(String JsonLocation) {
		JSONParser parser = new JSONParser();
		try {
			obj = parser.parse(new FileReader(JsonLocation));
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		resourceLocation = (JsonLocation.split("resources"))[1].replace("\\", "/");
	}
	
	public synchronized <T> T getPojo(Class<T> clazz) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String fileData = null;
		try {

			fileData = IOUtils.toString(JsonUtil.class.getResourceAsStream(resourceLocation),
					StandardCharsets.UTF_8);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		if (fileData == null) {
			throw new NullPointerException("data not available. check file: " + resourceLocation
					+ " in resources for availability and valid data");
		}

		return gson.fromJson(fileData, clazz);
	}

	public JSONObject getObject() {
		return (JSONObject) obj;
	}

	public String getValue(String JsonKey) {
		return getObject().get(JsonKey).toString();
	}

	public Object[] getKeys() {
		return getObject().keySet().toArray();

	}
	
	public Map<String, String> getAllValues() {
		Map<String, String> map=new TreeMap<String, String>();
		Object[] keys = getKeys();
		for(Object obj :keys ) {
			map.put(obj.toString(), getValue(obj.toString()));
		}
		return map;
	}

	public JSONArray getArray(String ArrayKey) {
		return (JSONArray) getObject().get(ArrayKey);
	}

	public JSONObject getObjFromArray(JSONArray jsonArray, int index) {
		return (JSONObject) jsonArray.get(index);
	}

}
