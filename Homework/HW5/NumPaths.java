package Homework.HW5;

import java.util.Scanner;

public class NumPaths {

    public int paths(int vertex, int start, int end, AdjacenyListGraph graph) {
        Queue queue = new Queue(100);
        boolean visited[] = new boolean[vertex];
        int opt[] = new int[vertex];

        queue.enqueue(start);
        visited[start] = true;
        opt[start] = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean[] CurrentVisited = new boolean[vertex];
            
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numVertex = scan.nextInt();
        int numEdges = scan.nextInt();
        AdjacenyListGraph graph = new AdjacenyListGraph(numVertex);
        for (int i = 0; i < numEdges; i++) {
            int start = scan.nextInt() - 1;
            int end = scan.nextInt() - 1;
            graph.addEdge(start, end);
        }
    }
}