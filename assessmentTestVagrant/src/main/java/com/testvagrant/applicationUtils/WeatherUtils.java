package com.testvagrant.applicationUtils;

import com.testvagrant.coreUtils.BaseClass;
import com.testvagrant.coreUtils.TestParameter;
import com.testvagrant.page.WeatherPage;

public class WeatherUtils extends BaseClass{

	private Utils util = new Utils();
	public WeatherPage weatherPage = new WeatherPage();
	private static final String city = "City";
	
	public void pinCity() {
//		util.fluentWaitUntilVisible(weatherPage.searchBox);
		String featureName = util.getFeatureFileName(TestParameter.getFeature());
		System.out.println("feature"+featureName);
		String CC = util.getJsonData(featureName,city);
		System.out.println("city"+CC);
		util.enterText(WeatherPage.searchBox,CC);
	}	
}
