@Registration
Feature: Registering for One Stop Shop
  @ZAP
  Scenario: A signed in user can complete a full registration
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
    And the user answers yes on the tax-in-eu page
    And the user selects France on the first eu-tax page
    And the user chooses yes on the first eu-vat page
    And the user adds FRA1123456789 on the first eu-vat-number page
    And the user chooses no on the first eu-fixed-establishment page
    And the user chooses no on the first eu-send-goods page
    And the user clicks continue on the first check-tax-details page
    And the user answers yes on the add-tax-details page
    And the user selects Germany on the second eu-tax page
    And the user chooses yes on the second eu-vat page
    And the user adds DE123456789 on the second eu-vat-number page
    And the user chooses no on the second eu-fixed-establishment page
    And the user chooses no on the second eu-send-goods page
    And the user clicks continue on the second check-tax-details page
    And the user answers no on the add-tax-details page
    And the user answers yes on the previous-oss page
    And the user selects France on the first previous-country page
    And the user answer oss on the previous-scheme page
    And the user add FRXQ123456789 on the first previous-oss-scheme-number page
    Then the user is on the previous-scheme-answer/1 page
    And the user answers no on the previous-scheme-answer/1 page
    And the user answers no on the add-deregistration page
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
    And the user completes the email verification process
    And the user completes details on the bank-details page
      | data                    | fieldId         |
      | Account Name            | accountName     |
      | ABCDEF2A                | bic             |
      | GB33BUKB20201555555555  | iban            |
    Then the user is at the check-answers page
    Then the user submits their registration

  Scenario: A signed in user can submit a registration when they have not yet made sales but plan to
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000002 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers no on the have-uk-trading-name page
    And the user answers no on the already-made-sales page
    And the user answers yes on the planned-first-sale page
    And the user clicks through the start-date page
    And the user answers no on the tax-in-eu page
    And the user answers yes on the previous-oss page
    And the user selects France on the first previous-country page
    And the user answer oss on the previous-scheme page
    And the user add FRDS123456789 on the first previous-oss-scheme-number page
    Then the user is on the previous-scheme-answer/1 page
    And the user answers no on the previous-scheme-answer/1 page
    And the user answers no on the add-deregistration page
    And the user answers no on the online-marketplace page
    And the user answers no on the give-website-address page
    And the user completes details on the business-contact-details page
      | data            | fieldId         |
      | Joe Bloggs      | fullName        |
      | 01234567890     | telephoneNumber |
      | email@test.com  | emailAddress    |
    And the user completes the email verification process
    And the user completes details on the bank-details page
      | data                    | fieldId         |
      | Account Name            | accountName     |
      | ABCDEF2A                | bic             |
      | GB33BUKB20201555555555  | iban            |
    Then the user is at the check-answers page
    Then the user submits their registration

  Scenario: A signed in user registers with an EU Tax identifier instead of a EU VAT number for EU Registration Details
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers no on the have-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters a date inside the notification period for date of first sale
    And the user presses the continue button
    And the user clicks through the start-date page
    And the user answers yes on the tax-in-eu page
    And the user selects France on the first eu-tax page
    And the user chooses no on the first eu-vat page
    And the user chooses no on the first eu-fixed-establishment page
    And the user chooses no on the first eu-send-goods page
    And the user clicks continue on the first check-tax-details page
    And the user answers yes on the add-tax-details page
    And the user selects Germany on the second eu-tax page
    And the user chooses yes on the second eu-vat page
    And the user adds DE123456789 on the second eu-vat-number page
    And the user chooses no on the second eu-fixed-establishment page
    And the user chooses no on the second eu-send-goods page
    And the user clicks continue on the second check-tax-details page
    And the user answers no on the add-tax-details page
    And the user answers yes on the previous-oss page
    And the user selects France on the first previous-country page
    And the user answer oss on the previous-scheme page
    And the user add FRA1123456789 on the first previous-oss-scheme-number page
    Then the user is on the previous-scheme-answer/1 page
    And the user answers no on the previous-scheme-answer/1 page
    And the user answers no on the add-deregistration page
    And the user answers no on the online-marketplace page
    And the user answers no on the give-website-address page
    And the user completes details on the business-contact-details page
      | data            | fieldId         |
      | Joe Bloggs      | fullName        |
      | 01234567890     | telephoneNumber |
      | email@test.com  | emailAddress    |
    And the user completes the email verification process
    And the user completes details on the bank-details page
      | data                    | fieldId         |
      | Account Name            | accountName     |
      | ABCDEF2A                | bic             |
      | GB33BUKB20201555555555  | iban            |
    Then the user is at the check-answers page
    Then the user submits their registration

  Scenario: A signed in user can continue a saved registration journey when going through filter questions
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
    And the user clicks on the save and come back later button
    And the user select the sign and come back later link
    And the user accesses the continue on sign in url
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    Then the user is at the continue-registration page

    Scenario: A signed in user can continue-on-sign-in url without starting a registration
      Given the user accesses the continue on sign in url
      And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
      Then the user is at the no-saved-registration page

  Scenario: A signed in user can complete a full registration with an intermediary identification number
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
    And the user answers yes on the tax-in-eu page
    And the user selects France on the first eu-tax page
    And the user chooses yes on the first eu-vat page
    And the user adds FRA1123456789 on the first eu-vat-number page
    And the user chooses no on the first eu-fixed-establishment page
    And the user chooses no on the first eu-send-goods page
    And the user clicks continue on the first check-tax-details page
    And the user answers yes on the add-tax-details page
    And the user selects Germany on the second eu-tax page
    And the user chooses yes on the second eu-vat page
    And the user adds DE123456789 on the second eu-vat-number page
    And the user chooses no on the second eu-fixed-establishment page
    And the user chooses no on the second eu-send-goods page
    And the user clicks continue on the second check-tax-details page
    And the user answers no on the add-tax-details page
    And the user answers yes on the previous-oss page
    And the user selects France on the first previous-country page
    And the user answer ioss on the previous-scheme page
    And the user answers yes on the previous-ioss-scheme/1/1 page
    And the user inputs ioss reg number IM2501234567 on the previous-ioss-number/1/1 page
    And the user inputs intermediary identification number IN2501234567 on the previous-ioss-number/1/1 page
    And the user answers no on the previous-scheme-answer/1 page
    And the user answers no on the add-deregistration page
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
    And the user completes the email verification process
    And the user completes details on the bank-details page
      | data                    | fieldId         |
      | Account Name            | accountName     |
      | ABCDEF2A                | bic             |
      | GB33BUKB20201555555555  | iban            |
    Then the user is at the check-answers page
    Then the user submits their registration

  Scenario: A signed in user can complete a full registration without an intermediary identification number
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
    And the user answers yes on the tax-in-eu page
    And the user selects France on the first eu-tax page
    And the user chooses yes on the first eu-vat page
    And the user adds FRA1123456089 on the first eu-vat-number page
    And the user chooses no on the first eu-fixed-establishment page
    And the user chooses no on the first eu-send-goods page
    And the user clicks continue on the first check-tax-details page
    And the user answers yes on the add-tax-details page
    And the user selects Germany on the second eu-tax page
    And the user chooses yes on the second eu-vat page
    And the user adds DE123456789 on the second eu-vat-number page
    And the user chooses no on the second eu-fixed-establishment page
    And the user chooses no on the second eu-send-goods page
    And the user clicks continue on the second check-tax-details page
    And the user answers no on the add-tax-details page
    And the user answers yes on the previous-oss page
    And the user selects France on the first previous-country page
    And the user answer ioss on the previous-scheme page
    And the user answers no on the previous-ioss-scheme/1/1 page
    And the user inputs ioss reg number IM2501234567 on the previous-ioss-number/1/1 page
    And the user clicks continue on the first previous-ioss-number/1 page
    And the user answers no on the previous-scheme-answer/1 page
    And the user answers no on the add-deregistration page
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
    And the user completes the email verification process
    And the user completes details on the bank-details page
      | data                    | fieldId         |
      | Account Name            | accountName     |
      | ABCDEF2A                | bic             |
      | GB33BUKB20201555555555  | iban            |
    Then the user is at the check-answers page
    Then the user submits their registration