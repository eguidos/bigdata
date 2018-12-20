package br.com.semantix

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._
import br.com.qualidade.logs.hql.KpiAcessDia
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import scala.reflect.macros.whitebox
import scala.util.matching.Regex


object Execute {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder()
      .appName("desafio_semantix")
      .getOrCreate()

    import spark.sqlContext.implicits._

    val teste = spark.sparkContext.textFile("/project/desafio_semantix/NASA_access_log_Aug95 (1).gz")
    val logs = teste.toDF()
    val etl = logs.withColumn("host", split($"value", " ").getItem(0)).
      withColumn("time_stamp0", regexp_extract(col("value"), "\\[.*\\]", 0)).
      withColumn("time_stamp1", split($"time_stamp0", ":").getItem(0)).
      withColumn("time_stamp", regexp_replace($"time_stamp1", "\\[", "")).
      withColumn("request", regexp_extract(col("value"), """".*"""", 0)).
      withColumn("id_http", split($"value", " ").getItem(8)).
      withColumn("total_bytes", split($"value", " ").getItem(9)).
      select("host", "time_stamp", "request", "id_http", "total_bytes")

    println("Número de Hosts unicos: " + etl.select("host").distinct().count())

    println("Total de Erros 404: " + etl.filter(col("id_http") === 404).count())

    println("Os 5 URLs que mais causaram erros 404: ")
    etl.filter(col("id_http") === 404).groupBy("host").count().sort($"count".desc).show(5)

    println("Quantidade de Erros 404 por dia")
    etl.filter(col("id_http") === 404).groupBy("time_stamp").count().sort($"time_stamp".asc).show(false)

    etl.select(count("total_bytes").as("Total de bytes retornados")).show()

  }
}
