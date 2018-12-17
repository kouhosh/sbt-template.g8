val suppressedInConsoleOptions = Seq(
  "-Xlint",
  "-Ywarn-unused",
  "-Ywarn-unused-import"
)

val catsVersion = "1.0.1"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      version := "$version$",
      scalaVersion := "$scalaVersion$",
    )),
    name := "$name$",
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
    scalacOptions in (Compile, console) ~= (_ filterNot (suppressedInConsoleOptions.toSet)),
    scalacOptions in (Test, console) := (scalacOptions in (Compile, console)).value,
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % catsVersion,
      "org.typelevel" %% "cats-free" % catsVersion,
      "org.scalatest" %% "scalatest" % "3.0.1" % "test"
    )
  )
