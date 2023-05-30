/*
 * Copyright 2023 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.cucumber.utils

import org.mongodb.scala.MongoClient
import org.mongodb.scala.bson.collection.immutable.Document
import org.mongodb.scala.model.Filters

import scala.concurrent.Await
import scala.concurrent.duration._

object MongoConnection {

  private val timeout: FiniteDuration = 10.seconds

  private val mongoClient: MongoClient = MongoClient()

  sys.addShutdownHook {
    mongoClient.close()
  }

  def dropRecord(db: String, collection: String, vrn: String): Unit =
    try Await.result(
      mongoClient
        .getDatabase(db)
        .getCollection(collection)
        .deleteMany(filter = Filters.equal("vrn", vrn))
        .head(),
      timeout
    )
    catch {
      case e: Exception => println("Error: " + e)
    }

  def insert(source: List[String], database: String, collection: String): Unit =
    try {
      val db  = mongoClient.getDatabase(database)
      val col = db.getCollection(collection)
      source.map { e =>
        val doc = Document(e)
        Await.result(
          col.insertOne(doc).toFutureOption(),
          timeout
        )
      }
    } catch {
      case ex: Exception => println(s"Error inserting data into MongoDB: $ex")
    }

  def dropRegistrations(): Unit = {
    dropRecord("one-stop-shop-registration", "registrations", "100000001")
    dropRecord("one-stop-shop-registration", "registrations", "100000002")
    dropRecord("one-stop-shop-registration", "registrations", "100000003")
    dropRecord("one-stop-shop-registration", "registrations", "123456789")
    dropRecord("one-stop-shop-registration", "registrations", "777777771")
    dropRecord("one-stop-shop-registration", "registrations", "777777778")
    dropRecord("one-stop-shop-registration", "registrations", "777777779")
    dropRecord("one-stop-shop-registration", "registrations", "222222223")
    dropRecord("one-stop-shop-registration", "registrations", "300000001")
    dropRecord("one-stop-shop-registration", "registrations", "300000002")
    dropRecord("one-stop-shop-registration", "registrations", "300000003")
    dropRecord("one-stop-shop-registration", "registrations", "600000022")
  }
  def dropSavedAnswers(): Unit = {
    dropRecord("one-stop-shop-registration", "saved-user-answers", "100000001")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "222222222")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "222222223")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "222222233")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "100000002")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "100000003")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "100000004")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "100000005")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "444444444")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "666000001")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "666000004")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "123456789")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "777777771")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "777777778")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "777777779")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "300000001")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "300000002")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "300000003")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "600000022")
  }
}
