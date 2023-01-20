@Registration
Feature: User registers with different commencement dates

  Background:
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers no on the have-uk-trading-name page

  Scenario: A user registers within notification period
    And the user answers yes on the already-made-sales page
    And the user enters a date inside the notification period for date of first sale
    And the user presses the continue button
    And the user clicks through the start-date page
    And the user answers no on the tax-in-eu page
    And the user answers yes on the previous-oss page
    And the user selects France on the first previous-country page
    And the user answer oss on the previous-scheme page
    And the user add FRDB123456789 on the first previous-oss-scheme-number page
    Then the user is on the previous-scheme-answer/1 page
    And the user answers no on the previous-scheme-answer/1 page
    And the user answers no on the add-deregistration page
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
    Then the user sees the pre 10th version of the successful page

  Scenario: A user has not made sales and will make sales
    And the user answers no on the already-made-sales page
    And the user answers yes on the planned-first-sale page
    And the user clicks through the start-date page
    And the user answers no on the tax-in-eu page
    And the user answers yes on the previous-oss page
    And the user selects France on the first previous-country page
    And the user answer oss on the previous-scheme page
    And the user add FRX1123456789 on the first previous-oss-scheme-number page
    Then the user is on the previous-scheme-answer/1 page
    And the user answers no on the previous-scheme-answer/1 page
    And the user answers no on the add-deregistration page
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
    Then the user sees the pre 10th version of the successful page