Feature: Assert that User management api is working
  @Tag
  Scenario: Find user by username
    Given REST request is sent to find user: 'Delphine'