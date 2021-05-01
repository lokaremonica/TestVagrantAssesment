package com.testvagrant.coreUtils;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.testvagrant.filereader.PropertiesReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;



public class BaseClass {
	TestParameter testParameter = new TestParameter();
	PropertiesReader propertyReader = new PropertiesReader();
	public static WebDriver driver;
	public static Scenario scenario;
	public static final String propFileName = "GlobalSetting.properties";

		@Before(order=0)
	    public void beforeScenario(Scenario scenario) throws FileNotFoundException{
			System.out.println("********Starting Execution for feature **********"+scenario.getId());
			System.out.println("********Starting Execution for scenario**********"+scenario.getName());
			String driverPath = propertyReader.getProperty(TestParameter.GLOBALSETTING,TestParameter.CHROMEDRIVER);
			System.setProperty("webdriver.chrome.driver", driverPath);
			ChromeOptions chromeOptions = new ChromeOptions();
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
			chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
			chromeOptions.setExperimentalOption("useAutomationExtension", false);
			chromeOptions.addArguments("--disable-extensions");
			chromeOptions.addArguments("--disable-notifications");
			chromeOptions.addArguments("--allow-insecure-localhost");
			chromeOptions.addArguments("--start-maximized");
			desiredCapabilities.setCapability("acceptInsecureCerts", false);
			desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(TestParameter.TimeOut, TimeUnit.SECONDS);
			driver.get(propertyReader.getProperty(TestParameter.GLOBALSETTING,TestParameter.UiUrl));
			TestParameter.setFeature(scenario.getId());
			TestParameter.setScenario(scenario.getName());
		} 
	 
	 @After(order=0)
	    public void afterScenario(){
	        System.out.println("*********Ending Execution*********");
	        driver.quit();
	    }

}
