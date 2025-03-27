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

import org.junit.Assert
import org.openqa.selenium.By

class CrossSchemaStepDef extends BaseStepDef {

  Then(
    """^the correct number of existing trading names are displayed for a trader with (a current|a previous|multiple|no) IOSS (registration|registrations)$"""
  ) { (version: String, registrationNumber: String) =>
    val header = driver.findElement(By.tagName("h1")).getText
    if (version == "no") {
      Assert.assertTrue(header.equals("You have added one UK trading name"))
    } else {
      Assert.assertTrue(header.equals("You have 2 UK trading names from your Import One Stop Shop registration"))
    }
  }

  Then(
    """^the (registration|amend|rejoin) trading name warnings (are|are not) displayed for a trader with (a current|a previous|multiple|no) IOSS (registration|registrations)$"""
  ) { (journey: String, displayed: String, version: String, registrationsNumber: String) =>
    val htmlBody    = driver.findElement(By.tagName("body")).getText
    val hintText    =
      "We added the trading names you entered when you registered for the Import One Stop Shop service. Check they are still correct."
    val warningText = if (version == "multiple") {
      "Any changes you make here will also update the trading names in all of your Import One Stop Shop registrations."
    } else if (version == "a previous") {
      "Any changes you make here will also update the trading names in your previous Import One Stop Shop registration."
    } else if (version != "no") {
      "Any changes you make here will also update the trading names in your Import One Stop Shop registration."
    } else {
      "Any changes you make here will also update the trading names in"
    }

    if (displayed == "are not") {
      if (journey == "registration") {
        Assert.assertFalse(htmlBody.contains(hintText))
      }
      Assert.assertFalse(htmlBody.contains(warningText))
    } else {
      if (journey == "registration") {
        Assert.assertTrue(htmlBody.contains(hintText))
      }
      Assert.assertTrue(htmlBody.contains(warningText))
    }
  }

  Then(
    """^the (contact|bank) details warnings (are|are not) displayed for a trader with (a current|a previous|multiple|no) IOSS (registration|registrations)$"""
  ) { (page: String, displayed: String, version: String, registrationsNumber: String) =>
    val htmlBody = driver.findElement(By.tagName("body")).getText
    val hintText =
      "We have added the details you entered for the Import One Stop Shop service. Check they are still correct."

    val warningText = if (version == "a current") {
      s"Any changes you make here will also update the $page details in your Import One Stop Shop registration."
    } else if (version == "a previous") {
      s"Any changes you make here will also update the $page details in your previous Import One Stop Shop registration."
    } else if (version == "multiple") {
      s"Any changes you make here will also update the $page details in all of your Import One Stop Shop registrations."
    } else {
      s"Any changes you make here will also update the $page details in"
    }

    if (displayed == "are not") {
      Assert.assertFalse(htmlBody.contains(hintText))
      Assert.assertFalse(htmlBody.contains(warningText))
    } else {
      Assert.assertTrue(htmlBody.contains(hintText))
      Assert.assertTrue(htmlBody.contains(warningText))
    }
  }

  Then(
    """^the text on the confirmation page (is|is not) displayed when the trader (has|has not) made changes and (has a current|has a previous|has multiple|has no) IOSS (registration|registrations)$"""
  ) { (displayed: String, madeChanges: String, version: String, registrationNumber: String) =>
    val htmlBody = driver.findElement(By.tagName("body")).getText

    val iossConfirmationText = if (version == "has a current") {
      "We've also updated your Import One Stop Shop registration."
    } else if (version == "has a previous") {
      "We've also updated your previous Import One Stop Shop registration."
    } else if (version == "has multiple") {
      "We've also updated your previous Import One Stop Shop registrations."
    } else {
      "We've also updated your"
    }

    if (displayed == "is not") {
      Assert.assertFalse(htmlBody.contains(iossConfirmationText))
    } else {
      Assert.assertTrue(htmlBody.contains(iossConfirmationText))
    }
  }

  Then("""^the contact details are blank$""") { () =>
    Assert.assertTrue(driver.findElement(By.id("fullName")).getAttribute("value").isEmpty)
    Assert.assertTrue(driver.findElement(By.id("telephoneNumber")).getAttribute("value").isEmpty)
    Assert.assertTrue(driver.findElement(By.id("emailAddress")).getAttribute("value").isEmpty)
  }

  Then("""^the bank details are blank$""") { () =>
    Assert.assertTrue(driver.findElement(By.id("accountName")).getAttribute("value").isEmpty)
    Assert.assertTrue(driver.findElement(By.id("bic")).getAttribute("value").isEmpty)
    Assert.assertTrue(driver.findElement(By.id("iban")).getAttribute("value").isEmpty)
  }

  Then(
    """^all of the updated answers are displayed as changed on the amend confirmation page for (a current|a previous|multiple|no) IOSS (registration|registrations)"""
  ) { (version: String, registrationNumber: String) =>
    val htmlBody = driver.findElement(By.tagName("body")).getText

    if (version == "a current" || version == "no") {
      Assert.assertTrue(htmlBody.contains("You changed the following details:"))
      Assert.assertTrue(htmlBody.contains("Trading names added Trading name cross-schema two"))
      Assert.assertTrue(htmlBody.contains("Trading names removed Trading name one"))
      Assert.assertTrue(htmlBody.contains("Trading name 2"))
      Assert.assertTrue(htmlBody.contains("Contact name or business department CS full-name"))
      Assert.assertTrue(htmlBody.contains("Email address email-cs-test@test.com"))
      Assert.assertTrue(htmlBody.contains("Name on the account CS Name"))
      Assert.assertTrue(htmlBody.contains("BIC or SWIFT code (if you have one) ABCDDD2A"))
      Assert.assertTrue(htmlBody.contains("IBAN GB33BUKB20201555555555555"))
    } else if (version == "a previous") {
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
    }
  }

  Then(
    """^only the existing trading names are displayed for a trader with no IOSS registrations$"""
  ) { (version: String, registrationNumber: String) =>
    val header = driver.findElement(By.tagName("h1")).getText
    Assert.assertTrue(header.equals("You have added 2 UK trading names"))
  }

}
