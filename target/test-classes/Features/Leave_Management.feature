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
Feature: Validate the behavior for MIS Leave Management page
  This feature file contains the scenarios to test MIS Leave Management Page .

  Scenario: Leave_Apply_Leave
    Given If User on MIS Login Page as deepa.chuphal and Password@1234
    Then Open Leave Management Page
    Then Click apply Leave
    Then Select from date for leave as November 2019 and 28
    Then Select to date for leave as November 2019 and 29
    Then select first leave day as half day
    Then Select type of leave
    Then Enter reason of leave as urgent work
    Then Enter primary contact number and alternate number as 7836039405 and 9410958759
    Then select availability on Mobile
    And submit to apply leave
    
    Scenario: Leave_Leave_Collision
    When Select from date as November 2019 and 29
    Then Select to date as November 2019 and 29
    And Verify leave Collision
    
    Scenario: Leave_View_Leave_Details
    When open view request details
    Then view request status
    
    Scenario: Leave_Cancel_Leave
    Then cancel leave
    
    Scenario: MIS_Logout
    When click User drop down button
    Then Click MIS logout field
    And close the browser
    