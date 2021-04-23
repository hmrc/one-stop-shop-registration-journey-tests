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

import java.sql.Driver

import org.openqa.selenium.{By, WebDriver}
import org.scalatest.concurrent.Eventually
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.driver.BrowserDriver

object AuthPage extends BasePage with BrowserDriver with Eventually {

  val url: String = TestConfiguration.url("auth-login-stub") + "/gg-sign-in"
  val title       = "Authority Wizard"

  def signIn(endUrl: String): Unit = {

    driver.navigate().to(url)

    driver.findElement(By.name("redirectionUrl")).clear()
    driver.findElement(By.name("redirectionUrl")).sendKeys(RegisteredCompanyNamePage.url + endUrl)
    driver.findElement(By.cssSelector("Input[value='Submit']")).click()

    eventually {
      driver.getCurrentUrl should be(RegisteredCompanyNamePage.url + "/registeredCompanyName")
    }
  }

}