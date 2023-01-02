@Registration
Feature: Previously registered journey

  Scenario: Oss validate with valid oss registration number(8 digits)
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers yes on the have-uk-trading-name page
    And the user adds Foo on the first uk-trading-name page
    And the user answers yes on the add-uk-trading-name page
    And the user adds Foo Two on the second uk-trading-name page
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters a date inside the notification period for date of first sale
    And the user presses the continue button
    And the user clicks through the start-date page
    And the user answers no on the tax-in-eu page
    And the user answers yes on the previous-oss page
    And the user selects Luxembourg on the first previous-country page
    And the user answer oss on the previous-scheme page
    And the user add LU99999999 on the first previous-oss-scheme-number page
    Then the user is on the previous-scheme-answer/1 page

  Scenario: Oss validate with valid oss registration number(9 digits)
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers yes on the have-uk-trading-name page
    And the user adds Foo on the first uk-trading-name page
    And the user answers yes on the add-uk-trading-name page
    And the user adds Foo Two on the second uk-trading-name page
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters a date inside the notification period for date of first sale
    And the user presses the continue button
    And the user clicks through the start-date page
    And the user answers no on the tax-in-eu page
    And the user answers yes on the previous-oss page
    And the user selects France on the first previous-country page
    And the user answer oss on the previous-scheme page
    And the user add FRXX123456789 on the first previous-oss-scheme-number page
    Then the user is on the previous-scheme-answer/1 page

  Scenario: Oss validate with valid oss registration number(10 digits)
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers yes on the have-uk-trading-name page
    And the user adds Foo on the first uk-trading-name page
    And the user answers yes on the add-uk-trading-name page
    And the user adds Foo Two on the second uk-trading-name page
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters a date inside the notification period for date of first sale
    And the user presses the continue button
    And the user clicks through the start-date page
    And the user answers no on the tax-in-eu page
    And the user answers yes on the previous-oss page
    And the user selects Belgium on the first previous-country page
    And the user answer oss on the previous-scheme page
    And the user add BE1234567890 on the first previous-oss-scheme-number page
    Then the user is on the previous-scheme-answer/1 page

  Scenario: Oss validate with valid oss registration number(11 digits)
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers yes on the have-uk-trading-name page
    And the user adds Foo on the first uk-trading-name page
    And the user answers yes on the add-uk-trading-name page
    And the user adds Foo Two on the second uk-trading-name page
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters a date inside the notification period for date of first sale
    And the user presses the continue button
    And the user clicks through the start-date page
    And the user answers no on the tax-in-eu page
    And the user answers yes on the previous-oss page
    And the user selects Croatia on the first previous-country page
    And the user answer oss on the previous-scheme page
    And the user add HR12345678910 on the first previous-oss-scheme-number page
    Then the user is on the previous-scheme-answer/1 page

  Scenario: Oss validate with valid oss registration number(12 digits)
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers yes on the have-uk-trading-name page
    And the user adds Foo on the first uk-trading-name page
    And the user answers yes on the add-uk-trading-name page
    And the user adds Foo Two on the second uk-trading-name page
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters a date inside the notification period for date of first sale
    And the user presses the continue button
    And the user clicks through the start-date page
    And the user answers no on the tax-in-eu page
    And the user answers yes on the previous-oss page
    And the user selects Netherlands on the first previous-country page
    And the user answer oss on the previous-scheme page
    And the user add NL123456789101 on the first previous-oss-scheme-number page
    Then the user is on the previous-scheme-answer/1 page

  Scenario: Oss validate with valid oss registration number(digits and Alphabets)
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers yes on the have-uk-trading-name page
    And the user adds Foo on the first uk-trading-name page
    And the user answers yes on the add-uk-trading-name page
    And the user adds Foo Two on the second uk-trading-name page
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters a date inside the notification period for date of first sale
    And the user presses the continue button
    And the user clicks through the start-date page
    And the user answers no on the tax-in-eu page
    And the user answers yes on the previous-oss page
    And the user selects Spain on the first previous-country page
    And the user answer oss on the previous-scheme page
    And the user add ESX1234567X on the first previous-oss-scheme-number page
    Then the user is on the previous-scheme-answer/1 page