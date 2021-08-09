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

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import uk.gov.hmrc.test.ui.pages.CheckYourAnswersPage

class CheckYourAnswersStepDef extends BaseStepDef {

  And("the user changes answers to yes and is redirected accordingly to add further answers") { () =>
    CheckYourAnswersPage
      .changeUkTradingName()
      .hasDifferentTradingName()
      .addTradingName("Foo One")
      .addAnotherTradingName("no")
      .changeTaxInEu()
      .hasEuRegistration()
      .addCountryRegisteredForTaxInEu("France")
      .registeredForVat("FR123456789")
      .withoutFixedEstablishment
      .headingText("France")
      .continueEu
      .anotherBusinessRegisteredForTaxInEu
      .addCountryRegisteredForTaxInEu("Germany")
      .registeredForVat("DE123456789")
      .withFixedEstablishment
      .addTradingName("EU Trading Name")
      .addFixedEstablishmentAddress
      .headingText("Germany")
      .changeVatRegistered
      .notRegisteredForVat
      .addTaxIdentificationNumber
      .continueToCheckAddTaxDetailsPage
      .continuesToCheckYourAnswersPage
      .changeDeregistrationDetails
      .addDeregisteredCountryDetails
      .continuesToCheckYourAnswersPage
      .giveWebsiteAddress
      .addWebsiteAddress("www.example1.com")
      .addAnotherWebsiteAddress
      .addWebsiteAddress("www.example2.com")
      .websiteAddressCount(2)
      .removeWebsiteAddress(2)
      .chooseToNotAddAnotherWebsiteAddress()
  }
}
