@Registration
Feature: Not all customer VAT details retrieved from DES and VAT Group true for EU registration journey
  Scenario: Missing Customer Vat Info from UK VAT details
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 700000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user enters foo on the business-name page
    And the user provides date 01/01/1980 on the uk-vat-registration-date page
    And the user answers no on the have-uk-trading-name page
    And the user answers no on the already-made-sales page
    And the user answers yes on the planned-first-sale page
    And the user clicks through the start-date page
    And the user answers yes on the tax-in-eu page
    And the user selects France on the first eu-tax page
    And the user adds A1123456789 on the first eu-vat-number page
    And the user answers no on the add-tax-details page
    And the user answers no on the deregistered page
    And the user answers no on the online-marketplace page
    And the user answers no on the give-website-address page
    And the user completes details on the business-contact-details page
      | data           | fieldId         |
      | Joe Bloggs     | fullName        |
      | 01234567890    | telephoneNumber |
      | email@test.com | emailAddress    |
    And the user completes details on the bank-details page
      | data                   | fieldId     |
      | Account Name           | accountName |
      | ABCDEF2A               | bic         |
      | GB33BUKB20201555555555 | iban        |
    Then the user is at the check-answers page
    Then the user submits their registration
