lazy val root = (project in file(".")).
  settings(
    name := "$name$",
    version := "$version$",
    scalaVersion := "$scalaVersion$",
    scalacOptions += "-feature",
    initialCommands in console := "import scalaz._, Scalaz._",
    libraryDependencies ++= Seq(
      "org.scalaz" %% "scalaz-core" % "7.2.6",
      "org.scalatest" %% "scalatest" % "3.0.1" % "test"
    )
  )
