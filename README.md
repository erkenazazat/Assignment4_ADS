**Student:** Yerkenaz Azat
**Group:** SE-2514

## Project Overview
This project focuses on implementing a graph data structure using an **Adjacency List** and exploring traversal algorithms.
* **Vertices:** Represents a node in the graph, identified by a unique ID.
* **Edges:** Represents a connection between vertices.
* **BFS & DFS:** Two primary methods for visiting every node in a graph. **BFS** explores neighbors level-by-level, while **DFS** explores as deep as possible along each branch.

## Class Description
* **Vertex:** Contains a unique id with necessary getters and a toString() method.
* **Edges:** Stores source and destination vertices to represents connections.
* **Graph:** Manages the graph structure using an Adjacency List to store connections efficiently.
* **Experiment:** Handles the execution of traversals and measures performance for different graph sizes.

## Algorithm Descriptions
### 1.BFS
* **Step-by-step:** It uses a queue. Starting from a source node, it visits all immediate neighbors, then moves to the next level of neighbors.
* **Use Cases:** Finding the shortest path in unweighted graphs and peer-to-peer networks.
* **Time Complexity:** O(V + E)
### 2.DFS
* **Step-by-step:** It uses a Stack. It visits a neighbor and immediately moves deeper until it hits a dead end, then backtracks.
* **Use Cases:** Pathfinding in puzzles (like mazes) and detecting cycles.
* **Time Complexity:** O(V + E).

## Experimental Results
I performed experiments on three graph sizes (10, 30, and 100 vertices) to measure performance in nanoseconds.

| Graph Size | Algorithm | Execution Time (ns) |
| :--- | :--- | :--- |
| **Small (10 Vertices)** | BFS | 275,000 |
| | DFS | 81,292 |
| **Medium (30 Vertices)** | BFS | 179,834 |
| | DFS | 154,042 |
| **Large (100 Vertices)** | BFS | 824,708 |
| | DFS | 477,083 |

### Questions
* **How does graph size affect performance?** As the number of vertices increases, the execution time grows because the algorithms must process more nodes and edges.
* **Which traversal is faster?** In these experiments, **DFS was generally faster** than BFS for larger graphs.
* **Do results match O(V + E)?** Yes, the execution time increases proportionally to the size of the graph, matching theoretical complexity.
* **How does structure affect order?** The adjacency list order determines which neighbor is visited first.BFS visits breadth-wise, while DFS dives depth-wise.
* **When is BFS preferred?** When you need to find the shortest path from the starting vertex.
* **What are the limitations of DFS?** DFS does not guarantee the shortest path and can be inefficient in very deep graphs.

## Screenshots
* **Graph Structure Output:**  ![small_graph.png](docs/screenshots/small_graph.png)
* **Performance Results:** ![performance.png](docs/screenshots/performance.png)

## F. Reflection
During this implementation, I learned how graph representation impacts the efficiency of traversal algorithms. I observed the practical differences between BFS and DFS in terms of execution flow and memory usage.