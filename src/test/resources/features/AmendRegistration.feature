@Registration
Feature: Amending a registration for One Stop Shop

  @ZAP @Accessibility
  Scenario: A user can amend all of the answers on their registration - first combination (no to yes)
    Given a registered user with VRN 300000001 accesses the amend registration journey
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-have-uk-trading-name
    Then the user answers yes on the amend-have-uk-trading-name page
    And the user adds my trading name on the first amend-uk-trading-name page
    Then the user answers yes on the amend-add-uk-trading-name page
    And the user adds another company on the second amend-uk-trading-name page
    Then the user answers no on the amend-add-uk-trading-name page
    And the user is on the change-your-registration page
    When the user selects the change link for amend-previous-oss
    Then the user answers yes on the amend-previous-oss page
    And the user selects Finland on the first amend-previous-country page
    And the user answer oss on the amend-previous-scheme/1/1 page
    And the user add FI11111111 on the first amend-previous-oss-scheme-number page
    And the user answers yes on the amend-previous-scheme-answers/1 page
    And the user answer ioss on the amend-previous-scheme/1/2 page
    And the user answers no on the amend-previous-ioss-scheme/1/2 page
    And the user inputs ioss reg number IM2467777777 on the amend-previous-ioss-number/1/2 page
    And the user presses the continue button
    And the user answers no on the amend-previous-scheme-answers/1 page
    Then the user answers no on the amend-previous-schemes-overview page
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
    When the user selects the change link for amend-business-contact-details
    And the user amends details on the amend-business-contact-details page
      | data              | fieldId         |
      | Another full name | fullName        |
      | 09852355522525    | telephoneNumber |
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-bank-details
    And the user amends details on the amend-bank-details page
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
    When the user selects the add link for amend-previous-schemes-overview
    Then the user selects the change link for amend-previous-scheme-answers\/2
    And the user answers yes on the amend-previous-scheme-answers/2 page
    And the user answer oss on the amend-previous-scheme/2/2 page
    And the user add BG987654321 on the second amend-previous-oss-scheme-number page
    And the user answers no on the amend-previous-scheme-answers/2 page
    Then the user answers yes on the amend-previous-schemes-overview page
    And the user selects Spain on the fifth amend-previous-country page
    And the user answer ioss on the amend-previous-scheme/5/1 page
    And the user answers yes on the amend-previous-ioss-scheme/5/1 page
    And the user inputs ioss reg number IM7241234567 on the amend-previous-ioss-number/5/1 page
    And the user inputs intermediary identification number IN7241234567 on the amend-previous-ioss-number/5/1 page
    Then the user answers yes on the amend-previous-scheme-answers/5 page
    And the user answer oss on the amend-previous-scheme/5/2 page
    And the user add ESX1234567X on the fifth amend-previous-oss-scheme-number page
    Then the user selects the remove link for amend-remove-previous-scheme\/5\/2
    And the user answers yes on the amend-remove-previous-scheme/5/2 page
    And the user answers no on the amend-previous-scheme-answers/5 page
    Then the user answers yes on the amend-previous-schemes-overview page
    And the user selects Malta on the sixth amend-previous-country page
    And the user answer oss on the amend-previous-scheme/6/1 page
    And the user add MT12345666 on the sixth amend-previous-oss-scheme-number page
    And the user answers no on the amend-previous-scheme-answers/6 page
    Then the user selects the remove link for amend-remove-deregistration\/6
    And the user answers yes on the amend-remove-deregistration/6 page
    Then the user answers no on the amend-previous-schemes-overview page
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-add-tax-details
    Then the user selects the change link for amend-check-tax-details\/2
    And the user selects the change link for amend-sells-goods-to-eu-consumers\/2
    Then the user answers yes on the amend-sells-goods-to-eu-consumers/2 page
    And the user answer fixed establishment on the amend-sells-goods-to-eu-consumer-method/2 page
    And the user answer vat number on the amend-registration-type/2 page
    And the user clicks continue on the second amend-eu-vat-number page
    And the user adds Amsterdam trading on the second amend-eu-trading-name page
    And the user completes details on the amend-eu-fixed-establishment-address/2 page
      | data               | fieldId    |
      | 123 Address Street | line1      |
      | A Town-City        | townOrCity |
      | AM4563 H           | postCode   |
    Then the user clicks continue on the second amend-check-tax-details page
    When the user selects the change link for amend-check-tax-details\/1
    Then the user selects the change link for amend-sells-goods-to-eu-consumers\/1
    And the user answers no on the amend-sells-goods-to-eu-consumers/1 page
    And the user clicks continue on the first amend-sales-declaration-not-required page
    And the user answers no on the amend-eu-vat/1 page
    Then the user clicks continue on the first amend-no-vat-number-for-eu-country page
    And the user presses the continue button
    When the user selects the remove link for amend-remove-tax-details\/2
    And the user answers yes on the amend-remove-tax-details/2 page
    Then the user answers no on the amend-add-tax-details page
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
    When the user selects the change link for amend-business-contact-details
    And the user amends details on the amend-business-contact-details page
      | data                | fieldId      |
      | Another full-name   | fullName     |
      | email-test@test.com | emailAddress |
    And the user completes the amend email verification process
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

  Scenario: A user is no longer able to amend their start date due to being over the time limit
    Given a registered user with VRN 300000001 accesses the amend registration journey
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-planned-first-sale
    Then the user is on the no-longer-amendable page
    When the user presses the continue button
    Then the user is on the change-your-registration page
    And the user selects the change link for amend-already-made-sales
    Then the user is on the no-longer-amendable page
    When the user presses the continue button
    Then the user is on the change-your-registration page
    When the user presses the continue button
    Then the user is on the successful-amend page

  Scenario: A user is can amend their start date within the time limit
    Given a registered user with VRN 300000003 accesses the amend registration journey
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-already-made-sales
    And the user answers yes on the amend-already-made-sales page
    Then the user enters today for amend-date-of-first-sale
    And the user presses the continue button
    When the user presses the continue button
    Then the user is on the successful-amend page

  Scenario: A user with fixed establishments enters amend registration after having VAT Group changed from No to Yes
    Given a registered user with VRN 777777771 accesses the returns service
    Then the user is on the delete-all-fixed-establishment page
    When the user presses the continue button
    Then the user is on the successful-amend page
    When the user clicks on the Returns account link
    Then the user clicks on the Change your registration link
    And the user selects the change link for amend-add-tax-details
    And the user answers yes on the amend-add-tax-details page
    And the user selects Portugal on the third amend-eu-tax page
    Then the user answers yes on the amend-sells-goods-to-eu-consumers/3 page
    And the user answer fixed establishment on the amend-sells-goods-to-eu-consumer-method/3 page
    Then the user is on the amend-no-fixed-establishments-required/3 page

  Scenario: A user can cancel their registration amends
    Given a registered user with VRN 300000001 accesses the amend registration journey
    Then the user is on the change-your-registration page
    When the user selects the change link for amend-online-marketplace
    Then the user answers yes on the amend-online-marketplace page
    And the user selects the change link for amend-give-website-address
    And the user answers yes on the amend-give-website-address page
    And the user adds www.1stwebsite.org on the first amend-website-address page
    And the user answers yes on the amend-add-website-address page
    And the user adds www.a-website-url.eu on the second amend-website-address page
    And the user answers no on the amend-add-website-address page
    Then the user is on the change-your-registration page
    When the user clicks on the cancel link
    Then the user answers yes on the cancel-amend-registration page
    Then the user is on the your-account page





