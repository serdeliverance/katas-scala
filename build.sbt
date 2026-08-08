ThisBuild / scalaVersion     := "3.8.4"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "io.github.serdeliverance"
ThisBuild / organizationName := "katas-scala"

lazy val root = (project in file("."))
  .settings(
    name := "katas-scala",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.13" % Test
  )