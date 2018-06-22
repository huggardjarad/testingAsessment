package com.qa.quickstart.Assessment;

import org.openqa.selenium.chrome.ChromeDriver;




public class AddaUser {

	
ChromeDriver myDriver;
	
	
	
	public void goToAddEmployeeTab() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver.exe");
		myDriver = new ChromeDriver();
		String url = "http://opensource.demo.orangehrmlive.com/index.php/pim/addEmployee";
		
		myDriver.manage().window().maximize();
		myDriver.navigate().to(url);

	}
	
}
