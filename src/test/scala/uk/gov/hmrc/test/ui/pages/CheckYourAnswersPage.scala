/*
 * Copyright 2021 HM Revenue & Customs
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
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.selenium.Chrome.textField
import uk.gov.hmrc.test.ui.driver.BrowserDriver
import uk.gov.hmrc.test.ui.pages.CommonPage.selectValueAutocomplete

import scala.collection.JavaConverters._

object CheckYourAnswersPage extends BrowserDriver with Matchers {

  def changeAnswers(dataTable: DataTable): Unit =
    dataTable.asMaps[String, String](classOf[String], classOf[String]).asScala.foreach { row =>
      val link = "change" + row.get("page").replace(" ", "")
      driver.findElement(By.cssSelector(s"a[href*=$link]")).click()
      CommonPage.checkUrl(link)
      driver.findElement(By.id("value")).clear()
      driver.findElement(By.id("value")).sendKeys(row.get("data"))
      driver.findElement(By.xpath("//*[@id='main-content']/div/div/form/button")).click()
    }

  def selectLink(link: String): Unit =
    driver.findElement(By.cssSelector(s"a[href*=$link]")).click()

  def changeUkTradingName(): CheckYourAnswersPage.type = {
    CommonPage.selectLink("check-have-uk-trading-name")
    this
  }

  def hasDifferentTradingName(): CheckYourAnswersPage.type = {
    CommonPage.checkUrl("check-have-uk-trading-name")
    CommonPage.selectAnswer("yes")
    this
  }

  def changeTaxInEu(): CheckYourAnswersPage.type = {
    CommonPage.selectLink("check-tax-in-eu")
    this
  }

  def hasEuRegistration(): CheckYourAnswersPage.type = {
    CommonPage.checkUrl("check-tax-in-eu")
    CommonPage.selectAnswer("yes")
    this
  }

  def addCountryRegisteredForTaxInEu(country: String): CheckYourAnswersPage.type = {
    CommonPage.selectValueAutocomplete(country)
    this
  }

  def registeredForVat(vatNumber: String): CheckYourAnswersPage.type = {
    CommonPage.selectAnswer("yes")
    CommonPage.enterData(vatNumber)
    this
  }

  def withoutFixedEstablishment: CheckYourAnswersPage.type = {
    CommonPage.selectAnswer("no")
    this
  }

  def headingText(heading: String): CheckYourAnswersPage.type = {
    driver.findElement(By.tagName("h1")).getText should include(heading)
    this
  }

  def continueEu: CheckYourAnswersPage.type = {
    CommonPage.clickContinue()
    this
  }

  def anotherBusinessRegisteredForTaxInEu: CheckYourAnswersPage.type = {
    CommonPage.selectAnswer("yes")
    this
  }

  def withFixedEstablishment: CheckYourAnswersPage.type = {
    CommonPage.selectAnswer("yes")
    this
  }

  def addTradingName(tradingName: String): CheckYourAnswersPage.type = {
    CommonPage.enterData(tradingName)
    this
  }

  def addAnotherTradingName(answer: String): CheckYourAnswersPage.type = {
    CommonPage.selectAnswer(answer)
    this
  }

  def addFixedEstablishmentAddress: CheckYourAnswersPage.type = {
    driver.findElement(By.id("line1")).sendKeys("1 Address")
    driver.findElement(By.id("townOrCity")).sendKeys("A town")
//    textField("line1").value = "1 Address"
//    textField("townOrCity").value = "A town"
    CommonPage.clickContinue()
    this
  }

  def changeVatRegistered: CheckYourAnswersPage.type = {
    val summaryRows = driver.findElements(By.className("govuk-summary-list__row")).asScala.toList
    summaryRows.find(row =>
      row.findElement(By.className("govuk-summary-list__key")).getText == "VAT registered"
    ) match {
      case Some(element) => element.findElement(By.className("govuk-link")).click()
      case None          => throw new NoSuchElementException("No row with value 'VAT registered' in Summary List")
    }
    this
  }

  def notRegisteredForVat: CheckYourAnswersPage.type = {
    CommonPage.selectAnswer("no")
    this
  }

  def addTaxIdentificationNumber: CheckYourAnswersPage.type = {
    CommonPage.enterData("ABC123")
    this
  }

  def continueToCheckAddTaxDetailsPage: CheckYourAnswersPage.type = {
    CommonPage.clickContinue()
    this
  }

  def continuesToCheckYourAnswersPage: CheckYourAnswersPage.type = {
    CommonPage.selectAnswer("no")
    CheckYourAnswersPage
  }

  def changeDeregistrationDetails: CheckYourAnswersPage.type = {
    CommonPage.checkUrl("check-answers")
    selectLink("check-deregistered")
    this
  }

  def addDeregisteredCountryDetails: CheckYourAnswersPage.type = {
    CommonPage.checkUrl("check-deregistered")
    CommonPage.selectAnswer("yes")
    CommonPage.selectValueAutocomplete("Austria")
    CommonPage.enterData("AT123")
    this
  }

  def giveWebsiteAddress: CheckYourAnswersPage.type = {
    CommonPage.checkUrl("check-answers")
    selectLink("check-give-website-address")
    CommonPage.checkUrl("check-give-website-address")
    this
  }

  def addWebsiteAddress(url: String): CheckYourAnswersPage.type = {
    CommonPage.selectAnswer("yes")
    CommonPage.enterData(url)
    CommonPage.checkUrl("check-add-website-address")
    this
  }

  def addAnotherWebsiteAddress: CheckYourAnswersPage.type = {
    CommonPage.selectAnswer("yes")
    this
  }

  def websiteAddressCount(index: Int): CheckYourAnswersPage.type = {
    driver.findElements(By.className("hmrc-add-to-a-list__identifier")).asScala.toList.size should be(index)
    this
  }

  def removeWebsiteAddress(index: Int): CheckYourAnswersPage.type = {
    CommonPage.checkUrl("check-add-website-address")
    selectLink(s"check-remove-website-address\\/$index")
    CommonPage.checkUrl(s"check-remove-website-address/$index")
    CommonPage.selectAnswer("yes")
    CommonPage.checkUrl("check-add-website-address")
    this
  }

  def chooseToNotAddAnotherWebsiteAddress(): CheckYourAnswersPage.type = {
    CommonPage.selectAnswer("no")
    CommonPage.checkUrl("check-answers")
    CheckYourAnswersPage
  }

}
