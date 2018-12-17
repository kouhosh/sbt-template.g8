import sbt._

object Dependencies {
  val catsVersion = "1.5.0"
  val catsEffectVersion = "1.1.0"
  lazy val cats = List(
    "org.typelevel" %% "cats-core" % catsVersion,
    "org.typelevel" %% "cats-free" % catsVersion,
    "org.typelevel" %% "cats-effect" % catsEffectVersion,
  )

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
}
