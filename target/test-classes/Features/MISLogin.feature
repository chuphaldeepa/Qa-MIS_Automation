#Author : deepachuphal
#Keywords Summary :
#Feature: List of scenarios.
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Validate the behavior for MIS Login
  This feature file contains the scenarios to test MIS Login Page with for different credentials.
   
   
   Scenario: MIS_SignIn_With_InValid_Credentials
    Given User is on MIS Login Page
    When Enter username in Username field as deepa.chuphal
    And Enter password in Password field as Password@12
    Then Click on the SignIn button
    Then Screen should throw error message on passing invalid credentials
    
  	Scenario: MIS_SignIn_Forgot_Password
    Then Click on the forgot_password button and reset password  
    Then verify Password reset link sent to your official email
    And  Click on Ok button
    And Click on the Signin button
    
  	Scenario: MIS_SignIn_With_Valid_Credentials
    When Enter username in Username field as deepa.chuphal
    And Enter password in Password field as Password@1234
    Then Click on the SignIn button and reset password if expired for user deepa.chuphal and set password as Password@123
    Then Verify Page Title
    
    
    Scenario: MIS_SignIn_In_New_Session
  
    Then open new window and verify if in new session NIS is logged out 
    And Close browser
    
    
      
    