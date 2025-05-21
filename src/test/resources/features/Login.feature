Feature: Login

  Background: Common setup for all scenarios in this feature
    Given the user is on the login page "https://chroma.mexil.it/site/login"

  @Regression @V-1
  Scenario: Ability to login with valid credentials
    When the user enters the correct username "general@teacher.com" into the username box
    And the user enters the correct passwords "123456" into the password box
    And the user clicks on the Sign In button
    Then the user is successfully logged in and redirected to a Dashboard page "https://mexil.it/chroma/admin/admin/dashboard"

  @Progression
  Scenario: Login with Invalid Credentials
    When the user enters the incorrect username "@teacher.com" into the username box
    And the user enters the incorrect passwords "12345" into the password box
    And the user clicks on the Sign In button
    Then the user sees the invalid login credentials message "Invalid Username or Password"