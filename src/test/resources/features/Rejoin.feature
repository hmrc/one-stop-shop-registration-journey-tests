@Registration
Feature: Re-register for OSS Scheme

  Scenario: An excluded user who has made sales in this quarter can re-register for the OSS scheme
    Given a registered user with VRN 600000019 accesses the rejoin registration journey
    Then the user is on the rejoin-already-made-sales page
    When the user answers yes on the rejoin-already-made-sales page
    Then the user enters today for date-of-first-sale
    Then the rejoin-start-date page displays a commencement date of today
    And the user presses the continue button
    Then the user is on the rejoin-registration page
    When the user presses the continue button
    Then the user is on the successful-rejoin page

  Scenario: An excluded user who has not made sales in this quarter can re-register for the OSS scheme
    Given a registered user with VRN 600000019 accesses the rejoin registration journey
    Then the user is on the rejoin-already-made-sales page
    When the user answers no on the rejoin-already-made-sales page
    Then the user is on the rejoin-start-date page
    And the commencement date is set to the first day of the next quarter
    And the user presses the continue button
    Then the user is on the rejoin-registration page
    When the user presses the continue button
    Then the user is on the successful-rejoin page

  Scenario: An excluded user can set date of first sale to this quarter and then change to not made sales in this quarter
    Given a registered user with VRN 600000019 accesses the rejoin registration journey
    Then the user is on the rejoin-already-made-sales page
    When the user answers yes on the rejoin-already-made-sales page
    Then the user enters today for date-of-first-sale
    Then the rejoin-start-date page displays a commencement date of today
    And the user presses the continue button
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-already-made-sales
    And the user answers no on the rejoin-already-made-sales page
    And the commencement date is set to the first day of the next quarter
    And the user presses the continue button
    When the user presses the continue button
    Then the user is on the successful-rejoin page

  Scenario: An excluded user who is rejoining the OSS scheme can make amendments to their minimal registration data
    Given a registered user with VRN 600000019 accesses the rejoin registration journey
    Then the user is on the rejoin-already-made-sales page
    When the user answers yes on the rejoin-already-made-sales page
    Then the user enters today for date-of-first-sale
    Then the rejoin-start-date page displays a commencement date of today
    And the user presses the continue button
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-have-uk-trading-name
    And the user answers yes on the rejoin-amend-have-uk-trading-name page
    And the user adds my rejoined trading name on the first rejoin-amend-uk-trading-name page
    Then the user answers yes on the rejoin-amend-add-uk-trading-name page
    And the user adds another rejoin company on the second rejoin-amend-uk-trading-name page
    Then the user answers no on the rejoin-amend-add-uk-trading-name page
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-previous-oss
    Then the user answers yes on the rejoin-amend-previous-oss page
    And the user selects Finland on the first rejoin-amend-previous-country page
    And the user answer oss on the rejoin-amend-previous-scheme/1/1 page
    And the user add FI11111111 on the first rejoin-amend-previous-oss-scheme-number page
    And the user answers yes on the rejoin-amend-previous-scheme-answers/1 page
    And the user answer ioss on the rejoin-amend-previous-scheme/1/2 page
    And the user answers no on the rejoin-amend-previous-ioss-scheme/1/2 page
    And the user inputs ioss reg number IM2467777777 on the rejoin-amend-previous-ioss-number/1/2 page
    And the user presses the continue button
    And the user answers no on the rejoin-amend-previous-scheme-answers/1 page
    Then the user answers no on the rejoin-amend-previous-schemes-overview page
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-tax-in-eu
    Then the user answers yes on the rejoin-amend-tax-in-eu page
    And the user selects Portugal on the first rejoin-amend-eu-tax page
    Then the user answers yes on the rejoin-sells-goods-to-eu-consumers/1 page
    And the user answer fixed establishment on the rejoin-sells-goods-to-eu-consumer-method/1 page
    Then the user answer tax id number on the rejoin-registration-type/1 page
    And the user adds PT8521472 on the first rejoin-amend-eu-tax-number page
    And the user adds Portugal Sales on the first rejoin-amend-eu-trading-name page
    And the user completes details on the rejoin-amend-eu-fixed-establishment-address/1 page
      | data      | fieldId    |
      | 1 Address | line1      |
      | A Town    | townOrCity |
    And the user clicks continue on the first rejoin-amend-check-tax-details page
    Then the user answers yes on the rejoin-amend-add-tax-details page
    And the user selects Slovenia on the second rejoin-amend-eu-tax page
    Then the user answers yes on the rejoin-sells-goods-to-eu-consumers/2 page
    And the user answer dispatch warehouse on the rejoin-sells-goods-to-eu-consumer-method/2 page
    Then the user answer vat number on the rejoin-registration-type/2 page
    And the user adds SI12345678 on the second rejoin-amend-eu-vat-number page
    And the user adds Slovenia Goods on the second rejoin-amend-eu-send-goods-trading-name page
    And the user completes details on the rejoin-amend-eu-send-goods-address/2 page
      | data      | fieldId    |
      | 1 Address | line1      |
      | A Town    | townOrCity |
      | SL123355  | postCode   |
    And the user clicks continue on the second rejoin-amend-check-tax-details page
    Then the user answers no on the rejoin-amend-add-tax-details page
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-give-website-address
    Then the user answers yes on the rejoin-amend-give-website-address page
    And the user adds www.first-rejoin-website.com on the first rejoin-amend-website-address page
    And the user answers yes on the rejoin-amend-add-website-address page
    And the user adds www.anotherrejoinwebsiteurl.com on the second rejoin-amend-website-address page
    And the user answers no on the rejoin-amend-add-website-address page
    Then the user is on the rejoin-registration page
    When the user presses the continue button
    Then the user is on the successful-rejoin page

  Scenario: A trader with non-mandatory answers in original registration set to yes can change to no and rejoin
    Given a registered user with VRN 600000050 accesses the rejoin registration journey
    Then the user is on the rejoin-already-made-sales page
    When the user answers yes on the rejoin-already-made-sales page
    Then the user enters today for date-of-first-sale
    Then the rejoin-start-date page displays a commencement date of today
    And the user presses the continue button
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-have-uk-trading-name
    And the user answers no on the rejoin-amend-have-uk-trading-name page
    And the user answers yes on the rejoin-amend-remove-all-trading-names page
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-tax-in-eu
    Then the user answers no on the rejoin-amend-tax-in-eu page
    And the user answers yes on the amend-remove-all-eu-details page
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-online-marketplace
    Then the user answers no on the rejoin-amend-online-marketplace page
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-give-website-address
    Then the user answers no on the rejoin-amend-give-website-address page
    And the user answers yes on the amend-remove-all-websites page
    Then the user is on the rejoin-registration page
    When the user presses the continue button
    Then the user is on the successful-rejoin page

  Scenario: A trader removes some registration answers and amends mandatory answers during rejoin
    Given a registered user with VRN 600000050 accesses the rejoin registration journey
    Then the user is on the rejoin-already-made-sales page
    When the user answers yes on the rejoin-already-made-sales page
    Then the user enters today for date-of-first-sale
    Then the rejoin-start-date page displays a commencement date of today
    And the user presses the continue button
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-add-tax-details
    Then the user selects the remove link for rejoin-amend-remove-tax-details\/2
    And the user answers yes on the rejoin-amend-remove-tax-details/2 page
    And the user answers no on the rejoin-amend-add-tax-details page
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-add-website-address
    Then the user selects the remove link for rejoin-remove-website-address\/1
    And the user answers yes on the rejoin-remove-website-address/1 page
    And the user answers no on the rejoin-amend-add-website-address page
    Then the user is on the rejoin-registration page
    When the user selects the change link for amend-business-contact-details
    And the user amends details on the rejoin-amend-business-contact-details page
      | data                     | fieldId         |
      | Another full rejoin name | fullName        |
      | 09852355522525           | telephoneNumber |
    And the user completes the rejoin email verification process
    Then the user is on the rejoin-registration page
    When the user selects the change link for amend-bank-details
    And the user amends details on the rejoin-amend-bank-details page
      | data                      | fieldId     |
      | Different Rejoin Name     | accountName |
      | ABCDDD2A                  | bic         |
      | GB33BUKB20201555555555555 | iban        |
    Then the user is on the rejoin-registration page
    When the user presses the continue button
    Then the user is on the successful-rejoin page

  Scenario: A trader can add and remove new previous schemes during rejoin
    Given a registered user with VRN 600000050 accesses the rejoin registration journey
    Then the user is on the rejoin-already-made-sales page
    When the user answers yes on the rejoin-already-made-sales page
    Then the user enters today for date-of-first-sale
    Then the rejoin-start-date page displays a commencement date of today
    And the user presses the continue button
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-previous-schemes-overview
    And the user answers yes on the rejoin-amend-previous-schemes-overview page
    And the user selects Austria on the fifth rejoin-amend-previous-country page
    And the user answer oss on the rejoin-amend-previous-scheme/5/1 page
    And the user adds ATU12345678 on the first rejoin-amend-previous-oss-scheme-number/5 page
    And the user answers yes on the rejoin-amend-previous-scheme-answers/5 page
    And the user answer ioss on the rejoin-amend-previous-scheme/5/2 page
    And the user answers no on the rejoin-amend-previous-ioss-scheme/5/2 page
    And the user inputs ioss reg number IM0407777777 on the rejoin-amend-previous-ioss-number/5/2 page
    And the user presses the continue button
    When the user selects the remove link for rejoin-amend-remove-previous-scheme\/5\/1
    Then the user answers yes on the rejoin-amend-remove-previous-scheme/5/1 page
    And the user answers no on the rejoin-amend-previous-scheme-answers/5 page
    When the user selects the remove link for rejoin-amend-remove-deregistration\/5
    Then the user answers yes on the rejoin-amend-remove-deregistration/5 page
    And the user answers no on the rejoin-amend-previous-schemes-overview page
    Then the user is on the rejoin-registration page
    When the user presses the continue button
    Then the user is on the successful-rejoin page

  Scenario: A trader amends their email address during rejoin
    Given a registered user with VRN 600000019 accesses the rejoin registration journey
    Then the user is on the rejoin-already-made-sales page
    When the user answers yes on the rejoin-already-made-sales page
    Then the user enters today for date-of-first-sale
    Then the rejoin-start-date page displays a commencement date of today
    And the user presses the continue button
    Then the user is on the rejoin-registration page
    When the user selects the change link for amend-business-contact-details
    And the user amends details on the rejoin-amend-business-contact-details page
      | data                  | fieldId      |
      | rejoin-test@email.com | emailAddress |
    And the user completes the rejoin email verification process
    Then the user is on the rejoin-registration page
    When the user presses the continue button
    Then the user is on the successful-rejoin page

  Scenario: A trader who is rejoining cannot remove previous registrations for a country retrieved from ETMP
    Given a registered user with VRN 600000050 accesses the rejoin registration journey
    Then the user is on the rejoin-already-made-sales page
    When the user answers yes on the rejoin-already-made-sales page
    Then the user enters today for date-of-first-sale
    Then the rejoin-start-date page displays a commencement date of today
    And the user presses the continue button
    Then the user is on the rejoin-registration page
    When the user manually navigates to the rejoin-amend-remove-deregistration/1 page
    Then the user is on the cannot-delete-previous-registrations page

  Scenario: A trader who is rejoining cannot remove individual previous registrations retrieved from ETMP
    Given a registered user with VRN 600000050 accesses the rejoin registration journey
    Then the user is on the rejoin-already-made-sales page
    When the user answers yes on the rejoin-already-made-sales page
    Then the user enters today for date-of-first-sale
    Then the rejoin-start-date page displays a commencement date of today
    And the user presses the continue button
    Then the user is on the rejoin-registration page
    When the user manually navigates to the rejoin-amend-remove-previous-scheme/1/1 page
    Then the user is on the cannot-delete-previous-schemes page

  Scenario: A trader with a future exclusion effective date is not able to access the rejoin registration journey
    Given a registered user with VRN 600000018 accesses the rejoin registration journey
    Then the user is on the cannot-rejoin page

  Scenario: An excluded trader with outstanding returns is not able to access the rejoin registration journey
    Given a registered user with VRN 100000025 accesses the rejoin registration journey
    Then the user is on the cannot-rejoin page

  Scenario: A quarantined trader is not able to access the rejoin registration journey
    Given a registered user with VRN 100000026 accesses the rejoin registration journey
    Then the user is on the cannot-rejoin page

  Scenario: A currently registered trader who is not excluded cannot access the rejoin registration journey
    Given a registered user with VRN 100000002 accesses the rejoin registration journey
    Then the user is on the cannot-rejoin page

  Scenario: A currently registered trader who is not excluded cannot access the rejoin registration journey via the amend journey
    Given a registered user with VRN 100000002 accesses the amend registration journey
    And the user is on the change-your-registration page
    When the user manually navigates to the rejoin-registration page
    Then the user is on the cannot-rejoin page

  Scenario: API failure from ETMP when rejoining OSS service
    Given a registered user with VRN 100000301 accesses the rejoin registration journey
    Then the user is on the rejoin-already-made-sales page
    When the user answers yes on the rejoin-already-made-sales page
    Then the user enters today for date-of-first-sale
    Then the rejoin-start-date page displays a commencement date of today
    And the user presses the continue button
    Then the user is on the rejoin-registration page
    When the user presses the continue button
    Then the user is on the error-submitting-rejoin page
    And the user clicks on the back to your account link
    And the user is on the your-account page


