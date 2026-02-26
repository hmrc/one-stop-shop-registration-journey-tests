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

class MissingVatInfoSpec extends BaseSpec {

  private val registration = Registration
  private val auth         = Auth

  Feature("Missing VAT Info journey") {

    Scenario("Missing Customer Vat Info from UK VAT details") {

      Given("the user accesses the OSS Registration Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("700000001", "Organisation", "vatOnly", "registration")
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

      And("the user is on the registration-service-error page")
      registration.checkJourneyUrl("registration-service-error")
    }
  }
}
