@RegistrationExtra
Feature: Unusable Email Status Scenarios

  Scenario: Intercept page for when a traders email address has unusable status
    Given a registered user with VRN 333333888 accesses the returns service
    Then the user is redirected to the email intercept page
    And the user clicks the Confirm email address button
    Then the user is redirected to the Business contact details page within Change your registration
    And the user amends details on the amend-business-contact-details page
      | data                     | fieldId      |
      | different-email@test.com | emailAddress |
    And the user completes the amend email verification process
    Then the user is on the change-your-registration page
    When the user presses the submit button
    Then the user is on the successful-amend page
    And the updated email address is displayed as changed on the confirmation page

  Scenario: The user does not amend the email address following the intercept page for unusable status
    Given a registered user with VRN 333333888 accesses the returns service
    Then the user is redirected to the email intercept page
    And the user clicks the Confirm email address button
    Then the user is redirected to the Business contact details page within Change your registration
    And the user presses the continue button
    When the user completes the amend email verification process
    Then the user is on the change-your-registration page
    And the user presses the submit button
    Then the user is on the successful-amend page
    And the confirmation of no answers changed is displayed

