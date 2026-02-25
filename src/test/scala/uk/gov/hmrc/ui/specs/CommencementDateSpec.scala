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

class CommencementDateSpec extends BaseSpec {

  private val registration = Registration
  private val auth         = Auth
  private val email        = EmailVerification
  private val commencementDate        = CommencementDate

  Feature("User registers with different commencement dates") {

    Scenario("A user registers within notification period") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000001", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user answers questions up to previous schemes")
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

      Then("the user adds a previous scheme")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-country/1")
      registration.selectCountry("France")
      registration.checkJourneyUrl("previous-scheme/1/1")
      registration.answerSchemeType("OSS")
      registration.checkJourneyUrl("previous-oss-scheme-number/1/1")
      registration.enterAnswer("FRDB123456789")
      registration.checkJourneyUrl("previous-scheme-answers/1")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-schemes-overview")
      registration.answerRadioButton("no")

      And("the user continues on the start-date page")
      registration.checkJourneyUrl("start-date")
      registration.continue()

      Then("the user answers the remaining questions in the registration")
      registration.checkJourneyUrl("tax-in-eu")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("online-marketplace")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("give-website-address")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Joe Bloggs", "01234567890", "email@test.com")
      email.completeEmailVerification("registration")
      registration.checkJourneyUrl("bank-details")
      registration.fillBankAccountDetails("Account Name", "ABCDEF2A", "GB33BUKB20201555555555")

      When("the user submits the registration on the check-answers page")
      registration.checkJourneyUrl("check-answers")
      registration.submit()
      registration.checkJourneyUrl("successful")

      Then("the user is shown the pre 10th version of the successful page")
      commencementDate.checkVersion("pre")
    }

    Scenario("A user's previous registration effective date overrides the date of first sale for commencement date") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000001", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user answers questions up to previous schemes")
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

      Then("the user adds a previous scheme")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("previous-country/1")
      registration.selectCountry("Belgium")
      registration.checkJourneyUrl("previous-scheme/1/1")
      registration.answerSchemeType("OSS")
      registration.checkJourneyUrl("previous-oss-scheme-number/1/1")
      registration.enterAnswer("BE0333333337")
      registration.checkJourneyUrl("previous-scheme-answers/1")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("previous-schemes-overview")
      registration.answerRadioButton("no")

      And("the user is shown a commencement date of today on the start date page instead of the date of their first sale")
      registration.checkJourneyUrl("start-date")
      commencementDate.checkCommencementDate("today")
      registration.continue()

      Then("the user answers the remaining questions in the registration")
      registration.checkJourneyUrl("tax-in-eu")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("online-marketplace")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("give-website-address")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Joe Bloggs", "01234567890", "email@test.com")
      email.completeEmailVerification("registration")
      registration.checkJourneyUrl("bank-details")
      registration.fillBankAccountDetails("Account Name", "ABCDEF2A", "GB33BUKB20201555555555")

      Then("the user changes their date of first sale to 7 days ago")
      registration.checkJourneyUrl("check-answers")
      registration.selectChangeOrRemoveLink(
        "check-date-of-first-sale"
      )
      registration.checkJourneyUrl("check-date-of-first-sale")
      registration.enterDate("7 days ago")

      And("the user is shown the start date page with a commencement date of today due to previous scheme still overriding date of first sale")
      registration.checkJourneyUrl("check-start-date")
      commencementDate.checkCommencementDate("today")
      registration.continue()

      When("the user submits the registration on the check-answers page")
      registration.checkJourneyUrl("check-answers")
      registration.submit()
      registration.checkJourneyUrl("successful")

      Then("the user is shown the pre 10th version of the successful page")
      commencementDate.checkVersion("pre")
    }

    Scenario("A user adds a previous registration via CYA and commencement date is displayed correctly following the change") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000001", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user answers questions up to check-answers")
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
      commencementDate.checkCommencementDate("yesterday")
      registration.continue()
      registration.checkJourneyUrl("tax-in-eu")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("online-marketplace")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("give-website-address")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Joe Bloggs", "01234567890", "email@test.com")
      email.completeEmailVerification("registration")
      registration.checkJourneyUrl("bank-details")
      registration.fillBankAccountDetails("Account Name", "ABCDEF2A", "GB33BUKB20201555555555")

      Then("the user changes their answers to include a previous scheme")
      registration.checkJourneyUrl("check-answers")
      registration.selectChangeOrRemoveLink(
        "check-previous-oss"
      )
      registration.checkJourneyUrl("check-previous-oss")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("check-previous-country/1")
      registration.selectCountry("Belgium")
      registration.checkJourneyUrl("check-previous-scheme/1/1")
      registration.answerSchemeType("OSS")
      registration.checkJourneyUrl("check-previous-oss-scheme-number/1/1")
      registration.enterAnswer("BE0333333337")
      registration.checkJourneyUrl("check-previous-scheme-answers/1")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("check-previous-schemes-overview")
      registration.answerRadioButton("no")

      And("the user is shown the start date page with a commencement date of today due to previous scheme overriding date of first sale")
      registration.checkJourneyUrl("check-start-date")
      commencementDate.checkCommencementDate("today")
      registration.continue()

      When("the user submits the registration on the check-answers page")
      registration.checkJourneyUrl("check-answers")
      registration.submit()
      registration.checkJourneyUrl("successful")

      Then("the user is shown the pre 10th version of the successful page")
      commencementDate.checkVersion("pre")
    }

    Scenario("Will not make sales in this quarter") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000001", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user answers questions in the registration")
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

      And("the start date shows the commencement date set to the first day of the next quarter")
      registration.checkJourneyUrl("start-date")
      commencementDate.commencementDateNextQuarter()
      registration.continue()

      Then("the user continues their registration")
      registration.checkJourneyUrl("tax-in-eu")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("online-marketplace")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("give-website-address")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("business-contact-details")
      registration.fillContactDetails("Joe Bloggs", "01234567890", "email@test.com")
      email.completeEmailVerification("registration")
      registration.checkJourneyUrl("bank-details")
      registration.fillBankAccountDetails("Account Name", "ABCDEF2A", "GB33BUKB20201555555555")

      When("the user submits the registration on the check-answers page")
      registration.checkJourneyUrl("check-answers")
      registration.submit()
      registration.checkJourneyUrl("successful")
    }
  }
}
