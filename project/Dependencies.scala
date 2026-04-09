import sbt.*

object Dependencies {

  // format: off
  val test: Seq[ModuleID] = Seq(
    "uk.gov.hmrc"         %% "ui-test-runner"     % "0.53.0",
    "junit"                % "junit"              % "4.13.2",
    "org.mongodb.scala"   %% "mongo-scala-driver" % "5.6.4" cross CrossVersion.for3Use2_13,
    "org.playframework"   %% "play-json"          % "3.0.6"
  ).map(_ % Test)
  // format: on

}
