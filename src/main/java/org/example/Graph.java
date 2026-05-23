package org.example;
import java.util.*;

public class Graph {
    private Map<Integer, List<Edge>> adjList;
    private Map<Integer, Vertex> vertices;

    public Graph() {
        adjList=new HashMap<>();
        vertices=new HashMap<>();
    }
    public void addVertex(Vertex v) {
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
        vertices.putIfAbsent(v.getId(), v);
    }
    public void addEdge(int from, int to, int weight) {
        Vertex source=vertices.get(from);
        Vertex destination=vertices.get(to);

        if (source!=null && destination!=null) {
            Edge edge=new Edge(source, destination, weight);
            adjList.get(from).add(edge);
        }
    }
    public void printGraph() {
        for (Integer key: adjList.keySet()) {
            System.out.println("Vertex "+key+"neighbors: "+adjList.get(key));
        }
    }

    public void dijkstra(int start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Start vertex not found. ");
            return;
        }
        Map<Integer, Integer> distances=new HashMap<>();
        Set<Integer> visited=new HashSet<>();

        for (Integer vertexId:adjList.keySet()) {
            distances.put(vertexId, Integer.MAX_VALUE);
        }
        distances.put(start,0);

        for (int i=0; i<adjList.size(); i++) {
            int minVertex=-1;
            int minDistance=Integer.MAX_VALUE;

            for (Integer vertexId:adjList.keySet()) {
                if (!visited.contains(vertexId) && distances.get(vertexId)<minDistance) {
                    minDistance=distances.get(vertexId);
                    minVertex=vertexId;
                }
            }
            if (minVertex==-1) break;

            visited.add(minVertex);

            for (Edge edge:adjList.getOrDefault(minVertex, new ArrayList<>())) {
                int neighborId=edge.getDestination().getId();
                if (!visited.contains(neighborId)) {
                    int newDist=distances.get(minVertex)+edge.getWeight();
                    if (newDist<distances.get(neighborId)) {
                        distances.put(neighborId, newDist);
                    }
                }
            }
        }
        System.out.println("\nDijkstra Shortest paths from Vertex "+start+":");
        for (Map.Entry<Integer, Integer> entry:distances.entrySet()) {
            String distanceStr=entry.getValue()==Integer.MAX_VALUE ? "Unreachable":String.valueOf(entry.getValue());
            System.out.println(" To Vertex "+entry.getKey()+"-> Distance: "+distanceStr);
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

            for (Edge edge : adjList.getOrDefault(current, new ArrayList<>())) {
                int neighbor=edge.getDestination().getId();
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

        for (Edge edge : adjList.getOrDefault(current, new ArrayList<>())) {
            int neighbor=edge.getDestination().getId();
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }
}