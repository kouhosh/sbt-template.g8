import Dependencies._

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

lazy val root = (project in file(".")).
  settings(
    name := "$name$",
    scalacOptions in (Compile, console) ~= (_ filterNot (suppressedInConsoleOptions.toSet)),
    scalacOptions in (Test, console) := (scalacOptions in (Compile, console)).value,
    libraryDependencies ++=
      cats ++
      List(
        scalaTest % Test,
      ),
  )
