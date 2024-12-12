@Registration

Feature: Previous OSS or IOSS registrations in other countries

 Scenario: Inactive (excluded but not quarantined) OSS Reg in another EU country
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
   And the user enters yesterday for date-of-first-sale
   And the user presses the continue button
   And the user answers yes on the previous-oss page
   And the user selects France on the first previous-country page
   And the user answer ioss on the previous-scheme/1/1 page
   And the user answers yes on the previous-ioss-scheme/1/1 page
   And the user inputs ioss reg number IM2501234567 on the previous-ioss-number/1/1 page
   And the user inputs intermediary identification number IN2501234567 on the previous-ioss-number/1/1 page
   And the user answers no on the previous-scheme-answers/1 page
   And the user answers no on the previous-schemes-overview page
   And the user clicks through the start-date page
   And the user answers yes on the tax-in-eu page
   And the user selects Denmark on the first eu-tax page
   And the user chooses yes on the first sells-goods-to-eu-consumers page
   And the user answer fixed establishment on the sells-goods-to-eu-consumer-method/1 page
  And the user answer vat number on the registration-type/1 page
  And the user adds DK12345678 on the first eu-vat-number page
  And the user adds soo on the first eu-trading-name page
  And the user completes details on the eu-fixed-establishment-address/1 page
    | data      | fieldId    |
    | 1 Address | line1      |
    | A Town    | townOrCity |
  And the user clicks continue on the first check-tax-details page
  And the user answers yes on the add-tax-details page
  And the user selects Croatia on the second eu-tax page
   And the user chooses yes on the second sells-goods-to-eu-consumers page
   And the user answer fixed establishment on the sells-goods-to-eu-consumer-method/2 page
   And the user answer vat number on the registration-type/2 page
   And the user adds HR01234567899 on the second eu-vat-number page
  And the user adds roo on the second eu-trading-name page
  And the user completes details on the eu-fixed-establishment-address/2 page
    | data      | fieldId    |
    | 1 Address | line1      |
    | A Town    | townOrCity |
  And the user clicks continue on the second check-tax-details page
   And the user answers no on the add-tax-details page
   And the user answers no on the online-marketplace page
   And the user answers yes on the give-website-address page
   And the user adds www.example.com on the first website-address page
   And the user answers yes on the add-website-address page
   And the user adds www.second-example.com on the second website-address page
   And the user answers no on the add-website-address page
   And the user completes details on the business-contact-details page
     | data            | fieldId         |
     | Joe Bloggs      | fullName        |
     | 01234567890     | telephoneNumber |
     | email@test.com  | emailAddress    |
   And the user completes the registration email verification process
   And the user completes details on the bank-details page
     | data                    | fieldId         |
     | Account Name            | accountName     |
     | ABCDEF2A                | bic             |
     | GB33BUKB20201555555555  | iban            |
   Then the user is at the check-answers page
   Then the user submits their registration

  Scenario: Active IOSS Reg in another EU country
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
    And the user enters yesterday for date-of-first-sale
    And the user answers yes on the previous-oss page
    And the user selects Italy on the first previous-country page
    And the user answer ioss on the previous-scheme/1/1 page
    And the user answers yes on the previous-ioss-scheme/1/1 page
    And the user inputs ioss reg number IM3801234567 on the previous-ioss-number/1/1 page
    And the user inputs intermediary identification number IN3801234567 on the previous-ioss-number/1/1 page
    And the user answers no on the previous-scheme-answers/1 page
    And the user answers no on the previous-schemes-overview page
    And the user clicks through the start-date page
    And the user answers no on the tax-in-eu page

  Scenario: User Remove single Previously Reg Scheme
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
    And the user enters yesterday for date-of-first-sale
    And the user answers yes on the previous-oss page
    And the user selects Spain on the first previous-country page
    And the user answer oss on the previous-scheme/1/1 page
    And the user add ESX1234567X on the first previous-oss-scheme-number page
    Then the user is on the previous-scheme-answers/1 page
    And the user answers yes on the previous-scheme-answers/1 page
    And the user answers ioss on the previous-scheme/1/2 page
    And the user answers no on the previous-ioss-scheme/1/2 page
    And the user inputs ioss reg number IM7241234567 on the previous-ioss-number/1/2 page
    And the user clicks through the previous-ioss-number/1/2 page
    Then the user selects the remove link for remove-previous-scheme
    And the user answers yes on the remove-previous-scheme/1/1 page
    Then the user is at the previous-scheme-answers/1 page

  Scenario: User Remove multiple Previously Reg Scheme
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
    And the user enters yesterday for date-of-first-sale
    And the user answers yes on the previous-oss page
    And the user selects Spain on the first previous-country page
    And the user answer oss on the previous-scheme/1/1 page
    And the user add ESX1234567X on the first previous-oss-scheme-number page
    Then the user is on the previous-scheme-answers/1 page
    And the user answers yes on the previous-scheme-answers/1 page
    And the user answers ioss on the previous-scheme/1/2 page
    And the user answers no on the previous-ioss-scheme/1/2 page
    And the user inputs ioss reg number IM7241234567 on the previous-ioss-number/1/2 page
    And the user clicks through the previous-ioss-number/1/2 page
    Then the user selects the remove link for remove-previous-scheme
    And the user answers yes on the remove-previous-scheme/1/1 page
    Then the user selects the remove link for remove-previous-scheme
    And the user answers yes on the remove-previous-scheme/1/1 page
    Then the user is at the previous-oss page


