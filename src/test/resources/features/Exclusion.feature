@Registration
Feature: VRN exclusion reason pages after GG login

  Scenario: User is excluded from OSS due to already being registered for a scheme in Estonia
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 333333333 and strong credentials
    Then the user clicks on the continue to your account link
    And the user is on the already-registered-other-country?countryCode=EE page

  Scenario: User is excluded from OSS due to excluded and quarantined in Estonia
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 333333334 and strong credentials
    Then the user clicks on the continue to your account link
    And the user is on the other-country-excluded-and-quarantined?countryCode=EE&exclusionDate=2023-01-01 page

