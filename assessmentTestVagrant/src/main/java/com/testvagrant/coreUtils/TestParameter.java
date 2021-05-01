package com.testvagrant.coreUtils;

public class TestParameter{
	
public static final String GLOBALSETTING = "GlobalSetting.properties";
public static final String CHROMEDRIVER = "ChromeDriverPath";
public static final String APIKEY = "APIKey";
public static final String APIURL = "APIURL";
public static final String TestDataResourcePath = "testDataResourcePath";
public static final String UiUrl = "Url";
public static final int TimeOut = 10;
public static String fetaure;
public static String scenario;

public static void setFeature(String id) {
	fetaure = id;
}

public static void setScenario(String name) {
	scenario = name;
}

public static String getFeature() {
	return fetaure;
}


public static String getScenario() {
	return scenario;
}
}
