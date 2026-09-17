/*
 * Copyright 2026 HM Revenue & Customs
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
         |""".stripMargin,
      s"""
         |{
         |  "_id": {
         |    "$$oid": "6aabb7624e6882f28ea80360"
         |  },
         |  "vrn": "100000103",
         |  "data": "tyJsSluYvyMdzgLanAmle9Dv95MLMxxDtz/CvqRu+Qdkzgio4rjl65YfS9vsRVY7iArX0LkovLitO/KaUoaBUxNBsagLffD6Lykxg4H6my7zT5/OFDK4Lp0uzr4Z6tf4kG27LWqi2UNbBGYvSTrVWw/HMA0yzNOEkc8E6a2KQovtQAmgOYidUwqEyvWZka1t3F0MYd8uS9AoJ8VvKlDwOR7fiXNBnMnsY+NQfX2pqi0JjTIs05o6hlhCfdSOAtKW7QEFjdcr8xv81Vo0V8ytlmNvIuzL96NWyUmdHutMBGldDPNTv8jwfAg6AhzN6asY8mKmVwFgliBZ0uXbIgFcA1a4nDwv9YNyHvMIKg4sirpQwEUgnXgRP5LIZ2iN6NA/xVJLVjhY7jNVdNxXEKssD0HGJ4JktNsO+2Q7PoBHrJyx4WYVvnSAZsS6n17SqhLpYunpYPnYLYvFcLwd2SsuYnvor6OhTS12nq75Z5x+/rb+WljXDqLTkSN5I8MNFkDoij0rko9nhijwzPkLeYXKxHQIzRObizrIp1Y4b0U6qAoVCx2OxOl0QtU6tpa1xXZKa0hz+H9fBipDOZZFZe7/KJbp12w8jGqvOHd7N2M0KiMabFJH1onZU0N8eJl22g9FWevv/SlajMZXI8Fv0mbBXdS+y+UnsD4WBX1V2ug9EIkLo1MAVAQGMPxjKGfEVCt/qWJMhqiMRsdhxxJ6/4cwjy26ZV17qtra1vuUBi/ha6PNo7dvF4uFfA+M4UFWxr04hzCedVQp",
         |  "lastUpdated": {
         |    "$$date": "${yesterday}T09:48:17.994Z"
         |  }
         |}
         |""".stripMargin,
      s"""
         |{
         |  "_id": {
         |    "$$oid": "6aabb8584e6882f28ea8ff67"
         |  },
         |  "vrn": "100000104",
         |  "data": "KV8yWo3hu9UPVudukHEHF986QC4cBK0vjak3eAHWRKQTwFoSO3PrmEKMuGhJGz9wXpYroPKfPra2mvgtHEzO/uDEEeaTuceAOnuZX5q84jdChUw9ptLIF2jp5OSqVu4QyYkWrPxHQkfxTP0htiBFqoLklsdnWznpUS6a2r1oELwrU8Gn1JmdBsQT6dahWwJK3r+oZCX9uJSrVoiqI4Pt6i/dRH9tcno8t60qW2gUslKU9PLpKEFDR1HFZXIpd0q8L0ZaJmmYGx2FYRlCcIXphd+eqPUkbG2NWoumio5IDGvn+e/w88H36oqxdZhy4weP+wJQn9MQDBwdu5JtJ6HaZvYz6NMQHaZz6TxfWJeT2w+KuTIfQYHXi+7XpTHRushYA5yckTQcPfm0WBXyEOujNmi/vse5JD0gG7ibjLOnytjTQBnBP3dS+K1sYXs6aXKtwLe5kdEqhEBuuMXo+sXlyxFlweX6huFMH+pZOvhODpnhoQNzpr1rCxJnV1K9nKPIC0Tcq0g0hfWiLOrQbNgEXsBa3zXEBtBs0qm09SRkoW25Y2nESod/3shql4NPvHqVtvi+Ohnk6sZzu6LOZbYAgjwxeBOyf0F0Fa48ZZyOLkNmYGBf6N+gW4eXS+raU9y/26CHbFS9iUQy+5CSmFMDZOTP7InCJewaoMYEFEgMUymfps2ROmBBxHq5PApJvJZPDF9WXFmzr4sJONmfW1hVA0OAyQQXLQ/fpMdN8OC2Gsi0JZwBntuaetuXRPOf4RyfcN4WxjDWPANoZ26nr6HyuJrOgCVD76cYv6SoaSWXsw0ojcK+POA=",
         |  "lastUpdated": {
         |    "$$date": "${yesterday}T09:52:24.920Z"
         |  }
         |}
         |""".stripMargin,
      s"""
         |{
         |  "_id": {
         |    "$$oid": "6aabda8b4e6882f28ebe9a72"
         |  },
         |  "vrn": "100000105",
         |  "data": "3X/3T1y0l392CRVJXlfMkKWFV4xPINsnVBRnNqfd+jrwsZxRHSQAI/RFmgussm/npyKXuuDBQ3K6MocFlD7JiveuKg59YvcoCsKvwHfXRZpSTMJB3EKe+4SdaSgfjt/i0/4p9b7dy/lB6Ses/n+p9vl1x6fVY8d3F78GMfON5pjuu7uurOMiC+9JVSz72sIjWcdUU3oGnDb2sa578PJpb8l68YpMTN0XW9DZyqSa1xrRvUWhDLSvPwA1syDLcEb+I9JbTlLTx1dyPgH3pJKv4fVs5LxQrLpI0lwhXbeSP4JkSBG6ppWu0bhw0BcJZW9kjuQWFqzL4AAUerfC7qku/x0Du/nwZRq00lzS5WhCwWZqAh9fb4YQ/TXSHQcox6gSp1QzHHH9IzZrW7ZHymhe3ODPFYvkXcRiouoCaikJK/n+gerXOqbHVQ267ENIYV/MHOTbc+0nGF1XUoQxNerPRSRbAd7r3monoYDHYiXPRJ0QlhBTYIVQzHhPU6JsP1YJYrUzPAImebzWjyCRU35BdAk1TiSi78vACU9rm5+E6UqUwGwF7CMbf7g4k9/T4wXH1Newu3k8L9/POrdgDXbLtYr8XTrHECXf1jg9tBwODZGXEtwk4Hw7qr6AvJvknBVbxcS8v9wo97r0Qr7M/Oh73yFJuA9jbS59L6aeUncjjHzRopKmLyqEuhFAWAbcoN+dfUBcW/W87bA976vlHKLBtU9Q/mzY",
         |  "lastUpdated": {
         |    "$$date": "${yesterday}T12:18:19.003Z"
         |  }
         |}
         |""".stripMargin
    )
}
