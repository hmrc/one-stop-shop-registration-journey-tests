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
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait}
import org.openqa.selenium.{By, Keys}
import uk.gov.hmrc.configuration.TestEnvironment
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.ui.pages.Registration.dateFormatter

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object CommencementDate extends BasePage {

  def checkVersion(version: String): Unit = {
    val htmlBody     = Driver.instance.findElement(By.tagName("body")).getText
    val post10thText = "You registered after the 10th day of the next month following your first eligible sale."
    version match {
      case "pre"  => Assert.assertFalse(htmlBody.contains(post10thText))
      case "post" => Assert.assertTrue(htmlBody.contains(post10thText))
      case _      => throw new Exception("Version doesn't exist")
    }
  }

  def checkCommencementDate(day: String): Unit = {
    var date          = LocalDate.now()
    if (day == "yesterday") {
      date = date.minusDays(1)
    }
    val htmlBody      = Driver.instance.findElement(By.tagName("body")).getText
    val startDateText =
      "You must include all eligible sales from " + date.format(dateFormatter) + " in your first return."
    Assert.assertTrue(htmlBody.contains(startDateText))
  }

  def commencementDateNextQuarter(): Unit = {
    val firstDayOfNextQuarter = CommonPage.getNextQuarterCommencementDate().format(dateFormatter)

    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText
    Assert.assertTrue(
      htmlBody.contains(s"You must include all eligible sales from $firstDayOfNextQuarter in your first return.")
    )
    Assert.assertTrue(
      htmlBody.contains(
        s"If you make your first sale before $firstDayOfNextQuarter you must update your registration to tell us."
      )
    )
  }
}
