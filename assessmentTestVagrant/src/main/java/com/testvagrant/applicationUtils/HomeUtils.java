package com.testvagrant.applicationUtils;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testvagrant.coreUtils.BaseClass;
import com.testvagrant.page.HomePage;

public class HomeUtils extends BaseClass{
	 
	Utils util = new Utils();
	public void navigateToWeather() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(HomePage.ALERT));
		util.clickElement(HomePage.ALERT_NO_THANKS);
		util.fluentWaitUntilClickable(HomePage.NAVIGATE_HEADER);
		util.clickElement(HomePage.NAVIGATE_HEADER);
	}
	
	public void clickWeatherLink() {
		util.fluentWaitUntilClickable(HomePage.LINK_WEATHER);
		util.clickElement(HomePage.LINK_WEATHER);
	}

}
