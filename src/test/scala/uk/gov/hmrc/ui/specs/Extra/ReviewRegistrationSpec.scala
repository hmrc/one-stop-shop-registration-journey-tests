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

class ReviewRegistrationSpec extends BaseSpec {

  private val registration = Registration
  private val auth         = Auth

  Feature("Review registration scenarios") {

    Scenario(
      "Review registration when registration has not been updated for 2 years - no amendments"
    ) {

      Given("the user accesses their OSS returns dashboard")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("323232323", "Organisation", "hasOSSEnrolment", "dashboard")

      When("the user starts a return")
      registration.checkDashboardJourneyUrl("your-account")
      registration.clickLink("start-your-return")
      registration.checkDashboardJourneyUrl("2023-Q2/start")
      registration.answerRadioButton("yes")

      Then("the user is shown the review registration intercept page")
      registration.checkDashboardJourneyUrl("2023-Q2/review-registration")

      And("the user clicks on the Review your registration details link")
      registration.selectLinkCss("start-amend-journey")

      And("the user is redirected to the registration service to review their registration")
      registration.checkJourneyUrl("change-your-registration")
      registration.checkAmendHeading("review")

      And("the user can submit their registration without amending any details")
      registration.noAmendmentsReview()
      registration.submit()
      registration.checkJourneyUrl("successful-amend")

      And("the confirmation page shows no amendments were made")
      registration.checkAmendedAnswers("noAmendments")
    }

    Scenario(
      "Review registration when registration has not been updated for 2 years - with amendments"
    ) {

      Given("the user accesses their OSS returns dashboard")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("323232323", "Organisation", "hasOSSEnrolment", "dashboard")

      When("the user starts a return")
      registration.checkDashboardJourneyUrl("your-account")
      registration.clickLink("start-your-return")
      registration.checkDashboardJourneyUrl("2023-Q2/start")
      registration.answerRadioButton("yes")

      Then("the user is shown the review registration intercept page")
      registration.checkDashboardJourneyUrl("2023-Q2/review-registration")

      And("the user clicks on the Review your registration details link")
      registration.selectLinkCss("start-amend-journey")

      And("the user is redirected to the registration service to review their registration")
      registration.checkJourneyUrl("change-your-registration")
      registration.checkAmendHeading("review")

      And("the user removes trading names")
      registration.selectChangeOrRemoveLink(
        "amend-have-no-other-uk-trading-names"
      )
      registration.checkJourneyUrl("amend-have-no-other-uk-trading-names")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("amend-remove-all-trading-names")
      registration.answerRadioButton("yes")
      registration.checkJourneyUrl("change-your-registration")

      And("the user can submit their registration with their amended details")
      registration.submit()
      registration.checkJourneyUrl("successful-amend")

      And("the confirmation page shows the amendments made")
      registration.checkAmendedAnswers("tradingNames")
    }
  }
}
