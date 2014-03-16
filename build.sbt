name := "Coursework 2"

organization := "com.fayi.hpc"

version := "0.0.1"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "0.9.0-incubating"
)

initialCommands := "import com.fayi.hpc.coursework2._"

