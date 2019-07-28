name := "Scala-Try-Dockerize-Custom"

version := "0.1"

scalaVersion := "2.13.0"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http"  % "10.1.9",
  "com.typesafe.akka" %% "akka-stream" % "2.5.23",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.9",
)

lazy val root = (project in file("."))
  .enablePlugins(JavaAppPackaging, AshScriptPlugin, DockerPlugin)
  .settings(
    organization := "com.github.tozastation",
    name := "SampleServer",
    version := "1.0.0-SNAPSHOT",
    scalaVersion := "2.13.0",
    mainClass in (Compile, run) := Some("SampleServer"),
    dockerBaseImage := "java:8-jdk-alpine",
    dockerExposedPorts := Seq(3001)
  )

assemblyJarName := s"${name.value}-${version.value}.jar"
lazy val commonSettings = Seq(
  version := "0.1-SNAPSHOT",
  organization := "com.github.tozastation",
  scalaVersion := "2.10.1",
  test in assembly := {}
)

lazy val app = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    mainClass in assembly := Some("com.github.tozastation.SampleServer"),
  )