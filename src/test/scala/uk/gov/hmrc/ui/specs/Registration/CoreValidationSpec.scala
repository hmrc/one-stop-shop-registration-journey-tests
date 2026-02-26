/*
 * Copyright 2026 HM Revenue & Customs
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

package uk.gov.hmrc.ui.specs.Registration

import uk.gov.hmrc.ui.pages.*
import uk.gov.hmrc.ui.specs.BaseSpec

import java.time.LocalDate

class CoreValidationSpec extends BaseSpec {

  private val registration = Registration
  private val auth         = Auth

  private val currentYear = LocalDate.now().getYear

  Feature("Core Validation journeys") {

    Scenario("User is excluded from OSS due to already being registered for a scheme in Estonia") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("333333333", "Organisation", "vatOnly", "registration")
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

      And("the user is on the already-registered-other-country?countryCode=EE page")
      registration.checkJourneyUrl("already-registered-other-country?countryCode=EE")
    }

    Scenario("User is excluded from OSS due to excluded and quarantined in Estonia") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("333333334", "Organisation", "vatOnly", "registration")
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

      And("the user is on the other-country-excluded-and-quarantined page")
      registration.checkJourneyUrl(
        s"other-country-excluded-and-quarantined?countryCode=EE&exclusionDate=$currentYear-01-01"
      )
    }

    Scenario("Active OSS Reg in another EU country") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000001", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user answers registration questions up to previous scheme")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("sell-from-northern-ireland")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("northern-ireland-business")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("business-pay")
      registration.continue()
      registration.checkJourneyUrl("confirm-vat-details")
      registration.answerVatDetailsChoice("Yes")
      registration.checkJourneyUrl("have-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("already-made-sales")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("date-of-first-sale")
      registration.enterDate("yesterday")

      Then("the user enters an OSS registration that is already active in another EU country")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-country/1")
      registration.selectCountry("Germany")
      registration.checkJourneyUrl("previous-scheme/1/1")
      registration.answerSchemeType("OSS")
      registration.checkJourneyUrl("previous-oss-scheme-number/1/1")
      registration.enterAnswer("DE123456789")

      And("the user is on the scheme-still-active/1/1?countryCode=EE page")
      registration.checkJourneyUrl("scheme-still-active/1/1?countryCode=EE")
    }

    Scenario("Quarantined OSS in another EU country") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000001", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user answers registration questions up to previous scheme")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("sell-from-northern-ireland")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("northern-ireland-business")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("business-pay")
      registration.continue()
      registration.checkJourneyUrl("confirm-vat-details")
      registration.answerVatDetailsChoice("Yes")
      registration.checkJourneyUrl("have-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("already-made-sales")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("date-of-first-sale")
      registration.enterDate("yesterday")

      Then("the user enters an OSS registration that is quarantined in another EU country")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-country/1")
      registration.selectCountry("France")
      registration.checkJourneyUrl("previous-scheme/1/1")
      registration.answerSchemeType("OSS")
      registration.checkJourneyUrl("previous-oss-scheme-number/1/1")
      registration.enterAnswer("FRXX123456789")

      And("the user is on the scheme-quarantined/1/1 page")
      registration.checkJourneyUrl("scheme-quarantined/1/1")
    }

    Scenario("Quarantined IOSS in another EU country") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000001", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user answers registration questions up to previous scheme")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("sell-from-northern-ireland")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("northern-ireland-business")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("business-pay")
      registration.continue()
      registration.checkJourneyUrl("confirm-vat-details")
      registration.answerVatDetailsChoice("Yes")
      registration.checkJourneyUrl("have-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("already-made-sales")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("date-of-first-sale")
      registration.enterDate("yesterday")

      Then("the user enters an IOSS registration that is quarantined in another EU country")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-country/1")
      registration.selectCountry("Greece")
      registration.checkJourneyUrl("previous-scheme/1/1")
      registration.answerSchemeType("IOSS")
      registration.checkJourneyUrl("previous-ioss-scheme/1/1")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-ioss-number/1/1")
      registration.enterIossNumber("IM3001234567")

      And("the user is on the scheme-quarantined/1/1 page")
      registration.checkJourneyUrl("scheme-quarantined/1/1")
    }

    Scenario("Cannot register with a fixed establishment that is already registered on a One Stop Shop service") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000001", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user answers registration questions up to fixed establishments")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("sell-from-northern-ireland")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("northern-ireland-business")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("business-pay")
      registration.continue()
      registration.checkJourneyUrl("confirm-vat-details")
      registration.answerVatDetailsChoice("Yes")
      registration.checkJourneyUrl("have-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("already-made-sales")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("date-of-first-sale")
      registration.enterDate("yesterday")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("start-date")
      registration.continue()

      Then("the user enters a fixed establishment already registered on another One Stop Shop service")
      registration.checkJourneyUrl("tax-in-eu")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("eu-tax/1")
      registration.selectCountry("Greece")
      registration.checkJourneyUrl("sells-goods-to-eu-consumers/1")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("sells-goods-to-eu-consumer-method/1")
      registration.answerFixedEstablishment("fixed establishment")
      registration.checkJourneyUrl("registration-type/1")
      registration.selectRegistrationType("vat number")
      registration.checkJourneyUrl("eu-vat-number/1")
      registration.enterAnswer("EL123456788")

      And("the user is on the fixed-establishment-vrn-already-registered/1 page")
      registration.checkJourneyUrl("fixed-establishment-vrn-already-registered/1")
    }

    Scenario("Cannot register with a fixed establishment that is quarantined on a One Stop Shop service") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000001", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user answers registration questions up to fixed establishments")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("sell-from-northern-ireland")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("northern-ireland-business")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("business-pay")
      registration.continue()
      registration.checkJourneyUrl("confirm-vat-details")
      registration.answerVatDetailsChoice("Yes")
      registration.checkJourneyUrl("have-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("already-made-sales")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("date-of-first-sale")
      registration.enterDate("yesterday")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("start-date")
      registration.continue()

      Then("the user enters a fixed establishment quarantined on another One Stop Shop service")
      registration.checkJourneyUrl("tax-in-eu")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("eu-tax/1")
      registration.selectCountry("Greece")
      registration.checkJourneyUrl("sells-goods-to-eu-consumers/1")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("sells-goods-to-eu-consumer-method/1")
      registration.answerFixedEstablishment("fixed establishment")
      registration.checkJourneyUrl("registration-type/1")
      registration.selectRegistrationType("tax id number")
      registration.checkJourneyUrl("eu-tax-number/1")
      registration.enterAnswer("333333336")

      And("the user is on the excluded-vrn page")
      registration.checkJourneyUrl("excluded-vrn")
    }

    Scenario("Kickout in the registration journey when the user is quarantined on the Import One Stop Shop service") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000001", "Organisation", "hasIOSSEnrolment", "quarantineIOSS")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user answers the filter questions")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("sell-from-northern-ireland")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("northern-ireland-business")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("business-pay")
      registration.continue()

      Then("the user is on the cannot-register-quarantined-ioss-trader page")
      registration.checkJourneyUrl("cannot-register-quarantined-ioss-trader")
    }

    Scenario(
      "User can access the registration journey when a quarantine on the Import One Stop Shop service has expired"
    ) {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000001", "Organisation", "hasIOSSEnrolment", "quarantineExpiredIOSS")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user answers the filter questions")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("sell-from-northern-ireland")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("northern-ireland-business")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("business-pay")
      registration.continue()

      Then("the user is on the confirm-vat-details page")
      registration.checkJourneyUrl("confirm-vat-details")
    }
  }
}
