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

class AmendRegistrationSpec extends BaseSpec {

  private val registration = Registration
  private val auth         = Auth
  private val email        = EmailVerification

  Feature("Amend Registration journeys") {

    Scenario("A user can amend all of the answers on their registration - first combination (no to yes)") {

      Given("the user accesses the Amend Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("300000001", "Organisation", "hasOSSEnrolment", "amendMinimal")

      And("the user is on the change-your-registration page")
      registration.checkJourneyUrl("change-your-registration")

      When("the user selects the change link for have uk trading name")
      registration.selectChangeOrRemoveLink(
        "amend-have-uk-trading-name"
      )

      Then("the user answers yes on the amend-have-uk-trading-name page")
      registration.checkJourneyUrl("amend-have-uk-trading-name")
      registration.answerRadioButton("yes")

      And("the user adds two trading names")
      registration.checkJourneyUrl("amend-uk-trading-name/1")
      registration.enterAnswer("my trading name")
      registration.checkJourneyUrl("amend-add-uk-trading-name")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("amend-uk-trading-name/2")
      registration.enterAnswer("another company")
      registration.checkJourneyUrl("amend-add-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("change-your-registration")

      When("the user selects the change link for previous oss")
      registration.selectChangeOrRemoveLink(
        "amend-previous-oss"
      )

      Then("the user answers yes on the amend-previous-oss page")
      registration.checkJourneyUrl("amend-previous-oss")
      registration.answerRadioButton("yes")

      Then("the user adds two previous schemes for Finland")
      registration.checkJourneyUrl("amend-previous-country/1")
      registration.selectCountry("Finland")
      registration.checkJourneyUrl("amend-previous-scheme/1/1")
      registration.answerSchemeType("OSS")
      registration.checkJourneyUrl("amend-previous-oss-scheme-number/1/1")
      registration.enterAnswer("FI11111111")
      registration.checkJourneyUrl("amend-previous-scheme-answers/1")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("amend-previous-scheme/1/2")
      registration.answerSchemeType("IOSS")
      registration.checkJourneyUrl("amend-previous-ioss-scheme/1/2")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("amend-previous-ioss-number/1/2")
      registration.enterIossNumber("IM2467777777")
      registration.checkJourneyUrl("amend-previous-scheme-answers/1")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("amend-previous-schemes-overview")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("change-your-registration")

      When("the user selects the change link for tax in eu")
      registration.selectChangeOrRemoveLink(
        "amend-tax-in-eu"
      )

      Then("the user answers yes on the amend-tax-in-eu page")
      registration.checkJourneyUrl("amend-tax-in-eu")
      registration.answerRadioButton("yes")

      And("the user adds eu registration details for two countries")
      And(
        "the user selects a country"
      )
      registration.checkJourneyUrl("amend-eu-tax/1")
      registration.selectCountry("Portugal")
      registration.checkJourneyUrl("amend-sells-goods-to-eu-consumers/1")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("amend-sells-goods-to-eu-consumer-method/1")
      registration.answerFixedEstablishment("fixed establishment")
      registration.checkJourneyUrl("amend-registration-type/1")
      registration.selectRegistrationType("tax id number")
      registration.checkJourneyUrl("amend-eu-tax-number/1")
      registration.enterAnswer("PT8521472")
      registration.checkJourneyUrl("amend-eu-trading-name/1")
      registration.enterAnswer("Portugal Sales")
      registration.checkJourneyUrl("amend-eu-fixed-establishment-address/1")
      registration.enterFixedEstablishmentAddress("1 Address", "", "A town", "", "")
      registration.checkJourneyUrl("amend-check-tax-details/1")
      registration.continue()
      registration.checkJourneyUrl("amend-add-tax-details")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("amend-eu-tax/2")
      registration.selectCountry("Slovenia")
      registration.checkJourneyUrl("amend-sells-goods-to-eu-consumers/2")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("amend-sells-goods-to-eu-consumer-method/2")
      registration.answerFixedEstablishment("dispatch warehouse")
      registration.checkJourneyUrl("amend-registration-type/2")
      registration.selectRegistrationType("vat number")
      registration.checkJourneyUrl("amend-eu-vat-number/2")
      registration.enterAnswer("SI12345678")
      registration.checkJourneyUrl("amend-eu-send-goods-trading-name/2")
      registration.enterAnswer("Slovenia Goods")
      registration.checkJourneyUrl("amend-eu-send-goods-address/2")
      registration.enterFixedEstablishmentAddress("1 Address", "", "A town", "", "SL123355")
      registration.checkJourneyUrl("amend-check-tax-details/2")
      registration.continue()
      registration.checkJourneyUrl("amend-add-tax-details")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("change-your-registration")
    }
  }
}
