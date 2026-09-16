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

package uk.gov.hmrc.ui.data

import java.time.LocalDate

object RegistrationData {

  val yesterday = LocalDate.now().minusDays(1)

  val data: List[String] =
    List(
      s"""
         |{
         |  "_id": {
         |    "$$oid": "6aaa69a44e6882f28e453ea2"
         |  },
         |  "vrn": "600000008",
         |  "data": "UJZhjw6e8uvLn1gGb1M9z5cmoBvqSGnrd7uiDxM/M6aTu/EtxrFGybRRxj9gLKlfzflynMrgOe2g6QzIls8Uiuu+yss+EfLDYh8GgsQWt/zcTFSawnJZ7nT+GYD93lRwrGUFKmMEJUty6kTnuj87qvGAqyiTwEJ1yXwxHs1CyFL0rl1bWBTR+0H1LB0VMak6ZjBLTahIVEZCQvlgn+0tqcknXRvGzj2eisPJmW59xXG5t1MzBgE2/1r2AKR/SZ9EMgDkOS+TTCyeDTG6iR2BPaPPgBjQcTzn5dJu/BIcu3Ou9gKBSA7QbxUtlo3nLM6ojk23arfCBKom2wBJdb5Yrynx+cgBlVVL6+p5C/SyF0tkPYgfFSyl/vutSJuUWtTmCc8fJIr34un8oL456Idh90l5KuUw4OrZPD/aVB0xPrTbsHXB7zc=",
         |  "lastUpdated": {
         |    "$$date": "${yesterday}T10:04:20.412Z"
         |  }
         |}
         |""".stripMargin,
      s"""
         |{
         |  "_id": {
         |    "$$oid": "6aaa92114e6882f28e5e9f7a"
         |  },
         |  "vrn": "333333311",
         |  "data": "Ca6RDXoEH7WMes4egzWU1y/WEo11ZxZnx2ojK7HmezzX0MnTVGUW4seQGs8pppD3w1GH8f6Mvk4sMhsVxs4Dh+Jyk+GbHicmfWKFPNoYM3hFCkVOVJowVUPAIJg6qW+kaT9g9EWkUd1W0e9zsQQhqJ/2JJsrLJ2UIt4I/Cd71KjZI2tD50+Spqxhfae2jc2XRnbd9gGQ54H9rT78i4uS+9A9UELdnQ2BggGVeajDK5kggU5y6x8Zm/VGPrfm+5boYYaKpJABmeCtrpVT9i0+ao8Dv1BCxk+Jcy3Ng+/m1unThmc1DWfVGxFvWHCnodTOcq6ERgnKB0gS7tkE2WegQN7knxYQAK838HFaPXtmeNtwhXIxGiYIjWBaRe24kVuKokNNC2Y0egtF8f5ZUyth6RgxZxU0Vy9Ox5rphK9DZg==",
         |  "lastUpdated": {
         |    "$$date": "${yesterday}T12:56:49.202Z"
         |  }
         |}
         |""".stripMargin,
      s"""
         |{
         |  "_id": {
         |    "$$oid": "6aaa97544e6882f28e63f89b"
         |  },
         |  "vrn": "333333322",
         |  "data": "Dn4HwUBZuFQhJKmsSYTM9xQkcisc1hhjXtgBfDq8gYyCi6fLlEy8CK6d/V0zVKiuosiCcFrPV+0e5lVpTyqUXKlYYAO2UMBJbXVOLh037Z9dlZblPnfzJwOCfNGVe1XWTESPaL5TrEdr9/lwCITTgSD6T7VFtOQRRyfo5KEtWib1RKxQc9lgbvNoi3+6R7gwG/sDh/tNm7i5dSUDfsgbXueBMXH8NPlrJFvM0JjQGs+5q+clyw+13cUidHVOPqF4XgB3x/rMyer46jcLaP84wGV1TtMilaapcbpdMD/ZZB6jopdkz1nRWGAINJjyI1iVAX+mad45qv266dEAUArXomxWxHDor7J2H5moPPEGjWlHVdy2Coxx822P/VWRdeOoe83m9QQlDsS5SVaWTxow1dejsh3HjoWGuC0Xrk3JHVZ/b3ZwLnOdSELD1YWjgXwAJcQPMO7PSme72zPAy7e2ubbuHh1exjnxShtmYVT3asRqHjl4+VnSnBu8BG24K/zgyFvpsvk0X8s2KNMoqvlLampj7OnVem08NvSXPnazRythCqj6CpLsSXjuDzaPDVaSKVQ=",
         |  "lastUpdated": {
         |    "$$date": "${yesterday}T13:19:16.865Z"
         |  }
         |}
         |""".stripMargin,
      s"""
         |{
         |  "_id": {
         |    "$$oid": "6aaaabdb4e6882f28e78d17b"
         |  },
         |  "vrn": "100000101",
         |  "data": "DMO4UBrzzmhHEZVsuIh21KgWuMqxM0XEI4aVPfmkB9eT5fPefotFd59ZSeIjQXJwJUvWvi71dmgk7rJh33JL3tOACXuNdRemX/b1G/ikM2qq8B8ORgLQlB+5WedzZMHu2WQHUvaI1J8iNb2wupLgpx9SE6g2HJFdzFmShJuJmTzJZxnxbT8qimdbpecWvE4o2RcwXHqxeZzE33puzzy+Vsc2iO/yb3aWhEPbiUwgi17V79oVFH1zSyF+5deyK1gQ4dSfRBd26AiDNPwf+6d5/I1XCZmEN6PhD3IFZgHpHumBkHKZTKczeChfZE+3ReGqBQXLFjy/722TVycQPi0OJmucJFZiVCCkWjVAXiYCP+3iNsbQ+cl/GMWXdJ/EqzXHHi/3tT4IYAmiwFpyb+F2TKsZP8P2bNi9quLDtjTYXOAINx0L3Ngtn0V3RPm5w/V4mtrGRE3cDBror0pj0xKv1iPmulctxZc+DOmmz+lLAsX4XxYIxsiSzz1RD7A3REAryu6Hvt5XT5nFSGKHyGv13/JbOrbGNSi+SS3YB/8QDqrE4BT8fjxc1znMBEmnceMuSfzJftEWmqDt738ka+2CGVfoy4NkYMhon7xlS1rINOnD3eG2GVCFc02cyO1lEZefbQso9mqH6tvM4OQU7pdzi4ME+lkffQBiVKufJloR4gSZ4Ni1/BQH0ko8ybDP0Q4zGbKBuxkX+asNDbwr3O0q/Hx1N+n3nlbTo/Kr",
         |  "lastUpdated": {
         |    "$$date": "${yesterday}T14:46:50.914Z"
         |  }
         |}
         |""".stripMargin,
      s"""
         |{
         |  "_id": {
         |    "$$oid": "6aaab8eb4e6882f28e8617ee"
         |  },
         |  "vrn": "100000102",
         |  "data": "r3xqvyjSyzWwzD4RIqNG/YFQpA9bW25cvUCXpjr4QLSrJDFzsV6qLYB9RshIQs6s2Bo+zVtzrqGMo1n5Mnzmz12Fu4nCgX8tAwrIm7STluvuIe4tZ/wiUWj2FJ351myRQ+yqgLQAKWYHP71DP53ZK3oQc/NBNm3GPe0TCRtVOUO1sGMuuWLb58hOMCCkUkKhdd3Y0sB55zf1BQk72ukCbgA6o+gHMryUuRQfXPgFilYB7G/oMMkX0HMUBcZsJr+grUedW01zj3V5A4yLZ2LdlasgEq+aoAXYxBXLYK4psqspdfgPnRwY31v9iVZ+yn0RpvyWUb0jEdkewjdvRD/VYgQwvUBm7vVAjBXF7xK4nAlRWkTr+bbw2cvcqgnGVKJcMVmvJ+Vw69BeqjhLHkgLEQWR9aUQC2U05kV1eH6DYwsEbZX6TL3UK+Rcn/mnX3q5m+dKU26QQEet7huy9i5c6DahDzkRn5F+3iVCrcZLe/kJXrSF4g5evZSIiCvZv6gN5JPMPobQe9VxYin8P8+tMSrRzcr7bmzhs6mnMxXSTfy6Poror1I3Y3QihoATNEHYYOiZAdbGHdkTsNgFfqbLhOb4ju6hfy3smVUDQfkYvIo0H1jj9JSY4h/9BQhkM2xkSG+3i2Glkodd6OYRwpBy4U8T+bCdxWgFCOO0KqGTeaLedHce0gOOCmfhluhTBh7Ck0+GMPftnJ0T3jhQIMdT2onpt3Fbnfo0u8g2Hw==",
         |  "lastUpdated": {
         |    "$$date": "${yesterday}T15:42:35.150Z"
         |  }
         |}
         |""".stripMargin
    )
}
