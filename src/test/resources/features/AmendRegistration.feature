@Registration @ZAP @Accessibility
Feature: Amending a registration for One Stop Shop
@wip
  Scenario: A user can amend all of the answers on their registration
#  Currently works via an existing registration in the database and pulls it into authenticated user answers
#  This will be amended to use an API to pull the reg from ETMP but will be stubbed/use a test only endpoint to continue using own db for tests
#  Will need a specific account set up in the tests so we know what has been answered and what we are changing
    Given a user with VRN 100000004 accesses the amend registration journey
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-online-marketplace
    Then the user answers yes on the amend-online-marketplace page
    Then the user is on the change-your-registration page
    When the user presses the continue button
#    Then the user is on the amend-confirmation page - not developed yet, says registration already exists
