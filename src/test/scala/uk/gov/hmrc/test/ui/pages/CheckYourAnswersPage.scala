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

import io.cucumber.datatable.DataTable
import org.openqa.selenium.By
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.selenium.component.PageObject

import scala.jdk.CollectionConverters._

object CheckYourAnswersPage extends PageObject with Matchers {

  def changeAnswers(dataTable: DataTable): Unit =
    dataTable.asMaps[String, String](classOf[String], classOf[String]).asScala.foreach { row =>
      val link = "change" + row.get("page").replace(" ", "")
      click(By.cssSelector(s"a[href*=$link]"))
      CommonPage.checkUrl(link)
      sendKeys(By.id("value"), "data")
      click(By.xpath("//*[@id='main-content']/div/div/form/button"))
    }

  def selectLink(link: String): Unit =
    click(By.cssSelector(s"a[href*='$link']"))
}
