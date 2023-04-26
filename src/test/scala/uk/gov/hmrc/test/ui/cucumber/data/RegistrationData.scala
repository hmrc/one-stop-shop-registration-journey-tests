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

package uk.gov.hmrc.test.ui.cucumber.data

object RegistrationData {
  val data: List[String] =
    List(
      s"""
      |{
      |    "_id" : ObjectId("61829039e7383c63ea118f5d"),
      |    "vrn" : "100000003",
      |    "registeredCompanyName" : {
      |        "value" : "fTs2HblwbFKRpSMSBUIajWWfhBivYxJ7BJoK1w==",
      |        "nonce" : "770iizyxzlsousLp4lxEUh6FjfdQES43jJCeM62ATJBe+co6vZDzFFQI641+cD/w50egW+RLe9eIyzFRtdQ2wE57LHBxjtkZC2D/uOPTyX/dhs4OGxgHbUUpjLgmUUXx"
      |    },
      |    "tradingNames" : [],
      |    "vatDetails" : {
      |        "registrationDate" : "2020-01-01",
      |        "address" : {
      |            "line1" : {
      |                "value" : "iYkT2jxOeEyK28ozSoBCb5Vjyf9glUS2QiU9Rg==",
      |                "nonce" : "LcN2Tjj7lSonobfhPugG6X/r9FF6TpdGInxLA3JzEhefGOGEcLToHE+Wq9MHUXJwUR1Kc/x5+CVNfFuxsSUKhUUGP281ciQyC1AVQS7dJL9hgklEM/rYjTu3m7Pa3JI2"
      |            },
      |            "line2" : {
      |                "value" : "pqOLyYGWToEfA/oMZ1skalAZibGC2n9w3g==",
      |                "nonce" : "hKTO3aAToSYF1UPuj+WT55MmOKL3bYHI7YQC6cCR+v5trKPEz61F0uHR9lsQS/dG4Fzdvb5ZyZuku/3J9dWyqvkYNEBfHoIhH2TOoM1Mwbo6wKutsDX4IitIhr8qJ4+E"
      |            },
      |            "postCode" : {
      |                "value" : "NG7uRXwTzbSrSbWKu2yP4ZJwa8DgFnQO",
      |                "nonce" : "kymdy5ZGcHH5LsJDN3bBfgYuEHfFE+nZX5JI6jMiS20bXYGRo7JSwhH3kp31pbrDMp8d4/VoHZ0uuPoRjrYtkJ5DnGjNGQwJ3shBr6nYFhtMY6KfT4zx35mNxqnQ0QqB"
      |            },
      |            "countryCode" : {
      |                "value" : "pvsWHhxAothp3klqp6Gfc/lf",
      |                "nonce" : "5J+9N285T+OrSTloNVjURmMXPzvLlLloZXBKPThj894F7D+plPuAUZ4mKw3zHP7M6asPGBftleqDd/ojj4ultMKm2u8SxWzQ/NDczMd3hFictQqZd2rn5+28eXu+g68f"
      |            }
      |        },
      |        "partOfVatGroup" : {
      |            "value" : "7jgkgFP+dEVp4xiTkXM+MEK2LiE=",
      |            "nonce" : "B2KTxrN/zikq2GCJlJF7gED5RnDOcYnKK1wuhzlJN4rI/492f0BIF2kh8p5TNCWVj8FO565quKBj+doHkS3diWXXf74jjdoUt6sYO/KkfJYMgFYAul/hTaq35bP6mLR2"
      |        },
      |        "source" : "etmp"
      |    },
      |    "euRegistrations" : [],
      |    "contactDetails" : {
      |        "fullName" : {
      |            "value" : "qC1VgfjoMf30Q9kdwNJrHV0iC9w=",
      |            "nonce" : "id1S7Bk1PxAbvGV9mpxkLBBTr54EE1OQ411fzY6GJitYGUxSIpIwmOQ6W77VWqA1Ljj6oxcw0M50dZ3vaoEywDTC20YryJ+mE90AmoCqrWe8DdyLmPLb+d0cQAAL6ybh"
      |        },
      |        "telephoneNumber" : {
      |            "value" : "AnAgACC8pb8vIEqiSISwVNkOSNS01wk=",
      |            "nonce" : "zpzHZrnRQFCeDUxqcUPM8nS0rhm9MOvzH0h1jxzaTPHRfTkv1UfETCTj3tVNDkymKgKiPIxcuisDIFrAh+qungNu2fgwnWvMtcS2j9aW19fPIJTIsdiiVt8cCtnjMVu/"
      |        },
      |        "emailAddress" : {
      |            "value" : "SFHeyXw8Cm+/ZNv6/+T0tvWxegea274v+JjSWhg=",
      |            "nonce" : "OVM7uUe/eQRlHoghCSvQLL5dj51XYXMhgbiyLPguwGw/GDKWWvtIT51hAJeekMKUB95fj60KjMlvYMG58yQnYiQN0PMEYU3XVSf/6KtSuHNQ7WFTA+kybYUy1hGLkPj7"
      |        }
      |    },
      |    "websites" : [],
      |    "commencementDate" : "2021-07-03",
      |    "previousRegistrations" : [],
      |    "bankDetails" : {
      |        "accountName" : {
      |            "value" : "hwIBtst1k33oduPcxfIr030TL8mS+WsjWA==",
      |            "nonce" : "IVdodm/uolDCjeXrDAa7fFakA4oaOnTgqfesoe90n1n0mcJwyb+pmIumijLiivrcRlvf8RohvwnUWCgQrDHhSjJXBOdWY6/hWTiieMnHwnp/eslRLsixMxnCK3GiiiCu"
      |        },
      |        "iban" : {
      |            "value" : "kkhH3EelKM3o9q4NqTZ0mhQt++hANtTA7jDdUQOyAoudcAa1p2U=",
      |            "nonce" : "jjWhZhiosCDoyOIjY0rC/HgLvYntXbG5yxcx/cCjl8pBqRwk+txaUijTjObrphmrb1W67qoizL+iUNxvpbcCsqKs9dcAKANiHsZZfK6Uv37N+uZco74TvUyseXNDw3XF"
      |        }
      |    },
      |    "isOnlineMarketplace" : {
      |        "value" : "XbVHKGLVSN10k1LKYNVXTUtOTZtn",
      |        "nonce" : "Ij/Sv6nbV9m4ZYbND9/DMIxlGcsOuIZqCpxZuuNkNk7R58ILP+f4jWKdhn2pcCcqYPHbf3FfBoi7uIjG3ncOac1bRw1YKFLJ8YuSCH/M6YAska+/3YG2rAIHB6tW21o5"
      |    },
      |    "niPresence" : "principalPlaceOfBusinessInNi",
      |    "submissionReceived" : "2021-11-03T13:35:53.592Z",
      |    "lastUpdated" : "2021-11-03T13:35:53.592Z"
      |}""".stripMargin,
      s"""
         |{
         |    "_id" : ObjectId("64493f4ae4c6600e08e4870b"),
         |    "vrn" : "300000001",
         |    "registeredCompanyName" : {
         |        "value" : "6VXIQpmJp/Z12F2tGrfqZ0T2YknkQymZ31OTng==",
         |        "nonce" : "iOFDRNI+ghfJGqS1hyuVTZ2q7AabXEI4Ig5ApjAdeqjptF+bShqDGdc53Ms0Wx5ArILjQ0y3LRo8CM3byN1UgdeQsufKV3zyL/DB+3cVdD4GUnSmPVoEdseJ2C2/uSgg"
         |    },
         |    "tradingNames" : [],
         |    "vatDetails" : {
         |        "registrationDate" : "2020-01-01",
         |        "address" : {
         |            "line1" : {
         |                "value" : "eitze3Z2RcrawJX4A4YHCrWi5LEs4njFwWH4Pg==",
         |                "nonce" : "TZk1VkaCj+JU/uwCQS2oyFeRnTGIQBqcEsAI/vy+v/4ld/gcYTf9tQsYUg/F9GYbwwW2uoIxpGdKJTM0R+YmAlKvVgWt3tLGoIK6gOq6AWRRL7wSW5V5Nkp22qwdvkCC"
         |            },
         |            "line2" : {
         |                "value" : "1yzbiWND0nBIkdVDaLj5VVI5nep6WroN5g==",
         |                "nonce" : "Gakz6cQqVveMUJohoie8T3IDdPzuco2PpvOCfEVbith2TGFPHryXLCO7ubfZwjkofpqmPIsamqkoiWZLzDHOFHiwTj6ltqdt6uSQjrrFbZU9T4a24pDXupyKul1BsFbL"
         |            },
         |            "postCode" : {
         |                "value" : "+yHyRz5iIr613HZywD5I3tEM3joZjtuS",
         |                "nonce" : "XFS299uUiwQIZDuFmwdlpXtxY9sdyE4aQgZEVCWvu4uAdAt+XVkFfr4Fkq5kG28lh+vy9iX3c+NuzRuQFq0iWXB+DhsvROfHhZHeMZEWnzgMlkGqQkZOvNMlPzImXZs/"
         |            },
         |            "countryCode" : {
         |                "value" : "lHEOvlHEyVIw4xGMbalYKcus",
         |                "nonce" : "sCEw9riF4DzH4JkwSy1FeZYVW51129Hhb/QkrRCB7zbKikkj0M3C39HEYGQ2tdPNajf5ZZXHfhYht8ldQwTgLaW+rbFpMavnPppQsulX3S/pMj0ym0aYYQYbbvK+85YX"
         |            }
         |        },
         |        "partOfVatGroup" : {
         |            "value" : "yugNw4zxnK5BCy42OLteSc4spFXI",
         |            "nonce" : "JGY3lJHtq/bSso7c4qu3CM/um4r6hqXjR24hZhi2K5zPd9yl8WwuvqgFDC/MPIYZcmhSbQA14ALvXtfrDtUIMOhX12BTK1woZjSKbl4hIM3DZ76DkDkdw7FdIVCAFsGE"
         |        },
         |        "source" : "etmp"
         |    },
         |    "euRegistrations" : [],
         |    "contactDetails" : {
         |        "fullName" : {
         |            "value" : "9Nm1tQv1rGt9eMQ2UxrnQ20As6mVaL7AqA==",
         |            "nonce" : "9KjlwfPNEzTz0j9Lkt9z7fa4qDbqMd7zn0HZNfDIjTYrYp9GC6QYYpZTWw0dGlBdvCEkasfVs1XS7ahV50+T6v5TBmi1JQA45IsAn0vA4sxpd0YEBY+aVB0P2TpncVE4"
         |        },
         |        "telephoneNumber" : {
         |            "value" : "d7gM5cRVl5vs7jVp3Yvw8LqwrBfbxEz/Iog=",
         |            "nonce" : "OeXujzOYe6DFkODLXuaSa8fDc1hJaRwigKJL+XfHiddSREbT4a7PzePMj2fMxyt8kGsYjoHIHSjYGzYaPqhslI/83jn0qSzmyAEmYgPsErKMUWVje0PavaKoBzUSMSV1"
         |        },
         |        "emailAddress" : {
         |            "value" : "SJf7ZwFS0Vo1CUa+rXisysPs5l5xEpo3GXBaJCQ=",
         |            "nonce" : "h6e4lGZhkw9jlWuE3wIsYUvAqJF3jzt8vc44dUCd+PykvB1Dlbzv5TlMD9VHBUOvc/0wCBwpGtZPZtMsf1MzhOOOlU1DIeF8z1eGJyt/Tb+hBsPW6+Nj59vmLVp29j5j"
         |        }
         |    },
         |    "websites" : [],
         |    "commencementDate" : "2023-04-26",
         |    "previousRegistrations" : [],
         |    "bankDetails" : {
         |        "accountName" : {
         |            "value" : "nFPmt0HVb/vL5ZHhL5U+Y+gESzEvmd+rSw==",
         |            "nonce" : "OnpDeYIpYF15RdlNjVbH0GlhzMyTn3PK1Z6Yn86xB8pX9xYvXqkWJkr9oO9R95xypqw133g5HX7MbMNW9IfR8dwBIWtfD3kSJts/dQhIXRfn6soMH684/MGeLAgqkIIN"
         |        },
         |        "iban" : {
         |            "value" : "xXo7o9sm8jTa21tfStjlwxlD6psiQi3Ntv0JUwC69MKBOeSX0Rk=",
         |            "nonce" : "bYxj8QOvMIdcxwdWvY3m5g4tr9EA1Vuklq4oxWodkDJdMduU6+aYYxuamczDc+SgrMKw+KUE48tXoWDEkKu6xgTfAgEj1XNDsSOh2fSwa4RoFuSyM4w76WpMI43271nr"
         |        }
         |    },
         |    "isOnlineMarketplace" : {
         |        "value" : "lAwEjuc51v+R17RfUJ1elLWzVlXO",
         |        "nonce" : "ZaAhEdGfxp2NzNxxV065y0i1O/ZrMCI6ntP7Qun6y0ex/jhZB9zv52OYy2ujnUwpLisw6R85g0dcOTv04fnBl8NMtaRJ9qo5OsckTXpd+FYfYFK15KKBOULKGm/wErvG"
         |    },
         |    "niPresence" : "principalPlaceOfBusinessInNi",
         |    "submissionReceived" : "2023-04-26T15:12:10.848897Z",
         |    "lastUpdated" : "2023-04-26T15:12:10.848907Z"
         |}
         |""".stripMargin,
      s"""
         |{
         |    "_id" : ObjectId("64494beae4c6600e08e4870d"),
         |    "vrn" : "300000002",
         |    "registeredCompanyName" : {
         |        "value" : "rD7utnxKx0dL3HLs/K/L3hM0D09RzXoI72VrSQ==",
         |        "nonce" : "UwwctcjnyIviCgJNv1ixa7NFwZGk5NCULdUYmmvRjYIWOayzVOFgG/S5ckYVw9dg78EvqZtSSvpL5e/mLklOOm2o5Lo+DJE0t9ALSMGmTsESgNiKrCHLq8Zzs6KOSL9p"
         |    },
         |    "tradingNames" : [
         |        {
         |            "value" : "+uPKS9TujjxbkljYwIZ8rGbNs/s5gEiIk6CAk1B7tcw=",
         |            "nonce" : "fkXYP0yYA/xFctob9JVCfOAtYsf/6I/Mh39DAOJImnaeq9i0bHjCM9jjTLOhm+Ql5I7wjI/itctaPliH3mYnxny2HjHI78a07985KveXEwbAcVJOtK75H4qUWtyQepgX"
         |        },
         |        {
         |            "value" : "GxZDlbdz8voa2/jbAB1Sx0c0Z24aQbqS0kJEqjBy",
         |            "nonce" : "OHCh7Qif8TbFBaX8KMaaJPG6yCdjN/8nM2t2BcRwO4ZMqb9nHSbjvUotTTFn52MDMBFXU0z3fW2ESIwAGpqB0bL2XwMjSM7DzNw/fywtq9D+lVxMkdoAVE41GohBXX++"
         |        }
         |    ],
         |    "vatDetails" : {
         |        "registrationDate" : "2020-01-01",
         |        "address" : {
         |            "line1" : {
         |                "value" : "wL4/pu+3k9lLatzWTmY3x7f4ANXW1t4Vczurbg==",
         |                "nonce" : "zS4EDfvCRjvN2tEoFJTwYeBIvghazF9yMJS/3we6/AP4TuowdsCdEjKoC6Va4dNzhG++xfS9ajTDQ1jCgWcYXDNEUskwdx77rJkDqO/7zfG1UB8ndgcH67HUYbRhsY1D"
         |            },
         |            "line2" : {
         |                "value" : "N3PgOcdO9BXlR9OpjwQvjZpttZFq7nZn3A==",
         |                "nonce" : "tg9PuuDdhWsc/dMOWTStE2VQ8yu4LVpFgUUL+mw3BHc1TwbUtr/FRtUeQsYWnZc1gVFKTH7aYMGxAwRRMId8RqCwkfO7GihSb8giGa5wz/hdprH/WcSgXUj+3V/Lhj22"
         |            },
         |            "postCode" : {
         |                "value" : "y2pEsuNAnC2CNszeXHBmsR17OY92lwVd",
         |                "nonce" : "eacf/XZ9/LIY/ecgizpe4IYyPtWyAQVl9LLXn6HnscQenypjzdXgya6Z7N4nBwz7sqyt0Xh4PuHrmQBhbc0CXZIdxzJ79YwgdE6z0qs1+0yMlyNr/ykZejGEVpGzaVxe"
         |            },
         |            "countryCode" : {
         |                "value" : "rd5tkjJn2tcukrA5NTlVZtvj",
         |                "nonce" : "RN1/G/Etqz4v7z79gNkv4BipIBBUkQHWEY2Y+P7ZBIkDggzyRJVBooXRtiKxNr3Mk3b2CDMYlGBUBsMhYsQmMbxG3/iwB0ThhJl46aRHm6YOe5rlMg5SjiulXwxvduB9"
         |            }
         |        },
         |        "partOfVatGroup" : {
         |            "value" : "72ZLR7971E8Q+0X3s194Imx15Vpc",
         |            "nonce" : "vNMrz8IoB+o0d1U++W2VgZ2/2+09NIfKE7DuGxDpSkVw0FigDHR+8/+pKigA9iO/4LAbuamkoBZFATw2D3FDyR9hNqjKW3c71PK7TGZ+nbeXOcOMYc+Bevn2zmjsyyWu"
         |        },
         |        "source" : "etmp"
         |    },
         |    "euRegistrations" : [
         |        {
         |            "country" : {
         |                "code" : {
         |                    "value" : "Lacz11mxz4VNh0QzKQYl6kI+",
         |                    "nonce" : "I7sF2LIjvK2H2/M/oTsi6zcuFz2bn4QTo0gVhM6feW0HvBCWNGyCsOLzAHR3NUnkbvJ+4bI7L+CDHxZi0PbXpSziT7aNzW8rP9BfT5rieAlsBugQTq+fU+zl4xozBhk2"
         |                },
         |                "name" : {
         |                    "value" : "mxjVKhh+cit77QRzkReJyDnr/hPPsVQZapCSY0n5S3X3gg==",
         |                    "nonce" : "fZXMTbQwLBK+2ctA1xdhA2Fu6I4ha7zmnXGpsC/91pYcqdUgcP2T0d7dlQVymgeiSUicu+PZzHaQ5bOkOUOpdk7BusooP6+PEw8dso7EpRC4frCLrxLMoEp6o0R+mySs"
         |                }
         |            },
         |            "taxIdentifier" : {
         |                "identifierType" : {
         |                    "value" : "RTr0ZtFIPdqQrzr03bAozDrEgg==",
         |                    "nonce" : "hdSpgwdkEnfE0Aga+kTYxk533aYzZ4cVnfzrY3V951uxfzGfocAlVXT/BVJAFys69qn65FcAwI5NMHmQIzSPRsQyNwqkSBL0ljne1Qe7dpuLwP0uSwVLJMsZgqtnQMmp"
         |                },
         |                "value" : {
         |                    "value" : "UrPFU5s4BwMlyc2xTEMIlV08QOzk0rrrNq1e",
         |                    "nonce" : "XSLUmwkVE5AKMkl5zF9/TfI0Y8C5lcGbmlinpsiYAyP3hbxCs7aW1Tt0p+JyGFW35dA3vp3HVAh+KMzJvenSUYbjTJtXtEljwKip2B7kk5bQq14pWeELRwB5rmiV7tit"
         |                }
         |            },
         |            "fixedEstablishment" : {
         |                "tradingName" : {
         |                    "value" : "RXZDlfG48lHG916q4hovsHnxSFsImvnWhlkv8SSS",
         |                    "nonce" : "FPhbQ0rNrNUwOhK9KrzU7UVboVVxSUfN9besu8i3D5MEuZBAVfiyX18A8YiG6evOcBuq5ZLFAZL+Bu+NZ7y9Q45/zDnt6pOu/mS64Rxzublxu/cBzKsK5pN3CmrZJ1Co"
         |                },
         |                "address" : {
         |                    "line1" : {
         |                        "value" : "0JOprCq+tBwKmahtjeo4deK8jJLzKdu5LDsmuVwC",
         |                        "nonce" : "F2voKiN+RCz+dKggAE2WdfjxoeG5iZh2Woa8a3j8TNrWYEnPvpwBOWKhqICaBii+gxe1phrd5jpdnTbwZEAIXIxd4A2WvLj3zNjLlyzFr3Exc5AOVk03So+5kwNl8Dkx"
         |                    },
         |                    "townOrCity" : {
         |                        "value" : "G+BmuDz0cIVlEr9kaZX1j0QPvw13UdR2LQ==",
         |                        "nonce" : "/3g8qIfkj89PAJf2tmdiiIyHjrOiPnwGP3QYwVRykVb/PxRxV+xnV4tNm5gWB3N5l2UY7smXrhiZ+4k3Cvm2bc7tglD41PIAPuHwT8WJjkP7YJNfZ1SI+XSoswz20lHW"
         |                    },
         |                    "stateOrRegion" : {
         |                        "value" : "+lSgNTNocyj6EVDlHths0jYL9n5Bom3ZuSQgO1U=",
         |                        "nonce" : "hOc2Haadu2a4z8sF7xBy+0RwpzZb+ecfGqONx/xrAIMewo3lzBWJltcwLry5jffel0Z5OCMc6P9On5cYshvBg5TBr6t1VG6Pu/bBRqIwTJenGtRcSvhJdPfDiUr8i2Dg"
         |                    },
         |                    "postCode" : {
         |                        "value" : "l6uc4jGddg+++QpBD6N25cu7Nd4zgTw=",
         |                        "nonce" : "62pgm7bYCScHSLgRGOE2QB2SB/E0JF6vORobhm5seVVZF83Xmvoj82aPRk+y7+nEVmJViXj5KrEIXTKg50WnJTEaBJgILwP+CJ5+tdA265I8ardxjYCZ+J+aPgGGgw4Q"
         |                    },
         |                    "country" : {
         |                        "code" : "CY",
         |                        "name" : "Republic of Cyprus"
         |                    }
         |                }
         |            }
         |        },
         |        {
         |            "country" : {
         |                "code" : {
         |                    "value" : "iZaahVgVOrREPIXYqXm1hkf6",
         |                    "nonce" : "YXyX7swkcUcl3B8dG7uPELXnO97QfnSjRMt/IEYZzxOEmqEGLd1HkTRTGsY1Li/w2Ocka4dRjDN7Pglt7aEsW3MiccyYQVeBU4XOEuiIix4Ev/bLS3HYqPBlzCJxl5gh"
         |                },
         |                "name" : {
         |                    "value" : "w2JY2KNuJIvadJ7K7BMxHHWqGbglSyhPSOre",
         |                    "nonce" : "PQ1g1o+KEeOXYjbQ2g8lx+ZE9jvQ9EhFruX3Ctlh0BD9q6QHVtbLqFBRod1df6i59Rvmr7PJjtUDw17SCFotiAzkSHMNcEqt4WZwz95em47zw+wcFv4VGLf+vZdzHLtd"
         |                }
         |            },
         |            "vatNumber" : {
         |                "value" : "wBYrf1zeY/aluc5f92vQSVJ1iVuq8WMw6f13PrOu",
         |                "nonce" : "pyUkSd3lp39QvZDrmh86udeDnSdqbkIstwVoTd7VhqlgXo9AsuWAj77/bdqGT5v9bpBeKnZFtLYACZHVnGn8ADDVR7+CL0qnpv/s4bq79whglSMBhTbJ3L65SrIY9qTY"
         |            }
         |        },
         |        {
         |            "country" : {
         |                "code" : {
         |                    "value" : "jYX0B0If9vDzEuzD65GOSn+j",
         |                    "nonce" : "s7yfsaXRNcKA+31AdllHQ6SKf0TyNGtYPCEd+N4Jd+a62XRJcQNgP0kaBzuf3BEWD2Kz/n+l4DMt7A1jTrkNbTrrXbPYsygKMCmH8/biKVioTQr/3/35hZAPx9DkTtdy"
         |                },
         |                "name" : {
         |                    "value" : "n8DRXW9REbUkLZLk1tBBVLhzRoJTuh8=",
         |                    "nonce" : "WEoRusDVpay/I78KPfBNsUWg9FyGEtnywvYCKcxp00jPkmwAWvaWiCFVcOOQOasZEY4T3cHzzAcSeBJShJyrEEC8JxRONrINeTQz9v1NTHgEOWTlusJbMIi4sLd6cTiW"
         |                }
         |            },
         |            "taxIdentifier" : {
         |                "identifierType" : {
         |                    "value" : "1zBEzEgmtjw3Kk5WXfT88mRM91vB",
         |                    "nonce" : "wtF0P3y2t8jZSUWBa6HWyROSyAc1sX0Kr8Qzqy+E79E1xmMmDkc9NDxk2TZGQduimQyJ8/W76PSx3OUxgZF2G1luIdzXcBD349IPa3eOyVNNFb4mR7ElMIYszW5Ra2eL"
         |                },
         |                "value" : {
         |                    "value" : "Q0MBlZ8uMqT/AvmGppVJbLL19emTyAuQcQ==",
         |                    "nonce" : "G+1vp62bYXrPMFlkb9G+TXlpvdiQ7tDutgqLQ6Z/bIcthWu+v9N51C3wvVvByllL7ymdDCHZzdrUnCyinBtpSXwC1Aj99iAioTsxS9VjGKcOjXPL3gKGSQd/81hbqgDB"
         |                }
         |            },
         |            "tradeDetails" : {
         |                "tradingName" : {
         |                    "value" : "keMwt1xoI0KzDUBVe5BP2TV5jbB76Lc=",
         |                    "nonce" : "LVShZB0fb5rk3wFeFe1Uhj6bvZcUpRdTTtzV+kpxFoggzm8VaUX27ncxigilNoGSiyb+kl0tzoboryE06QOXXW2vjd9mQUG8ZBcJ7C7eBmpGqw31JoORVncgvHI/ABFl"
         |                },
         |                "address" : {
         |                    "line1" : {
         |                        "value" : "dXf4K9kMcV/LMx7VxF16IAIJmNowuEMn0QhlSp/t",
         |                        "nonce" : "1oQvYvQ+xw/pfhm8XIijbpH0+YbQ2bltpBZM2mYSyz+Vqiv5O93XsQm3OuDA3Yom0QGi1B4n/ZGtG6D7M/Guw7YvZ4TPPtKcY3D0H30xndusUu9qHmPldQXa/vr9YNlE"
         |                    },
         |                    "line2" : {
         |                        "value" : "6IheYwpQD+/1LAhXiiEQDWDSrlzItO1Pl22Xpg==",
         |                        "nonce" : "lPNqr177KZQsKo7bOP6+aBNvPrbrRGS31Egd51vhXcniMrzYpHxiXrGuuBdFoIpY3ZZNPW9Qq88byJtrxSMbSzoIaJ1JJZL0u6dj2vMMYdHgBYk9JW8iEOtoWPXFXPoB"
         |                    },
         |                    "townOrCity" : {
         |                        "value" : "Y0oFZOdVLHzcNaawUET3+RQRNOzctBjZ4A==",
         |                        "nonce" : "KdK/PpTgFAaZi/7vcfN4ZaoyuxayZB6Too+pl2W04bObUvBspr2Z7jVwctxNV819uAdQ0v0nt+/TRTWk1PuR1q1+6toIs+JufyOAs0kr3q1fUGa7iKeRxWCygYRN6G+S"
         |                    },
         |                    "stateOrRegion" : {
         |                        "value" : "zDmak3+53GMQ58qgYzne3SbqMVf6f0dmXUT1MzQ=",
         |                        "nonce" : "4ANXCqOpEs9e17UAz+0mxXRwvGoo6nn6eEXXYZHjD20pNqRdPM/UxjkYoWLlKsiv92830ALX+w07J88NGFEvCuny6qcWVmyEOBbaJHzKZo2Qdu/L381li1JURfbwu17O"
         |                    },
         |                    "postCode" : {
         |                        "value" : "V1wS10qxLTL4P8Jpek9VQUyvaJKaXLE=",
         |                        "nonce" : "UyHA8YgL42VBeXVbjGFpyxU3cdMPBWU1ftkYqLaF70spQOBy6PXmcCrRvBDogbDk+gaAYMf0oa3NjpSK4205L1VFd496F28Z86+Ryy84qTj2tLQK1AAjhqYcyIWhO+Vj"
         |                    },
         |                    "country" : {
         |                        "code" : "RO",
         |                        "name" : "Romania"
         |                    }
         |                }
         |            }
         |        }
         |    ],
         |    "contactDetails" : {
         |        "fullName" : {
         |            "value" : "3syyw+i/nXZnRBEyGTUY4PI0sPgUAjRTcg==",
         |            "nonce" : "t5F1o8LkE1BPRBhhv8V+oXDQyC2U0JncUIijcuNCEI6bdq3k4ORgLTR26qnGBNBd+FKEGv8YQbZJobktBLLFozC/9QQRGE/iDZLTIKyAkbvP0vWpuQ2M6dF1A1rCis93"
         |        },
         |        "telephoneNumber" : {
         |            "value" : "4SQI5wVZB+wayH+L0EGq/v5IXUH92nb9NQ==",
         |            "nonce" : "IhlyxDVoHtDzOZuEhc3TNLCQHn9y4z20SsO0wOOsyQTe3Tkhlh9R342spVuLTzGgPOWqwD9NWv61TIj2KoYH64RL8PEAqLC9cVEk8TLc6vw87HWPv+LHha7qExJNYqiS"
         |        },
         |        "emailAddress" : {
         |            "value" : "/PU9AhaFUJciStLDZJ2JzGFwf7+0XiGzAt5X8VQ=",
         |            "nonce" : "A42F4TA+cdgqvdQ+eoNsO/cgnkDzmNmV9Evs34cXwescyq7jLCYimjvQxhy74p+tNfdEd9E669kdvZlQGNupm5RNmEWzYzWpX3HBCti/LIccIrQb6ul56zYJ+7uW7kLE"
         |        }
         |    },
         |    "websites" : [
         |        {
         |            "value" : "oPCWFcBWc5TVpXr3m0okGXG03baH8BVN7plUUizuTIZPlXCl",
         |            "nonce" : "aZvrdVYqXM0h1rDhKYrid+C2bNkuUUuG41qO7pxz5KikCpK8kQB7JcoUOW89gjcaOtCT9SzMSgVgZ0btuHjeHdrNI7njxAK/rS4twqbEPYZw/3Ac7tdT5XjpZxA36yKS"
         |        },
         |        {
         |            "value" : "ToBSbmqUWUu4A3uBM9322t+RoTXy20unghrySzDV56vvD34=",
         |            "nonce" : "qlGL+VJD435yJ7MqTS0izr+zZaV1akYYHyVkAjtfrOs8QrZ32f51RvPTbWb2bH3nEs0isWvxObVXt4UR0TWU+am/dVuqKs0nBQUU88T3yb/RfvTuP9c/8hkFh9eLsvw1"
         |        }
         |    ],
         |    "commencementDate" : "2023-04-01",
         |    "previousRegistrations" : [
         |        {
         |            "country" : {
         |                "code" : {
         |                    "value" : "F7fm9gUl+2MqkakDu/ZdsP5T",
         |                    "nonce" : "/J8xbkMxaDkHCbecc+xVhtUKYAFqCIIFT9c3kH/wWQwuP+9BsvvmtHtJa43upMSTbwIduo5/DaRQ8rbLfNHxa389jRX6p2elMLdnu/rxpwu27z5YX6M1cZnNQZcdnYX5"
         |                },
         |                "name" : {
         |                    "value" : "AeKvEZFWlpu2wSp2b62VsVWH74RImLw=",
         |                    "nonce" : "VN611LGTcI5s+WafMFjIE7ampzBl96bcjN7nQlJfLhowqIXRQu3blaY7Nw1m7DPnXI/gtmrvRsDA6sKymcBVuC78ZOr+0rZDec/2rG2r3RdSTMk7S2FF5ZUjdNyMzoqX"
         |                }
         |            },
         |            "previousSchemeDetails" : [
         |                {
         |                    "previousScheme" : {
         |                        "value" : "0o7RbP6Kr8bSAe66AvgjGTGB/54=",
         |                        "nonce" : "W+yerfMKmZ3MYtbkIeSnkkAHSc5o6x4utM3p4ErJKjDvCmQhZ7ZWTd52/5Zo669xTaVKpOSZwPmK1n9MYO5PmbjeW9Wzm4sNygsXKHJlwPwCkS6CxrBzKgX27ENL0kYz"
         |                    },
         |                    "previousSchemeNumbers" : {
         |                        "previousSchemeNumber" : {
         |                            "value" : "CGESWa2gX3uXpC8pzwH6PXzWwrVwj9YLkDL+pg==",
         |                            "nonce" : "P2FtTq/Wqd1ogqd0hOaNkNLgFa4kvRZP7w1H8ynbxWoc8OoyCsfKJ8MpkEUOu4it/Pite8sEK27ZEbb5KwUyQhfKLaqaLAdtDCPMls50zHrgLQRwDY9Bd9bLWATHdeVg"
         |                        }
         |                    }
         |                },
         |                {
         |                    "previousScheme" : {
         |                        "value" : "75nUNa3PdBxHd6lVKbbsxe2H6fQr",
         |                        "nonce" : "VOXT4W6cZTMsGEiB24JX7JN6UnAMPMgHWPiI4GoeDdJHFIsdu9Cvppdthb0ghFL6RVWkbRkN9RVc/tgSD71IuxtVTzEAIuLZOqvCO3G3Zsuvcuk6khfhcQmtISDYY4g0"
         |                    },
         |                    "previousSchemeNumbers" : {
         |                        "previousSchemeNumber" : {
         |                            "value" : "pCdTs1fjbjaEWPV1ZDqraat58sMttt0LpHsv",
         |                            "nonce" : "k6ysIvWTurzFMDVXJxNH8lxTP8DRmv6cakiliQzDsC6YSvQCR7JdrIlxLtgjrZa9X+KL3auu/arc9n4awLkuVLMx5VuXGhW8m3yIfEWnmMkJeXBywUXJmgoAdJt9IJL3"
         |                        }
         |                    }
         |                },
         |                {
         |                    "previousScheme" : {
         |                        "value" : "DajLs9NIhmMDX1uolDuPtzBfd+3lNQ==",
         |                        "nonce" : "v1wv8JSsc2XDRrviv6rpLwI4HvVBnnmXdsk+FVPzeA9Womc+0h8sZW8a8UYOJJ8EW63l60B/zy5NXtqJV8I0XrNfozx5MoJSMt3RMNK+F48L2fskBIW6WPI6dStPijoO"
         |                    },
         |                    "previousSchemeNumbers" : {
         |                        "previousSchemeNumber" : {
         |                            "value" : "3dt7tdjxyPeYSr5EqLem5TXWB06hHP8pEFrUGg==",
         |                            "nonce" : "r6oZgUmzh5fbm0M7sqxDzuQCZpqZ78ON2hImSlP8dVkiBFBZqczvvJ4PabP7E5UeqwzGPNc2xqPrVeSly+w82EWvh915AvhlCPh+1yUTuULWtAZmXvi4H9bT4jCyrLVY"
         |                        },
         |                        "previousIntermediaryNumber" : {
         |                            "value" : "IKKlWrglN0RKkOZkuDKGtu1enm81qZCMGly9zA==",
         |                            "nonce" : "IP5846NoDX0d0mRHEgM4qRTenK6HEV785Vr8PaZJpUYPTXLvCgh7VVdUKXrUXo/spHun3R03ClY9ZhRRS0w6ckz3jf/YpgDOQj0AqWusJwGQ7NK6dlN2T/NU7JJWs0+C"
         |                        }
         |                    }
         |                }
         |            ]
         |        },
         |        {
         |            "country" : {
         |                "code" : {
         |                    "value" : "tFb/VyGL9uIDHq48mEPFi2lf",
         |                    "nonce" : "72iNnBdpubCaRzuGcnbz8+Nx+mtdHGAGp044sH/HfEaCP7qfYDPlrTxztVcjGioYusMJptjBJzYLJ0UabnrqIRFWpnLb7YPs0a+Hv1euIGjvpDfQxqgLNyoFSGma2SRo"
         |                },
         |                "name" : {
         |                    "value" : "PEcZO3I6465nocMbNuKA/1dmljzC8OdJ",
         |                    "nonce" : "jgVZ/ARAe030AtOBqphQ3Uhz95aam7YgnQUxW5C/TQ29vtOZpbTp44cZtK2ufIRLexj0JVptBDpO13TzMmV52FVyfHH+9BWGmPiFAcYmSrqaAnWC3vUC8ghrCKc447Rj"
         |                }
         |            },
         |            "previousSchemeDetails" : [
         |                {
         |                    "previousScheme" : {
         |                        "value" : "st0VDEhzYLuGMK83xMTEOm+TNNz39TM=",
         |                        "nonce" : "RGRqei3HnNhl9lbrt+O8qKj+Gtn9zxs2ZUe9LtraYqasF1oCxUcSrNPqdUCDzY3QqsMSvTYjvE/27Ea70cALn9oi1KvWY/BWr7IdT3+vGPwUCh6GJqG/pxf9eV6mQXwU"
         |                    },
         |                    "previousSchemeNumbers" : {
         |                        "previousSchemeNumber" : {
         |                            "value" : "icXmHTzUSRA6i5SpN/Wd6H5cv1apKAOIVCabrA==",
         |                            "nonce" : "05ZZKcdmUaJ1RkFg7OxAx4KMsaSFJwF84qiBilbXtN6FNxJrRnOn5wHa0Ok6MaCWGO7liiTuo2qtyU/CrS0XN+TWC8a9JopBMgSArNhq0/hmYtwS6+BAYRd6drmovKPT"
         |                        }
         |                    }
         |                }
         |            ]
         |        },
         |        {
         |            "country" : {
         |                "code" : {
         |                    "value" : "OEDjDBCGc6UXa+DAOMplHbzv",
         |                    "nonce" : "2outXcjVU8MMwFnmzzuk+PleaRphm0h/KmLWPLOATNIIPWpo/9RTcmVxqCcT0dNMu0UJmF8ALUMowA3ZyjMf0HzjjS2y+E/FtClwryfH/qOI7X6dKwCygRgmaghngHRE"
         |                },
         |                "name" : {
         |                    "value" : "NtaCPu2SgRXDsewt95TxZ6R9iE/3gOBc",
         |                    "nonce" : "xN18qTpOaWGiL3NyrSQDrudm7sGkEODOh9rnpKpHdRdvejDl+IdBt31dO8H3X70GAgsDhf//YhKknGnwaa7hQPiCmz4g0dTHRxnnzVb/e0yZ9HasUFhcXHWO/AWv8BMp"
         |                }
         |            },
         |            "previousSchemeDetails" : [
         |                {
         |                    "previousScheme" : {
         |                        "value" : "f1wYIHysZyQSt22vZ+M5xBkjLJB1kA==",
         |                        "nonce" : "c1ZIlhX1WpNxnd/BAzSDUXUrgTyA5ThBJ2SfRigE9UhAfdHzBwVFZjnWLvnHRvZo91mwYT227UjOYSZIEQFXgm72aDy59x4Xs4HZE9x5bouqVE8/oEDPHV7owNDe4IMF"
         |                    },
         |                    "previousSchemeNumbers" : {
         |                        "previousSchemeNumber" : {
         |                            "value" : "UgCq8ZQ0fMFhOBXQZI0EmIj3wQx0eIt7gmgcfQ==",
         |                            "nonce" : "vfVXBAYNhnpr2A1lE+YZbuhKUZV79FW+fdShh/ihXpaCJ4EMHy8s9DwWBHeGTMcABcBTc8GKMKcD28r15s682KFVcmr5O5Cc0r0P8D4mxiiON0SJUbHpodUPx09eUijT"
         |                        },
         |                        "previousIntermediaryNumber" : {
         |                            "value" : "6FS/i1Ck7ynGxUeAsWLG6rq6G8UXa6vRH8luNg==",
         |                            "nonce" : "Tg0+u7s1e0h0uJh9qFI8FTnDDeVb/FgqXs/cH4WG0IAbWo1M4Yq/SBMbaZ/fyoqxNkjpf5mwnLuft89vWb9gfg47vNY50hmAem3Q00Gf0V+hWZsk0AGshPGjepvvF7wy"
         |                        }
         |                    }
         |                },
         |                {
         |                    "previousScheme" : {
         |                        "value" : "kFfLlsue6Br4aq7enSWqdnodfGo=",
         |                        "nonce" : "3h+kYTVjAkirp3J6igklRgZgOX4OFk97aaL6sASDhBFN6iGal0mYrQP/hyEPwWDthKgzGnY2XXIX0X8spFkNbeiRjGnRdJXWsGYj9FjP10Pf9nlubX5K5qegGq9t3w/I"
         |                    },
         |                    "previousSchemeNumbers" : {
         |                        "previousSchemeNumber" : {
         |                            "value" : "3HKb4er1kSIXX+qq6qXNyNx3mO6rXz9xzxxmVg==",
         |                            "nonce" : "GNWAyuvHFMWKun1a1z2O1P3Ec7rBG9JHqoPybX11ZsztDpphBaRpgds6N66FVQXMSe3i2C/+UF7XHvdYJ6vN71loUpiFML06dPBwbIntLI2aIFWtj/U/MaMpZLoadDjT"
         |                        }
         |                    }
         |                }
         |            ]
         |        },
         |        {
         |            "country" : {
         |                "code" : {
         |                    "value" : "7Ax5GDrYN02Hw12ICnLaD8e5",
         |                    "nonce" : "VGNSxGCHDhMPe5F+0t3uCkq1JbChULJY7sJ4FYg/+6d4phQ1VpUqVsUSK/GQ4cpKLY3HG08f7BhH78yGAvElynp91Bc58xaddQ6s0gOGpc/OVF7s3cvxP/0vSouXHrd+"
         |                },
         |                "name" : {
         |                    "value" : "vYbwfTnoksemWUj0e9drWXLt3AUdGGA=",
         |                    "nonce" : "5gvk55Ap30zXHBFmfd5/zEZlk9b1JYipiaWPmTpyeIfN+pT2u9ss75rt4dll4XvOX1UMRr92/3zZ5nIL4EEZlblNPNkcaQ3oPqUJeRPQSGkwYu25/yFUAqUuSfCkM+qS"
         |                }
         |            },
         |            "previousSchemeDetails" : [
         |                {
         |                    "previousScheme" : {
         |                        "value" : "8ysAlqNdK3Z5Ft0xV1XBMdXHpio=",
         |                        "nonce" : "h1yPc3U5cdVBR4HiaKcKosNDLtyvDEDAe1otHh8xoDu7DKePg87A3RnNJ53rLUDsHb7+pNho8GhPkdx/Zd3XkzqDJCvZBW+9njq1DkXFDbTmpOZ4+e7skf0yqxifbk4O"
         |                    },
         |                    "previousSchemeNumbers" : {
         |                        "previousSchemeNumber" : {
         |                            "value" : "MJOWW4LvewUXGHI1lW6x/4NJos5NoQbwdKA=",
         |                            "nonce" : "7MJNIXX0PqPwHzPEQT2jcT1LaD1At4CViySMFODVVtI9cTXjeR0gqqCGjhdJhJFpk3tpao3Ve0xNiO9FHwuNk6xDcTu108N609ooZPKDoGmPniH6BbpYtvaJaboSRdXk"
         |                        }
         |                    }
         |                }
         |            ]
         |        }
         |    ],
         |    "bankDetails" : {
         |        "accountName" : {
         |            "value" : "GtG6V379tkoRg3sJu3xPSNbLIo3CR5H1fDQnRlbM",
         |            "nonce" : "LfW5AbywDSCySj9eXFZ7IXIEsHueiC+XTAgKxI0NqnKxp/X/BmZPZw9Q7hXDrRsI95z0oqAynBgFkGs1gLlNNUm7Av7NVfmt6XuYWus3QEdkDvj347tRzhWu6t9BK77c"
         |        },
         |        "iban" : {
         |            "value" : "ARzLi+gjKH+JUcuqxcDLSJeS7+zTiS756a4e4ZDc3DaltcIyfTk=",
         |            "nonce" : "+wgkfqFPv9xwf0p1PJn2xxBho7RqpgLLhF1f3F6oJoodRfa4+q7B37X8+v6pkHa/Hq4Vr/LW76BWFFHm7FSMQxWb5zcqoPs3KwiomCAjooNmscvGy46HtOAhbHpr8mkC"
         |        }
         |    },
         |    "isOnlineMarketplace" : {
         |        "value" : "CFChwUe0iW1LBU4ztJmDrMh5iP0=",
         |        "nonce" : "+dwn8UMS25jQNFI9Dq5MU7rVvLjzDcFv5n1qUdszPz/35m72nUVKGLnpljgZa1RCkdt+VYb/E5JVOSwkTgWNxhiKKgU5YjLZGvuzgcmc5dDkVMgC5wlhhbV7IS/gnDAp"
         |    },
         |    "niPresence" : "principalPlaceOfBusinessInNi",
         |    "submissionReceived" : "2023-04-26T16:06:02.548765Z",
         |    "lastUpdated" : "2023-04-26T16:06:02.548767Z",
         |    "dateOfFirstSale" : "2023-04-01"
         |}
         |""".stripMargin
    )
}
