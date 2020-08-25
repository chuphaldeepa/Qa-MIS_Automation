package com.qa.MIS.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;
/**
 * 
 * @author ak.khattar
 *
 */
public class ConfigFileReader {

	public static final String propertyfilepath = "Config//Configuration.properties";
	public static final String elementPropertyfilepath = "Config/ElementLocator.Properties";
	public static Properties properties,propertiesElement;

	// Method to read the data from Property file
	public ConfigFileReader() {
		BufferedReader reader,readerElement;
		try {
			reader = new BufferedReader(new FileReader(propertyfilepath));
			readerElement = new BufferedReader(new FileReader(elementPropertyfilepath));
			properties = new Properties();
			propertiesElement=new Properties();
			try {
				properties.load(reader);
				propertiesElement.load(readerElement);
				reader.close();
				readerElement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// General method to get Property from Configuration.properties
	public String getConfigProperty(String property) {
		String driverPath = properties.getProperty(property);
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverpath not specified in the Configuration.properties file");
	}

	// General method to get Property from ElementLocator.properties
	public static   String getElementLocatorProperty(String property) {
		String driverPath = propertiesElement.getProperty(property);
		if (driverPath != null) {
			System.out.println(driverPath);
			return driverPath;
			
		}
		else
			{throw new RuntimeException("driverpath not specified in the ElementLocator.properties file");}
	}
}
