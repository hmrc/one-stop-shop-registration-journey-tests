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

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import uk.gov.hmrc.test.ui.pages._

import java.time.format.DateTimeFormatter

class AuthStepDef extends BaseStepDef {

  val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy")

  Given("""the user accesses the stub url""") { () =>
    AuthPage.goToStartOfJourneyFromStub()
  }

  Given("^the user signs in as an Organisation Admin with VAT enrolment (.*) and strong credentials$") {
    (vrn: String) =>
      AuthActions.loginUsingScpStub("Organisation", vrn)
      AuthActions.selectMfaSuccess()
  }

  Given(
    "^the user signs in as an Organisation Admin with Hmrc Mdt and OSS VAT enrolment (.*) and strong credentials$"
  ) { (vrn: String) =>
    AuthActions.loginUsingAuthorityWizard("user", "Organisation", vrn, None, withOssEnrolment = true, "registration")
  }

  When("""^a (non-registered|registered) user with VRN (.*) accesses the (amend|rejoin) registration journey""") {
    (registrationStatus: String, vrn: String, journey: String) =>
      AuthPage.goToStartOfJourneyFromStub()
      var withOssEnrolment = true
      if (registrationStatus == "non-registered") {
        withOssEnrolment = false
      }
      AuthActions.loginUsingAuthorityWizard("user", "Organisation", vrn, None, withOssEnrolment, journey)
  }

  When("""^a registered user with VRN (.*) accesses the returns service""") { (vrn: String) =>
    AuthPage.goToStartOfJourneyFromStub()
    AuthActions.loginUsingAuthorityWizard("user", "Organisation", vrn, None, true, "returns")
  }

  Given(
    "^the IOSS registered user signs into OSS (registration|amend|rejoin) with IOSS number (.*) and VRN (.*)$"
  ) { (journey: String, iossNumber: String, vrn: String) =>
    val withOssEnrolment = if (journey == "registration") {
      false
    } else {
      true
    }
    AuthActions.loginUsingAuthorityWizard("user", "Organisation", vrn, Some(iossNumber), withOssEnrolment, journey)
  }

  Given(
    "^the (user) signs in as an Organisation Admin with Hmrc Mdt VAT enrolment (.*) and strong credentials via authwiz$"
  ) { (user: String, vrn: String) =>
    AuthActions.loginUsingAuthorityWizard(user, "Organisation", vrn, None, withOssEnrolment = false, "registration")
  }

}
