MIS_Selenium Automation using Cucumber
Cucumber is a behavior driven development (BDD) approach to write automation test script to test Web. It enables you to write and execute automated acceptance/unit tests. It is cross-platform, open source and free. Automate your test cases with minimal coding.

Documentation
Installation (pre-requisites)
JDK 1.8+ (make sure Java class path is set)
Maven (make sure .m2 class path is set)
Eclipse
Eclipse Plugins for
Maven
Cucumber
Browser driver (make sure you have your desired browser driver and class path is set)
Framework set up
Fork / Clone repository from here or download zip and set it up in your local workspace.
Predefined steps

Download from below repository
Gitea- https://gitea.geminisolutions.in/ak.khattar/MIS_Selenium_Automation.git

Project-MIS_Selenium_Automation
	|
	|_src/main/java
	|	|_qa_mis.qa_mis
	|_src/main/resources
	|_src/test/java
	|	|_com.qa.MIS.GlobalVariables
	|	|	|_GLobalVariables.java
	|	|_com.qa.MIS.RunnerClass
	|	|	|_RunnerClass.java
	|	|_com.qa.MIS.StepDefinition
	|	|	|_MIS_LoginFunctionality.java
	|	|	|...
	|	|_com.qa.MIS.Utils
	|	|	|_CommonFunctions.java
	|	|_Drivers
	|	|	|_chromedriver.exe
	|	|_Features
	|	|	|_MISLogin.feature
	|	|	|...
	|_src/test/resources

Writing a test
The cucumber features goes in the features library and should have the ".feature" extension.

You can start out by looking at Features/MISLogin.feature. You can extend this feature or make your own features using some of the predefined steps that comes with selenium-cucumber.
Feature: Validate the behavior for MIS Login
  This feature file contains the scenarios to test MIS Login Page with for different credentials.
   
Scenario: MIS Login with Valid Credentials
    Given User is on MIS Login Page
    When Enter username in Username field as deepa.chuphal
    And Enter password in Password field as Password@1234
    Then Click on the SignIn button and reset password if expired for user deepa.chuphal and set password as Password@1234
    And Verify Page Title

Predefined steps
By using predefined steps you can automate your test cases more quickly, more efficiently and without much coding.

Running test
Go to your project directory from terminal and hit following commands

mvn test (defualt will run on chrome browser)