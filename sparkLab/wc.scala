val f = sc.textFile("hdfs://hadoop-master:9000/user/parallels/sparkLab/gonsoo.txt")
val words = f.flatMap(l => l.split(" ")).map(word => (word,1))
words.reduceByKey(_+_).collect.foreach(println) 
System.exit(0)