package com.testvagrant.coreUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class GlobalHooks extends BaseClass{
	private Properties properties;
	private final String propertyFilePath= "src//main//resources//GlobalSetting.properties";
	 
	public void ConfigFileReader() throws IOException{
		 BufferedReader reader;
		 try {
		 reader = new BufferedReader(new FileReader(propertyFilePath));
		 properties = new Properties();
		 properties.load(reader);
		 reader.close();
		 } catch (FileNotFoundException e) {
		 e.printStackTrace();
		 throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		 }
		}
	
	@Before
    public void beforeScenario(){
		System.out.println("********Starting Execution**********");
		driver = new ChromeDriver();
		String driverPath = properties.getProperty("ChromeDriverPath");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	} 
 
 @After
    public void afterScenario(){
        System.out.println("*********Ending Execution*********");
        driver.quit();
    }

}
