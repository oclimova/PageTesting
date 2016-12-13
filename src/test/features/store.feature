Feature: http://172.16.44.49/oc/
  As a simple user
  I want to be able to enter on the site main page, create account and login

  Background:
    Given I am an unsigned user

  @Run
  # this one runs correctly
  Scenario: unsigned user navigates to the home page
    When I navigate to the Home page
    Then the Home page is displayed

  @Run
  # this one runs correctly
  Scenario: unsigned user navigates to the Register Account page
    Given I navigated to the Home page
    When I click on CreateAccount link from the Home page
    Then the RegisterAccount page is displayed
    And all text fields on the RegisterAccount page are clear
    But Country field on the RegisterAccount page is filled with 'United Kingdom' value
    And Region field on the RegisterAccount page is filled with '--- Please Select ---' value
    And Subscribe radio-group on the RegisterAccount page is set to 'No' value

  @NotRun
  # this one's steps aren't implemented
  Scenario: unsigned user navigates to the Register Account page and tries to register an account with complete and valid data
    Given I navigated to the RegisterAccount page
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

  @NotRun
  # this one's steps aren't implemented
  Scenario: unsigned user navigates to the Login page
    Given I navigated to the Home page
    When I click on the 'login' link
    Then I am redirected to the 'Account Login page'
    And the 'Account Login page' is displayed
    And 'E-Mail Address field' is clear
    And 'Password field' is clear