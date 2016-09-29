lazy val root = (project in file(".")).
  settings(
    name := "$name$",
    version := "$version$",
    scalaVersion := "$scalaVersion$",
    libraryDependencies ++= Seq(
      "org.scalaz" %% "scalaz-core" % "7.2.6",
      "org.scalatest" %% "scalatest" % "2.2.4" % "test"
    )
  )
