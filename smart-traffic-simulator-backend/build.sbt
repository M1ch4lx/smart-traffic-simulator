val scala3Version = "3.8.3"

lazy val root = project
  .in(file("."))
  .settings(
    name := "smart-traffic-simulator-backend",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit" % "1.3.0" % Test,

    assembly / mainClass := Some("Main"),

    assembly / assemblyMergeStrategy := {
      case PathList("META-INF", xs @ _*) => MergeStrategy.discard
      case x => MergeStrategy.first
    }
  )
