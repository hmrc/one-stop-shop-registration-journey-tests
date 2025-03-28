@Registration
Feature: Cross Schema scenarios

  Scenario: Registration for trader with a current IOSS registration - amends data
    Given the user accesses the stub url
    When the IOSS registered user signs into OSS registration with IOSS number IM9001234567 and VRN 100005555
    Then the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    Then the user is on the confirm-vat-details page
    And the user chooses Yes on the confirm-vat-details page
    And the correct number of existing trading names are displayed for a trader with a current IOSS registration
    And the registration trading name warnings are displayed for a trader with a current IOSS registration
    And the user clicks remove via list for first uk-trading-name
    And the user answers yes on the remove-uk-trading-name/1 page
    And the user answers yes on the add-uk-trading-name page
    And the user adds second cross schema name on the second uk-trading-name page
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters today for date-of-first-sale
    And the user answers no on the previous-oss page
    And the user clicks through the start-date page
    And the user answers no on the tax-in-eu page
    And the user answers no on the online-marketplace page
    And the user answers no on the give-website-address page
    Then the user is on the business-contact-details page
    And the contact details warnings are displayed for a trader with a current IOSS registration
    And the user amends details on the business-contact-details page
      | data                  | fieldId  |
      | CrossSchema Full Name | fullName |
    And the user completes the registration email verification process
    And the user is on the bank-details page
    And the bank details warnings are displayed for a trader with a current IOSS registration
    And the user amends details on the bank-details page
      | data                   | fieldId |
      | GB29NWBK60161331926819 | iban    |
    Then the user is at the check-answers page
    Then the user submits their registration
    And the text on the confirmation page is displayed when the trader has made changes and has a current IOSS registration

  Scenario: Registration for trader with a previous IOSS registration - amends data
    Given the user accesses the stub url
    When the IOSS registered user signs into OSS registration with IOSS number IM9019999997 and VRN 100005555
    Then the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user chooses Yes on the confirm-vat-details page
    And the user is on the add-uk-trading-name page
    And the correct number of existing trading names are displayed for a trader with a previous IOSS registration
    And the registration trading name warnings are displayed for a trader with a previous IOSS registration
    And the user clicks change via list for second uk-trading-name
    And the user amends answer to an amended cross schema trading name
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters today for date-of-first-sale
    And the user answers no on the previous-oss page
    And the user clicks through the start-date page
    And the user answers no on the tax-in-eu page
    And the user answers no on the online-marketplace page
    And the user answers no on the give-website-address page
    Then the user is on the business-contact-details page
    And the contact details warnings are displayed for a trader with a previous IOSS registration
    And the user completes details on the business-contact-details page
      | data                            | fieldId         |
      | +441234567890                   | telephoneNumber |
      | email-new-cross-schema@test.com | emailAddress    |
    And the user completes the registration email verification process
    And the bank details warnings are displayed for a trader with a previous IOSS registration
    And the user completes details on the bank-details page
      | data            | fieldId     |
      | Account Name CS | accountName |
    Then the user is at the check-answers page
    Then the user submits their registration
    And the text on the confirmation page is displayed when the trader has made changes and has a previous IOSS registration

  Scenario: Registration for trader with multiple IOSS registrations - amends data
    Given the user accesses the stub url
    When the IOSS registered user signs into OSS registration with IOSS number IM9007231111 and VRN 100005555
    Then the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user chooses Yes on the confirm-vat-details page
    And the user is on the add-uk-trading-name page
    And the correct number of existing trading names are displayed for a trader with multiple IOSS registrations
    And the registration trading name warnings are displayed for a trader with multiple IOSS registrations
    And the user answers yes on the add-uk-trading-name page
    And the user adds cross-schema name on the third uk-trading-name page
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters today for date-of-first-sale
    And the user answers no on the previous-oss page
    And the user clicks through the start-date page
    And the user answers no on the tax-in-eu page
    And the user answers no on the online-marketplace page
    And the user answers no on the give-website-address page
    Then the user is on the business-contact-details page
    And the contact details warnings are displayed for a trader with multiple IOSS registrations
    And the user completes details on the business-contact-details page
      | data            | fieldId         |
      | 123654448485656 | telephoneNumber |
    And the user completes the registration email verification process
    And the bank details warnings are displayed for a trader with multiple IOSS registrations
    And the user completes details on the bank-details page
      | data                   | fieldId |
      | GB29NWBK60161331926819 | iban    |
    Then the user is at the check-answers page
    Then the user submits their registration
    And the text on the confirmation page is displayed when the trader has made changes and has multiple IOSS registrations
@wip
  Scenario: Amend registration for trader with a current IOSS registration - amends data
    Given the user accesses the stub url
    When the IOSS registered user signs into OSS amend with IOSS number IM9001234567 and VRN 300000002
    Then the user is on the change-your-registration page
    And the user selects the change link for amend-add-uk-trading-name
    And the correct number of existing trading names are displayed for a trader with a current IOSS registration
    And the amend trading name warnings are displayed for a trader with a current IOSS registration
    Then the user selects the change link for amend-uk-trading-name\/2
    And the user amends answer to Trading name cross-schema two
    Then the user is on the amend-add-uk-trading-name page
    When the user selects the remove link for amend-remove-uk-trading-name\/1
    And the user answers yes on the amend-remove-uk-trading-name/1 page
    Then the user answers no on the amend-add-uk-trading-name page
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-business-contact-details
    And the contact details warnings are displayed for a trader with a current IOSS registration
    And the user amends details on the amend-business-contact-details page
      | data                   | fieldId      |
      | CS full-name           | fullName     |
      | email-cs-test@test.com | emailAddress |
    And the user completes the amend email verification process
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-bank-details
    And the bank details warnings are displayed for a trader with a current IOSS registration
    And the user amends details on the amend-bank-details page
      | data                      | fieldId     |
      | CS Name                   | accountName |
      | ABCDDD2A                  | bic         |
      | GB33BUKB20201555555555555 | iban        |
    Then the user is on the change-your-registration page
    When the user presses the submit button
    Then the user is on the successful-amend page
    And all of the updated answers are displayed as changed on the amend confirmation page for a current IOSS registration
    And the text on the confirmation page is displayed when the trader has made changes and has a current IOSS registration

  Scenario: Amend registration for trader with a previous IOSS registration - amends data
    Given the user accesses the stub url
    When the IOSS registered user signs into OSS amend with IOSS number IM9019999997 and VRN 300000002
    Then the user is on the change-your-registration page
    And the user selects the change link for amend-add-uk-trading-name
    And the correct number of existing trading names are displayed for a trader with a previous IOSS registration
    And the amend trading name warnings are displayed for a trader with a previous IOSS registration
    Then the user selects the change link for amend-uk-trading-name\/2
    And the user amends answer to Trading name cross-schema two
    Then the user answers no on the amend-add-uk-trading-name page
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-business-contact-details
    And the contact details warnings are displayed for a trader with a previous IOSS registration
    And the user amends details on the amend-business-contact-details page
      | data         | fieldId  |
      | CS full-name | fullName |
    And the user completes the amend email verification process
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-bank-details
    And the bank details warnings are displayed for a trader with a previous IOSS registration
    And the user amends details on the amend-bank-details page
      | data                   | fieldId |
      | GB29NWBK60161331926819 | iban    |
    Then the user is on the change-your-registration page
    When the user presses the submit button
    Then the user is on the successful-amend page
    And all of the updated answers are displayed as changed on the amend confirmation page for a previous IOSS registration
    And the text on the confirmation page is displayed when the trader has made changes and has a previous IOSS registration

  Scenario: Amend registration for trader with multiple IOSS registrations - amends data
    Given the user accesses the stub url
    When the IOSS registered user signs into OSS amend with IOSS number IM9007231111 and VRN 300000002
    Then the user is on the change-your-registration page
    And the user selects the change link for amend-add-uk-trading-name
    And the correct number of existing trading names are displayed for a trader with multiple IOSS registrations
    And the amend trading name warnings are displayed for a trader with multiple IOSS registrations
    When the user selects the remove link for amend-remove-uk-trading-name\/1
    And the user answers yes on the amend-remove-uk-trading-name/1 page
    Then the user answers no on the amend-add-uk-trading-name page
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-business-contact-details
    And the contact details warnings are displayed for a trader with multiple IOSS registrations
    And the user amends details on the amend-business-contact-details page
      | data                   | fieldId      |
      | email-cs-test@test.com | emailAddress |
    And the user completes the amend email verification process
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-bank-details
    And the bank details warnings are displayed for a trader with multiple IOSS registrations
    And the user amends details on the amend-bank-details page
      | data    | fieldId     |
      | CS Name | accountName |
    Then the user is on the change-your-registration page
    When the user presses the submit button
    Then the user is on the successful-amend page
    And all of the updated answers are displayed as changed on the amend confirmation page for multiple IOSS registrations
    And the text on the confirmation page is displayed when the trader has made changes and has multiple IOSS registrations

  Scenario: Rejoin registration for trader with a current IOSS registration - amends data
    Given the user accesses the stub url
    When the IOSS registered user signs into OSS rejoin with IOSS number IM9001234567 and VRN 600000050
    Then the user is on the rejoin-already-made-sales page
    When the user answers yes on the rejoin-already-made-sales page
    Then the user enters today for date-of-first-sale
    Then the rejoin-start-date page displays a commencement date of today
    And the user presses the continue button
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-add-uk-trading-name
    And the correct number of existing trading names are displayed for a trader with a current IOSS registration
    And the rejoin trading name warnings are displayed for a trader with a current IOSS registration
    Then the user selects the change link for rejoin-amend-uk-trading-name\/2
    And the user amends answer to Trading name cross-schema two
    Then the user is on the rejoin-amend-add-uk-trading-name page
    When the user selects the remove link for rejoin-amend-remove-uk-trading-name\/1
    And the user answers yes on the rejoin-amend-remove-uk-trading-name/1 page
    Then the user answers no on the rejoin-amend-add-uk-trading-name page
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-business-contact-details
    And the contact details warnings are displayed for a trader with a current IOSS registration
    And the user amends details on the rejoin-amend-business-contact-details page
      | data                   | fieldId      |
      | CS full-name           | fullName     |
      | email-cs-test@test.com | emailAddress |
    And the user completes the rejoin email verification process
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-bank-details
    And the bank details warnings are displayed for a trader with a current IOSS registration
    And the user amends details on the rejoin-amend-bank-details page
      | data                      | fieldId     |
      | CS Name                   | accountName |
      | ABCDDD2A                  | bic         |
      | GB33BUKB20201555555555555 | iban        |
    Then the user is on the rejoin-registration page
    When the user presses the submit button
    Then the user is on the successful-rejoin page
    And the text on the confirmation page is displayed when the trader has made changes and has a current IOSS registration

  Scenario: Rejoin registration for trader with a previous IOSS registration - amends data
    Given the user accesses the stub url
    When the IOSS registered user signs into OSS rejoin with IOSS number IM9019999997 and VRN 600000050
    Then the user is on the rejoin-already-made-sales page
    And the user answers yes on the rejoin-already-made-sales page
    Then the user enters today for date-of-first-sale
    Then the rejoin-start-date page displays a commencement date of today
    And the user presses the continue button
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-add-uk-trading-name
    And the correct number of existing trading names are displayed for a trader with a previous IOSS registration
    And the rejoin trading name warnings are displayed for a trader with a previous IOSS registration
    Then the user selects the change link for rejoin-amend-uk-trading-name\/1
    And the user amends answer to Trading name cross-schema 1
    Then the user is on the rejoin-amend-add-uk-trading-name page
    Then the user answers no on the rejoin-amend-add-uk-trading-name page
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-business-contact-details
    And the contact details warnings are displayed for a trader with a previous IOSS registration
    And the user amends details on the rejoin-amend-business-contact-details page
      | data                   | fieldId      |
      | email-cs-test@test.com | emailAddress |
    And the user completes the rejoin email verification process
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-bank-details
    And the bank details warnings are displayed for a trader with a previous IOSS registration
    And the user amends details on the rejoin-amend-bank-details page
      | data     | fieldId |
      | ABCDDD2A | bic     |
    Then the user is on the rejoin-registration page
    When the user presses the submit button
    Then the user is on the successful-rejoin page
    And the text on the confirmation page is displayed when the trader has made changes and has a previous IOSS registration

  Scenario: Rejoin registration for trader with multiple IOSS registrations - amends data
    Given the user accesses the stub url
    When the IOSS registered user signs into OSS rejoin with IOSS number IM9007231111 and VRN 600000050
    Then the user is on the rejoin-already-made-sales page
    And the user answers yes on the rejoin-already-made-sales page
    Then the user enters today for date-of-first-sale
    Then the rejoin-start-date page displays a commencement date of today
    And the user presses the continue button
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-add-uk-trading-name
    And the correct number of existing trading names are displayed for a trader with multiple IOSS registrations
    And the rejoin trading name warnings are displayed for a trader with multiple IOSS registrations
    When the user selects the remove link for rejoin-remove-uk-trading-name\/2
    And the user answers yes on the rejoin-remove-uk-trading-name/2 page
    Then the user answers no on the rejoin-add-uk-trading-name page
    Then the user is on the change-your-registration page
    When the user selects the change link for rejoin-business-contact-details
    And the contact details warnings are displayed for a trader with multiple IOSS registrations
    And the user amends details on the rejoin-business-contact-details page
      | data         | fieldId  |
      | CS full-name | fullName |
    And the user completes the rejoin email verification process
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-bank-details
    And the bank details warnings are displayed for a trader with multiple IOSS registrations
    And the user amends details on the rejoin-bank-details page
      | data                      | fieldId     |
      | CS Name                   | accountName |
      | GB33BUKB20201555555555555 | iban        |
    Then the user is on the rejoin-registration page
    When the user presses the submit button
    Then the user is on the successful-rejoin page
    And the text on the confirmation page is displayed when the trader has made changes and has multiple IOSS registrations

  Scenario: Registration for trader with multiple IOSS registrations - does not amend data
    Given the user accesses the stub url
    When the IOSS registered user signs into OSS registration with IOSS number IM9007231111 and VRN 100005555
    Then the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user chooses Yes on the confirm-vat-details page
    And the user is on the add-uk-trading-name page
    And the correct number of existing trading names are displayed for a trader with multiple IOSS registrations
    And the registration trading name warnings are displayed for a trader with multiple IOSS registrations
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters today for date-of-first-sale
    And the user answers no on the previous-oss page
    And the user clicks through the start-date page
    And the user answers no on the tax-in-eu page
    And the user answers no on the online-marketplace page
    And the user answers no on the give-website-address page
    Then the user is on the business-contact-details page
    And the contact details warnings are displayed for a trader with multiple IOSS registrations
    And the user presses the continue button
    And the user completes the registration email verification process
    Then the user is on the bank-details page
    And the bank details warnings are displayed for a trader with multiple IOSS registrations
    And the user presses the continue button
    Then the user is at the check-answers page
    Then the user submits their registration
    And the text on the confirmation page is not displayed when the trader has not made changes and has multiple IOSS registrations

  Scenario: Amend registration for trader with multiple IOSS registrations - does not amend data
    Given the user accesses the stub url
    When the IOSS registered user signs into OSS amend with IOSS number IM9007231111 and VRN 600000050
    Then the user is on the change-your-registration page
    And the user presses the submit button
    Then the user is on the successful-amend page
    And the confirmation of no answers changed is displayed
    And the text on the confirmation page is not displayed when the trader has not made changes and has multiple IOSS registrations

  Scenario: Rejoin registration for trader with multiple IOSS registrations - does not amend data
    Given the user accesses the stub url
    When the IOSS registered user signs into OSS rejoin with IOSS number IM9007231111 and VRN 600000050
    Then the user is on the rejoin-already-made-sales page
    When the user answers yes on the rejoin-already-made-sales page
    Then the user enters today for date-of-first-sale
    Then the rejoin-start-date page displays a commencement date of today
    And the user presses the continue button
    Then the user is on the rejoin-registration page
    When the user presses the submit button
    Then the user is on the successful-rejoin page
    And the text on the confirmation page is not displayed when the trader has not made changes and has multiple IOSS registrations

  Scenario: Registration for trader with no other registrations - amends data
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100005555 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers yes on the have-uk-trading-name page
    And the user adds Only Trading Name on the first uk-trading-name page
    And the user is on the add-uk-trading-name page
    And the correct number of existing trading names are displayed for a trader with no IOSS registrations
    And the registration trading name warnings are not displayed for a trader with no IOSS registrations
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters today for date-of-first-sale
    And the user answers no on the previous-oss page
    And the user clicks through the start-date page
    And the user answers no on the tax-in-eu page
    And the user answers no on the online-marketplace page
    And the user answers no on the give-website-address page
    Then the user is on the business-contact-details page
    And the contact details warnings are not displayed for a trader with no IOSS registrations
    And the contact details are blank
    And the user completes details on the business-contact-details page
      | data           | fieldId         |
      | Joe Bloggs     | fullName        |
      | 01234567890    | telephoneNumber |
      | email@test.com | emailAddress    |
    And the user completes the registration email verification process
    Then the user is on the bank-details page
    And the bank details warnings are not displayed for a trader with no IOSS registrations
    And the bank details are blank
    And the user completes details on the bank-details page
      | data                   | fieldId     |
      | Account Name           | accountName |
      | ABCDEF2A               | bic         |
      | GB33BUKB20201555555555 | iban        |
    Then the user is at the check-answers page
    Then the user submits their registration
    And the text on the confirmation page is not displayed when the trader has made changes and has no IOSS registrations

  Scenario: Amend registration for trader with no other registrations - amends data
    Given a registered user with VRN 300000002 accesses the amend registration journey
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-add-uk-trading-name
    And only the existing trading names are displayed for a trader with no IOSS registrations
    And the amend trading name warnings are not displayed for a trader with no IOSS registrations
    Then the user selects the change link for amend-uk-trading-name\/2
    And the user amends answer to Trading name cross-schema two
    Then the user is on the amend-add-uk-trading-name page
    When the user selects the remove link for amend-remove-uk-trading-name\/1
    And the user answers yes on the amend-remove-uk-trading-name/1 page
    Then the user answers no on the amend-add-uk-trading-name page
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-business-contact-details
    And the contact details warnings are not displayed for a trader with no IOSS registrations
    And the user amends details on the amend-business-contact-details page
      | data                   | fieldId      |
      | CS full-name           | fullName     |
      | email-cs-test@test.com | emailAddress |
    And the user completes the amend email verification process
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-bank-details
    And the bank details warnings are not displayed for a trader with no IOSS registrations
    And the user amends details on the amend-bank-details page
      | data                      | fieldId     |
      | CS Name                   | accountName |
      | ABCDDD2A                  | bic         |
      | GB33BUKB20201555555555555 | iban        |
    Then the user is on the change-your-registration page
    When the user presses the submit button
    Then the user is on the successful-amend page
    And all of the updated answers are displayed as changed on the amend confirmation page for no IOSS registrations
    And the text on the confirmation page is not displayed when the trader has made changes and has no IOSS registrations

  Scenario: Rejoin registration for trader with no other registrations - amends data
    Given a registered user with VRN 600000050 accesses the rejoin registration journey
    Then the user is on the rejoin-already-made-sales page
    When the user answers yes on the rejoin-already-made-sales page
    Then the user enters today for date-of-first-sale
    Then the rejoin-start-date page displays a commencement date of today
    And the user presses the continue button
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-add-uk-trading-name
    And the correct number of existing trading names are displayed for a trader with no IOSS registrations
    And the rejoin trading name warnings are not displayed for a trader with no IOSS registrations
    Then the user selects the change link for rejoin-amend-uk-trading-name\/1
    And the user amends answer to Trading name cross-schema 1
    Then the user is on the rejoin-amend-add-uk-trading-name page
    Then the user answers no on the rejoin-amend-add-uk-trading-name page
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-business-contact-details
    And the contact details warnings are not displayed for a trader with no IOSS registrations
    And the user amends details on the rejoin-amend-business-contact-details page
      | data                   | fieldId      |
      | email-cs-test@test.com | emailAddress |
    And the user completes the rejoin email verification process
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-bank-details
    And the bank details warnings are not displayed for a trader with no IOSS registrations
    And the user amends details on the rejoin-amend-bank-details page
      | data     | fieldId |
      | ABCDDD2A | bic     |
    Then the user is on the rejoin-registration page
    When the user presses the submit button
    Then the user is on the successful-rejoin page
    And the text on the confirmation page is not displayed when the trader has made changes and has no IOSS registrations

