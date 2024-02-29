#Created by: Louchin Var Cejar 2024

Feature: Add to cart Feature
  #commonly that can be used in each scenario
  Background:
    Given User is on landing page


  @SmokeTest @Test5
  Scenario Outline: Validate if user can add to cart
    Given User login to application using username <UserName>and password <Password>
    When Home page is displayed
    And Product items should be displayed
    And Click an item to add to cart <Position>
    Then Product items is added to cart

    Examples:
      | UserName                | Password     | Position |
      | standard_user           | secret_sauce | 1        |
      | problem_user            | secret_sauce | 2        |
      | performance_glitch_user | secret_sauce | 3        |
      | error_user              | secret_sauce | 4        |
      | visual_user             | secret_sauce | 5        |
