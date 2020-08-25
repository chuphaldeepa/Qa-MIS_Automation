package com.qa.MIS.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
import com.qa.MIS.GlobalVariables.GlobalVariables;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.Scenario;


/**
 * 
 * @author ak.khattar
 *
 */

public class CommonFunctions extends GlobalVariables {

	// Variable

	public static String Hostname;
	public static String NextLine = "<br>";
	public static String BlueBold_Start = "<B><font color=\"Blue\">";
	public static String BlueBold_End = "</font></B>";
	public static String BlueNormal_Start = "<font color=\"Blue\">";
	public static String BlueNormal_End = "</font>";

	// Launch the Application in the desired Browser
	public static void fn_LaunchBrowser(String Browser, String driverpath, String URL) throws IOException {
		try {
			if (Browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", driverpath);
				driver = new ChromeDriver();
			} else if (Browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", driverpath);
				driver = new FirefoxDriver();
				driver.get(URL);
			} else if (Browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", driverpath);
				driver = new InternetExplorerDriver();
				driver.get(URL);
			}
		} catch (Exception e) {
			extentTest.log(LogStatus.FAIL, "Navigate to Application URL", "Failed to launch URL: " + URL);
			e.printStackTrace();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
		extentTest.log(LogStatus.PASS, "Navigate to Applicaion URL",
				"Browser launched and navigated to" + NextLine + BlueNormal_Start + URL + extentTest.addScreenCapture(fn_Capture_getScreen()));
	}

	public static WebDriver getInstance() {
		return driver;
	}
	
	//Genric login
	
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

	// Close Browser
	public static void fn_CloseBrowser() {
		try {
			driver.close();
			driver.quit();
			extentTest.log(LogStatus.PASS, "Close the Browser", "Browser is closed successfully");
		} catch (Exception e) {
			extentTest.log(LogStatus.FAIL, "Close the Browser", "Failed to close the Browser");
		}
	}

	// Genric function to login into MIS
	/*
	 * public void fn_Generic_login(String username, String password) throws
	 * Throwable {
	 * 
	 * if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty(
	 * "Username")))) {
	 * fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("Username")),
	 * username); }
	 * 
	 * if (fn_isElementFound(By.xpath(ConfigFileReader.getElementLocatorProperty(
	 * "Password")))) {
	 * fn_type(By.xpath(ConfigFileReader.getElementLocatorProperty("Password")),
	 * password); }
	 * 
	 * }
	 */

	// Get the current date
	public static String fn_GetDateTime() {
		// Get the current system date
		String Current_Date = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ssaa").format(Calendar.getInstance().getTime());
		return Current_Date;
	}

	// Get the current date
	public static String fn_GetDate() {
		// Get the current system date
		String Current_Date = new SimpleDateFormat("M-d-yyyy").format(Calendar.getInstance().getTime());
		return Current_Date;
	}

	// Get the time
	public static String fn_GetTime() {
		// Get the current system date
		String Current_Time = new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime());
		return Current_Time;

	}

	// Description: Capture screenshot
	public static String fn_Capture_getScreen() throws IOException {
		String screenShotName = System.getProperty("user.dir") + "/Reports/" + fn_GetDate() + "/screenShot/" + fn_GetDateTime() + ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(screenShotName));
		return screenShotName;
	}

	// Description: Create and add System information in extent report
	public static void fn_create_extent_report() {
		String report_Path = "/Reports/" + fn_GetDate() + "/" + fn_GetDateTime() + ".html";
		// String report_Path="/Reports/"+ fn_GetDate() + "/" + fn_GetDate()+ ".html";
		extentReport = new ExtentReports(System.getProperty("user.dir") + report_Path, true);
		extentReport.addSystemInfo("Machine", "Windows 10" + "64 Bit");
		extentReport.addSystemInfo("Selenium", "3.7.0");
		extentReport.addSystemInfo("Maven", "3.5.2");
		extentReport.addSystemInfo("Java Version", "1.8.0_151");
		extentReport.loadConfig(new File(System.getProperty("user.dir") + "/Config/Report.xml"));
	}

	// Description: this method will run after every scenario and will capture
	// screenshot on failure
	public static void fn_after_Scenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				File sourcePath = new File(fn_Capture_getScreen());
				File destinationPath = new File(System.getProperty("user.dir") + "/Reports/" + fn_GetDate()
						+ "/Screenshots/" + screenshotName + ".png");
				Files.copy(sourcePath, destinationPath);
				// Reporter.addScreenCaptureFromPath(destinationPath.toString());
				extentTest.addScreenCapture(destinationPath.toString());
			} catch (IOException e) {
			}
		}
		// fn_CloseBrowser();
	}
	public static String fn_Capture_getScreenShot() throws IOException {
		String screenShotName = System.getProperty("user.dir") + "/Reports/" + fn_GetDate() + "/screenShot/" + fn_GetDateTime() + ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(screenShotName));
		String link = "</br><a href ="+ screenShotName+"> Screenshot</a>";
		return link;
		
	}

	// Description : log pass step in extent report
	public static void fn_add_pass_step(String step, String description) {
		extentTest.log(LogStatus.PASS, step, description );
	}

	// Description : log fail step in extent report
	public static void fn_add_fail_step(String step, String description) {
		extentTest.log(LogStatus.PASS, step, description);
	}

	// Description : extent report start new test
	public static void fn_extent_start_test(String testName) {
		extentTest = extentReport.startTest(testName);
	}

	// Description: This method clicks on an object specified in the Object
	public static void fn_click(By loc, String PassStep, String PassDescription, String FailStep,
			String FailDescription) {
		try {
			WebElement element = driver.findElement(loc);
			element.click();
			extentTest.log(LogStatus.PASS, PassStep, PassDescription + (fn_Capture_getScreenShot()));
			Thread.sleep(1000);
		} catch (Exception e) {
			extentTest.log(LogStatus.FAIL, FailStep, FailDescription);
		}
	}
	
	public static boolean fn_click(By loc) {
		try {
			WebElement element = driver.findElement(loc);
			element.click();
		
			Thread.sleep(1000);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean fn_isElementFound(By loc, String step, String passDescription, String failDescription) {
		try {
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(loc));
			driver.findElement(loc);
			extentTest.log(LogStatus.PASS, step, passDescription + (fn_Capture_getScreenShot()));
			Thread.sleep(1000);
			return true;
		} catch (Exception e) {
			extentTest.log(LogStatus.FAIL, step, failDescription );
			return false;
		}
	}

	public static boolean fn_isElementFound(By loc, String step, String passDescription) {
		try {
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(loc));
			driver.findElement(loc);
			extentTest.log(LogStatus.PASS, step, passDescription + (fn_Capture_getScreenShot()));
			Thread.sleep(1000);
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	public static boolean fn_isElementFound(By loc) {
		try {
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(loc));
			driver.findElement(loc);
			Thread.sleep(1000);
			return true;
		} catch (Exception e) {

			return false;
		}
	}
	
	
	public boolean clickWebElement(By byLocator, int timeout) {

		boolean isClicked = false;
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(byLocator));
			element = driver.findElement(byLocator);
			if (element.isDisplayed()) {
				element.click();
				isClicked = true;
			} else
				throw new ElementNotVisibleException("Element is not Displayed on page");
		} catch (Exception exception) {
			isClicked = false;
		}
		return isClicked;
	}


	// Description: This method will check if the element is enabled and will
	// click on it
	public static void fn_isEnabled_click(By loc, String step, String passDescription, String failDescription,
			String exceptionDescription) {
		try {
			WebElement element = driver.findElement(loc);
			if (element.isEnabled()) {
				element.click();
				extentTest.log(LogStatus.PASS, step, passDescription + (fn_Capture_getScreenShot()));
				Thread.sleep(1000);
			} else {
				extentTest.log(LogStatus.FAIL, step, failDescription);
			}
		} catch (Exception e) {
			extentTest.log(LogStatus.FAIL, step, exceptionDescription);
		}
	}

	// Description: this method will compare two strings
	public void fn_compare_strings(By loc, String expected, String step, String passDescription, String failDescription,
			String exceptionDescription) {
		try {
			WebElement element = driver.findElement(loc);
			Boolean result = false;
			String actual = element.getText();
			if (actual.equalsIgnoreCase(expected)) {
				result = true;
				if (result == true) {
					extentTest.log(LogStatus.PASS, step, passDescription + (fn_Capture_getScreenShot()));
				} else {
					extentTest.log(LogStatus.FAIL, step, failDescription);
				}
			}
		} catch (Exception e) {
			extentTest.log(LogStatus.FAIL, step, exceptionDescription);
		}
	}

	// Description: move to element if the element isDisplayed
	public void fn_moveToElement(By loc, String step, String passDescription, String failDescription,
			String exceptionDescription) {
		WebElement element = driver.findElement(loc);
		try {
			Actions action = new Actions(driver);
			if (element.isDisplayed()) {
				action.moveToElement(element).perform();
				Thread.sleep(2000);
				extentTest.log(LogStatus.PASS, step, passDescription + (fn_Capture_getScreenShot()));
			} else {
				extentTest.log(LogStatus.FAIL, step, failDescription);
			}
		} catch (Exception e) {
			extentTest.log(LogStatus.FAIL, step, exceptionDescription);
		}
	}

	// Description: This method will get Page title
	public void fn_getTitle(String expected, String step, String passDescription, String failDescription,
			String exceptionDescription) {
		try {
			Thread.sleep(2000);
			if (driver.getTitle().contains(expected)) {
				extentTest.log(LogStatus.PASS, step, passDescription + (fn_Capture_getScreenShot()));
			} else {
				extentTest.log(LogStatus.FAIL, step,
						failDescription + BlueNormal_Start + driver.getTitle() + "</br>Expected: " + expected);
			}
		} catch (Exception e) {
			extentTest.log(LogStatus.FAIL, step, exceptionDescription);
		}
	}

	public void fn_type(By loc, String value, String step, String passDescription, String failDescription,
			String exceptionDescription) {
		try {
			WebElement element = driver.findElement(loc);
			element.clear();
			element.sendKeys(value);
			if (element.isEnabled() == true) {
				extentTest.log(LogStatus.PASS, step, passDescription + (fn_Capture_getScreenShot()));
			} else {
				extentTest.log(LogStatus.FAIL, step, failDescription);
			}
		} catch (Exception e) {
			extentTest.log(LogStatus.FAIL, step, exceptionDescription);
		}
	}

	public void fn_type(By loc, String value) {
		try {
			WebElement element = driver.findElement(loc);
			element.clear();
			element.sendKeys(value);

		} catch (Exception e) {

		}
	}

	public static boolean fn_type_if_isElementFound(By loc, String value, String step, String passDescription,
			String failDescription) {
		try {
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(loc));
			WebElement element = driver.findElement(loc);
			element.clear();
			element.sendKeys(value);
			if (element.isEnabled() == true) {
				extentTest.log(LogStatus.PASS, step, passDescription + (fn_Capture_getScreenShot())) ;
				Thread.sleep(1000);
				return true;
			} else {
				extentTest.log(LogStatus.FAIL, step, failDescription);
				return false;
			}
		} catch (Exception e) {
			extentTest.log(LogStatus.FAIL, step, failDescription);
			return false;
		}
	}
	
	public  void  fn_selectFromDropdownByVisibleText(By loc, String value, String step, String passDescription,
			String failDescription) {
		try {
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(loc));
			WebElement element = driver.findElement(loc);
			Select s = new Select(element);
			// System.out.println("DD values:" + s);
			s.selectByVisibleText(value);
			if (element.isEnabled() == true) {
				extentTest.log(LogStatus.PASS, step, passDescription + (fn_Capture_getScreenShot()));
				
			} else {
				extentTest.log(LogStatus.FAIL, step, failDescription);
				
			}
		} catch (Exception e) {
			extentTest.log(LogStatus.FAIL, step, failDescription);
			
		}
			
	}
	
	/*
	 * public void selectFromDropdownByVisibleText(By loc, String value, String
	 * methodname, String description, String steps) { try { WebElement element =
	 * driver.findElement(loc); Select s = new Select(element); //
	 * System.out.println("DD values:" + s); s.selectByVisibleText(value); if
	 * (element.isEnabled() == true) { status = "PASS";
	 * ReporterHandler.appendrow(methodname, status, description, steps, getTime(),
	 * getScreenShot("")); } else { status = "FAIL";
	 * ReporterHandler.writeFailInReport(methodname, status, description,
	 * "Failed to select", getScreenShot("")); } } catch (Exception e) {
	 * catchBlock(); } }
	 */

	public void fn_waitUntilElementEnabled(By loc, String step, String passDescription, String failDescription) {
		try {
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(loc));
			extentTest.log(LogStatus.PASS, step, passDescription + (fn_Capture_getScreenShot()));
		} catch (Exception e) {
			extentTest.log(LogStatus.FAIL, step, failDescription);
		}
	}

	public void fn_waitUntilElementEnabled(By loc) {
		try {
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(loc));
		} catch (Exception e) {

		}
	}

}
