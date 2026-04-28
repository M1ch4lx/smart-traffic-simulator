val scala3Version = "3.8.3"

lazy val root = project
  .in(file("."))
  .settings(
    name := "smart-traffic-simulator-backend",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit" % "1.3.0" % Test,

    libraryDependencies ++= Seq(
      "com.softwaremill.sttp.tapir" %% "tapir-http4s-server" % "1.13.15",
      "com.softwaremill.sttp.tapir" %% "tapir-swagger-ui-bundle" % "1.13.15",
      "org.http4s" %% "http4s-ember-server" % "0.23.27"
    ),

    assembly / mainClass := Some("Main"),

    assembly / assemblyMergeStrategy := {
      case PathList("META-INF", xs @ _*) => MergeStrategy.discard
      case x => MergeStrategy.first
    }
  )
