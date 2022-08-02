/*
 * Copyright 2022 HM Revenue & Customs
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
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.test.ui.driver.BrowserDriver
import io.cucumber.datatable.DataTable
import org.junit.Assert
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper

import scala.collection.JavaConverters._

object CommonPage extends BrowserDriver with Matchers {

  def checkUrl(url: String): Unit =
    driver.getCurrentUrl should endWith(url)

  def goToStartOfJourney(): Unit =
    driver.navigate().to("http://localhost:10200/pay-vat-on-goods-sold-to-eu/northern-ireland-register/")

  def goToStartOfExternalJourney(): Unit =
    driver
      .navigate()
      .to("http://localhost:10200/pay-vat-on-goods-sold-to-eu/northern-ireland-register/test-only/from-external")

  def navigateToBtaLink(link: String): Unit =
    driver
      .navigate()
      .to(s"http://localhost:10200/pay-vat-on-goods-sold-to-eu/northern-ireland-register/test-only/$link")

  def enterData(data: String): Unit = {
    val inputId = "value"
    driver.findElement(By.id(inputId)).sendKeys(data)
    driver.findElement(By.className("govuk-button")).click()
  }

  def waitForElement(by: By) =
    new WebDriverWait(driver, 3).until {
      ExpectedConditions.presenceOfElementLocated(by)
    }

  def selectValueAutocomplete(data: String): Unit = {
    val inputId = "value"
    driver.findElement(By.id(inputId)).sendKeys(data)
    waitForElement(By.id(inputId))
    driver.findElement(By.cssSelector("li#value__option--0")).click()
    driver.findElement(By.className("govuk-button")).click()
  }

  def provideDate(date: String): Unit = {
    driver.findElement(By.id("value.day")).sendKeys(date.substring(0, 2))
    driver.findElement(By.id("value.month")).sendKeys(date.substring(3, 5))
    driver.findElement(By.id("value.year")).sendKeys(date.substring(6, 10))
    driver.findElement(By.className("govuk-button")).click()
  }

  def selectAnswer(data: String): Unit = {
    data match {
      case "yes" => driver.findElement(By.id("value")).click()
      case "no"  => driver.findElement(By.id("value-no")).click()
      case _     => throw new Exception("Option doesn't exist")
    }
    driver.findElement(By.className("govuk-button")).click()
  }
  def selectContinueRegistration(data: String): Unit = {
    data match {
      case "yes"                                  => driver.findElement(By.id("continueProgress")).click()
      case "No,delete my answers and start again" => driver.findElement(By.id("deleteProgress")).click()
      case _                                      => throw new Exception("Option doesn't exist")
    }
    driver.findElement(By.className("govuk-button")).click()
  }

  def completeForm(dataTable: DataTable): Unit = {
    dataTable.asMaps[String, String](classOf[String], classOf[String]).asScala.foreach { row =>
      driver.findElement(By.id(row.get("fieldId"))).sendKeys(row.get("data"))
    }
    driver.findElement(By.className("govuk-button")).click()
  }

  def submitRegistration(): Unit =
    driver.findElement(By.className("govuk-button")).click()

  def clickContinue(): Unit =
    driver.findElement(By.className("govuk-button")).click()

  def enterDate(day: String, month: String, year: String): Unit = {
    driver.findElement(By.id("value.day")).sendKeys(day)
    driver.findElement(By.id("value.month")).sendKeys(month)
    driver.findElement(By.id("value.year")).sendKeys(year)

  }

  def checkVersion(version: String): Unit = {
    val htmlBody     = driver.findElement(By.tagName("body")).getText
    val post10thText = "You registered after the 10th day of the next month following your first eligible sale."
    version match {
      case "pre"  => Assert.assertFalse(htmlBody.contains(post10thText))
      case "post" => Assert.assertTrue(htmlBody.contains(post10thText))
      case _      => throw new Exception("Version doesn't exist")
    }
  }
  def checkButton(button: String): Unit = {
    val buttonElement = driver.findElement(By.id("backToYourAccount")).getText
    val buttonText    = "Back to your account"
    button match {
      case "back to your account" => Assert.assertTrue(buttonElement.contains(buttonText))
    }

  }
}
