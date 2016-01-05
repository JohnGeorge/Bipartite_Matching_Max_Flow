# Bipartite_Matching_Max_Flow
This is a solution of a bipartite matching, max flow problem written in Java using the Ford Fulkerson algorithm
### How the algorithm works.
to connect left side node to right side node, add edge method in main class 
where the first parameter is left side node and second parameter is the right side node.
e.g. 
```java
g.addEdge(1, 5);
```

###Output.
When running the program the output will look something like this.
```java
---------------
Bipartite graph
---------------
0 1 1 1 0 0 0 0 
0 0 0 0 0 1 0 0 
0 0 0 0 0 0 1 0 
0 0 0 0 1 0 0 0 
0 0 0 0 0 0 0 1 
0 0 0 0 0 0 0 1 
0 0 0 0 0 0 0 1 
0 0 0 0 0 0 0 0 
---------------
 Maxflow is 3
---------------
```
It will present you with a matrix with the connections between the nodes and the maximum flow between them.
