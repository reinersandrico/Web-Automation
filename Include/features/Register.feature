# User Registration Website
# @created : Wed, 03 Maret 2023 10:40
# @author  : Aziz Hendra (hendraaziz80@gmail.com)
@8_Register
Feature: User Registration Website

  @positive_case
  Scenario: User Registration with Correct Credentials
    Given User already on Home page
    When User clicks the Masuk button on the top right corner of the page
    And User clicks the Daftar di sini link under the Masuk button
    And User inputs their complete name in the Nama field
    And User inputs a valid email address in the Email address field
    And User inputs a valid password in the Password field
    And User clicks the Daftar button
    Then User should see a flash/toast message Silahkan verifikasi email agar dapat menggunakan layanan kami
    And User should be successfully registered.

  @negative_case
  Scenario Outline: User Registration with Incorrect Credentials
    Given User already on Home page
    When User clicks the Masuk button on the top right corner of the page
    And User clicks the Daftar di sini link under the Masuk button
    And User <name_case> name in the Nama field
    And User inputs <email_case> email address in the Email address field
    And User inputs <password_case> password in the Password field
    And User clicks the Daftar button
    Then User failed to register and should see warning information that <warning>

    Examples: 
      | code_id | name_case             | email_case             | password_case                    | warning                               |
      |     001 | inputs their complete | an incorrect           | a valid                          | Email  format is incorrect            |
      |     002 | inputs their complete | a valid                | with less than eight characters  | Password Kurang dari delapan Karakter |
      |     003 | inputs their complete | an already registered  | a valid                          | Email sudah digunakan                 |
      |     004 | skips input complete  | a valid                | a valid                          | Nama field is required                |
