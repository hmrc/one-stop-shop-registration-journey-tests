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

class SaveForLaterKickoutsSpec extends BaseSpec {

  private val registration = Registration
  private val auth         = Auth

  Feature("Saved Registrations that are no longer eligible for One Stop Shop") {

    Scenario("VRN has expired since saving their OSS Registration") {

      Given("the user accesses their saved registration")
      auth.goToAuthorityWizard()

      When("their VRN has now expired")
      auth.loginUsingAuthorityWizard("600000008", "Organisation", "vatOnly", "savedPreviously")

      Then("the user is redirected to the revalidate-vrn-expired page")
      registration.checkJourneyUrl("revalidate-vrn-expired")
    }

    Scenario("VRN is now active on OSS in another country since saving their OSS Registration") {

      Given("the user accesses their saved registration")
      auth.goToAuthorityWizard()

      When("their VRN has now been registered on OSS in another country")
      auth.loginUsingAuthorityWizard("333333311", "Organisation", "vatOnly", "savedPreviously")

      Then("the user is redirected to the revalidate-already-registered page")
      registration.checkJourneyUrl("revalidate-already-registered")
    }

    Scenario("VRN is now quarantined on OSS in another country since saving their OSS Registration") {

      Given("the user accesses their saved registration")
      auth.goToAuthorityWizard()

      When("their VRN has now been quarantined on OSS in another country")
      auth.loginUsingAuthorityWizard("333333322", "Organisation", "vatOnly", "savedPreviously")

      Then("the user is redirected to the revalidate-quarantined-trader page")
      registration.checkJourneyUrl("revalidate-quarantined-trader")
    }

    Scenario("EU VRN added to Saved OSS Registration is now active in another country") {

      Given("the user accesses their saved registration")
      auth.goToAuthorityWizard()

      When("the EU VRN used in the registration data is now active on OSS in another country")
      auth.loginUsingAuthorityWizard("100000101", "Organisation", "vatOnly", "savedPreviously")

      Then("the user is redirected to the revalidate-already-registered page")
      registration.checkJourneyUrl("revalidate-already-registered")
    }

    Scenario("EU VRN added to Saved OSS Registration is now quarantined in another country") {

      Given("the user accesses their saved registration")
      auth.goToAuthorityWizard()

      When("the EU VRN used in the registration data is now quarantined on OSS in another country")
      auth.loginUsingAuthorityWizard("100000102", "Organisation", "vatOnly", "savedPreviously")

      Then("the user is redirected to the revalidate-quarantined-trader page")
      registration.checkJourneyUrl("revalidate-quarantined-trader")
    }
  }
}
