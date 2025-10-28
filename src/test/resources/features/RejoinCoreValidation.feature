@AmendRejoin
Feature: Core validation during re-register for OSS Scheme

  Scenario: A trader with a quarantined VRN cannot access the rejoin journey
    Given a registered user with VRN 333333222 accesses the rejoin registration journey
    Then the user has been directed to the rejoin quarantine page

  Scenario: A trader with a VRN that is still active on another scheme cannot access the rejoin journey
    Given a registered user with VRN 333333111 accesses the rejoin registration journey
    Then the user is on the rejoin-already-registered-other-country?countryCode=EE page

  Scenario: A trader with a quarantined previous registration retrieved from ETMP cannot access the rejoin journey
    Given a registered user with VRN 333333666 accesses the rejoin registration journey
    Then the user has been directed to the rejoin quarantine page

  Scenario: A trader with a VRN that is still active on a previous registration retrieved from ETMP cannot access the rejoin journey
    Given a registered user with VRN 333333444 accesses the rejoin registration journey
    Then the user is on the rejoin-already-registered-other-country?countryCode=EE page

  Scenario: A trader with a quarantined EU VAT registration retrieved from ETMP cannot access the rejoin journey
    Given a registered user with VRN 333333777 accesses the rejoin registration journey
    Then the user has been directed to the rejoin quarantine page

  Scenario: A trader with a VRN that is still active on an EU VAT registration retrieved from ETMP cannot access the rejoin journey
    Given a registered user with VRN 333333555 accesses the rejoin registration journey
    Then the user is on the rejoin-already-registered-other-country?countryCode=EE page

  Scenario: A trader is unable to rejoin with a quarantined previous OSS scheme
    Given a registered user with VRN 600000019 accesses the rejoin registration journey
    Then the user is on the rejoin-already-made-sales page
    When the user answers yes on the rejoin-already-made-sales page
    Then the user enters today for date-of-first-sale
    Then the rejoin-start-date page displays a commencement date of today
    And the user presses the continue button
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-previous-oss
    Then the user answers yes on the rejoin-amend-previous-oss page
    And the user selects France on the first rejoin-amend-previous-country page
    And the user answer oss on the rejoin-amend-previous-scheme/1/1 page
    And the user add FRXX123456789 on the first rejoin-amend-previous-oss-scheme-number page
    Then the user has been directed to the rejoin quarantine page

  Scenario: A trader is unable to rejoin with a previous OSS scheme that is still active
    Given a registered user with VRN 600000019 accesses the rejoin registration journey
    Then the user is on the rejoin-already-made-sales page
    When the user answers yes on the rejoin-already-made-sales page
    Then the user enters today for date-of-first-sale
    Then the rejoin-start-date page displays a commencement date of today
    And the user presses the continue button
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-previous-oss
    Then the user answers yes on the rejoin-amend-previous-oss page
    And the user selects Germany on the first rejoin-amend-previous-country page
    And the user answer oss on the rejoin-amend-previous-scheme/1/1 page
    And the user add DE123456789 on the first rejoin-amend-previous-oss-scheme-number page
    Then the user is on the rejoin-already-registered-other-country?countryCode=EE page

  Scenario: A trader is unable to rejoin with a quarantined previous IOSS scheme
    Given a registered user with VRN 600000019 accesses the rejoin registration journey
    Then the user is on the rejoin-already-made-sales page
    When the user answers yes on the rejoin-already-made-sales page
    Then the user enters today for date-of-first-sale
    Then the rejoin-start-date page displays a commencement date of today
    And the user presses the continue button
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-previous-oss
    Then the user answers yes on the rejoin-amend-previous-oss page
    And the user selects Greece on the first rejoin-amend-previous-country page
    And the user answer ioss on the rejoin-amend-previous-scheme/1/1 page
    And the user answers no on the rejoin-amend-previous-ioss-scheme/1/1 page
    And the user inputs ioss reg number IM3001234567 on the rejoin-amend-previous-ioss-number/1/1 page
    Then the user has been directed to the rejoin quarantine page

  Scenario: A trader is unable to rejoin with a quarantined previous IOSS scheme with intermediary
    Given a registered user with VRN 600000019 accesses the rejoin registration journey
    Then the user is on the rejoin-already-made-sales page
    When the user answers yes on the rejoin-already-made-sales page
    Then the user enters today for date-of-first-sale
    Then the rejoin-start-date page displays a commencement date of today
    And the user presses the continue button
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-previous-oss
    Then the user answers yes on the rejoin-amend-previous-oss page
    And the user selects Germany on the first rejoin-amend-previous-country page
    And the user answer ioss on the rejoin-amend-previous-scheme/1/1 page
    And the user answers yes on the rejoin-amend-previous-ioss-scheme/1/1 page
    And the user inputs ioss reg number IM2761234567 on the rejoin-amend-previous-ioss-number/1/1 page
    Then the user has been directed to the rejoin quarantine page

  Scenario: A trader is able to rejoin with a previous IOSS scheme that is still active
    Given a registered user with VRN 600000019 accesses the rejoin registration journey
    Then the user is on the rejoin-already-made-sales page
    When the user answers yes on the rejoin-already-made-sales page
    Then the user enters today for date-of-first-sale
    Then the rejoin-start-date page displays a commencement date of today
    And the user presses the continue button
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-previous-oss
    Then the user answers yes on the rejoin-amend-previous-oss page
    And the user selects France on the first rejoin-amend-previous-country page
    And the user answer ioss on the rejoin-amend-previous-scheme/1/1 page
    And the user answers no on the rejoin-amend-previous-ioss-scheme/1/1 page
    And the user inputs ioss reg number IM2501234567 on the rejoin-amend-previous-ioss-number/1/1 page
    And the user answers no on the rejoin-amend-previous-scheme-answers/1 page
    Then the user answers no on the rejoin-amend-previous-schemes-overview page
    Then the user is on the rejoin-registration page
    When the user presses the submit button
    Then the user is on the successful-rejoin page

  Scenario: A trader is unable to rejoin with a quarantined EU registration
    Given a registered user with VRN 600000019 accesses the rejoin registration journey
    Then the user is on the rejoin-already-made-sales page
    When the user answers yes on the rejoin-already-made-sales page
    Then the user enters today for date-of-first-sale
    Then the rejoin-start-date page displays a commencement date of today
    And the user presses the continue button
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-tax-in-eu
    Then the user answers yes on the rejoin-amend-tax-in-eu page
    And the user selects Greece on the first rejoin-amend-eu-tax page
    Then the user answers yes on the rejoin-sells-goods-to-eu-consumers/1 page
    And the user answer fixed establishment on the rejoin-sells-goods-to-eu-consumer-method/1 page
    Then the user answer tax id number on the rejoin-registration-type/1 page
    And the user adds 333333336 on the first rejoin-amend-eu-tax-number page
    Then the user has been directed to the rejoin quarantine page

  Scenario: A trader is unable to rejoin with an EU registration that is still active in another country
    Given a registered user with VRN 600000019 accesses the rejoin registration journey
    Then the user is on the rejoin-already-made-sales page
    When the user answers yes on the rejoin-already-made-sales page
    Then the user enters today for date-of-first-sale
    Then the rejoin-start-date page displays a commencement date of today
    And the user presses the continue button
    Then the user is on the rejoin-registration page
    When the user selects the change link for rejoin-amend-tax-in-eu
    Then the user answers yes on the rejoin-amend-tax-in-eu page
    And the user selects Greece on the first rejoin-amend-eu-tax page
    Then the user answers yes on the rejoin-sells-goods-to-eu-consumers/1 page
    And the user answer fixed establishment on the rejoin-sells-goods-to-eu-consumer-method/1 page
    Then the user answer vat number on the rejoin-registration-type/1 page
    And the user adds EL123456788 on the first rejoin-amend-eu-vat-number page
    Then the user is on the rejoin-already-registered-other-country?countryCode=EE page


