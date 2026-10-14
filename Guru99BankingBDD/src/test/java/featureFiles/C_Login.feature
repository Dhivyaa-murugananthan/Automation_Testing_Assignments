
Feature: Manager login

  Scenario: Login to Guru99 Banking with valid credentials
    Given I launch the Guru99 Banking application
    When I log in with valid manager credentials
    Then the manager dashboard should be displayed
