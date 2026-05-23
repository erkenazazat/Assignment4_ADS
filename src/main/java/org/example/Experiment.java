package org.example;
import java.util.Random;

public class Experiment {
    public void runTraversals(Graph g, int startNode) {
        long startBfs=System.nanoTime();
        System.out.print("BFS Order: ");
        g.bfs(startNode);
        long endBfs=System.nanoTime();
        long durationBfs=endBfs-startBfs;

        long startDfs=System.nanoTime();
        System.out.print("\nDFS Order: ");
        g.dfs(startNode);
        long endDfs=System.nanoTime();
        long durationDfs=endDfs-startDfs;

        System.out.println("BFS execution time: "+durationBfs+"ns");
        System.out.println("DFS execution time: "+durationDfs+"ns");

        long startDijkstra=System.nanoTime();
        g.dijkstra(startNode);
        long endDijksta=System.nanoTime();
        long durationDijkstra=endDijksta-startDijkstra;
        System.out.println("Dijkstra execution time: "+durationDijkstra+"ns\n");
    }
    public void MultipleTests() {
        int[] sizes={10,30,100};
        Random random=new Random();

        for (int size:sizes) {
            System.out.println("Experiment: Graph with "+size+" vertices.");
            Graph graph=new Graph();

            for (int i=0; i<size; i++) {
                graph.addVertex(new Vertex(i));
            }
            for (int i=0; i<size*2; i++) {
                int from=random.nextInt(size);
                int to=random.nextInt(size);
                if (from!=to) {
                    int weight=random.nextInt(10)+1;
                    graph.addEdge(from,to, weight);
                }
            }
            if (size==10) {
                System.out.println("Graph Structure(Small): ");
                graph.printGraph();
            }
            runTraversals(graph,0);
        }
    }
}
