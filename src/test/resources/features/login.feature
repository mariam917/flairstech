Feature: OrangeHRM Login

  Scenario: Login with valid credentials
    Given I open the OrangeHRM login page
    When I enter username "Admin" and password "admin123"
    And I click the login button
    Then I should be logged in successfully
