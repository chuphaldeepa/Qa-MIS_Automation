
package com.qa.MIS.StepDefinition;

import org.openqa.selenium.By;
import com.qa.MIS.Utils.*;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.qa.MIS.StepDefinition.Dashboard_Functionality;


public class Leave_Management extends CommonFunctions {

	static ConfigFileReader configFileReader;
	public static String URL, driverPath;

	@Before
	public void Initialize_Test(Scenario s) throws Throwable {
		// Get the Host Name

		testCaseName = s.getName();
		// System.out.println("The script is running in the Host Name" +
		// CommonFunctions.NextLine + Hostname);
		// CommonFunctions.fn_extent_start_test(s.getName());

	}

	@After
	public void afterScenario(Scenario scenario) {
		CommonFunctions.fn_after_Scenario(scenario);
	}

	Dashboard_Functionality Dashboard = new Dashboard_Functionality();

	@Given("^If User on MIS Login Page as (.*) and (.*)$")
	public void validate_MIS_LoggedIn(String username, String password) throws Throwable {
		Dashboard.validate_user_is_on_mis_LoginPage();
		fn_Generic_login(username, password);
		fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveManagement")));
	}

	@Then("^Open Leave Management Page$")
	public void fn_Click_Leave_Managemt() throws Throwable {

		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveManagement")),
				"Verify Leave Management button", "Leave Management button is present",
				"Leave Management button not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveManagement")),
					"Wait for Leave Management button to be enabled", "Button is enabled", "Button is disabled");
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveManagement")), "Click on leave management Button",
					"Clicked successfully", "Failed to click", "Exception caught on click");
			Thread.sleep(1000);
		}
	}

	@Then("^Click apply Leave$")
	public void fn_Click_Apply_Leave() throws Throwable {

		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("applyLeave")),
				"Verify Leave Management button", "Apply Leave button is present", "Apply Leave button not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("applyLeave")),
					"Wait for apply leave button to be enabled", "Button is enabled", "Button is disabled");
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("applyLeave")), "Click on aplly Button",
					"Clicked successfully", "Failed to click", "Exception caught on click");
			Thread.sleep(1000);
		}
	}

	// --------------selecting FROM date for leave------------

	@Then("^Select from date for leave as (.*) and (.*)$")
	public void fn_Select_FromDate(String input1, String input2) throws Throwable {

		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveFrom")), "leave from field",
				"leave from field present", "Aleave from field not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveFrom")));
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveFrom")));
			Thread.sleep(2000);

			while (true) {

				String Month = driver.findElement(By.xpath(ConfigFileReader.getElementLocatorProperty("activeMonth"))).getText();
				if (Month.equals(input1)) {
					break;
				} else {
					fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("next")));
				}
			}

			driver.findElement(By.xpath("//*[@class='day' and contains(text()," + input2 + ")]")).click();
			Thread.sleep(300);

		}
	}
	// --------------selecting TO date for leave------------

	@Then("^Select to date for leave as (.*) and (.*)$")
	public void fn_Select_ToDate(String input3, String input4) throws Throwable {

		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveTo")), "leave to field",
				"leave to field present", "leave to field not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveTo")));
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveTo")));
			Thread.sleep(2000);
			while (true) {

				String Month2 = driver.findElement(By.xpath(ConfigFileReader.getElementLocatorProperty("activeMonth"))).getText();
						
				if (Month2.equals(input3)) {
					break;
				} else {
					fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("next")));
				}
			}

			driver.findElement(By.xpath("//*[@class='day' and contains(text()," + input4 + ")]")).click();
			Thread.sleep(300);

		}
	}

	@Then("^select first leave day as half day$")
	public void fn_Select_HalfDay() throws Throwable {

		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveFirstHalfDay")),
				"leave half day field", "leave half day field present", "leave half day field not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveFirstHalfDay")));
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveFirstHalfDay")),
					"Mark first day of leave as half day clicked successfully", "Marked successfully",
					"Failed to click", "Exception caught on click");

		}
	}

	@Then("^Select type of leave$")
	public void fn_Select_LeaveType() throws Throwable {

		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveType")), "leave type field",
				"leave type field present", "leave type field not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveType")));
			String option = driver.findElement(By.xpath(ConfigFileReader.getElementLocatorProperty("LWP"))).getText();
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveType")));
			fn_selectFromDropdownByVisibleText(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveType")),
					option, "Verify leave type selected", "leave type selected successfully",
					"exception caught while selecting");
			Thread.sleep(300);
		}
	}

	@Then("^Enter reason of leave as (.*)$")
	public void fn_Enter_Leave_Reason(String Reason) throws Throwable {

		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveReason")), "leave reason field",
				"leave reason field present", "leave reason field not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveReason")));
			Thread.sleep(2000);
			fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveReason")), Reason,
					"Enter leave reason in Textbox", "Input entered successfully", "Failed to enter reason",
					"Exception caught while entering leave reason");

			Thread.sleep(300);
		}
	}

	@Then("^Enter primary contact number and alternate number as (.*) and (.*)$")
	public void fn_Enter_Contact(String Contact1, String Contact2) throws Throwable {

		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveContactNumber")),
				"contact number field", "contact number field present", "contact number field not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveContactNumber")));
			fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveContactNumber")), Contact1,
					"Enter primary conatct number in Textbox", "Input entered successfully", "Failed to 1enter contact",
					"Exception caught while entering contact number");
			Thread.sleep(300);
		}

		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveAltContNumber")),
				"alternate contact number field", "contact number field present", "contact number field not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveAltContNumber")));
			fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveAltContNumber")), Contact2,
					"Enter alt contact in Textbox", "Input entered successfully", "Failed to enter alt contact number",
					"Exception caught while entering contact number");
			Thread.sleep(300);
		}
	}

	@Then("^select availability on Mobile$")
	public void fn_Select_Availability() throws Throwable {

		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("availableOnMobile")),
				"verify select  field present", "field present", "field not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("availableOnMobile")));
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("availableOnMobile")), "Select availability",
					"selected successfully", "Failed to select", "Exception caught ");
			Thread.sleep(300);
		}
	}

	@And("^submit to apply leave$")
	public void fn_apply() throws Throwable {

		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveSubmit")),
				"verify submit  field present", "field present", "field not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveSubmit")));
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveSubmit")), "varify leave submit clicked",
					"clicked successfully", "Failed to click", "Exception caught ");
			Thread.sleep(300);
			if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveApplied"))))

			{
				fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("Ok")),
						"Verify leave applied successfully", "leave applied successfully", "failed to apply",
						"wxception caught");
			}
		}
	}

	
		
		@When("^Select from date as (.*) and (.*)$")
		public void fn_select_FromDate(String input1, String input2) throws Throwable {

			if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveFrom")), "leave from field",
					"leave from field present", "Aleave from field not present")) {
				fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveFrom")));
				fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveFrom")));
				Thread.sleep(2000);

				while (true) {

					String Month = driver.findElement(By.xpath(ConfigFileReader.getElementLocatorProperty("activeMonth"))).getText();
					if (Month.equals(input1)) {
						break;
					} else {
						fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("next")));
					}
				}

				driver.findElement(By.xpath("//*[@class='day' and contains(text()," + input2 + ")]")).click();
				Thread.sleep(300);

			}
		}
		
		@Then("^Select to date as (.*) and (.*)$")
		public void fn_select_ToDate(String input3, String input4) throws Throwable {

			if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveTo")), "leave to field",
					"leave to field present", "leave to field not present")) {
				fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveTo")));
				fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveTo")));
				Thread.sleep(2000);
				while (true) {

					String Month2 = driver.findElement(By.xpath(ConfigFileReader.getElementLocatorProperty("activeMonth"))).getText();
							
					if (Month2.equals(input3)) {
						break;
					} else {
						fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("next")));
					}
				}

				driver.findElement(By.xpath("//*[@class='day' and contains(text()," + input4 + ")]")).click();
				Thread.sleep(300);

			}
		}

		
		@And("^Verify leave Collision$")
		public void fn_leave_collision() throws Throwable{
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("dateCollisionWarning")),
				"verify date collision", "date collision", "no date collision")) {
			System.out.println("date collision, please select other dates");
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("Ok")));
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("Ok")));

		}
	}

	@When("^open view request details$")
	public void fn_Open_leave_details() throws Throwable {
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("viewRequestStatus")),
				"verify viewRequestStatus filed present", "field  presentn", "field not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("viewRequestStatus")));
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("viewRequestStatus")));
			Thread.sleep(1000);
		}
	}

	@Then("^view request status$")
	public void fn_View_Status() throws Throwable {
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveStatus")),
				"verify leave status filed present", "Leave approval is pending", "status not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("leaveStatus")));
			System.out.println("Leave approval is pending");

		}
	}
	
	/*
	 * @When("^click on plus sign$") public void fn_CLick_On_Plus() throws
	 * Throwable{ if
	 * (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty(
	 * "plusSign")),"verify plus filed present",
	 * "filed present","field not present")) {
	 * fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.
	 * getElementLocatorProperty("plusSign")));
	 * fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("plusSign")),
	 * "click on plus", "clicked successfully","Failed to click",
	 * "Exception caught on click"); Thread.sleep(1000); } }
	 */
	
	

	@Then("^cancel leave$")
	public void fn_Cancel_Leave() throws Throwable{
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("cancelLeave")),"verify cancel filed present",
				"filed present","field not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("cancelLeave")));
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("cancelLeave")),
					"click on cancel", "leave cancelled successfully","Failed to click", "Exception caught on click");
			Thread.sleep(1000);
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("confirmCancelLeave")));
			Thread.sleep(1000);
			if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("confirmCancelLeave")))) {
				fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("Yes")));
				Thread.sleep(2000);
				if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("requestProcessed")))) {
					fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("Ok")));
					fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("Ok")), "varify leave cancelled successfully",
							"leave cancelled successfully","failed to cancelled","exception caught");
				Thread.sleep(1000);
				System.out.println("leave has been cancelled successfully");
			
		}
	}
	
}
}
	
	@When("^click User drop down button$")
	public void MIS_LogOut() throws Throwable{
		
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("userDropdown")),
				"Verfiy user drop down is visible", "user drop down field is visible",
				"user drop down  field is not visible")) {
			Thread.sleep(1000);
			
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("userDropdown")), "Click on user drop down",
					"Clicked successfully", "Failed to click", "Exception caught on click");
			Thread.sleep(1000);
			
		}
	}
			
			@Then("^Click MIS logout field$")
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
			
			
	@And("^close the browser$")	
	public void fn_Close_browser() throws Throwable{
		fn_CloseBrowser();

		}
}
