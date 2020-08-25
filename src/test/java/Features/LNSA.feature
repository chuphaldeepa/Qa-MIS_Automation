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
Feature: Validate the behavior for MIS LNSA page
  This feature file contains the scenarios to test MIS Dashboard Page .

  Scenario: LNSA_Open_Apply_LNSA
    When If User on MIS Login Page
    When user logged in into mis as deepa.chuphal and Password@1234
    Then Click on LNSA button
    Then Click apply LNSA
    
	  Scenario: LNSA_Validate_Calendar_Control
    When Click prev date
    Then Click next date
    Then Select date1
    And Select date2
    
    
   Scenario: LNSA_Validate_Reason
    Then close reason box without entering reason
    And enter LNSA reason as worked in night shift
    
    Scenario: LNSA_Apply_LNSA
    When submit request
    Then verify if request submitted successfully
    
    Scenario: LNSA_Select_Week_Checkbox
    When select week for LNSA
    Then submit_request as abcfhjbgmc
    
    Scenario: LNSA_Open_View_Request_Status
    When LNSA has been applied
    Then search LNSA as oct
    Then view LNSA request
    And verify LNSA request is opened
    
    
    Scenario: LNSA_Close_LNSA_Request_Details
    When close view
    
    Scenario: LNSA_Cancel_Request
    When click cancel LNSA
    Then confirm cancel request
    And verify LNSA request cancelled successfully
    
     Scenario: LNSA_MIS_Logout
    When Click User drop down
    Then Click MIS logout
    Then Close the browser
    
    
    
    
    
    

  