package com.qa.quickstart.Assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class Users {

	ChromeDriver myDriver;
	
	@FindBy(xpath = "//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]")
		private WebElement userNameBox; 
	
	public void gotoUsersTab() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver.exe");
		myDriver = new ChromeDriver();
		
		String url = "http://opensource.demo.orangehrmlive.com/index.php/admin/viewSystemUsers";
		
		myDriver.manage().window().maximize();
		myDriver.navigate().to(url);
	}
}
