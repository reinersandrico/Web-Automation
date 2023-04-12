@3_Add_Product_no_login
Feature: Add Product Without Login

 
  Scenario: User want to add new product
  	Given User visit the website
    And User already on home page
    And User click + Tambah Produk
    Then User redirected to login page
