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

package uk.gov.hmrc.ui.pages

import org.junit.Assert
import org.openqa.selenium.By
import uk.gov.hmrc.selenium.webdriver.Driver

object CrossSchema extends BasePage {

  def tradingNamesDisplayed(version: String): Unit = {
    val header = Driver.instance.findElement(By.tagName("h1")).getText
    if (version == "no") {
      Assert.assertTrue(header.equals("You have added 2 UK trading names"))
    } else {
      Assert.assertTrue(header.equals("You have 2 UK trading names from your Import One Stop Shop registration"))
    }
  }

  def hintTextAndWarnings(version: String, journey: String, displayed: Boolean): Unit = {
    val htmlBody    = Driver.instance.findElement(By.tagName("body")).getText
    val hintText    =
      "We have added the details you entered for a previous One Stop Shop scheme. Check they are still correct."
    val warningText =
      s"Changes you make here will also update the $version in any One Stop Shop accounts you registered for."

    if (!displayed) {
      Assert.assertFalse(htmlBody.contains(hintText))
      Assert.assertFalse(htmlBody.contains(warningText))
    } else {
      if (journey == "registration") {
        Assert.assertTrue(htmlBody.contains(hintText))
      }
      Assert.assertTrue(htmlBody.contains(warningText))
    }
  }

  def confirmationText(displayed: Boolean): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText

    val iossConfirmationText = "We've also updated any One Stop Shop registrations you have."

    if (!displayed) {
      Assert.assertFalse(htmlBody.contains(iossConfirmationText))
    } else {
      Assert.assertTrue(htmlBody.contains(iossConfirmationText))
    }
  }

  def amendments(version: String): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText

    if (version == "current" || version == "noRegistration") {
      Assert.assertTrue(htmlBody.contains("You changed the following details:"))
      Assert.assertTrue(htmlBody.contains("Trading names added Trading name cross-schema two"))
      Assert.assertTrue(htmlBody.contains("Trading names removed Trading name one"))
      Assert.assertTrue(htmlBody.contains("Trading name 2"))
      Assert.assertTrue(htmlBody.contains("Contact name or business department CS full-name"))
      Assert.assertTrue(htmlBody.contains("Email address email-cs-test@test.com"))
      Assert.assertTrue(htmlBody.contains("Name on the account CS Name"))
      Assert.assertTrue(htmlBody.contains("BIC (Business Identifier Code) or SWIFT code (if you have one) ABCDDD2A"))
      Assert.assertTrue(htmlBody.contains("IBAN (International Bank Account Number) GB33BUKB20201555555555555"))
    } else if (version == "previous") {
      Assert.assertTrue(htmlBody.contains("You changed the following details:"))
      Assert.assertTrue(htmlBody.contains("Trading names added Trading name cross-schema two"))
      Assert.assertTrue(htmlBody.contains("Trading names removed Trading name 2"))
      Assert.assertTrue(htmlBody.contains("Contact name or business department CS full-name"))
      Assert.assertTrue(htmlBody.contains("IBAN (International Bank Account Number) GB29NWBK60161331926819"))
    } else if (version == "multiple") {
      Assert.assertTrue(htmlBody.contains("You changed the following details:"))
      Assert.assertTrue(htmlBody.contains("Trading names removed Trading name one"))
      Assert.assertTrue(htmlBody.contains("Email address email-cs-test@test.com"))
      Assert.assertTrue(htmlBody.contains("Name on the account CS Name"))
    } else {
      Assert.assertTrue(htmlBody.contains("You haven't changed any details"))
    }
  }

  def oneTradingName(): Unit = {
    val header = Driver.instance.findElement(By.tagName("h1")).getText
    Assert.assertTrue(header.equals("You have added one UK trading name"))
  }
}
