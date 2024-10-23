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

import io.cucumber.datatable.DataTable
import org.junit.Assert
import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.pages.CommonPage.clickBackButton
import uk.gov.hmrc.test.ui.pages._

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class RegistrationStepDef extends BaseStepDef {

  val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy")

  Given("^the user accesses the service$") { () =>
    CommonPage.goToStartOfJourney()
  }
  Given("^the user accesses the continue on sign in url$") { () =>
    CommonPage.goToContinueOnSignInPage()
  }
  Given("^the user accesses the external service$") { () =>
    CommonPage.goToStartOfExternalJourney()
  }

  When("""^the user manually navigates to the (.*) link$""") { (link: String) =>
    CommonPage.navigateToBtaLink(link)
  }

  Given("""the user accesses the stub url""") { () =>
    CommonPage.goToStartOfJourneyFromStub()
  }

  Given("a user is signed in") { () =>
    AuthPage.signIn()
  }

  Given("^the user signs in as an Organisation Admin with VAT enrolment (.*) and strong credentials$") {
    (vrn: String) =>
      AuthActions.loginUsingScpStub("Organisation", vrn)
      AuthActions.selectMfaSuccess()

  }
  Given(
    "^the user signs in as an Organisation Admin with Hmrc Mdt and OSS VAT enrolment (.*) and strong credentials$"
  ) { (vrn: String) =>
    AuthActions.loginUsingAuthorityWizard("user", "Organisation", vrn, withOssEnrolment = true, "registration")
  }

  Given(
    "^the (user|assistant) signs in as an Organisation Admin with Hmrc Mdt VAT enrolment (.*) and strong credentials via authwiz$"
  ) { (user: String, vrn: String) =>
    AuthActions.loginUsingAuthorityWizard(user, "Organisation", vrn, withOssEnrolment = false, "registration")
  }

  When("""^a (non-registered|registered) user with VRN (.*) accesses the (amend|rejoin) registration journey""") {
    (registrationStatus: String, vrn: String, journey: String) =>
      CommonPage.goToStartOfJourneyFromStub()
      var withOssEnrolment = true
      if (registrationStatus == "non-registered") {
        withOssEnrolment = false
      }
      AuthActions.loginUsingAuthorityWizard("user", "Organisation", vrn, withOssEnrolment, journey)
  }

  When("""^a registered user with VRN (.*) accesses the returns service""") { (vrn: String) =>
    CommonPage.goToStartOfJourneyFromStub()
    AuthActions.loginUsingAuthorityWizard("user", "Organisation", vrn, true, "returns")
  }

  When("""^the user enters (.*) on the (.*) page$""") { (data: String, url: String) =>
    CommonPage.checkUrl(url)
    CommonPage.enterData(data)
  }
  And("""^the user inputs ioss reg number (.*) on the (.*) page$""") { (iossNumber: String, url: String) =>
    CommonPage.checkUrl(url)
    CommonPage.enterTheIossNumbers(iossNumber)

  }
  And("""^the user inputs intermediary identification number (.*) on the (.*) page$""") {
    (intermediaryNumber: String, url: String) =>
      CommonPage.checkUrl(url)
      CommonPage.enterTheIntermediaryIdentificationNumber(intermediaryNumber)

  }
  When("""^the user (adds|amends) (.*) on the (first|second|third) (.*) page$""") {
    (mode: String, data: String, index: String, url: String) =>
      index match {
        case "first"  => CommonPage.checkUrl(url + "/1")
        case "second" => CommonPage.checkUrl(url + "/2")
        case "third"  => CommonPage.checkUrl(url + "/3")
        case _        => throw new Exception("Index doesn't exist")
      }
      if (mode == "amends") {
        driver.findElement(By.id("value")).clear()
      }
      CommonPage.enterData(data)
  }
  When("""^the user add (.*) on the (first|second|fifth|sixth) (.*) page$""") {
    (data: String, index: String, url: String) =>
      index match {
        case "first"  => CommonPage.checkUrl(url + "/1" + "/1")
        case "second" => CommonPage.checkUrl(url + "/2" + "/2")
        case "fifth"  => CommonPage.checkUrl(url + "/5" + "/2")
        case "sixth"  => CommonPage.checkUrl(url + "/6" + "/1")
        case _        => throw new Exception("Index doesn't exist")
      }
      CommonPage.enterData(data)

  }

  When("""^the user selects (.*) on the (first|second|third|fifth|sixth) (.*) page$""") {
    (data: String, index: String, url: String) =>
      index match {
        case "first"  => CommonPage.checkUrl(url + "/1")
        case "second" => CommonPage.checkUrl(url + "/2")
        case "third"  => CommonPage.checkUrl(url + "/3")
        case "fifth"  => CommonPage.checkUrl(url + "/5")
        case "sixth"  => CommonPage.checkUrl(url + "/6")
        case _        => throw new Exception("Index doesn't exist")
      }
      CommonPage.selectValueAutocomplete(data)
  }

  When("""^the user chooses (yes|no) on the (first|second) (.*) page$""") {
    (data: String, index: String, url: String) =>
      index match {
        case "first"  => CommonPage.checkUrl(url + "/1")
        case "second" => CommonPage.checkUrl(url + "/2")
        case _        => throw new Exception("Index doesn't exist")
      }
      CommonPage.selectAnswer(data)
  }

  When("""^the user clicks continue on the (first|second) (.*) page$""") { (index: String, url: String) =>
    index match {
      case "first"  => CommonPage.checkUrl(url + "/1")
      case "second" => CommonPage.checkUrl(url + "/2")
      case _        => throw new Exception("Index doesn't exist")
    }
    CommonPage.clickContinue()
  }

  When("^the user clicks through the (.*) page$") { (url: String) =>
    CommonPage.checkUrl(url)
    CommonPage.clickContinue()
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
    CommonPage.clearDate()
    CommonPage.enterDate(
      dateOfFirstSale.getDayOfMonth.toString,
      dateOfFirstSale.getMonthValue.toString,
      dateOfFirstSale.getYear.toString
    )
    CommonPage.clickContinue()
  }

  When("^the (.*) page displays a commencement date of (today|yesterday)$") { (url: String, day: String) =>
    var date          = LocalDate.now()
    if (day == "yesterday") {
      date = date.minusDays(1)
    }
    val htmlBody      = driver.findElement(By.tagName("body")).getText
    val startDateText =
      "You must include all eligible sales from " + date.format(dateFormatter) + " in your first return."
    CommonPage.checkUrl("start-date")
    Assert.assertTrue(htmlBody.contains(startDateText))
  }

  When("""^the user answers (yes|no) on the (.*) page$""") { (data: String, url: String) =>
    CommonPage.checkUrl(url)
    CommonPage.selectAnswer(data)

  }
  When("""^the user answer (oss|ioss) on the (.*) page$""") { (data: String, url: String) =>
    CommonPage.checkUrl(url)
    CommonPage.selectAnswerAs(data)
  }

  When("""^the user answer (fixed establishment|dispatch warehouse) on the (.*) page$""") {
    (data: String, url: String) =>
      CommonPage.checkUrl(url)
      CommonPage.selectOperationAs(data)
  }
  When("""^the user answer (vat number|tax id number) on the (.*) page$""") { (data: String, url: String) =>
    CommonPage.checkUrl(url)
    CommonPage.selectSortOfRegistrationAs(data)
  }
  When("""^the user answers (oss|ioss) on the (.*) page$""") { (data: String, url: String) =>
    CommonPage.checkUrl(url)
    CommonPage.selectAnswerAs(data)

  }

  When("""^the user select (yes|No,delete my answers and start again) on the (.*) page$""") {
    (data: String, url: String) =>
      if (url == "continue-registration") {}
      CommonPage.checkUrl(url)
      CommonPage.selectContinueRegistration(data)

  }

  Then("""^the user should be on the (.*) page$""") { (url: String) =>
    CommonPage.checkUrl(url)
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
    val journeyId = driver.getCurrentUrl.split("/")(5)

    CommonPage.goToEmailVerificationPasscodeGeneratorUrl()

    val passcode = driver.findElement(By.tagName("body")).getText.split(">")(3).dropRight(3)
    CommonPage.goToEmailVerificationUrl(journeyId)
    driver.findElement(By.id("passcode")).sendKeys(passcode)
    driver.findElement(By.className("govuk-button")).click()
  }

  Then("""^the user is at the (.*) page$""") { (url: String) =>
    CommonPage.checkUrl(url)
  }

  Then("""^the user submits their registration$""") { () =>
    CommonPage.submitRegistration()
    CommonPage.checkUrl("successful")
  }
  Then("""^the user selects the register button$""") { () =>
    CommonPage.submitRegistration()
  }

  When("^the user chooses No on the Already Made Sales page$") { () =>
    CommonPage.checkUrl("alreadyMadeSales")
    AlreadyMadeSalesPage.selectNo()
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
    CommonPage.checkVersion(version)
  }
  Then("""^the user sees the (back to your account) button$""") { (button: String) =>
    CommonPage.checkButton(button)
  }

  Then("""^the user clicks on the (.*) link$""") { (link: String) =>
    link match {
      case "BTA"                                    =>
        driver.findElement(By.id("back-to-your-account")).click()
      case "continue to complete your registration" =>
        driver.findElement(By.cssSelector("a#continueToYourReturn")).click()
      case "sign out and come back later"           =>
        driver.findElement(By.xpath("/*[@id=‘signOut’]")).click()
      case "continue to your account"               =>
        driver.findElement(By.xpath("//*[@id='main-content']/div/div/div[1]/a"))
      case "try again later"                        =>
        driver.findElement(By.xpath("/html/body/div/main/div/div/p[1]/a")).click()
      case "back to your account"                   =>
        driver.findElement(By.id("backToYourAccount")).click()
      case "Change your registration"               =>
        driver.findElement(By.id("change-your-registration")).click()
      case "Returns account"                        =>
        driver.findElement(By.id("back-to-your-account")).click()
      case "cancel"                                 =>
        driver.findElement(By.id("cancel")).click()
      case _                                        =>
        throw new Exception("Link doesn't exist")
    }

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

  When("""^the user amends answer to (.*)$""") { (answer: String) =>
    driver.findElement(By.id("value")).clear()
    CommonPage.enterData(answer)
  }

  Then("""^the user is presented with the problem page$""") { () =>
    val htmlHeader = driver.findElement(By.tagName("h1")).getText
    Assert.assertTrue(htmlHeader.equals("Sorry, there is a problem with the service"))
  }

  Then("""^the commencement date is set to the first day of the next quarter$""") { () =>
    val firstDayOfNextQuarter = CommonPage.getNextQuarterCommencementDate().format(dateFormatter)

    val htmlBody = driver.findElement(By.tagName("body")).getText
    Assert.assertTrue(
      htmlBody.contains(s"You must include all eligible sales from $firstDayOfNextQuarter in your first return.")
    )
    Assert.assertTrue(
      htmlBody.contains(
        s"If you make your first sale before $firstDayOfNextQuarter you must amend your registration to tell us."
      )
    )
  }

  When("""^the user manually navigates to the (.*) page$""") { (page: String) =>
    CommonPage.navigateToPage(page)
  }

  Then("""^the user clicks back on the browser$""") { () =>
    clickBackButton()
  }

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
    Assert.assertTrue(htmlBody.contains("EU tax details removed Republic of Cyprus"))
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
    Assert.assertTrue(htmlBody.contains("EU tax details removed Republic of Cyprus"))
    Assert.assertTrue(htmlBody.contains("Netherlands"))
    Assert.assertTrue(htmlBody.contains("Romania"))
    Assert.assertTrue(htmlBody.contains("Sell goods online No"))
    Assert.assertTrue(htmlBody.contains("Trading websites removed www.onewebsite.co.uk"))
    Assert.assertTrue(htmlBody.contains("www.website2.org.uk"))
  }

  Then("""^the confirmation of a removed fixed establishment is displayed$""") { () =>
    val htmlBody = driver.findElement(By.tagName("body")).getText
    Assert.assertTrue(htmlBody.contains("You changed the following details:"))
    Assert.assertTrue(htmlBody.contains("EU tax details removed Republic of Cyprus"))
  }

}
