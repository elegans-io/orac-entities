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
    "com.typesafe.akka" %% "akka-http-spray-json" % AkkaHttpVersion,
    "org.scalaz" %% "scalaz-core" % "7.2.18"
  )
}

scalacOptions += "-deprecation"
scalacOptions += "-feature"
//scalacOptions += "-Ylog-classpath"

enablePlugins(GitBranchPrompt)
enablePlugins(GitVersioning)
enablePlugins(UniversalPlugin)

git.useGitDescribe := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>https://github.com/elegans-io/orac-entities</url>
    <licenses>
      <license>
        <name>GPLv2</name>
        <url>https://www.gnu.org/licenses/old-licenses/gpl-2.0.md</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:elegans-io/orac-entities.git</url>
      <connection>scm:git:git@github.com:elegans-io/orac-entities.git</connection>
    </scm>
    <developers>
      <developer>
        <id>angleto</id>
        <name>Angelo Leto</name>
        <url>http://www.elegans.io</url>
      </developer>
    </developers>)

licenses := Seq(("GPLv2", url("https://www.gnu.org/licenses/old-licenses/gpl-2.0.md")))
