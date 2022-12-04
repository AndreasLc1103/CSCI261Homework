import java.util.Scanner;

public class NegativeCycle {

    public static void CheckIfNeg(Graph graph) {
        if (bellmanRunner(graph)) {
            System.out.println("\nYES");
        } else {
            System.out.println("\nNO");
        }
    }

    public static boolean isThereANegativeCycle(Graph graph, int[] dist, int src) {

        for (int i = 0; i < graph.getVertices(); i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        for (int i = 1; i <= graph.getVertices() - 1; i++) {

            for (int j = 0; j < graph.getEdges(); j++) {
                int s = graph.adjacency[j].src;
                int d = graph.adjacency[j].dest;
                int weight = graph.adjacency[j].weight;
                if (dist[s] != Integer.MAX_VALUE && dist[s] + weight < dist[d]) {
                    dist[d] = dist[s] + weight;
                }
            }
        }

        for (int i = 0; i < graph.edges; i++) {
            int s = graph.adjacency[i].src;
            int v = graph.adjacency[i].dest;
            int weight = graph.adjacency[i].weight;

            if (dist[s] != Integer.MAX_VALUE && dist[s] + weight < dist[v]) {
                return true;
            }

        }
        return false;
    }

    public static boolean bellmanRunner(Graph graph) {

        boolean[] visited = new boolean[graph.vertices];

        int[] distArr = new int[graph.vertices];

        for (int i = 0; i < graph.vertices; i++) {
            if (visited[i] == false) {
                if (isThereANegativeCycle(graph, distArr, i)) {
                    return true;
                }
                for (int j = 0; j < graph.vertices; j++) {
                    if (distArr[j] != Integer.MAX_VALUE) {
                        visited[j] = true;
                    }
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int v = scan.nextInt();
        int edges = scan.nextInt();
        Edge[] edgesList = new Edge[edges];
        for (int i = 0; i < edges; i++) {
            int src = scan.nextInt();
            int dest = scan.nextInt();
            int weight = scan.nextInt();
            Edge edge = new Edge(src, dest, weight);
            edgesList[i] = edge;
        }
        Graph graph = new Graph(v, edges, edgesList);
        CheckIfNeg(graph);
    }

    static class Edge {
        private int src;
        private int dest;
        private int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public Edge() {
            this.src = 0;
            this.dest = 0;
            this.weight = 0;
        }

        public int getSrc() {
            return src;
        }

        public void setSrc(int src) {
            this.src = src;
        }

        public int getDest() {
            return dest;
        }

        public void setDest(int dest) {
            this.dest = dest;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

    }

    static class Graph {
        // indicate number of vertexes
        private int vertices;
        private int edges;

        private Edge[] adjacency;

        public Graph(int v, int e, Edge[] edges) {
            this.vertices = v;
            this.edges = e;
            this.adjacency = edges;
        }

        public int getVertices() {
            return vertices;
        }

        public void setVertices(int vertices) {
            this.vertices = vertices;
        }

        public int getEdges() {
            return edges;
        }

        public void setEdges(int edges) {
            this.edges = edges;
        }

        public Edge[] getAdjacency() {
            return adjacency;
        }

        public void setAdjacency(Edge[] adjacency) {
            this.adjacency = adjacency;
        }

    }

}
