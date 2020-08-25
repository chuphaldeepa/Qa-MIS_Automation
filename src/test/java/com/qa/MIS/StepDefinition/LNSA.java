package com.qa.MIS.StepDefinition;

import org.openqa.selenium.By;
import com.qa.MIS.Utils.*;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import com.qa.MIS.StepDefinition.Dashboard_Functionality;







public class LNSA extends CommonFunctions {

	static ConfigFileReader configFileReader;
	public static String URL, driverPath;

	@Before
	public void Initialize_Test(Scenario s) throws Throwable {
		// Get the Host Name
		
		testCaseName = s.getName();
		//System.out.println("The script is running in the Host Name" + CommonFunctions.NextLine + Hostname);
	//	CommonFunctions.fn_extent_start_test(s.getName());
		
		 
		 
		 
	}

	@After
	public void afterScenario(Scenario scenario) {
		CommonFunctions.fn_after_Scenario(scenario);
	}

	/*
	 * @And("^Close browser$") public void close_browser() throws Throwable {
	 * 
	 * CommonFunctions.fn_CloseBrowser(); }
	 */
	Dashboard_Functionality Dashboard = new Dashboard_Functionality();
	
	

	@When("^If User on MIS Login Page$")
	public void validate_user_on_mis_LoginPage() throws Throwable {
		Dashboard.validate_user_is_on_mis_LoginPage();	
		}

	@When("^user logged in into mis as (.*) and (.*)$")
	public void verify_login(String username, String password) throws Throwable {		
		fn_Generic_login(username, password);
		fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("LNSA")));
	}
	
	@Then("^Click on LNSA button$")
	public void fn_click_LNSA() throws Throwable {

		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("LNSA")), "Verify LNSA button",
				"LNSA button is present", "LNSA button not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("LNSA")),
					"Wait for LNSA button to be enabled", "Button is enabled", "Button is disabled");
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("LNSA")), "Click on LNSA Button",
					"Clicked successfully", "Failed to click", "Exception caught on click");
			Thread.sleep(1000);
		}
	}
	
	@Then("^Click apply LNSA$")
	public void fn_click_Apply_LNSA() throws Throwable{
			
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("apply_LNSA")), "Verify apply_LNSA button",
				"apply_LNSA button is present", "apply_LNSA button not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("apply_LNSA")),
					"Wait for apply_LNSA button to be enabled", "Button is enabled", "Button is disabled");
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("apply_LNSA")), "Click on apply_LNSA Button",
					"Clicked successfully", "Failed to click", "Exception caught on click");
		}
	}
		
	@When("^Click prev date$")
	public void fn_Select_Prev_Date() throws Throwable{
		
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("prevDate")), "Verify prevDate button",
				"prevDate button is present", "prevDate button not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("prevDate")),
					"Wait for prevDate button to be enabled", "Button is enabled", "Button is disabled");
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("prevDate")), "Click on prevDate Button",
					"Clicked successfully", "Failed to click", "Exception caught on click");
			Thread.sleep(1000);
	
	}
	}
	
	@Then("^Click next date$")
	public void fn_Select_Next_Date() throws Throwable{
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("nextDate")), "Verify nextDate button",
				"nextDate button is present", "nextDate button not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("nextDate")),
					"Wait for nextDate button to be enabled", "Button is enabled", "Button is disabled");
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("nextDate")), "Click on nextDate Button",
					"Clicked successfully", "Failed to click", "Exception caught on click");
			Thread.sleep(1000);
	
	}
	
	}
	
	@Then("^Select date1$")
	public void fn_Select_Date1() throws Throwable{
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("Date1")), "Verify date1 is present",
				"date1 is present", "date1 not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("Date1")),
					"Wait for Date1 to be enabled", "Button is enabled", "Button is disabled");
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("Date1")), "Click on nextDate Button",
					"Clicked successfully", "Failed to click", "Exception caught on click");
			Thread.sleep(1000);
			
		}
	}
	
	@And("^Select date2$")
	public void fn_Select_Date2() throws Throwable{
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("Date2")), "Verify Date2 is present",
				"date1 is present", "date1 not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("Date2")),
					"Wait for Date2 to be enabled", "Date2 is enabled", "Date2 is disabled");
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("Date2")), "Click on nextDate Button",
					"Clicked successfully", "Failed to click", "Exception caught on click");
			Thread.sleep(1000);
			
		}
	}
	
	
	
		
	
	/*
	 * //@Then("^enter LNSA reason$") public void fn_Enter_LNSA_Reason(String
	 * reason) throws Throwable{
	 * 
	 * 
	 * } }
	 */

	
	@Then("^close reason box without entering reason$")
	public void fn_Close_Reason_Box() throws Throwable{
		
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("submitLNSAbtn")), "Verify submitLNSAbtn is present",
				"submitLNSAbtn is present", "submitLNSAbtn not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("submitLNSAbtn")),
					"Wait for submitLNSAbtn to be enabled", "submitLNSAbtn is enabled", "submitLNSAbtn is disabled");
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("submitLNSAbtn")), "Click on nextDate Button",
					"Clicked successfully", "Failed to click", "Exception caught on click");
			Thread.sleep(1000);
			
		}
	
		
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("LNSAreasonBox")), "Verify LNSAreasonBox is present",
				"LNSAreasonBox is present", "LNSAreasonBox not present")) {
			/*fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("LNSAreasonBox")),
					"Wait for LNSAreasonBox to be enabled", "LNSAreasonBox is enabled", "LNSAreasonBox is disabled");
			fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("LNSAreasonBox")), reason,
					"Enter LNSA reason in Textbox", "Input entered successfully", "Failed to enter reason",
					"Exception caught while entering extension number");*/
			Thread.sleep(1000);
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("reasonCloseBox")), "Verify reasonCloseBox is present",
				"reasonCloseBox is present", "reasonCloseBox not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("reasonCloseBox")),
					"Wait for reasonCloseBox to be enabled", "reasonCloseBox is enabled", "reasonCloseBox is disabled");
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("reasonCloseBox")), "Click on reasonCloseBox ",
					"Clicked successfully", "Failed to click", "Exception caught on click");
			Thread.sleep(1000);
			
		}
	}
	}
	
	@And("^enter LNSA reason as (.*)$")
	public void fn_Enter_Reason(String Reason) throws Throwable{ 
		
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("submitLNSAbtn")), "Verify submitLNSAbtn is present",
				"submitLNSAbtn is present", "submitLNSAbtn not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("submitLNSAbtn")),
					"Wait for submitLNSAbtn to be enabled", "submitLNSAbtn is enabled", "submitLNSAbtn is disabled");
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("submitLNSAbtn")), "Click on nextDate Button",
					"Clicked successfully", "Failed to click", "Exception caught on click");
			Thread.sleep(1000);
			
		
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("LNSAreasonBox")), "Verify LNSAreasonBox is present",
				"LNSAreasonBox is present", "LNSAreasonBox not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("LNSAreasonBox")),
					"Wait for LNSAreasonBox to be enabled", "LNSAreasonBox is enabled", "LNSAreasonBox is disabled");
			fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("LNSAreasonBox")), Reason,
					"Enter LNSA reason in Textbox", "Input entered successfully", "Failed to enter reason",
					"Exception caught while entering extension number");
			Thread.sleep(1000);
		}
		}
	}
	
	@When("^submit request$")
	public void fn_Submit_Request() throws Throwable{ 
		
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("submitRequest")), "Verify submitRequest is present",
				"submitRequest is present", "submitRequest not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("submitRequest")),
					"Wait for submitRequest to be enabled", "submitRequest is enabled", "submitRequest is disabled");
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("submitRequest")), "Click on submitRequest Button",
					"Clicked successfully", "Failed to click", "Exception caught on click");
			Thread.sleep(1000);
			
		}
	}
	
	@Then("^verify if request submitted successfully$")
	public void fn_Verify_submission() throws Throwable{ 
		
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("successLNSA")), "Verify request has been submitted successfully",
				"request has been submitted successfully", "request has not been submitted successfully")) {
			if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("clickOK")), "Verify OK is present",
					"OK is present", "OK not present")) {
				fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("clickOK")));
				fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("clickOK")), "Click on OK Button",
						"Clicked successfully", "Failed to click", "Exception caught on click");
		}
	}
	}
	
	@When("^select week for LNSA$")
	public void fn_Select_week() throws Throwable{ 
		
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("selectWeek")), "Verify selectWeek is present",
				"selectWeek is present", "selectWeek not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("selectWeek")),
					"Wait for selectWeek to be enabled", "selectWeek is enabled", "selectWeek is disabled");
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("selectWeek")), "Click on selectWeek Button",
					"Clicked successfully", "Failed to click", "Exception caught on click");
			Thread.sleep(1000);
			
		}
	}
	
	@Then("^submit_request as (.*)$")
	public void fn_Submit(String reason) throws Throwable{ 
		fn_Enter_Reason(reason);
		fn_Submit_Request();
		fn_Verify_submission();
			
		}
	
	@When("^LNSA has been applied$")
	public void fn_Click_ViewRequestStatus() throws Throwable{ 
		
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("ViewRequestStatus")), "Verify ViewRequestStatus is present",
				"ViewRequestStatus is present", "ViewRequestStatus not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("ViewRequestStatus")),
					"Wait for ViewRequestStatus to be enabled", "ViewRequestStatus is enabled", "ViewRequestStatus is disabled");
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("ViewRequestStatus")), "Click on ViewRequestStatus Button",
					"Clicked successfully", "Failed to click", "Exception caught on click");
			Thread.sleep(1000);
			
		}
	}
	
	@Then("^search LNSA as (.*)$")
	public void fn_search_request(String LNSA) throws Throwable{ 
		
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("SearchLNSA")), "Verify SearchLNSA is present",
				"SearchLNSA is present", "SearchLNSA not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("SearchLNSA")),
					"Wait for SearchLNSA to be enabled", "SearchLNSA is enabled", "SearchLNSA is disabled");
			fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("SearchLNSA")), LNSA,
					"Enter LNSA in Textbox", "Input entered successfully", "Failed to enter reason",
					"Exception caught while entering extension number");
			Thread.sleep(10000);
			
		}
	}
	
	@Then("^verify search by date$")
public void fn_Verify_LNSA(String date) throws Throwable{ 
		if (fn_isElementFound(By.xpath("//td["+ date + "]"), "Verify LNSA request is present",
				"LNSA request is present", "LNSA request is not present")) {
		
			
			System.out.println("Request is present");
			
		}
			
			
	}
	
		
	
	@Then("^view LNSA request$")
	public void fn_View_Request() throws Throwable{ 
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("ViewLNSA")), "Verify ViewLNSA is present",
				"ViewLNSA is present", "ViewLNSA not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("ViewLNSA")),
					"Wait for ViewLNSA to be enabled", "ViewLNSA is enabled", "ViewLNSA is disabled");
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("ViewLNSA")), "Click on ViewLNSA Button",
					"Clicked successfully", "Failed to click", "Exception caught on click");
			Thread.sleep(1000);
			
		}
			
			
	}
	
	@And("^verify LNSA request is opened$")
	public void fn_Verify_View() throws Throwable{ 
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("openedView")), "Verify LNSA details are present and view is opended",
				"LNSA details are present and view is opened", "LNSA details are not present")) {
			System.out.println("details are present");
			
		}
			
			
	}
	
	@When("^close view$")
	public void fn_Close_View() throws Throwable{ 
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("CloseLNSA")), "Verify CloseLNSA is present",
				"CloseLNSA is present", "CloseLNSA not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("CloseLNSA")),
					"Wait for CloseLNSA to be enabled", "CloseLNSA is enabled", "CloseLNSA is disabled");
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("CloseLNSA")), "Click on CloseLNSA Button",
					"Clicked successfully", "Failed to click", "Exception caught on click");
			Thread.sleep(1000);
			
		}
			
			
	}
	
	@When("^click cancel LNSA$")
	public void cancel_LNSA( ) throws Throwable{
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("ViewRequestStatus")))) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("ViewRequestStatus")));
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("ViewRequestStatus")));
			Thread.sleep(1000);
			
	
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("cancelLNSA")), "Verify Cancel button is present",
				"Cancel button is present", "Cancel button not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("cancelLNSA")),
					"Wait for Cancel button to be enabled", "Cancel button is enabled", "Cancel button is disabled");
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("cancelLNSA")), "Click on Cancel button Button",
					"Clicked successfully", "Failed to click", "Exception caught on click");
			Thread.sleep(1000);
	}
	}
	}
	
	@Then("^confirm cancel request$")
	public void confirm( ) throws Throwable{
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("yesConfirm")))) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("yesConfirm")));
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("yesConfirm")), "Confirm to concel LNSA",
					"Cancelled confirmed", "Failed to Cancel", "Exception caught on click");
			Thread.sleep(1000);
	}
	}
	
	@And("^verify LNSA request cancelled successfully$")
	public void verify_Cancel_LNSA( ) throws Throwable{
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("successLNSA")))) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("successLNSA")));
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("Ok")), "Verify cancel LNSA",
					"Cancelled successfully", "Failed to Cancel", "Exception caught on click");
			Thread.sleep(1000);
	}
	}
	
	@When("^Click User drop down$")
	public void mis_logout() throws Throwable{
		
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("userDropdown")),
				"Verfiy user drop down is visible", "user drop down field is visible",
				"user drop down  field is not visible")) {
			Thread.sleep(1000);
			
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("userDropdown")), "Click on user drop down",
					"Clicked successfully", "Failed to click", "Exception caught on click");
			Thread.sleep(1000);
			
		}
	}
			
			@Then("^Click MIS logout$")
			public void click_signout() throws Throwable{
			if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("Signout")),
					"Verfiy user drop down is visible", "user drop down field is visible",
					"user drop down  field is not visible")) {
				fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("Signout")),
						"Wait for user drop down field to be enabled", "Field is enabled", "Filed is disabled");
				
				fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("Signout")), "Click on user drop down",
						"Clicked successfully", "Failed to click", "Exception caught on click");
				Thread.sleep(1000);
				
				if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("Signin")),"Verfiy mis logged out", 
						"logged out","not logged out")) {
					System.out.println("logged out");
				}
	
	
	}
			
		}
			@Then("^Close the browser$")
			public void fn_Close() throws Throwable{
			fn_CloseBrowser();

			}
		
		
		
	


}