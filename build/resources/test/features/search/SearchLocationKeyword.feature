Feature: Search by Location and Keyword

  Scenario: Searching for a location and key word
    Given Fernanda is on the ChoucairTesting Empleos Page
    When she searches for keyword "Analista" and location "Bogot"
    Then all the result titles location should contain the word "Bogot"
    Then all the result titles should contain the word "Analista"