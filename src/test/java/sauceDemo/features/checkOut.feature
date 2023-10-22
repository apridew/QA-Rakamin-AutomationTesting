@Checkout
Feature: Checkout Page SauceDemo

  @TDD @Positive
  Scenario Outline: Verify User is success to Checkout products
    Given On the login page sauceDemo
    When user input a registered username
    And user input a registered password
    And user click login button
    And user click Add to cart button on the product
    And user click Cart icon on the top right
    And I click button Checkout to redirect fill the shipping information data
    And I input <firstname> as first name
    And I input <lastname> as last name
    And I input <zipcode> as zip code
    And click Continue button
    And I click Finish button
    Then I verify <status> redirect to complete Checkout page

    Examples:
      | username      | password     | firstname | lastname   | zipcode | status  |
      | standard_user | secret_sauce | Dewi      | Apriyanti  | 112233  | success |

  @TDD @Negative
  Scenario Outline: Verify User is failed to Checkout products without fill shipping data
    Given On the login page sauceDemo
    When user input a registered username
    And user input a registered password
    And user click login button
    And user click Add to cart button on the product
    And user click Cart icon on the top right
    And I click button Checkout to redirect fill the shipping information data
    And I click Continue button without fill the form
    Then I verify failed to checkout product with warning message appear

    Examples:
      | username      | password      |
      | standard_user | secret_sauce  |
