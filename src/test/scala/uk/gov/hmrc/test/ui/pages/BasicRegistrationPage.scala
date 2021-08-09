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

import org.openqa.selenium.By
import org.scalatestplus.selenium.Chrome.textField
import uk.gov.hmrc.test.ui.driver.BrowserDriver

import scala.jdk.CollectionConverters.asScalaBufferConverter

object BasicRegistrationPage extends BrowserDriver {

  def registerForOneStopShop(): BasicRegistrationPage.type = {
    CommonPage.checkUrl("confirm-vat-details")
    CheckVatDetailsPage.selectChoice("Yes")
    CommonPage.clickContinue()
    this
  }

  def doesNotHaveDifferentTradingName: BasicRegistrationPage.type = {
    CommonPage.selectAnswer("no")
    this
  }

  def withFirstSaleDate(day: String, month: String, year: String): BasicRegistrationPage.type = {
    CommonPage.enterDate(day, month, year)
    CommonPage.clickContinue()
    this
  }

  def confirmsSaleStartDate(): BasicRegistrationPage.type = {
    CommonPage.clickContinue()
    this
  }

  def businessNotRegisteredForTaxInEu(): BasicRegistrationPage.type = {
    CommonPage.selectAnswer("no")
    this
  }

  def businessNotDeregistered(): BasicRegistrationPage.type = {
    CommonPage.selectAnswer("no")
    this
  }

  def doesNotHaveAnOnlineMarketPlace(): BasicRegistrationPage.type = {
    CommonPage.selectAnswer("no")
    this
  }

  def doesNotAddWebsiteAddress(): BusinessContactDetailsPage.type = {
    CommonPage.selectAnswer("no")
    BusinessContactDetailsPage
  }
}
