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

      When("the user selects the change link for online marketplace")
      registration.selectChangeOrRemoveLink(
        "amend-online-marketplace"
      )

      Then("the user answers yes on the amend-online-marketplace page")
      registration.checkJourneyUrl("amend-online-marketplace")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("change-your-registration")

      When("the user selects the change link for websites")
      registration.selectChangeOrRemoveLink(
        "amend-give-website-address"
      )

      Then("the user answers yes on the amend-give-website-address page")
      registration.checkJourneyUrl("amend-give-website-address")
      registration.answerRadioButton("yes")

      And("the user adds two websites")
      registration.checkJourneyUrl("amend-website-address/1")
      registration.enterAnswer("www.first-website.com")
      registration.checkJourneyUrl("amend-add-website-address")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("amend-website-address/2")
      registration.enterAnswer("www.anotherwebsiteurl.com")
      registration.checkJourneyUrl("amend-add-website-address")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("change-your-registration")

      When("the user selects the change link for contact details")
      registration.selectChangeOrRemoveLink(
        "amend-business-contact-details"
      )

      And("the user updates some of their contact details")
      registration.checkJourneyUrl("amend-business-contact-details")
      registration.updateField("fullName", "Another full name")
      registration.updateField("telephoneNumber", "09852355522525")
      registration.continue()
      email.completeEmailVerification("amend")
      registration.checkJourneyUrl("change-your-registration")

      When("the user selects the change link for bank details")
      registration.selectChangeOrRemoveLink(
        "amend-bank-details"
      )

      And("the user updates their bank details")
      registration.checkJourneyUrl("amend-bank-details")
      registration.updateField("accountName", "Different Name")
      registration.updateField("bic", "ABCDDD2A")
      registration.updateField("iban", "GB33BUKB20201555555555555")
      registration.continue()
      registration.checkJourneyUrl("change-your-registration")

      And("the user can submit their amended registration")
      registration.submit()
      registration.checkJourneyUrl("successful-amend")

      And("the correct answers are displayed as amended on the confirmation page")
      registration.checkAmendedAnswers("noToYes")
    }

    Scenario("A user can amend all of the answers on their registration - second combination (yes to no/amends)") {

      Given("the user accesses the Amend Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("300000002", "Organisation", "hasOSSEnrolment", "amendFull")

      And("the user is on the change-your-registration page")
      registration.checkJourneyUrl("change-your-registration")

      When("the user selects the change link for add uk trading name")
      registration.selectChangeOrRemoveLink(
        "amend-add-uk-trading-name"
      )

      Then("the user amends and removes trading names")
      registration.checkJourneyUrl("amend-add-uk-trading-name")
      registration.selectChangeOrRemoveLink(
        "amend-uk-trading-name\\/2"
      )
      registration.checkJourneyUrl("amend-uk-trading-name/2")
      registration.enterAnswer("Trading name two")
      registration.checkJourneyUrl("amend-add-uk-trading-name")
      registration.selectChangeOrRemoveLink(
        "amend-remove-uk-trading-name\\/1"
      )
      registration.checkJourneyUrl("amend-remove-uk-trading-name/1")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("amend-add-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("change-your-registration")

      When("the user selects the change link for previous schemes overview")
      registration.selectChangeOrRemoveLink(
        "amend-previous-schemes-overview"
      )

      Then("the user adds some additional previous schemes")
      registration.checkJourneyUrl("amend-previous-schemes-overview")
      registration.selectChangeOrRemoveLink("amend-previous-scheme-answers\\/2")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("amend-previous-scheme/2/2")
      registration.answerSchemeType("OSS")
      registration.checkJourneyUrl("amend-previous-oss-scheme-number/2/2")
      registration.enterAnswer("BG987654321")
      registration.checkJourneyUrl("amend-previous-scheme-answers/2")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("amend-previous-schemes-overview")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("amend-previous-country/5")
      registration.selectCountry("Spain")
      registration.checkJourneyUrl("amend-previous-scheme/5/1")
      registration.answerSchemeType("IOSS")
      registration.checkJourneyUrl("amend-previous-ioss-scheme/5/1")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("amend-previous-ioss-number/5/1")
      registration.enterIossNumber("IM7241234567")
      registration.checkJourneyUrl("amend-previous-scheme-answers/5")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("amend-previous-scheme/5/2")
      registration.answerSchemeType("OSS")
      registration.checkJourneyUrl("amend-previous-oss-scheme-number/5/2")
      registration.enterAnswer("ESX1234567X")
      registration.checkJourneyUrl("amend-previous-scheme-answers/5")

      And("the user removes some of their previous scheme answers")
      registration.selectChangeOrRemoveLink("amend-remove-previous-scheme\\/5\\/2")
      registration.checkJourneyUrl("amend-remove-previous-scheme/5/2")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("amend-previous-scheme-answers/5")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("amend-previous-schemes-overview")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("amend-previous-country/6")
      registration.selectCountry("Malta")
      registration.checkJourneyUrl("amend-previous-scheme/6/1")
      registration.answerSchemeType("OSS")
      registration.checkJourneyUrl("amend-previous-oss-scheme-number/6/1")
      registration.enterAnswer("MT12345666")
      registration.checkJourneyUrl("amend-previous-scheme-answers/6")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("amend-previous-schemes-overview")
      registration.selectChangeOrRemoveLink("amend-remove-deregistration\\/6")
      registration.checkJourneyUrl("amend-remove-deregistration/6")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("amend-previous-schemes-overview")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("change-your-registration")

      When("the user selects the change link for add tax details")
      registration.selectChangeOrRemoveLink(
        "amend-add-tax-details"
      )

      Then("the user amends tax details for a country")
      registration.checkJourneyUrl("amend-add-tax-details")
      registration.selectChangeOrRemoveLink(
        "amend-check-tax-details\\/2"
      )
      registration.checkJourneyUrl("amend-check-tax-details/2")
      registration.selectChangeOrRemoveLink(
        "amend-sells-goods-to-eu-consumers\\/2"
      )
      registration.checkJourneyUrl("amend-sells-goods-to-eu-consumers/2")
      registration.answerRadioButton("yes")
      registration.answerFixedEstablishment("fixed establishment")
      registration.checkJourneyUrl("amend-registration-type/2")
      registration.selectRegistrationType("vat number")
      registration.checkJourneyUrl("amend-eu-vat-number/2")
      registration.continue()
      registration.checkJourneyUrl("amend-eu-trading-name/2")
      registration.enterAnswer("Amsterdam trading")
      registration.checkJourneyUrl("amend-eu-fixed-establishment-address/2")
      registration.enterFixedEstablishmentAddress("123 Address Street", "", "A Town-City", "", "AM4563 H")
      registration.checkJourneyUrl("amend-check-tax-details/2")
      registration.continue()
      registration.checkJourneyUrl("amend-add-tax-details")

      And("the user changes answer for selling to EU from a country to no")
      registration.selectChangeOrRemoveLink(
        "amend-check-tax-details\\/1"
      )
      registration.checkJourneyUrl("amend-check-tax-details/1")
      registration.selectChangeOrRemoveLink(
        "amend-sells-goods-to-eu-consumers\\/1"
      )
      registration.checkJourneyUrl("amend-sells-goods-to-eu-consumers/1")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("amend-sales-declaration-not-required/1")
      registration.continue()
      registration.checkJourneyUrl("amend-eu-vat/1")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("amend-no-vat-number-for-eu-country/1")
      registration.continue()

      And("the user removes tax details for a country")
      registration.checkJourneyUrl("amend-add-tax-details")
      registration.selectChangeOrRemoveLink(
        "amend-remove-tax-details\\/2"
      )
      registration.checkJourneyUrl("amend-remove-tax-details/2")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("amend-add-tax-details")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("change-your-registration")

      When("the user selects the change link for online marketplace")
      registration.selectChangeOrRemoveLink(
        "amend-online-marketplace"
      )

      Then("the user changes online marketplace answer to no")
      registration.checkJourneyUrl("amend-online-marketplace")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("change-your-registration")

      When("the user selects the change link for add website address")
      registration.selectChangeOrRemoveLink(
        "amend-add-website-address"
      )

      Then("the user amends and removes website addresses")
      registration.checkJourneyUrl("amend-add-website-address")
      registration.selectChangeOrRemoveLink(
        "amend-website-address\\/1"
      )
      registration.checkJourneyUrl("amend-website-address/1")
      registration.enterAnswer("www.anotherwebsite.com")
      registration.checkJourneyUrl("amend-add-website-address")
      registration.selectChangeOrRemoveLink(
        "amend-remove-website-address\\/2"
      )
      registration.checkJourneyUrl("amend-remove-website-address/2")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("amend-add-website-address")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("change-your-registration")

      When("the user selects the change link for contact details")
      registration.selectChangeOrRemoveLink(
        "amend-business-contact-details"
      )

      And("the user updates some of their contact details")
      registration.checkJourneyUrl("amend-business-contact-details")
      registration.updateField("fullName", "Another full-name")
      registration.updateField("emailAddress", "email-test@test.com")
      registration.continue()
      email.completeEmailVerification("amend")
      registration.checkJourneyUrl("change-your-registration")

      And("the user can submit their amended registration")
      registration.submit()
      registration.checkJourneyUrl("successful-amend")

      And("the correct answers are displayed as amended on the confirmation page")
      registration.checkAmendedAnswers("amended")
    }
  }
}
