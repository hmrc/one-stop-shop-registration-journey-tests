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
import uk.gov.hmrc.test.ui.driver.BrowserDriver

object BankDetailsPage extends BrowserDriver {

  def addBankDetails(): CheckYourAnswersPage.type = {
    CommonPage.checkUrl("bank-details")
    driver.findElement(By.id("accountName")).sendKeys("Account Name")
    driver.findElement(By.id("bic")).sendKeys("ABCDEF2A")
    driver.findElement(By.id("iban")).sendKeys("GB33BUKB20201555555555")
    driver.findElement(By.cssSelector(".govuk-button")).click()
    CommonPage.checkUrl("check-answers")
    CheckYourAnswersPage
  }
}
