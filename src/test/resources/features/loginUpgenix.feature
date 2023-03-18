@login
Feature: User should be able to login

  Background: user is on the login page
    Given user is on the login page

@credentials @UPG10-222
  Scenario Outline: Check Login and Password
    When user enters "<login>" and "<password>" in range of <start> to <end>
    Examples:
      | login        | password     | start | end |
      | salesmanager | salesmanager | 6     | 7   |
      | posmanager   | posmanager   | 15    | 16  |
#5-105 #15-155

@UPG10-223
  Scenario: "Wrong login/password" message should be displayed for invalid credentials
    When User enter invalids credentials for SalesManager
    And user clicks on the "login" button
    Then user see "Wrong login/password"


@UPG10-224
  Scenario: "Please fill out this field" message should be displayed if the password or username is empty
    When User leaves login field empty and enters password
    And user clicks on the "login" button
    Then user see "Заповніть це поле.".

@UPG10-225
  Scenario: User should see the password in bullet signs by default while typing (like ****)
    When User enter any password
    Then User should see the password in bullet signs by default while typing like ****

@UPG10-226
  Scenario: Verify if the ‘Enter’ key of the keyboard is working correctly on the login page
    When User enter valid credentials for SalesManager (e.g., username: "salesmanager15@info.com", password: "salesmanager")
    And user press ENTER after typing password
    Then user logins and redirected to home page
