Feature: Validate comments section functionality
  @Tag
  Scenario: Validate all emails in comments to be of correct format
    Given actor user with username 'Delphine' exists
    When actor user has existing posts
    Then all actor user posts have email of right format