@5_Detail_Product
Feature: View Detail Product at Website

  @positive_case
  Scenario: User want to see detail product without login
    Given User visit secondhand website
    When User click product on list product
    Then User can see detail product page

  Scenario: User want to bid product without login
    Given User visit secondhand website
    When User click product on list product
    And User click Saya Tertarik dan Ingin Nego button
    Then User redirected to login page
    
  Scenario: User want to see detail product with login
		Given User already in login page
    When  User input correct email "likalagi10@gmail.com"
    And User input correct password "trilika10"
    And User click login button
    Then User successfully login and redirected to home page
    And User click product on list product
    Then User can see detail product page
    

    