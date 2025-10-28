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

package uk.gov.hmrc.test.ui.pages

import io.cucumber.datatable.DataTable
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.selenium.component.PageObject
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.test.ui.pages.AuthPage.fluentWait

import java.time.LocalDate
import scala.jdk.CollectionConverters._

object CommonPage extends PageObject with Matchers {

  def checkUrl(url: String): Unit = {
    fluentWait.until(ExpectedConditions.urlContains(url))
    getCurrentUrl should endWith(url)
  }

  def goToStartOfJourney(): Unit =
    get("http://localhost:10200/pay-vat-on-goods-sold-to-eu/northern-ireland-register/")

  def goToContinueOnSignInPage(): Unit =
    get("http://localhost:10200/pay-vat-on-goods-sold-to-eu/northern-ireland-register/continue-on-sign-in")

  def enterData(data: String, inputId: String = "value"): Unit = {
    sendKeys(By.id(inputId), data)
    clickContinue()
  }

  def waitForElement(by: By) =
    fluentWait.until(ExpectedConditions.presenceOfElementLocated(by))

  def selectValueAutocomplete(data: String): Unit = {
    val inputId = "value"
    sendKeys(By.id(inputId), data)
    waitForElement(By.id(inputId))
    click(By.cssSelector("li#value__option--0"))
    clickContinue()
  }

  def provideDate(date: String): Unit = {
    sendKeys(By.id("value.day"), date.substring(0, 2))
    sendKeys(By.id("value.month"), date.substring(3, 5))
    sendKeys(By.id("value.year"), date.substring(6, 10))
    clickContinue()
  }

  def selectAnswer(data: String): Unit = {
    data match {
      case "yes" => click(By.id("value"))
      case "no"  => click(By.id("value-no"))
      case _     => throw new Exception("Option doesn't exist")
    }
    CommonPage.clickContinue()
  }

  def completeForm(dataTable: DataTable): Unit = {
    dataTable.asMaps[String, String](classOf[String], classOf[String]).asScala.foreach { row =>
      Driver.instance.findElement(By.id(row.get("fieldId"))).clear()
      Driver.instance.findElement(By.id(row.get("fieldId"))).sendKeys(row.get("data"))
    }
    CommonPage.clickContinue()
  }

  def submitRegistration(): Unit =
    CommonPage.clickSubmit()

  def clickContinue(): Unit =
    click(By.id("continue"))

  def clickSubmit(): Unit =
    click(By.id("submit"))

  def enterDate(day: String, month: String, year: String): Unit = {
    sendKeys(By.id("value.day"), day)
    sendKeys(By.id("value.month"), month)
    sendKeys(By.id("value.year"), year)
  }

  def getNextQuarterCommencementDate(): LocalDate = {
    val lastMonthofQuarter       = (((LocalDate.now().getMonthValue - 1) / 3) + 1) * 3
    val dateInLastMonthOfQuarter = LocalDate.now().withMonth(lastMonthofQuarter)
    val lastDayOfCurrentQuarter  = dateInLastMonthOfQuarter.withDayOfMonth(dateInLastMonthOfQuarter.lengthOfMonth())

    lastDayOfCurrentQuarter.plusDays(1)
  }

  def navigateToPage(page: String): Unit =
    get(s"http://localhost:10200/pay-vat-on-goods-sold-to-eu/northern-ireland-register/$page")

  def clickBackButton(): Unit =
    Driver.instance
      .navigate()
      .back()

  def selectLinkByCss(link: String): Unit =
    click(By.cssSelector(s"a[href*=$link]"))

  def selectLinkById(link: String): Unit =
    click(By.id(link))

  def selectLinkByXPath(link: String): Unit =
    click(By.xpath(link))

}
