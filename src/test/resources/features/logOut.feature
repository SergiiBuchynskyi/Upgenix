@logout
Feature: User should be able to logout

  Background: user is Logged in
    Given user is already logged in

  @UPG10-227
  Scenario: User can log out and ends up in login page
    Then user log out
    Then user is redirected to home page

  @UPG10-229
  Scenario: The user can not go to the home page again by clicking the step back button after successfully logged out.
    When user log out
    Then user press step back button and user can not go to the home page again


  @UPG10-228
  Scenario: The user must be logged out if the user closes all open tab
    When User closes all tabs
    And user navigates to home page again
    Then user has to be logged out

