package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DemositePage {
	private  By firstNameLoc = By.xpath("//input[@placeholder='First Name']");
	private  By lastNameLoc = By.xpath("//input[@placeholder='Last Name']");
	private  By addressLoc = By.tagName("textarea");
	private  By emailLoc = By.xpath("//input[@type='email']");
	private  By mobileNumLoc = By.xpath("//input[@type='tel']");
	private  By genderLoc = By.xpath("//input[@value='Male']");
	private  By hobbies_1Loc = By.xpath("//input[@value='Cricket']");
	private  By hobbies_2Loc = By.xpath("//input[@value='Movies']");
	private  By langLoc = By.id("msdd");
	private  By lang_1Loc = By.xpath("//a[text()='Arabic']");
	private  By lang_2Loc = By.xpath("//a[text()='English']");
	private  By skillsLoc = By.id("Skills");
	private  By countriesLoc = By.id("countries");
	private  By countries_1Loc = By.id("country");
	private  By yearLoc = By.id("yearbox");
	private  By monthLoc = By.xpath("//select[@placeholder='Month']");
	private  By dayLoc = By.id("daybox");
	private  By passLoc = By.id("firstpassword");
	private  By confrmPassLoc = By.id("secondpassword");
	private  By refreshLoc = By.xpath("//button[text()='Refresh']");
	private  By switchToLoc = By.linkText("SwitchTo");
	private  By alertsLoc = By.linkText("Alerts");
	private  By widgetsLoc = By.linkText("Widgets");
	private  By autoCompleteLoc = By.linkText("AutoComplete");
	private  By moreEleLoc = By.linkText("More");
	private  By modalsLoc = By.linkText("Modals");
	private  By emptyFirstnameLoc = By.xpath("//input[@placeholder='First Name']");
	private  By searchBoxLoc = By.id("searchbox");
	private  By indiaLoc = By.xpath("//a[text()='India']");
	private  By malaysiaLoc = By.xpath("//a[text()='Malaysia']");
	private  By boxCountry_1Loc = By.xpath("//div[text()='India']");
	private  By videoLoc = By.linkText("Video");
	private  By vimeoLoc = By.xpath("//a[text()='Vimeo']");
	private  By playVideoLoc = By.xpath("//div[@class='play-icon']");
	private  By alertClickLoc = By.xpath("//button[contains(text(),'display an  alert box')]");
	private  By homeLoc = By.linkText("Home");
	private  By signInLoc = By.xpath("//button[text()='Sign In']");
	private  By signInEmailLoc = By.xpath("//input[@placeholder='E mail']");
	private  By signInPasswordLoc = By.xpath("//input[@placeholder='Password']");
	private  By enterLoc = By.xpath("//img[@id='enterbtn']");
	private  By errorMsgLoc = By.xpath("//label[@id='errormsg']");
	private WebDriver driver;
	
	
	public DemositePage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	
	public  void formFilling(String firstName, String lastName, String address, String email,
			String num, String skill, String workCountry, String presentCountry, String birthYear, String birthMonth,
			String birthDay, String password, String confirmPass) {
		driver.findElement(firstNameLoc).sendKeys(firstName);

		driver.findElement(lastNameLoc).sendKeys(lastName);

		driver.findElement(addressLoc).sendKeys(address);

		driver.findElement(emailLoc).sendKeys(email);

		driver.findElement(mobileNumLoc).sendKeys(num);

		driver.findElement(genderLoc).click();

		driver.findElement(hobbies_1Loc).click();

		driver.findElement(hobbies_2Loc).click();

		driver.findElement(langLoc).click();

		driver.findElement(lang_1Loc).click();

		driver.findElement(lang_2Loc).click();

		Select skills = new Select(driver.findElement(skillsLoc));
		skills.selectByVisibleText(skill);

		Select country = new Select(driver.findElement(countriesLoc));
		country.selectByVisibleText(workCountry);

		Select country1 = new Select(driver.findElement(countries_1Loc));
		country1.selectByVisibleText(presentCountry);

		Select year = new Select(driver.findElement(yearLoc));
		year.selectByVisibleText(birthYear);

		Select month = new Select(driver.findElement(monthLoc));
		month.selectByVisibleText(birthMonth);

		Select day = new Select(driver.findElement(dayLoc));
		day.selectByVisibleText(birthDay);

		driver.findElement(passLoc).sendKeys(password);

		driver.findElement(confrmPassLoc).sendKeys(confirmPass);

		driver.findElement(refreshLoc).click();

	}

	public  String getTitleOfPage() {

		return driver.getTitle();

	}

	public  void clickOnAlerts() {

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(switchToLoc)).pause(2000).build().perform();
		driver.findElement(alertsLoc).click();
		action.moveToElement(driver.findElement(alertClickLoc)).pause(2000).click().build().perform();
	}

	public  void clickOnAutoComplete(String country_1, String country_2) {

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(widgetsLoc)).pause(2000).build().perform();
		driver.findElement(autoCompleteLoc).click();
		driver.findElement(searchBoxLoc).sendKeys(country_1);
		driver.findElement(indiaLoc).click();
		driver.findElement(searchBoxLoc).sendKeys(country_2);
		driver.findElement(malaysiaLoc).click();
	}

	public  void clickOnModals() {

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(moreEleLoc)).pause(2000).build().perform();
		driver.findElement(modalsLoc).click();
	}

	public  String afterRefresh() {

		return driver.findElement(emptyFirstnameLoc).getText();

	}

	public  String getFilledCountryName() {

		return driver.findElement(boxCountry_1Loc).getText();

	}

	public  void clickOnVimeo() {

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(videoLoc)).pause(2000).moveToElement(driver.findElement(vimeoLoc)).pause(2000).click().build().perform();

		driver.switchTo().frame("foo");
		action.moveToElement(driver.findElement(playVideoLoc)).click().pause(5000).build().perform();

	}
	
	
	public  void clickOnSignin(String email,String password) {

		driver.findElement(homeLoc).click();
		driver.findElement(signInLoc).click();
		driver.findElement(signInEmailLoc).sendKeys(email);
		driver.findElement(signInPasswordLoc).sendKeys(password);
		driver.findElement(enterLoc).click();
		

	}
	
	
	public  String getErrorMsg() {
		
		return driver.findElement(errorMsgLoc).getText();
		
	}
	
	

}
