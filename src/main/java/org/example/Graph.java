package org.example;
import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjList;

    public Graph() {
        adjList=new HashMap<>();
    }
    public void addVertex(Vertex v) {
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
    }
    public void addEdge(int from, int to) {
        adjList.get(from).add(to);
    }
    public void printGraph() {
        for (Integer key: adjList.keySet()) {
            System.out.println("Vertex "+key+"neighbors: "+adjList.get(key));
        }
    }
    public void bfs(int start) {
        Set<Integer> visited=new HashSet<>();
        Queue<Integer> queue=new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int current=queue.poll();
            System.out.print(current+" ");

            for (int neighbor:adjList.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
    public void dfs(int start) {
        Set<Integer> visited=new HashSet<>();
        dfsHelper(start, visited);
    }
    private void dfsHelper(int current, Set<Integer> visited) {
        visited.add(current);
        System.out.print(current+" ");

        for (int neighbor:adjList.getOrDefault(current, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }
}