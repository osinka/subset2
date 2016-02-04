organization := "com.osinka.subset"

name := "subset"

homepage := Some(url("https://github.com/osinka/subset2"))

startYear := Some(2013)

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.11.8", "2.12.1")

licenses += "Apache License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")

organizationName := "Osinka"

description := """MongoDB Document parser combinators and builders"""

scalacOptions ++= List("-deprecation", "-unchecked", "-feature")

libraryDependencies ++= Seq(
  "org.mongodb" % "mongo-java-driver" % "3.4.1",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

credentials <+= (version) map { version: String =>
  val file =
    if (version.trim endsWith "SNAPSHOT") "credentials_osinka"
    else "credentials_sonatype"
  Credentials(Path.userHome / ".ivy2" / file)
}

pomIncludeRepository := { x => false }

publishTo <<= (version) { version: String =>
  Some(
    if (version.trim endsWith "SNAPSHOT")
      "Osinka Internal Repo" at "https://r.osinka.co/content/repositories/snapshots/"
    else
      "Sonatype OSS Staging" at "https://oss.sonatype.org/service/local/staging/deploy/maven2/"
  )
}

useGpg := true

pomExtra := <xml:group>
    <developers>
      <developer>
        <id>alaz</id>
        <email>azarov@osinka.com</email>
        <name>Alexander Azarov</name>
        <timezone>Europe/Riga</timezone>
      </developer>
    </developers>
    <scm>
      <connection>scm:git:git://github.com/osinka/subset2.git</connection>
      <developerConnection>scm:git:git@github.com:osinka/subset2.git</developerConnection>
      <url>http://github.com/osinka/subset2</url>
    </scm>
    <issueManagement>
      <system>github</system>
      <url>http://github.com/osinka/subset2/issues</url>
    </issueManagement>
  </xml:group>
