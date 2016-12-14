Feature: http://172.16.44.49/oc/
  As a simple user
  I want to be able to enter on the site main page, create account and login

  Background:
    Given I am an unsigned user

  @NotRun
  # this one runs correctly
  Scenario: unsigned user navigates to the home page
    When I navigate to the Home page
    Then the Home page is displayed

  @NotRun
  # this one runs correctly
  Scenario: unsigned user navigates to the Register Account page
    Given I navigated to the Home page
    When I click on CreateAccount link from the Home page
    Then the RegisterAccount page is displayed
    And all text fields on the RegisterAccount page are clear
    But Country field on the RegisterAccount page is filled with 'United Kingdom' value
    And Region field on the RegisterAccount page is filled with '--- Please Select ---' value
    And Subscribe radio-group on the RegisterAccount page is set to 'No' value

  @Run
  # this one's steps aren't implemented
  Scenario: unsigned user navigates to the Register Account page and tries to register an account with complete and valid data
    Given I navigated to the RegisterAccount page
    # we don't have access to the database, so we have to put a new email in the next step every time we run it
    When I filled some fields on the RegisterAccount page with the following data
      | FirstName       | aaa              |
      | LastName        | aaa              |
      | Email           | email1@gmail.com |
      | Telephone       | +37368179073     |
      | Address1        | aaa              |
      | City            | aaa              |
      | Country         | 0                |
      | Region          | 0                |
      | Password        | password         |
      | PasswordConfirm | password         |
    And pressed continue button on the RegisterAccount page
    Then AccountCreated page is displayed

  @NotRun
  # this one's steps aren't implemented
  Scenario: unsigned user navigates to the Login page
    Given I navigated to the Home page
    When I click on the 'login' link
    Then I am redirected to the 'Account Login page'
    And the 'Account Login page' is displayed
    And 'E-Mail Address field' is clear
    And 'Password field' is clear