import org.apache.spark.SparkContext
import SparkContext._

object WordCount {
  def main(args: Array[String]) = {
    val jars = SparkContext.jarOfObject(this)
    val master = "local"
    val sc = new SparkContext(master, "WordCountJob", null, jars)

    val file = sc.textFile(args(0))
    val wordCount = file.flatMap(l => tokenize(l)).map(w => (w, 1)).reduceByKey(_ + _)
    wordCount.saveAsTextFile(args(1))
  }

  private def tokenize(text : String) : Array[String] =
    text.toLowerCase.replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+")
}
