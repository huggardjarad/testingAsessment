package com.qa.quickstart.Assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage {

	ChromeDriver myDriver;
	
	ExtentReports report;
	
	@FindBy(id ="txtUsername")
		private WebElement homeUsername;
	
	@FindBy(id ="txtPassword")
		private WebElement homePassword;
	
	@FindBy(id ="btnLogin")
		private WebElement loginButton;
	
	public void goToURL() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver.exe");
		
		myDriver = new ChromeDriver();
		
		report = new ExtentReports("C:\\Users\\Admin\\Reports\\AssessmentReport.html", false);
		
		String url = "http://opensource.demo.orangehrmlive.com/index.php";
		
		ExtentTest test = report.startTest("going to Homepage");
		
		myDriver.manage().window().maximize();
		
		test.log(LogStatus.INFO, "Browser Started");
		
		myDriver.navigate().to(url);
		
		test.log(LogStatus.INFO, "URL Found");
		
		Actions action = new Actions(myDriver);
		
		action.moveToElement(homeUsername).click().sendKeys("Admin").perform();
		action.moveToElement(homePassword).click().sendKeys("admin").perform();
		action.moveToElement(loginButton).click().perform();
		report.endTest(test);
		report.flush();
	}
	
}
