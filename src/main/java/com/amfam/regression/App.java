package com.amfam.regression;

import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.ml.classification.LogisticRegression;
import org.apache.spark.ml.classification.LogisticRegressionModel;
import org.apache.spark.ml.classification.LogisticRegressionTrainingSummary;
import org.apache.spark.ml.feature.StringIndexer;
import org.apache.spark.ml.feature.VectorAssembler;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {

    private static Observation parseObs(double[] line) {
        //      if (line(9) == 4.0) 1 else 0, line(0), line(1), line(2), line(3), line(4), line(5), line(6), line(7), line(8)
        return new Observation(line[9] == 4.0 ? 1d : 0d, line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7], line[8]);
    }


    private static Dataset<Observation> parseRDD(Dataset<Row> rdd) {
        Dataset<Row> filter = rdd.drop().filter((FilterFunction<Row>) row -> !Objects.equals(row.getString(6), "?"));

        return filter.map((MapFunction<Row, Observation>) r -> null, Encoders.bean(Observation.class)
        );

    }


    public static void main(String[] args) {

        SparkSession spark = SparkSession
                .builder()
                .master("local[2]")
                .appName("JavaLogisticRegressionSummaryExample")
                .getOrCreate();


        SQLContext sqlContext = new SQLContext(spark.sparkContext());
        Dataset<Row> rdd = sqlContext.read().format("csv").option("header", "false").load("data/wbcd.csv");

        Dataset<Observation> dataset = parseRDD(rdd);

//        Dataset<Observation> obsRDD = dataset.map((MapFunction<double[], Observation>) App::parseObs, Encoders.bean(Observation.class));
//
//        String[] featureCols = {"thickness", "size", "shape", "madh", "epsize", "bnuc", "bchrom", "nNuc", "mit"};
//        VectorAssembler assembler = new VectorAssembler().setInputCols(featureCols).setOutputCol("features");
//        Dataset<Row> df2 = assembler.transform(obsRDD);
//
//        StringIndexer labelIndexer = new StringIndexer().setInputCol("clas").setOutputCol("label");
//        Dataset<Row> df3 = labelIndexer.fit(df2).transform(df2);
//
//        int splitSeed = 5043;
//        Dataset<Row>[] datasets = df3.randomSplit(new double[]{0.7, 0.3}, splitSeed);
//        Dataset<Row> trainingData = datasets[0];
//        Dataset<Row> testData = datasets[1];
//
//        LogisticRegression lr = new LogisticRegression().setMaxIter(10).setRegParam(0.3).setElasticNetParam(0.8);
//        LogisticRegressionModel model = lr.fit(trainingData);
//        Dataset<Row> predictions = model.transform(testData);
//
//        predictions.select("clas", "label", "prediction").show(5);
//
//        LogisticRegressionTrainingSummary trainingSummary = model.summary();
//        double[] objectiveHistory = trainingSummary.objectiveHistory();
//        Stream.of(objectiveHistory).forEach(System.out::println);


    }
}
