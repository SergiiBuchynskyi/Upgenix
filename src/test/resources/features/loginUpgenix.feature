Feature: User should be able to login

  Background: user is on the login page
    Given user is on the login page

  @login @credentials
  Scenario Outline: Check Login and Password
    When user enters "<login>" and "<password>" in range of <start> to <end>
    Examples:
      | login        | password     | start | end |
      | salesmanager | salesmanager | 6     | 7   |
      | posmanager   | posmanager   | 15    | 16  |
#5-105 #15-155

  @login
  Scenario: "Wrong login/password" message should be displayed for invalid credentials
    When User enter invalids credentials for SalesManager
    And user clicks on the "login" button
    Then user see "Wrong login/password"


  @login @wip
  Scenario: "Please fill out this field" message should be displayed if the password or username is empty
    When User leaves login field empty and enters password
    And user clicks on the "login" button
    Then user see "Заповніть це поле.".

  @login
  Scenario: User should see the password in bullet signs by default while typing (like ****)
    When User enter any password
    Then User should see the password in bullet signs by default while typing like ****

  @login
  Scenario: Verify if the ‘Enter’ key of the keyboard is working correctly on the login page
    When User enter valid credentials for SalesManager (e.g., username: "salesmanager15@info.com", password: "salesmanager")
    And user press ENTER after typing password
    Then user logins and redirected to home page
