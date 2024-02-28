#Created by: Louchin Var Cejar 2024

Feature: Login to sauce.com website
  #commonly that can be used in each scenario
  Background:
    Given User is on landing page

  @SauceDemoSite
  Scenario Outline: Validate Users in Sauce Demo Site using valid accounts
    Given Username, password and login button fields are displayed
    When User login to application using username <UserName> and password <Password>
    Then Home page is displayed

    #scenario outline will re run again based on how many Examples are displayed
    Examples:
    | UserName                | Password     |
    | standard_user           | secret_sauce |
    | problem_user            | secret_sauce |
    | performance_glitch_user | secret_sauce |
    | error_user              | secret_sauce |
    | visual_user             | secret_sauce |

  @SauceDemoSite @SmokeTest @Test2
  Scenario Outline: Validate Users in Sauce Demo Site using invalid accounts
    Given Username, password and login button fields are displayed
    When User login to application using username <UserName> and password <Password>
    Then Login error message is displayed

    #scenario outline will re run again based on how many Examples are displayed
    Examples:
      | UserName                | Password     |
      | standard_user_incorrect | secret_sauce |
      | locked_out_user         | secret_sauce |
      | standard_user           | secret_sauce |

  @SmokeTest @SauceDemoSite
  Scenario Outline: Validate left navigation pane in Sauce Demo Site
    Given User login to application using username <UserName> and password <Password>
    When User clicks the left navigation pane
    Then Left navigation pane should display
    And Following Items should be displayed
    |All Items|
    |About    |
    |Logout   |
    |Reset App State|

    Examples:
      | UserName                | Password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |


  @SmokeTest @SauceDemoSite @Test1
    Scenario Outline: Validate if there are displayed products
    Given User login to application using username <UserName> and password <Password>
    When Home page is displayed
    Then Product items should be displayed

    Examples:
      | UserName                | Password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |
