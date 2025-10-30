@Registration

Feature: Save For Later Feature

  Scenario: A user can save their progress and return to the last page they were on
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000600 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers yes on the have-uk-trading-name page
    And the user adds Foo on the first uk-trading-name page
    And the user answers yes on the add-uk-trading-name page
    And the user adds Foo Two on the second uk-trading-name page
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters yesterday for date-of-first-sale
    And the user is on the previous-oss page
    And the user clicks on the save and come back later button
    And the user is on the progress-saved?continueUrl=%2Fpay-vat-on-goods-sold-to-eu%2Fnorthern-ireland-register%2Fprevious-oss page
    Then the user clicks on the continue to complete your registration link
    And the user answers yes on the previous-oss page
    And the user selects Ireland on the first previous-country page
    And the user answer oss on the previous-scheme/1/1 page
    And the user add IE1234567WI on the first previous-oss-scheme-number page
    Then the user is on the previous-scheme-answers/1 page
    And the user answers no on the previous-scheme-answers/1 page
    And the user answers no on the previous-schemes-overview page
    And the user clicks through the start-date page
    And the user answers yes on the tax-in-eu page
    And the user selects Romania on the first eu-tax page
    And the user chooses yes on the first sells-goods-to-eu-consumers page
    And the user answer fixed establishment on the sells-goods-to-eu-consumer-method/1 page
    And the user answer vat number on the registration-type/1 page
    And the user adds RO1234567890 on the first eu-vat-number page
    And the user adds name on the first eu-trading-name page
    And the user completes details on the eu-fixed-establishment-address/1 page
      | data      | fieldId    |
      | 1 Address | line1      |
      | A Town    | townOrCity |
    And the user clicks continue on the first check-tax-details page
    And the user answers yes on the add-tax-details page
    And the user selects Portugal on the second eu-tax page
    And the user chooses yes on the second sells-goods-to-eu-consumers page
    And the user answer fixed establishment on the sells-goods-to-eu-consumer-method/2 page
    And the user answer tax id number on the registration-type/2 page
    And the user adds PT123456789 on the second eu-tax-number page
    And the user adds name on the second eu-trading-name page
    And the user completes details on the eu-fixed-establishment-address/2 page
      | data      | fieldId    |
      | 1 Address | line1      |
      | A Town    | townOrCity |
    And the user clicks continue on the second check-tax-details page
    And the user answers no on the add-tax-details page
    And the user is on the online-marketplace page
    And the user clicks on the save and come back later button
    And the user is on the progress-saved?continueUrl=%2Fpay-vat-on-goods-sold-to-eu%2Fnorthern-ireland-register%2Fonline-marketplace page
    Then the user clicks on the continue to complete your registration link
    And the user answers no on the online-marketplace page
    And the user answers yes on the give-website-address page
    And the user adds www.example.com on the first website-address page
    And the user answers yes on the add-website-address page
    And the user adds www.second-example.com on the second website-address page
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
    And the user clicks on the save and come back later button
    And the user is on the progress-saved?continueUrl=%2Fpay-vat-on-goods-sold-to-eu%2Fnorthern-ireland-register%2Fcheck-answers page
    Then the user clicks on the continue to complete your registration link
    Then the user is at the check-answers page

  Scenario: A user can access their saved registration from government gateway login and complete it
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000600 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers yes on the have-uk-trading-name page
    And the user adds Foo on the first uk-trading-name page
    And the user answers yes on the add-uk-trading-name page
    And the user adds Foo Two on the second uk-trading-name page
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters yesterday for date-of-first-sale
    And the user is on the previous-oss page
    And the user clicks on the save and come back later button
    And the user is on the progress-saved?continueUrl=%2Fpay-vat-on-goods-sold-to-eu%2Fnorthern-ireland-register%2Fprevious-oss page
    And the user selects the sign out and come back later link
    And the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000600 and strong credentials
    And the user select yes on the continue-registration page
    And the user answers yes on the previous-oss page
    And the user selects Sweden on the first previous-country page
    And the user answer oss on the previous-scheme/1/1 page
    And the user add SE012345678987 on the first previous-oss-scheme-number page
    Then the user is on the previous-scheme-answers/1 page
    And the user answers no on the previous-scheme-answers/1 page
    And the user answers no on the previous-schemes-overview page
    And the user clicks through the start-date page
    And the user answers yes on the tax-in-eu page
    And the user selects Ireland on the first eu-tax page
    And the user chooses yes on the first sells-goods-to-eu-consumers page
    And the user answer fixed establishment on the sells-goods-to-eu-consumer-method/1 page
    And the user answer vat number on the registration-type/1 page
    And the user adds IE1234567WI on the first eu-vat-number page
    And the user adds name on the first eu-trading-name page
    And the user completes details on the eu-fixed-establishment-address/1 page
      | data      | fieldId    |
      | 1 Address | line1      |
      | A Town    | townOrCity |
    And the user clicks continue on the first check-tax-details page
    And the user answers yes on the add-tax-details page
    And the user selects Italy on the second eu-tax page
    And the user chooses yes on the second sells-goods-to-eu-consumers page
    And the user answer fixed establishment on the sells-goods-to-eu-consumer-method/2 page
    And the user answer tax id number on the registration-type/2 page
    And the user adds IT01234567899 on the second eu-tax-number page
    And the user adds name on the second eu-trading-name page
    And the user completes details on the eu-fixed-establishment-address/2 page
      | data      | fieldId    |
      | 1 Address | line1      |
      | A Town    | townOrCity |
    And the user clicks continue on the second check-tax-details page
    And the user answers no on the add-tax-details page
    And the user answers no on the online-marketplace page
    And the user answers yes on the give-website-address page
    And the user adds www.example.com on the first website-address page
    And the user answers yes on the add-website-address page
    And the user adds www.second-example.com on the second website-address page
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
    Then the user submits their registration

  Scenario: A user can delete an in progress registration and start again
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000600 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers yes on the have-uk-trading-name page
    And the user adds Foo on the first uk-trading-name page
    And the user answers yes on the add-uk-trading-name page
    And the user adds Foo Two on the second uk-trading-name page
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters yesterday for date-of-first-sale
    And the user is on the previous-oss page
    And the user clicks on the save and come back later button
    And the user is on the progress-saved?continueUrl=%2Fpay-vat-on-goods-sold-to-eu%2Fnorthern-ireland-register%2Fprevious-oss page
    And the user selects the sign out and come back later link
    And the user accesses the continue on sign in url
    And the user signs in as an Organisation Admin with VAT enrolment 100000600 and strong credentials
    Then the user is at the continue-registration page
    And the user select No,delete my answers and start again on the continue-registration page
    And the user chooses Yes on the confirm-vat-details page
    And the user answers yes on the have-uk-trading-name page
    And the user adds Foo on the first uk-trading-name page
    And the user answers yes on the add-uk-trading-name page
    And the user adds Foo Two on the second uk-trading-name page
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters yesterday for date-of-first-sale
    And the user answers yes on the previous-oss page
    And the user selects Hungary on the first previous-country page
    And the user answer oss on the previous-scheme/1/1 page
    And the user add HU12345678 on the first previous-oss-scheme-number page
    Then the user is on the previous-scheme-answers/1 page
    And the user answers no on the previous-scheme-answers/1 page
    And the user answers no on the previous-schemes-overview page
    And the user clicks through the start-date page
    And the user answers yes on the tax-in-eu page
    And the user selects Italy on the first eu-tax page
    And the user chooses yes on the first sells-goods-to-eu-consumers page
    And the user answer fixed establishment on the sells-goods-to-eu-consumer-method/1 page
    And the user answer vat number on the registration-type/1 page
    And the user adds IT01234567899 on the first eu-vat-number page
    And the user adds name on the first eu-trading-name page
    And the user completes details on the eu-fixed-establishment-address/1 page
      | data      | fieldId    |
      | 1 Address | line1      |
      | A Town    | townOrCity |
    And the user clicks continue on the first check-tax-details page
    And the user answers yes on the add-tax-details page
    And the user selects Ireland on the second eu-tax page
    And the user chooses yes on the second sells-goods-to-eu-consumers page
    And the user answer fixed establishment on the sells-goods-to-eu-consumer-method/2 page
    And the user answer tax id number on the registration-type/2 page
    And the user adds IE1234567WI  on the second eu-tax-number page
    And the user adds name on the second eu-trading-name page
    And the user completes details on the eu-fixed-establishment-address/2 page
      | data      | fieldId    |
      | 1 Address | line1      |
      | A Town    | townOrCity |
    And the user clicks continue on the second check-tax-details page
    And the user answers no on the add-tax-details page
    And the user answers no on the online-marketplace page
    And the user answers yes on the give-website-address page
    And the user adds www.example.com on the first website-address page
    And the user answers yes on the add-website-address page
    And the user adds www.second-example.com on the second website-address page
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
    Then the user submits their registration


