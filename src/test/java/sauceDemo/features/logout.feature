@Logout
Feature: Logout Page SauceDemo

  @Regression @Positive
  Scenario: Success Logout
    Given On the login page sauceDemo
    When user input a registered username
    And user input a registered password
    And user click login button
    And click sidebar menu on the top left
    And click Menu Logout
    Then user back to login page sauceDemo

  @TDD
  Scenario Outline: Verify User success Logout from sauceDemo
    Given On the login page sauceDemo
    When I input <username> as username
    And I input <password> as password
    And I click login button
    And click sidebar menu on the top left
    And click Menu Logout
    Then I verify <status> logout result redirect to login page sauceDemo

    Examples:
      | username                | password              | status  |
      | standard_user           | secret_sauce          | success |