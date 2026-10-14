
Feature: Customer registration

  Scenario: Register a new customer successfully
    Given I launch the Guru99 Banking application
    When I log in with valid manager credentials
    Then the manager dashboard should be displayed
    When I navigate to the New Customer page
    And I enter the following customer details
      | field       | value                                  |
      | customerName| Dhivyaa Muruganannthaan                |
      | gender      | female                                 |
      | dateOfBirth | 12-10-1999                             |
      | address     | 12D Sanjeevini Sanctuary Whitefield    |
      | city        | Bangalore                              |
      | state       | Karnataka                              |
      | pin         | 560066                                 |
      | mobile      | 7418200537                             |
      | email       | dhivyannnandd@gmail.com                 |
      | password    | Test@12345                             |
    And I submit the new customer form
    Then the customer should be registered successfully
    And the generated customer ID should be displayed
