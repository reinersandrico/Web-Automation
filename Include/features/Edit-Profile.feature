@7_Edit_Profile
Feature: Edit Profile

  Background: user already login
    Given User already in login page
    And User input correct email "kanita3723@fenwazi.com"
    And User input correct password "123456789"
    And User click login button
    And User successfully login and redirected to home page
	
	@positive_case
  Scenario: User want to update name profile with correct data
    When User click profile icon
    And User click profile
    And User edit Nama
    And User click Submit button
    Then User successfully edit profile
	
	@positive_case
  Scenario: User want to update city profile with correct data
    When User click profile icon
    And User click profile
    And User edit Kota
    And User click Submit button
    Then User successfully edit profile
	
	@positive_case
  Scenario: User want to update address profile with correct data
    When User click profile icon
    And User click profile
    And User edit Alamat
    And User click Submit button
    Then User successfully edit profile
    
	@positive_case
  Scenario: User want to update number phone profile with correct data
    When User click profile icon
    And User click profile
    And User edit No Handphone
    And User click Submit button
    Then User successfully edit profile

	@negative_case
  Scenario: User want to update address profile with incorrect data
    When User click profile icon
    And User click profile
    And User edit incorrect Alamat
    And User click Submit button
    Then User unsuccessfully edit profile
