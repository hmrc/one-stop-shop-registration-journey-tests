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

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.support.ui.ExpectedConditions
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.selenium.component.PageObject
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.pages.AuthPage.fluentWait

object EmailVerificationPage extends PageObject with Matchers {

  def goToEmailVerificationUrl(journeyId: String): Unit = {

    val emailVerificationUrl =
      s"http://localhost:9890/email-verification/journey/$journeyId/passcode?continueUrl=/pay-vat-on-goods-sold-to-eu/northern-ireland-register/bank-details&origin=OSS&service=one-stop-shop-registration-frontend"
    get(emailVerificationUrl)

    fluentWait.until(ExpectedConditions.urlContains(emailVerificationUrl))
  }

  def goToEmailVerificationPasscodeGeneratorUrl(): Unit = {
    val testOnlyUrl =
      "http://localhost:10200/pay-vat-on-goods-sold-to-eu/northern-ireland-register/test-only/get-passcodes"

    get(testOnlyUrl)

    fluentWait.until(ExpectedConditions.urlContains(testOnlyUrl))
  }

  def checkInterceptPage(): Unit =
    getCurrentUrl should startWith(
      TestConfiguration.url("one-stop-shop-returns-frontend") + "/intercept-unusable-email"
    )

  def checkBusinessContactDetails(): Unit =
    getCurrentUrl should startWith(
      TestConfiguration.url(
        "one-stop-shop-registration-frontend"
      ) + "/amend-business-contact-details"
    )

}
