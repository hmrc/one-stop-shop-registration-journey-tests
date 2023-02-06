@Registration @wip
Feature: Not all customer VAT details retrieved from DES
  Scenario: Missing Customer Vat Info from UK VAT details
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 700000001 and strong credentials
    Then the user is on the registration-service-error page
