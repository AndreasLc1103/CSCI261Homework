package Homework.HW5;

import java.util.Scanner;

public class ConnectGraph {

    public static void dfsRunner(AdjacencyMatrixGraph g, int vertex) {
        boolean visited[] = new boolean[vertex];
        // counter to see if it gets through the
        int connections = 0;
        int counter = 0;
        while (counter < visited.length) {
            if (!visited[counter]) {
                dfs(g, counter, visited);
                connections++;
            }
            counter++;
        }
        System.out.println(connections - 1);
    }

    public static void dfs(AdjacencyMatrixGraph g, int started, boolean visit[]) {
        visit[started] = true;
        for (int i = 0; i < g.length(); i++) {
            if (g.readMatrix(i, started) && (!visit[i])) {
                dfs(g, i, visit);
            }
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numVertex = scan.nextInt();
        int numEdges = scan.nextInt();
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(numVertex, false);
        for (int i = 0; i < numEdges; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            graph.addEdge(start, end);
        }
        dfsRunner(graph, numVertex);
    }
}
