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

import uk.gov.hmrc.ui.pages._

class RegistrationSpec extends BaseSpec {

  private val registration = Registration
  private val auth         = Auth
  private val email        = EmailVerification

  Feature("Registration journeys") {

    Scenario("User can complete a registration - full answers") {

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

      Then("the user selects yes on the confirm-vat-details page")
      registration.checkJourneyUrl("confirm-vat-details")
      registration.answerVatDetailsChoice("Yes")

      And("the user selects yes on the have-uk-trading-name page")
      registration.checkJourneyUrl("have-uk-trading-name")
      registration.answerRadioButton("yes")

      And("the user adds the first trading name")
      registration.checkJourneyUrl("uk-trading-name/1")
      registration.enterAnswer("first trading name")

      And("the user selects yes on the add-uk-trading-name page")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.answerRadioButton("yes")

      And("the user adds the second trading name")
      registration.checkJourneyUrl("uk-trading-name/2")
      registration.enterAnswer("trading 2!")

      And("the user selects no on the add-uk-trading-name page")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.answerRadioButton("no")

      And("the user selects yes on the already-made-sales page")
      registration.checkJourneyUrl("already-made-sales")
      registration.answerRadioButton("yes")

      And("the user enters yesterday for date-of-first-sale")
      registration.checkJourneyUrl("date-of-first-sale")
      registration.enterDate("yesterday")

      Then("the user selects on yes on previous-oss page")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("yes")

      Then("the user selects country")
      registration.checkJourneyUrl("previous-country/1")
      registration.selectCountry("Sweden")

      When("the user selects OSS on the previous-scheme page")
      registration.checkJourneyUrl("previous-scheme/1/1")
      registration.answerSchemeType("OSS")

      And("the user adds an OSS union scheme number")
      registration.checkJourneyUrl("previous-oss-scheme-number/1/1")
      registration.enterAnswer("SE012345678987")

      When("the user selects yes on the previous-scheme-answers/1 page")
      registration.checkJourneyUrl("previous-scheme-answers/1")
      registration.answerRadioButton("yes")

      When("the user selects IOSS on the previous-scheme page")
      registration.checkJourneyUrl("previous-scheme/1/2")
      registration.answerSchemeType("IOSS")

      When("the user selects yes on the previous-ioss-scheme/1/2 page")
      registration.checkJourneyUrl("previous-ioss-scheme/1/2")
      registration.answerRadioButton("yes")

      And("the user adds an IOSS number")
      registration.checkJourneyUrl("previous-ioss-number/1/2")
      registration.enterIossNumber("IM7527777777")

      When("the user selects no on the previous-scheme-answers/1 page")
      registration.checkJourneyUrl("previous-scheme-answers/1")
      registration.answerRadioButton("no")

      Then("the user selects yes on the previous-schemes-overview page")
      registration.checkJourneyUrl("previous-schemes-overview")
      registration.answerRadioButton("yes")

      Then("the user selects country")
      registration.checkJourneyUrl("previous-country/2")
      registration.selectCountry("Belgium")

      When("the user selects OSS on the previous-scheme page")
      registration.checkJourneyUrl("previous-scheme/2/1")
      registration.answerSchemeType("OSS")

      And("the user adds an OSS non-union scheme number")
      registration.checkJourneyUrl("previous-oss-scheme-number/2/1")
      registration.enterAnswer("EU012345678")

      When("the user selects no on the previous-scheme-answers/2 page")
      registration.checkJourneyUrl("previous-scheme-answers/2")
      registration.answerRadioButton("no")

      Then("the user selects no on the previous-schemes-overview page")
      registration.checkJourneyUrl("previous-schemes-overview")
      registration.answerRadioButton("no")

      And("the user continues on the start-date page")
      registration.checkJourneyUrl("start-date")
      registration.continue()

      Then("the user selects yes on the tax-in-eu page")
      registration.checkJourneyUrl("tax-in-eu")
      registration.answerRadioButton("yes")

      And(
        "the user selects a country"
      )
      registration.checkJourneyUrl("eu-tax/1")
      registration.selectCountry("Luxembourg")

      Then("the user selects yes on the sells-goods-to-eu-consumers page")
      registration.checkJourneyUrl("sells-goods-to-eu-consumers/1")
      registration.answerRadioButton("yes")

      And("the user selects fixed establishment on the sells-goods-to-eu-consumer-method/1 page")
      registration.checkJourneyUrl("sells-goods-to-eu-consumer-method/1")
      registration.answerFixedEstablishment("fixed establishment")

      And("the user selects vat number on the registration-type/1 page")
      registration.checkJourneyUrl("registration-type/1")
      registration.selectRegistrationType("vat number")

      And("the user adds a vat number")
      registration.checkJourneyUrl("eu-vat-number/1")
      registration.enterAnswer("LU12345678")

      And("the user enters a trading name")
      registration.checkJourneyUrl("eu-trading-name/1")
      registration.enterAnswer("A Trading Name")

      And("the user enters an address")
      registration.checkJourneyUrl("eu-fixed-establishment-address/1")
      registration.enterFixedEstablishmentAddress("1 Street Name", "", "A town", "", "")

      And("the user continues through the check-tax-details page")
      registration.checkJourneyUrl("check-tax-details/1")
      registration.continue()

      Then("the user selects yes on the add-tax-details page")
      registration.checkJourneyUrl("add-tax-details")
      registration.answerRadioButton("yes")

      And(
        "the user selects a country"
      )
      registration.checkJourneyUrl("eu-tax/2")
      registration.selectCountry("Latvia")

      Then("the user selects yes on the sells-goods-to-eu-consumers page")
      registration.checkJourneyUrl("sells-goods-to-eu-consumers/2")
      registration.answerRadioButton("yes")

      And("the user selects fixed establishment on the sells-goods-to-eu-consumer-method/1 page")
      registration.checkJourneyUrl("sells-goods-to-eu-consumer-method/2")
      registration.answerFixedEstablishment("dispatch warehouse")

      And("the user selects tax id number on the registration-type/2 page")
      registration.checkJourneyUrl("registration-type/2")
      registration.selectRegistrationType("tax id number")

      And("the user adds a tax id number")
      registration.checkJourneyUrl("eu-tax-number/2")
      registration.enterAnswer("ABC123A")

      And("the user enters a trading name")
      registration.checkJourneyUrl("eu-send-goods-trading-name/2")
      registration.enterAnswer("Another Trading Name")

      And("the user enters an address")
      registration.checkJourneyUrl("eu-send-goods-address/2")
      registration.enterFixedEstablishmentAddress("1 Street Name", "", "A town", "", "12345")

      And("the user continues through the check-tax-details page")
      registration.checkJourneyUrl("check-tax-details/2")
      registration.continue()

      Then("the user selects no on the add-tax-details page")
      registration.checkJourneyUrl("add-tax-details")
      registration.answerRadioButton("no")

      And("the user selects no on the online-marketplace page")
      registration.checkJourneyUrl("online-marketplace")
      registration.answerRadioButton("no")

      And("the user selects yes on the give-website-address page")
      registration.checkJourneyUrl("give-website-address")
      registration.answerRadioButton("yes")

      Then("the user adds the first website address")
      registration.checkJourneyUrl("website-address/1")
      registration.enterAnswer("www.first-website.com")

      Then("the user answers yes to add another website address")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("yes")

      Then("the user adds the second website address")
      registration.checkJourneyUrl("website-address/2")
      registration.enterAnswer("http://websiteno2.co.uk")

      Then("the user answers no to adding another website address")
      registration.checkJourneyUrl("add-website-address")
      registration.answerRadioButton("no")

      Then("the user enters their contact details on business-contact-details page")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Joe Bloggs", "01234567890", "email@test.com")

      Then("the user completes the email verification process")
      email.completeEmailVerification("registration")

      Then("the user enters bank details on bank-details page")
      registration.checkJourneyUrl("bank-details")
      registration.fillBankAccountDetails("Account Name", "SMCOGB2LXXM", "GB29NWBK60161331926819")

      When("the user submits the registration on the check-answers page")
      registration.checkJourneyUrl("check-answers")
      registration.submit()

      Then("the user is on the successful submission page")
      registration.checkJourneyUrl("successful")
    }

    Scenario("User can complete a registration - minimal answers") {

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

      Then("the user selects yes on the confirm-vat-details page")
      registration.checkJourneyUrl("confirm-vat-details")
      registration.answerVatDetailsChoice("Yes")

      And("the user selects no on the have-uk-trading-name page")
      registration.checkJourneyUrl("have-uk-trading-name")
      registration.answerRadioButton("no")

      And("the user selects no on the already-made-sales page")
      registration.checkJourneyUrl("already-made-sales")
      registration.answerRadioButton("no")

      Then("the user selects on no on previous-oss page")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("no")

      And("the user continues on the start-date page")
      registration.checkJourneyUrl("start-date")
      registration.continue()

      Then("the user selects no on the tax-in-eu page")
      registration.checkJourneyUrl("tax-in-eu")
      registration.answerRadioButton("no")

      And("the user selects yes on the online-marketplace page")
      registration.checkJourneyUrl("online-marketplace")
      registration.answerRadioButton("yes")

      And("the user selects no on the give-website-address page")
      registration.checkJourneyUrl("give-website-address")
      registration.answerRadioButton("no")

      Then("the user enters their contact details on business-contact-details page")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Joe Bloggs", "+01234567890", "email@test.com")

      Then("the user completes the email verification process")
      email.completeEmailVerification("registration")

      Then("the user enters bank details on bank-details page")
      registration.checkJourneyUrl("bank-details")
      registration.fillBankAccountDetails("Account Name", "", "GB33BUKB20201555555555")

      When("the user submits the registration on the check-answers page")
      registration.checkJourneyUrl("check-answers")
      registration.submit()

      Then("the user is on the successful submission page")
      registration.checkJourneyUrl("successful")
    }

    Scenario("User cannot add fixed establishments when they are part of a VAT group") {

      Given("the user who is not part of a VAT group accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("777777779", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user answers all of the questions leading up to fixed establishments")
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
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("start-date")
      registration.continue()

      Then("the user selects yes on the tax-in-eu page")
      registration.checkJourneyUrl("tax-in-eu")
      registration.answerRadioButton("yes")

      And(
        "the user selects a country"
      )
      registration.checkJourneyUrl("eu-tax/1")
      registration.selectCountry("Finland")

      Then("the user selects yes on the sells-goods-to-eu-consumers page")
      registration.checkJourneyUrl("sells-goods-to-eu-consumers/1")
      registration.answerRadioButton("yes")

      And("the user selects fixed establishment on the sells-goods-to-eu-consumer-method/1 page")
      registration.checkJourneyUrl("sells-goods-to-eu-consumer-method/1")
      registration.answerFixedEstablishment("fixed establishment")

      Then("the user is on the no-fixed-establishments-required/1 page")
      registration.checkJourneyUrl("no-fixed-establishments-required")
      registration.continue()

      Then("the user selects no on the tax-in-eu page")
      registration.checkJourneyUrl("tax-in-eu")
      registration.answerRadioButton("no")

      And("the user selects no on the online-marketplace page")
      registration.checkJourneyUrl("online-marketplace")
      registration.answerRadioButton("no")

      And("the user selects no on the give-website-address page")
      registration.checkJourneyUrl("give-website-address")
      registration.answerRadioButton("no")

      Then("the user enters their contact details on business-contact-details page")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Joe Bloggs", "+01234567890", "email@test.com")

      Then("the user completes the email verification process")
      email.completeEmailVerification("registration")

      Then("the user enters bank details on bank-details page")
      registration.checkJourneyUrl("bank-details")
      registration.fillBankAccountDetails("Account Name", "", "GB33BUKB20201555555555")

      When("the user submits the registration on the check-answers page")
      registration.checkJourneyUrl("check-answers")
      registration.submit()

      Then("the user is on the successful submission page")
      registration.checkJourneyUrl("successful")
    }

    Scenario("User with an individual name instead of an organisation name can complete a registration") {

      Given("the user who has an individual name accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("777777778", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user selects no on the already-eu-registered page")
      registration.answerRadioButton("no")

      Then("the user can complete the rest of the registration")
      registration.minimalRegistrationAnswers()

      Then("the user is on the successful submission page")
      registration.checkJourneyUrl("successful")
    }
  }
}
