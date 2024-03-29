import Dependencies._

ThisBuild / scalaVersion     := "3.2.0"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "io.github.serdeliverance"
ThisBuild / organizationName := "katas-scala"

lazy val root = (project in file("."))
  .settings(
    name := "katas-scala",
    libraryDependencies += scalaTest % Test
  )