@Registration
Feature: Check Your Answers

  Scenario: Changing answers in Check Your Answers
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
    And the user answers no on the tax-in-eu page
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
    Then the user selects the change link for check-have-uk-trading-name
    And the user answers yes on the check-have-uk-trading-name page
    And the user adds Foo on the first check-uk-trading-name page
    And the user answers yes on the check-add-uk-trading-name page
    And the user adds Foo Two on the second check-uk-trading-name page
    And the user answers no on the check-add-uk-trading-name page
    Then the user is at the check-answers page
    Then the user selects the change link for check-tax-in-eu
    And the user answers yes on the check-tax-in-eu page
    And the user selects France on the first check-eu-tax page
    And the user chooses yes on the first check-eu-vat page
    And the user adds FRXX123456789 on the first check-eu-vat-number page
    And the user chooses no on the first check-eu-fixed-establishment page
    And the user chooses no on the first eu-send-goods page
    And the user clicks continue on the first change-check-tax-details page
    And the user answers yes on the check-add-tax-details page
    And the user selects Germany on the second check-eu-tax page
    And the user chooses yes on the second check-eu-vat page
    And the user adds DE123456789 on the second check-eu-vat-number page
    And the user chooses yes on the second check-eu-fixed-establishment page
    And the user adds EU trading name on the second check-eu-trading-name page
    And the user completes details on the check-eu-fixed-establishment-address/2 page
      | data      | fieldId    |
      | 1 Address | line1      |
      | A Town    | townOrCity |
    And the user selects the change link for check-eu-vat\/2
    And the user chooses no on the second check-eu-vat page
    And the user adds ABC123 on the second check-eu-tax-number page
    And the user clicks continue on the second change-check-tax-details page
    And the user answers no on the check-add-tax-details page
    Then the user is at the check-answers page
    Then the user selects the change link for check-add-deregistration
    And the user answers yes on the check-add-deregistration page
    And the user selects Austria on the second check-previous-country page
    And the user answers oss on the check-previous-scheme/2/1 page
    And the user enters ATU99999999 on the check-previous-oss-scheme-number/2/1 page
    And the user answers no on the check-previous-scheme-answer/2 page
    And the user answers no on the check-add-deregistration page
    Then the user is at the check-answers page
    Then the user selects the change link for check-give-website-address
    And the user answers yes on the check-give-website-address page
    And the user adds www.example.com on the first check-website-address page
    And the user answers yes on the check-add-website-address page
    And the user adds www.second-example.com on the second check-website-address page
    And the user selects the remove link for check-remove-website-address\/2
    Then the user answers yes on the check-remove-website-address/2 page
    And the user answers no on the check-add-website-address page
    Then the user is at the check-answers page

