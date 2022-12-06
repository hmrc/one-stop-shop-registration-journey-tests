import sbt._

object Dependencies {

  val test = Seq(
    "uk.gov.hmrc"         %% "webdriver-factory"  % "0.30.0"        % Test,
    "org.scalatest"       %% "scalatest"          % "3.2.12"        % Test,
    "org.scalatestplus"   %% "selenium-3-141"     % "3.2.10.0"      % Test,
    "com.vladsch.flexmark" % "flexmark-all"       % "0.64.0"        % Test,
    "io.cucumber"         %% "cucumber-scala"     % "8.2.6"         % Test,
    "io.cucumber"          % "cucumber-junit"     % "7.3.3"         % Test,
    "junit"                % "junit"              % "4.13.2"        % Test,
    "com.novocode"         % "junit-interface"    % "0.11"          % Test,
    "com.typesafe"         % "config"             % "1.4.2"         % Test,
    "org.mongodb.scala"   %% "mongo-scala-driver" % "4.6.0"         % Test,
    "com.typesafe.play"   %% "play-iteratees"     % "2.6.1"         % Test,
    "uk.gov.hmrc"         %% "play-language"      % "5.3.0-play-28" % Test
  )

}
