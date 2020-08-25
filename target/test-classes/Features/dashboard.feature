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
Feature: Validate the behavior for MIS Dashborad page
  This feature file contains the scenarios to test MIS Dashboard Page .

  Scenario: Dashboard_Open_User_Profile
    Given If User is on MIS Login Page
    When login with credentials as deepa.chuphal and Password@1234
    Then Click user dropdown
    And Click user profile

  Scenario: Dashboard_Update_Profile_Picture
    When Update profile picture as /home/de.chuphal/Downloads/images.jpeg
    
    Scenario: Dashboard_Update_Contact_Details
     When Enter invalid number as 12345
     Then Verify Contact nunber is valid
     And Enter vaild number as 1234556789
     And Update extn as 123
    
    Scenario: Dashboard_Update_Address
     When update user address by clicking update address button
     Then update country as India
     Then update state as Haryana
     And update city as Gurgaon
     And update pincode as 223462
     Then Update present address as S54/53, dlf phase 3
     And Update address details
     
     Scenario: Dashboard_Update_Password
     When update pasword by clicking on update password button
     Then Enter details as Password@1234 and Password@123
     Then Confirm password as Password@123
     And Update passwordand login again as deepa.chuphal and Password@123


  Scenario: Dashboard_Update_Skills
    When update dashboard settings by clicking on dashborad settings button
    Then Enter Technology and proficiency level as HTML and Beginner
    Then Enter skill type and experience in months as Secondary and 24
    And save skills as PHP
    
   Scenario: Dashboard_MIS_Logout
    When Click user drop down
    Then Click logout
    Then closing browser
