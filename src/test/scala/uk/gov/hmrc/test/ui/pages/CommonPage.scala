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

import org.openqa.selenium.By
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.driver.BrowserDriver

object CommonPage extends BrowserDriver with Matchers {

  def constructUrl(prettyUrl: String): String =
    (prettyUrl.head.toLower + prettyUrl.tail).replace(" ", "")

  def checkUrl(url: String): Unit =
    driver.getCurrentUrl should endWith(constructUrl(url))

  def enterData(data: String): Unit = {
    val inputId = "value"
    driver.findElement(By.id(inputId)).sendKeys(data)
    driver.findElement(By.xpath("//*[@id='main-content']/div/div/form/button")).click()
  }

  def provideDate(date: String): Unit = {
    val day   = date.substring(1, 2)
    val month = date.substring(4, 5)
    val year  = date.substring(7, 10)
    driver.findElement(By.id("value.day")).sendKeys(day)
    driver.findElement(By.id("value.month")).sendKeys(month)
    driver.findElement(By.id("value.year")).sendKeys(year)
    driver.findElement(By.xpath("//*[@id='main-content']/div/div/form/button")).click()
  }

  def selectAnswer(data: String): Unit = {
    data match {
      case "yes" => driver.findElement(By.id("value")).click()
      case "no"  => driver.findElement(By.id("value-no")).click()
      case _     => throw new Exception("Option doesn't exist")
    }
    driver.findElement(By.xpath("//*[@id='main-content']/div/div/form/button")).click()
  }
}
