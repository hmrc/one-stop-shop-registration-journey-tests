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

class SaveForLaterSpec extends BaseSpec {

  private val registration = Registration
  private val auth         = Auth
  private val email        = EmailVerification

  Feature("Save for Later journeys") {

    Scenario("A user can save their progress and return to the last page they were on") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000600", "Organisation", "vatOnly", "savedWithCredId")
      registration.checkJourneyUrl("already-eu-registered")

      And("the user answers the filter questions")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("sell-from-northern-ireland")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("northern-ireland-business")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("business-pay")
      registration.continue()
      registration.checkJourneyUrl("confirm-vat-details")
      registration.answerVatDetailsChoice("Yes")

      When("the user adds some answers to their registration")
      registration.checkJourneyUrl("have-uk-trading-name")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("uk-trading-name/1")
      registration.enterAnswer("first trading name")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("uk-trading-name/2")
      registration.enterAnswer("trading 2!")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("already-made-sales")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("date-of-first-sale")
      registration.enterDate("yesterday")

      Then("the user clicks on the save and come back later button")
      registration.checkJourneyUrl("previous-oss")
      registration.clickLink("saveProgress")
      registration.checkJourneyUrl("progress-saved?continueUrl=%2Fpay-vat-on-goods-sold-to-eu%2Fnorthern-ireland-register%2Fprevious-oss")

      And("the user clicks on the continue to complete your registration link")
      registration.clickLink("continueToYourReturn")

      Then("the user is returned to their saved registration and can continue entering answers")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-country/1")
      registration.selectCountry("Ireland")
      registration.checkJourneyUrl("previous-scheme/1/1")
      registration.answerSchemeType("OSS")
      registration.checkJourneyUrl("previous-oss-scheme-number/1/1")
      registration.enterAnswer("IE1234567WI")
      registration.checkJourneyUrl("previous-scheme-answers/1")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-schemes-overview")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("start-date")
      registration.continue()
      registration.checkJourneyUrl("tax-in-eu")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("eu-tax/1")
      registration.selectCountry("Romania")
      registration.checkJourneyUrl("sells-goods-to-eu-consumers/1")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("sells-goods-to-eu-consumer-method/1")
      registration.answerFixedEstablishment("fixed establishment")
      registration.checkJourneyUrl("registration-type/1")
      registration.selectRegistrationType("vat number")
      registration.checkJourneyUrl("eu-vat-number/1")
      registration.enterAnswer("RO1234567890")
      registration.checkJourneyUrl("eu-trading-name/1")
      registration.enterAnswer("A Trading Name")
      registration.checkJourneyUrl("eu-fixed-establishment-address/1")
      registration.enterFixedEstablishmentAddress("1 Street Name", "", "A town", "", "")
      registration.checkJourneyUrl("check-tax-details/1")
      registration.continue()
      registration.checkJourneyUrl("add-tax-details")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("eu-tax/2")
      registration.selectCountry("Portugal")
      registration.checkJourneyUrl("sells-goods-to-eu-consumers/2")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("sells-goods-to-eu-consumer-method/2")
      registration.answerFixedEstablishment("dispatch warehouse")
      registration.checkJourneyUrl("registration-type/2")
      registration.selectRegistrationType("tax id number")
      registration.checkJourneyUrl("eu-tax-number/2")
      registration.enterAnswer("PT123456789")
      registration.checkJourneyUrl("eu-send-goods-trading-name/2")
      registration.enterAnswer("Another Trading Name")
      registration.checkJourneyUrl("eu-send-goods-address/2")
      registration.enterFixedEstablishmentAddress("1 Street Name", "", "A town", "", "12345")
      registration.checkJourneyUrl("check-tax-details/2")
      registration.continue()
      registration.checkJourneyUrl("add-tax-details")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("online-marketplace")

      Then("the user clicks on the save and come back later button")
      registration.clickLink("saveProgress")
      registration.checkJourneyUrl("progress-saved?continueUrl=%2Fpay-vat-on-goods-sold-to-eu%2Fnorthern-ireland-register%2Fonline-marketplace")

      And("the user clicks on the continue to complete your registration link")
      registration.clickLink("continueToYourReturn")

      Then("the user is returned to their saved registration and can continue entering answers")
      registration.checkJourneyUrl("online-marketplace")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("give-website-address")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("website-address/1")
      registration.enterAnswer("www.first-website.com")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("website-address/2")
      registration.enterAnswer("http://websiteno2.co.uk")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Joe Bloggs", "01234567890", "email@test.com")
      email.completeEmailVerification("registration")
      registration.checkJourneyUrl("bank-details")
      registration.fillBankAccountDetails("Account Name", "SMCOGB2LXXM", "GB29NWBK60161331926819")
      registration.checkJourneyUrl("check-answers")

      Then("the user clicks on the save and come back later button")
      registration.clickLink("saveProgress")
      registration.checkJourneyUrl("progress-saved?continueUrl=%2Fpay-vat-on-goods-sold-to-eu%2Fnorthern-ireland-register%2Fcheck-answers")

      And("the user clicks on the continue to complete your registration link")
      registration.clickLink("continueToYourReturn")

      And("the user returns to their saved registration to submit it")
      registration.checkJourneyUrl("check-answers")
      registration.submit()

      Then("the user is on the successful submission page")
      registration.checkJourneyUrl("successful")
    }

    Scenario("A user can access their saved registration from government gateway login and complete it") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000601", "Organisation", "vatOnly", "savedWithCredId")
      registration.checkJourneyUrl("already-eu-registered")

      And("the user answers the filter questions")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("sell-from-northern-ireland")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("northern-ireland-business")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("business-pay")
      registration.continue()
      registration.checkJourneyUrl("confirm-vat-details")
      registration.answerVatDetailsChoice("Yes")

      When("the user adds some answers to their registration")
      registration.checkJourneyUrl("have-uk-trading-name")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("uk-trading-name/1")
      registration.enterAnswer("first trading name")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("uk-trading-name/2")
      registration.enterAnswer("trading 2!")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("already-made-sales")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("date-of-first-sale")
      registration.enterDate("yesterday")

      Then("the user clicks on the save and come back later button")
      registration.checkJourneyUrl("previous-oss")
      registration.clickLink("saveProgress")
      registration.checkJourneyUrl("progress-saved?continueUrl=%2Fpay-vat-on-goods-sold-to-eu%2Fnorthern-ireland-register%2Fprevious-oss")

      And("the user clicks on the sign out and come back later link")
      registration.clickLink("signOut")

      When("the user logs in again to the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000601", "Organisation", "vatOnly", "savedRegistration")

      Then("the user is presented with the continue-registration page")
      registration.checkJourneyUrl("continue-registration")

      And("the user answers yes and continues with their saved registration")
      registration.clickLink("continueProgress")
      registration.continue()
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-country/1")
      registration.selectCountry("Ireland")
      registration.checkJourneyUrl("previous-scheme/1/1")
      registration.answerSchemeType("OSS")
      registration.checkJourneyUrl("previous-oss-scheme-number/1/1")
      registration.enterAnswer("IE1234567WI")
      registration.checkJourneyUrl("previous-scheme-answers/1")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-schemes-overview")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("start-date")
      registration.continue()
      registration.checkJourneyUrl("tax-in-eu")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("eu-tax/1")
      registration.selectCountry("Romania")
      registration.checkJourneyUrl("sells-goods-to-eu-consumers/1")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("sells-goods-to-eu-consumer-method/1")
      registration.answerFixedEstablishment("fixed establishment")
      registration.checkJourneyUrl("registration-type/1")
      registration.selectRegistrationType("vat number")
      registration.checkJourneyUrl("eu-vat-number/1")
      registration.enterAnswer("RO1234567890")
      registration.checkJourneyUrl("eu-trading-name/1")
      registration.enterAnswer("A Trading Name")
      registration.checkJourneyUrl("eu-fixed-establishment-address/1")
      registration.enterFixedEstablishmentAddress("1 Street Name", "", "A town", "", "")
      registration.checkJourneyUrl("check-tax-details/1")
      registration.continue()
      registration.checkJourneyUrl("add-tax-details")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("eu-tax/2")
      registration.selectCountry("Portugal")
      registration.checkJourneyUrl("sells-goods-to-eu-consumers/2")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("sells-goods-to-eu-consumer-method/2")
      registration.answerFixedEstablishment("dispatch warehouse")
      registration.checkJourneyUrl("registration-type/2")
      registration.selectRegistrationType("tax id number")
      registration.checkJourneyUrl("eu-tax-number/2")
      registration.enterAnswer("PT123456789")
      registration.checkJourneyUrl("eu-send-goods-trading-name/2")
      registration.enterAnswer("Another Trading Name")
      registration.checkJourneyUrl("eu-send-goods-address/2")
      registration.enterFixedEstablishmentAddress("1 Street Name", "", "A town", "", "12345")
      registration.checkJourneyUrl("check-tax-details/2")
      registration.continue()
      registration.checkJourneyUrl("add-tax-details")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("online-marketplace")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("give-website-address")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("website-address/1")
      registration.enterAnswer("www.first-website.com")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("website-address/2")
      registration.enterAnswer("http://websiteno2.co.uk")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Joe Bloggs", "01234567890", "email@test.com")
      email.completeEmailVerification("registration")
      registration.checkJourneyUrl("bank-details")
      registration.fillBankAccountDetails("Account Name", "SMCOGB2LXXM", "GB29NWBK60161331926819")
      registration.checkJourneyUrl("check-answers")

      And("the user submits their registration")
      registration.submit()

      Then("the user is on the successful submission page")
      registration.checkJourneyUrl("successful")
    }


    Scenario("User accesses continue-on-sign-in url but does not have a saved registration") {

      Given("the user accesses the OSS Registration Service via the continue-on-sign-in url")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000001", "Organisation", "vatOnly", "noSavedRegistration")

      Then("the user is on the no-saved-registration page")
      registration.checkJourneyUrl("no-saved-registration")
    }
  }
}
