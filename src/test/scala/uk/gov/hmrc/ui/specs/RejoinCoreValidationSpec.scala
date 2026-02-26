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

import java.time.LocalDate

class RejoinCoreValidationSpec extends BaseSpec {

  private val registration     = Registration
  private val auth             = Auth
  private val commencementDate = CommencementDate

  private val currentYear = LocalDate.now().getYear

  Feature("Rejoin Core Validation journeys") {

    Scenario("A trader with a quarantined VRN cannot access the rejoin journey") {

      Given("the user accesses the Rejoin Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("333333222", "Organisation", "hasOSSEnrolment", "rejoin")

      Then("the user is on the cannot-rejoin-quarantined-country page")
      registration.checkJourneyUrl(s"cannot-rejoin-quarantined-country?countryCode=EE&exclusionDate=$currentYear-01-01")
    }

    Scenario("A trader with a quarantined previous registration retrieved from ETMP cannot access the rejoin journey") {

      Given("the user accesses the Rejoin Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("333333666", "Organisation", "hasOSSEnrolment", "rejoin")

      Then("the user is on the cannot-rejoin-quarantined-country page")
      registration.checkJourneyUrl(s"cannot-rejoin-quarantined-country?countryCode=EE&exclusionDate=$currentYear-01-01")
    }

    Scenario("A trader with a quarantined EU VAT registration retrieved from ETMP cannot access the rejoin journey") {

      Given("the user accesses the Rejoin Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("333333777", "Organisation", "hasOSSEnrolment", "rejoin")

      Then("the user is on the cannot-rejoin-quarantined-country page")
      registration.checkJourneyUrl(s"cannot-rejoin-quarantined-country?countryCode=EE&exclusionDate=$currentYear-01-01")
    }

    Scenario("A trader with a VRN that is still active on another scheme cannot access the rejoin journey") {

      Given("the user accesses the Rejoin Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("333333111", "Organisation", "hasOSSEnrolment", "rejoin")

      Then("the user is on the rejoin-already-registered-other-country page")
      registration.checkJourneyUrl("rejoin-already-registered-other-country?countryCode=EE")
    }

    Scenario(
      "A trader with a VRN that is still active on a previous registration retrieved from ETMP cannot access the rejoin journey"
    ) {

      Given("the user accesses the Rejoin Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("333333444", "Organisation", "hasOSSEnrolment", "rejoin")

      Then("the user is on the rejoin-already-registered-other-country page")
      registration.checkJourneyUrl("rejoin-already-registered-other-country?countryCode=EE")
    }

    Scenario(
      " A trader with a VRN that is still active on an EU VAT registration retrieved from ETMP cannot access the rejoin journey"
    ) {

      Given("the user accesses the Rejoin Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("333333555", "Organisation", "hasOSSEnrolment", "rejoin")

      Then("the user is on the rejoin-already-registered-other-country page")
      registration.checkJourneyUrl("rejoin-already-registered-other-country?countryCode=EE")
    }

    Scenario("A trader is unable to rejoin with a quarantined previous OSS scheme") {

      Given("the user accesses the Rejoin Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("600000019", "Organisation", "hasOSSEnrolment", "rejoin")

      And("the user enters date of first sale information")
      registration.checkJourneyUrl("rejoin-already-made-sales")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-date-of-first-sale")
      registration.enterDate("today")
      registration.checkJourneyUrl("rejoin-start-date")
      commencementDate.checkCommencementDate("today")
      registration.continue()
      registration.checkJourneyUrl("rejoin-registration")

      When("the user adds a quarantined OSS scheme")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-previous-oss"
      )
      registration.checkJourneyUrl("rejoin-amend-previous-oss")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-amend-previous-country/1")
      registration.selectCountry("France")
      registration.checkJourneyUrl("rejoin-amend-previous-scheme/1/1")
      registration.answerSchemeType("OSS")
      registration.checkJourneyUrl("rejoin-amend-previous-oss-scheme-number/1/1")
      registration.enterAnswer("FRXX123456789")

      Then("the user is on the cannot-rejoin-quarantined-country page")
      registration.checkJourneyUrl(s"cannot-rejoin-quarantined-country?countryCode=EE&exclusionDate=$currentYear-01-01")
    }

    Scenario("A trader is unable to rejoin with a previous OSS scheme that is still active") {

      Given("the user accesses the Rejoin Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("600000019", "Organisation", "hasOSSEnrolment", "rejoin")

      And("the user enters date of first sale information")
      registration.checkJourneyUrl("rejoin-already-made-sales")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-date-of-first-sale")
      registration.enterDate("today")
      registration.checkJourneyUrl("rejoin-start-date")
      commencementDate.checkCommencementDate("today")
      registration.continue()
      registration.checkJourneyUrl("rejoin-registration")

      When("the user adds an already active OSS scheme")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-previous-oss"
      )
      registration.checkJourneyUrl("rejoin-amend-previous-oss")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-amend-previous-country/1")
      registration.selectCountry("Germany")
      registration.checkJourneyUrl("rejoin-amend-previous-scheme/1/1")
      registration.answerSchemeType("OSS")
      registration.checkJourneyUrl("rejoin-amend-previous-oss-scheme-number/1/1")
      registration.enterAnswer("DE123456789")

      Then("the user is on the rejoin-already-registered-other-country page")
      registration.checkJourneyUrl("rejoin-already-registered-other-country?countryCode=EE")
    }

    Scenario("A trader is unable to rejoin with a quarantined previous IOSS scheme") {

      Given("the user accesses the Rejoin Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("600000019", "Organisation", "hasOSSEnrolment", "rejoin")

      And("the user enters date of first sale information")
      registration.checkJourneyUrl("rejoin-already-made-sales")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-date-of-first-sale")
      registration.enterDate("today")
      registration.checkJourneyUrl("rejoin-start-date")
      commencementDate.checkCommencementDate("today")
      registration.continue()
      registration.checkJourneyUrl("rejoin-registration")

      When("the user adds a quarantined IOSS scheme")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-previous-oss"
      )
      registration.checkJourneyUrl("rejoin-amend-previous-oss")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-amend-previous-country/1")
      registration.selectCountry("Greece")
      registration.checkJourneyUrl("rejoin-amend-previous-scheme/1/1")
      registration.answerSchemeType("IOSS")
      registration.checkJourneyUrl("rejoin-amend-previous-ioss-scheme/1/1")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("rejoin-amend-previous-ioss-number/1/1")
      registration.enterIossNumber("IM3001234567")

      Then("the user is on the cannot-rejoin-quarantined-country page")
      registration.checkJourneyUrl(s"cannot-rejoin-quarantined-country?countryCode=EE&exclusionDate=$currentYear-01-01")
    }

    Scenario("A trader is able to rejoin with a previous IOSS scheme that is still active") {

      Given("the user accesses the Rejoin Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("600000019", "Organisation", "hasOSSEnrolment", "rejoin")

      And("the user enters date of first sale information")
      registration.checkJourneyUrl("rejoin-already-made-sales")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-date-of-first-sale")
      registration.enterDate("today")
      registration.checkJourneyUrl("rejoin-start-date")
      commencementDate.checkCommencementDate("today")
      registration.continue()
      registration.checkJourneyUrl("rejoin-registration")

      When("the user adds a quarantined IOSS scheme")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-previous-oss"
      )
      registration.checkJourneyUrl("rejoin-amend-previous-oss")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-amend-previous-country/1")
      registration.selectCountry("France")
      registration.checkJourneyUrl("rejoin-amend-previous-scheme/1/1")
      registration.answerSchemeType("IOSS")
      registration.checkJourneyUrl("rejoin-amend-previous-ioss-scheme/1/1")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("rejoin-amend-previous-ioss-number/1/1")
      registration.enterIossNumber("IM2501234567")

      And("the user can submit their registration")
      registration.checkJourneyUrl("rejoin-amend-previous-scheme-answers/1")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("rejoin-amend-previous-schemes-overview")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("rejoin-registration")
      registration.submit()
      registration.checkJourneyUrl("successful-rejoin")
    }

    Scenario("A trader is unable to rejoin with a quarantined EU registration") {

      Given("the user accesses the Rejoin Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("600000019", "Organisation", "hasOSSEnrolment", "rejoin")

      And("the user enters date of first sale information")
      registration.checkJourneyUrl("rejoin-already-made-sales")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-date-of-first-sale")
      registration.enterDate("today")
      registration.checkJourneyUrl("rejoin-start-date")
      commencementDate.checkCommencementDate("today")
      registration.continue()
      registration.checkJourneyUrl("rejoin-registration")

      When("the user enters a quarantined EU registration")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-tax-in-eu"
      )
      registration.checkJourneyUrl("rejoin-amend-tax-in-eu")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-amend-eu-tax/1")
      registration.selectCountry("Greece")
      registration.checkJourneyUrl("rejoin-sells-goods-to-eu-consumers/1")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-sells-goods-to-eu-consumer-method/1")
      registration.answerFixedEstablishment("fixed establishment")
      registration.checkJourneyUrl("rejoin-registration-type/1")
      registration.selectRegistrationType("tax id number")
      registration.checkJourneyUrl("rejoin-amend-eu-tax-number/1")
      registration.enterAnswer("333333336")

      Then("the user is on the cannot-rejoin-quarantined-country page")
      registration.checkJourneyUrl(s"cannot-rejoin-quarantined-country?countryCode=EE&exclusionDate=$currentYear-01-01")
    }

    Scenario("A trader is unable to rejoin with an EU registration that is still active in another country") {

      Given("the user accesses the Rejoin Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("600000019", "Organisation", "hasOSSEnrolment", "rejoin")

      And("the user enters date of first sale information")
      registration.checkJourneyUrl("rejoin-already-made-sales")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-date-of-first-sale")
      registration.enterDate("today")
      registration.checkJourneyUrl("rejoin-start-date")
      commencementDate.checkCommencementDate("today")
      registration.continue()
      registration.checkJourneyUrl("rejoin-registration")

      When("the user enters an already active EU registration")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-tax-in-eu"
      )
      registration.checkJourneyUrl("rejoin-amend-tax-in-eu")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-amend-eu-tax/1")
      registration.selectCountry("Greece")
      registration.checkJourneyUrl("rejoin-sells-goods-to-eu-consumers/1")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-sells-goods-to-eu-consumer-method/1")
      registration.answerFixedEstablishment("fixed establishment")
      registration.checkJourneyUrl("rejoin-registration-type/1")
      registration.selectRegistrationType("vat number")
      registration.checkJourneyUrl("rejoin-amend-eu-vat-number/1")
      registration.enterAnswer("EL123456788")

      Then("the user is on the rejoin-already-registered-other-country page")
      registration.checkJourneyUrl("rejoin-already-registered-other-country?countryCode=EE")
    }

    Scenario(
      "Kickout when the user attempts to rejoin the service but is quarantined on the Import One Stop Shop service"
    ) {

      Given("the user accesses the Amend Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("600000050", "Organisation", "hasOSSAndIOSSEnrolment", "rejoinQuarantinedIOSS")

      When("the user is on the cannot-register-quarantined-ioss-trader page")
      registration.checkJourneyUrl("cannot-register-quarantined-ioss-trader")
    }
  }
}
