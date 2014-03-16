/**
 * Author: Fayimora Femi-Balogun (fayi@fayimora.com)
 * Date: 16/03/2014
 * Time: 16:46
 */

import org.apache.spark.SparkContext
import scala.util.{Try, Success, Failure}
import SparkContext._

object PreProcessor {
  def main(args: Array[String]) {
    val jars = SparkContext.jarOfObject(this)
    val master = "local"
    val sc = new SparkContext(master, "PreProcessorJob", null, jars)

    val file = sc.textFile(args(0))
    file.flatMap(line => tokenize(line)).saveAsTextFile(args(1))
  }

  private def tokenize(line: String): Array[String] = {
    val tokens = line.split(":")
    val node = tokens(0)
    val neighbours = Try(tokens(1)) match {
      case Failure(ex) => Array[String]("")
      case Success(st) => st.split(",")
    }
    neighbours.map(n => node + " " + n)
  }
}
