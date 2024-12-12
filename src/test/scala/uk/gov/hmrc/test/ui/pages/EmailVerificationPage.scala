/*
 * Copyright 2024 HM Revenue & Customs
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

import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.test.ui.driver.BrowserDriver

object EmailVerificationPage extends BrowserDriver with Matchers {

  def goToEmailVerificationUrl(journeyId: String): Unit =
    driver
      .navigate()
      .to(
        s"http://localhost:9890/email-verification/journey/$journeyId/passcode?continueUrl=/pay-vat-on-goods-sold-to-eu/northern-ireland-register/bank-details&origin=OSS&service=one-stop-shop-registration-frontend"
      )

  def goToEmailVerificationPasscodeGeneratorUrl(): Unit =
    driver.navigate
      .to("http://localhost:10200/pay-vat-on-goods-sold-to-eu/northern-ireland-register/test-only/get-passcodes")

}
