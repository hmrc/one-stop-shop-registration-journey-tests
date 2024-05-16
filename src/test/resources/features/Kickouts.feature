@Registration @Accessibility
Feature: Not Eligible for One Stop Shop

  Scenario: Business is already registered in another county
    Given the user accesses the service
    And the user answers yes on the already-eu-registered page
    Then the user is on the return-later-already-eu-registered page

  Scenario: Business not selling goods from Northern Ireland
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers no on the sell-from-northern-ireland page
    Then the user is on the do-not-sell-from-northern-ireland page

  Scenario: Business outside NI only selling via an online marketplace
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers no on the northern-ireland-business page
    And the user answers no on the northern-ireland-fixed-establishment page
    And the user picks Online Marketplace on the sales-on-marketplaces page
    Then the user is on the cannot-use-no-vat page

  Scenario: Business outside NI selling some goods via an online marketplace
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers no on the northern-ireland-business page
    And the user answers no on the northern-ireland-fixed-establishment page
    And the user picks Mixed on the sales-on-marketplaces page
    Then the user is on the do-not-pay-sales-on-marketplace page

  Scenario: Business outside NI not selling via an online marketplace
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers no on the northern-ireland-business page
    And the user answers no on the northern-ireland-fixed-establishment page
    And the user picks Not Online Marketplace on the sales-on-marketplaces page
    Then the user is on the business-pay page

  Scenario: Incorrect UK VAT details
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses No, details incorrect on the confirm-vat-details page
    Then the user is on the update-vat-details page

  Scenario: Use different UK VAT details
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses No, wrong account on the confirm-vat-details page
    Then the user is on the register-different-business page

  Scenario: Will not make sales in this quarter
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers no on the have-uk-trading-name page
    And the user answers no on the already-made-sales page
    And the user answers no on the planned-first-sale page
    Then the user is on the register-later page

  Scenario: NI Protocol Rejection
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 500000001 and strong credentials
    Then the user is on the cannot-register-ni-protocol page

  Scenario: Vat details Api down with vrn number starting with 8
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 800000001 and strong credentials
    Then the user is on the registration-service-error page

  Scenario:Scenario: Vat details Api down with vrn number starting with 9
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 900000001 and strong credentials
    Then the user is on the registration-service-error page

  Scenario: An unauthorised error from ETMP when submitting a registration
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 666000004 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers no on the have-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters yesterday for date-of-first-sale
    And the user answers no on the previous-oss page
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
      | data                    | fieldId         |
      | Account Name            | accountName     |
      | ABCDEF2A                | bic             |
      | GB33BUKB20201555555555  | iban            |
    And the user is at the check-answers page
    And the user selects the register button
    Then the user is on the error-submitting-registration page

  Scenario: Error creating enrolment when submitting registration to ETMP
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 222222233 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers no on the have-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters yesterday for date-of-first-sale
    And the user answers no on the previous-oss page
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
      | data                    | fieldId         |
      | Account Name            | accountName     |
      | ABCDEF2A                | bic             |
      | GB33BUKB20201555555555  | iban            |
    And the user is at the check-answers page
    And the user selects the register button
    Then the user is on the error-submitting-registration page

  Scenario: An error from ETMP when submitting a registration accessed via BTA
    Given the user accesses the stub url
    And the user signs in as an Organisation Admin with Hmrc Mdt VAT enrolment 666000001 and strong credentials via authwiz
    Then the user manually navigates to the from-external link
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user chooses Yes on the confirm-vat-details page
    And the user answers no on the have-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters yesterday for date-of-first-sale
    And the user answers no on the previous-oss page
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
      | data                    | fieldId         |
      | Account Name            | accountName     |
      | ABCDEF2A                | bic             |
      | GB33BUKB20201555555555  | iban            |
    And the user is at the check-answers page
    And the user selects the register button
    Then the user is on the error-submitting-registration page

  Scenario: User who already has an OSS VAT enrolment but has no saved registration sees an error page
    Given the user accesses the stub url
    And the user signs in as an Organisation Admin with Hmrc Mdt and OSS VAT enrolment 100000700 and strong credentials
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    Then the user is on the account-restore-error page

  Scenario: User who already has an OSS VAT enrolment and a saved registration lands on the already-registered page
    Given the user accesses the stub url
    And the user signs in as an Organisation Admin with Hmrc Mdt and OSS VAT enrolment 100000003 and strong credentials
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    Then the user is on the already-registered page

  Scenario: Submitting a registration when the user has no OSS enrolment but is already registered on ETMP
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 222222223 and strong credentials
    Then the user is on the already-registered page

  Scenario: A user who has not previously registered for OSS cannot access the amend registration journey
    Given a non-registered user with VRN 100000700 accesses the amend registration journey
    Then the user is on the cannot-use-not-registered page

  Scenario: A user is directed to an error page when there is an issue submitting their amended registration
    Given a registered user with VRN 600000022 accesses the amend registration journey
    Then the user is on the change-your-registration page
    When the user presses the continue button
    Then the user is on the error-submitting-amendment page
    When the user clicks on the try again later link
    Then the user is on the change-your-registration page
    When the user presses the continue button
    And the user clicks on the back to your account link
    Then the user is on the your-account page

  Scenario: A historic user who was registered on oss without an enrolment can't access the amend journey
    Given a non-registered user with VRN 300000002 accesses the amend registration journey
    Then the user is presented with the technical difficulties page

  Scenario: User with expired VRN cannot register
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 600000001 and strong credentials
    Then the user is on the invalid-vrn-date page


