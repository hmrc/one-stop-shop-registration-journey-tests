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

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import io.cucumber.datatable.DataTable
import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.pages._
import play.api.libs.json.{JsSuccess, Json}
import uk.gov.hmrc.test.ui.models.Passcode

import java.time.LocalDate

class RegistrationStepDef extends BaseStepDef {

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
    AuthActions.loginUsingAuthorityWizard("Organisation", vrn)

  }
  When("""^the user enters (.*) on the (.*) page$""") { (data: String, url: String) =>
    CommonPage.checkUrl(url)
    CommonPage.enterData(data)
  }

  When("""^the user adds (.*) on the (first|second) (.*) page$""") { (data: String, index: String, url: String) =>
    index match {
      case "first"  => CommonPage.checkUrl(url + "/1")
      case "second" => CommonPage.checkUrl(url + "/2")
      case _        => throw new Exception("Index doesn't exist")
    }
    CommonPage.enterData(data)
  }
  When("""^the user add (.*) on the (first|second) (.*) page$""") { (data: String, index: String, url: String) =>
    index match {
      case "first"  => CommonPage.checkUrl(url + "/1" + "/1")
      case "second" => CommonPage.checkUrl(url + "/2" + "/2")
      case _        => throw new Exception("Index doesn't exist")
    }
    CommonPage.enterData(data)
  }

  When("""^the user selects (.*) on the (first|second) (.*) page$""") { (data: String, index: String, url: String) =>
    index match {
      case "first"  => CommonPage.checkUrl(url + "/1")
      case "second" => CommonPage.checkUrl(url + "/2")
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

  When("^the user enters a date inside the notification period for date of first sale$") { () =>
    val today = LocalDate.now().minusDays(1)
    CommonPage.checkUrl("date-of-first-sale")
    CommonPage.enterDate(today.getDayOfMonth.toString, today.getMonthValue.toString, today.getYear.toString)
  }

  When("""^the user answers (yes|no) on the (.*) page$""") { (data: String, url: String) =>
    CommonPage.checkUrl(url)
    CommonPage.selectAnswer(data)

  }
  When("""^the user answer (oss|ioss) on the (.*) page$""") { (data: String, url: String) =>
    CommonPage.checkUrl(url + "/1" + "/1")
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

  When("""^the user completes details on the (.*) page$""") { (url: String, dataTable: DataTable) =>
    CommonPage.checkUrl(url)
    CommonPage.completeForm(dataTable)
  }

  And("""the user completes the email verification process""") { () =>
    val journeyId = driver.getCurrentUrl.split("/")(5)

    CommonPage.goToEmailVerificationPasscodeGeneratorUrl()

    val data = driver.findElement(By.tagName("body")).getText
    val js   = Json.parse(data)

    (js \ "passcodes").validate[Seq[Passcode]] match {
      case JsSuccess(passcode +: _, _) =>
        CommonPage.goToEmailVerificationUrl(journeyId)
        CommonPage.enterData(passcode.passcode, inputId = "passcode")

        driver
          .navigate()
          .to(
            "http://localhost:10200/pay-vat-on-goods-sold-to-eu/northern-ireland-register/bank-details"
          )
      case _                           => fail("No passcode found")
    }

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
      case _                                        =>
        throw new Exception("Link doesn't exist")
    }

  }

  Then("""^the user presses the continue button$""") { () =>
    driver.findElement(By.id("continue")).click()
  }
  Given("""the user clicks on the save and come back later button""") { () =>
    driver.findElement(By.id("saveProgress")).click()
  }
  Then("""^the user select the sign and come back later link""") { () =>
    driver.findElement(By.id("signOut")).click()
  }

}
