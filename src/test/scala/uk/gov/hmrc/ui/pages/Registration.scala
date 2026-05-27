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
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait}
import org.openqa.selenium.By
import uk.gov.hmrc.configuration.TestEnvironment
import uk.gov.hmrc.selenium.webdriver.Driver

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Registration extends BasePage {

  private val registrationUrl: String =
    TestEnvironment.url("one-stop-shop-registration-frontend")
  private val journeyUrl: String      = "/pay-vat-on-goods-sold-to-eu/northern-ireland-register"

  private val dashboardUrl: String        =
    TestEnvironment.url("one-stop-shop-returns-frontend")
  private val dashboardJourneyUrl: String = "/pay-vat-on-goods-sold-to-eu/northern-ireland-returns-payments"

  private val email = EmailVerification

  val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy")

  def goToRegistrationJourney(): Unit =
    get(registrationUrl + journeyUrl)

  def checkJourneyUrl(page: String): Unit = {
    val url = s"$registrationUrl$journeyUrl/$page"
    fluentWait.until(ExpectedConditions.urlContains(url))
    getCurrentUrl.startsWith(url)
  }

  def checkDashboardJourneyUrl(page: String): Unit =
    getCurrentUrl.startsWith(s"$dashboardUrl$dashboardJourneyUrl/$page")

  def answerRadioButton(answer: String): Unit = {

    answer match {
      case "yes" => click(By.id("value"))
      case "no"  => click(By.id("value-no"))
      case _     => throw new Exception("Option doesn't exist")
    }
    click(continueButton)
  }

  def answerVatDetailsChoice(answer: String): Unit = {
    answer match {
      case "Yes"                                           => click(By.id("value_0"))
      case "Yes, but some of my VAT details are incorrect" => click(By.id("value_1"))
      case "No, I want to register a different business"   => click(By.id("value_2"))
      case _                                               => throw new Exception("Option doesn't exist")
    }
    click(continueButton)
  }

  def continue(): Unit =
    click(continueButton)

  def submit(): Unit =
    click(submitButton)

  def goToPage(page: String): Unit =
    get(s"$registrationUrl$journeyUrl/$page")

  def enterAnswer(answer: String): Unit = {
    sendKeys(By.id("value"), answer)
    click(continueButton)
  }

  def selectChangeOrRemoveLink(link: String): Unit =
    click(By.cssSelector(s"a[href*=$link]"))

  def waitForElement(by: By): Unit =
    new FluentWait(Driver.instance).until(ExpectedConditions.presenceOfElementLocated(by))

  def selectCountry(country: String): Unit = {
    val inputId = "value"
    sendKeys(By.id(inputId), country)
    waitForElement(By.id(inputId))
    click(By.cssSelector("li#value__option--0"))
    click(continueButton)
  }

  def selectRegistrationType(data: String): Unit = {
    data match {
      case "vat number"    => click(By.id("value_0"))
      case "tax id number" => click(By.id("value_1"))
      case _               => throw new Exception("Option doesn't exist")
    }
    continue()
  }

  def enterFixedEstablishmentAddress(
    line1: String,
    line2: String,
    townOrCity: String,
    stateOrRegion: String,
    postCode: String
  ): Unit = {
    sendKeys(By.id("line1"), line1)
    sendKeys(By.id("line2"), line2)
    sendKeys(By.id("townOrCity"), townOrCity)
    sendKeys(By.id("stateOrRegion"), stateOrRegion)
    sendKeys(By.id("postCode"), postCode)
    click(continueButton)
  }

  def fillContactDetails(name: String, phone: String, email: String): Unit = {
    sendKeys(By.id("fullName"), name)
    sendKeys(By.id("telephoneNumber"), phone)
    sendKeys(By.id("emailAddress"), email)
    click(continueButton)
  }

  def fillBankAccountDetails(accountName: String, bicNumber: String, ibanNumber: String): Unit = {
    sendKeys(By.id("accountName"), accountName)
    sendKeys(By.id("bic"), bicNumber)
    sendKeys(By.id("iban"), ibanNumber)
    click(continueButton)
  }

  def updateField(id: String, text: String): Unit =
    sendKeys(By.id(id), text)

  def minimalRegistrationAnswers(): Unit = {
    checkJourneyUrl("sell-from-northern-ireland")
    answerRadioButton("yes")
    checkJourneyUrl("northern-ireland-business")
    answerRadioButton("yes")
    checkJourneyUrl("business-pay")
    continue()
    checkJourneyUrl("confirm-vat-details")
    answerVatDetailsChoice("Yes")
    checkJourneyUrl("have-uk-trading-name")
    answerRadioButton("no")
    checkJourneyUrl("already-made-sales")
    answerRadioButton("no")
    checkJourneyUrl("previous-oss")
    answerRadioButton("no")
    checkJourneyUrl("start-date")
    continue()
    checkJourneyUrl("tax-in-eu")
    answerRadioButton("no")
    checkJourneyUrl("online-marketplace")
    answerRadioButton("yes")
    checkJourneyUrl("give-website-address")
    answerRadioButton("no")
    checkJourneyUrl("business-contact-details")
    fillContactDetails("Joe Bloggs", "+01234567890", "email@test.com")
    email.completeEmailVerification("registration")
    checkJourneyUrl("bank-details")
    fillBankAccountDetails("Account Name", "", "GB33BUKB20201555555555")
    checkJourneyUrl("check-answers")
    submit()
  }

  def clickLink(link: String): Unit =
    click(By.id(link))

  def checkProblemPage(): Unit = {
    val h1 = Driver.instance.findElement(By.tagName("h1")).getText
    Assert.assertTrue(h1.equals("Sorry, there is a problem with the service"))
  }

  def checkChangeRemoveLinks(): Unit = {
    val body = Driver.instance.findElement(By.tagName("body")).getText
    Assert.assertFalse(body.contains("Change"))
    Assert.assertFalse(body.contains("Remove"))
  }

  def checkAmendedAnswers(amendJourney: String): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText

    amendJourney match {
      case "noToYes"                   =>
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
        Assert.assertTrue(htmlBody.contains("BIC (Business Identifier Code) or SWIFT code (if you have one) ABCDDD2A"))
        Assert.assertTrue(htmlBody.contains("IBAN (International Bank Account Number) GB33BUKB20201555555555555"))
      case "amended"                   =>
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
        Assert.assertTrue(htmlBody.contains("www.website2.org.uk"))
        Assert.assertTrue(htmlBody.contains("Contact name or business department Another full-name"))
        Assert.assertTrue(htmlBody.contains("Email address email-test@test.com"))
      case "websites"                  =>
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
      case "notMadeSales"              =>
        val nextQuarter = CommencementDate.getNextQuarterCommencementDate().format(dateFormatter)
        Assert.assertTrue(htmlBody.contains("You changed the following details:"))
        Assert.assertTrue(htmlBody.contains("Already made eligible sales No"))
        Assert.assertTrue(htmlBody.contains(s"Include sales from this date $nextQuarter"))
      case "changedDateOfFirstSale"    =>
        val today = LocalDate.now().format(dateFormatter)
        Assert.assertTrue(htmlBody.contains("You changed the following details:"))
        Assert.assertTrue(htmlBody.contains("Already made eligible sales Yes"))
        Assert.assertTrue(htmlBody.contains(s"Date of first sale $today"))
        Assert.assertTrue(htmlBody.contains(s"Include sales from this date $today"))
      case "fixedEstablishmentRemoved" =>
        Assert.assertTrue(htmlBody.contains("You changed the following details:"))
        Assert.assertTrue(htmlBody.contains("EU tax details removed Cyprus"))
      case "email"                     =>
        Assert.assertTrue(htmlBody.contains("You changed the following details:"))
        Assert.assertTrue(htmlBody.contains("Email address different-email@test.com"))
      case "noAmendments"              =>
        Assert.assertTrue(htmlBody.contains("You haven't changed any details"))
      case _                           =>
        throw new Exception("This amend variation does not exist")
    }
  }

  def enterDate(day: String): Unit = {

    val date =
      if (day == "7 days ago") {
        LocalDate.now().minusDays(6)
      } else if (day == "today") {
        LocalDate.now()
      } else {
        LocalDate.now() minusDays 1
      }

    sendKeys(By.id("value.day"), date.getDayOfMonth.toString)
    sendKeys(By.id("value.month"), date.getMonthValue.toString)
    sendKeys(By.id("value.year"), date.getYear.toString)

    click(continueButton)
  }

  def answerSchemeType(answer: String): Unit = {
    answer match {
      case "OSS"  => click(By.id("value_0"))
      case "IOSS" => click(By.id("value_1"))
      case _      => throw new Exception("Option doesn't exist")
    }
    click(continueButton)
  }

  def enterIossNumber(iossNumber: String): Unit = {
    sendKeys(By.id("previousSchemeNumber"), iossNumber)
    continue()
  }

  def answerFixedEstablishment(answer: String): Unit = {
    answer match {
      case "fixed establishment" => click(By.id("value_0"))
      case "dispatch warehouse"  => click(By.id("value_1"))
      case _                     => throw new Exception("Option doesn't exist")
    }
    continue()
  }

  def checkBtaUrl(): Unit = {
    val url = "business-account"
    fluentWait.until(ExpectedConditions.urlContains(url))
    getCurrentUrl.endsWith(url)
  }

  def selectOnlineMarketplaceSales(answer: String): Unit = {
    answer match {
      case "All"  => click(By.id("value_0"))
      case "Some" => click(By.id("value_1"))
      case "None" => click(By.id("value_2"))
    }
    continue()
  }

  def noAmendments(): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText
    Assert.assertTrue(htmlBody.contains("You have not made any changes."))
  }
}
