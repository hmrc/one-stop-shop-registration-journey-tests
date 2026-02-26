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

  def tradingNameWarnings(version: String, journey: String, displayed: Boolean): Unit = {
    val htmlBody    = Driver.instance.findElement(By.tagName("body")).getText
    val hintText    =
      "We added the trading names you entered when you registered for the Import One Stop Shop service. Check they are still correct."
    val warningText = if (version == "multiple") {
      "Any changes you make here will also update the trading names in all of your Import One Stop Shop registrations."
    } else if (version == "previous") {
      "Any changes you make here will also update the trading names in your previous Import One Stop Shop registration."
    } else if (version == "current") {
      "Any changes you make here will also update the trading names in your Import One Stop Shop registration."
    } else {
      "Any changes you make here will also update the trading names in"
    }

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

  def contactAndBankWarnings(page: String, version: String, journey: String, displayed: Boolean): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText
    val hintText =
      "We have added the details you entered for the Import One Stop Shop service. Check they are still correct."

    val warningText = if (version == "current") {
      s"Any changes you make here will also update the $page details in your Import One Stop Shop registration."
    } else if (version == "previous") {
      s"Any changes you make here will also update the $page details in your previous Import One Stop Shop registration."
    } else if (version == "multiple") {
      s"Any changes you make here will also update the $page details in all of your Import One Stop Shop registrations."
    } else {
      s"Any changes you make here will also update the $page details in"
    }

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

  def confirmationText(version: String, displayed: Boolean): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText

    val iossConfirmationText = if (version == "current") {
      "We've also updated your Import One Stop Shop registration."
    } else if (version == "previous") {
      "We've also updated your previous Import One Stop Shop registration."
    } else if (version == "multiple") {
      "We've also updated your previous Import One Stop Shop registrations."
    } else {
      "We've also updated your"
    }

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
      Assert.assertTrue(htmlBody.contains("BIC or SWIFT code (if you have one) ABCDDD2A"))
      Assert.assertTrue(htmlBody.contains("IBAN GB33BUKB20201555555555555"))
    } else if (version == "previous") {
      Assert.assertTrue(htmlBody.contains("You changed the following details:"))
      Assert.assertTrue(htmlBody.contains("Trading names added Trading name cross-schema two"))
      Assert.assertTrue(htmlBody.contains("Trading names removed Trading name 2"))
      Assert.assertTrue(htmlBody.contains("Contact name or business department CS full-name"))
      Assert.assertTrue(htmlBody.contains("IBAN GB29NWBK60161331926819"))
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
