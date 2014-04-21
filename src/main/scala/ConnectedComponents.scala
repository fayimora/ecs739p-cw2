/**
 * Author: Fayimora Femi-Balogun (fayi@fayimora.com)
 */

import org.apache.spark._
import org.apache.spark.graphx._
import java.io.{File, PrintWriter}

object ConnectedComponents {
  def main(args: Array[String]) {
    val jars = SparkContext.jarOfObject(this)
    val master = "spark://ricotta.student.eecs.qmul.ac.uk:7077"

    val conf = new SparkConf()
    conf.setAppName("Find Strongly Connected Components")
    conf.setMaster(master)
    conf.set("spark.executor.memory", "6g")
    conf.setJars(jars)

    val sc = new SparkContext(conf)

    val graph = GraphLoader.edgeListFile(sc, "hdfs://ricotta:54310/data/livejournal/soc-LiveJournal1.txt")
    val cc = graph.connectedComponents().vertices

    printToFile("livejournal-conected-components.txt")(p => cc.collect().foreach(p.println))
  }

  def printToFile(filename: String)(op: PrintWriter => Unit) {
    val p = new PrintWriter(new File(filename))
    try{ op(p) } finally { p.close() }
  }
}
