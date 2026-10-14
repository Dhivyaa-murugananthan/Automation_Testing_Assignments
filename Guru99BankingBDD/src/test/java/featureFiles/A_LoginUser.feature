
Feature: Basic Cucumber framework validation

  Scenario: Verify that the framework executes a simple scenario
    Given the framework is initialized
    When I execute a sample action
    Then the scenario should pass
