Feature: Search by keyword

  Scenario: Searching for a term
    Given Fernanda is on the ChoucairTesting Empleos Page
    When she searches for "Pruebas"
    Then all the result titles should contain the word "Pruebas"

