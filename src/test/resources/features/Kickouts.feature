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
    Then the user is on the niProtocolRejection page

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
