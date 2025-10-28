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

import io.cucumber.datatable.DataTable
import org.junit.Assert
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import uk.gov.hmrc.test.ui.pages.AuthPage.fluentWait
import uk.gov.hmrc.test.ui.pages.EmailVerificationPage.{checkBusinessContactDetails, checkInterceptPage}
import uk.gov.hmrc.test.ui.pages._

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class RegistrationStepDef extends BaseStepDef {

  val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy")

  And("""^the user inputs ioss reg number (.*) on the (.*) page$""") { (iossNumber: String, url: String) =>
    CommonPage.checkUrl(url)
    RegistrationPage.enterTheIossNumbers(iossNumber)
  }

  When("^the user enters (yesterday|7 days ago|today) for (.*)$") { (date: String, url: String) =>
    val dateOfFirstSale = {
      if (date == "7 days ago") {
        LocalDate.now().minusDays(6)
      } else if (date == "today") {
        LocalDate.now()
      } else {
        LocalDate.now() minusDays 1
      }
    }
    CommonPage.checkUrl(url)
    CommonPage.enterDate(
      dateOfFirstSale.getDayOfMonth.toString,
      dateOfFirstSale.getMonthValue.toString,
      dateOfFirstSale.getYear.toString
    )
    CommonPage.clickContinue()
  }

  When("^the (.*) page displays a commencement date of (today|yesterday)$") { (url: String, day: String) =>
    CommonPage.checkUrl("start-date")
    var date          = LocalDate.now()
    if (day == "yesterday") {
      date = date.minusDays(1)
    }
    val htmlBody      = driver.findElement(By.tagName("body")).getText
    val startDateText =
      "You must include all eligible sales from " + date.format(dateFormatter) + " in your first return."
    Assert.assertTrue(htmlBody.contains(startDateText))
  }

  When("""^the user answer (oss|ioss) on the (.*) page$""") { (data: String, url: String) =>
    CommonPage.checkUrl(url)
    RegistrationPage.selectAnswerAs(data)
  }

  When("""^the user answer (fixed establishment|dispatch warehouse) on the (.*) page$""") {
    (data: String, url: String) =>
      CommonPage.checkUrl(url)
      RegistrationPage.selectOperationAs(data)
  }
  When("""^the user answer (vat number|tax id number) on the (.*) page$""") { (data: String, url: String) =>
    CommonPage.checkUrl(url)
    RegistrationPage.selectSortOfRegistrationAs(data)
  }
  When("""^the user answers (oss|ioss) on the (.*) page$""") { (data: String, url: String) =>
    CommonPage.checkUrl(url)
    RegistrationPage.selectAnswerAs(data)
  }

  When("""^the user select (yes|No,delete my answers and start again) on the (.*) page$""") {
    (data: String, url: String) =>
      if (url == "continue-registration") {}
      CommonPage.checkUrl(url)
      RegistrationPage.selectContinueRegistration(data)
  }

  When("""^the user provides date (.*) on the (.*) page$""") { (date: String, url: String) =>
    CommonPage.checkUrl(url)
    CommonPage.provideDate(date)
  }

  When("""^the user (completes|amends) details on the (.*) page$""") {
    (mode: String, url: String, dataTable: DataTable) =>
      CommonPage.checkUrl(url)
      CommonPage.completeForm(dataTable)
  }

  And("""^the user completes the (registration|amend|rejoin) email verification process""") { (mode: String) =>
    fluentWait.until(ExpectedConditions.urlContains("http://localhost:9890/email-verification/journey"))

    val journeyId = driver.getCurrentUrl.split("/")(5)

    EmailVerificationPage.goToEmailVerificationPasscodeGeneratorUrl()

    val passcode = driver.findElement(By.tagName("body")).getText.split(">")(3).dropRight(3)
    EmailVerificationPage.goToEmailVerificationUrl(journeyId)
    driver.findElement(By.id("passcode")).sendKeys(passcode)
    driver.findElement(By.className("govuk-button")).click()

    if (mode == "registration") {
      fluentWait.until(
        ExpectedConditions.urlContains(
          "http://localhost:10200/pay-vat-on-goods-sold-to-eu/northern-ireland-register/bank-details"
        )
      )
    }
  }

  Then("""^the user submits their registration$""") { () =>
    CommonPage.submitRegistration()
    CommonPage.checkUrl("successful")
  }
  Then("""^the user selects the register button$""") { () =>
    CommonPage.submitRegistration()
  }

  When("""^the user chooses (Yes|No, details incorrect|No, wrong account) on the (.*) page$""") {
    (data: String, url: String) =>
      if (url == "confirm-vat-details") {}
      CommonPage.checkUrl(url)
      CheckVatDetailsPage.selectChoice(data)
      CommonPage.clickContinue()
  }

  When("""^the user picks (Online Marketplace|Mixed|Not Online Marketplace) on the sales-on-marketplaces page$""") {
    answer: String =>
      CommonPage.checkUrl("sales-on-marketplaces")
      SalesChannelsPage.selectChoice(answer)
      CommonPage.clickContinue()
  }

  Then("""^the user sees the (pre|post) 10th version of the successful page$""") { (version: String) =>
    RegistrationPage.checkVersion(version)
  }

  Then("""^the user presses the (continue|submit) button$""") { (button: String) =>
    if (button == "submit") {
      CommonPage.clickSubmit()
    } else {
      CommonPage.clickContinue()
    }
  }

  Given("""the user clicks on the save and come back later button""") { () =>
    driver.findElement(By.id("saveProgress")).click()
  }

  Then("""^the user select the sign and come back later link""") { () =>
    driver.findElement(By.id("signOut")).click()
  }

  Then("""an error message is displayed as {string}""") { (errorMessage: String) =>
    errorMessage match {
      case "Enter a registration number in the correct format" =>
        assert(driver.findElement(By.id("value-error")).getText.contains(errorMessage))
      case "Enter a valid IOSS registration number"            =>
        assert(driver.findElement(By.id("previousSchemeNumber-error")).getText.contains(errorMessage))
      case "Enter a valid intermediary identification number"  =>
        assert(driver.findElement(By.id("previousIntermediaryNumber-error")).getText.contains(errorMessage))
      case "Enter your IOSS registration number"               =>
        assert(driver.findElement(By.id("previousSchemeNumber-error")).getText.contains(errorMessage))
      case "Enter your intermediary number"                    =>
        assert(driver.findElement(By.id("previousIntermediaryNumber-error")).getText.contains(errorMessage))
      case _                                                   =>
        throw new Exception("Error message doesn't exist")
    }
  }

  Then("""^the commencement date is set to the first day of the next quarter$""") { () =>
    val firstDayOfNextQuarter = CommonPage.getNextQuarterCommencementDate().format(dateFormatter)

    val htmlBody = driver.findElement(By.tagName("body")).getText
    Assert.assertTrue(
      htmlBody.contains(s"You must include all eligible sales from $firstDayOfNextQuarter in your first return.")
    )
    Assert.assertTrue(
      htmlBody.contains(
        s"If you make your first sale before $firstDayOfNextQuarter you must update your registration to tell us."
      )
    )
  }

  Then("""^the user is redirected to the email intercept page$""") { () =>
    checkInterceptPage()
  }

  Then("""^the user clicks the Confirm email address button$""") { () =>
    CommonPage.clickContinue()
  }

  Then("""^the user is redirected to the Business contact details page within Change your registration$""") { () =>
    checkBusinessContactDetails()
  }

  When("""^the user has been directed to the (registration|rejoin) quarantine page$""") { (registrationType: String) =>
    val currentYear = LocalDate.now().getYear
    if (registrationType == "registration") {
      CommonPage.checkUrl(s"other-country-excluded-and-quarantined?countryCode=EE&exclusionDate=$currentYear-01-01")
    } else {
      CommonPage.checkUrl(s"cannot-rejoin-quarantined-country?countryCode=EE&exclusionDate=$currentYear-01-01")

    }
  }

}
