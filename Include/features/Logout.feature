@2_Logout
Feature: Logout Feature Mobile

  Background: User do the login process
    Given User already in login page
    And User input correct email "reiner.sandrico@ti.ukdw.ac.id"
    And User input correct password "123456789"
    And User click login button
    Then User successfully login and redirected to home page

  Scenario: User want to logout from an account
    When User click Akun icon
    And User click Keluar
    Then User's account should be logged out
