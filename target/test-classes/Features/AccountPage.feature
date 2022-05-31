Feature: Account Page Feature
  Background:
    Given user has already logged in to application
    |username|password|
    |dec2020secondbatch@gmail.com|Selenium@12345|

    Scenario: Account Page Title
      Given user is on accounts page
      When user gets the title of the page
      Then page title should be "My account - My Store"
      And Logout from Application

    Scenario: Account section count
      Given user is on accounts page
      Then user gets account section
        |ORDER HISTORY AND DETAILS|
        |MY CREDIT SLIPS|
        |MY ADDRESSES|
        |MY PERSONAL INFORMATION|
        |MY WISHLISTS|
        |Home|
      And accounts section count should be 6
      And Logout from Application
