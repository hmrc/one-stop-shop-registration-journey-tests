@Registration
Feature: Amending a registration for One Stop Shop
  @ZAP @Accessibility
  Scenario: A user can amend all of the answers on their registration - first combination (no to yes)
#  Currently works via an existing registration in the database and pulls it into authenticated user answers
#  This will be amended to use an API to pull the reg from ETMP but will be stubbed/use a test only endpoint to continue using own db for tests
    Given a user with VRN 300000001 accesses the amend registration journey
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-have-uk-trading-name
    Then the user answers yes on the amend-have-uk-trading-name page
    And the user adds my trading name on the first amend-uk-trading-name page
    Then the user answers yes on the amend-add-uk-trading-name page
    And the user adds another company on the second amend-uk-trading-name page
    Then the user answers no on the amend-add-uk-trading-name page
    And the user is on the change-your-registration page
    When the user selects the change link for amend-online-marketplace
    Then the user answers yes on the amend-online-marketplace page
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-give-website-address
    Then the user answers yes on the amend-give-website-address page
    And the user adds www.first-website.com on the first amend-website-address page
    And the user answers yes on the amend-add-website-address page
    And the user adds www.anotherwebsiteurl.com on the second amend-website-address page
    And the user answers no on the amend-add-website-address page
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-bank-details
    And the user amends details on the bank-details page
      | data                      | fieldId     |
      | Different Name            | accountName |
      | ABCDDD2A                  | bic         |
      | GB33BUKB20201555555555555 | iban        |
    Then the user is on the change-your-registration page
    When the user presses the continue button
#    Then the user is on the amend-confirmation page - not developed yet, says registration already exists

  Scenario: A user can amend all of the answers on their registration - second combination (yes to no/amends)
    Given a user with VRN 300000002 accesses the amend registration journey
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-add-uk-trading-name
    Then the user selects the change link for amend-uk-trading-name\/2
    And the user amends answer to Trading name two
    Then the user is on the amend-add-uk-trading-name page
    When the user selects the remove link for amend-remove-uk-trading-name\/1
    And the user answers yes on the amend-remove-uk-trading-name/1 page
    Then the user answers no on the amend-add-uk-trading-name page
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-online-marketplace
    Then the user answers no on the amend-online-marketplace page
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-add-website-address
    And the user selects the change link for amend-website-address\/1
    Then the user amends answer to www.anotherwebsite.com
    And the user is on the amend-add-website-address page
    Then the user selects the remove link for amend-remove-website-address\/2
    And the user answers yes on the amend-remove-website-address/2 page
    Then the user answers no on the amend-add-website-address page
    Then the user is on the change-your-registration page
    When the user presses the continue button

  Scenario: A user can amend all of the answers on their registration - third combination (remove all)
    Given a user with VRN 300000002 accesses the amend registration journey
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-have-uk-trading-name
    Then the user answers no on the amend-have-uk-trading-name page
    Then the user answers yes on the amend-remove-all-trading-names page
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-give-website-address
    Then the user answers no on the amend-give-website-address page
    Then the user answers yes on the amend-remove-all-websites page
    Then the user is on the change-your-registration page
    When the user presses the continue button




