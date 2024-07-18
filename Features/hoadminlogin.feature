Feature: All admin login related scenarios

  Scenario: To test a required field validation check
    Given I am on login page
    When I have does't enter email id and password
    And  I click on continue button
    Then Required field validation properly shown