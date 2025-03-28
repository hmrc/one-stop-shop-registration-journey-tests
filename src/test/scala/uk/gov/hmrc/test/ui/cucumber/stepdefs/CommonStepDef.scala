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

import org.junit.Assert
import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.pages.CommonPage.clickBackButton
import uk.gov.hmrc.test.ui.pages._

class CommonStepDef extends BaseStepDef {

  Given("^the user accesses the service$") { () =>
    CommonPage.goToStartOfJourney()
  }
  Given("^the user accesses the continue on sign in url$") { () =>
    CommonPage.goToContinueOnSignInPage()
  }

  When("""^the user enters (.*) on the (.*) page$""") { (data: String, url: String) =>
    CommonPage.checkUrl(url)
    CommonPage.enterData(data)
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

  When("""^the user answers (yes|no) on the (.*) page$""") { (data: String, url: String) =>
    CommonPage.checkUrl(url)
    CommonPage.selectAnswer(data)
  }

  Then("""^the user is at the (.*) page$""") { (url: String) =>
    CommonPage.checkUrl(url)
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

  When("""^the user amends answer to (.*)$""") { (answer: String) =>
    driver.findElement(By.id("value")).clear()
    CommonPage.enterData(answer)
  }

  Then("""^the user is presented with the problem page$""") { () =>
    val htmlHeader = driver.findElement(By.tagName("h1")).getText
    Assert.assertTrue(htmlHeader.equals("Sorry, there is a problem with the service"))
  }

  When("""^the user manually navigates to the (.*) page$""") { (page: String) =>
    CommonPage.navigateToPage(page)
  }

  Then("""^the user clicks back on the browser$""") { () =>
    clickBackButton()
  }

  Then(
    """^the user clicks (remove|change) via list for (first|second|third) (.*)$"""
  ) { (action: String, index: String, page: String) =>
    val indexNumber = index match {
      case "first"  => "1"
      case "second" => "2"
      case "third"  => "3"
      case _        => throw new Exception("Index doesn't exist")
    }
    if (action == "remove") {
      CommonPage.selectLink(s"remove-$page\\/$indexNumber")
    } else {
      CommonPage.selectLink(s"$page\\/$indexNumber")
    }
  }

}
