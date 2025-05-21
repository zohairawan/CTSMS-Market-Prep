Feature: Sample Template for a Gherkin Feature
  A short high-level description of what the feature is about.
  This helps stakeholders, testers, and developers to understand the purpose of the tests.

  Background: Common setup for all scenarios in this feature
    # Common steps that are run before each scenario
    Given the user is on the login page
    And the database is seeded with default test data

  Scenario: Successful Login
    # A scenario describes a specific user behavior or system interaction
    Given the user enters valid credentials
    When they click the login button
    Then they are redirected to the dashboard
    And they see a welcome message

  Scenario: Invalid Login Attempt
    Given the user enters an incorrect username or password
    When they click the login button
    Then an error message is displayed
    And the login page remains visible

  Scenario Outline: Testing various login attempts
    # Scenario Outline allows you to reuse a scenario with multiple sets of test data
    Given the user enters "<username>" and "<password>"
    When they click the login button
    Then the system displays a "<message>"

    Examples: Valid credentials
      | username          | password      | message               |
      | validUser1        | validPass123  | Welcome back!         |
      | validUser2        | pass@word     | Welcome back!         |

    Examples: Invalid credentials
      | username          | password      | message               |
      | invalidUser       | invalidPass   | Invalid credentials   |
      | lockedUser        | correctPass   | Account locked        |

  Scenario: Using a data table to perform bulk actions
    Given the following users need to be created:
      | username   | email             | password    |
      | user1      | user1@test.com    | pass1       |
      | user2      | user2@test.com    | pass2       |
      | user3      | user3@test.com    | pass3       |
    When I create each user
    Then the users should exist in the system
    And their accounts should be active

  @SmokeTest @Critical
  Scenario: Working with tags
    # Tags allow scenarios to be grouped or categorized for running selective tests
    Given the application is running
    When the homepage is opened
    Then the main banner should be visible