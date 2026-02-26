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

package uk.gov.hmrc.ui.specs.Extra

import uk.gov.hmrc.ui.pages.*
import uk.gov.hmrc.ui.specs.BaseSpec

class CrossSchemaSpec extends BaseSpec {

  private val registration     = Registration
  private val auth             = Auth
  private val email            = EmailVerification
  private val crossSchema      = CrossSchema
  private val commencementDate = CommencementDate

  Feature("Cross Schema journeys") {

    Scenario("Registration for trader with a current IOSS registration - amends data") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100005555", "Organisation", "hasIOSSEnrolment", "crossSchemaRegistration")
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

      Then("the user is shown their existing trading names from their IOSS registration")
      registration.checkJourneyUrl("add-uk-trading-name")
      crossSchema.tradingNamesDisplayed("current")
      crossSchema.tradingNameWarnings("current", "registration", true)

      And("the user removes the first trading name")
      registration.selectChangeOrRemoveLink("remove-uk-trading-name\\/1")
      registration.checkJourneyUrl("remove-uk-trading-name/1")
      registration.answerRadioButton("yes")

      And("the user selects yes on the add-uk-trading-name page")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.answerRadioButton("yes")

      And("the user adds the second trading name")
      registration.checkJourneyUrl("uk-trading-name/2")
      registration.enterAnswer("second cross schema name")

      And("the user selects no on the add-uk-trading-name page")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.answerRadioButton("no")

      And("the user provides answers until the next cross schema section")
      registration.checkJourneyUrl("already-made-sales")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("date-of-first-sale")
      registration.enterDate("yesterday")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("start-date")
      registration.continue()
      registration.checkJourneyUrl("tax-in-eu")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("online-marketplace")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("give-website-address")
      registration.answerRadioButton("no")

      Then("the contact details from the IOSS registration are provided")
      registration.checkJourneyUrl("business-contact-details")
      crossSchema.contactAndBankWarnings("contact", "current", "registration", true)

      And("the user amends the contact name")
      registration.updateField("fullName", "CrossSchema Full Name")
      registration.continue()
      email.completeEmailVerification("registration")

      Then("the bank details from the IOSS registration are provided")
      registration.checkJourneyUrl("bank-details")
      crossSchema.contactAndBankWarnings("bank", "current", "registration", true)

      And("the user amends the iban")
      registration.updateField("iban", "GB29NWBK60161331926819")
      registration.continue()

      When("the user submits the registration on the check-answers page")
      registration.checkJourneyUrl("check-answers")
      registration.submit()

      Then("the user is on the successful submission page")
      registration.checkJourneyUrl("successful")

      And("the user is shown the correct text on the confirmation page regarding updating existing registrations")
      crossSchema.confirmationText("current", true)
    }

    Scenario("Registration for trader with a previous IOSS registration - amends data") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(
        "100005555",
        "Organisation",
        "hasIOSSEnrolment",
        "crossSchemaPreviousIOSSRegistration"
      )
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

      Then("the user is shown their existing trading names from their IOSS registration")
      registration.checkJourneyUrl("add-uk-trading-name")
      crossSchema.tradingNamesDisplayed("previous")
      crossSchema.tradingNameWarnings("previous", "registration", true)

      And("the user amends the second trading name")
      registration.selectChangeOrRemoveLink("uk-trading-name\\/2")
      registration.checkJourneyUrl("uk-trading-name/2")
      registration.enterAnswer("an amended cross schema trading name")

      And("the user selects no on the add-uk-trading-name page")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.answerRadioButton("no")

      And("the user provides answers until the next cross schema section")
      registration.checkJourneyUrl("already-made-sales")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("date-of-first-sale")
      registration.enterDate("yesterday")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("start-date")
      registration.continue()
      registration.checkJourneyUrl("tax-in-eu")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("online-marketplace")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("give-website-address")
      registration.answerRadioButton("no")

      Then("the contact details from the IOSS registration are provided")
      registration.checkJourneyUrl("business-contact-details")
      crossSchema.contactAndBankWarnings("contact", "previous", "registration", true)

      And("the user amends contact details")
      registration.updateField("telephoneNumber", "+441234567890")
      registration.updateField("emailAddress", "email-new-cross-schema@test.com")
      registration.continue()
      email.completeEmailVerification("registration")

      Then("the bank details from the IOSS registration are provided")
      registration.checkJourneyUrl("bank-details")
      crossSchema.contactAndBankWarnings("bank", "previous", "registration", true)

      And("the user amends the bank details")
      registration.updateField("accountName", "Account Name CS")
      registration.continue()

      When("the user submits the registration on the check-answers page")
      registration.checkJourneyUrl("check-answers")
      registration.submit()

      Then("the user is on the successful submission page")
      registration.checkJourneyUrl("successful")

      And("the user is shown the correct text on the confirmation page regarding updating existing registrations")
      crossSchema.confirmationText("previous", true)
    }

    Scenario("Registration for trader with multiple IOSS registrations - amends data") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(
        "100005555",
        "Organisation",
        "hasIOSSEnrolment",
        "crossSchemaMultipleIOSSRegistrations"
      )
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

      Then("the user is shown their existing trading names from their IOSS registration")
      registration.checkJourneyUrl("add-uk-trading-name")
      crossSchema.tradingNamesDisplayed("multiple")
      crossSchema.tradingNameWarnings("multiple", "registration", true)

      And("the user adds another trading name")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("uk-trading-name/3")
      registration.enterAnswer("cross-schema name")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.answerRadioButton("no")

      And("the user provides answers until the next cross schema section")
      registration.checkJourneyUrl("already-made-sales")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("date-of-first-sale")
      registration.enterDate("yesterday")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("start-date")
      registration.continue()
      registration.checkJourneyUrl("tax-in-eu")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("online-marketplace")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("give-website-address")
      registration.answerRadioButton("no")

      Then("the contact details from the IOSS registration are provided")
      registration.checkJourneyUrl("business-contact-details")
      crossSchema.contactAndBankWarnings("contact", "multiple", "registration", true)

      And("the user amends contact details")
      registration.updateField("telephoneNumber", "123654448485656")
      registration.continue()
      email.completeEmailVerification("registration")

      Then("the bank details from the IOSS registration are provided")
      registration.checkJourneyUrl("bank-details")
      crossSchema.contactAndBankWarnings("bank", "multiple", "registration", true)

      And("the user amends the bank details")
      registration.updateField("iban", "GB29NWBK60161331926819")
      registration.continue()

      When("the user submits the registration on the check-answers page")
      registration.checkJourneyUrl("check-answers")
      registration.submit()

      Then("the user is on the successful submission page")
      registration.checkJourneyUrl("successful")

      And("the user is shown the correct text on the confirmation page regarding updating existing registrations")
      crossSchema.confirmationText("multiple", true)
    }

    Scenario("Amend registration for trader with a current IOSS registration - amends data") {

      Given("the user accesses the Amend Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("300000002", "Organisation", "hasOSSAndIOSSEnrolment", "amend")

      When("the user is on the change-your-registration page")
      registration.checkJourneyUrl("change-your-registration")

      Then("the user clicks change on trading name")
      registration.selectChangeOrRemoveLink(
        "amend-add-uk-trading-name"
      )

      Then("the user is shown their existing trading names from their IOSS registration")
      registration.checkJourneyUrl("amend-add-uk-trading-name")
      crossSchema.tradingNamesDisplayed("current")
      crossSchema.tradingNameWarnings("current", "amend", true)

      And("the user makes amendments")
      registration.selectChangeOrRemoveLink(
        "amend-uk-trading-name\\/2"
      )
      registration.checkJourneyUrl("amend-uk-trading-name/2")
      registration.enterAnswer("Trading name cross-schema two")
      registration.checkJourneyUrl("amend-add-uk-trading-name")
      registration.selectChangeOrRemoveLink(
        "amend-remove-uk-trading-name\\/1"
      )
      registration.checkJourneyUrl("amend-remove-uk-trading-name/1")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("amend-add-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("change-your-registration")

      Then("the user clicks change on contact details")
      registration.selectChangeOrRemoveLink(
        "amend-business-contact-details"
      )

      Then("the contact details from the IOSS registration are provided")
      registration.checkJourneyUrl("amend-business-contact-details")
      crossSchema.contactAndBankWarnings("contact", "current", "amend", true)

      And("the user updates some of their contact details")
      registration.updateField("fullName", "CS full-name")
      registration.updateField("emailAddress", "email-cs-test@test.com")
      registration.continue()
      email.completeEmailVerification("amend")
      registration.checkJourneyUrl("change-your-registration")

      When("the user clicks change on bank details")
      registration.selectChangeOrRemoveLink(
        "amend-bank-details"
      )

      Then("the bank details from the IOSS registration are provided")
      registration.checkJourneyUrl("amend-bank-details")
      crossSchema.contactAndBankWarnings("bank", "current", "amend", true)

      And("the user updates their bank details")
      registration.updateField("accountName", "CS Name")
      registration.updateField("bic", "ABCDDD2A")
      registration.updateField("iban", "GB33BUKB20201555555555555")
      registration.continue()
      registration.checkJourneyUrl("change-your-registration")

      And("the user can submit their amended registration")
      registration.submit()
      registration.checkJourneyUrl("successful-amend")

      And("the user is shown the correct text on the confirmation page regarding updating existing registrations")
      crossSchema.confirmationText("current", true)

      And("the correct amendments are displayed")
      crossSchema.amendments("current")
    }

    Scenario("Amend registration for trader with a previous IOSS registration - amends data") {

      Given("the user accesses the Amend Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(
        "300000002",
        "Organisation",
        "hasOSSAndIOSSEnrolment",
        "amendCrossSchemaPreviousIOSSRegistration"
      )

      When("the user is on the change-your-registration page")
      registration.checkJourneyUrl("change-your-registration")

      Then("the user clicks change on trading name")
      registration.selectChangeOrRemoveLink(
        "amend-add-uk-trading-name"
      )

      Then("the user is shown their existing trading names from their IOSS registration")
      registration.checkJourneyUrl("amend-add-uk-trading-name")
      crossSchema.tradingNamesDisplayed("previous")
      crossSchema.tradingNameWarnings("previous", "amend", true)

      And("the user makes amendments")
      registration.selectChangeOrRemoveLink(
        "amend-uk-trading-name\\/2"
      )
      registration.checkJourneyUrl("amend-uk-trading-name/2")
      registration.enterAnswer("Trading name cross-schema two")
      registration.checkJourneyUrl("amend-add-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("change-your-registration")

      Then("the user clicks change on contact details")
      registration.selectChangeOrRemoveLink(
        "amend-business-contact-details"
      )

      Then("the contact details from the IOSS registration are provided")
      registration.checkJourneyUrl("amend-business-contact-details")
      crossSchema.contactAndBankWarnings("contact", "previous", "amend", true)

      And("the user updates some of their contact details")
      registration.updateField("fullName", "CS full-name")
      registration.continue()
      email.completeEmailVerification("amend")
      registration.checkJourneyUrl("change-your-registration")

      When("the user clicks change on bank details")
      registration.selectChangeOrRemoveLink(
        "amend-bank-details"
      )

      Then("the bank details from the IOSS registration are provided")
      registration.checkJourneyUrl("amend-bank-details")
      crossSchema.contactAndBankWarnings("bank", "previous", "amend", true)

      And("the user updates their bank details")
      registration.updateField("iban", "GB29NWBK60161331926819")
      registration.continue()
      registration.checkJourneyUrl("change-your-registration")

      And("the user can submit their amended registration")
      registration.submit()
      registration.checkJourneyUrl("successful-amend")

      And("the user is shown the correct text on the confirmation page regarding updating existing registrations")
      crossSchema.confirmationText("previous", true)

      And("the correct amendments are displayed")
      crossSchema.amendments("previous")
    }

    Scenario("Amend registration for trader with multiple IOSS registrations - amends data") {

      Given("the user accesses the Amend Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(
        "300000002",
        "Organisation",
        "hasOSSAndIOSSEnrolment",
        "amendCrossSchemaMultipleIOSSRegistrations"
      )

      When("the user is on the change-your-registration page")
      registration.checkJourneyUrl("change-your-registration")

      Then("the user clicks change on trading name")
      registration.selectChangeOrRemoveLink(
        "amend-add-uk-trading-name"
      )

      Then("the user is shown their existing trading names from their IOSS registration")
      registration.checkJourneyUrl("amend-add-uk-trading-name")
      crossSchema.tradingNamesDisplayed("multiple")
      crossSchema.tradingNameWarnings("multiple", "amend", true)

      And("the user makes amendments")
      registration.selectChangeOrRemoveLink(
        "amend-remove-uk-trading-name\\/1"
      )
      registration.checkJourneyUrl("amend-remove-uk-trading-name/1")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("amend-add-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("change-your-registration")

      Then("the user clicks change on contact details")
      registration.selectChangeOrRemoveLink(
        "amend-business-contact-details"
      )

      Then("the contact details from the IOSS registration are provided")
      registration.checkJourneyUrl("amend-business-contact-details")
      crossSchema.contactAndBankWarnings("contact", "multiple", "amend", true)

      And("the user updates some of their contact details")
      registration.updateField("emailAddress", "email-cs-test@test.com")
      registration.continue()
      email.completeEmailVerification("amend")
      registration.checkJourneyUrl("change-your-registration")

      When("the user clicks change on bank details")
      registration.selectChangeOrRemoveLink(
        "amend-bank-details"
      )

      Then("the bank details from the IOSS registration are provided")
      registration.checkJourneyUrl("amend-bank-details")
      crossSchema.contactAndBankWarnings("bank", "multiple", "amend", true)

      And("the user updates their bank details")
      registration.updateField("accountName", "CS Name")
      registration.continue()
      registration.checkJourneyUrl("change-your-registration")

      And("the user can submit their amended registration")
      registration.submit()
      registration.checkJourneyUrl("successful-amend")

      And("the user is shown the correct text on the confirmation page regarding updating existing registrations")
      crossSchema.confirmationText("multiple", true)

      And("the correct amendments are displayed")
      crossSchema.amendments("multiple")
    }

    Scenario(
      "Rejoin registration for trader with a current IOSS registration - amends data"
    ) {

      Given("the user accesses the Rejoin Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("600000050", "Organisation", "hasOSSAndIOSSEnrolment", "rejoin")

      And("the user enters date of first sale information")
      registration.checkJourneyUrl("rejoin-already-made-sales")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-date-of-first-sale")
      registration.enterDate("today")
      registration.checkJourneyUrl("rejoin-start-date")
      commencementDate.checkCommencementDate("today")
      registration.continue()
      registration.checkJourneyUrl("rejoin-registration")

      Then("the user clicks amend for trading name details")
      registration.selectChangeOrRemoveLink("rejoin-amend-add-uk-trading-name")
      registration.checkJourneyUrl("rejoin-amend-add-uk-trading-name")

      Then("the user is shown their existing trading names from their IOSS registration")
      crossSchema.tradingNamesDisplayed("current")
      crossSchema.tradingNameWarnings("current", "rejoin", true)

      And("the user amends answers")
      registration.selectChangeOrRemoveLink("rejoin-amend-uk-trading-name\\/2")
      registration.checkJourneyUrl("rejoin-amend-uk-trading-name/2")
      registration.enterAnswer("Trading name cross-schema two")
      registration.checkJourneyUrl("rejoin-amend-add-uk-trading-name")
      registration.selectChangeOrRemoveLink("rejoin-amend-remove-uk-trading-name\\/1")
      registration.checkJourneyUrl("rejoin-amend-remove-uk-trading-name/1")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-amend-add-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("rejoin-registration")

      When("the user selects change for contact details")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-business-contact-details"
      )
      registration.checkJourneyUrl("rejoin-amend-business-contact-details")

      Then("the contact details from the IOSS registration are provided")
      crossSchema.contactAndBankWarnings("contact", "current", "rejoin", true)

      And("the user amends contact details")
      registration.updateField("fullName", "CS full-name")
      registration.updateField("emailAddress", "email-cs-test@test.com")
      registration.continue()
      email.completeEmailVerification("rejoin")
      registration.checkJourneyUrl("rejoin-registration")

      When("the user selects change for bank details")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-bank-details"
      )
      registration.checkJourneyUrl("rejoin-amend-bank-details")

      Then("the bank details from the IOSS registration are provided")
      crossSchema.contactAndBankWarnings("bank", "current", "rejoin", true)

      And("the user amends bank details")
      registration.updateField("accountName", "CS Name")
      registration.updateField("bic", "ABCDDD2A")
      registration.updateField("iban", "GB33BUKB20201555555555555")
      registration.continue()
      registration.checkJourneyUrl("rejoin-registration")

      And("the user can submit their registration successfully")
      registration.submit()
      registration.checkJourneyUrl("successful-rejoin")

      And("the user is shown the correct text on the confirmation page regarding updating existing registrations")
      crossSchema.confirmationText("current", true)
    }

    Scenario(
      "Rejoin registration for trader with a previous IOSS registration - amends data"
    ) {

      Given("the user accesses the Rejoin Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(
        "600000050",
        "Organisation",
        "hasOSSAndIOSSEnrolment",
        "rejoinCrossSchemaPreviousIOSSRegistration"
      )

      And("the user enters date of first sale information")
      registration.checkJourneyUrl("rejoin-already-made-sales")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-date-of-first-sale")
      registration.enterDate("today")
      registration.checkJourneyUrl("rejoin-start-date")
      commencementDate.checkCommencementDate("today")
      registration.continue()
      registration.checkJourneyUrl("rejoin-registration")

      Then("the user clicks amend for trading name details")
      registration.selectChangeOrRemoveLink("rejoin-amend-add-uk-trading-name")
      registration.checkJourneyUrl("rejoin-amend-add-uk-trading-name")

      Then("the user is shown their existing trading names from their IOSS registration")
      crossSchema.tradingNamesDisplayed("previous")
      crossSchema.tradingNameWarnings("previous", "rejoin", true)

      And("the user amends answers")
      registration.selectChangeOrRemoveLink("rejoin-amend-uk-trading-name\\/1")
      registration.checkJourneyUrl("rejoin-amend-uk-trading-name/1")
      registration.enterAnswer("Trading name cross-schema 1")
      registration.checkJourneyUrl("rejoin-amend-add-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("rejoin-registration")

      When("the user selects change for contact details")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-business-contact-details"
      )
      registration.checkJourneyUrl("rejoin-amend-business-contact-details")

      Then("the contact details from the IOSS registration are provided")
      crossSchema.contactAndBankWarnings("contact", "previous", "rejoin", true)

      And("the user amends contact details")
      registration.updateField("emailAddress", "email-cs-test@test.com")
      registration.continue()
      email.completeEmailVerification("rejoin")
      registration.checkJourneyUrl("rejoin-registration")

      When("the user selects change for bank details")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-bank-details"
      )
      registration.checkJourneyUrl("rejoin-amend-bank-details")

      Then("the bank details from the IOSS registration are provided")
      crossSchema.contactAndBankWarnings("bank", "previous", "rejoin", true)

      And("the user amends bank details")
      registration.updateField("bic", "ABCDDD2A")
      registration.continue()
      registration.checkJourneyUrl("rejoin-registration")

      And("the user can submit their registration successfully")
      registration.submit()
      registration.checkJourneyUrl("successful-rejoin")

      And("the user is shown the correct text on the confirmation page regarding updating existing registrations")
      crossSchema.confirmationText("previous", true)
    }

    Scenario(
      "Rejoin registration for trader with multiple IOSS registrations - amends data"
    ) {

      Given("the user accesses the Rejoin Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(
        "600000050",
        "Organisation",
        "hasOSSAndIOSSEnrolment",
        "rejoinCrossSchemaMultipleIOSSRegistrations"
      )

      And("the user enters date of first sale information")
      registration.checkJourneyUrl("rejoin-already-made-sales")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-date-of-first-sale")
      registration.enterDate("today")
      registration.checkJourneyUrl("rejoin-start-date")
      commencementDate.checkCommencementDate("today")
      registration.continue()
      registration.checkJourneyUrl("rejoin-registration")

      Then("the user clicks amend for trading name details")
      registration.selectChangeOrRemoveLink("rejoin-amend-add-uk-trading-name")
      registration.checkJourneyUrl("rejoin-amend-add-uk-trading-name")

      Then("the user is shown their existing trading names from their IOSS registration")
      crossSchema.tradingNamesDisplayed("multiple")
      crossSchema.tradingNameWarnings("multiple", "rejoin", true)

      And("the user amends answers")
      registration.selectChangeOrRemoveLink("rejoin-amend-remove-uk-trading-name\\/2")
      registration.checkJourneyUrl("rejoin-amend-remove-uk-trading-name/2")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-amend-add-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("rejoin-registration")

      When("the user selects change for contact details")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-business-contact-details"
      )
      registration.checkJourneyUrl("rejoin-amend-business-contact-details")

      Then("the contact details from the IOSS registration are provided")
      crossSchema.contactAndBankWarnings("contact", "multiple", "rejoin", true)

      And("the user amends contact details")
      registration.updateField("fullName", "CS full-name")
      registration.continue()
      email.completeEmailVerification("rejoin")
      registration.checkJourneyUrl("rejoin-registration")

      When("the user selects change for bank details")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-bank-details"
      )
      registration.checkJourneyUrl("rejoin-amend-bank-details")

      Then("the bank details from the IOSS registration are provided")
      crossSchema.contactAndBankWarnings("bank", "multiple", "rejoin", true)

      And("the user amends bank details")
      registration.updateField("accountName", "CS Name")
      registration.updateField("iban", "GB33BUKB20201555555555555")
      registration.continue()
      registration.checkJourneyUrl("rejoin-registration")

      And("the user can submit their registration successfully")
      registration.submit()
      registration.checkJourneyUrl("successful-rejoin")

      And("the user is shown the correct text on the confirmation page regarding updating existing registrations")
      crossSchema.confirmationText("multiple", true)
    }

    Scenario("Registration for trader with multiple IOSS registrations - does not amend data") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(
        "100005555",
        "Organisation",
        "hasIOSSEnrolment",
        "crossSchemaMultipleIOSSRegistrations"
      )
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

      Then("the user is shown their existing trading names from their IOSS registration")
      registration.checkJourneyUrl("add-uk-trading-name")
      crossSchema.tradingNamesDisplayed("multiple")
      crossSchema.tradingNameWarnings("multiple", "registration", true)
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.answerRadioButton("no")

      And("the user provides answers until the next cross schema section")
      registration.checkJourneyUrl("already-made-sales")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("date-of-first-sale")
      registration.enterDate("yesterday")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("start-date")
      registration.continue()
      registration.checkJourneyUrl("tax-in-eu")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("online-marketplace")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("give-website-address")
      registration.answerRadioButton("no")

      Then("the contact details from the IOSS registration are provided")
      registration.checkJourneyUrl("business-contact-details")
      crossSchema.contactAndBankWarnings("contact", "multiple", "registration", true)
      registration.continue()
      email.completeEmailVerification("registration")

      Then("the bank details from the IOSS registration are provided")
      registration.checkJourneyUrl("bank-details")
      crossSchema.contactAndBankWarnings("bank", "multiple", "registration", true)
      registration.continue()

      When("the user submits the registration on the check-answers page")
      registration.checkJourneyUrl("check-answers")
      registration.submit()

      Then("the user is on the successful submission page")
      registration.checkJourneyUrl("successful")

      And("the user is shown the correct text on the confirmation page regarding updating existing registrations")
      crossSchema.confirmationText("multiple", false)
    }

    Scenario("Amend registration for trader with multiple IOSS registrations - does not amend data") {

      Given("the user accesses the Amend Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(
        "300000002",
        "Organisation",
        "hasOSSAndIOSSEnrolment",
        "amendCrossSchemaMultipleIOSSRegistrations"
      )

      When("the user is on the change-your-registration page")
      registration.checkJourneyUrl("change-your-registration")

      And("the user can submit their registration")
      registration.submit()
      registration.checkJourneyUrl("successful-amend")

      And("the user is shown the correct text on the confirmation page regarding updating existing registrations")
      crossSchema.confirmationText("multiple", false)

      And("the correct amendments are displayed")
      crossSchema.amendments("no")
    }

    Scenario(
      "Rejoin registration for trader with multiple IOSS registrations - does not amend data"
    ) {

      Given("the user accesses the Rejoin Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(
        "600000050",
        "Organisation",
        "hasOSSAndIOSSEnrolment",
        "rejoinCrossSchemaMultipleIOSSRegistrations"
      )

      And("the user enters date of first sale information")
      registration.checkJourneyUrl("rejoin-already-made-sales")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("rejoin-date-of-first-sale")
      registration.enterDate("today")
      registration.checkJourneyUrl("rejoin-start-date")
      commencementDate.checkCommencementDate("today")
      registration.continue()
      registration.checkJourneyUrl("rejoin-registration")

      And("the user can submit their registration successfully")
      registration.submit()
      registration.checkJourneyUrl("successful-rejoin")

      And("the user is shown the correct text on the confirmation page regarding updating existing registrations")
      crossSchema.confirmationText("multiple", false)
    }

    Scenario("Registration for trader with no other registrations - amends data") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("100000001", "Organisation", "vatOnly", "registration")
      registration.checkJourneyUrl("already-eu-registered")

      When("the user answers questions up to trading names")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("sell-from-northern-ireland")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("northern-ireland-business")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("business-pay")
      registration.continue()
      registration.checkJourneyUrl("confirm-vat-details")
      registration.answerVatDetailsChoice("Yes")

      And("the user adds one trading name")
      registration.checkJourneyUrl("have-uk-trading-name")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("uk-trading-name/1")
      registration.enterAnswer("first trading name")

      And("the correct number of trading names have been added")
      crossSchema.oneTradingName()
      crossSchema.tradingNameWarnings("no", "registration", false)

      And("the user selects no on the add-uk-trading-name page and continues until next cross schema section")
      registration.checkJourneyUrl("add-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("already-made-sales")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("date-of-first-sale")
      registration.enterDate("yesterday")
      registration.checkJourneyUrl("previous-oss")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("start-date")
      registration.continue()
      registration.checkJourneyUrl("tax-in-eu")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("online-marketplace")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("give-website-address")
      registration.answerRadioButton("no")

      And("there are no warnings on the contact details page")
      registration.checkJourneyUrl("business-contact-details")
      crossSchema.contactAndBankWarnings("contact", "no", "registration", false)
      registration.fillContactDetails("Joe Bloggs", "01234567890", "email@test.com")
      email.completeEmailVerification("registration")

      Then("there are no warnings on the bank details page")
      registration.checkJourneyUrl("bank-details")
      crossSchema.contactAndBankWarnings("bank", "no", "registration", false)
      registration.fillBankAccountDetails("Account Name", "SMCOGB2LXXM", "GB29NWBK60161331926819")

      When("the user submits the registration on the check-answers page")
      registration.checkJourneyUrl("check-answers")
      registration.submit()

      Then("the user is on the successful submission page")
      registration.checkJourneyUrl("successful")

      And("the user is shown the correct text on the confirmation page regarding updating existing registrations")
      crossSchema.confirmationText("current", false)
    }

    Scenario("Amend registration for trader with no other registrations - amends data") {

      Given("the user accesses the Amend Registration journey within the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("300000002", "Organisation", "hasOSSEnrolment", "amendFull")

      And("the user is on the change-your-registration page")
      registration.checkJourneyUrl("change-your-registration")

      When("the user selects the change link for add uk trading name")
      registration.selectChangeOrRemoveLink(
        "amend-add-uk-trading-name"
      )

      Then("there are no warnings displayed")
      registration.checkJourneyUrl("amend-add-uk-trading-name")
      crossSchema.tradingNamesDisplayed("no")
      crossSchema.tradingNameWarnings("no", "amend", false)
      registration.selectChangeOrRemoveLink("amend-uk-trading-name\\/2")
      registration.checkJourneyUrl("amend-uk-trading-name/2")
      registration.enterAnswer("Trading name cross-schema two")
      registration.checkJourneyUrl("amend-add-uk-trading-name")
      registration.selectChangeOrRemoveLink("amend-remove-uk-trading-name\\/1")
      registration.checkJourneyUrl("amend-remove-uk-trading-name/1")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("amend-add-uk-trading-name")
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("change-your-registration")

      When("the user selects the change link for contact details")
      registration.selectChangeOrRemoveLink(
        "amend-business-contact-details"
      )

      Then("there are no warnings displayed")
      registration.checkJourneyUrl("amend-business-contact-details")
      crossSchema.contactAndBankWarnings("contact", "no", "amend", false)
      registration.updateField("fullName", "CS full-name")
      registration.updateField("emailAddress", "email-cs-test@test.com")
      registration.continue()
      email.completeEmailVerification("amend")
      registration.checkJourneyUrl("change-your-registration")

      When("the user selects the change link for bank details")
      registration.selectChangeOrRemoveLink(
        "amend-bank-details"
      )

      Then("there are no warnings displayed")
      registration.checkJourneyUrl("amend-bank-details")
      crossSchema.contactAndBankWarnings("bank", "no", "amend", false)
      registration.updateField("accountName", "CS Name")
      registration.updateField("bic", "ABCDDD2A")
      registration.updateField("iban", "GB33BUKB20201555555555555")
      registration.continue()
      registration.checkJourneyUrl("change-your-registration")

      And("the user can submit their amended registration")
      registration.submit()
      registration.checkJourneyUrl("successful-amend")

      And("the user is shown the correct text on the confirmation page regarding updating existing registrations")
      crossSchema.confirmationText("no", false)

      And("the correct amendments are displayed")
      crossSchema.amendments("noRegistration")
    }

    Scenario(
      "Rejoin registration for trader with no other registrations - amends data"
    ) {

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

      Then("the user clicks amend for trading name details")
      registration.selectChangeOrRemoveLink("rejoin-amend-add-uk-trading-name")
      registration.checkJourneyUrl("rejoin-amend-add-uk-trading-name")

      Then("no warnings are displayed")
      crossSchema.tradingNamesDisplayed("no")
      crossSchema.tradingNameWarnings("no", "rejoin", false)
      registration.answerRadioButton("no")
      registration.checkJourneyUrl("rejoin-registration")

      When("the user selects change for contact details")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-business-contact-details"
      )
      registration.checkJourneyUrl("rejoin-amend-business-contact-details")

      Then("no warnings are displayed")
      crossSchema.contactAndBankWarnings("contact", "current", "rejoin", false)
      registration.updateField("emailAddress", "email-cs-test@test.com")
      registration.continue()
      email.completeEmailVerification("rejoin")
      registration.checkJourneyUrl("rejoin-registration")

      When("the user selects change for bank details")
      registration.selectChangeOrRemoveLink(
        "rejoin-amend-bank-details"
      )
      registration.checkJourneyUrl("rejoin-amend-bank-details")

      Then("no warnings are displayed")
      crossSchema.contactAndBankWarnings("bank", "current", "rejoin", false)
      registration.updateField("bic", "ABCDDD2A")
      registration.continue()
      registration.checkJourneyUrl("rejoin-registration")

      And("the user can submit their registration successfully")
      registration.submit()
      registration.checkJourneyUrl("successful-rejoin")

      And("the user is shown the correct text on the confirmation page regarding updating existing registrations")
      crossSchema.confirmationText("no", false)
    }
  }
}
