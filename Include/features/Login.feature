@1_Login
Feature: Login Feature Web

  @login_positive_case
  Scenario: User want login using correct email and password
    Given User already in login page
    When User input correct email "kanita3723@fenwazi.com"
    And User input correct password "123456789"
    And User click login button
    Then User successfully login and redirected to home page

  @login_negative_positive
  Scenario Outline: User login with incorrect credentials
    Given User already in login page
    When User input email field with <email_user>
    And User input password field with <password_user>
    And User click login button
    Then User unsuccessfully login and get <result> toast message

    Examples: 
      | case_id | email_user   	| password_user    	| result       							|
      |     001 | valid email  	| invalid password 	| wrong password      			|
      |     002 | invalid email	| valid password   	| account not found   			|
      |     003 | new email 		| valid password		| check email verification	|
      |     004 | empty email  	| valid password   	| failed empty email      	|
      |     005 | valid email  	| empty password   	| failed empty password     |
      |     006 | empty email  	| empty password   	| failed empty email				|
      
