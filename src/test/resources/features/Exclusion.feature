@Registration
Feature: VRN exclusion reason page after GG login

  Scenario: GG Login when a user is excluded
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 333333333 and strong credentials
    Then the user is at the already-registered-other-country?countryCode=EE page

  Scenario:GG when a user is not excluded
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 123456789 and strong credentials
    Then the user is at the already-registered page

