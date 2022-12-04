import java.util.Scanner;

public class SpanTree {
    class WUGraph {
        private int vertices;
        private int boss;
        private int size = 0;
        private LinkedList set;

        private LinkedList[] adjacencyList;

        public WUGraph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices];
            set = new LinkedList();
            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new LinkedList();
            }
            for (int i = 0; i < adjacencyList.length; i++) {
            }
        }

        public int getVertices() {
            return vertices;
        }

        class LinkedList {
            Node head;

            static class Node {
                int value;
                Node next;

                Node(int value) {
                    value = this.value;
                    next = null;
                }
            }

            public void insert(int data) {
                Node newNode = new Node(data);

                if (head == null) {
                    head = newNode;
                } else {
                    Node last = head;
                    while (last.next != null) {
                        last = last.next;
                    }
                    last.next = newNode;
                }
            }
        }

        class Edge {
            private int source;
            private int target;
            private int weight;

            public Edge(int source, int target, int weight) {
                this.source = source;
                this.target = target;
                this.weight = weight;
            }

            public int getSource() {
                return source;
            }

            public int getTarget() {
                return target;
            }

            public int getWeight() {
                return weight;
            }
        }

        public void setVertices(int vertices) {
            this.vertices = vertices;
        }

        public int getBoss() {
            return boss;
        }

        public void setBoss(int boss) {
            this.boss = boss;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public LinkedList getSet() {
            return set;
        }

        public void setSet(LinkedList set) {
            this.set = set;
        }

        public LinkedList[] getAdjacencyList() {
            return adjacencyList;
        }

        public void setAdjacencyList(LinkedList[] adjacencyList) {
            this.adjacencyList = adjacencyList;
        }

    }

    public static void init(WUGraph graph, int[] boss, int[] size, java.util.Set<Integer> set[]) {
        for (int i = 0; i < graph.getAdjacencyList().length; i++) {
            boss[i] = i;
            size[i] = 1;
            set[i] = new java.util.HashSet<>();
            set[i].add(i);
        }
    }

    public static void union(int u, int v, int[] size, int[] boss, java.util.Set<Integer> set[]) {
        if (size[boss[u]] >= size[boss[v]]) {
            set[boss[u]].addAll(set[boss[v]]);
            size[boss[u]] += size[boss[v]];
            for (Integer z : set[boss[v]]) {
                boss[z] = boss[u];
            }
        } else {
            set[boss[v]].addAll(set[boss[u]]);
            size[boss[v]] += size[boss[u]];
            for (Integer z : set[boss[u]]) {
                boss[z] = boss[v];
            }
        }
    }

    public static void run(WUGraph graph, Edge[] edges) {
        Edge[] T = new Edge[edges.length];
        int counter = 0, i = 0;
        while (i < edges.length) {
            if (edges[i].getInF() == 1)
                T[counter++] = edges[i];
            i++;
        }

        boolean[] visited = new boolean[graph.getSize()];
        graph.BFS(T[0].getFrom(), visited);
        for (Edge e : T) {

            if (e != null && (!visited[e.getFrom()] || !visited[e.getTo()])) {
                System.out.println("-1");
                return;
            }
        }

        Edge[] filteredEdges = new Edge[edges.length - (counter)];
        for (int j = 0, k = 0; j < edges.length; j++)
            if (edges[j].getInF() == 0)
                filteredEdges[k++] = edges[j];
        edges = MergeSort.sort(filteredEdges, filteredEdges.length);
        int[] boss = new int[graph.getSize()], size = new int[graph.getSize()];
        java.util.Set<Integer> set[] = new java.util.HashSet[graph.getSize()];
        init(graph, boss, size, set);

        int inF = counter, newCounter = 0;

        for (int j = 0; j < T.length; j++) {
            Edge e = T[j];
            if (e != null && boss[e.getFrom()] != boss[e.getTo()]) {
                union(e.getFrom(), e.getTo(), size, boss, set);
                newCounter++;
            }
        }

        if (inF != newCounter) {
            System.out.println("-1");
            return;
        }

        for (int j = 0; j < edges.length; j++) {
            Edge e = edges[j];
            if (boss[e.getFrom()] != boss[e.getTo()]) {
                T[counter++] = e;
                union(e.getFrom(), e.getTo(), size, boss, set);
            }
        }

        int total = 0;
        for (Edge e : T)
            if (e != null)
                total += e.getWeight();
        System.out.println(total);
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int size = Integer.parseInt(split[0]);
        Graph graph = new Graph(size + 1);
        Edge[] edges = new Edge[Integer.parseInt(split[1])];
        for (int i = 0; i < Integer.parseInt(split[1]); i++) {
            String currentLine = scanner.nextLine();
            String[] currentSplit = currentLine.split(" ");
            graph.connectWeightedUnDirected(Integer.parseInt(currentSplit[0]), Integer.parseInt(currentSplit[1]),
                    Integer.parseInt(currentSplit[2]), Integer.parseInt(currentSplit[3]));
            edges[i] = new Edge(Integer.parseInt(currentSplit[0]), Integer.parseInt(currentSplit[1]),
                    Integer.parseInt(currentSplit[2]), Integer.parseInt(currentSplit[3]));
        }
        run(graph, edges);
    }
}