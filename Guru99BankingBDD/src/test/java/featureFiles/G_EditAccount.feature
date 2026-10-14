
Feature: Edit Account

  Scenario: Open an existing account for editing
    Given I launch the Guru99 Banking application
    When I log in with valid manager credentials
    And I navigate to the Edit Account page
    And I submit the Account ID stored in Excel
