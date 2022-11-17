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
    And the user adds A1123456789 on the first eu-vat-number page
    And the user chooses yes on the first eu-fixed-establishment page
    And the user adds French business name on the first eu-trading-name page
    And the user completes details on the eu-fixed-establishment-address/1 page
      | data           | fieldId       |
      | 1 Test Address | line1         |
      | Test Town      | townOrCity    |
      | Test Region    | stateOrRegion |
      | 45236 FR       | postCode      |
    And the user clicks continue on the first check-tax-details page
    And the user answers yes on the add-tax-details page
    And the user selects Germany on the second eu-tax page
    And the user chooses yes on the second eu-vat page
    And the user adds 123456789 on the second eu-vat-number page
    And the user chooses no on the second eu-fixed-establishment page
    And the user chooses yes on the second eu-send-goods page
    And the user adds German business name on the second eu-send-goods-trading-name page
    And the user completes details on the eu-send-goods-address/2 page
      | data           | fieldId       |
      | 1 Test Address | line1         |
      | Test Town      | townOrCity    |
      | Test Region    | stateOrRegion |
      | DE45236        | postCode      |
    And the user clicks continue on the second check-tax-details page
    And the user answers yes on the add-tax-details page
    And the user selects Poland on the third eu-tax page
    And the user chooses yes on the third eu-vat page
    And the user adds 1234567891 on the third eu-vat-number page
    And the user chooses no on the third eu-fixed-establishment page
    And the user chooses no on the third eu-send-goods page
    And the user clicks continue on the third check-tax-details page
    And the user answers no on the add-tax-details page
    And the user answers yes on the deregistered page
    And the user selects Austria on the first deregistered-country page
    And the user adds U98765432 on the first deregistered-eu-vat-number page
    And the user answers no on the add-deregistration page
    And the user answers no on the online-marketplace page
    And the user answers yes on the give-website-address page
    And the user adds www.example.com on the first website-address page
    And the user answers yes on the add-website-address page
    And the user adds www.second-example.com on the second website-address page
    And the user answers no on the add-website-address page
    And the user completes details on the business-contact-details page
      | data           | fieldId         |
      | Joe Bloggs     | fullName        |
      | 01234567890    | telephoneNumber |
      | email@test.com | emailAddress    |
    And the user completes the email verification process
    And the user completes details on the bank-details page
      | data                   | fieldId     |
      | Account Name           | accountName |
      | ABCDEF2A               | bic         |
      | GB33BUKB20201555555555 | iban        |
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
    And the user answers no on the deregistered page
    And the user answers no on the online-marketplace page
    And the user answers no on the give-website-address page
    And the user completes details on the business-contact-details page
      | data           | fieldId         |
      | Joe Bloggs     | fullName        |
      | 01234567890    | telephoneNumber |
      | email@test.com | emailAddress    |
    And the user completes the email verification process
    And the user completes details on the bank-details page
      | data                   | fieldId     |
      | Account Name           | accountName |
      | ABCDEF2A               | bic         |
      | GB33BUKB20201555555555 | iban        |
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
    And the user chooses yes on the first eu-fixed-establishment page
    And the user adds XA123456789 on the first eu-tax-number page
    And the user adds French business name on the first eu-trading-name page
    And the user completes details on the eu-fixed-establishment-address/1 page
      | data           | fieldId       |
      | 1 Test Address | line1         |
      | Test Town      | townOrCity    |
      | Test State     | stateOrRegion |
      | 12345 FR       | postCode      |
    And the user clicks continue on the first check-tax-details page
    And the user answers yes on the add-tax-details page
    And the user selects Germany on the second eu-tax page
    And the user chooses yes on the second eu-vat page
    And the user adds 123456789 on the second eu-vat-number page
    And the user chooses no on the second eu-fixed-establishment page
    And the user chooses yes on the second eu-send-goods page
    And the user adds 123456789 on the second eu-tax-number page
    And the user adds German business name on the second eu-send-goods-trading-name page
    And the user completes details on the eu-send-goods-address/2 page
      | data           | fieldId       |
      | 1 Test Address | line1         |
      | Test Town      | townOrCity    |
      | Test Region    | stateOrRegion |
      | 45236 DE       | postCode      |
    And the user clicks continue on the second check-tax-details page
    And the user answers yes on the add-tax-details page
    And the user selects Spain on the third eu-tax page
    And the user chooses no on the third eu-vat page
    And the user chooses no on the third eu-fixed-establishment page
    And the user chooses no on the third eu-send-goods page
    And the user clicks continue on the third check-tax-details page
    And the user answers no on the add-tax-details page
    And the user answers no on the deregistered page
    And the user answers no on the online-marketplace page
    And the user answers no on the give-website-address page
    And the user completes details on the business-contact-details page
      | data           | fieldId         |
      | Joe Bloggs     | fullName        |
      | 01234567890    | telephoneNumber |
      | email@test.com | emailAddress    |
    And the user completes the email verification process
    And the user completes details on the bank-details page
      | data                   | fieldId     |
      | Account Name           | accountName |
      | ABCDEF2A               | bic         |
      | GB33BUKB20201555555555 | iban        |
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
