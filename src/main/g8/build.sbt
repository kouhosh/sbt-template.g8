lazy val root = (project in file(".")).
  settings(
    name := "$name$",
    version := "$version$",
    scalaVersion := "$scalaVersion$",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "2.2.1" % "test"
    )
  )
