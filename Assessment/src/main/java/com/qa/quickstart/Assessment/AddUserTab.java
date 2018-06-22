package com.qa.quickstart.Assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddUserTab {
	
	ChromeDriver myDriver;
	
	@FindBy(id = "firstName")
		private WebElement employeeFirstName;
	
	@FindBy(id = "lastName")
		private WebElement employeeLastName;
	
	@FindBy(id = "employeeId")
		private WebElement employeeId;
	
	@FindBy(id = "chkLogin")
		private WebElement loginBox;
	
	@FindBy(id = "user_name")
		private WebElement userName;
	
	@FindBy(id = "user_password")
		private WebElement passWord;
	
	@FindBy(id = "re_password")
		private WebElement confirmPassword;
	
	@FindBy(id = "btnSave")
		private WebElement saveButton;
	
	public void enterFirstName() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver.exe");
		myDriver = new ChromeDriver();
		Actions action = new Actions(myDriver);
		
		action.moveToElement(employeeFirstName).click().sendKeys("Jarad").perform();
	}
	public void enterLastName() {
		
		Actions action2 = new Actions(myDriver);
		
		action2.moveToElement(employeeLastName).click().sendKeys("Huggard").perform();
	}
	public void clickLogin() {
		
		Actions action3 = new Actions(myDriver);
		action3.moveToElement(loginBox).click().perform();
	}
	public void enterUserName() {
		
		Actions action4 = new Actions(myDriver);
		
		action4.moveToElement(userName).click().sendKeys("huggardjarad").perform();
	}
	public void enterAndConfirmPassword() {
		
		Actions action5 = new Actions(myDriver);
		
		action5.moveToElement(passWord).click().sendKeys("MonkeyBomb1").perform();
		action5.moveToElement(confirmPassword).click().sendKeys("MonkeyBomb1").perform();
	}
	public void clickSave() {
		Actions action6 = new Actions(myDriver);
		action6.moveToElement(saveButton).click().perform();
	}
	
	
}
