package com.testvagrant.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

//import cucumber.api.CucumberOptions;
//import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(

		plugin = {"pretty", "html:target/cucumber"},
		features = {"src/main/resources/features"},
		glue={"com.testvagrant.steps"},
		monochrome = true,
		tags = {"@WeatherUI"},
		dryRun = false,
		strict = true
		)
public class runner{

}
