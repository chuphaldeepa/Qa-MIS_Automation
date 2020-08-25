package com.qa.MIS.StepDefinition;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.MIS.Utils.CommonFunctions;
import com.qa.MIS.Utils.ConfigFileReader;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MIS_LoginFunctionality extends CommonFunctions {

	static ConfigFileReader configFileReader;
	public static String URL, driverPath;

	public MIS_LoginFunctionality() {
		System.out.println("Launching MIS");
	}

	@Before
	public void Initialize_Test(Scenario s) throws Throwable {
		// Get the Host Name
		Hostname = InetAddress.getLocalHost().getHostName();
		testCaseName = s.getName();
		System.out.println("The script is running in the Host Name" + CommonFunctions.NextLine + Hostname);
		CommonFunctions.fn_extent_start_test(s.getName());
		CommonFunctions.fn_add_pass_step(testCaseName,
				"The script is running in the Host Name" + CommonFunctions.NextLine + Hostname);
	}

	@After
	public void afterScenario(Scenario scenario) {
		CommonFunctions.fn_after_Scenario(scenario);
	}

	@And("^Close browser$")
	public void close_browser() throws Throwable {

		CommonFunctions.fn_CloseBrowser();
	}

	@Given("^User is on MIS Login Page$")
	public void validate_user_is_on_mis_LoginPage() throws Throwable {
		try {
			configFileReader = new ConfigFileReader();
			testCaseName = this.getClass().getSimpleName().toString();
			CommonFunctions.fn_add_pass_step(testCaseName,
					"The script is runnisigninng in the Host Name" + CommonFunctions.NextLine + Hostname);
			driverPath = configFileReader.getConfigProperty("chromedriverpath");
			URL = configFileReader.getConfigProperty("AppURL");
			CommonFunctions.fn_LaunchBrowser("Chrome", driverPath, URL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("Username")), "Open MIS Login Page",
				"Launched MIS Login Page successfully", "Failed to launch MIS Login Page");
	}

	@When("^Enter username in Username field as (.*)$")
	public void enter_userName(String username) throws Throwable {
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("Username")),
				"Verify username textbox is present", "Username textbox is present",
				"Username textbox is not present")) {
			fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("Username")), username,
					"Enter username in Textbox", "Input entered successfully", "Failed to enter username",
					"Exception caught while entering username");
		}
	}

	@And("^Enter password in Password field as (.*)$")
	public void enter_password(String password) throws Throwable {

		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("Password")),
				"Verify password textbox is present", "Verify MIS >> LOG IN >> Password field object exists",
				"Password textbox is not present")) {
			fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("Password")), password,
					"Enter password in Textbox", "Input entered successfully", "Failed to enter password",
					"Exception caught while entering password");
		}
	}

	@Then("^Click on the SignIn button and reset password if expired for user (.*) and set password as (.*)$")
	public void click_on_Signin_button_and_reset_password(String username, String newPassword) throws Throwable 
	{
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("signIn")), "Verify Signin button",
				"Signin button is present", "Signin button not present")) 
		{
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("signIn")),
					"Wait for Signin button to be enabled", "Button is enabled", "Button is disabled");
			
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("signIn")), "Click on Signin Button",
					"Clicked successfully", "Failed to click", "Exception caught on click");
		}
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("cpassword")),
				"Password expired! Please Reset password", "Click to Reset password")) 
		{
			MIS_resetPsswrd("Reset Password", username, newPassword);
		}
	}

	@Then("^Click on the SignIn button$")
	public void click_on_Signin_button() throws Throwable {
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("signIn")), "Verify Signin button",
				"Signin button is present", "Signin button not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("signIn")),
					"Wait for Signin button to be enabled", "Button is enabled", "Button is disabled");
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("signIn")), "Click on Signin Button",
					"Clicked successfully", "Failed to click", "Exception caught on click");
		}
	}

	@Then("^Verify Page Title$")
	public void verify_page_title() throws Throwable {
		String Title = ConfigFileReader.getElementLocatorProperty("title");
		fn_getTitle(Title, "Validate title of MIS", "Title of MIS: " + CommonFunctions.BlueNormal_Start + Title,
				"Title of MIS: ", "Exception raised in navigating to MIS Home Page");

	}

	@Then("^Screen should throw error message on passing invalid credentials$")
	public void invalid_login() throws Throwable {
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("errormsg")),
				"Verify error message appears on invalid login",
				"Verify MIS >> LOG IN >> error message field object exists") == false) {
			fn_add_fail_step("Verify error message appears on invalid login",
					"Verify MIS >> LOG IN >> error message field object exists");
		}
	}

	@Then("^Click on the forgot_password button and reset password$")
	public void forgot_password() throws Throwable {
		Thread.sleep(10000);
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("forgotPsswrd")),
				"Verify forgot password button", "forgot password button is present",
				"forgot password button not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("forgotPsswrd")),
					"Wait for forgot password button to be enabled", "Button is enabled", "Button is disabled");
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("forgotPsswrd")),
					"Click on forgot password Button", "Clicked successfully", "Failed to click",
					"Exception caught on click");
			if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("resetPsswrd")),
					"Verify reset password button", "reset password button is present",
					"reset password button not present")) {
				fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("resetPsswrd")),
						"Wait for reset password button to be enabled", "Button is enabled", "Button is disabled");
				fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("resetPsswrd")),
						"Click on forgot password Button", "Clicked successfully", "Failed to click",
						"Exception caught on click");
				Thread.sleep(10000);
			}
		}

	}@Then("^close browser$")
	public void fn_Close_Browser() throws Throwable{
	fn_CloseBrowser();

	}

	@Then("^verify Password reset link sent to your official email$")
	public void verify_resetPassword() throws Throwable {
		fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("successPasswrdRst")),
				"Wait for reset password button to be enabled", "Button is enabled", "Button is disabled");
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("successPasswrdRst")),
				"Verify password reset is successfull", "Password reset successfull", "Password reset failed"))
			;
	}

	@Then("^Click on Ok button$")
	public void click_Ok() throws Throwable {
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("Ok")), "Verify OK button",
				"OK button is present", "OK button not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("Ok")),
					"Wait for OK button to be enabled", "Button is enabled", "Button is disabled");
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("Ok")), "Click on OK Button",
					"Clicked successfully", "Failed to click", "Exception caught on click");
		}
	}

	@And("^Click on the Signin button$")
	public void click_signin() throws Throwable {

		fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("Signin")),
				"Wait for signin button to be enabled", "Button is enabled", "Button is disabled");
		fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("Signin")), "Click on signin Button",
				"Clicked successfully", "Failed to click", "Exception caught on click");
	}

	@Then("^open new window and verify if in new session NIS is logged out$")
	public void open_newWindow() throws Throwable {

		ChromeDriver driver2 = new ChromeDriver();
		((JavascriptExecutor) driver2).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver2.getWindowHandles());
		driver2.switchTo().window(tabs.get(1));
		driver2.get("http://mymis.geminisolutions.in/");
		if (driver2.findElementByXPath("//input[@type='button' and @id='btnLogin']") != null) {
			fn_add_pass_step("Verify MIS is logged out in new session", "MIS is logged out in new session");
		} else {
			fn_add_fail_step("Verify MIS is logged out in new session", "MIS is logged in in new session");
		}

		driver2.close();
		driver2.quit();
	}
	
	

	public void MIS_resetPsswrd(String Steps, String username, String newPassword) throws IOException, Throwable {

		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("password")), "Object exists",
				"Verify MIS >> Reset Password >> Reset Password field object exists", "Failed")) {
			fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("password")), newPassword,
					"Verify input entered successfully in Password field", "Password entered successfully",
					"Failed to enter Password", "Exception occured while entering password");
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("password")));
			Thread.sleep(3000);
		}

		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("cpassword")), "Object exists",
				"Verify MIS >> Confirm Password >> Confirm Password field object exists", "Failed")) {
			fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("cpassword")), newPassword,
					"Verify input entered successfully in confirm Password field",
					"Confirm Password entered successfully", "Failed to enter Confirm Password",
					"Exception occured while entering confirm password");
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("cpassword")));
			Thread.sleep(3000);
		}

		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("submit")), "Object exists",
				"Verify MIS >> LOG IN >> Submit field object exists", "Failed")) {
			fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("submit")), newPassword,
					"Verify input entered successfully in confirm Password field",
					"Confirm Password entered successfully", "Failed to enter Confirm Password",
					"Exception occured while entering confirm password");
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("submit")));
			Thread.sleep(3000);
		}

		enter_userName(username);
		enter_password(newPassword);
		click_on_Signin_button();
		

	}
	
}
