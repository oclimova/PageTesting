Feature: http://172.16.44.49/oc/
  As a simple user
  I want to be able to enter on the site main page, create account and login

  @Run
  Scenario: unsigned user navigates to the home page
    Given I am an 'unsigned user'
    When I navigated to the 'home page'
    Then the 'home page' is displayed

  @Run
  Scenario: unsigned user navigates to the Register Account page
    Given as an 'unsigned user' I navigated to the 'home page'
    When I click on 'create an account' link
    Then I am redirected to the 'Register Account page'
    And the 'Register Account page' is displayed
    And all fields are clear
    But 'Country' field is filled with 'United Kingdom' value
    And 'Region / State' field is filled with '--- Please Select ---' value
    And 'Subscribe' radio-group is set to 'No' value

  @Run
  Scenario: unsigned user navigates to the Register Account page and tries to register an account with complete and valid data
    Given as an 'unsigned user' I navigated to the 'Register Account page'
    When I filled all required fields
    And marked 'I have read and agree to the Privacy Policy checkbox'
    And pressed 'Continue button'
    Then I am shown 'Your Account Has Been Created!' message

  @Run
  Scenario: unsigned user navigates to the Register Account page and tries to enter his password
    Given as an 'unsigned user' I navigated to the 'Register Account page'
    When I fill the 'Password' field
    Then all symbols are replaced with '*'

  @Run
  Scenario: unsigned user navigates to the Register Account page and tries to enter his password confirmation
    Given as an 'unsigned user' I navigated to the 'Register Account page'
    When I fill the 'Password Confirm' field
    Then all symbols are replaced with '*'

  @Run
  Scenario: unsigned user navigates to the Login page
    Given as an 'unsigned user' I navigated to the 'home page'
    When I click on the 'login' link
    Then I am redirected to the 'Account Login page'
    And the 'Account Login page' is displayed
    And 'E-Mail Address field' is clear
    And 'Password field' is clear