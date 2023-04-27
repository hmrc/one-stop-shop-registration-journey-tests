@Registration @ZAP @Accessibility
Feature: Amending a registration for One Stop Shop

  @wip
  Scenario: A user can amend all of the answers on their registration - first combination
#  Currently works via an existing registration in the database and pulls it into authenticated user answers
#  This will be amended to use an API to pull the reg from ETMP but will be stubbed/use a test only endpoint to continue using own db for tests
    Given a user with VRN 300000001 accesses the amend registration journey
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-online-marketplace
    Then the user answers yes on the amend-online-marketplace page
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-give-website-address
    Then the user answers yes on the amend-give-website-address page
    And the user adds www.first-website.com on the first amend-website-address page
    And the user answers yes on the amend-add-website-address page
    And the user adds www.anotherwebsiteurl.com on the second amend-website-address page
  #  Then change and remove?
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

@wip
  Scenario: A user can amend all of the answers on their registration - second combination
    Given a user with VRN 300000002 accesses the amend registration journey
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-online-marketplace
    Then the user answers no on the amend-online-marketplace page
    Then the user is on the change-your-registration page
#    bug 1575
    When the user selects the change link for amend-add-website-address
#  change one and then remove one
    Then the user answers no on the amend-give-website-address page
    Then the user is on the change-your-registration page
    When the user presses the continue button

  Scenario: A user can amend all of the answers on their registration - third combination
    Given a user with VRN 300000002 accesses the amend registration journey
    Then the user is on the change-your-registration page
    #  Will need ticket pulled in from main when change goes in
#    When the user selects the change link for amend-give-website-address
#    Then the user selects no on the amend-give-website-address page
#   Then the user answers yes on the amend-remove-all-websites page
#    Then the user is on the change-your-registration page

