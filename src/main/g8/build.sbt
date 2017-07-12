val suppressedInConsoleOptions = Seq(
  "-Xlint",
  "-Ywarn-unused",
  "-Ywarn-unused-import"
)

lazy val root = (project in file(".")).
  settings(
    name := "$name$",
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
      "-Ywarn-value-discard"
    ) ++ suppressedInConsoleOptions,
    scalacOptions in (Compile, console) ~= (_ filterNot (suppressedInConsoleOptions.toSet)),
    scalacOptions in (Test, console) := (scalacOptions in (Compile, console)).value,
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.1" % "test"
    )
  )
