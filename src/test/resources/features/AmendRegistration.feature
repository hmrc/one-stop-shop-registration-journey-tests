@Registration
Feature: Amending a registration for One Stop Shop

  @ZAP @Accessibility
  Scenario: A user can amend all of the answers on their registration - first combination (no to yes)
#  Currently works via an existing registration in the database and pulls it into authenticated user answers
#  This will be amended to use an API to pull the reg from ETMP but will be stubbed/use a test only endpoint to continue using own db for tests
    Given a registered user with VRN 300000001 accesses the amend registration journey
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-have-uk-trading-name
    Then the user answers yes on the amend-have-uk-trading-name page
    And the user adds my trading name on the first amend-uk-trading-name page
    Then the user answers yes on the amend-add-uk-trading-name page
    And the user adds another company on the second amend-uk-trading-name page
    Then the user answers no on the amend-add-uk-trading-name page
    And the user is on the change-your-registration page
    When the user selects the change link for amend-tax-in-eu
    Then the user answers yes on the amend-tax-in-eu page
    And the user selects Portugal on the first amend-eu-tax page
    Then the user answers yes on the amend-sells-goods-to-eu-consumers/1 page
    And the user answer fixed establishment on the amend-sells-goods-to-eu-consumer-method/1 page
    Then the user answer tax id number on the amend-registration-type/1 page
    And the user adds PT8521472 on the first amend-eu-tax-number page
    And the user adds Portugal Sales on the first amend-eu-trading-name page
    And the user completes details on the amend-eu-fixed-establishment-address/1 page
      | data      | fieldId    |
      | 1 Address | line1      |
      | A Town    | townOrCity |
    And the user clicks continue on the first amend-check-tax-details page
    Then the user answers yes on the amend-add-tax-details page
    And the user selects Slovenia on the second amend-eu-tax page
    Then the user answers yes on the amend-sells-goods-to-eu-consumers/2 page
    And the user answer dispatch warehouse on the amend-sells-goods-to-eu-consumer-method/2 page
    Then the user answer vat number on the amend-registration-type/2 page
    And the user adds SI12345678 on the second amend-eu-vat-number page
    And the user adds Slovenia Goods on the second amend-eu-send-goods-trading-name page
    And the user completes details on the amend-eu-send-goods-address/2 page
      | data      | fieldId    |
      | 1 Address | line1      |
      | A Town    | townOrCity |
      | SL123355  | postCode   |
    And the user clicks continue on the second amend-check-tax-details page
    Then the user answers no on the amend-add-tax-details page
    Then the user is on the change-your-registration page
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
    Then the user is on the successful-amend page

  Scenario: A user can amend all of the answers on their registration - second combination (yes to no/amends)
    Given a registered user with VRN 300000002 accesses the amend registration journey
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-add-uk-trading-name
    Then the user selects the change link for amend-uk-trading-name\/2
    And the user amends answer to Trading name two
    Then the user is on the amend-add-uk-trading-name page
    When the user selects the remove link for amend-remove-uk-trading-name\/1
    And the user answers yes on the amend-remove-uk-trading-name/1 page
    Then the user answers no on the amend-add-uk-trading-name page
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-add-tax-details
    Then the user selects the change link for amend-check-tax-details\/2
    And the user selects the change link for amend-sells-goods-to-eu-consumers\/2
    Then the user answers yes on the amend-sells-goods-to-eu-consumers/2 page
    And the user answer fixed establishment on the amend-sells-goods-to-eu-consumer-method/2 page
    And the user answer vat number on the amend-registration-type/2 page
    And the user adds NL0123456789AB on the second amend-eu-vat-number page
    And the user adds Amsterdam trading on the second amend-eu-trading-name page
    And the user completes details on the amend-eu-fixed-establishment-address/2 page
      | data               | fieldId    |
      | 123 Address Street | line1      |
      | A Town-City        | townOrCity |
      | AM4563 H           | postCode   |
    Then the user clicks continue on the second amend-check-tax-details page
#    Bug 1590
#    When the user selects the change link for amend-check-tax-details\/1
#    Then the user selects the change link for amend-sells-goods-to-eu-consumers\/1
#    And the user answers no on the amend-sells-goods-to-eu-consumers/1 page
#    And the user clicks continue on the first amend-sales-declaration-not-required page
##  this line below not working
#    Then the user answers no on the amend-eu-vat/1 page
#    When the user selects the remove link for amend-remove-tax-details\/3
#    And the user answers yes on the amend-remove-tax-details/3 page
#    Then the user answers no on the amend-add-tax-details page
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
    Then the user is on the successful-amend page

  Scenario: A user can amend all of the answers on their registration - third combination (remove all)
    Given a registered user with VRN 300000002 accesses the amend registration journey
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-have-uk-trading-name
    Then the user answers no on the amend-have-uk-trading-name page
    Then the user answers yes on the amend-remove-all-trading-names page
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-tax-in-eu
    And the user answers no on the amend-tax-in-eu page
    Then the user answers yes on the amend-remove-all-eu-details page
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-give-website-address
    Then the user answers no on the amend-give-website-address page
    Then the user answers yes on the amend-remove-all-websites page
    Then the user is on the change-your-registration page
    When the user presses the continue button
    Then the user is on the successful-amend page




