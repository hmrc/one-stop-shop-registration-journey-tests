@Registration
Feature: Check Your Answers

  Scenario: Changing answers in Check Your Answers
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers no on the have-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters yesterday for date-of-first-sale
    And the user answers yes on the previous-oss page
    And the user selects Latvia on the first previous-country page
    And the user answer oss on the previous-scheme/1/1 page
    And the user add LV01234567899 on the first previous-oss-scheme-number page
    Then the user is on the previous-scheme-answers/1 page
    And the user answers no on the previous-scheme-answers/1 page
    And the user answers no on the previous-schemes-overview page
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
      | data                   | fieldId     |
      | Account Name           | accountName |
      | ABCDEF2A               | bic         |
      | GB33BUKB20201555555555 | iban        |
    Then the user is at the check-answers page
    Then the user selects the change link for check-have-uk-trading-name
    And the user answers yes on the check-have-uk-trading-name page
    And the user adds Foo on the first check-uk-trading-name page
    And the user answers yes on the check-add-uk-trading-name page
    And the user adds Foo Two on the second check-uk-trading-name page
    And the user answers no on the check-add-uk-trading-name page
    Then the user is at the check-answers page
    Then the user selects the change link for check-tax-in-eu
    And the user answers yes on the check-tax-in-eu page
    And the user selects Poland on the first check-eu-tax page
    And the user chooses yes on the first check-sells-goods-to-eu-consumers page
    And the user answer fixed establishment on the check-sells-goods-to-eu-consumer-method/1 page
    And the user answer vat number on the check-registration-type/1 page
    And the user adds PL1234567890 on the first check-eu-vat-number page
    And the user adds soo on the first check-eu-trading-name page
    And the user completes details on the check-eu-fixed-establishment-address/1 page
      | data      | fieldId    |
      | 1 Address | line1      |
      | A Town    | townOrCity |
    And the user clicks continue on the first change-check-tax-details page
    And the user answers yes on the check-add-tax-details page
    And the user selects Finland on the second check-eu-tax page
    And the user chooses yes on the second check-sells-goods-to-eu-consumers page
    And the user answer fixed establishment on the check-sells-goods-to-eu-consumer-method/2 page
    And the user answer vat number on the check-registration-type/2 page
    And the user adds FI12345678 on the second check-eu-vat-number page
    And the user adds roo on the second check-eu-trading-name page
    And the user completes details on the check-eu-fixed-establishment-address/2 page
      | data      | fieldId    |
      | 1 Address | line1      |
      | A Town    | townOrCity |
    And the user clicks continue on the second change-check-tax-details page
    And the user answers no on the check-add-tax-details page
    Then the user is at the check-answers page
    Then the user selects the change link for check-previous-schemes-overview
    Then the user answers yes on the check-previous-schemes-overview page
    And the user selects Austria on the second check-previous-country page
    And the user answers oss on the check-previous-scheme/2/1 page
    And the user enters ATU99999999 on the check-previous-oss-scheme-number/2/1 page
    And the user answers no on the check-previous-scheme-answers/2 page
    And the user answers no on the previous-schemes-overview page
    Then the user is at the check-start-date page
    And the user presses the continue button
    Then the user is at the check-answers page
    Then the user selects the change link for check-give-website-address
    And the user answers yes on the check-give-website-address page
    And the user adds www.example.com on the first check-website-address page
    And the user answers yes on the check-add-website-address page
    And the user adds www.second-example.com on the second check-website-address page
    And the user is on the check-add-website-address page
    And the user selects the remove link for check-remove-website-address\/2
    Then the user answers yes on the check-remove-website-address/2 page
    And the user answers no on the check-add-website-address page
    Then the user is at the check-answers page
    Then the user submits their registration

  Scenario: Changing answers from yes to no from CYA to show delete all pages
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers yes on the have-uk-trading-name page
    And the user adds Trading Name on the first uk-trading-name page
    And the user answers yes on the add-uk-trading-name page
    And the user adds Another One on the second uk-trading-name page
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters yesterday for date-of-first-sale
    And the user answers yes on the previous-oss page
    And the user selects Sweden on the first previous-country page
    And the user answer oss on the previous-scheme/1/1 page
    And the user add SE012345678999 on the first previous-oss-scheme-number page
    Then the user is on the previous-scheme-answers/1 page
    And the user answers yes on the previous-scheme-answers/1 page
    And the user answers ioss on the previous-scheme/1/2 page
    And the user answers no on the previous-ioss-scheme/1/2 page
    And the user inputs ioss reg number IM7527777777 on the previous-ioss-number/1/2 page
    And the user answers no on the previous-scheme-answers/1 page
    And the user answers no on the previous-schemes-overview page
    And the user clicks through the start-date page
    And the user answers yes on the tax-in-eu page
    And the user selects Croatia on the first eu-tax page
    And the user answers yes on the sells-goods-to-eu-consumers/1 page
    And the user answer fixed establishment on the sells-goods-to-eu-consumer-method/1 page
    And the user answer tax id number on the registration-type/1 page
    And the user adds CR987654 on the first eu-tax-number page
    And the user adds Croatian Products on the first eu-trading-name page
    And the user completes details on the eu-fixed-establishment-address/1 page
      | data      | fieldId    |
      | 1 Address | line1      |
      | A Town    | townOrCity |
    And the user clicks continue on the first check-tax-details page
    And the user answers yes on the add-tax-details page
    And the user selects Finland on the second eu-tax page
    And the user answers yes on the sells-goods-to-eu-consumers/2 page
    And the user answer dispatch warehouse on the sells-goods-to-eu-consumer-method/2 page
    And the user answer vat number on the registration-type/2 page
    And the user adds FI12345678 on the second eu-vat-number page
    And the user adds Finnish Sales on the second eu-send-goods-trading-name page
    And the user completes details on the eu-send-goods-address/2 page
      | data      | fieldId    |
      | 1 Address | line1      |
      | A Town    | townOrCity |
    And the user clicks continue on the second check-tax-details page
    And the user answers no on the add-tax-details page
    And the user answers no on the online-marketplace page
    And the user answers yes on the give-website-address page
    And the user adds www.website1.co.uk on the first website-address page
    And the user answers yes on the add-website-address page
    And the user adds www.another-website.org on the second website-address page
    And the user answers no on the add-website-address page
    And the user completes details on the business-contact-details page
      | data           | fieldId         |
      | Joe Bloggs     | fullName        |
      | 01234567890    | telephoneNumber |
      | email@test.com | emailAddress    |
    And the user completes the registration email verification process
    And the user completes details on the bank-details page
      | data                   | fieldId     |
      | Account Name           | accountName |
      | ABCDEF2A               | bic         |
      | GB33BUKB20201555555555 | iban        |
    Then the user is at the check-answers page
    When the user selects the change link for check-previous-oss
    And the user answers no on the check-previous-oss page
    Then the user answers yes on the check-remove-all-previous-registrations page
    And the user is at the check-answers page
    When the user selects the change link for check-tax-in-eu
    And the user answers no on the check-tax-in-eu page
    Then the user answers yes on the check-remove-all-eu-details page
    And the user is on the check-answers page
    When the user selects the change link for check-give-website-address
    And the user answers no on the check-give-website-address page
    Then the user answers yes on the check-remove-all-websites page
    And the user is on the check-answers page
    When the user selects the change link for check-have-uk-trading-name
    And the user answers no on the check-have-uk-trading-name page
    Then the user answers yes on the check-remove-all-trading-names page
    And the user is on the check-answers page
    Then the user submits their registration

  Scenario: Changing answers for EU registrations whilst progressing through the journey
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers no on the have-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters yesterday for date-of-first-sale
    And the user answers no on the previous-oss page
    And the user clicks through the start-date page
    And the user answers yes on the tax-in-eu page
    And the user selects Netherlands on the first eu-tax page
    And the user chooses yes on the first sells-goods-to-eu-consumers page
    And the user answer dispatch warehouse on the sells-goods-to-eu-consumer-method/1 page
    And the user answer vat number on the registration-type/1 page
    And the user adds NL0123456789AB on the first eu-vat-number page
    And the user adds Amsterdam Goods on the first eu-send-goods-trading-name page
    And the user completes details on the eu-send-goods-address/1 page
      | data      | fieldId    |
      | 1 Address | line1      |
      | A Town    | townOrCity |
    And the user clicks continue on the first check-tax-details page
    And the user answers yes on the add-tax-details page
    And the user selects Denmark on the second eu-tax page
    And the user chooses yes on the second sells-goods-to-eu-consumers page
    And the user answer fixed establishment on the sells-goods-to-eu-consumer-method/2 page
    And the user answer tax id number on the registration-type/2 page
    And the user adds D123456 on the second eu-tax-number page
    And the user adds Danish Trading on the second eu-trading-name page
    And the user completes details on the eu-fixed-establishment-address/2 page
      | data      | fieldId    |
      | 1 Address | line1      |
      | A Town    | townOrCity |
    And the user clicks continue on the second check-tax-details page
    And the user is on the add-tax-details page
    Then the user selects the change link for check-tax-details\/1
    And the user is on the check-tax-details/1 page
    And the user selects the change link for sells-goods-to-eu-consumer-method\/1
    Then the user answer fixed establishment on the sells-goods-to-eu-consumer-method/1 page
    And the user answer tax id number on the registration-type/1 page
    Then the user adds C9876 on the first eu-tax-number page
    And the user adds A trading name on the first eu-trading-name page
    And the user completes details on the eu-fixed-establishment-address/1 page
      | data      | fieldId    |
      | 1 Address | line1      |
      | A Town    | townOrCity |
    And the user is on the check-tax-details/1 page
    Then the user selects the change link for first-check-eu-trading-name\/1
    And the user adds 123 on the first first-check-eu-trading-name page
    Then the user clicks continue on the first check-tax-details page
    And the user is on the add-tax-details page
    And the user selects the change link for check-tax-details\/2
    And the user is on the check-tax-details/2 page
    Then the user selects the change link for registration-type\/2
    And the user answer vat number on the registration-type/2 page
    Then the user adds DK12345678 on the second eu-vat-number page
    And the user clicks continue on the second eu-trading-name page
    And the user clicks continue on the second eu-fixed-establishment-address page
    And the user is on the check-tax-details/2 page
    Then the user selects the change link for first-check-eu-fixed-establishment-address\/2
    And the user completes details on the first-check-eu-fixed-establishment-address/2 page
      | data        | fieldId |
      | second line | line2   |
    Then the user clicks continue on the second check-tax-details page
    And the user answers no on the add-tax-details page
    And the user answers no on the online-marketplace page
    And the user answers no on the give-website-address page
    And the user completes details on the business-contact-details page
      | data           | fieldId         |
      | Joe Bloggs     | fullName        |
      | 01234567890    | telephoneNumber |
      | email@test.com | emailAddress    |
    And the user completes the registration email verification process
    And the user completes details on the bank-details page
      | data                   | fieldId     |
      | Account Name           | accountName |
      | ABCDEF2A               | bic         |
      | GB33BUKB20201555555555 | iban        |
    And the user is on the check-answers page
    Then the user submits their registration

