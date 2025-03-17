@regression
Feature: [1] Validate the search results to ensure relevant job listings appear

  Background:
    Given user is on search page

  Scenario: [1.1] Job openings with the title containing "Analyst" in London returns correct values
    When user searches for "Analyst" in "London"
    Then "33" search results should be displayed

  @wip
  Scenario: [1.2] Apply filter options
    When user searches for "Analyst" in "London"
    And user filters "Medicines and Healthcare products Regulatory Agency"
    Then "1" search results should be displayed



