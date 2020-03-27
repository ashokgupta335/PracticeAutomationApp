package com.cts.stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cts.base.LaunchingWebBrowser;
import com.cts.pages.DemositePage;
import com.cts.pages.HomePage;
import com.cts.utils.ReadExcel;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

	WebDriver driver;
	
	@After
	public void afterScenario() {
		LaunchingWebBrowser launch = new LaunchingWebBrowser(driver);
		
		//closing the browser
		launch.tearDown();

	}
	@Given("User launch the browser with practiceautomationtestingPage")
	public void user_launch_the_browser_with_practiceautomationtestingPage() {
		LaunchingWebBrowser launch = new LaunchingWebBrowser(driver);
		
		//Launching browser with required website
		driver = launch.setUp();
		driver.get("http://practice.automationtesting.in/");
		HomePage home = new HomePage(driver);
		
		//click on demosite
		home.clickOnDemosite();
	}

	@When("I fill the form by using below data")
	public void i_fill_the_form_by_using_below_data(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		
		DemositePage demo = new DemositePage(driver);
		List<Map<String, String>> data = dataTable.asMaps();
		
		//filling registration form
		demo.formFilling(data.get(0).get("firstName"), data.get(0).get("lastName"),
				data.get(0).get("address"), data.get(0).get("email"), data.get(0).get("number"),
				data.get(0).get("skill"), data.get(0).get("workCountry"), data.get(0).get("presentCountry"),
				data.get(0).get("birthYear"), data.get(0).get("birthMonth"), data.get(0).get("birthDay"),
				data.get(0).get("password"), data.get(0).get("confirmPassword"));

	}

	@Then("Assert for the firstname text box")
	public void assert_for_the_firstname_text_box() {

		DemositePage demo = new DemositePage(driver);
		
		//Getting text from first name box
		String actual = demo.afterRefresh();
		System.out.println(actual);
		
		//Asserting first name text box
		Assert.assertTrue(actual.contentEquals(""));

	}

	@Then("I should get a page with {string} title")
	public void i_should_get_a_page_with_title(String expected) {

		DemositePage demo = new DemositePage(driver);
		
		//Getting current page title
		String actual = demo.getTitleOfPage();
		
		//Asserting page title
		Assert.assertTrue(actual.equals(expected));
		System.out.println("Passed");

	}

	@When("I hover to widgets and click on AutoComplete and filled the two country names as {string} and {string}")
	public void i_hover_to_widgets_and_click_on_AutoComplete_and_filled_the_two_country_names_as_and(String country1,
			String country2) {

		DemositePage demo = new DemositePage(driver);
		
		//Auto completing the country names
		demo.clickOnAutoComplete(country1, country2);

	}

	@When("I hover to more and click on modals")
	public void i_hover_to_more_and_click_on_modals() {

		DemositePage demo = new DemositePage(driver);
		
		//Launching modals page
		demo.clickOnModals();

	}

	@Then("the box should contains the given two country names")
	public void the_box_should_contains_the_given_two_country_names() {

		DemositePage demo = new DemositePage(driver);
		
		//Asserting one of the auto filled country name
		Assert.assertTrue((demo.getFilledCountryName()).contains("India"));

	}

	@When("I hover to video and click vimeo and click on video screen")
	public void i_hover_to_video_and_click_vimeo_and_click_on_video_screen() {

		DemositePage demo = new DemositePage(driver);
		
		//Playing a video
		demo.clickOnVimeo();

	}

	@Then("Video should play")
	public void video_should_play() {

		
		//Taking a screenshot of video while playing
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		file.renameTo(new File("src/test/resources/screenshot/video.png"));
		System.out.println("Passed");

	}

	@When("I hover to switchTo and click on alerts")
	public void i_hover_to_switchTo_and_click_on_alerts() {

		DemositePage demo = new DemositePage(driver);
		
		//Getting alert
		demo.clickOnAlerts();
		

	}

	@Then("I should get a alert")
	public void i_should_get_a_alert() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		//Wait for the alert presence
		wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue((driver.switchTo().alert().getText()).contains("alert"));
		
		//Printing alert message
		System.out.println(driver.switchTo().alert().getText());
		
		//Accepting alert
		driver.switchTo().alert().accept();

	}
	
	@When("I click on home and enter wrong sign in details from excel {string} with sheetname as {string}")
	public void i_click_on_home_and_enter_wrong_sign_in_details_from_excel_with_sheetname_as(String location, String sheetName) throws IOException {
	   
		DemositePage demo = new DemositePage(driver);
		
		//Converting excel data to array
		String[][] data = ReadExcel.getSheetIntoStringArray(location,sheetName);
		
		//Filling sign in details using excel
		demo.clickOnSignin(data[0][0], data[0][1]);
		
		
	}

	@Then("I will get a error message")
	public void i_will_get_a_error_message() {
		DemositePage demo = new DemositePage(driver);
		
		//Asserting the error message
		Assert.assertTrue(demo.getErrorMsg().equalsIgnoreCase("invalid user name or password"));
		
		//Printing error message
		System.out.println(demo.getErrorMsg());
		
	}
	

}