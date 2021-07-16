@Registration
Feature: Check Your Answers

  Scenario: Changing answers in Check Your Answers
    Given the business is responsible for reporting and paying VAT for all sales in EU
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user registers with minimal details for the one stop shop scheme
    Then the user changes answers to yes and is redirected accordingly to add further answers

