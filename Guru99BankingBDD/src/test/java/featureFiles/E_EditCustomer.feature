
Feature: Edit Customer

  Scenario: Update an existing customer's address
    Given I launch the Guru99 Banking application
    When I log in with valid manager credentials
    And I navigate to the Edit Customer page
    And I update the customer address to "Updated Address, Bangalore"
    Then the customer address update should be successful
