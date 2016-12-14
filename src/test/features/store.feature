Feature: http://172.16.44.49/oc/
  As a simple user
  I want to be able to enter on the site main page, create account and login

  Background:
    Given I am an unsigned user

  # this one runs correctly
  @NotRun
  Scenario: unsigned user navigates to the home page
    When I navigate to the Home page
    Then the Home page is displayed

  # this one runs correctly
  @NotRun
  Scenario: unsigned user navigates to the Register Account page
    Given I navigated to the Home page
    When I click on CreateAccount link from the Home page
    Then the RegisterAccount page is displayed
    And all text fields on the RegisterAccount page are clear
    But Country field on the RegisterAccount page is filled with 'United Kingdom' value
    And Region field on the RegisterAccount page is filled with '--- Please Select ---' value
    And Subscribe radio-group on the RegisterAccount page is set to 'No' value

  # this one runs correctly
  @NotRun
  Scenario: unsigned user navigates to the Register Account page and tries to register an account with complete and valid data
    Given I navigated to the RegisterAccount page
    # we don't have access to the database, so WE HAVE TO PUT A NEW EMAIL IN THE NEXT STEP EVERY TIME WE RUN IT
    When I filled some fields on the RegisterAccount page with the following data
      | FirstName       | aaa              |
      | LastName        | aaa              |
      | Email           | email1@gmail.com |
      | Telephone       | +37368179073     |
      | Address1        | aaa              |
      | City            | aaa              |
      | Country         | 1                |
      | Region          | 1                |
      | Password        | password         |
      | PasswordConfirm | password         |
    And I clicked on the PrivacyPolicy checkbox from the RegisterAccount page
    And pressed Continue button on the RegisterAccount page
    Then the AccountCreated page is displayed

  # this one's steps aren't implemented
  @Run
  Scenario: unsigned user navigates to the Login page
    Given I navigated to the Home page
    When I click on the Login link from the Home page
    And the AccountLogin page is displayed
    And all text fields on the AccountLogin page are clear