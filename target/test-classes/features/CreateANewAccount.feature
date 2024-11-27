Feature: Create a New Account
  Verify the "Create Account" functionality with different input scenarios.

  Scenario: Successfully create a new account with valid inputs
    Given I navigate to the Signup page
    When I enter First Name for account creation
    And I enter Last Name for account creation
    And I enter Email for account creation
    And I enter Password for account creation
    And I enter Confirm Password for account creation
    And I click Create Account button
    Then I should see a confirmation message "Thank you for registering with Main Website Store."

  
  Scenario: Password and Confirm Password do not match
    Given I navigate to the Signup page
    When I enter Password
    And I enter Confirm Password
    And I click Create Account button
    Then I should see an error message for password mismatch in the account creation

  Scenario: Invalid email format
    Given I navigate to the Signup page
    When I enter invalid email
    And I click Create Account button
    Then I should see an error message for invalid email format in the account creation

  Scenario: Attempt to sign up with an already registered email
    Given I navigate to the Signup page
    And I enter already registred Email
    And I click Create Account button
    Then I should see an error message for already registered email in the account creation
