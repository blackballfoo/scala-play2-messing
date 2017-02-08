
name := """play-scala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
    .settings(
      scoverageSettings
    )
scalaVersion := "2.11.8"

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
// Resolver is needed only for SNAPSHOT versions
resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies ++= Seq(
  "com.adrianhurt" %% "play-bootstrap" % "1.1-P25-B3"
)

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test


lazy val scoverageSettings = {
  import scoverage.ScoverageKeys

  Seq(
    // Semicolon-separated list of regexs matching classes to exclude
    ScoverageKeys.coverageExcludedPackages := "<empty>;Reverse.*;router/*;view.*;",
    ScoverageKeys.coverageMinimum := 97,
    ScoverageKeys.coverageFailOnMinimum := true,
    ScoverageKeys.coverageHighlighting := true,
    parallelExecution in Test := false
  )
}


