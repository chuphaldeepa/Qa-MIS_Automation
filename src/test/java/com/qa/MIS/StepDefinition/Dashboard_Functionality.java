package com.qa.MIS.StepDefinition;

import java.net.InetAddress;

import org.openqa.selenium.By;

import com.qa.MIS.Utils.*;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;




public class Dashboard_Functionality extends CommonFunctions {

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

	@Given("^If User is on MIS Login Page$")
	public void validate_user_is_on_mis_LoginPage() throws Throwable {
		try {
			Hostname = InetAddress.getLocalHost().getHostName();
			configFileReader = new ConfigFileReader();
			testCaseName = this.getClass().getSimpleName().toString();
			 CommonFunctions.fn_add_pass_step(testCaseName,
					  "The script is running in the Host Name" + CommonFunctions.NextLine +
					  Hostname);
			driverPath = configFileReader.getConfigProperty("chromedriverpath");
			URL = configFileReader.getConfigProperty("AppURL");
			CommonFunctions.fn_LaunchBrowser("Chrome", driverPath, URL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("Username")), "Open MIS Login Page",
				"Launched MIS Login Page successfully", "Failed to launch MIS Login Page");
	}

	@When("^login with credentials as (.*) and (.*)$")
	public void fn_Generic_login(String username, String password) throws Throwable {

		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("Username")))) {
			fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("Username")), username);
		}

		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("Password")))) {
			fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("Password")), password);

		}
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("signIn")), "Verify Signin button",
				"Signin button is present", "Signin button not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("signIn")),
					"Wait for Signin button to be enabled", "Button is enabled", "Button is disabled");
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("signIn")), "Click on Signin Button",
					"Clicked successfully", "Failed to click", "Exception caught on click");
			Thread.sleep(2000);
		}
	}

	@Then("^Click user dropdown$")
	public void click_on_user_dropdown() throws Throwable {
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("userDropdown")),
				"Verify User dropdown button", "User dropdown button is present", "User dropdown button not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("userDropdown")),
					"Wait for User dropdown button to be enabled", "Button is enabled", "Button is disabled");

			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("userDropdown")),
					"Click on User dropdown Button", "Clicked successfully", "Failed to click",
					"Exception caught on click");

		}
		
	}
		@And("^Click user profile$")
		public void click_on_user_profile() throws Throwable {
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("profile")), "Verify Profile button",
				"Profile button is present", "Profile button not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("profile")),
					"Wait for Profile button to be enabled", "Button is enabled", "Button is disabled");

			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("profile")), "Click on Profile Button",
					"Clicked successfully", "Failed to click", "Exception caught on click");

		}

	}

	@When("^Update profile picture as (.*)$")
	public void update_profile_pic(String profilePicture) throws Throwable {
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("profilePic")),
				"Verify user profile pic field is present", "user profile pic field is present",
				"user profile pic field is not present")) {
			/*
			 * fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.
			 * getElementLocatorProperty("profilePic")),
			 * "Wait for user profile pic field to be enabled", "Field is enabled",
			 * "Field is disabled");
			 */
			Thread.sleep(1000);

			fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("profilePic")), profilePicture,
					"Enter username in Textbox", "Input entered successfully", "Failed to enter username",
					"Exception caught while uploading user profile picture");
			Thread.sleep(1000);
		}

	}

	@When("^Enter invalid number as (.*)$")
	public void enter_wrongContact(String wrongContact) throws InterruptedException {
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("contactNo")),
				"Verify contact number field is present"
				, "contact number field is present",
				"contact number field is not present")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("contactNo")),
					"Wait for contact number field to be enabled", "Field is enabled", "Filed is disabled");

			fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("contactNo")), wrongContact,
					"Enter contact number in Textbox", "Input entered successfully", "Failed to enter username",
					"Exception caught while entering contact number");
			Thread.sleep(1000);

		}
	}

	@Then("^Verify Contact nunber is valid$")
	public void update_contactNo() throws Throwable {

		fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("updtusrbtn")), "Click on Update Profile Button",
				"Clicked successfully", "Failed to click", "Exception caught on click");

		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("okWarning")),
				"Verfiy mobile no should conatin 10 digits", "mobile no should conatin 10 digits",
				"mobile no can be of any length")) {

			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("okWarning")), "Click on OK Button",
					"Clicked successfully", "Failed to click", "Exception caught on click");
			Thread.sleep(500);
		}

	}

	@And("^Enter vaild number as (.*)$")
	public void update_contactNo(String correctContact) throws InterruptedException {

		fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("contactNo")), correctContact,
				"Enter contact number in Textbox", "Input entered successfully", "Failed to enter username",
				"Exception caught while entering contact number");
		Thread.sleep(1000);

	}

	@And("^Update extn as (.*)$")
	public void update_extNo(String extnNumber) throws Throwable {
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("extnNo")),
				"Verfiy extension number field is visible", "extension number field is visible",
				"extension number field is not visible")) {

			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("extnNo")),
					"Wait for contact number field to be enabled", "Field is enabled", "Filed is disabled");
			fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("extnNo")), extnNumber,
					"Enter extension number in Textbox", "Input entered successfully", "Failed to enter extn",
					"Exception caught while entering extension number");
			Thread.sleep(1000);
		}
	}

	@When("^update user address by clicking update address button$")
	public void update_address() throws Throwable {
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("chgaddrs")),
				"Verfiy Change address field is visible", "Change address field is visible",
				"Change address field is not visible")) {
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("chgaddrs")), "Click on Change address",
					"Clicked successfully", "Failed to click", "Exception caught on click");
		}
	}

	@Then("^update country as (.*)$")
	public void update_country_(String Country) throws Throwable {
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("countryArrow")),
				"Verfiy Change address field is visible", "Change address field is visible",
				"Change address field is not visible")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("countryArrow")),
					"Wait for Country field to be enabled", "Field is enabled", "Filed is disabled");
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("countryArrow")), "Click on Country",
					"Clicked successfully", "Failed to click", "Exception caught on click");

			fn_selectFromDropdownByVisibleText(By.xpath(ConfigFileReader.getElementLocatorProperty("countryBox")),
					Country, "verify Counrty is selected", "value Seleceted successfully", "Failed to to select value");
		}
	}

			
			@Then("^update state as (.*)$")
			public void update_state(String State) throws Throwable {
			if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("stateArrow")),
					"Verfiy state field is visible", "state field is visible", "state  field is not visible")) {
				fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("stateArrow")), "Click on state field",
						"Clicked successfully", "Failed to click", "Exception caught on click");

				fn_selectFromDropdownByVisibleText(By.xpath(ConfigFileReader.getElementLocatorProperty("stateBox")),
						State, "verify State is selected", "value Seleceted successfully", "Failed to to select value");
			}

		}
	

	@And("^update city as (.*)$")
	public void update_city(String City) throws Throwable {
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("cityArrow")),
				"Verfiy city field is visible", "city field is visible", "state  field is not visible")) {
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("cityArrow")), "Click on state field",
					"Clicked successfully", "Failed to click", "Exception caught on click");

			fn_selectFromDropdownByVisibleText(By.xpath(ConfigFileReader.getElementLocatorProperty("cityBox")), City,
					"verify State is selected", "value Seleceted successfully", "Failed to to select value");
		}
	}
		@And("^update pincode as (.*)$")
		public void update_pincode(String Pincode) throws Throwable {
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("pincode")),
				"Verfiy pincode is visible", "pincode field is visible", "pincode  field is not visible")) {

			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("pincode")),
					"Wait for pincode field to be enabled", "Field is enabled", "Filed is disabled");
			fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("pincode")), Pincode, "Enter pincode in Textbox",
					"Input entered successfully", "Failed to enter pincode", "Exception caught while entering pincode");
		}

	}

	@Then("^Update present address as (.*)$")
	public void update_present_address(String presetAddress) throws Throwable {
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("prsntadd")),
				"Verfiy present address is visible", "present address field is visible",
				"present address  field is not visible")) {

			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("prsntadd")),
					"Wait for present address field to be enabled", "Field is enabled", "Filed is disabled");
			fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("prsntadd")), presetAddress,
					"Enter present address in Textbox", "Input entered successfully", "Failed to enter pincode",
					"Exception caught while entering present address");
			//fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("okButton")));
		}
	}

	@And("^Update address details$")
	public void update_address_details() throws Throwable {
		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("updtaddbtn")),
				"Verfiy update address is visible", "update address field is visible",
				"update address  field is not visible")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("updtaddbtn")),
					"Wait for update address field to be enabled", "Field is enabled", "Filed is disabled");
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("updtaddbtn")), "Click on Country",
					"Clicked successfully", "Failed to click", "Exception caught on click");
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("okButton")),
					"Wait for update address field to be enabled", "Field is enabled", "Filed is disabled");
			Thread.sleep(1000);

			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("okButton")), "Click on Country",
					"Clicked successfully", "Failed to click", "Exception caught on click");
			Thread.sleep(1000);
		}
	}

	@When("^update pasword by clicking on update password button$")
	public void update_password() throws Throwable {

		if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("chngPasswrd")),
				"Verfiy change password is visible", "change password field is visible",
				"change password  field is not visible")) {
			fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("chngPasswrd")),
					"Wait for change password field to be enabled", "Field is enabled", "Filed is disabled");
			fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("chngPasswrd")), "Click on change password",
					"Clicked successfully", "Failed to click", "Exception caught on click");

		}
	}

	@Then("^Enter details as (.*) and (.*)$")
				public void enter_old_and_new_password(String oldPassword, String newPassword) throws Throwable{
					if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("oldpsswrd")),
							"Verfiy old password is visible", "old password field is visible",
							"old password  field is not visible")) {
						fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("oldpsswrd")),
								"Wait for old password field to be enabled", "Field is enabled", "Filed is disabled");
						fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("oldpsswrd")), oldPassword,
								"Enter old password in Textbox", "Input entered successfully", "Failed to enter old password",
								"Exception caught while entering  old password");
						
						if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("newPsswrd")),
								"Verfiy new password is visible", "new password field is visible",
								"old password  field is not visible")) {
							fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("newPsswrd")),
									"Wait for new password field to be enabled", "Field is enabled", "Filed is disabled");
							fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("newPsswrd")), newPassword,
									"Enter new password in Textbox", "Input entered successfully", "Failed to enter new password",
									"Exception caught while entering  new password");
					
				}
				}
	}

				@Then("^Confirm password as (.*)$")
				public void confirm_new_password(String confirmPassword) throws Throwable{
						
						if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("confrmPsswrd")),
								"Verfiy confirm password is visible", "confirm password field is visible",
								"confirm password  field is not visible")) {
							fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("confrmPsswrd")),
									"Wait for confirm password field to be enabled", "Field is enabled", "Filed is disabled");
							fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("confrmPsswrd")), confirmPassword,
									"Enter confirm password in Textbox", "Input entered successfully", "Failed to enter confirm password",
									"Exception caught while entering  confirm password");
						
					}
					}

				

				
				@And("^Update passwordand login again as (.*) and (.*)$")
				public void click_update_password(String username, String password)throws Throwable{
					
					if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("updtPsswrdBtn")),
							"Verfiy update password is visible", "update password field is visible",
							"update password  field is not visible")) {
						fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("updtPsswrdBtn")),
								"Wait for update password field to be enabled", "Field is enabled", "Filed is disabled");
						fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("updtPsswrdBtn")), "Click on update password",
								"Clicked successfully", "Failed to click", "Exception caught on click");
					Thread.sleep(1000);
			/*
			 * if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty(
			 * "warning1")))){ fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.
			 * getElementLocatorProperty("warning1")));
			 * fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("warning1")));
			 * Thread.sleep(1000); System.out.println("Please enter valid old password");
			 * fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("oldpsswrd")),
			 * oldPassword);
			 * 
			 * System.out.println("Correct old password entered successfully");
			 * Thread.sleep(1000);
			 * fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("updtPsswrdBtn")
			 * ));
			 * 
			 * }
			 */
					if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("Username")))){
				
						fn_Generic_login(username, password);
						Thread.sleep(1000);
			
					}
					}
				}
				
				
				@When("^update dashboard settings by clicking on dashborad settings button$")
				public void update_dashboard_settings() throws Throwable{
					
					if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("userDropdown")),
							"Verfiy user drop down is visible", "user drop down field is visible",
							"user drop down  field is not visible")) {
						fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("userDropdown")),
								"Wait for user drop down field to be enabled", "Field is enabled", "Filed is disabled");
						
						fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("userDropdown")), "Click on user drop down",
								"Clicked successfully", "Failed to click", "Exception caught on click");
						Thread.sleep(1000);
						if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("Skills")),
								"Verfiy skills is visible", "user skills field is visible",
								"skills  field is not visible")) {
							fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("Skills")),
									"Wait for skills field to be enabled", "Field is enabled", "Filed is disabled");
							
							fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("Skills")), "Click on skills",
									"Clicked successfully", "Failed to click", "Exception caught on click");
							Thread.sleep(1000);
						}
					}
				}
							
							@Then("^Enter Technology and proficiency level as (.*) and (.*)$")
							public void enter_technology_and_pofLevel(String Technology, String proficiency_Level) throws Throwable{
							
							if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("techArrow")),
									"Verfiy skills is visible", "user skills field is visible",
									"skills  field is not visible")) {
									fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("techArrow")),
										"Wait for skills field to be enabled", "Field is enabled", "Filed is disabled");
								fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("technologyBox")),
										"Wait for skills field to be enabled", "Field is enabled", "Filed is disabled");
								
								fn_selectFromDropdownByVisibleText(By.xpath(ConfigFileReader.getElementLocatorProperty("technologyBox")), Technology,
										"verify Technology is selected", "value Seleceted successfully", "Failed to to select value");
								Thread.sleep(1000);
								
								if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("proficiencyLevel")),
										"Verfiy proficiency Level is visible", "user proficiency Level field is visible",
										"proficiency Level  field is not visible")) {
									fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("proficiencyLevel")),
											"Wait for proficiency Level field to be enabled", "Field is enabled", "Filed is disabled");
								
									
									fn_selectFromDropdownByVisibleText(By.xpath(ConfigFileReader.getElementLocatorProperty("proficiencyLevel")), proficiency_Level,
											"verify proficiency Level is selected", "value Seleceted successfully", "Failed to to select value");
									Thread.sleep(1000);
									
								}
							}
							
							}
							
							@Then("^Enter skill type and experience in months as (.*) and (.*)$")
							public void enter_skilltype_and_expinmonths(String skill_type, String expINmonths ) throws Throwable{
									if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("skillType")),
											"Verfiy skill type is visible", "user skill type field is visible",
											"skill type  field is not visible")) {
										fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("skillType")),
												"Wait for skill type field to be enabled", "Field is enabled", "Filed is disabled");
									
										
										fn_selectFromDropdownByVisibleText(By.xpath(ConfigFileReader.getElementLocatorProperty("skillType")), skill_type,
												"verify skill type is selected", "value Seleceted successfully", "Failed to to select value");
										Thread.sleep(1000);
										
										if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("expInMonths")),
												"Verfiy exp in months is visible", "field is visible",
												"field is not visible")) {
											fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("expInMonths")),
													"Wait for exp in months field to be enabled", "Field is enabled", "Filed is disabled");
											fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("expInMonths")), expINmonths,
													"Enter exp in months in Textbox", "Input entered successfully", "Failed to enter confirm password",
													"Exception caught while entering  exp in months");
										
									}
										
									}
								
									}
					
					

				
						

					
					

							@And("^save skills as (.*)$")
							public void save_skills(String Technology ) throws Throwable{
								
								if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("saveSkills")),
										"Verfiy save skills is visible", "field is visible",
										"field is not visible")) {
									fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("saveSkills")),
											"Wait for save skiils field to be enabled", "Field is enabled", "Filed is disabled");
						
									fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("saveSkills")), "Click on skills",
											"Clicked successfully", "Failed to click", "Exception caught on click");
									if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("warningSkills")))) {
										
										fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("warningSkills")));
										fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("Ok")));
										fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("technologyBox")));
										fn_selectFromDropdownByVisibleText(By.xpath(ConfigFileReader.getElementLocatorProperty("technologyBox")), Technology,
												"verify Technology is selected", "value Seleceted successfully", "Failed to to select value");
										fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("saveSkills")));
										fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("saveSkills")));
										fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("Ok")));
										fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("Ok")));
						}
						
						else {
							fn_waitUntilElementEnabled(By.xpath(ConfigFileReader.getElementLocatorProperty("Ok")));
							fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("Ok")));
					}
					}
				}
							
							@When("^Click user drop down$")
							public void mis_Logout() throws Throwable{
								
								if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty("userDropdown")),
										"Verfiy user drop down is visible", "user drop down field is visible",
										"user drop down  field is not visible")) {
									Thread.sleep(1000);
									
									fn_click(By.xpath(ConfigFileReader.getElementLocatorProperty("userDropdown")), "Click on user drop down",
											"Clicked successfully", "Failed to click", "Exception caught on click");
									Thread.sleep(1000);
									
								}
							}
									
									@Then("^Click logout$")
									public void click_Signout() throws Throwable{
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
									@Then("^closing browser$")
									public void fn_close_browser() throws Throwable{
										fn_CloseBrowser();

										}

							
							}

