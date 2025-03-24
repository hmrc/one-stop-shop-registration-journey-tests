@Registration
Feature: Cross Schema scenarios

  Scenario: Registration for trader with a current IOSS registration - amends data
    Given the IOSS registered user signs into OSS registration with IOSS number IM9001234567 and VRN 100005555
    When the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    Then the user is on the confirm-vat-details page

  Scenario: Registration for trader with a previous IOSS registration - amends data
    Given the IOSS registered user signs into OSS registration with IOSS number IM9019999997 and VRN 100005555
    When the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    Then the user is on the confirm-vat-details page

  Scenario: Registration for trader with multiple IOSS registrations - amends data
    Given the IOSS registered user signs into OSS registration with IOSS number IM9007231111 and VRN 100005555
    When the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    Then the user is on the confirm-vat-details page

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

