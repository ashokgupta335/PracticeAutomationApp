package com.cts.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchingWebBrowser {

	private WebDriver driver;
	public LaunchingWebBrowser(WebDriver driver) {
		
		this.driver = driver;
	}
	
		public WebDriver setUp() 
		{
			System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			return driver;
			
		}
		public void tearDown()
		{
			driver.quit();
		}
	
	
}
