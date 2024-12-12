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

import org.junit.Assert
import org.openqa.selenium.By
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.test.ui.driver.BrowserDriver

object RegistrationPage extends BrowserDriver with Matchers {

  def enterTheIossNumbers(iossNumber: String): Unit =
    driver.findElement(By.id("previousSchemeNumber")).sendKeys(iossNumber)

  def enterTheIntermediaryIdentificationNumber(intermediaryNumber: String): Unit = {
    driver.findElement(By.id("previousIntermediaryNumber")).sendKeys(intermediaryNumber)
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

  def checkVersion(version: String): Unit = {
    val htmlBody     = driver.findElement(By.tagName("body")).getText
    val post10thText = "You registered after the 10th day of the next month following your first eligible sale."
    version match {
      case "pre"  => Assert.assertFalse(htmlBody.contains(post10thText))
      case "post" => Assert.assertTrue(htmlBody.contains(post10thText))
      case _      => throw new Exception("Version doesn't exist")
    }
  }

}
