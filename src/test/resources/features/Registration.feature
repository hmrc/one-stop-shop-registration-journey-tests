@Registration
Feature: Registering for One Stop Shop

  @ZAP @Accessibility
  Scenario: A signed in user can complete a full registration with vat tax id number
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers yes on the have-uk-trading-name page
    And the user adds Foo on the first uk-trading-name page
    And the user answers yes on the add-uk-trading-name page
    And the user adds Foo Two on the second uk-trading-name page
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters yesterday for date-of-first-sale
    And the user answers yes on the previous-oss page
    And the user selects Sweden on the first previous-country page
    And the user answer oss on the previous-scheme page
    And the user add SE012345678987 on the first previous-oss-scheme-number page
    Then the user is on the previous-scheme-answers/1 page
    And the user answers no on the previous-scheme-answers/1 page
    And the user answers no on the previous-schemes-overview page
    And the user clicks through the start-date page
    And the user answers yes on the tax-in-eu page
    And the user selects Luxembourg on the first eu-tax page
    And the user chooses yes on the first sells-goods-to-eu-consumers page
    And the user answer fixed establishment on the sells-goods-to-eu-consumer-method/1 page
    And the user answer tax id number on the registration-type/1 page
    And the user adds LU12345678  on the first eu-tax-number page
    And the user adds soo on the first eu-trading-name page
    And the user completes details on the eu-fixed-establishment-address/1 page
      | data      | fieldId    |
      | 1 Address | line1      |
      | A Town    | townOrCity |
    And the user clicks continue on the first check-tax-details page
    And the user answers yes on the add-tax-details page
    And the user selects Latvia on the second eu-tax page
    And the user chooses yes on the second sells-goods-to-eu-consumers page
    And the user answer fixed establishment on the sells-goods-to-eu-consumer-method/2 page
    And the user answer tax id number on the registration-type/2 page
    And the user adds LV01234567899 on the second eu-tax-number page
    And the user adds moo on the second eu-trading-name page
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
    And the user completes the email verification process
    And the user completes details on the bank-details page
      | data                   | fieldId     |
      | Account Name           | accountName |
      | ABCDEF2A               | bic         |
      | GB33BUKB20201555555555 | iban        |
    Then the user is at the check-answers page
    Then the user submits their registration
  @Accessibility
  Scenario: A signed in user can submit a registration when they have not yet made sales but plan to
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000002 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers no on the have-uk-trading-name page
    And the user answers no on the already-made-sales page
    And the user answers yes on the planned-first-sale page
    And the user answers yes on the previous-oss page
    And the user selects Hungary on the first previous-country page
    And the user answer oss on the previous-scheme page
    And the user add HU12345678 on the first previous-oss-scheme-number page
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
    And the user completes the email verification process
    And the user completes details on the bank-details page
      | data                   | fieldId     |
      | Account Name           | accountName |
      | ABCDEF2A               | bic         |
      | GB33BUKB20201555555555 | iban        |
    Then the user is at the check-answers page
    Then the user submits their registration

  Scenario: A signed in user registers with an EU Tax identifier instead of a EU VAT number for EU Registration Details
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
    And the user selects Malta on the first previous-country page
    And the user answer oss on the previous-scheme page
    And the user add MT12345678 on the first previous-oss-scheme-number page
    Then the user is on the previous-scheme-answers/1 page
    And the user answers no on the previous-scheme-answers/1 page
    And the user answers no on the previous-schemes-overview page
    And the user clicks through the start-date page
    And the user answers yes on the tax-in-eu page
    And the user selects France on the first eu-tax page
    And the user chooses yes on the first sells-goods-to-eu-consumers page
    And the user answer fixed establishment on the sells-goods-to-eu-consumer-method/1 page
    And the user answer tax id number on the registration-type/1 page
    And the user adds LU12345678  on the first eu-tax-number page
    And the user adds soo on the first eu-trading-name page
    And the user completes details on the eu-fixed-establishment-address/1 page
      | data      | fieldId    |
      | 1 Address | line1      |
      | A Town    | townOrCity |
    And the user clicks continue on the first check-tax-details page
    And the user answers yes on the add-tax-details page
    And the user selects Czech Republic on the second eu-tax page
    And the user chooses yes on the second sells-goods-to-eu-consumers page
    And the user answer fixed establishment on the sells-goods-to-eu-consumer-method/2 page
    And the user answer tax id number on the registration-type/2 page
    And the user adds LU12345678  on the second eu-tax-number page
    And the user adds roo on the second eu-trading-name page
    And the user completes details on the eu-fixed-establishment-address/2 page
      | data      | fieldId    |
      | 1 Address | line1      |
      | A Town    | townOrCity |
    And the user clicks continue on the second check-tax-details page
    And the user answers no on the add-tax-details page
    And the user answers no on the online-marketplace page
    And the user answers no on the give-website-address page
    And the user completes details on the business-contact-details page
      | data           | fieldId         |
      | Joe Bloggs     | fullName        |
      | 01234567890    | telephoneNumber |
      | email@test.com | emailAddress    |
    And the user completes the email verification process
    And the user completes details on the bank-details page
      | data                   | fieldId     |
      | Account Name           | accountName |
      | ABCDEF2A               | bic         |
      | GB33BUKB20201555555555 | iban        |
    Then the user is at the check-answers page
    Then the user submits their registration
  @Accessibility
  Scenario: A signed in user can continue-on-sign-in url without starting a registration
    Given the user accesses the continue on sign in url
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    Then the user is at the no-saved-registration page

  Scenario: A signed in user can complete a full registration with an intermediary identification number
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers yes on the have-uk-trading-name page
    And the user adds Foo on the first uk-trading-name page
    And the user answers yes on the add-uk-trading-name page
    And the user adds Foo Two on the second uk-trading-name page
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters yesterday for date-of-first-sale
    And the user answers yes on the previous-oss page
    And the user selects France on the first previous-country page
    And the user answer ioss on the previous-scheme page
    And the user answers yes on the previous-ioss-scheme/1/1 page
    And the user inputs ioss reg number IM2501234567 on the previous-ioss-number/1/1 page
    And the user inputs intermediary identification number IN2501234567 on the previous-ioss-number/1/1 page
    And the user answers no on the previous-scheme-answers/1 page
    And the user answers no on the previous-schemes-overview page
    And the user clicks through the start-date page
    And the user answers yes on the tax-in-eu page
    And the user selects Malta on the first eu-tax page
    And the user chooses yes on the first sells-goods-to-eu-consumers page
    And the user answer fixed establishment on the sells-goods-to-eu-consumer-method/1 page
    And the user answer tax id number on the registration-type/1 page
    And the user adds MT12345678  on the first eu-tax-number page
    And the user adds soo on the first eu-trading-name page
    And the user completes details on the eu-fixed-establishment-address/1 page
      | data      | fieldId    |
      | 1 Address | line1      |
      | A Town    | townOrCity |
    And the user clicks continue on the first check-tax-details page
    And the user answers yes on the add-tax-details page
    And the user selects Latvia on the second eu-tax page
    And the user chooses yes on the second sells-goods-to-eu-consumers page
    And the user answer fixed establishment on the sells-goods-to-eu-consumer-method/2 page
    And the user answer tax id number on the registration-type/2 page
    And the user adds LV01234567899 on the second eu-tax-number page
    And the user adds soo on the second eu-trading-name page
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
    And the user completes the email verification process
    And the user completes details on the bank-details page
      | data                   | fieldId     |
      | Account Name           | accountName |
      | ABCDEF2A               | bic         |
      | GB33BUKB20201555555555 | iban        |
    Then the user is at the check-answers page
    Then the user submits their registration

  Scenario: A signed in user can complete a full registration without an intermediary identification number
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers yes on the have-uk-trading-name page
    And the user adds Foo on the first uk-trading-name page
    And the user answers yes on the add-uk-trading-name page
    And the user adds Foo Two on the second uk-trading-name page
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters yesterday for date-of-first-sale
    And the user answers yes on the previous-oss page
    And the user selects France on the first previous-country page
    And the user answer ioss on the previous-scheme page
    And the user answers no on the previous-ioss-scheme/1/1 page
    And the user inputs ioss reg number IM2501234567 on the previous-ioss-number/1/1 page
    And the user clicks continue on the first previous-ioss-number/1 page
    And the user answers no on the previous-scheme-answers/1 page
    And the user answers no on the previous-schemes-overview page
    And the user clicks through the start-date page
    And the user answers yes on the tax-in-eu page
    And the user selects Latvia on the first eu-tax page
    And the user chooses yes on the first sells-goods-to-eu-consumers page
    And the user answer fixed establishment on the sells-goods-to-eu-consumer-method/1 page
    And the user answer tax id number on the registration-type/1 page
    And the user adds LV01234567899 on the first eu-tax-number page
    And the user adds soo on the first eu-trading-name page
    And the user completes details on the eu-fixed-establishment-address/1 page
      | data      | fieldId    |
      | 1 Address | line1      |
      | A Town    | townOrCity |
    And the user clicks continue on the first check-tax-details page
    And the user answers yes on the add-tax-details page
    And the user selects Luxembourg on the second eu-tax page
    And the user chooses yes on the second sells-goods-to-eu-consumers page
    And the user answer fixed establishment on the sells-goods-to-eu-consumer-method/2 page
    And the user answer tax id number on the registration-type/2 page
    And the user adds LU12345678 on the second eu-tax-number page
    And the user adds soo on the second eu-trading-name page
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
    And the user completes the email verification process
    And the user completes details on the bank-details page
      | data                   | fieldId     |
      | Account Name           | accountName |
      | ABCDEF2A               | bic         |
      | GB33BUKB20201555555555 | iban        |
    Then the user is at the check-answers page
    Then the user submits their registration
@Accessibility
  Scenario: A signed in user can complete a full registration without selling goods
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers yes on the have-uk-trading-name page
    And the user adds Foo on the first uk-trading-name page
    And the user answers yes on the add-uk-trading-name page
    And the user adds Foo Two on the second uk-trading-name page
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters yesterday for date-of-first-sale
    And the user answers yes on the previous-oss page
    And the user selects Malta on the first previous-country page
    And the user answer oss on the previous-scheme page
    And the user add MT12345678 on the first previous-oss-scheme-number page
    Then the user is on the previous-scheme-answers/1 page
    And the user answers no on the previous-scheme-answers/1 page
    And the user answers no on the previous-schemes-overview page
    And the user clicks through the start-date page
    And the user answers yes on the tax-in-eu page
    And the user selects Belgium on the first eu-tax page
    And the user chooses no on the first sells-goods-to-eu-consumers page
    And the user clicks continue on the first sales-declaration-not-required page
    And the user chooses yes on the first eu-vat page
    And the user adds BE0123456789 on the first eu-vat-number page
    And the user clicks continue on the first check-tax-details page
    And the user answers yes on the add-tax-details page
    And the user selects Luxembourg on the second eu-tax page
    And the user chooses no on the second sells-goods-to-eu-consumers page
    And the user clicks continue on the second sales-declaration-not-required page
    And the user chooses yes on the second eu-vat page
    And the user adds LU12345678 on the second eu-vat-number page
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
    And the user completes the email verification process
    And the user completes details on the bank-details page
      | data                   | fieldId     |
      | Account Name           | accountName |
      | ABCDEF2A               | bic         |
      | GB33BUKB20201555555555 | iban        |
    Then the user is at the check-answers page
    Then the user submits their registration
  @Accessibility
  Scenario: A signed in user who is part of a VAT group cannot add fixed establishments
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 777777779 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers no on the have-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters yesterday for date-of-first-sale
    And the user answers no on the previous-oss page
    And the user clicks through the start-date page
    And the user answers yes on the tax-in-eu page
    And the user selects Finland on the first eu-tax page
    And the user answers yes on the sells-goods-to-eu-consumers/1 page
    And the user answer fixed establishment on the sells-goods-to-eu-consumer-method/1 page
    Then the user clicks continue on the first no-fixed-establishments-required page
    And the user answers no on the tax-in-eu page
    And the user answers no on the online-marketplace page
    And the user answers no on the give-website-address page
    And the user completes details on the business-contact-details page
      | data           | fieldId         |
      | Joe Bloggs     | fullName        |
      | 01234567890    | telephoneNumber |
      | email@test.com | emailAddress    |
    And the user completes the email verification process
    And the user completes details on the bank-details page
      | data                   | fieldId     |
      | Account Name           | accountName |
      | ABCDEF2A               | bic         |
      | GB33BUKB20201555555555 | iban        |
    Then the user is at the check-answers page
    Then the user submits their registration

  Scenario: A user without an organisation name can log in and submit their registration under their individual name
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 777777778 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers yes on the have-uk-trading-name page
    And the user adds Trading Name on the first uk-trading-name page
    And the user answers no on the add-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters yesterday for date-of-first-sale
    And the user answers yes on the previous-oss page
    And the user selects Republic of Cyprus on the first previous-country page
    And the user answer oss on the previous-scheme page
    And the user add CY12345678X on the first previous-oss-scheme-number page
    Then the user is on the previous-scheme-answers/1 page
    And the user answers no on the previous-scheme-answers/1 page
    And the user answers no on the previous-schemes-overview page
    And the user clicks through the start-date page
    And the user answers yes on the tax-in-eu page
    And the user selects Slovenia on the first eu-tax page
    And the user chooses yes on the first sells-goods-to-eu-consumers page
    And the user answer fixed establishment on the sells-goods-to-eu-consumer-method/1 page
    And the user answer vat number on the registration-type/1 page
    And the user adds SI12345678 on the first eu-vat-number page
    And the user adds Slovenia Trading Name on the first eu-trading-name page
    And the user completes details on the eu-fixed-establishment-address/1 page
      | data      | fieldId    |
      | 1 Address | line1      |
      | A Town    | townOrCity |
    And the user clicks continue on the first check-tax-details page
    And the user answers no on the add-tax-details page
    And the user answers no on the online-marketplace page
    And the user answers yes on the give-website-address page
    And the user adds www.example.com on the first website-address page
    And the user answers no on the add-website-address page
    And the user completes details on the business-contact-details page
      | data           | fieldId         |
      | Joe Bloggs     | fullName        |
      | 01234567890    | telephoneNumber |
      | email@test.com | emailAddress    |
    And the user completes the email verification process
    And the user completes details on the bank-details page
      | data                   | fieldId     |
      | Account Name           | accountName |
      | ABCDEF2A               | bic         |
      | GB33BUKB20201555555555 | iban        |
    Then the user is at the check-answers page
    Then the user submits their registration

