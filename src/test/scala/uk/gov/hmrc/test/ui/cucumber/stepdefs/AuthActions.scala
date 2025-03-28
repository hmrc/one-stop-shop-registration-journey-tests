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

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.Select
import uk.gov.hmrc.test.ui.driver.BrowserDriver

object AuthActions extends BrowserDriver {

  def loginUsingAuthorityWizard(
    user: String,
    affinityGroup: String,
    vrn: String,
    iossNumber: Option[String],
    withOssEnrolment: Boolean,
    journey: String
  ): Unit = {
    driver.findElement(By.id("redirectionUrl")).clear()

    val url = journey match {
      case "registration" =>
        "http://localhost:10200/pay-vat-on-goods-sold-to-eu/northern-ireland-register/already-eu-registered"
      case "amend"        => "http://localhost:10200/pay-vat-on-goods-sold-to-eu/northern-ireland-register/start-amend-journey"
      case "rejoin"       =>
        "http://localhost:10200/pay-vat-on-goods-sold-to-eu/northern-ireland-register/start-rejoin-journey"
      case "returns"      =>
        "http://localhost:10204/pay-vat-on-goods-sold-to-eu/northern-ireland-returns-payments/your-account"
    }

    driver.findElement(By.id("redirectionUrl")).sendKeys(url)
    val selectCredentialStrength = new Select(driver.findElement(By.id("credentialStrength")))
    selectCredentialStrength.selectByValue("strong")
    val selectAffinityGroup      = new Select(driver.findElement(By.id("affinityGroupSelect")))
    selectAffinityGroup.selectByValue("Organisation")

    if (user == "assistant") {
      val selectCredentialRole = new Select(driver.findElement(By.id("credential-role-select")))
      selectCredentialRole.selectByValue("Assistant")
    }

    driver.findElement(By.id("enrolment[0].name")).sendKeys("HMRC-MTD-VAT")
    driver
      .findElement(By.id("input-0-0-name"))
      .sendKeys("VRN")
    driver
      .findElement(By.id("input-0-0-value"))
      .sendKeys(vrn)
    if (withOssEnrolment) {
      driver.findElement(By.id("enrolment[1].name")).sendKeys("HMRC-OSS-ORG")
      driver
        .findElement(By.id("input-1-0-name"))
        .sendKeys("VRN")
      driver
        .findElement(By.id("input-1-0-value"))
        .sendKeys(vrn)
      if (iossNumber.nonEmpty) {
        driver.findElement(By.id("enrolment[2].name")).sendKeys("HMRC-IOSS-ORG")
        driver
          .findElement(By.id("input-2-0-name"))
          .sendKeys("IOSSNumber")
        driver
          .findElement(By.id("input-2-0-value"))
          .sendKeys(iossNumber.get)
        if (iossNumber.get == "IM9007231111") {
          driver.findElement(By.id("enrolment[3].name")).sendKeys("HMRC-IOSS-ORG")
          driver
            .findElement(By.id("input-3-0-name"))
            .sendKeys("IOSSNumber")
          driver
            .findElement(By.id("input-3-0-value"))
            .sendKeys("IM9006231111")
        }
      }
    }

    if (!withOssEnrolment && iossNumber.nonEmpty) {
      driver.findElement(By.id("enrolment[1].name")).sendKeys("HMRC-IOSS-ORG")
      driver
        .findElement(By.id("input-1-0-name"))
        .sendKeys("IOSSNumber")
      driver
        .findElement(By.id("input-1-0-value"))
        .sendKeys(iossNumber.get)
      if (iossNumber.get == "IM9007231111") {
        driver.findElement(By.id("enrolment[2].name")).sendKeys("HMRC-IOSS-ORG")
        driver
          .findElement(By.id("input-2-0-name"))
          .sendKeys("IOSSNumber")
        driver
          .findElement(By.id("input-2-0-value"))
          .sendKeys("IM9006231111")
      }
    }

    driver.findElement(By.cssSelector("Input[value='Submit']")).click()

  }

  def loginUsingScpStub(affinityGroup: String, vrn: String): Unit = {

    driver.findElement(By.partialLinkText("Register SCP User")).click()
    val selectAccountType = new Select(driver.findElement(By.id("accountType")))
    selectAccountType.selectByValue(affinityGroup)

    driver.findElement(By.id("isAdmin")).click()
    driver.findElement(By.id("groupProfile")).sendKeys("123")

    driver.findElement(By.id("enrolment[0].name")).sendKeys("HMRC-MTD-VAT")
    driver.findElement(By.id("enrolment[0].identifier")).sendKeys("VRN")
    driver.findElement(By.id("enrolment[0].value")).sendKeys(vrn)

    driver.findElement(By.className("submit")).click()
  }

  def selectMfaSuccess(): Unit = {
    driver.findElement(By.id("mfaOutcome")).click()
    driver.findElement(By.className("submit")).click()
  }
}
