/*
 * Copyright 2021 HM Revenue & Customs
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

import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.driver.BrowserDriver
import uk.gov.hmrc.test.ui.pages.CommonPage.{checkUrl, clickContinue, selectAnswer}

object PreAuthPage extends BrowserDriver {

  val oneStopShopRegistrationUrl: String = TestConfiguration.url("one-stop-shop-registration-frontend")

  def goToOneStopShopRegistrationPage(): PreAuthPage.type = {
    driver.navigate().to(oneStopShopRegistrationUrl)
    checkUrl("already-eu-registered")
    PreAuthPage
  }

  def businessNotRegisteredInEuForOneStopShop(): PreAuthPage.type = {
    selectAnswer("no")
    PreAuthPage
  }

  def sellsFromNorthernIrelandToEu(): PreAuthPage.type = {
    selectAnswer("yes")
    PreAuthPage
  }

  def businessInNorthernIreland(): PreAuthPage.type = {
    selectAnswer("yes")
    PreAuthPage
  }

  def continueToReportAndPayVatOnSales(): PreAuthPage.type = {
    clickContinue()
    PreAuthPage
  }

  def alreadyMadeSales(): PreAuthPage.type = {
    selectAnswer("yes")
    PreAuthPage
  }

}
