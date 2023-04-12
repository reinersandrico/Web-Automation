@4_Product
Feature: Product

  Background: user already login
    Given User already in login page
    And User input correct email "reiner.sandrico@ti.ukdw.ac.id"
    And User input correct password "123456789"
    And User click login button
    And User successfully login and redirected to home page
    
 @Edit_product_positive_case
  Scenario: User want to edit product using all the correct product data
    When User click three dots menu on the navigation menu
    And User select "2nd" product from list product
    And User click edit button
    And User change name product "penjualbanrdm1"
    And User change the price product "1200"
    And User select the new category product "Baju"
    And User input new description product "Ini adalah product yang di edit"
    And User click Terbitkan button
    Then User successfully update product and will be directed to the home page
    And User edit the product back to the initial value
    
  @Edit_product_negative
  Scenario Outline: User want to edit product using empty data product
    When User click three dots menu on the navigation menu
    And User select "2nd" product from list product
    And User click edit button
    And User edit product <data_product>
    And User click Terbitkan button
    Then User get result <result> update product
    And User edit the product back to the initial value <value>
    
   
    
    Examples: 
      | case_id | data_product       	 	| result       	|value											|
      |     001 | delete name product  	| failed 				|name product								|
      |     002 | delete description		| successfully 	|description product 				|
      |     003 | minus price product 	| failed 				|price product							|


  @Add_Product
  Scenario: User want to add new product
    When User click three dots menu on the navigation menu
    And User click + Tambah Produk
    And User input product name
    And User input product price with 2000
    And User choose the Hoby category
    And User input description
    And User click Terbitkan button
    Then User will be directed to the home page
    
  @Add_Product_negative
  Scenario Outline: User want to add new product with false requirement
    When User click three dots menu on the navigation menu
    And User click + Tambah Produk
    And User input product name
    And User input product price with <variant price>
    And User input product with <false requirement>
    And User choose the <case> category
    And User input description
    And User click Terbitkan button
    Then User should be able to see error toast
    
    Examples:
		|case_id| 	false requirement			|				case			|				variant price		|
		|A01		|				empty category		|				empty			|						100					|
		|A02		| 			empty price				|			category 		|						 0					|

  @Add_Product_negative
  Scenario: User want to add fifth new product
    Given User already has 4 products
    When User click three dots menu on the navigation menu
    And User click + Tambah Produk
    And User input product name
    And User input product price with 2000
    And User choose the Hoby category
    And User input description
    And User click Terbitkan button
    Then User should be able to see warning
    
  @Delete_Product
  Scenario: User want to delete product
  	When User click three dots menu on the navigation menu
  	And User select "3rd" product from list product
  	And User click delete button
  	Then User will be directed to the home page
    
