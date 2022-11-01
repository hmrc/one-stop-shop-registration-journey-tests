@Registration
Feature: Not Eligible for One Stop Shop

  Scenario: Business is already registered in another county
    Given the user accesses the service
    And the user answers yes on the already-eu-registered page
    Then the user is on the return-later-already-eu-registered page

  Scenario: Business not selling goods from Northern Ireland
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers no on the sell-from-northern-ireland page
    Then the user is on the do-not-sell-from-northern-ireland page

  Scenario: Business outside NI only selling via an online marketplace
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers no on the northern-ireland-business page
    And the user answers no on the northern-ireland-fixed-establishment page
    And the user picks Online Marketplace on the sales-on-marketplaces page
    Then the user is on the cannot-use-no-vat page

  Scenario: Business outside NI selling some goods via an online marketplace
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers no on the northern-ireland-business page
    And the user answers no on the northern-ireland-fixed-establishment page
    And the user picks Mixed on the sales-on-marketplaces page
    Then the user is on the do-not-pay-sales-on-marketplace page

  Scenario: Business outside NI not selling via an online marketplace
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers no on the northern-ireland-business page
    And the user answers no on the northern-ireland-fixed-establishment page
    And the user picks Not Online Marketplace on the sales-on-marketplaces page
    Then the user is on the business-pay page

  Scenario: Incorrect UK VAT details
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses No, details incorrect on the confirm-vat-details page
    Then the user is on the update-vat-details page

  Scenario: Use different UK VAT details
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses No, wrong account on the confirm-vat-details page
    Then the user is on the register-different-business page

  Scenario: Will not make sales in this quarter
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers no on the have-uk-trading-name page
    And the user answers no on the already-made-sales page
    And the user answers no on the planned-first-sale page
    Then the user is on the register-later page

  Scenario: NI Protocol Rejection
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 222232222 and strong credentials
    Then the user is on the cannot-register-ni-protocol page

  Scenario: Vat details Api down with vrn number starting with 8
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 800000001 and strong credentials
    Then the user is on the registration-service-error page

  Scenario:Scenario: Vat details Api down with vrn number starting with 9
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 900000001 and strong credentials
    Then the user is on the registration-service-error page


#  Scenario: A failed registration journey with enrolments failure
#    Given the user accesses the service
#    And the user answers no on the already-eu-registered page
#    And the user answers yes on the sell-from-northern-ireland page
#    And the user answers yes on the northern-ireland-business page
#    And the user clicks through the business-pay page
#    And the user signs in as an Organisation Admin with VAT enrolment 666000004 and strong credentials
#    And the user chooses Yes on the confirm-vat-details page
#    And the user answers yes on the have-uk-trading-name page
#    And the user adds Foo on the first uk-trading-name page
#    And the user answers yes on the add-uk-trading-name page
#    And the user adds Foo Two on the second uk-trading-name page
#    And the user answers no on the add-uk-trading-name page
#    And the user answers yes on the already-made-sales page
#    And the user enters a date inside the notification period for date of first sale
#    And the user presses the continue button
#    And the user clicks through the start-date page
#    And the user answers yes on the tax-in-eu page
#    And the user selects France on the first eu-tax page
#    And the user chooses yes on the first eu-vat page
#    And the user adds A1123456789 on the first eu-vat-number page
#    And the user chooses no on the first eu-fixed-establishment page
#    And the user clicks continue on the first check-tax-details page
#    And the user answers yes on the add-tax-details page
#    And the user selects Germany on the second eu-tax page
#    And the user chooses yes on the second eu-vat page
#    And the user adds 123456789 on the second eu-vat-number page
#    And the user chooses no on the second eu-fixed-establishment page
#    And the user clicks continue on the second check-tax-details page
#    And the user answers no on the add-tax-details page
#    And the user answers yes on the deregistered page
#    And the user selects Austria on the first deregistered-country page
#    And the user adds U98765432 on the first deregistered-eu-vat-number page
#    And the user answers no on the add-deregistration page
#    And the user answers no on the online-marketplace page
#    And the user answers yes on the give-website-address page
#    And the user adds www.example.com on the first website-address page
#    And the user answers yes on the add-website-address page
#    And the user adds www.second-example.com on the second website-address page
#    And the user answers no on the add-website-address page
#    And the user completes details on the business-contact-details page
#      | data            | fieldId         |
#      | Joe Bloggs      | fullName        |
#      | 01234567890     | telephoneNumber |
#      | email@test.com  | emailAddress    |
#    And the user completes details on the bank-details page
#      | data                    | fieldId         |
#      | Account Name            | accountName     |
#      | ABCDEF2A                | bic             |
#      | GB33BUKB20201555555555  | iban            |
#    And the user is at the check-answers page
#    And the user selects the register button
#    Then the user is on the error-submitting-registration page



#  Scenario: ETmp error when A user registers via BTA
#    Given the user accesses the external service
#    And the user answers no on the already-eu-registered page
#    And the user answers yes on the sell-from-northern-ireland page
#    And the user answers yes on the northern-ireland-business page
#    And the user clicks through the business-pay page
#    And the user signs in as an Organisation Admin with VAT enrolment 666000001 and strong credentials
#    And the user chooses Yes on the confirm-vat-details page
#    And the user answers yes on the have-uk-trading-name page
#    And the user adds Foo on the first uk-trading-name page
#    And the user answers yes on the add-uk-trading-name page
#    And the user adds Foo Two on the second uk-trading-name page
#    And the user answers no on the add-uk-trading-name page
#    And the user answers yes on the already-made-sales page
#    And the user enters a date inside the notification period for date of first sale
#    And the user presses the continue button
#    And the user clicks through the start-date page
#    And the user answers yes on the tax-in-eu page
#    And the user selects France on the first eu-tax page
#    And the user chooses yes on the first eu-vat page
#    And the user adds A1123456789 on the first eu-vat-number page
#    And the user chooses no on the first eu-fixed-establishment page
#    And the user clicks continue on the first check-tax-details page
#    And the user answers yes on the add-tax-details page
#    And the user selects Germany on the second eu-tax page
#    And the user chooses yes on the second eu-vat page
#    And the user adds 123456789 on the second eu-vat-number page
#    And the user chooses no on the second eu-fixed-establishment page
#    And the user clicks continue on the second check-tax-details page
#    And the user answers no on the add-tax-details page
#    And the user answers yes on the deregistered page
#    And the user selects Austria on the first deregistered-country page
#    And the user adds U98765432 on the first deregistered-eu-vat-number page
#    And the user answers no on the add-deregistration page
#    And the user answers no on the online-marketplace page
#    And the user answers yes on the give-website-address page
#    And the user adds www.example.com on the first website-address page
#    And the user answers yes on the add-website-address page
#    And the user adds www.second-example.com on the second website-address page
#    And the user answers no on the add-website-address page
#    And the user completes details on the business-contact-details page
#      | data            | fieldId         |
#      | Joe Bloggs      | fullName        |
#      | 01234567890     | telephoneNumber |
#      | email@test.com  | emailAddress    |
#    And the user completes details on the bank-details page
#      | data                    | fieldId         |
#      | Account Name            | accountName     |
#      | ABCDEF2A                | bic             |
#      | GB33BUKB20201555555555  | iban            |
#    And the user is at the check-answers page
#    And the user selects the register button
#    Then the user is on the error-submitting-registration page
#    Then the user sees the back to your account button
#
#  Scenario: ETmp error when registration already exist
#    Given the user accesses the service
#    And the user answers no on the already-eu-registered page
#    And the user answers yes on the sell-from-northern-ireland page
#    And the user answers yes on the northern-ireland-business page
#    And the user clicks through the business-pay page
#    And the user signs in as an Organisation Admin with VAT enrolment 666000001 and strong credentials
#    And the user chooses Yes on the confirm-vat-details page
#    And the user answers yes on the have-uk-trading-name page
#    And the user adds Foo on the first uk-trading-name page
#    And the user answers yes on the add-uk-trading-name page
#    And the user adds Foo Two on the second uk-trading-name page
#    And the user answers no on the add-uk-trading-name page
#    And the user answers yes on the already-made-sales page
#    And the user enters a date inside the notification period for date of first sale
#    And the user presses the continue button
#    And the user clicks through the start-date page
#    And the user answers yes on the tax-in-eu page
#    And the user selects France on the first eu-tax page
#    And the user chooses yes on the first eu-vat page
#    And the user adds A1123456789 on the first eu-vat-number page
#    And the user chooses no on the first eu-fixed-establishment page
#    And the user clicks continue on the first check-tax-details page
#    And the user answers yes on the add-tax-details page
#    And the user selects Germany on the second eu-tax page
#    And the user chooses yes on the second eu-vat page
#    And the user adds 123456789 on the second eu-vat-number page
#    And the user chooses no on the second eu-fixed-establishment page
#    And the user clicks continue on the second check-tax-details page
#    And the user answers no on the add-tax-details page
#    And the user answers yes on the deregistered page
#    And the user selects Austria on the first deregistered-country page
#    And the user adds U98765432 on the first deregistered-eu-vat-number page
#    And the user answers no on the add-deregistration page
#    And the user answers no on the online-marketplace page
#    And the user answers yes on the give-website-address page
#    And the user adds www.example.com on the first website-address page
#    And the user answers yes on the add-website-address page
#    And the user adds www.second-example.com on the second website-address page
#    And the user answers no on the add-website-address page
#    And the user completes details on the business-contact-details page
#      | data            | fieldId         |
#      | Joe Bloggs      | fullName        |
#      | 01234567890     | telephoneNumber |
#      | email@test.com  | emailAddress    |
#    And the user completes details on the bank-details page
#      | data                    | fieldId         |
#      | Account Name            | accountName     |
#      | ABCDEF2A                | bic             |
#      | GB33BUKB20201555555555  | iban            |
#    And the user is at the check-answers page
#    And the user selects the register button
#    Then the user is on the error-submitting-registration page

#  Scenario: Existing enrolment in registration
#    Given the user accesses the stub url
#    And the user signs in as an Organisation Admin with Hmrc Mdt and OSS VAT enrolment 100000001 and strong credentials
 #   And the user answers no on the already-eu-registered page
#    And the user answers yes on the sell-from-northern-ireland page
#    And the user answers yes on the northern-ireland-business page
#    And the user clicks through the business-pay page
#    Then the user is on the account-restore-error page


  Scenario: User vat number have been excluded
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers no on the have-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters a date inside the notification period for date of first sale
    And the user presses the continue button
    And the user clicks through the start-date page
    And the user answers yes on the tax-in-eu page
    And the user selects Germany on the first eu-tax page
    And the user chooses no on the first eu-vat page
    And the user chooses yes on the first eu-fixed-establishment page
    And the user adds 333333336 on the first eu-tax-number page
    Then the user is at the excluded-vrn page

  Scenario:User vat number already registered elsewhere
    Given the user accesses the service
    And the user answers no on the already-eu-registered page
    And the user answers yes on the sell-from-northern-ireland page
    And the user answers yes on the northern-ireland-business page
    And the user clicks through the business-pay page
    And the user signs in as an Organisation Admin with VAT enrolment 100000001 and strong credentials
    And the user chooses Yes on the confirm-vat-details page
    And the user answers no on the have-uk-trading-name page
    And the user answers yes on the already-made-sales page
    And the user enters a date inside the notification period for date of first sale
    And the user presses the continue button
    And the user clicks through the start-date page
    And the user answers yes on the tax-in-eu page
    And the user selects Germany on the first eu-tax page
    And the user chooses yes on the first eu-vat page
    And the user adds 333333332 on the first eu-vat-number page
    Then the user is at the excluded-vrn page






