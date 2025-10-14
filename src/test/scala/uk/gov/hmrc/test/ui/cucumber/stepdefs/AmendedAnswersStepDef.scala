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

import org.junit.Assert
import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.pages._

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class AmendedAnswersStepDef extends BaseStepDef {

  val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy")

  Then("""^the confirmation of no answers changed is displayed$""") { () =>
    val htmlBody = driver.findElement(By.tagName("body")).getText
    Assert.assertTrue(htmlBody.contains("You haven't changed any details"))
  }

  Then("""^the confirmation of a changed date of first sale is displayed$""") { () =>
    val today    = LocalDate.now().format(dateFormatter)
    val htmlBody = driver.findElement(By.tagName("body")).getText
    Assert.assertTrue(htmlBody.contains("You changed the following details:"))
    Assert.assertTrue(htmlBody.contains("Already made eligible sales Yes"))
    Assert.assertTrue(htmlBody.contains(s"Date of first sale $today"))
    Assert.assertTrue(htmlBody.contains(s"Include sales from this date $today"))
  }

  Then("""^the confirmation of changing to having not made eligible sales is displayed$""") { () =>
    val nextQuarter = CommonPage.getNextQuarterCommencementDate().format(dateFormatter)
    val htmlBody    = driver.findElement(By.tagName("body")).getText
    Assert.assertTrue(htmlBody.contains("You changed the following details:"))
    Assert.assertTrue(htmlBody.contains("Already made eligible sales No"))
    Assert.assertTrue(htmlBody.contains(s"Include sales from this date $nextQuarter"))
  }

  Then("""^all of the first combination answers are displayed as changed on the confirmation page$""") { () =>
    val htmlBody = driver.findElement(By.tagName("body")).getText
    Assert.assertTrue(htmlBody.contains("You changed the following details:"))
    Assert.assertTrue(htmlBody.contains("Have a different UK trading name Yes"))
    Assert.assertTrue(htmlBody.contains("Trading names added my trading name"))
    Assert.assertTrue(htmlBody.contains("another company"))
    Assert.assertTrue(htmlBody.contains("Other One Stop Shop registrations Yes"))
    Assert.assertTrue(htmlBody.contains("Countries registered in Finland"))
    Assert.assertTrue(htmlBody.contains("Registered for tax in other EU countries Yes"))
    Assert.assertTrue(htmlBody.contains("EU tax details added Portugal"))
    Assert.assertTrue(htmlBody.contains("Slovenia"))
    Assert.assertTrue(htmlBody.contains("Sell goods online Yes"))
    Assert.assertTrue(htmlBody.contains("Trading websites added https://www.first-website.com"))
    Assert.assertTrue(htmlBody.contains("https://www.anotherwebsiteurl.com"))
    Assert.assertTrue(htmlBody.contains("Contact name or business department Another full name"))
    Assert.assertTrue(htmlBody.contains("Telephone number 09852355522525"))
    Assert.assertTrue(htmlBody.contains("Name on the account Different Name"))
    Assert.assertTrue(htmlBody.contains("BIC or SWIFT code (if you have one) ABCDDD2A"))
    Assert.assertTrue(htmlBody.contains("IBAN GB33BUKB20201555555555555"))
  }

  Then("""^all of the second combination answers are displayed as changed on the confirmation page$""") { () =>
    val htmlBody = driver.findElement(By.tagName("body")).getText
    Assert.assertTrue(htmlBody.contains("You changed the following details:"))
    Assert.assertTrue(htmlBody.contains("Trading names added Trading name two"))
    Assert.assertTrue(htmlBody.contains("Trading names removed Trading name one"))
    Assert.assertTrue(htmlBody.contains("Trading name 2"))
    Assert.assertTrue(htmlBody.contains("Countries registered in Spain"))
    Assert.assertTrue(htmlBody.contains("Countries registered in changed Bulgaria"))
    Assert.assertTrue(htmlBody.contains("EU tax details removed Cyprus"))
    Assert.assertTrue(htmlBody.contains("Romania"))
    Assert.assertTrue(htmlBody.contains("EU tax details changed Netherlands"))
    Assert.assertTrue(htmlBody.contains("Other businesses sell goods on your website or app No"))
    Assert.assertTrue(htmlBody.contains("Trading websites added https://www.anotherwebsite.com"))
    Assert.assertTrue(htmlBody.contains("Trading websites removed www.onewebsite.co.uk"))
    Assert.assertTrue(htmlBody.contains("Contact name or business department Another full-name"))
    Assert.assertTrue(htmlBody.contains("Email address email-test@test.com"))
  }

  Then("""^all of the third combination answers are displayed as changed on the confirmation page$""") { () =>
    val htmlBody = driver.findElement(By.tagName("body")).getText
    Assert.assertTrue(htmlBody.contains("You changed the following details:"))
    Assert.assertTrue(htmlBody.contains("Have a different UK trading name No"))
    Assert.assertTrue(htmlBody.contains("Trading names removed Trading name one"))
    Assert.assertTrue(htmlBody.contains("Trading name 2"))
    Assert.assertTrue(htmlBody.contains("Registered for tax in other EU countries No"))
    Assert.assertTrue(htmlBody.contains("EU tax details removed Cyprus"))
    Assert.assertTrue(htmlBody.contains("Netherlands"))
    Assert.assertTrue(htmlBody.contains("Romania"))
    Assert.assertTrue(htmlBody.contains("Sell goods online No"))
    Assert.assertTrue(htmlBody.contains("Trading websites removed www.onewebsite.co.uk"))
    Assert.assertTrue(htmlBody.contains("www.website2.org.uk"))
  }

  Then("""^the confirmation of a removed fixed establishment is displayed$""") { () =>
    val htmlBody = driver.findElement(By.tagName("body")).getText
    Assert.assertTrue(htmlBody.contains("You changed the following details:"))
    Assert.assertTrue(htmlBody.contains("EU tax details removed Cyprus"))
  }

  Then("""^the updated email address is displayed as changed on the confirmation page$""") { () =>
    val htmlBody = driver.findElement(By.tagName("body")).getText
    Assert.assertTrue(htmlBody.contains("You changed the following details:"))
    Assert.assertTrue(htmlBody.contains("Email address different-email@test.com"))
  }

}
