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

import org.junit.Assert
import org.openqa.selenium.By
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.selenium.component.PageObject
import uk.gov.hmrc.selenium.webdriver.Driver

object RegistrationPage extends PageObject with Matchers {

  def enterTheIossNumbers(iossNumber: String): Unit = {
    sendKeys(By.id("previousSchemeNumber"), iossNumber)
    CommonPage.clickContinue()
  }

  def enterTheIntermediaryIdentificationNumber(intermediaryNumber: String): Unit =
    sendKeys(By.id("previousIntermediaryNumber"), intermediaryNumber)

  def selectAnswerAs(data: String): Unit = {
    data match {
      case "oss"  => click(By.id("value_0"))
      case "ioss" => click(By.id("value_1"))
      case _      => throw new Exception("Option doesn't exist")
    }
    CommonPage.clickContinue()
  }

  def selectSortOfRegistrationAs(data: String): Unit = {
    data match {
      case "vat number"    => click(By.id("value_0"))
      case "tax id number" => click(By.id("value_1"))
      case _               => throw new Exception("Option doesn't exist")
    }
    CommonPage.clickContinue()
  }

  def selectOperationAs(data: String): Unit = {
    data match {
      case "fixed establishment" => click(By.id("value_0"))
      case "dispatch warehouse"  => click(By.id("value_1"))
      case _                     => throw new Exception("Option doesn't exist")
    }
    CommonPage.clickContinue()
  }

  def selectContinueRegistration(data: String): Unit = {
    data match {
      case "yes"                                  => click(By.id("continueProgress"))
      case "No,delete my answers and start again" => click(By.id("deleteProgress"))
      case _                                      => throw new Exception("Option doesn't exist")
    }
    CommonPage.clickContinue()
  }

  def checkVersion(version: String): Unit = {
    val htmlBody     = Driver.instance.findElement(By.tagName("body")).getText
    val post10thText = "You registered after the 10th day of the next month following your first eligible sale."
    version match {
      case "pre"  => Assert.assertFalse(htmlBody.contains(post10thText))
      case "post" => Assert.assertTrue(htmlBody.contains(post10thText))
      case _      => throw new Exception("Version doesn't exist")
    }
  }

}
