import NativePackagerHelper._

name := "Orac Entities"

organization := "io.elegans"

crossScalaVersions := Seq("2.12.4", "2.11.11")

resolvers ++= Seq("Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  Resolver.bintrayRepo("hseeberger", "maven"))

libraryDependencies ++= {
  val AkkaVersion       = "2.5.8"
  val AkkaHttpVersion   = "10.1.0"
  Seq(
    "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
    "com.typesafe.akka" %% "akka-testkit" % AkkaVersion,
    "com.typesafe.akka" %% "akka-typed" % AkkaVersion,
    "com.typesafe.akka" %% "akka-contrib" % AkkaVersion,
    "com.typesafe.akka" %% "akka-http-core" % AkkaHttpVersion,
    "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % AkkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-testkit" % AkkaHttpVersion,
    "org.scalaz" %% "scalaz-core" % "7.2.18"
  )
}

scalacOptions += "-deprecation"
scalacOptions += "-feature"
//scalacOptions += "-Ylog-classpath"

enablePlugins(GitVersioning)
enablePlugins(GitBranchPrompt)
enablePlugins(JavaServerAppPackaging)
enablePlugins(UniversalPlugin)

git.useGitDescribe := true

licenses := Seq(("GPLv2", url("https://www.gnu.org/licenses/old-licenses/gpl-2.0.md")))

