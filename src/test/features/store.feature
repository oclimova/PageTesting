Feature: http://172.16.44.49/oc/
  As a simple user
  I want to be able to enter on the site main page, create account and login

  @Run
  Background:
    Given I am an unsigned user

  @Run
  Scenario: unsigned user navigates to the home page
    When I navigate to the 'home page'
    Then the 'home page' is displayed

  @Run
  Scenario: unsigned user navigates to the Register Account page
    Given I navigated to the 'home page'
    When I click on 'create an account' link
    Then I am redirected to the 'Register Account page'
    And all text fields on the 'Register Account page' are clear
    But 'Country' field on the 'Register Account page' is filled with 'United Kingdom' value
    And 'Region / State' field on the 'Register Account page' is filled with '--- Please Select ---' value
    And 'Subscribe' radio-group on the 'Register Account page' is set to 'No' value

  @Run
  Scenario: unsigned user navigates to the Register Account page and tries to register an account with complete and valid data
    Given I navigated to the 'Register Account page'
    When I filled all required fields with the following data
      | First Name       | aaa          |
      | Last Name        | aaa          |
      | E-mail           | random email |
      | Telephone        | +37368179073 |
      | Address 1        | aaa          |
      | City             | aaa          |
      | Country          | random       |
      | Region / State   | random       |
      | Password         | random       |
      | Password Confirm | the same     |
    And pressed 'Continue button'
    Then I am shown 'Your Account Has Been Created!' message

  @Run
  Scenario: unsigned user navigates to the Login page
    Given I navigated to the 'home page'
    When I click on the 'login' link
    Then I am redirected to the 'Account Login page'
    And the 'Account Login page' is displayed
    And 'E-Mail Address field' is clear
    And 'Password field' is clear