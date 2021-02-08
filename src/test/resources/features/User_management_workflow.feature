Feature: Validate user management functionality

  @Regression @Defect
  Scenario: Validate if user can be created
    Given user with username: 'Test User' does not exist
    When user with username: 'Test User' is created
    Then user with username 'Test User' exists
