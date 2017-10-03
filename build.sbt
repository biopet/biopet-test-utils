organization := "com.github.biopet"
name := "biopet-test-utils"

scalaVersion := "2.11.11"

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.1"
libraryDependencies += "org.testng" % "testng" % "6.8"

useGpg := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

import ReleaseTransformations._
releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  releaseStepCommand("publishSigned"),
  setNextVersion,
  commitNextVersion,
  releaseStepCommand("sonatypeReleaseAll"),
  pushChanges
)
