lazy val root = (project in file(".")).
  settings(
    name := "$name$",
    version := "$version$",
    scalaVersion := "$scalaVersion$",
    scalacOptions += "-feature",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.1" % "test"
    )
  )
