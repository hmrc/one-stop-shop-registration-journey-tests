@Registration
Feature: Cross Schema scenarios

  Scenario: Registration for trader with a current IOSS registration - amends data
    Given the IOSS registered user signs into OSS registration with IOSS number IM9001234567 and VRN 100005555
    When the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    Then the user is on the confirm-vat-details page
    And the user is on the add-uk-trading-name page
    And the correct number of existing trading names are displayed for a trader with a current IOSS registration
    And the trading name warnings are displayed for a trader with a current IOSS registration
    And the user clicks remove via list for first uk-trading-name
    And the user answers yes on the remove-uk-trading-name/1 page
    And the user answers yes on the add-uk-trading-name page
    And the user adds second cross schema name on the second uk-trading-name page
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters today for date-of-first-sale
    And the user answers no on the previous-oss page
    And the user answers no on the tax-in-eu page
    And the user answers no on the online-marketplace page
    And the user answers no on the give-website-address page
    Then the user is on the business-contact-details page
    And the contact details warnings are displayed for a trader with a current IOSS registration
    And the user completes details on the business-contact-details page
      | data                  | fieldId  |
      | CrossSchema Full Name | fullName |
    And the user completes the registration email verification process
    And the bank details warnings are displayed for a trader with a current IOSS registration
    And the user completes details on the bank-details page
      | data                   | fieldId     |
      | GB29NWBK60161331926819 | iban        |
    Then the user is at the check-answers page
    Then the user submits their registration
    And the text on the confirmation page is displayed when the trader has made changes and has a current IOSS registration

  Scenario: Registration for trader with a previous IOSS registration - amends data
    Given the IOSS registered user signs into OSS registration with IOSS number IM9019999997 and VRN 100005555
    When the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    Then the user is on the confirm-vat-details page
    And the user is on the add-uk-trading-name page
#    check heading
#    check hint text
#    check warning
#    make amends
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters today for date-of-first-sale
    And the user answers no on the previous-oss page
    And the user answers no on the tax-in-eu page
    And the user answers no on the online-marketplace page
    And the user answers no on the give-website-address page
    Then the user is on the business-contact-details page
#    check hint text
#    check auto-populated
#    check warning
#    make amends
    And the user completes details on the business-contact-details page
      | data           | fieldId         |
      | Joe Bloggs     | fullName        |
      | 01234567890    | telephoneNumber |
      | email@test.com | emailAddress    |
    And the user completes the registration email verification process
  #    check hint text
  #    check auto-populated
  #    check warning
  #    make amends
    And the user completes details on the bank-details page
      | data                   | fieldId     |
      | Account Name           | accountName |
      | ABCDEF2A               | bic         |
      | GB33BUKB20201555555555 | iban        |
    Then the user is at the check-answers page
    Then the user submits their registration
#  check acknowledgement page

  Scenario: Registration for trader with multiple IOSS registrations - amends data
    Given the IOSS registered user signs into OSS registration with IOSS number IM9007231111 and VRN 100005555
    When the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    Then the user is on the confirm-vat-details page
    And the user is on the add-uk-trading-name page
#    check heading
#    check hint text
#    check warning
#    make amends
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters today for date-of-first-sale
    And the user answers no on the previous-oss page
    And the user answers no on the tax-in-eu page
    And the user answers no on the online-marketplace page
    And the user answers no on the give-website-address page
    Then the user is on the business-contact-details page
#    check hint text
#    check auto-populated
#    check warning
#    make amends
    And the user completes details on the business-contact-details page
      | data           | fieldId         |
      | Joe Bloggs     | fullName        |
      | 01234567890    | telephoneNumber |
      | email@test.com | emailAddress    |
    And the user completes the registration email verification process
  #    check hint text
  #    check auto-populated
  #    check warning
  #    make amends
    And the user completes details on the bank-details page
      | data                   | fieldId     |
      | Account Name           | accountName |
      | ABCDEF2A               | bic         |
      | GB33BUKB20201555555555 | iban        |
    Then the user is at the check-answers page
    Then the user submits their registration
#  check acknowledgement page

  Scenario: Amend registration for trader with a current IOSS registration - amends data
    Given the IOSS registered user signs into OSS amend with IOSS number IM9001234567 and VRN 300000002
    When the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    Then the user is on the confirm-vat-details page

  Scenario: Amend registration for trader with a previous IOSS registration - amends data
    Given the IOSS registered user signs into OSS amend with IOSS number IM9019999997 and VRN 300000002
    When the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    Then the user is on the confirm-vat-details page

  Scenario: Amend registration for trader with multiple IOSS registrations - amends data
    Given the IOSS registered user signs into OSS amend with IOSS number IM9007231111 and VRN 300000002
    When the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    Then the user is on the confirm-vat-details page

  Scenario: Rejoin registration for trader with a current IOSS registration - amends data
    Given the IOSS registered user signs into OSS rejoin with IOSS number IM9001234567 and VRN 600000050
    When the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    Then the user is on the confirm-vat-details page

  Scenario: Rejoin registration for trader with a previous IOSS registration - amends data
    Given the IOSS registered user signs into OSS rejoin with IOSS number IM9019999997 and VRN 600000050
    When the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    Then the user is on the confirm-vat-details page

  Scenario: Rejoin registration for trader with multiple IOSS registrations - amends data
    Given the IOSS registered user signs into OSS rejoin with IOSS number IM9007231111 and VRN 600000050
    When the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    Then the user is on the confirm-vat-details page

  Scenario: Registration for trader with multiple IOSS registrations - does not amend data
    Given the IOSS registered user signs into OSS registration with IOSS number IM9007231111 and VRN 600000050
    When the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    Then the user is on the confirm-vat-details page
    And the user is on the add-uk-trading-name page
#    check heading
#    check hint text
#    check warning
#    don't make amends
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters today for date-of-first-sale
    And the user answers no on the previous-oss page
    And the user answers no on the tax-in-eu page
    And the user answers no on the online-marketplace page
    And the user answers no on the give-website-address page
    Then the user is on the business-contact-details page
#    check hint text
#    check auto-populated
#    check warning
#    don't make amends
    And the user completes details on the business-contact-details page
      | data           | fieldId         |
      | Joe Bloggs     | fullName        |
      | 01234567890    | telephoneNumber |
      | email@test.com | emailAddress    |
    And the user completes the registration email verification process
  #    check hint text
  #    check auto-populated
  #    check warning
  #    don't make amends
    And the user completes details on the bank-details page
      | data                   | fieldId     |
      | Account Name           | accountName |
      | ABCDEF2A               | bic         |
      | GB33BUKB20201555555555 | iban        |
    Then the user is at the check-answers page
    Then the user submits their registration
#  check acknowledgement page

  Scenario: Amend registration for trader with multiple IOSS registrations - does not amend data
    Given the IOSS registered user signs into OSS amend with IOSS number IM9007231111 and VRN 600000050
    When the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    Then the user is on the confirm-vat-details page

  Scenario: Rejoin registration for trader with multiple IOSS registrations - does not amend data
    Given the IOSS registered user signs into OSS rejoin with IOSS number IM9007231111 and VRN 600000050
    When the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    Then the user is on the confirm-vat-details page

  Scenario: Registration for trader with no other registrations - amends data
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100005555 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers yes on the have-uk-trading-name page
    And the user adds Trading Name on the first uk-trading-name page
    And the user is on the add-uk-trading-name page
#    check heading
#    check hint text
#    check warning
#    make amends
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters today for date-of-first-sale
    And the user answers no on the previous-oss page
    And the user answers no on the tax-in-eu page
    And the user answers no on the online-marketplace page
    And the user answers no on the give-website-address page
    Then the user is on the business-contact-details page
#    check hint text
#    check not auto-populated
#    check warning
#    make amends
    And the user completes details on the business-contact-details page
      | data           | fieldId         |
      | Joe Bloggs     | fullName        |
      | 01234567890    | telephoneNumber |
      | email@test.com | emailAddress    |
    And the user completes the registration email verification process
  #    check hint text
  #    check not auto-populated
  #    check warning
  #    make amends
    And the user completes details on the bank-details page
      | data                   | fieldId     |
      | Account Name           | accountName |
      | ABCDEF2A               | bic         |
      | GB33BUKB20201555555555 | iban        |
    Then the user is at the check-answers page
    Then the user submits their registration
#  check acknowledgement page

  Scenario: Amend registration for trader with no other registrations - amends data
    Given a registered user with VRN 300000002 accesses the amend registration journey
    Then the user is on the change-your-registration page

  Scenario: Rejoin registration for trader with no other registrations - amends data
    Given a registered user with VRN 600000050 accesses the rejoin registration journey
    Then the user is on the rejoin-already-made-sales page
    When the user answers yes on the rejoin-already-made-sales page
    Then the user enters today for date-of-first-sale
    Then the rejoin-start-date page displays a commencement date of today
    And the user presses the continue button
    Then the user is on the rejoin-registration page

