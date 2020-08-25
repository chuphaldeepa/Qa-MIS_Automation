$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Scenarios.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: manish.rana@pimco.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 5,
      "value": "#| (Data Tables)"
    },
    {
      "line": 6,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 7,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 8,
      "value": "#\"\""
    },
    {
      "line": 9,
      "value": "## (Comments)"
    },
    {
      "line": 10,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 12,
  "name": "Cucumber-POC",
  "description": "This feature file contains the scenarios to test PIMCO.com for different use roles.",
  "id": "cucumber-poc",
  "keyword": "Feature",
  "tags": [
    {
      "line": 11,
      "name": "@tag"
    }
  ]
});
formatter.before({
  "duration": 25996700070,
  "status": "passed"
});
formatter.background({
  "line": 16,
  "name": "",
  "description": "Given: Select the country as US",
  "type": "background",
  "keyword": "Background"
});
formatter.scenario({
  "line": 19,
  "name": "Validate the behaviour for Financial Intermediary",
  "description": "",
  "id": "cucumber-poc;validate-the-behaviour-for-financial-intermediary",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 20,
  "name": "Select Financial Intermediary User",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "Validate User is navigated to next page",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "Verify the header for the User",
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "Mousehover on Investment and verify all the product",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "click on the ETF instrument",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "validate user is on ETF page",
  "keyword": "And "
});
formatter.match({
  "location": "Scenarios_SD.select_Financial_Intermediary_User()"
});
formatter.result({
  "duration": 3392403084,
  "status": "passed"
});
formatter.match({
  "location": "Scenarios_SD.validate_User_is_navigated_to_next_page()"
});
formatter.result({
  "duration": 13085253712,
  "status": "passed"
});
formatter.match({
  "location": "Scenarios_SD.verify_the_header_for_the_User()"
});
formatter.result({
  "duration": 61251,
  "status": "passed"
});
formatter.match({
  "location": "Scenarios_SD.mousehover_on_Investment_and_verify_all_the_product()"
});
formatter.result({
  "duration": 50146,
  "status": "passed"
});
formatter.match({
  "location": "Scenarios_SD.click_on_the_ETF_instrument()"
});
formatter.result({
  "duration": 39460,
  "status": "passed"
});
formatter.match({
  "location": "Scenarios_SD.validate_user_is_on_ETF_page()"
});
formatter.result({
  "duration": 81435,
  "status": "passed"
});
formatter.after({
  "duration": 2378974144,
  "status": "passed"
});
});