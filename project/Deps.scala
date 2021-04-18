import sbt._

object Versions {
  lazy val zio            = "1.0.5"
  lazy val zioJson        = "0.1.4"
  lazy val zioInteropCats = "2.4.0.0"
  lazy val zioLogging     = "0.5.8"
  lazy val canoe          = "0.5.1"
}

object Deps {
  lazy val zio            = "dev.zio" %% "zio"      % Versions.zio
  lazy val zioJson        = "dev.zio" %% "zio-json" % Versions.zioJson
  lazy val zioInteropCats =
    "dev.zio" %% "zio-interop-cats" % Versions.zioInteropCats
  lazy val zioLogging = "dev.zio" %% "zio-logging" % Versions.zioLogging

  lazy val zioTest    = "dev.zio" %% "zio-test"     % Versions.zio % Test
  lazy val zioTestSbt = "dev.zio" %% "zio-test-sbt" % Versions.zio % Test

  lazy val canoe = "org.augustjune" %% "canoe" % Versions.canoe
}
