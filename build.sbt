organization := "com.github.biopet"
name := "test-utils"

scalaVersion := "2.11.11"

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.1"
libraryDependencies += "org.mockito" % "mockito-all" % "1.9.5"
libraryDependencies += "org.testng" % "testng" % "6.8"

parallelExecution in Test := false
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
