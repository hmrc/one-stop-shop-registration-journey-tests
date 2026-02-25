/*
 * Copyright 2025 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.ui.specs

import uk.gov.hmrc.ui.pages.*

class KickoutsSpec extends BaseSpec {

  private val registration = Registration
  private val auth         = Auth

  Feature("Not Eligible for One Stop Shop") {

    Scenario("Business is already registered in another country") {

      Given("the user accesses the OSS Registration Service")
      registration.goToRegistrationJourney()
      registration.checkJourneyUrl("already-eu-registered")

      When("the user selects yes on the already-eu-registered page")
      registration.answerRadioButton("yes")

      And("the user is on the return-later-already-eu-registered page")
      registration.checkJourneyUrl("return-later-already-eu-registered")
    }

    Scenario("Business not selling goods from Northern Ireland") {

      Given("the user accesses the OSS Registration Service")
      registration.goToRegistrationJourney()
      registration.checkJourneyUrl("already-eu-registered")

      When("the user selects no on the already-eu-registered page")
      registration.answerRadioButton("no")

      And("the user selects no on the sell-from-northern-ireland page")
      registration.checkJourneyUrl("sell-from-northern-ireland")
      registration.answerRadioButton("no")

      And("the user is on the do-not-sell-from-northern-ireland page")
      registration.checkJourneyUrl("do-not-sell-from-northern-ireland")
    }

    Scenario("Business outside NI only selling via an online marketplace") {

      Given("the user accesses the OSS Registration Service")
      registration.goToRegistrationJourney()
      registration.checkJourneyUrl("already-eu-registered")

      When("the user selects no on the already-eu-registered page")
      registration.answerRadioButton("no")

      And("the user selects yes on the sell-from-northern-ireland page")
      registration.checkJourneyUrl("sell-from-northern-ireland")
      registration.answerRadioButton("yes")

      When("the user selects no on the northern-ireland-business page")
      registration.checkJourneyUrl("northern-ireland-business")
      registration.answerRadioButton("no")

      And("the user selects no on the northern-ireland-fixed-establishment page")
      registration.checkJourneyUrl("northern-ireland-fixed-establishment")
      registration.answerRadioButton("no")

      And("the user picks All on the sales-on-marketplaces page")
      registration.checkJourneyUrl("sales-on-marketplaces")
      registration.selectOnlineMarketplaceSales("All")

      And("the user is on the cannot-use-no-vat page")
      registration.checkJourneyUrl("cannot-use-no-vat")
    }

    Scenario("Business outside NI selling some goods via an online marketplace") {

      Given("the user accesses the OSS Registration Service")
      registration.goToRegistrationJourney()
      registration.checkJourneyUrl("already-eu-registered")

      When("the user selects no on the already-eu-registered page")
      registration.answerRadioButton("no")

      And("the user selects yes on the sell-from-northern-ireland page")
      registration.checkJourneyUrl("sell-from-northern-ireland")
      registration.answerRadioButton("yes")

      When("the user selects no on the northern-ireland-business page")
      registration.checkJourneyUrl("northern-ireland-business")
      registration.answerRadioButton("no")

      And("the user selects no on the northern-ireland-fixed-establishment page")
      registration.checkJourneyUrl("northern-ireland-fixed-establishment")
      registration.answerRadioButton("no")

      And("the user picks All on the sales-on-marketplaces page")
      registration.checkJourneyUrl("sales-on-marketplaces")
      registration.selectOnlineMarketplaceSales("Some")

      And("the user is on the do-not-pay-sales-on-marketplace page")
      registration.checkJourneyUrl("do-not-pay-sales-on-marketplace")
    }

    Scenario("Business outside NI not selling via an online marketplace") {

      Given("the user accesses the OSS Registration Service")
      registration.goToRegistrationJourney()
      registration.checkJourneyUrl("already-eu-registered")

      When("the user selects no on the already-eu-registered page")
      registration.answerRadioButton("no")

      And("the user selects yes on the sell-from-northern-ireland page")
      registration.checkJourneyUrl("sell-from-northern-ireland")
      registration.answerRadioButton("yes")

      When("the user selects no on the northern-ireland-business page")
      registration.checkJourneyUrl("northern-ireland-business")
      registration.answerRadioButton("no")

      And("the user selects no on the northern-ireland-fixed-establishment page")
      registration.checkJourneyUrl("northern-ireland-fixed-establishment")
      registration.answerRadioButton("no")

      And("the user picks All on the sales-on-marketplaces page")
      registration.checkJourneyUrl("sales-on-marketplaces")
      registration.selectOnlineMarketplaceSales("None")

      And("the user is on the business-pay page")
      registration.checkJourneyUrl("business-pay")
    }

    Scenario("Incorrect UK VAT details") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000001", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user selects no on the already-eu-registered page")
      registration.answerRadioButton("no")

      And("the user selects yes on the sell-from-northern-ireland page")
      registration.checkJourneyUrl("sell-from-northern-ireland")
      registration.answerRadioButton("yes")

      And("the user selects yes on the northern-ireland-business")
      registration.checkJourneyUrl("northern-ireland-business")
      registration.answerRadioButton("yes")

      Then("the user presses continue on the business-pay page")
      registration.checkJourneyUrl("business-pay")
      registration.continue()

      Then("the user selects Yes details incorrect on the confirm-vat-details page")
      registration.checkJourneyUrl("confirm-vat-details")
      registration.answerVatDetailsChoice("Yes, but some of my VAT details are incorrect")

      And("the user is on the update-vat-details page")
      registration.checkJourneyUrl("update-vat-details")
    }

    Scenario("Use different UK VAT details") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000001", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user selects no on the already-eu-registered page")
      registration.answerRadioButton("no")

      And("the user selects yes on the sell-from-northern-ireland page")
      registration.checkJourneyUrl("sell-from-northern-ireland")
      registration.answerRadioButton("yes")

      And("the user selects yes on the northern-ireland-business")
      registration.checkJourneyUrl("northern-ireland-business")
      registration.answerRadioButton("yes")

      Then("the user presses continue on the business-pay page")
      registration.checkJourneyUrl("business-pay")
      registration.continue()

      Then("the user selects No on the confirm-vat-details page")
      registration.checkJourneyUrl("confirm-vat-details")
      registration.answerVatDetailsChoice("No, I want to register a different business")

      And("the user is on the register-different-business page")
      registration.checkJourneyUrl("register-different-business")
    }

    Scenario("NI Protocol Rejection") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("500000001", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user answers the filter questions")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("sell-from-northern-ireland")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("northern-ireland-business")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("business-pay")
      registration.continue()

      Then("the user is on the cannot-register-ni-protocol page")
      registration.checkJourneyUrl("cannot-register-ni-protocol")
    }

    Scenario("Vat details Api down with vrn number starting with 8") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("800000001", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user answers the filter questions")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("sell-from-northern-ireland")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("northern-ireland-business")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("business-pay")
      registration.continue()

      Then("the user is on the registration-service-error page")
      registration.checkJourneyUrl("registration-service-error")
    }

    Scenario("Vat details Api down with vrn number starting with 9") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("900000001", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user answers the filter questions")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("sell-from-northern-ireland")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("northern-ireland-business")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("business-pay")
      registration.continue()

      Then("the user is on the registration-service-error page")
      registration.checkJourneyUrl("registration-service-error")
    }

    Scenario("An unauthorised error from ETMP when submitting a registration") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("666000004", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user selects no on the already-eu-registered page")
      registration.answerRadioButton("no")

      Then("the user can complete the rest of the registration")
      registration.minimalRegistrationAnswers()

      And("the user is on the error-submitting-registration page")
      registration.checkJourneyUrl("error-submitting-registration")
    }

    Scenario("Error creating enrolment when submitting registration to ETMP") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("222222233", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user selects no on the already-eu-registered page")
      registration.answerRadioButton("no")

      Then("the user can complete the rest of the registration")
      registration.minimalRegistrationAnswers()

      And("the user is on the error-submitting-registration page")
      registration.checkJourneyUrl("error-submitting-registration")
    }

    Scenario("An error from ETMP when submitting a registration accessed via BTA") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("666000001", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      And("the user manually navigates to the from-external link")
      registration.goToPage("test-only/from-external")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user selects no on the already-eu-registered page")
      registration.answerRadioButton("no")

      Then("the user can complete the rest of the registration")
      registration.minimalRegistrationAnswers()

      And("the user is on the error-submitting-registration page")
      registration.checkJourneyUrl("error-submitting-registration")
    }

    Scenario("User who already has an OSS VAT enrolment but has no saved registration sees an error page") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000700", "Organisation", "hasOSSEnrolment", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user answers the filter questions")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("sell-from-northern-ireland")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("northern-ireland-business")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("business-pay")
      registration.continue()

      Then("the user is on the account-restore-error page")
      registration.checkJourneyUrl("account-restore-error")
    }

    Scenario(
      "User who already has an OSS VAT enrolment and a saved registration lands on the already-registered page"
    ) {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000003", "Organisation", "hasOSSEnrolment", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user answers the filter questions")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("sell-from-northern-ireland")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("northern-ireland-business")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("business-pay")
      registration.continue()

      Then("the user is on the already-registered page")
      registration.checkJourneyUrl("already-registered")
    }

    Scenario("Starting a registration when the user has no OSS enrolment but is already registered on ETMP") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("222222223", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user answers the filter questions")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("sell-from-northern-ireland")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("northern-ireland-business")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("business-pay")
      registration.continue()

      Then("the user is on the already-registered page")
      registration.checkJourneyUrl("already-registered")
    }

    Scenario("A user who has not previously registered for OSS cannot access the amend registration journey") {

      Given("the user accesses the Amend Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000700", "Organisation", "vatOnly", "amendNotRegistered")

      Then("the user is on the cannot-use-not-registered page")
      registration.checkJourneyUrl("cannot-use-not-registered")
    }

    Scenario("A user is directed to an error page when there is an issue submitting their amended registration") {

      Given("the user accesses the Amend Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("600000022", "Organisation", "hasOSSEnrolment", "amendError")
      registration.checkJourneyUrl("change-your-registration")

      When("the user submits their amended registration")
      registration.submit()

      Then("the user is on the error-submitting-amendment page")
      registration.checkJourneyUrl("error-submitting-amendment")
    }

    Scenario("A historic user who was registered on oss without an enrolment can't access the amend journey") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("300000002", "Organisation", "vatOnly", "amendNoOSSEnrolment")

      Then("the user is presented with the problem page")
      registration.checkJourneyUrl("start-amend-journey")
      registration.checkProblemPage()
    }

    Scenario("User with expired VRN cannot register") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("600000001", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user answers the filter questions")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("sell-from-northern-ireland")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("northern-ireland-business")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("business-pay")
      registration.continue()

      Then("the user is on the invalid-vrn-date page")
      registration.checkJourneyUrl("invalid-vrn-date")
    }
  }
}
