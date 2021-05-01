package com.testvagrant.filereader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PropertiesReader {
	static Properties properties;
	static InputStream inputStream;
	public String valuePair;
	

	public String getProperty(String fileName,String keyName) throws FileNotFoundException {
		properties = new Properties();
		inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
		if (inputStream != null) {
			try {
				properties.load(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
			valuePair = properties.getProperty(keyName);
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
		}
		return valuePair;
	
	}
	
  public String JsonReader(String fileName,String keyName) throws FileNotFoundException, ParseException {
	  JSONObject jsonObject = null;
	  String jsonTxt = null;
	  	inputStream = getClass().getClassLoader().getResourceAsStream(fileName+".json");
	  	JSONParser jsonParser = new JSONParser();
	  	if(inputStream!=null) {
			try {
				jsonTxt = IOUtils.toString(inputStream, "UTF-8");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  		jsonObject = (JSONObject) jsonParser.parse(jsonTxt);
	  	}
		return (String) jsonObject.get(keyName);
	}
}
