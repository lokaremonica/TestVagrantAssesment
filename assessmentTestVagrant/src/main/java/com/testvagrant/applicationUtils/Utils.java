package com.testvagrant.applicationUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testvagrant.coreUtils.BaseClass;
import com.testvagrant.coreUtils.TestParameter;
import com.testvagrant.filereader.PropertiesReader;

import gherkin.ast.Feature;
import io.cucumber.java.Scenario;


public class Utils extends BaseClass{
	
Properties properties;
public String valuePair;

InputStream inputStream;
PropertiesReader propertyReader = new PropertiesReader();
TestParameter testParameter = new TestParameter();

	public void clickElement(By element) {
		driver.findElement(element).click();
	}

	public void fluentWaitUntilVisible(By element) {
		WebDriverWait wait = new WebDriverWait(driver,TestParameter.TimeOut);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		}catch(TimeoutException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void fluentWaitUntilClickable(By element) {
		WebDriverWait wait = new WebDriverWait(driver,TestParameter.TimeOut);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(TimeoutException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getDriverPath() throws IOException{
		String driverPath = propertyReader.getProperty(TestParameter.GLOBALSETTING,TestParameter.CHROMEDRIVER);
		 if(driverPath!= null) return driverPath;
		 else throw new RuntimeException("Driver Path not specified in the GlobalSetting.properties file for the Key:driverPath"); 
		 }
	
	public String getAPIKey() throws IOException{
		String apiKey = propertyReader.getProperty(TestParameter.GLOBALSETTING,TestParameter.APIKEY);
		 if(apiKey!= null) return apiKey;
		 else throw new RuntimeException("API Key not specified in the GlobalSetting.properties file for the key:APIKey"); 
		 }
		
	public String getAPIUrl() throws IOException{
		String apiUrl = propertyReader.getProperty(TestParameter.GLOBALSETTING,TestParameter.APIURL);
		 if(apiUrl!= null) return apiUrl;
		 else throw new RuntimeException("Ui Url Key not specified in the GlobalSetting.properties file for the key:API"); 
		 }
	
	public void launchUiUrl() {
		try {
			driver.get(propertyReader.getProperty(TestParameter.GLOBALSETTING,TestParameter.UiUrl));
		}catch(Exception e) {
			System.out.println("Unable to get url"+e);
		}
	}
	
	public void launchApiUrl() throws IOException {
		driver.get(getAPIUrl());
	}
	
	public String getTestDataResourcePath() throws IOException{
		 String tesDataPath = propertyReader.getProperty(TestParameter.GLOBALSETTING,TestParameter.TestDataResourcePath);
		if(tesDataPath!= null) return tesDataPath;
		 else throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath"); 
		 }
	
	public String getScenario(Scenario scenario) {
		return scenario.getName();
	}
	
	public String getFeatureFileName(String feature) {
		System.out.println(feature);
		 String[] featureName = feature.split("/");
		 String[] test = featureName[4].split("\\.");
		return test[0];
	}
	
	public String getJsonData(String scenario,String key) {
		//try {
		String data = null;
			 try {
			data = propertyReader.JsonReader(scenario,key);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//} catch (FileNotFoundException | ParseException e) {
//			e.printStackTrace();
//		}
//		return feature;
			return data;
	}

	public void enterText(By element, String text) {
		driver.findElement(element).sendKeys(text);
	}
	
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(TestParameter.TimeOut, TimeUnit.SECONDS);
	}
}
