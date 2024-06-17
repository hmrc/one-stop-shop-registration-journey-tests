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

#    Rejoins with amends scenarios

  Scenario: A trader with a future exclusion effective date is not able to access the rejoin registration journey
    Given a registered user with VRN 600000018 accesses the rejoin registration journey
#    currently not working
#    Then the user is on the cannot-rejoin page

  Scenario: An excluded trader with outstanding returns is not able to access the rejoin registration journey
    Given a registered user with VRN 100000025 accesses the rejoin registration journey
#    currently not working
#    Then the user is on the cannot-rejoin page

  Scenario: A quarantined trader is not able to access the rejoin registration journey
    Given a registered user with VRN 100000026 accesses the rejoin registration journey
#    currently not working
#    Then the user is on the cannot-rejoin page

  Scenario: A currently registered trader who is not excluded cannot access the rejoin registration journey
    Given a registered user with VRN 100000002 accesses the rejoin registration journey
#    currently not working
#    Then the user is on the cannot-rejoin page

  Scenario: A currently registered trader who is not excluded cannot access the rejoin registration journey via the amend journey
    Given a registered user with VRN 100000002 accesses the amend registration journey
    And the user is on the change-your-registration page
    When the user manually navigates to the rejoin-registration page
    Then the user is on the cannot-rejoin page

#    API failure

