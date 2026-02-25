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

class RejoinSpec extends BaseSpec {

  private val registration = Registration
  private val auth         = Auth
  private val email        = EmailVerification
  private val commencementDate        = CommencementDate

  Feature("Rejoin Registration journeys") {

    Scenario("An excluded user who has made sales in this quarter can re-register for the OSS scheme") {

      Given("the user accesses the Rejoin Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("600000019", "Organisation", "hasOSSEnrolment", "rejoin")

      And("the user is on the rejoin-already-made-sales page")
      registration.checkJourneyUrl("rejoin-already-made-sales")

      When("the user answers yes on the rejoin-already-made-sales page")
      registration.answerRadioButton("yes")

      Then("the user enters today for rejoin-date-of-first-sale")
      registration.checkJourneyUrl("rejoin-date-of-first-sale")
      registration.enterDate("today")

      And("the rejoin-start-date page displays a commencement date of today")
      registration.checkJourneyUrl("rejoin-start-date")
      commencementDate.checkCommencementDate("today")
      registration.continue()

      And("the user can submit their registration successfully")
      registration.checkJourneyUrl("rejoin-registration")
      registration.submit()
      registration.checkJourneyUrl("successful-rejoin")
    }

    Scenario("An excluded user who has not made sales in this quarter can re-register for the OSS scheme") {

      Given("the user accesses the Rejoin Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("600000019", "Organisation", "hasOSSEnrolment", "rejoin")

      And("the user is on the rejoin-already-made-sales page")
      registration.checkJourneyUrl("rejoin-already-made-sales")

      When("the user answers no on the rejoin-already-made-sales page")
      registration.answerRadioButton("no")

      And("the rejoin-start-date page displays a commencement date of the first day of the next quarter")
      registration.checkJourneyUrl("rejoin-start-date")
      commencementDate.commencementDateNextQuarter()
      registration.continue()

      And("the user can submit their registration successfully")
      registration.checkJourneyUrl("rejoin-registration")
      registration.submit()
      registration.checkJourneyUrl("successful-rejoin")
    }

    Scenario("An excluded user can set date of first sale to this quarter and then change to not made sales in this quarter") {

      Given("the user accesses the Rejoin Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("600000019", "Organisation", "hasOSSEnrolment", "rejoin")

      And("the user is on the rejoin-already-made-sales page")
      registration.checkJourneyUrl("rejoin-already-made-sales")

      When("the user answers yes on the rejoin-already-made-sales page")
      registration.answerRadioButton("yes")

      Then("the user enters today for rejoin-date-of-first-sale")
      registration.checkJourneyUrl("rejoin-date-of-first-sale")
      registration.enterDate("today")

      And("the rejoin-start-date page displays a commencement date of today")
      registration.checkJourneyUrl("rejoin-start-date")
      commencementDate.checkCommencementDate("today")
      registration.continue()
      registration.checkJourneyUrl("rejoin-registration")

      When("the user changes the answer for already made sales to no and the commencement date changes to next quarter")
      registration.selectChangeOrRemoveLink(
        "rejoin-already-made-sales"
      )
      registration.checkJourneyUrl("rejoin-already-made-sales")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("rejoin-start-date")
      commencementDate.commencementDateNextQuarter()
      registration.continue()

      And("the user can submit their registration successfully")
      registration.checkJourneyUrl("rejoin-registration")
      registration.submit()
      registration.checkJourneyUrl("successful-rejoin")
    }

    Scenario("An excluded user who is rejoining the OSS scheme can make amendments to their minimal registration data") {

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

      Then("the user amends trading name details")
      registration.selectChangeOrRemoveLink("rejoin-amend-have-uk-trading-name")
      registration.checkJourneyUrl("rejoin-amend-have-uk-trading-name")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-amend-uk-trading-name/1")
      registration.enterAnswer("my rejoined trading name")
      registration.checkJourneyUrl("rejoin-amend-add-uk-trading-name")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-amend-uk-trading-name/2")
      registration.enterAnswer("another rejoin company")
      registration.checkJourneyUrl("rejoin-amend-add-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("rejoin-registration")

      Then("the user amends previous scheme details")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-previous-oss"
      )
      registration.checkJourneyUrl("rejoin-amend-previous-oss")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-amend-previous-country/1")
      registration.selectCountry("Finland")
      registration.checkJourneyUrl("rejoin-amend-previous-scheme/1/1")
      registration.answerSchemeType("OSS")
      registration.checkJourneyUrl("rejoin-amend-previous-oss-scheme-number/1/1")
      registration.enterAnswer("FI11111111")
      registration.checkJourneyUrl("rejoin-amend-previous-scheme-answers/1")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-amend-previous-scheme/1/2")
      registration.answerSchemeType("IOSS")
      registration.checkJourneyUrl("rejoin-amend-previous-ioss-scheme/1/2")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("rejoin-amend-previous-ioss-number/1/2")
      registration.enterIossNumber("IM2467777777")
      registration.checkJourneyUrl("rejoin-amend-previous-scheme-answers/1")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("rejoin-amend-previous-schemes-overview")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("rejoin-registration")

      Then("the user amends tax information")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-tax-in-eu"
      )
      registration.checkJourneyUrl("rejoin-amend-tax-in-eu")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-amend-eu-tax/1")
      registration.selectCountry("Portugal")
      registration.checkJourneyUrl("rejoin-sells-goods-to-eu-consumers/1")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-sells-goods-to-eu-consumer-method/1")
      registration.answerFixedEstablishment("fixed establishment")
      registration.checkJourneyUrl("rejoin-registration-type/1")
      registration.selectRegistrationType("tax id number")
      registration.checkJourneyUrl("rejoin-amend-eu-tax-number/1")
      registration.enterAnswer("PT8521472")
      registration.checkJourneyUrl("rejoin-amend-eu-trading-name/1")
      registration.enterAnswer("Portugal Sales")
      registration.checkJourneyUrl("rejoin-amend-eu-fixed-establishment-address/1")
      registration.enterFixedEstablishmentAddress("1 Address", "", "A town", "", "")
      registration.checkJourneyUrl("rejoin-amend-check-tax-details/1")
      registration.continue()
      registration.checkJourneyUrl("rejoin-amend-add-tax-details")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-amend-eu-tax/2")
      registration.selectCountry("Slovenia")
      registration.checkJourneyUrl("rejoin-sells-goods-to-eu-consumers/2")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-sells-goods-to-eu-consumer-method/2")
      registration.answerFixedEstablishment("dispatch warehouse")
      registration.checkJourneyUrl("rejoin-registration-type/2")
      registration.selectRegistrationType("vat number")
      registration.checkJourneyUrl("rejoin-amend-eu-vat-number/2")
      registration.enterAnswer("SI12345678")
      registration.checkJourneyUrl("rejoin-amend-eu-send-goods-trading-name/2")
      registration.enterAnswer("Slovenia Goods")
      registration.checkJourneyUrl("rejoin-amend-eu-send-goods-address/2")
      registration.enterFixedEstablishmentAddress("1 Address", "", "A town", "", "SL123355")
      registration.checkJourneyUrl("rejoin-amend-check-tax-details/2")
      registration.continue()
      registration.checkJourneyUrl("rejoin-amend-add-tax-details")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("rejoin-registration")

      Then("the user amends website addresses")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-give-website-address"
      )
      registration.checkJourneyUrl("rejoin-amend-give-website-address")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-amend-website-address/1")
      registration.enterAnswer("www.first-website.com")
      registration.checkJourneyUrl("rejoin-amend-add-website-address")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-amend-website-address/2")
      registration.enterAnswer("www.anotherwebsiteurl.com")
      registration.checkJourneyUrl("rejoin-amend-add-website-address")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("rejoin-registration")

      And("the user can submit their registration successfully")
      registration.submit()
      registration.checkJourneyUrl("successful-rejoin")
    }

    Scenario("A trader with non-mandatory answers in original registration set to yes can change to no and rejoin") {

      Given("the user accesses the Rejoin Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("600000050", "Organisation", "hasOSSEnrolment", "rejoin")

      And("the user enters date of first sale information")
      registration.checkJourneyUrl("rejoin-already-made-sales")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-date-of-first-sale")
      registration.enterDate("today")
      registration.checkJourneyUrl("rejoin-start-date")
      commencementDate.checkCommencementDate("today")
      registration.continue()
      registration.checkJourneyUrl("rejoin-registration")

      Then("the user can remove all of their trading names")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-have-uk-trading-name"
      )
      registration.checkJourneyUrl("rejoin-amend-have-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("rejoin-amend-remove-all-trading-names")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-registration")

      Then("the user can remove all of their tax details")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-tax-in-eu"
      )
      registration.checkJourneyUrl("rejoin-amend-tax-in-eu")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("rejoin-amend-remove-all-eu-details")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-registration")

      Then("the user can change their answer for online marketplaces")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-online-marketplace"
      )
      registration.checkJourneyUrl("rejoin-amend-online-marketplace")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("rejoin-registration")

      Then("the user can remove all of their website addresses")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-give-website-address"
      )
      registration.checkJourneyUrl("rejoin-amend-give-website-address")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("rejoin-amend-remove-all-websites")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-registration")

      And("the user can submit their registration successfully")
      registration.submit()
      registration.checkJourneyUrl("successful-rejoin")
    }

    Scenario("A trader removes some registration answers and amends mandatory answers during rejoin") {

      Given("the user accesses the Rejoin Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("600000050", "Organisation", "hasOSSEnrolment", "rejoin")

      And("the user enters date of first sale information")
      registration.checkJourneyUrl("rejoin-already-made-sales")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-date-of-first-sale")
      registration.enterDate("today")
      registration.checkJourneyUrl("rejoin-start-date")
      commencementDate.checkCommencementDate("today")
      registration.continue()
      registration.checkJourneyUrl("rejoin-registration")

      Then("the user removes tax information")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-add-tax-details"
      )
      registration.checkJourneyUrl("rejoin-amend-add-tax-details")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-remove-tax-details\\/2"
      )
      registration.checkJourneyUrl("rejoin-amend-remove-tax-details/2")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-amend-add-tax-details")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("rejoin-registration")

      Then("the user removes a website address")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-add-website-address"
      )
      registration.checkJourneyUrl("rejoin-amend-add-website-address")
      registration.selectChangeOrRemoveLink("rejoin-remove-website-address\\/1")
      registration.checkJourneyUrl("rejoin-remove-website-address/1")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-amend-add-website-address")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("rejoin-registration")

      And("the user updates some of their contact details")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-business-contact-details"
      )
      registration.checkJourneyUrl("rejoin-amend-business-contact-details")
      registration.updateField("fullName", "Another full rejoin name")
      registration.updateField("telephoneNumber", "09852355522525")
      registration.continue()
      email.completeEmailVerification("rejoin")
      registration.checkJourneyUrl("rejoin-registration")

      And("the user updates their bank details")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-bank-details"
      )
      registration.checkJourneyUrl("rejoin-amend-bank-details")
      registration.updateField("accountName", "Different Rejoin Name")
      registration.updateField("bic", "ABCDDD2A")
      registration.updateField("iban", "GB33BUKB20201555555555555")
      registration.continue()
      registration.checkJourneyUrl("rejoin-registration")

      And("the user can submit their registration successfully")
      registration.submit()
      registration.checkJourneyUrl("successful-rejoin")

    }
  }
}
