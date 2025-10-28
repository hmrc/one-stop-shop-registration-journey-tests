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

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import uk.gov.hmrc.selenium.component.PageObject
import uk.gov.hmrc.test.ui.pages.AuthPage.fluentWait

object AuthActions extends PageObject {

  def loginUsingAuthorityWizard(
    user: String,
    affinityGroup: String,
    vrn: String,
    iossNumber: Option[String],
    withOssEnrolment: Boolean,
    journey: String
  ): Unit = {

    val url = journey match {
      case "registration" =>
        "http://localhost:10200/pay-vat-on-goods-sold-to-eu/northern-ireland-register/already-eu-registered"
      case "amend"        => "http://localhost:10200/pay-vat-on-goods-sold-to-eu/northern-ireland-register/start-amend-journey"
      case "rejoin"       =>
        "http://localhost:10200/pay-vat-on-goods-sold-to-eu/northern-ireland-register/start-rejoin-journey"
      case "returns"      =>
        "http://localhost:10204/pay-vat-on-goods-sold-to-eu/northern-ireland-returns-payments/your-account"
    }

    sendKeys(By.id("redirectionUrl"), url)

    selectByValue(By.id("affinityGroupSelect"), affinityGroup)

    sendKeys(By.id("enrolment[0].name"), "HMRC-MTD-VAT")
    sendKeys(By.id("input-0-0-name"), "VRN")
    sendKeys(By.id("input-0-0-value"), vrn)
    if (withOssEnrolment) {
      sendKeys(By.id("enrolment[1].name"), "HMRC-OSS-ORG")
      sendKeys(By.id("input-1-0-name"), "VRN")
      sendKeys(By.id("input-1-0-value"), vrn)
      if (iossNumber.nonEmpty) {
        sendKeys(By.id("enrolment[2].name"), "HMRC-IOSS-ORG")
        sendKeys(By.id("input-2-0-name"), "IOSSNumber")
        sendKeys(By.id("input-2-0-value"), iossNumber.get)
        if (iossNumber.get == "IM9007231111") {
          sendKeys(By.id("enrolment[3].name"), "HMRC-IOSS-ORG")
          sendKeys(By.id("input-3-0-name"), "IOSSNumber")
          sendKeys(By.id("input-3-0-value"), "IM9006231111")
        }
      }
    }

    if (!withOssEnrolment && iossNumber.nonEmpty) {
      sendKeys(By.id("enrolment[1].name"), "HMRC-IOSS-ORG")
      sendKeys(By.id("input-1-0-name"), "IOSSNumber")
      sendKeys(By.id("input-1-0-value"), iossNumber.get)
      if (iossNumber.get == "IM9007231111") {
        sendKeys(By.id("enrolment[2].name"), "HMRC-IOSS-ORG")
        sendKeys(By.id("input-2-0-name"), "IOSSNumber")
        sendKeys(By.id("input-2-0-value"), "IM9006231111")
      }
    }

    click(By.cssSelector("Input[value='Submit']"))

  }

  def loginUsingScpStub(affinityGroup: String, vrn: String): Unit = {

    fluentWait.until(ExpectedConditions.urlContains("http://localhost:9597/bas-stub/login"))

    click(By.partialLinkText("Register SCP User"))

    fluentWait.until(ExpectedConditions.urlContains("http://localhost:9597/bas-stub/register"))

    selectByValue(By.id("accountType"), affinityGroup)

    click(By.id("isAdmin"))
    sendKeys(By.id("groupProfile"), "123")

    sendKeys(By.id("enrolment[0].name"), "HMRC-MTD-VAT")
    sendKeys(By.id("enrolment[0].identifier"), "VRN")
    sendKeys(By.id("enrolment[0].value"), vrn)

    click(By.className("submit"))
  }

  def selectMfaSuccess(): Unit = {
    fluentWait.until(ExpectedConditions.urlContains("http://localhost:9597/bas-stub/required-mfa-register"))
    click(By.id("mfaOutcome"))
    click(By.className("submit"))
  }
}
