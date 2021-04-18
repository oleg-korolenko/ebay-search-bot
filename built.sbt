import sbt._
import Settings._
import Deps._

ThisBuild / organization := "com.reaktive-carrot"
ThisBuild / organizationName := "reaktive-carrot"

lazy val commonDeps = Seq(
  Deps.zio,
  Deps.zioInteropCats,
  Deps.zioLogging,
  Deps.zioTest,
  Deps.zioTestSbt
)

lazy val telegramClientServiceDeps = commonDeps ++ Seq(
  Deps.canoe,
  Deps.zioJson
)

lazy val domain = Project("domain", file("modules/domain"))
  .settings(commonSettings)

lazy val telegramClientService =
  Project("telegram-client-service", file("modules/telegramClientService"))
    .settings(commonSettings)
    .settings(libraryDependencies ++= telegramClientServiceDeps)
    .dependsOn(domain)

lazy val ebaySearchBot = Project("ebay-search-bot", file("."))
  .settings(commonSettings)
  .settings(moduleName := "ebay-search-bot")
  .aggregate(
    domain,
    telegramClientService
  )

addCommandAlias("fmt", "all scalafmtSbt scalafmt test:scalafmt")
addCommandAlias("fix", "; all compile:scalafix test:scalafix; all scalafmtSbt scalafmtAll")
addCommandAlias("check", "; scalafmtSbtCheck; scalafmtCheckAll; compile:scalafix --check; test:scalafix --check")
