package com.testvagrant.steps;

import com.testvagrant.applicationUtils.WeatherUtils;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.When;


public class WeatherStepDef {
	
	private WeatherUtils weather = new WeatherUtils();
//	private Scenario scenario;
	
//	public void before(Scenario scenario) {
//		this.scenario = scenario;
//	}
//	
	@When("^User pins desired city$")
	public void pinDesiredCity() {
		weather.pinCity();
	}
}
