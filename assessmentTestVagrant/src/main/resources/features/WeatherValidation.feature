#Author: monilokare@gmail.com
#This feature helps us in getting the values from UI

@WeatherUI
Feature: Validate Weather Reporting
  Scenario: Fetch weather details from the Ui automation
    Given User launches weather website
    When User clicks on weather link
    And User pins desired city
    Then User validates the city on the map
    And User validates the weather details
    And User sends request to the weather api
    Then User gets response from the request
    And User validates weather details from ui and api