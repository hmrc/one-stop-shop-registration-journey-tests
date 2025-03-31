@RegistrationExtra
Feature: Entering the Registration service via BTA

  Scenario: A user registers via BTA and then has the correct BTA link on the registration submission page
    Given the user accesses the stub url
    And the user signs in as an Organisation Admin with Hmrc Mdt VAT enrolment 100000001 and strong credentials via authwiz
    Then the user manually navigates to the from-external link
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user chooses Yes on the confirm-vat-details page
    And the user answers no on the have-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters yesterday for date-of-first-sale
    And the user answers yes on the previous-oss page
    And the user selects France on the first previous-country page
    And the user answer oss on the previous-scheme/1/1 page
    And the user add FR1B123456789 on the first previous-oss-scheme-number page
    Then the user is on the previous-scheme-answers/1 page
    And the user answers no on the previous-scheme-answers/1 page
    And the user answers no on the previous-schemes-overview page
    And the user clicks through the start-date page
    And the user answers no on the tax-in-eu page
    And the user answers no on the online-marketplace page
    And the user answers no on the give-website-address page
    And the user completes details on the business-contact-details page
      | data           | fieldId         |
      | Joe Bloggs     | fullName        |
      | 01234567890    | telephoneNumber |
      | email@test.com | emailAddress    |
    And the user completes the registration email verification process
    And the user completes details on the bank-details page
      | data                   | fieldId     |
      | Account Name           | accountName |
      | ABCDEF2A               | bic         |
      | GB33BUKB20201555555555 | iban        |
    Then the user is at the check-answers page
    Then the user submits their registration
    Then the user clicks on the BTA link
    And the user is on the business-account page

  Scenario: The user enters the service via BTA and is directed back to BTA via the Already EU Registered kickout page
    Given the user accesses the stub url
    And the user signs in as an Organisation Admin with Hmrc Mdt VAT enrolment 100000001 and strong credentials via authwiz
    Then the user manually navigates to the from-external link
    And the user answers yes on the already-eu-registered page
    Then the user is on the return-later-already-eu-registered page
    Then the user clicks on the BTA link
    And the user is on the business-account page

  Scenario: The user enters the service via BTA and is directed back to BTA via the Do Not Sell from NI kickout page
    Given the user accesses the stub url
    And the user signs in as an Organisation Admin with Hmrc Mdt VAT enrolment 100000001 and strong credentials via authwiz
    Then the user manually navigates to the from-external link
    And the user answers no on the already-eu-registered page
    And the user answers no on the sell-from-northern-ireland page
    Then the user is on the do-not-sell-from-northern-ireland page
    Then the user clicks on the BTA link
    And the user is on the business-account page

  Scenario: The user enters the service via BTA and is directed back to BTA via the Cannot Use No VAT kickout page
    Given the user accesses the stub url
    And the user signs in as an Organisation Admin with Hmrc Mdt VAT enrolment 100000001 and strong credentials via authwiz
    Then the user manually navigates to the from-external link
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers no on the northern-ireland-business page
    And the user answers no on the northern-ireland-fixed-establishment page
    And the user picks Online Marketplace on the sales-on-marketplaces page
    Then the user is on the cannot-use-no-vat page
    Then the user clicks on the BTA link
    And the user is on the business-account page

  Scenario: The user enters the service via BTA and is directed back to BTA via the post-auth already registered page
    Given the user accesses the stub url
    And the user signs in as an Organisation Admin with Hmrc Mdt VAT enrolment 100000003 and strong credentials via authwiz
    Then the user manually navigates to the from-external link
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    Then the user is on the already-registered page
    Then the user clicks on the continue to your account link


  Scenario: A Welsh user enters the service via BTA and is first directed to the Welsh transition page before continuing
    Given the user accesses the stub url
    And the user signs in as an Organisation Admin with Hmrc Mdt VAT enrolment 100000001 and strong credentials via authwiz
    Then the user manually navigates to the from-external?lang=cy link
    And the user is on the no-welsh-service page
    Then the user presses the continue button
    And the user is on the already-eu-registered page

  Scenario: A user enters the service via BTA using the en parameter and is directed straight to the registration service
    Given the user accesses the stub url
    And the user signs in as an Organisation Admin with Hmrc Mdt VAT enrolment 100000001 and strong credentials via authwiz
    Then the user manually navigates to the from-external?lang=en link
    And the user is on the already-eu-registered page

