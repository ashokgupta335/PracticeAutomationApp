package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	public  By clickOnmyAccountLoc = By.xpath("//a[text()='My Account']");
	public  By demoSiteLoc = By.linkText("Demo Site");
	private WebDriver driver;
	
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public  void clickOnMyAccount()
	{
		driver.findElement(clickOnmyAccountLoc).click();;
	}

	public  void clickOnDemosite() {
		
		driver.findElement(demoSiteLoc).click();
		
	}

}