Feature: Search by Location

  Scenario: Searching for a location
    Given Fernanda is on the ChoucairTesting Empleos Page
    When she searches for location "Per"
    Then all the result titles location should contain the word "Per"

