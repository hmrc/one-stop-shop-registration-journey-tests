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

import java.time.LocalDate

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
         |    "commencementDate" : "2023-01-26",
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
         |    "submissionReceived" : "2023-01-26T15:12:10.848897Z",
         |    "lastUpdated" : "2023-01-26T15:12:10.848907Z"
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
         |""".stripMargin,
      s"""
         |{
         |    "_id" : ObjectId("646b4ba909ed405309579450"),
         |    "vrn" : "600000022",
         |    "registeredCompanyName" : {
         |        "value" : "CC5ENIQGuFf2wV0aQRbtiUn3A+2BWu0c6+Z2qA==",
         |        "nonce" : "+yHQ+/hPnOvs8xwLLMzz1RbyZMt2T9oYVJQUnwwDe41gMjo7O2PfB0yrA0v5TMa8TcT1hKs5K5NMPr05Y5dJfOuvZPs7VDIGsRrppStPvcGngtCKkkTs640vyyxPF8t/"
         |    },
         |    "tradingNames" : [
         |        {
         |            "value" : "uvDstdwHYDMh/MwZsS3RRsVklYMcqa/HPokWaIU1",
         |            "nonce" : "4CzmJNmLgu40R75f5Cneb3+BFLFd+ss0FrsGtY5rN9mVe/ZSzKZR8MQFoOioY9Tb/qz2Ssj/HvRiNk1tI0quQOWHJf277jcTNbpa3H8ox0oxHcr6U8Q1g0vyTEtFTVLe"
         |        }
         |    ],
         |    "vatDetails" : {
         |        "registrationDate" : "2020-01-01",
         |        "address" : {
         |            "line1" : {
         |                "value" : "cLWA3cR8PfGH27RYuVMPxbh/sXiB0PI0JO0ptw==",
         |                "nonce" : "ENFJjNQbGn+XHf722CMLmkCXASgMnKHObVAAUXF8v734B862hxji1HIErqTycDmlHVDv+kPGNpIIun74bxFJXpjdXDLd39v5TzVDPZ6zCUjDRXKFw5PBoWlA1pdpwg9u"
         |            },
         |            "line2" : {
         |                "value" : "ttgkrQ7UHtFnUOHQ+KwhKNuGGMx7PN2/ZA==",
         |                "nonce" : "+eu44Y89MWtqnA5ikAPclv+qFvEeKyiwPy+WaQepxDWn2HEqF93PdO0QXG411qYHR/6zKm6p0Bj1fOE9YdzwckpOBXZm9ZYy6VUFtmqgbGDGs0gwle65gO+y/bQ+mWfV"
         |            },
         |            "postCode" : {
         |                "value" : "c/ifqxsYBC9RgKvwXhAMkcioxVheu273",
         |                "nonce" : "vxiifnTvSfo1IkV6etQYEn3N6BJ0zLzHEYtJdGs9g0B6rcXs3fi5Kilwh+KzScfJ+qTDbLTMM/4yqwMEBzIuHaXrnjlSi1UXAcJjqCIajhW64FGeevzRGiamVl+yzeNk"
         |            },
         |            "countryCode" : {
         |                "value" : "upqeesiJJWNRbKMUEQGAhEZx",
         |                "nonce" : "cxMGFFYSSopfdc2rlispThrCaPoqdrJCC6B0CvKQZ1s/e9rMWd4s+iyScK7tDIehnsjsVlpOoIwjvgAROXhv0OW6mqeKIRaBRxRVn0yxRKkn95ffRqp3Kj6d+8gMmPuQ"
         |            }
         |        },
         |        "partOfVatGroup" : {
         |            "value" : "cV0ERQmUKFTGY+VUQqInsZLaBXwy",
         |            "nonce" : "utvsJxSpymFp/v2u0dBhE1hWh1HbkN5erBtBfWtVZwSpDsCc4o/KFjmV68y8M/4atSuwQXdgqQ8U1b5TgEob38frUhu0YScVig0HiP57KXFLOQrGyZOSqTobanpOMwtu"
         |        },
         |        "source" : "etmp"
         |    },
         |    "euRegistrations" : [
         |        {
         |            "country" : {
         |                "code" : {
         |                    "value" : "MdTZ+yOCXqIZBM6Iumi9xZvj",
         |                    "nonce" : "yILBvPjsFcdSoqq/0JYxiV332+bxOZPJPBB8BqBYRLNN+G+NnhamCS80wuxrm68lsfSdHsQaMp9vbIvXvSA3BcpfyIDB1TCcQX0gXbfBU4xKp7oxJxnlusvifyNMe/it"
         |                },
         |                "name" : {
         |                    "value" : "bWDVVJW+VIYCynKoaxA5fJ/G+f26Pp4=",
         |                    "nonce" : "5F36xmLjKiLmANbk/jsBRZXx1ly+jWtJ2AxDxfzRYHZ3ELOxtXDfkBJ9sjxCq1+kzhf1dXj2fX9rmS8Mho4bJCAZfV6aHlx+ftdWS3rOB2jCRTXaDsywvJ/NIWxdTpkv"
         |                }
         |            },
         |            "taxIdentifier" : {
         |                "identifierType" : {
         |                    "value" : "SayCUtpnH2NR58RuMsSP1qZcig==",
         |                    "nonce" : "9lk0x7+iPD5V4S5HGNJuC+Zg0XCE2WGpqv1nP8Cax6UL4RjY5YuUUcIQf/8RqMdH8/2Urxd+gs4a8R5soC5iBQe0zDFZY4SFJUz4x9J1EYScU0W4MNu7+P5OwwvJgGVo"
         |                },
         |                "value" : {
         |                    "value" : "2tGSdR3Glwqzx9SB2stwOp3VX8BJd3H6x21R",
         |                    "nonce" : "DYi/gtpIOuVSwDY++aJKJiVGXWGSdMg+6n0My3Tt+hnm1qLlpfJW7CEmf7oVeZZ/B0H+cCiLbh1KOwFPkABotJiMLq0tFOwabfahQxU9V6e9b8qTNJmHSBMOU9l0xYpx"
         |                }
         |            },
         |            "fixedEstablishment" : {
         |                "tradingName" : {
         |                    "value" : "/3yCwK2PqkSMvrml4DTCR9WVtz7yBD30sCEHJAk+",
         |                    "nonce" : "L4XcxFHJs7+AcdQiplMcJ0YCoq2TOLu8+H2dVg6G7HHFXH4Ahb+sckXACMe3udzqwZCThHozhfPzt76cOVRGXaIfyhbwlcnBd0TcOZ52WUHMhDf6jLYgSn9eUSe5L4zC"
         |                },
         |                "address" : {
         |                    "line1" : {
         |                        "value" : "2sBnQbSWh+JlPq1Dku8mV1g/9hJ+l9VkFXWhfcjO",
         |                        "nonce" : "xQafX0vhPqbI5GdqR5WSiPcNChhOwDJqB7OEJ89hywYWSh8VSw3JGr6I0CEW+6rtmDPfRqB/4GtmjP+u+WRGhtoRJUJnInAgpVstmdoWNijLWx2jdtnWkYw/VwyKHOKL"
         |                    },
         |                    "townOrCity" : {
         |                        "value" : "pRQbC6rqhPe7sYcyUtSf03Y98pwYSlrKzQ==",
         |                        "nonce" : "UD5ghVd3nsIsiymGFouGunmv474nu0ya3Nf2IVOwkPHW3/S2lwMioVz8Ara6UxcI4gL2YV2e0A281Dpve4fMrT9b3dUhbxZvEtX08jrGDp/OLxQVUbvmh10+f4yJmBFd"
         |                    },
         |                    "postCode" : {
         |                        "value" : "taBFTt9/lvmCub3X0IwesQ+KA+G6",
         |                        "nonce" : "XlF6nBap77QluksmAcIiiISqS1ClHXNIzBTIWKamiqP/Q2sG4tPIHWHxnJKUhg8aoFfjCXs3DZ6ToF0QAtQQjxqw18qmIDu4o1p8tMIXj/7yvfBWWxey9P2/8BAMrQ8/"
         |                    },
         |                    "country" : {
         |                        "code" : "AT",
         |                        "name" : "Austria"
         |                    }
         |                }
         |            }
         |        }
         |    ],
         |    "contactDetails" : {
         |        "fullName" : {
         |            "value" : "ii9pLGwy/DAdh9rshdhAJh6Bdtw=",
         |            "nonce" : "mfBlsteN96ggj+m4U9qlM28Vnw7sYZFwgtLa/1OIi1Uv46caDzWWyY07t05pJCXgWD0vlO23awvHbeS5HRV/dIZIPp+TOeZ8B8MaCTLntzpi5sMHEdtOgi8c/0YVc70J"
         |        },
         |        "telephoneNumber" : {
         |            "value" : "ec0VDlaozwH83ucodfXk0DUYugcayPqS",
         |            "nonce" : "ubzxO1S5IqXWPM56mw6ntl9fdOZyRMCIFSul6UbGsqqFRk2hc0Kgs+A61fBK4ivkJHPkf/DBsYDoVZoC8EhRVEs/E230AT3mgsmjub5cMN24oRmpRxphFEP1AatGOTZe"
         |        },
         |        "emailAddress" : {
         |            "value" : "guOdF8N4WQCA1VxEFb/UPL45+U1UPR1cG03DWiI=",
         |            "nonce" : "eQD9vT9PUT5udu+MemJrOATC9IxnzZrC51zsxRJJYUbWS1UjACABeKFnq6PSPNyR+wn9xIr3QpujMF8fSZ8pP2SXoeMQZldJgRAYrd7Mtd4QOu47v8K7jj1WbwbPK4nl"
         |        }
         |    },
         |    "websites" : [
         |        {
         |            "value" : "CMXnmByufUyZ7HoAAgV0bsWLfuXHEB/TC0708CfRCc1P4Lrn+QAqoaXgEO62",
         |            "nonce" : "90V+/kSyuETq/EMMq+Jw09S6O3aAxUYzzUBp//BYhCm+HQcfTRbZSPgthJeNcdB4Q6mQdpFGATHXb527sJWwmxcKD5Ttik7sUUxvFSW1x4Q7Mh++W83yMGI0JLqMtrxB"
         |        }
         |    ],
         |    "commencementDate" : "2023-05-01",
         |    "previousRegistrations" : [],
         |    "bankDetails" : {
         |        "accountName" : {
         |            "value" : "Cb/+GDx+GsIuFcvmuqHBCfHMZe8=",
         |            "nonce" : "YH5jvopoKdfOXSgD9rg8bRBmdKTXiLHWy8zjIKMOPnAI9dzYysSotxMhSB7Q2AKbW8pVxz/oAz1F3YfzQLQI23RJOTY241vwyODbd57Y9y8CjyhhnlEo7nBgSy+8aBWm"
         |        },
         |        "iban" : {
         |            "value" : "S12aqNdGPvjfN1U3TB7zT/Xwsd91HgOEK0d3ZDVDRhNAxKXr8DE=",
         |            "nonce" : "eFrFAo67NOjEQ9ksQhaGtqzEimAuZFwXaZYyvGi/YuhZ9SDFuOlaM/KW1rDrEcG4CXR9hhPxrlPFCpTDVgkifzSMRPYpfLFuVpzevrMuXnAJi94+aOssSX1qg4c+Hf8J"
         |        }
         |    },
         |    "isOnlineMarketplace" : {
         |        "value" : "XvTHgSg4RqSJEEQ1oJ/r8rvJV3tP",
         |        "nonce" : "ZC0bnrkk9NyfQC/ny73sWg9EJ23JySyQcmYmoHe9DjUX9Uv5Wl5B/gaLlwnD/5jL7EUPaA8PHk/s3yobEJf/1yaeUQboQRsIXnSZ1G5At/eq28mo6xT4M1I62LSN2MJ+"
         |    },
         |    "niPresence" : "principalPlaceOfBusinessInNi",
         |    "submissionReceived" : "2023-05-22T11:02:01.623800Z",
         |    "lastUpdated" : "2023-05-22T11:02:01.623801Z",
         |    "dateOfFirstSale" : "2023-05-01"
         |}
         |""".stripMargin,
      s"""
         |{
         |    "_id" : ObjectId("6475ac3918128b30fa58a6f6"),
         |    "vrn" : "300000003",
         |    "registeredCompanyName" : {
         |        "value" : "17xr9hqGnfAdWH3dFXO9bh5jVKP0Ie9pJacoEQ==",
         |        "nonce" : "0E9MT7ajy/4WzQTfrG9vuVpYeTGXz/bcn9VH8VdkfqALNQLefXOvcUMPA4UM8bpzFkkkz/EAFdnsadD3tNEsbNdEREjwo+ApSQjENCQmEKEGCDCBV0DK16f3ylLMJsVO"
         |    },
         |    "tradingNames" : [],
         |    "vatDetails" : {
         |        "registrationDate" : "2020-01-01",
         |        "address" : {
         |            "line1" : {
         |                "value" : "Pm5BS6RRxZzATVnxV6POEdCHh0wVNBxz17xpLQ==",
         |                "nonce" : "CLAUWdNqOdK6VH7LEKng2Ux+Q0WCel2UviBzoiSptiJpQn5PXOwHWZ/vZZ6vYlX5WNCZ31BvKTuluEYHks/VRlJZuhBdGHnTQ+cRbkd1aewUH4uUXYLxywYepzqa9tTI"
         |            },
         |            "line2" : {
         |                "value" : "b0dg+wSmxD3fTxEz8UdPHdmyu2MCDE1LGg==",
         |                "nonce" : "q/9tw/VhPhJT38nhDGOBYOHvuZFplcvghAJ6JRfEPRfiXkkcEEPmsqPsCRjXh5PQox7BQ95OpJSxLwm7vewrJBAso19CJQP9qVRpDV4smOxpDd5kn/D9N9O4V0Iw0+3G"
         |            },
         |            "postCode" : {
         |                "value" : "k6Z8fEW5vH0BPcx2szyty/xh4fuqVoig",
         |                "nonce" : "uJ6cCpOa/xHzEfoInf393GQWyEQ50pJ2PA8t7AT7E0QkvoJOwyVJZ+QzjjbRHhcQLRSz1SOIyfCrpNvFGcO1bjv0bGeelc6VEc1B2nchPf62Z54yD6vkdEsh8iLcRBxs"
         |            },
         |            "countryCode" : {
         |                "value" : "+VOUszJJQhLTU/uNj8hAfOyU",
         |                "nonce" : "01Vh0k1Dr5F0sPaQr0FDAc6IVVZxgKfyfPttiQ2997MRMXMracGae6ZPQzuBc/w6cUvOr9AbOzh4C7bpT/Zfoe4gfgf7WRO3P0cVg9lj129kuGM7IOmo91wayoIPB9lT"
         |            }
         |        },
         |        "partOfVatGroup" : {
         |            "value" : "mw9z538xjg0seT90XVXRyH5o4jWQ",
         |            "nonce" : "TMX3NLJ6sGDy8DMad87+C75dcFKd5fbA5XtoBZ7SZc0IiOC4rddbvZagBFahclkXWcCIuWFaacsU9lBRH26xSSnhWfwHQ2NJPSBSYdkh3pVZyt1AZQLVLo21O4TKHcsT"
         |        },
         |        "source" : "etmp"
         |    },
         |    "euRegistrations" : [
         |        {
         |            "country" : {
         |                "code" : {
         |                    "value" : "Ic55Wam2MgFNfTf7hv/YIibe",
         |                    "nonce" : "4NQ/z+8nm1gdJ4EpADVuG58zNX4UOXGotr0+9gAaR9i4XmsogqgVeyRI59z6vFjV1qFZbWKHOTWaCdro3xjFUIHjISS3d8+Q3W5l+4Wkjg/ulvIaH03691zVh1aQ5vsU"
         |                },
         |                "name" : {
         |                    "value" : "dlYsjTJzqmFE/CuuLGoQ2O0jSxRIta8=",
         |                    "nonce" : "+95UN1aTZGzI9qzfQAXWAHplzdz4uEPTvB1xZz9v3kS05cZC+8xo0kpO6LBT0oP4AsnnInAoLKSYhI5Cw23c7fLK8gpShY0RmnuZawvyfoR+1jzOMHmwGQ8hgh5+GFJ3"
         |                }
         |            },
         |            "taxIdentifier" : {
         |                "identifierType" : {
         |                    "value" : "/r8SPU7UpsoggcNUFCZZ+Xo4pg==",
         |                    "nonce" : "d82V6WJ/CzJ/Y3aG2ZOXb/rJdXQVrj3Utq5Xp9pGND0ey1pR6jhioOlHPIH6onvUuQPBaH29AnYsLMtgjnHcTiGNe4VkVFR1rzERCrhUfvQE2zvJiEvvTYVb1MSVys50"
         |                },
         |                "value" : {
         |                    "value" : "qBfC/4b9UuVr/iXpiiKakAqf27krJpuPGHA=",
         |                    "nonce" : "RAHkoTINAW9fiEl9Mtx7JLXRnw4KrbaKc8iNX72Iai/JpGoNq+oI6fiPGHwYfWa+BHWQKktoYJn+uwE/mdboqbO+wR6Totyby7i0EChmcni7YS/T6Dt6CdhcEJz4UqCh"
         |                }
         |            },
         |            "fixedEstablishment" : {
         |                "tradingName" : {
         |                    "value" : "EUEUe+kRYZXPvf5KzlXkOnvllmAs0CeItLlzJHnAEw==",
         |                    "nonce" : "vlthWF6gsb4tE7BpSaBE0x2QrGY0XORiPJtjDHhMmBbIhsN7M3ldEdq60ZSkYIxV1O8ylseKEG2xwlCgjJJcWplwBLqJGON56a18UinT4C0iS5YUC0DaJ3WV+T7o0hVK"
         |                },
         |                "address" : {
         |                    "line1" : {
         |                        "value" : "kFjV8alVNm27L84zOrV4XrOpzdcB16ZSfvmzrzcU",
         |                        "nonce" : "+1kOjvplAQ1jYmhs5w7/7wEn7DjH6fCaZsAP8y/oWJBvushblrtDFxXFqk0ozDqRXrsrNSKOTPIoSFWFWJOCC36iTI1i05Q+/6CbFsCGdR4fw6Rsxcv1vu+tLn6ned83"
         |                    },
         |                    "townOrCity" : {
         |                        "value" : "bRScDM68rr1SfZeBVW0eFwmZ+flOsiDv4g==",
         |                        "nonce" : "UbRANQrtCPyN9xKT+gVAe+d3v8zWVcDDXWjTusjRhqUVJ0tVvheVk6k0mzbR4qTMOyi8F5G7BX9XUQ5rIesDk44x8gz42CFJobD3hRppX0VXzlJmfoONlVsFLGYtlmbj"
         |                    },
         |                    "stateOrRegion" : {
         |                        "value" : "Yc78pHudQgcFqYaAhh3BGs6wJeKjGKB2oGE=",
         |                        "nonce" : "SQ4MAULjvHuXuuEojrvWxVlKdgsrgNMFu9rT5LlUYT5cKdps2qf01f3NEs20q7M33RMdlEewaqAxYlrxAq9Ks2guTgyjjdTXq380h9HpWgosq3Kmkv4R8/yelf1uNJs4"
         |                    },
         |                    "postCode" : {
         |                        "value" : "PMQI5qvqBVcCG961euWZVNaBKgHXlDqP",
         |                        "nonce" : "Zt+mqUbRBND32Qvqb00P2icq6NcO3rB4uXLyE+D59TYDVjqmNj1hnnIYztuVcn8ypNZIy/TfoONJHe/aap3FQXf4ScDHxxajCTRMymwgljXgyIBpZwDLYAJe7xn8vJqv"
         |                    },
         |                    "country" : {
         |                        "code" : "DK",
         |                        "name" : "Denmark"
         |                    }
         |                }
         |            }
         |        }
         |    ],
         |    "contactDetails" : {
         |        "fullName" : {
         |            "value" : "A4gBISd8TyiZ18ktxKlKj6WoZ/qWqZvlSg==",
         |            "nonce" : "GYE+EwFwdWUhC/VvJ69Gc9oRYgtO17FVHkGZPz71XBPFTUqVutQAmXTbORN5/2/q2q0PyMH5VrXd7pOkyaZ01dqrb8X8jms1s1f04Bao0xFQs6VkPgu8OxTbT9cLF3XA"
         |        },
         |        "telephoneNumber" : {
         |            "value" : "yNPsfo/cwbxJIW10j5Ve0MhBMzNYgh2TWjE=",
         |            "nonce" : "Qwa2oZ1Be+lS1lUFKgqoWgfwg7bd0DR+cqjTgpgcFVGglreD//swJySzyHNOAePtwOIv1C5NklT0T1QHRyFbEc2KCvdXlOvd5+iYuGMaUWOPXZnZJZJnLjEVBC/DA1if"
         |        },
         |        "emailAddress" : {
         |            "value" : "sCpv9zRIWI8CZH4YuUNyMD18jghw+J0W5KYUi15yHBl88A==",
         |            "nonce" : "MWzXGKavGu/5C9nyjjNP6/MDNg4c/MbVPS/crKrKBH/icHB//jsgrmp75vkM5iLSXHclHGdughQrn2TtLBjM7pzGU3fTjXDwg2T6F3EaxC4DiwC2YiQAh2r0HU8H3dK9"
         |        }
         |    },
         |    "websites" : [
         |        {
         |            "value" : "XUoOq80iWm9y0/Yvd3b8NMrH4eF/Bai0D6oaCyaX0uKYSJ/FS90=",
         |            "nonce" : "l2aUCuEJLc3ZZVz03gqBFCJX0Y29DVOenzHwHwylaNkT+m6pSVzqKdAvcdClmyOXaajISNxgn6r2IKLBd2+xyCk9Oza22JGph7C0v+MS0qv2lASNNj/R0J1TjWT5Q+F+"
         |        },
         |        {
         |            "value" : "w4XfWsS0Vj0JoCf6iv6JnyIClaZILp8cbonKk1FmR54AfSfsMKAXiuIp1WowjMMTXA==",
         |            "nonce" : "EvBkrAei3oymaP4/qW9wAdhlW9W0jAnHkqg4KNbmw8auw5meuDR3yfA6AcGCPnZMlse6c23VzHTGXSNs8AtbhsrULkZ3xG64mLVT4x/jmEmSVzCrPNgopHLjAZqDoaN2"
         |        }
         |    ],
         |    "commencementDate" : "${LocalDate.now().minusDays(1)}",
         |    "previousRegistrations" : [
         |        {
         |            "country" : {
         |                "code" : {
         |                    "value" : "nuCt6CaEF5jwN4XOju/z6/cs",
         |                    "nonce" : "ayp+kmPV4JWSxIGjDLipyF7wZMG7JpCYr3sW4wj6JvB7zbCLJLPlZJxO9KoiGtZMIIdlkgTdnQhOA166f8QrlHI8jApEbIO/5bxVy4fQJ0URZpTB361XHVI99LxCZfep"
         |                },
         |                "name" : {
         |                    "value" : "fIwxQVeK8Hd+KvNsyitMIC2LC7kjLqU=",
         |                    "nonce" : "j/iSThsumwsc35MRyRzhCJrLCs92MltEEB7R4EB0uifaMOmhrG0unjPJhsrmQ2DQ0WQGdKawsornixrPb/36OAeOh1DY2WZUcR/fBOApFfDC0o110qIGpOugvumqh855"
         |                }
         |            },
         |            "previousSchemeDetails" : [
         |                {
         |                    "previousScheme" : {
         |                        "value" : "Is3SWwDCj1Xbb+91dLvagocHsbU=",
         |                        "nonce" : "nXjy5Y7QT4KcBPmhw53xjqYHFASthe20zWXmOr8LORpnux9MuoFfUAyCIvFhVGtYhSn+OQVfT3I4/FciXnr916rFTGLDc0N31E1yPdmjV+rBUgOgW5jk5DQ5J9FDX1JB"
         |                    },
         |                    "previousSchemeNumbers" : {
         |                        "previousSchemeNumber" : {
         |                            "value" : "5n2K5GvKVa9Yp7az8F/dYbFLBqni2b/WDzuldQ==",
         |                            "nonce" : "ZleQwhzVhOL8hhEOsol10I3UsuzRnaWkAdnS3LnLHzNNQxCs2H90fmXDbbKvGmWwurH0CIzd60Dkclr6BcZbGSGmQ9bYg0cuAdXcsX26KFn13E+/Ux0pgFum8Wqz6mm7"
         |                        }
         |                    }
         |                }
         |            ]
         |        }
         |    ],
         |    "bankDetails" : {
         |        "accountName" : {
         |            "value" : "vNrLtGCuGs69ruf5vW7SA19l+9m8coKqtw==",
         |            "nonce" : "o+YvGjhnaQ5//OtxbTan3PTG7DpxV0D6Z1uvXh2AnM/nUvhRJ8yxs5OXbSsib0FNDAKKEHetPhe35jyv0dW5X17yB7Xj0rYpstcyQOeQRGAUv9eGVwAqGwC/uEUpAGB+"
         |        },
         |        "iban" : {
         |            "value" : "VdQL9eN8E9rCrhGFqeJTyaaGmkF0ppMqKQ93sazYhKAXzuFTEmU=",
         |            "nonce" : "jJqq8tSo2NvpP8c2mk8Ao5pqoI4QGZwl66S5KIv6+9oalXkReEDxp+3WJOqfViwE4y+dsxlQgx8jS5pYgAMXXcmlZxOsXpd7oiT0W/eUhAAqusg+mCTe1hYJKg0yACpK"
         |        }
         |    },
         |    "isOnlineMarketplace" : {
         |        "value" : "VD3n3xNZTXl1/POGzMtakYJwjoKU",
         |        "nonce" : "t9gSM16Bekam+ze67+naJ3h/C3olxpnM+xQD4HlKHB98uSm/d/STjUSWYOl7rGuknO8v8xFeo/tUZTtbQF1Bt4IkwtEMze128uAuBsxwxrcZcZYaEnJo88cupckZZxA8"
         |    },
         |    "niPresence" : "principalPlaceOfBusinessInNi",
         |    "submissionReceived" : "2023-05-30T07:56:41.967955Z",
         |    "lastUpdated" : "2023-05-30T07:56:41.967957Z"
         |}
         |""".stripMargin,
      s"""
         |{
         |    "_id" : ObjectId("6475d8fa18128b30fa58a71d"),
         |    "vrn" : "777777771",
         |    "registeredCompanyName" : {
         |        "value" : "UnjgNI/1egzkhfPs0FnfxExXmvw5C3aSbZ6LSQ==",
         |        "nonce" : "8oooPC2xMgAna7VqF73hlhNxZeRPONTDgkr82+ZZtFp6DIvm/R6lSNlun0Xe0iU9XC8rVaZdB5ViIH+uK1VB4ES/z6z2Ya+uW/4uomf3mD7Pmyw2edDS2NExLchWgCTk"
         |    },
         |    "tradingNames" : [],
         |    "vatDetails" : {
         |        "registrationDate" : "2020-01-01",
         |        "address" : {
         |            "line1" : {
         |                "value" : "IMYG0LIjVF1QquU4jaiENU+ZNS0uSEmEN3wdEA==",
         |                "nonce" : "EYeoHyXI/+qkegf1fq/dvsHuFCWQPCBd+ZTJML6oge0FSoI7YYMio6UNqyqP2azDuRDqGK2mVgZ/Et28Ysa3/9oBSNBN7zXTjcdx11NlsfKgFav1xB1sgZ9TrREaOLHp"
         |            },
         |            "line2" : {
         |                "value" : "OClc84g4/kdk1j2aCKkqoG8si37zbM9wiw==",
         |                "nonce" : "V41l/4g5RHU6AZN1VDbPAEv22ci7/1Z/SeuimXbFbbWIdpPnI4h7Si+NEDc9rnbYAdJ7xgzsdG4ayY2HQxf/LsR9mnslQOhwhHbx06gDWGChoCzoIjm9eacxLzne6kBx"
         |            },
         |            "postCode" : {
         |                "value" : "9FWHlVio1g2fvTE25g5yXjSNmJjUCruj",
         |                "nonce" : "WYO11ru4T5Q1sUoEmERIIvBcJc1xKzU3CRuoujtyqptVJpWI9MueJ7frfCmSH1nIUmXaIVbVTAMwNrACTgPBctrt5ycemfl0cKu/3Ucqw0lxADcumqV8hxYqBc8hS2co"
         |            },
         |            "countryCode" : {
         |                "value" : "ZghMHG9j/ROBInUt0L5hqlYK",
         |                "nonce" : "C49v7F8XYCDuHLemYCc3sZjfmXxsszQu7aNpEHFq/IFT83oYDYxRzJOJDXcQHWGCDHw1iorLe+WjGKBEJ/p4+tXU0lE8Jhhvh+u9dyLCAwXqiKYTbtiLvMzOtWsmjfxG"
         |            }
         |        },
         |        "partOfVatGroup" : {
         |            "value" : "HUQ3ptnGV7SRutI1pKFVNaxXRsF9",
         |            "nonce" : "ZwULbUg8GAH+LNRIhsdNCv0Li9TCJkdN4PmpCS364Sto4rL4mplMJIj2sUKceUxALKXMXjx2/5Trvukwho5+e9VWcDkY5a/psNKDQjU3s2y336sMOtXfXO0gYqmLPGFP"
         |        },
         |        "source" : "etmp"
         |    },
         |    "euRegistrations" : [
         |        {
         |            "country" : {
         |                "code" : {
         |                    "value" : "tTVhhhdpNSDJhBSD7dZ16x+Q",
         |                    "nonce" : "QpmTRVfopJ/Cqt7sJk/wK/VnEH6QfbiqPanv0RFax5Ixuy/UdQFJ9V9iLZerfUcUR2+rxBbp+XsUq7+Egf/I7tRyLeMcJOa80Qg2yb7ABtCX5L5TzDklkKvfd4dNGsxs"
         |                },
         |                "name" : {
         |                    "value" : "XnwPhLdLqdUkEO5u0tBFxN8/j1lsYQ==",
         |                    "nonce" : "tgiN/0/hk3rC5L+9PvrHDFt7nInZCocyNYXu66uOA8iIC6cechAn/MT46q1MvDTjnjfM3xzkzNukIux3JUZKg6l2bikHkM+Qnay/gH9sfcssg8iOAdXPhhMA/lA/t06H"
         |                }
         |            },
         |            "taxIdentifier" : {
         |                "identifierType" : {
         |                    "value" : "QIxJ8W4ffCKZNi5wE3vd0BJqpA==",
         |                    "nonce" : "0xd27RCdbv4mCj8gisjydX04Qn6+sZkJ1RYUTrxqgXCUDIemuel6aFBfB9SUVknSS9XJj9jDGfeWvokGCMhG1wIy2X3eWAvaxZf3d4d+XQg/03ExO7IJCBAy622xeayL"
         |                },
         |                "value" : {
         |                    "value" : "Jyi4I7me6bzThX+7oM7tLOlSefUpTjRw7xQU5SI=",
         |                    "nonce" : "il74wbRWVXUCuOb8Avt/fjnqhBmOjkLs30xwWagDjlASuY7c/6+dZzgbfT6MfXjyCiKxq1jW84F4+ARqFeKbhVaaCgr1TNd6YZVEMHEOrsxQWltDipIBPa3M64uiayVN"
         |                }
         |            },
         |            "fixedEstablishment" : {
         |                "tradingName" : {
         |                    "value" : "ptaFUSLpqYfQGC2m446N8LUz9PZdaDZeIBxLy7VU",
         |                    "nonce" : "2XdW19scC4/TgIfqDXgp1mSE9uEv4wC6aLyNg6xszWRjHHa5pl7WFNvsyfzGkzNTXM2vEIXL+EYwbAelMgGrLLYDsNta3H7WkZPXvByNNi8brkzAMwaR+DqHQAZPnyau"
         |                },
         |                "address" : {
         |                    "line1" : {
         |                        "value" : "pYZNnQtdj1UoxTYL1A5qDmc34iqYpf4LEbyJ4XHC",
         |                        "nonce" : "mUVTa9PR6eemybfYZBlR/i0kRTjuhYju1wAiGh/R3fV7VHLjcgyoBBB5tpFza0GYaMDjZPS5XU+h/GLJpAYOgFzR4DMsA5qiV2wXybGAvkss/5w52jpljP7MY0f98Nfx"
         |                    },
         |                    "townOrCity" : {
         |                        "value" : "VRnhquBl0IIrVBcAQa4JN0fvvsIqLCFxlw==",
         |                        "nonce" : "Mb6FCBjpL8eHLYzQjelzfUTMOpr9Vg11ZqESZzNr1If41wszl0GGE64W0eNUgftxc6KMLLOK5ub4H0WWnkIkTHGEMG6pYkvcZhqzs3KTWqzEzBN7qHnpagdhF5rqmj0V"
         |                    },
         |                    "stateOrRegion" : {
         |                        "value" : "A9bLCwKa8g0QTAldOznuMnHdDUdjBYb/oZQ=",
         |                        "nonce" : "mpJdAkgAEnvoaO6ZVkaGiXf0ZdQpTpu73FfVZXcKzuEidjbiMswrHcdZU8NbmVRsTH5vaTkyNBBP5xuVNlMh+sae6AvOL1SiaAhJqnau/aQn+UQUayf0b420t0K5O1D9"
         |                    },
         |                    "postCode" : {
         |                        "value" : "EHWWKFxUtBZeub77RMFoGWbbDOtr5L6Ow5AW",
         |                        "nonce" : "x+iYNiQqQO5BOaZdjral6Hk93b0oV19x0uCgqZmD7FjkMavq9A1ToOuIH5Zk+He1k7JA3SLroHESBraBfKQeSyToGtlSTLvQfPNOGKsg6tckQL3PECAgTXg2BAlA872z"
         |                    },
         |                    "country" : {
         |                        "code" : "FR",
         |                        "name" : "France"
         |                    }
         |                }
         |            }
         |        },
         |        {
         |            "country" : {
         |                "code" : {
         |                    "value" : "hphL0j+EzRvXiDrTjyvoN2L9",
         |                    "nonce" : "qc1cfxJJrbtCNluuNrbZwdQ5eHSMu6dnB5xpKBfMpGZFNB04gDItvOYn3co6Xgl9snGxmGDhIRgsoWt5GimbhH0N1ETW1pTqEJhCDiqFQ/MVcF+Gk1TZ54PDbL/GS9H2"
         |                },
         |                "name" : {
         |                    "value" : "JJ46XXn2dlBOjpH5W1a6wC9A1izkO9c=",
         |                    "nonce" : "pTMQwUsaWyZhUgmaD5T59UYCLONlG3nSkU80CiIpQL52+s0JMDQ3mzCcxlXEYqw2g6UkfYrXaZwVIFKC4cI0j119lNDHaabo8S2d38WUEhGVtXHLGDxnuoZaegNBhBun"
         |                }
         |            },
         |            "taxIdentifier" : {
         |                "identifierType" : {
         |                    "value" : "csp08prxgrL22lKc7fuGKVIA7t7C",
         |                    "nonce" : "PEdBKa2rWH1tDb5paxMpjfUMFREgsr4mW4uyAlo2Kxc/bZvSeLddKQket/3UcnW8Ob8JbV4Rzdq2nBAIpAB6iaeZoWjd1e2jeLXX2RPBPOwKEuMi5I2KY8+A5/WriC+e"
         |                },
         |                "value" : {
         |                    "value" : "mgcQlUQ1Z3zRX4ynCs4jFMTNBirBdYI=",
         |                    "nonce" : "4HMa25Gc+A3p8+h70TfhCGEU5untPo9Mav3XAMbCQOqZolOwhrsOFjv7Xx5KTOSgjJRdxiCbpe4BWilO1aWWDvVhcxia1JaQXgNlrOLaOwVyAN5c0jgAomNvt8eBi3Qt"
         |                }
         |            },
         |            "tradeDetails" : {
         |                "tradingName" : {
         |                    "value" : "Dat64val7UbKbUVzX3rR+xCXiuCo6/Cyojd0PII2W5kU",
         |                    "nonce" : "eU/r9AU45kC50rRvddFdmK6elYUZOiaDK2eScarL8c0b3da/tG+VROWA59XP+htUBW4Ef6r9rbOAiZ/XONYCnwkGMUdSojqk2hKUhg4/bmPh5KVfmY/MVtJTF/OSR+UX"
         |                },
         |                "address" : {
         |                    "line1" : {
         |                        "value" : "euUBlw4EYLBc79n7xOfJt7/O80Dlb33wzTNDMWp1",
         |                        "nonce" : "QY3mtdCEH+LGdPP7kN/6lWE+AuFd41AQ8cWYBiRcGwso90fwMfG+TWCe7quyR0FFjXRnOrr4ugMg7WmQyuukmVP/ltHBOpzLam8G8pHq9VqbJ1q6RjLoHIk6HmTX3GvQ"
         |                    },
         |                    "townOrCity" : {
         |                        "value" : "54g7oYop/yADM8R/aRf2BpS4mNtvcTGlzw==",
         |                        "nonce" : "20i0HoNJoBo/BY5W79aaxXOJNfDVAGgyQlIKhfV7frIqa+UnxW5cqtqYyk+/aEQdD5S5dUZgmjwuwyWAtz4VAaJy7GUWjlZUxbxBByZvw2YlqrztPRpKssIvcxp68slC"
         |                    },
         |                    "stateOrRegion" : {
         |                        "value" : "PazLzIylmOfIqsOaZjjTDiOjzWWDC+Bs5Pg=",
         |                        "nonce" : "23ba7yZvP5Fo4eRHD92GmFIGQU2rqEoUXm3o1aWKi7KFmuBAnqaBCPMM2c4HgmHKO/hcdZpbMt1mRvErJySMBIgxjPmbvWWFDVOEpUY6EmAKRDTtwRNkakJrAqPzYWrS"
         |                    },
         |                    "postCode" : {
         |                        "value" : "bVIWBK5hoEIzJ6/jGYvupdO7AhxS67A=",
         |                        "nonce" : "iQ+TX1gm36IlXObCuZkvVqTAl8FRpLcMfLuEbo2aNvMgHaaBpAuE8ovdBIxEO+e4lwrku7JIlQYY6a9LBeVcZvtFMR28uSFi2a3uql8btmrrCH8T+mSxHcvJPdb9Scp1"
         |                    },
         |                    "country" : {
         |                        "code" : "BE",
         |                        "name" : "Belgium"
         |                    }
         |                }
         |            }
         |        },
         |        {
         |            "country" : {
         |                "code" : {
         |                    "value" : "E7mDteuDwyj4hMUZawCziTqg",
         |                    "nonce" : "wQzRrUbEDU1PXEyCcoseCE0tSmBVg7WYKA5TrPdl5EW9hf7+yeLUoh5u4B+tnDBT0gcrhaYXKeT8HZ9CxIrshWHECGlTFYi23wpAhWILPbLeySto3IS5ZuvwjnkfX/Ku"
         |                },
         |                "name" : {
         |                    "value" : "yl7kAXMvQuASLBvT7T4DU+Ejgu7a08OK",
         |                    "nonce" : "aZ5xIAZtqLRqSXeXWtR1vqHhvzdeO4oykc7tArZHhCMmVoAbbVaaCSxqWglI/S1w58ptQeQCIpMqAsMrlW7gt3hdYRWEap/hjrfq4mUr77B62kcuk3XOKrsK6JC3syYS"
         |                }
         |            },
         |            "taxIdentifier" : {
         |                "identifierType" : {
         |                    "value" : "5oyUeOgnLrbtataetxU4+Ch8cw==",
         |                    "nonce" : "7MU6WDREe3eZwWzJVvCn0zO+mxFIxoqsh3xuhiZcnjhZfIgenvaRQq0VuRkYB+SjarGWJ1+91V2VJ3vM1iC7b2gSkPosQQlkGJHJUNwLA5cTsW4pM8cwF6NSC7p2HSqd"
         |                },
         |                "value" : {
         |                    "value" : "hOnSIfyl2D0Fswd0qeSYo3V9YRJjAdbSAoLF",
         |                    "nonce" : "yvSMirWDpSKaeEyth5gMylU0WZqNQOby4Y9Xtw7VKONWdGDe6E1LdokKUbdMbyMX+77OZyr6thwgQlQmmIXz8tWU+XOH3EOKiRhTi5zB+hT4bzUSt9LugbyojK6kyfca"
         |                }
         |            },
         |            "fixedEstablishment" : {
         |                "tradingName" : {
         |                    "value" : "PSlMhXokTROzh3denJBtajdZujuV5n8iIGQgjtRDiA==",
         |                    "nonce" : "Z5vxuZQ3Mv9hIObPf6YxRclGfCNhJQkn5tz/Oam/sT5dMmxq/W9TR0leUAsG6ySjMol2CD/AmDk+2Do55POzBntoLH1gPol/U+39PhD5S9xil//xCbPfrfsKOoBWl+8Z"
         |                },
         |                "address" : {
         |                    "line1" : {
         |                        "value" : "2DnNzeUYQkOYoLwcE+FGxq7YskGea4/uWrIvQiKz",
         |                        "nonce" : "UmXv3opO0M8UWIs89ta3Yjx8TjtgJz1RjheODfEvTdehfDAxxnSYdl13TFqZtSxNR2rOR7FaK2/K0wqlyjjyfM8cLMik/UNGBZhhFWxTMVXrh9chQ+sVHoOad47214h/"
         |                    },
         |                    "townOrCity" : {
         |                        "value" : "ryFvmpp+ej7LmPLfLsvp1qgW3tOj1GwzaA==",
         |                        "nonce" : "EErvQco0mGshI4JdxlsbbWSgzQPuaaZLQKnQ/x/Y/pOJ8pAlkhOVtHwsWg8lMBeo+7W71AEyJL8g3Wi0Ui/pC/MDGhvqSjmPCi/3KknWmsEVdrwve4/51as+YTWH9FGt"
         |                    },
         |                    "stateOrRegion" : {
         |                        "value" : "UNI4jHXfKstPLQY/QousBOuBdJJy3/MAJBg=",
         |                        "nonce" : "heJx5prxGp7GiDCKYqewC4RShr5rpb9vvD/nWRLC7s+i95MW8Adip4AG/lFV+ao7zs0esASHenYxI7iwvMQ5fSP3HQirzr2NYQfkDu3vQZnXPXWxKpXV934gGTfBFsP3"
         |                    },
         |                    "postCode" : {
         |                        "value" : "unevI1W9dNtVahSM7yKQaPVSOklhvvg=",
         |                        "nonce" : "p7uJuaK8kVAM6qUXoU0L49Jhtia6fj0bUbsUVyGRcO0f5YDpRTxFgio1N49obG0/kT879mYEW7NZoOz80LGkzdUR7sS63bILCREPiG5FlaJ+OJZ7UB7pwTPEvmSgKrBy"
         |                    },
         |                    "country" : {
         |                        "code" : "BG",
         |                        "name" : "Bulgaria"
         |                    }
         |                }
         |            }
         |        },
         |        {
         |            "country" : {
         |                "code" : {
         |                    "value" : "zdYSFzfgZKc7I2JB9jG4fwqp",
         |                    "nonce" : "MWrjhxYaVesecBjt5xTAbmoJjRW0nYNfbmOZmhZ5wT3Ni06qqq7fg5j/Kk0DPGNh1FtN6g0l2Lb1I2VfwHdekgoNp7wkfB8UBFU3tA80r4wV55GTu9wu0DMQIlvOvzr7"
         |                },
         |                "name" : {
         |                    "value" : "sYd9w0FYVrbBWOf+F5t+aTGqV76mmzb9hDquAXCb",
         |                    "nonce" : "5p/1MKJHmFDR/Svs5ewJWhC1chkz61RDQBwu21tNxY0r7FS8IIClb49t3A7Ek9hyzI3k931a4AUo5VODXxWw5W2gQEKaz+nab9YWJ70vCxLqUlZAsd1daH2d242Sx+GH"
         |                }
         |            },
         |            "vatNumber" : {
         |                "value" : "Jgw0rmUlDHy7BfUpx+MKbSlbSHDN5FSe4J7D",
         |                "nonce" : "0tor7mkw6djRUxohnkF3Bl/dGHgESRf5Yxig/bdgtm2dllpZMYeFydSce+k4i0kV+sAp4bLjXFUdgLFTkxmgFye94J+YKPWnaqueZAdKd2xfHhSSUhbZSN9c4qq155Fe"
         |            }
         |        }
         |    ],
         |    "contactDetails" : {
         |        "fullName" : {
         |            "value" : "sHjorf6lBC7cc+rmpKufkDrSefSx8hUhmw==",
         |            "nonce" : "I0pu1KhSM8PdE+Lpa3ESEZFgkpfi9QL3tjvnj69pkZ+jGJDAAjlhUJA4lRc6Y/a4FxtaDGHClIWoE5NaZzPlNEW/uQmZde/emOS5bOu77lEyqEJrZQnFHs82feh3NAi1"
         |        },
         |        "telephoneNumber" : {
         |            "value" : "LPdb7OjudJtmcxT4CHcXiLgCwUpKOL9p",
         |            "nonce" : "j/wwM9280wC9XGJjDy/2GCNZUn45cJo+ycso4K5HBI6wA57BdWyWUcX8HdW5El9D08uPWEtYuIXp8QbPUvno7IXCKx/PgXCAQyGHInyF1PV9jWM+QWEnDPj8K5o2HD5R"
         |        },
         |        "emailAddress" : {
         |            "value" : "6KQ7n+bHoQa2Mohs6JWRvdWC4YShSPykfysiQKA=",
         |            "nonce" : "ci1r3RX/C5qGYKXrbDTpuY4AwK6UsMF3+FWWmBkWzL50Gl7qGCXjwaB5k31Q40cMkqgA1GhErN+thdgUmMAZ9NLDovWtXFywrrd+rcVLMMj0QK+NI8izEPGz6/eFwvDr"
         |        }
         |    },
         |    "websites" : [],
         |    "commencementDate" : "2023-05-01",
         |    "previousRegistrations" : [],
         |    "bankDetails" : {
         |        "accountName" : {
         |            "value" : "6Izbx1Fqjn6e3xLTeAEFmQ40Kt8=",
         |            "nonce" : "ccPt13SqW+oocYOPGWMcVWSXC2cBgzSI6G4b4QbmtuSEAIxupnYxP2pLXT6ZtaF+tTCBqwoRyh0ZWW8M8YlbbOhLuyNkF2U9I4gqmRjfvITaWiHzKWgz/12MHOin4hBl"
         |        },
         |        "iban" : {
         |            "value" : "owCcgBWxUQXCvE3C85GHMZGMN37FXdQSSAUiFpmXtoJcWxfttCA=",
         |            "nonce" : "X7+XXVSn6YGFKlikik4CFNjULJbguIBKkGc9Z3Ti7yphxuLoKOO8iNfptcI9Z3UP6k0QtxaellrvwdwDPZ/1unlkkHOCx0Q0KKIcs2CwFCVhE8yV+BnArWPYA3taq2rI"
         |        }
         |    },
         |    "isOnlineMarketplace" : {
         |        "value" : "sZCzUnHMijRWeYjR/cl1aVw/HXFi",
         |        "nonce" : "etUvHgzpX1hPGfAETUgkE42oAZ90efb+flTo3X0YMIn2YXbUAKXASkinIifymlE/AK4aHRbFSUd1sq2hZkvVxXfxvOMcU9/XtMA6Ldqf9EdQvN9OhEZo/urKdlFb+cIe"
         |    },
         |    "niPresence" : "principalPlaceOfBusinessInNi",
         |    "submissionReceived" : "2023-05-30T11:07:38.271416Z",
         |    "lastUpdated" : "2023-05-30T11:07:38.271417Z",
         |    "dateOfFirstSale" : "2023-05-01"
         |}
         |""".stripMargin
    )
}
