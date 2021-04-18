import sbt._
import org.scalafmt.sbt.ScalafmtPlugin.autoImport.scalafmtOnCompile
import sbt.Keys.{ scalacOptions, _ }

object Settings {

  /**
   * Default scalacOptions are injected with sbt-tpolecat plugin  (https://tpolecat.github.io/2017/04/25/scalac-flags.html)
   */
  val commonSettings =
    Seq(
      scalaVersion := "2.13.4",
      version := (version in ThisBuild).value,
      scalafmtOnCompile := true,
      testFrameworks := Seq(new TestFramework("zio.test.sbt.ZTestFramework")),
      cancelable in Global := true,
      fork in Global := true
    )

}
