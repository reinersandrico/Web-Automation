@6_Bid_Product
Feature: Bid Product at Website

Background:
  	Given User already in login page
    When  User input correct email "get.your.item2@gmail.com"
    And User input correct password "12345678"
    And User click login button
    Then User successfully login and redirected to home page
    And User click added product on list product
    And User click Saya Tertarik dan Ingin Nego button


  Scenario Outline: User want to bid product with false requirement
    And User input original price in Harga Tawar field with <price>
    And User click Kirim button
    Then User can see <result> toast message

	Examples:
		|case_id|price	|result	|
		|P01		|0			|failed	|
		|P02		|null		|failed	|
		|P03		|1000		|Success|