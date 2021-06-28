package com.alexp

import org.apache.spark.sql.{DataFrame, SparkSession}

object MyJob {
  private val spark = SparkSession.builder
    .master("local[*]")
    .appName("SparkStreamingTask")
    .config("spark.sql.shuffle.partitions", 16)
    .config("spark.sql.streaming.checkpointLocation", "./checkpointTEST/")
    .getOrCreate()

  import spark.implicits._

  def main(args: Array[String]): Unit = {
    val expediaTestData = Seq(
      (4, "2015-07-17 09:32:04", 2, 3, 66, 467, 36345, 66.7913, 50, 0, 0, 0, "2017-08-22", "2017-08-23", 2, 0, 1, 11812, 1, 970662608801L),
      (5, "2015-07-17 09:32:04", 2, 3, 66, 467, 36345, 66.7913, 50, 0, 0, 0, "2017-08-24", "2017-08-26", 2, 0, 1, 11812, 1, 970662608801L),
      (6, "2015-07-17 09:32:04", 2, 3, 66, 467, 36345, 66.7913, 50, 0, 0, 0, "2017-08-26", "2017-08-27", 2, 0, 1, 11812, 1, 970662608801L),
      (7, "2015-07-17 09:32:04", 2, 3, 66, 467, 36345, 66.7913, 50, 0, 0, 0, "2017-08-27", "2017-08-30", 2, 0, 1, 11812, 1, 970662608801L),
      (8, "2015-07-17 09:32:04", 2, 3, 66, 467, 36345, 66.7913, 50, 0, 0, 0, "2017-08-22", "2017-08-23", 2, 0, 1, 11812, 1, 970662608802L),
      (8, "2015-07-17 09:32:04", 2, 3, 66, 467, 36345, 66.7913, 50, 0, 0, 0, "2017-08-23", "2017-08-24", 2, 0, 1, 11812, 1, 970662608802L)
    ).toDF("id", "date_time", "site_name", "posa_continent", "user_location_country", "user_location_region",
      "user_location_city", "orig_destination_distance", "user_id", "is_mobile", "is_package", "channel",
      "srch_ci", "srch_co", "srch_adults_cnt", "srch_children_cnt", "srch_rm_cnt", "srch_destination_id",
      "srch_destination_type_id", "hotel_id")

    func(expediaTestData)

    spark.stop()
  }

  def func(df: DataFrame) {
    df.show()
  }
}
