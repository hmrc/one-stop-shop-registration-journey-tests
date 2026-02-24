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

class BTASpec extends BaseSpec {

  private val registration = Registration
  private val auth         = Auth

  Feature("BTA journeys") {

    Scenario("A user registers via BTA and then has the correct BTA link on the registration submission page") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000001", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      And("the user manually navigates to the from-external link")
      registration.goToPage("test-only/from-external")

      When("the user selects no on the already-eu-registered page")
      registration.checkJourneyUrl("already-eu-registered")
      registration.answerRadioButton("no")

      Then("the user can complete the rest of the registration")
      registration.minimalRegistrationAnswers()

      Then("the user is on the successful submission page")
      registration.checkJourneyUrl("successful")

      When("the user clicks on the BTA link")
      registration.clickLink("back-to-your-account")

      Then("the user is on the business-account page")
      registration.checkBtaUrl()
    }

    Scenario(
      "The user enters the service via BTA and is directed back to BTA via the Already EU Registered kickout page"
    ) {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000001", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      And("the user manually navigates to the from-external link")
      registration.goToPage("test-only/from-external")

      When("the user selects yes on the already-eu-registered page")
      registration.checkJourneyUrl("already-eu-registered")
      registration.answerRadioButton("yes")

      And("the user is on the return-later-already-eu-registered page")
      registration.checkJourneyUrl("return-later-already-eu-registered")

      When("the user clicks on the BTA link")
      registration.clickLink("back-to-your-account")

      Then("the user is on the business-account page")
      registration.checkBtaUrl()
    }

    Scenario(
      "The user enters the service via BTA and is directed back to BTA via the Do Not Sell from NI kickout page"
    ) {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000001", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      And("the user manually navigates to the from-external link")
      registration.goToPage("test-only/from-external")

      When("the user selects no on the already-eu-registered page")
      registration.checkJourneyUrl("already-eu-registered")
      registration.answerRadioButton("no")

      And("the user selects no on the sell-from-northern-ireland page")
      registration.checkJourneyUrl("sell-from-northern-ireland")
      registration.answerRadioButton("no")

      And("the user is on the do-not-sell-from-northern-ireland page")
      registration.checkJourneyUrl("do-not-sell-from-northern-ireland")

      When("the user clicks on the BTA link")
      registration.clickLink("back-to-your-account")

      Then("the user is on the business-account page")
      registration.checkBtaUrl()
    }

    Scenario("The user enters the service via BTA and is directed back to BTA via the Cannot Use No VAT kickout page") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000001", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      And("the user manually navigates to the from-external link")
      registration.goToPage("test-only/from-external")

      When("the user selects no on the already-eu-registered page")
      registration.checkJourneyUrl("already-eu-registered")
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

      When("the user clicks on the BTA link")
      registration.clickLink("back-to-your-account")

      Then("the user is on the business-account page")
      registration.checkBtaUrl()
    }

    Scenario(
      "The user enters the service via BTA and is directed back to BTA via the post-auth already registered page"
    ) {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000003", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      And("the user manually navigates to the from-external link")
      registration.goToPage("test-only/from-external")

      When("the user selects no on the already-eu-registered page")
      registration.checkJourneyUrl("already-eu-registered")
      registration.answerRadioButton("no")

      And("the user selects yes on the sell-from-northern-ireland page")
      registration.checkJourneyUrl("sell-from-northern-ireland")
      registration.answerRadioButton("yes")

      When("the user selects yes on the northern-ireland-business page")
      registration.checkJourneyUrl("northern-ireland-business")
      registration.answerRadioButton("yes")

      Then("the user presses continue on the business-pay page")
      registration.checkJourneyUrl("business-pay")
      registration.continue()

      And("the user is on the already-registered page")
      registration.checkJourneyUrl("already-registered")

      When("the user clicks on the Continue to your account button")
      registration.continue()

//      Currently broken - awaiting fix in VEOSS-2162
//      Then("the user is on the business-account page")
//      registration.checkBtaUrl()
    }

    Scenario(
      "A Welsh user enters the service via BTA and is first directed to the Welsh transition page before continuing"
    ) {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000003", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      And("the user manually navigates to the from-external?lang=cy link")
      registration.goToPage("test-only/from-external?lang=cy")

      Then("the user is on the no-welsh-service page")
      registration.checkJourneyUrl("no-welsh-service")

      When("the user clicks on the Continue button")
      registration.continue()

      Then("the user is on the already-eu-registered page")
      registration.checkJourneyUrl("already-eu-registered")
    }

    Scenario(
      "A user enters the service via BTA using the en parameter and is directed straight to the registration service"
    ) {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000003", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      And("the user manually navigates to the from-external?lang=en link")
      registration.goToPage("test-only/from-external?lang=en")

      Then("the user is on the already-eu-registered page")
      registration.checkJourneyUrl("already-eu-registered")
    }
  }
}
