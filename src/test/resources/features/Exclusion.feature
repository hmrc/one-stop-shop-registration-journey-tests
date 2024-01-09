@Registration @Accessibility
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

  Scenario: Active OSS Reg in another EU country
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers no on the have-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters yesterday for date-of-first-sale
    And the user answers yes on the previous-oss page
    And the user selects Germany on the first previous-country page
    And the user answer oss on the previous-scheme/1/1 page
    And the user add DE123456789 on the first previous-oss-scheme-number page
    Then the user is on the scheme-still-active/1/1?countryCode=EE page

  Scenario: Quarantined OSS in another EU country
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers no on the have-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters yesterday for date-of-first-sale
    And the user answers yes on the previous-oss page
    And the user selects France on the first previous-country page
    And the user answer oss on the previous-scheme/1/1 page
    And the user add FRXX123456789 on the first previous-oss-scheme-number page
    Then the user is on the scheme-quarantined/1/1 page

  Scenario: Quarantined IOSS in another EU country
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers no on the have-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters yesterday for date-of-first-sale
    And the user answers yes on the previous-oss page
    And the user selects Greece on the first previous-country page
    And the user answer ioss on the previous-scheme/1/1 page
    And the user answers no on the previous-ioss-scheme/1/1 page
    And the user inputs ioss reg number IM3001234567 on the previous-ioss-number/1/1 page
    And the user clicks continue on the first previous-ioss-number/1 page
    Then the user is on the scheme-quarantined/1/1 page

  Scenario: Quarantined intermediary identification number in another EU country
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers no on the have-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters yesterday for date-of-first-sale
    And the user answers yes on the previous-oss page
    And the user selects Germany on the first previous-country page
    And the user answer ioss on the previous-scheme/1/1 page
    And the user answers yes on the previous-ioss-scheme/1/1 page
    And the user inputs ioss reg number IM2761234567 on the previous-ioss-number/1/1 page
    And the user inputs intermediary identification number IN2761234567 on the previous-ioss-number/1/1 page
    Then the user is on the scheme-quarantined/1/1 page

  Scenario: Cannot register with a fixed establishment that is already registered on a One Stop Shop service
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers no on the have-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters yesterday for date-of-first-sale
    And the user answers no on the previous-oss page
    And the user clicks through the start-date page
    And the user answers yes on the tax-in-eu page
    And the user selects Greece on the first eu-tax page
    And the user chooses yes on the first sells-goods-to-eu-consumers page
    And the user answer fixed establishment on the sells-goods-to-eu-consumer-method/1 page
    And the user answer vat number on the registration-type/1 page
    And the user adds EL123456788 on the first eu-vat-number page
    Then the user is on the fixed-establishment-vrn-already-registered/1 page

  Scenario: Cannot register with a fixed establishment that is excluded on a One Stop Shop service
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers no on the have-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters yesterday for date-of-first-sale
    And the user answers no on the previous-oss page
    And the user clicks through the start-date page
    And the user answers yes on the tax-in-eu page
    And the user selects Greece on the first eu-tax page
    And the user chooses yes on the first sells-goods-to-eu-consumers page
    And the user answer fixed establishment on the sells-goods-to-eu-consumer-method/1 page
    And the user answer tax id number on the registration-type/1 page
    And the user adds 333333336 on the first eu-tax-number page
    Then the user is on the excluded-vrn page

