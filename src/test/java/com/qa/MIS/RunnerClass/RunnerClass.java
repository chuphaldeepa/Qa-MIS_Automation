package com.qa.MIS.RunnerClass;

import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.collections.Lists;

import com.qa.MIS.GlobalVariables.GlobalVariables;
import com.qa.MIS.Utils.CommonFunctions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
/**
 * 
 * @author ak.khattar
 *
 */
@CucumberOptions(
		//features = "src/test/java/Features/Leave_Management.feature",
		features = { "src/test/java/Features" },
		glue = { "com.qa.MIS.StepDefinition" }, plugin = {
				"pretty" }, monochrome = true)

public class RunnerClass extends AbstractTestNGCucumberTests {
	
	
	public static void main(String[] args) {
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();

		String testNGXML = "TestNGXML/TestNg.xml";
		suites.add(testNGXML);
		testng.setTestSuites(suites);
		testng.run();
	}

	@BeforeSuite
	public static void setup() {
		CommonFunctions.fn_create_extent_report();
	}

	@AfterSuite
	public void endReport() {
		// In after suite stopping the object of ExtentReports and ExtentTest
		GlobalVariables.extentReport.endTest(GlobalVariables.extentTest);
		GlobalVariables.extentReport.flush();
		CommonFunctions.fn_CloseBrowser();
	}
	
}
