package kmdv.Data;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;

import kmdv.Common.BaseUtil;

public class LocatorsUtil extends BaseUtil {
	private Properties loc;


	public LocatorsUtil(String LocatorsPath) {
		loc = new Properties();
		try {
			loc.load(new FileReader(LocatorsPath));
		} catch (Exception e) {
			if (LocatorsPath.contains("locators.properties"))
			 { try {
				FileOutputStream outputProp = new FileOutputStream(LocatorsPath);
				FileWriter write = new FileWriter(LocatorsPath);
				write.write("###Locators Should be end with _ ~ xpath, id, name, className, tagName, cssSelector, linkText, partialLinkText  ###");
				write.close();
				outputProp.close();
				loc.load(new FileReader(LocatorsPath));

			} catch (Exception e2) {
				e2.printStackTrace();
			} }

		}
		
		for (Map.Entry<Object, Object> entry : loc.entrySet()) {
			String[] locators = entry.getKey().toString().split("_");
			
			switch (locators[1].toLowerCase()) {
				
				case "id":Locators.put(entry.getKey().toString(), By.id(entry.getValue().toString()));break;
				case "className":Locators.put(entry.getKey().toString(), By.className(entry.getValue().toString()));break;
				case "tagName":Locators.put(entry.getKey().toString(), By.tagName(entry.getValue().toString()));break;
				case "xpath": Locators.put(entry.getKey().toString(), By.xpath(entry.getValue().toString()));break;
				case "cssSelector":Locators.put(entry.getKey().toString(), By.cssSelector(entry.getValue().toString()));break;
				case "linkText":Locators.put(entry.getKey().toString(), By.linkText(entry.getValue().toString()));break;
				case "name":Locators.put(entry.getKey().toString(), By.name(entry.getValue().toString()));break;
				case "partialLinkText":Locators.put(entry.getKey().toString(), By.partialLinkText(entry.getValue().toString()));break;
				default:Locators.put(entry.getKey().toString(), By.xpath(entry.getValue().toString()));break;
			}
			
		}
		
	}
	
	
	

}
