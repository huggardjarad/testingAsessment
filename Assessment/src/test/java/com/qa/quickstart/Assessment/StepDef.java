package com.qa.quickstart.Assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {

	WebDriver myDriver;
	ExtentReports report;
	
	@Given("^the Add Employee Tab$")
	public void goToAddEmployeeTab() {
		HomePage home = PageFactory.initElements(myDriver, HomePage.class);
		home.goToURL();
	
		
		myDriver = new ChromeDriver();
		report = new ExtentReports("C:\\Users\\Admin\\Reports\\AssessmentReport.html", false);
		ExtentTest test = report.startTest("Going to AddUser Tab");
		
		AddaUser addEmployee = PageFactory.initElements(myDriver, AddaUser.class);
		
		addEmployee.goToAddEmployeeTab();
		try {
			assertEquals("http://opensource.demo.orangehrmlive.com/index.php/pim/addEmployee", myDriver.getCurrentUrl());
			test.log(LogStatus.PASS, "Navigated to Correct Page");
			
		}catch(AssertionError e) {
			test.log(LogStatus.FAIL, "Could not go to correct page");
		}finally {
			test.log(LogStatus.INFO, "Navigate to Add Employee Tab Test Complete");
			report.endTest(test);
			report.flush();
		}
		
	}
	@When("^I fill out the Employee Details correctly")
	public void fillingOutEmployeeDetails() {
		ExtentTest test2 = report.startTest("Inputting employee details");
		AddUserTab addUser = PageFactory.initElements(myDriver, AddUserTab.class);
		test2.log(LogStatus.INFO, "Inputting Employee details");
		addUser.enterFirstName();
		addUser.enterLastName();
		WebElement firstNameBox = myDriver.findElement(By.id("firstName"));
		
		try {
			assertEquals("Jarad", firstNameBox.getAttribute("value"));
			test2.log(LogStatus.PASS, "Brilliant! Employee details entered correctly");
		}catch (AssertionError e) {
			test2.log(LogStatus.FAIL, "Bad Luck!, Details not filled out correctly");
		}finally {
			test2.log(LogStatus.INFO, "Add Employee details test complete");
			report.endTest(test2);
			report.flush();
		}
	}
		
	@And("^I choose to create Login Details$")
	public void creatingLoginDetails() {
		
		ExtentTest test3 = report.startTest("Inputting user details");
		AddUserTab addUser2 = PageFactory.initElements(myDriver, AddUserTab.class);
		WebElement userNameBox = myDriver.findElement(By.id("user_name"));
		
		addUser2.clickLogin();
	
			try {
			assertTrue(userNameBox.isDisplayed());
			test3.log(LogStatus.PASS, "Identified correctly that user details wish to be created");
			}catch (AssertionError e) {
				test3.log(LogStatus.FAIL, "Bad Luck not identified correctly!");	
			}finally {
				test3.log(LogStatus.INFO, "Test Complete");
				report.endTest(test3);
				report.flush();
			}
		}
	@And("^I fill out the Login Details correctly$")
	public void fillingLoginDetails () {
		
		ExtentTest test4 = report.startTest("Inputting user details");
		AddUserTab addUser3 = PageFactory.initElements(myDriver, AddUserTab.class);
		WebElement validationError = myDriver.findElement(By.className("formInputText validation-error"));
		
		
		test4.log(LogStatus.INFO, "Creating Username and Password");
		addUser3.enterUserName();
		addUser3.enterAndConfirmPassword();
		try{
			assertFalse(validationError.isDisplayed());
			test4.log(LogStatus.PASS, "Details Entered Correctly");
		}catch(AssertionError e) {
			test4.log(LogStatus.FAIL, "Details entered incorrectly");
		}finally {
			test4.log(LogStatus.INFO, "User creation Test Complete");
			report.endTest(test4);
			report.flush();
		}
		
		
	}
		
	@And("^I click the Save button")
	public void clickingSave() {
		
		ExtentTest test5 = report.startTest("Inputting user details");
		AddUserTab addUser4 = PageFactory.initElements(myDriver, AddUserTab.class);
		
		WebElement validationError = myDriver.findElement(By.className("formInputText validation-error"));
		
		addUser4.clickSave();
		
		try{
			assertFalse(validationError.isDisplayed());
			test5.log(LogStatus.PASS, "Details Entered Correctly");
		}catch(AssertionError e) {
			test5.log(LogStatus.FAIL, "Details entered incorrectly");
		}finally {
			test5.log(LogStatus.INFO, "User creation Test Complete");
			report.endTest(test5);
			report.flush();
		}
				
	}
	@Then("^I can see information about the user$")
	public void seeingInfo() {
		
		ExtentTest test7 = report.startTest("going to users to identify if user has been created");
		Users checkUser = PageFactory.initElements(myDriver, Users.class);
		
		WebElement userNameBox = myDriver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]"));
		
		checkUser.gotoUsersTab();
		
		test7.log(LogStatus.INFO, "going to users tab");
		
		try {
			assertEquals("huggardjarad", userNameBox.getAttribute("value"));
			test7.log(LogStatus.PASS, "Found created user");
		}catch(AssertionError e) {
			test7.log(LogStatus.FAIL, "Could not find User");
		}finally {
			test7.log(LogStatus.INFO, "Test Complete");
			report.endTest(test7);
			report.flush();
		}
		
	}
}
