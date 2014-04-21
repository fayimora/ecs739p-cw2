name := "Coursework 2"

organization := "com.fayi.hpc"

version := "0.0.1"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "0.9.0-incubating",
  "org.apache.spark" %% "spark-graphx" % "0.9.0-incubating",
  "org.apache.hadoop" % "hadoop-client" % "2.0.0-cdh4.3.1",
  "org.apache.hadoop" % "hadoop-core" % "2.0.0-mr1-cdh4.3.1"
)

resolvers += "Akka Repository" at "http://repo.akka.io/releases/"

resolvers += "cloudera" at "https://repository.cloudera.com/artifactory/cloudera-repos/"

