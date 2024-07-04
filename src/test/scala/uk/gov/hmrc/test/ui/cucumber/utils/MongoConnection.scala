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

  def dropSavedAnswers(): Unit = {
    dropRecord("one-stop-shop-registration", "saved-user-answers", "100000600")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "300000001")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "300000002")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "300000003")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "600000022")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "777777771")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "100000001")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "100000002")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "777777779")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "777777778")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "666000004")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "222222223")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "222222233")
    dropRecord("one-stop-shop-registration", "saved-user-answers", "666000001")
  }

  def dropReturns(): Unit = {
    dropRecord("one-stop-shop-returns", "returns", "600000019")
    dropRecord("one-stop-shop-returns", "returns", "100000301")
    dropRecord("one-stop-shop-returns", "returns", "600000050")
    dropRecord("one-stop-shop-returns", "returns", "500000002")
  }
}
