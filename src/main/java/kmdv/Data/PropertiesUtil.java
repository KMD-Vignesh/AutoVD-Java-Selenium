package kmdv.Data;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import kmdv.Common.BaseUtil;

public class PropertiesUtil extends BaseUtil {
	private Properties p;

	public PropertiesUtil(String PropertyPath) {
		p = new Properties();
		try {
			p.load(new FileReader(PropertyPath));
		} catch (Exception e) {
			if (PropertyPath.contains("browser.properties"))
			 { try {
				FileOutputStream outputProp = new FileOutputStream(PropertyPath);
				FileWriter write = new FileWriter(PropertyPath);
				write.write("BrowserName=chrome");
				write.write("\n");
				write.write("waitTime=15");
				write.write("\n");
				write.write("BrowserStack = off");
				write.close();
				outputProp.close();
				p.load(new FileReader(PropertyPath));

			} catch (Exception e2) {
				e2.printStackTrace();
			} }
			
			else if(PropertyPath.contains("browserStack.properties")) {
				{ try {
					FileOutputStream outputProp = new FileOutputStream(PropertyPath);
					FileWriter write = new FileWriter(PropertyPath);
					write.write("USERNAME = ");
					write.write("\n");
					write.write("ACCESS_KEY = ");
					write.write("\n");
					write.write("\n");
					write.write("os = Windows");
					write.write("\n");
					write.write("os_version = 10");
					write.write("\n");
					write.write("\n");
					write.write("browser = Chrome");
					write.write("\n");
					write.write("browser_version = latest");
					
					write.close();
					outputProp.close();
					p.load(new FileReader(PropertyPath));

				} catch (Exception e2) {
					e2.printStackTrace();
				}	}
				
			}

		}
	}

	public String getValue(String propertyName) {

		return p.getProperty(propertyName);

	}

	public Set<Object> getKeys() {
		return p.keySet();
	}
	
	public HashMap<String, String> getMAP() {
	    HashMap<String, String> keyVal = new HashMap<>();
		Set<Object> keys = getKeys();
		
		for ( Object ke : keys) {
			keyVal.put(ke.toString(), getValue(ke.toString()));
		}
		return keyVal;
	}
}
