
Feature: New Account

  Scenario: Create a savings account for an existing customer
    Given I launch the Guru99 Banking application
    When I log in with valid manager credentials
    And I navigate to the New Account page
    And I create a savings account with initial deposit "5000"
    Then the account should be created and saved in Excel
