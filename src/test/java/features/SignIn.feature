Feature: User Sign In
  Verify the "Sign In" functionality with valid and invalid input scenarios.

  Scenario: Successfully sign in with valid credentials
    Given I navigate to the Sign In page
    When I enter registered Email 
    And I enter Password for sign in
    And I click the Sign In button
    Then I should be redirected to the dashboard

  Scenario: Attempt to sign in with an empty Email and password
    Given I navigate to the Sign In page
    When I leave both Email and Password fields empty
    And I click the Sign In button
    Then I should see an error message for both the fields


  Scenario: Attempt to sign in with an invalid email
    Given I navigate to the Sign In page
    When I enter invalid email for sign in
    And I click the Sign In button
    Then I should see an error message for the Email field

  Scenario: Attempt to sign in with invalid password
    Given I navigate to the Sign In page
    When I enter registered Email
    And I enter invalid Password
    And I click the Sign In button
    Then I should see an error message for invalid password

 

