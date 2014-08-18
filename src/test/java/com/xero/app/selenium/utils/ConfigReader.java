/**
 * 
 */
package com.xero.app.selenium.utils;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Reshma
 *
 */
public class ConfigReader {

	private static ConfigReader _instance = null;

	public static ConfigReader getInstance() {
		if (_instance == null) {
			synchronized (ConfigReader.class) {
				if (_instance == null) {
					_instance = new ConfigReader();
				}
			}
		}
		return _instance;
	}

	private Properties properties;
	
	private ConfigReader(){
		properties = new Properties();
		try {
			properties.load(ClassLoader.getSystemResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String get(String key){
		return get(key,null);
	}
	
	public String get(String key, String defaultValue){
		return properties.getProperty(key,defaultValue);
	}
}
