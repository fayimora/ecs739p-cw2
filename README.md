CW-HPC-04 Social network analysis: community detection
===========

One of the main incentives of analyzing a social network graph is to identify what are the
relationships between the members of that network. The objective of this coursework is to implement
a community detection algorithm that computes a real world graph from Google+ users, and attempts
to identify communities of users with strong common links.


To run a job, open a terminal and load the sbt console, then run `runMain JobName <input-file> <output-path>`.

OR

run `sbt "runMain JobName <input-file> <output-path>"` in your terminal. Input file might be
optional depending on the program you are running.

`ConectedComponents.scala`  contains code used for finding connected components in both datasets
`Preprocessor.scala` contains code used to convert adjacency list to an edge list
`TriangleCount.scala` contains code used to find the number of triangles each node contains.
`WordCount.scala` is a word count program that was initially used to find the number of nodes in our graph

All The above mentioned scripts run in Apache Spark. The input could also be in the local file
system or HDFS. The output however is written to the local file system.

`create_mappings.py` code that we used to attempt renaming nodes in the G+ dataset
`sort.py` a utility to help sort output from triangles job

The `resources` folder contains the output we used in our analysis


