@Cart
Feature: Add Cart SauceDemo

  @Regression @Positive
  Scenario: verify response when clicking the checkout button on the cart after adding a product
    Given On the login page sauceDemo
    When user input a registered username
    And user input a registered password
    And user click login button
    And user click Add to cart button on the product
    And user click Cart icon on the top right
    Then user redirect to Your Cart product added

