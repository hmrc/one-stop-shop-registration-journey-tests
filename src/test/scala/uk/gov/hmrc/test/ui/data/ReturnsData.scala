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

package uk.gov.hmrc.test.ui.data

object ReturnsData {
  val data: List[String] =
    List(
      s"""
         |{
         |    "_id" : ObjectId("664b1393c247ad7d5113dd27"),
         |    "vrn" : "600000019",
         |    "period" : {
         |        "year" : 2024,
         |        "quarter" : "Q1"
         |    },
         |    "reference" : "XI/XI600000019/Q1.2024",
         |    "paymentReference" : "NI600000019Q124",
         |    "startDate" : "2024-01-01",
         |    "endDate" : "2024-03-31",
         |    "salesFromNi" : [],
         |    "salesFromEu" : [],
         |    "submissionReceived" : "2024-05-20T09:10:43.575816Z",
         |    "lastUpdated" : "2024-05-20T09:10:43.575816Z"
         |}
         |""".stripMargin,
      s"""
         |{
         |    "_id" : ObjectId("667055088cdf2464e97cfdc2"),
         |    "vrn" : "100000301",
         |    "period" : {
         |        "year" : 2024,
         |        "quarter" : "Q1"
         |    },
         |    "reference" : "XI/XI100000301/Q1.2024",
         |    "paymentReference" : "NI100000301Q124",
         |    "startDate" : "2024-01-01",
         |    "endDate" : "2024-03-31",
         |    "salesFromNi" : [],
         |    "salesFromEu" : [],
         |    "submissionReceived" : "2024-06-17T15:23:52.132138Z",
         |    "lastUpdated" : "2024-06-17T15:23:52.132139Z"
         |}
         |""".stripMargin,
      s"""
         |{
         |    "_id" : ObjectId("667143a08cdf2464e97cfdc3"),
         |    "vrn" : "600000050",
         |    "period" : {
         |        "year" : 2024,
         |        "quarter" : "Q1"
         |    },
         |    "reference" : "XI/XI600000050/Q1.2024",
         |    "paymentReference" : "NI600000050Q124",
         |    "startDate" : "2024-01-01",
         |    "endDate" : "2024-03-31",
         |    "salesFromNi" : [],
         |    "salesFromEu" : [],
         |    "submissionReceived" : "2024-06-18T08:21:52.700312Z",
         |    "lastUpdated" : "2024-06-18T08:21:52.700313Z"
         |}
         |""".stripMargin,
      s"""
         |{
         |    "_id" : ObjectId("6683ce68f8ba07271a9969f7"),
         |    "vrn" : "500000002",
         |    "period" : {
         |        "year" : 2024,
         |        "quarter" : "Q1"
         |    },
         |    "reference" : "XI/XI500000002/Q1.2024",
         |    "paymentReference" : "NI500000002Q124",
         |    "startDate" : "2024-01-01",
         |    "endDate" : "2024-03-31",
         |    "salesFromNi" : [],
         |    "salesFromEu" : [],
         |    "submissionReceived" : "2024-07-02T09:54:46.918713Z",
         |    "lastUpdated" : "2024-07-02T09:54:46.918713Z"
         |}
         |""".stripMargin,
      s"""
         |{
         |    "_id" : ObjectId("668d4672f8ba07271a9969ff"),
         |    "vrn" : "600000003",
         |    "period" : {
         |        "year" : 2024,
         |        "quarter" : "Q1"
         |    },
         |    "reference" : "XI/XI600000003/Q1.2024",
         |    "paymentReference" : "NI600000003Q124",
         |    "startDate" : "2024-01-01",
         |    "endDate" : "2024-03-31",
         |    "salesFromNi" : [],
         |    "salesFromEu" : [],
         |    "submissionReceived" : "2024-07-09T14:17:22.201312Z",
         |    "lastUpdated" : "2024-07-09T14:17:22.201312Z"
         |}
         |""".stripMargin,
      s"""
         |{
         |    "_id" : ObjectId("668bfa27f8ba07271a9969f8"),
         |    "vrn" : "333333222",
         |    "period" : {
         |        "year" : 2024,
         |        "quarter" : "Q1"
         |    },
         |    "reference" : "XI/XI333333222/Q1.2024",
         |    "paymentReference" : "NI333333222Q124",
         |    "startDate" : "2024-01-01",
         |    "endDate" : "2024-03-31",
         |    "salesFromNi" : [],
         |    "salesFromEu" : [],
         |    "submissionReceived" : "2024-07-08T14:39:34.880640Z",
         |    "lastUpdated" : "2024-07-08T14:39:34.880641Z"
         |}
         |""".stripMargin,
      s"""
         |{
         |    "_id" : ObjectId("668bfd77f8ba07271a9969f9"),
         |    "vrn" : "333333111",
         |    "period" : {
         |        "year" : 2024,
         |        "quarter" : "Q1"
         |    },
         |    "reference" : "XI/XI333333111/Q1.2024",
         |    "paymentReference" : "NI333333111Q124",
         |    "startDate" : "2024-01-01",
         |    "endDate" : "2024-03-31",
         |    "salesFromNi" : [],
         |    "salesFromEu" : [],
         |    "submissionReceived" : "2024-07-08T14:53:43.458510Z",
         |    "lastUpdated" : "2024-07-08T14:53:43.458511Z"
         |}
         |""".stripMargin,
      s"""
         |{
         |    "_id" : ObjectId("668bfffcf8ba07271a9969fa"),
         |    "vrn" : "333333666",
         |    "period" : {
         |        "year" : 2024,
         |        "quarter" : "Q1"
         |    },
         |    "reference" : "XI/XI333333666/Q1.2024",
         |    "paymentReference" : "NI333333666Q124",
         |    "startDate" : "2024-01-01",
         |    "endDate" : "2024-03-31",
         |    "salesFromNi" : [],
         |    "salesFromEu" : [],
         |    "submissionReceived" : "2024-07-08T15:04:28.859479Z",
         |    "lastUpdated" : "2024-07-08T15:04:28.859479Z"
         |}
         |""".stripMargin,
      s"""
         |{
         |    "_id" : ObjectId("668c0111f8ba07271a9969fb"),
         |    "vrn" : "333333444",
         |    "period" : {
         |        "year" : 2024,
         |        "quarter" : "Q1"
         |    },
         |    "reference" : "XI/XI333333444/Q1.2024",
         |    "paymentReference" : "NI333333444Q124",
         |    "startDate" : "2024-01-01",
         |    "endDate" : "2024-03-31",
         |    "salesFromNi" : [],
         |    "salesFromEu" : [],
         |    "submissionReceived" : "2024-07-08T15:09:05.174172Z",
         |    "lastUpdated" : "2024-07-08T15:09:05.174173Z"
         |}
         |""".stripMargin,
      s"""
         |{
         |    "_id" : ObjectId("668c0178f8ba07271a9969fc"),
         |    "vrn" : "333333777",
         |    "period" : {
         |        "year" : 2024,
         |        "quarter" : "Q1"
         |    },
         |    "reference" : "XI/XI333333777/Q1.2024",
         |    "paymentReference" : "NI333333777Q124",
         |    "startDate" : "2024-01-01",
         |    "endDate" : "2024-03-31",
         |    "salesFromNi" : [],
         |    "salesFromEu" : [],
         |    "submissionReceived" : "2024-07-08T15:10:48.803516Z",
         |    "lastUpdated" : "2024-07-08T15:10:48.803516Z"
         |}
         |""".stripMargin,
      s"""
         |{
         |    "_id" : ObjectId("668c01cef8ba07271a9969fd"),
         |    "vrn" : "333333555",
         |    "period" : {
         |        "year" : 2024,
         |        "quarter" : "Q1"
         |    },
         |    "reference" : "XI/XI333333555/Q1.2024",
         |    "paymentReference" : "NI333333555Q124",
         |    "startDate" : "2024-01-01",
         |    "endDate" : "2024-03-31",
         |    "salesFromNi" : [],
         |    "salesFromEu" : [],
         |    "submissionReceived" : "2024-07-08T15:12:14.179279Z",
         |    "lastUpdated" : "2024-07-08T15:12:14.179279Z"
         |}
         |""".stripMargin
    )
}
