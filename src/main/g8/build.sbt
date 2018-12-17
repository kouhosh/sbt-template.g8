val suppressedInConsoleOptions = Seq(
  "-Xlint",
  "-Ywarn-unused",
  "-Ywarn-unused-import"
)

inThisBuild(Seq(
  version := "$version$",
  scalaVersion := "$scalaVersion$",
  scalacOptions ++= Seq(
    "-deprecation",
    "-feature",
    "-unchecked",
    "-Xlint",
    "-Xfatal-warnings",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Ywarn-value-discard",
    "-Ypartial-unification",
  ) ++ suppressedInConsoleOptions,
))

val catsVersion = "1.0.1"

lazy val root = (project in file(".")).
  settings(
    name := "$name$",
    scalacOptions in (Compile, console) ~= (_ filterNot (suppressedInConsoleOptions.toSet)),
    scalacOptions in (Test, console) := (scalacOptions in (Compile, console)).value,
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % catsVersion,
      "org.typelevel" %% "cats-free" % catsVersion,
      "org.scalatest" %% "scalatest" % "3.0.1" % "test"
    )
  )
