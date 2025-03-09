@regression
Feature: [1] Validate the search results to ensure relevant job listings appear

  Scenario: [1.1] Job openings with the title containing "Analyst" in London returns correct values
    Given user is on search page
    When user searches for "Analyst" in "London"
    Then "34" search results should be displayed

  @wip
  Scenario: [1.2] Apply filter options
    Given user is on search page
    When user searches for "Analyst" in "London"
    And user filters "Medicines and Healthcare products Regulatory Agency"


