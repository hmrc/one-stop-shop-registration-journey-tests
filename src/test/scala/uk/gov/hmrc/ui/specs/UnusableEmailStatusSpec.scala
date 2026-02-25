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

class UnusableEmailStatusSpec extends BaseSpec {

  private val registration = Registration
  private val auth         = Auth
  private val email = EmailVerification

  Feature("Unusable Email Status Scenarios") {

    Scenario(
      "Intercept page for when a traders email address has unusable status"
    ) {

      Given("the user accesses their OSS returns dashboard")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("333333888", "Organisation", "hasOSSEnrolment", "dashboard")

      When("the user is shown the email intercept page and clicks continue")
      registration.checkDashboardJourneyUrl("intercept-unusable-email")
      registration.continue()

      Then("the user is redirected to the business-contact-details page within the OSS registration service")
      registration.checkJourneyUrl("amend-business-contact-details")

      And("the user updates their email address")
      registration.updateField("emailAddress", "different-email@test.com")
      registration.continue()
      email.completeEmailVerification("amend")

      And("the user can submit their amended registration")
      registration.checkJourneyUrl("change-your-registration")
      registration.submit()
      registration.checkJourneyUrl("successful-amend")

      And("the correct answers are displayed as amended on the confirmation page")
      registration.checkAmendedAnswers("email")
    }

    Scenario(
      "The user does not amend the email address following the intercept page for unusable status"
    ) {

      Given("the user accesses their OSS returns dashboard")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("333333888", "Organisation", "hasOSSEnrolment", "dashboard")

      When("the user is shown the email intercept page and clicks continue")
      registration.checkDashboardJourneyUrl("intercept-unusable-email")
      registration.continue()

      Then("the user is redirected to the business-contact-details page within the OSS registration service")
      registration.checkJourneyUrl("amend-business-contact-details")

      And("the user does not update their email address")
      registration.continue()
      email.completeEmailVerification("amend")

      And("the user can submit their amended registration")
      registration.checkJourneyUrl("change-your-registration")
      registration.submit()
      registration.checkJourneyUrl("successful-amend")

      And("the confirmation page shows no amended answers")
      registration.checkAmendedAnswers("noAmendments")
    }
  }
}
