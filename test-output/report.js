$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/feature/PracticeAutomation.feature");
formatter.feature({
  "name": "PracticeAutomation",
  "description": "In order to shop the Automation books \nAs a practice automation user\nI want to connect with the practice automation application",
  "keyword": "Feature"
});
formatter.background({
  "name": "common for each scenario",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "User launch the browser with practiceautomationtestingPage",
  "keyword": "Given "
});
formatter.match({
  "location": "com.cts.stepdefinitions.StepDefinition.user_launch_the_browser_with_practiceautomationtestingPage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Invalid sign in details",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I click on home and enter wrong sign in details from excel \"src/test/resources/excel/AutomationPractice.xlsx\" with sheetname as \"InvalidSignInDetails\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.cts.stepdefinitions.StepDefinition.i_click_on_home_and_enter_wrong_sign_in_details_from_excel_with_sheetname_as(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I will get a error message",
  "keyword": "Then "
});
formatter.match({
  "location": "com.cts.stepdefinitions.StepDefinition.i_will_get_a_error_message()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});