package com.testvagrant.steps;

import com.testvagrant.applicationUtils.HomeUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class HomeStepDef {
	private HomeUtils home = new HomeUtils();
	
	@Given("User launches weather website")
	public void launchWeather() {
		home.navigateToWeather();
	}
	
	@When("^User clicks on weather link$")
	public void clickOnWeather() {
		home.clickWeatherLink();
	}
	
}
