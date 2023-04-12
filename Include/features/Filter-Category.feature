# Category Filter Product Website
# @created : Wed, 08 Maret 2023 11:50
# @author  : Aziz Hendra (hendraaziz80@gmail.com)
@9_FilterCategory
Feature: Category Filter Product Website

  @positive_case
  Scenario Outline: User View Products by Category Filter
    Given User already in login page
    When User input correct email "hendraa@yopmail.com"
    And User input correct password "hendraaziz"
    And User click login button
    And User successfully login and redirected to home page
    And User clicks on <kategori> Filter under Telusuri Kategori selection
    Then Products with <kategori> category will be displayed

    Examples: 
      | case_id | kategori   |
      | C01     | Semua      |
      | C02     | Hoby       |
      | C03     | Kendaraan  |
      | C04     | Baju       |
      | C05     | Elektronik |
      | C06     | Kesehatan  |
