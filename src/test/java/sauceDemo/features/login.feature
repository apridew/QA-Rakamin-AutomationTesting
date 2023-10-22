@Login
Feature: Login Page SauceDemo

  @Regression @Positive
  Scenario: Success Login
    Given On the login page sauceDemo
    When user input a registered username
    And user input a registered password
    And user click login button
    Then user is on the dashboard product page

  @Regression @Negative
  Scenario: Failed Login
    Given On the login page sauceDemo
    When user input a registered username
    And user input unregistered password
    And user click login button
    Then user get an error message

  @TDD
  Scenario Outline: User Login to sauceDemo
    Given On the login page sauceDemo
    When I input <username> as username
    And I input <password> as password
    And I click login button
    Then I verify <status> login result

    Examples:
      | username                | password              | status  |
      | standard_user           | secret_sauce          | success |
      | standard_user           | unregistered_password | failed  |
      | performance_glitch_user | secret_sauce          | success |