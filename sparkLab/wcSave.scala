/*
	Author: Gon-soo Moon
	Date: Feb 25, 2017
	Title: Word Count with saving file to HDFS
	Run command:
	spark-shell -i wcSave.scala	
*/

// Load file from HDFS
val textFile = sc.textFile("hdfs://hadoop-master:9000/user/parallels/sparkLab/gonsoo.txt")
// Map and reduce
val counts = textFile.flatMap(line => line.split(" ")).map(word => (word,1)).reduceByKey(_+_)
// Save file
counts.saveAsTextFile("hdfs://hadoop-master:9000/user/parallels/sparkLab/sparkout")

/*
Useful command

	
	hdfs dfs -rm -r sparkLab/sparkout
	hdfs dfs -ls sparkLab/sparkout
	hdfs dfs -cat sparkLab/sparkout/part-00000	

*/

