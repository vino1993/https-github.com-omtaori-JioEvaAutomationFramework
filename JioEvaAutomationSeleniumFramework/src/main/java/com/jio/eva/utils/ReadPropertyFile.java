package com.jio.eva.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.jio.eva.constants.FrameworkConstants;

public final class ReadPropertyFile {

	private ReadPropertyFile() {

	}

	private static Properties property = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();
	
	static {
		try {
			FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath());
			property.load(file);

			
			for(Map.Entry<Object, Object> entry: property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}
			
			// property.entrySet().forEach(entry -> CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	public static String get(String key) {
		try {
			if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key))) {
				System.out.println("Property name " + key + " is not found in config.properties file");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CONFIGMAP.get(key);
	}
	
	/*
	public static String getValue(String key) {
		String value ="";
		try {
			value = property.getProperty(key);

			if(Objects.isNull(value)) {
				System.out.println("Property name " + key + " is not found in config.properties file");
			}
			else {
				System.out.println("Value of '"+ key +"' key is '"+value+"'");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	*/
}
