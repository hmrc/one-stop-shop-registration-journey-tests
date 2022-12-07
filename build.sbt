lazy val testSuite = (project in file("."))
  .enablePlugins(SbtAutoBuildPlugin)
  .disablePlugins(JUnitXmlReportPlugin) //Required to prevent https://github.com/scalatest/scalatest/issues/1427
  .settings(
    name := "one-stop-shop-registration-journey-tests",
    version := "0.1.0",
    scalaVersion := "2.12.15",
    scalacOptions ++= Seq("-feature", "-Xfatal-warnings"),
    libraryDependencies ++= Dependencies.test,
    //The testOptions from SbtAutoBuildPlugin supports only ScalaTest. Resetting testOptions for Cucumber Tests.
    testOptions in Test := Seq.empty
  )
