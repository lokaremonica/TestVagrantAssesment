#Author: monilokare@gmail.com
#This feature helps us in getting the values from UI

@SmokeTest
Feature: Validate API Weather Reporting
Scenario: Fetch weather details from the api automation
    Given User sends request to the weather api
    Then User gets response from the request
    