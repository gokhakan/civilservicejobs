@regression
Feature: [1] Validate the search results to ensure relevant job listings appear

  Background:
    Given user is on search page

  Scenario: [1.1] Job openings with the title containing "Analyst" in London returns correct values
    When user searches for "Analyst" in "London"
    Then "34" search results should be displayed

  Scenario: [1.2] Apply filter options
    When user searches for "Analyst" in "London"
    And user filters "Medicines and Healthcare products Regulatory Agency"
    Then "1" search results should be displayed

  @wip
  Scenario: [1.3] Civil Service Code
    When user clicks on "careers available in the Civil Service (opens in a new window)"
    And user clicks on "Working for the Civil Service"
    Then user is on "workingforthecivilservice" page
    When user clicks on "Civil Service Code"
    Then user is on "code" page



