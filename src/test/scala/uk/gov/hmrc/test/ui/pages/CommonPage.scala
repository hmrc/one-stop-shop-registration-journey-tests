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

package uk.gov.hmrc.test.ui.pages

import io.cucumber.datatable.DataTable
import org.junit.Assert
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait}
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.test.ui.driver.BrowserDriver

import java.time.LocalDate
import scala.jdk.CollectionConverters._

object CommonPage extends BrowserDriver with Matchers {

  def goToEmailVerificationUrl(journeyId: String): Unit =
    driver
      .navigate()
      .to(
        s"http://localhost:9890/email-verification/journey/$journeyId/passcode?continueUrl=/pay-vat-on-goods-sold-to-eu/northern-ireland-register/bank-details&origin=OSS&service=one-stop-shop-registration-frontend"
      )

  def goToEmailVerificationPasscodeGeneratorUrl(): Unit =
    driver.navigate
      .to("http://localhost:10200/pay-vat-on-goods-sold-to-eu/northern-ireland-register/test-only/get-passcodes")

  def goToStartOfJourneyFromStub(): Unit =
    driver.navigate().to("http://localhost:9949/auth-login-stub/gg-sign-in/")

  def checkUrl(url: String): Unit =
    driver.getCurrentUrl should endWith(url)

  def goToStartOfJourney(): Unit =
    driver.navigate().to("http://localhost:10200/pay-vat-on-goods-sold-to-eu/northern-ireland-register/")

  def goToContinueOnSignInPage(): Unit =
    driver
      .navigate()
      .to("http://localhost:10200/pay-vat-on-goods-sold-to-eu/northern-ireland-register/continue-on-sign-in")

  def goToStartOfExternalJourney(): Unit =
    driver
      .navigate()
      .to("http://localhost:10200/pay-vat-on-goods-sold-to-eu/northern-ireland-register/test-only/from-external")

  def navigateToBtaLink(link: String): Unit =
    driver
      .navigate()
      .to(s"http://localhost:10200/pay-vat-on-goods-sold-to-eu/northern-ireland-register/test-only/$link")

  def enterData(data: String, inputId: String = "value"): Unit = {
    driver.findElement(By.id(inputId)).sendKeys(data)
    CommonPage.clickContinue()
  }

  def waitForElement(by: By)                        =
    new FluentWait(driver).until(ExpectedConditions.presenceOfElementLocated(by))

  def selectValueAutocomplete(data: String): Unit = {
    val inputId = "value"
    driver.findElement(By.id(inputId)).sendKeys(data)
    waitForElement(By.id(inputId))
    driver.findElement(By.cssSelector("li#value__option--0")).click()
    CommonPage.clickContinue()
  }

  def provideDate(date: String): Unit = {
    driver.findElement(By.id("value.day")).sendKeys(date.substring(0, 2))
    driver.findElement(By.id("value.month")).sendKeys(date.substring(3, 5))
    driver.findElement(By.id("value.year")).sendKeys(date.substring(6, 10))
    CommonPage.clickContinue()
  }
  def enterTheIossNumbers(iossNumber: String): Unit =
    driver.findElement(By.id("previousSchemeNumber")).sendKeys(iossNumber)
  def enterTheIntermediaryIdentificationNumber(intermediaryNumber: String): Unit = {
    driver.findElement(By.id("previousIntermediaryNumber")).sendKeys(intermediaryNumber)
    CommonPage.clickContinue()
  }

  def selectAnswer(data: String): Unit = {
    data match {
      case "yes" => driver.findElement(By.id("value")).click()
      case "no"  => driver.findElement(By.id("value-no")).click()
      case _     => throw new Exception("Option doesn't exist")
    }
    CommonPage.clickContinue()
  }

  def selectAnswerAs(data: String): Unit = {
    data match {
      case "oss"  => driver.findElement(By.id("value_0")).click()
      case "ioss" => driver.findElement(By.id("value_1")).click()
      case _      => throw new Exception("Option doesn't exist")
    }
    CommonPage.clickContinue()
  }

  def selectSortOfRegistrationAs(data: String): Unit = {
    data match {
      case "vat number"    => driver.findElement(By.id("value_0")).click()
      case "tax id number" => driver.findElement(By.id("value_1")).click()
      case _               => throw new Exception("Option doesn't exist")
    }
    CommonPage.clickContinue()
  }

  def selectOperationAs(data: String): Unit = {
    data match {
      case "fixed establishment" => driver.findElement(By.id("value_0")).click()
      case "dispatch warehouse"  => driver.findElement(By.id("value_1")).click()
      case _                     => throw new Exception("Option doesn't exist")
    }
    CommonPage.clickContinue()
  }

  def selectContinueRegistration(data: String): Unit = {
    data match {
      case "yes"                                  => driver.findElement(By.id("continueProgress")).click()
      case "No,delete my answers and start again" => driver.findElement(By.id("deleteProgress")).click()
      case _                                      => throw new Exception("Option doesn't exist")
    }
    CommonPage.clickContinue()
  }

  def completeForm(dataTable: DataTable): Unit = {
    dataTable.asMaps[String, String](classOf[String], classOf[String]).asScala.foreach { row =>
      driver.findElement(By.id(row.get("fieldId"))).clear()
      driver.findElement(By.id(row.get("fieldId"))).sendKeys(row.get("data"))
    }
    CommonPage.clickContinue()
  }

  def submitRegistration(): Unit =
    CommonPage.clickContinue()

  def clickContinue(): Unit =
    driver.findElement(By.id("continue")).click()

  def clearDate(): Unit = {
    driver.findElement(By.id("value.day")).clear()
    driver.findElement(By.id("value.month")).clear()
    driver.findElement(By.id("value.year")).clear()

  }

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
      case _                      => fail("unknown check button")
    }

  }

  def getNextQuarterCommencementDate(): LocalDate = {

    val lastMonthofQuarter       = (((LocalDate.now().getMonthValue - 1) / 3) + 1) * 3
    val dateInLastMonthOfQuarter = LocalDate.now().withMonth(lastMonthofQuarter)
    val lastDayOfCurrentQuarter  = dateInLastMonthOfQuarter.withDayOfMonth(dateInLastMonthOfQuarter.lengthOfMonth())

    lastDayOfCurrentQuarter.plusDays(1)
  }

  def navigateToPage(page: String): Unit =
    driver
      .navigate()
      .to(s"http://localhost:10200/pay-vat-on-goods-sold-to-eu/northern-ireland-register/$page")
}
