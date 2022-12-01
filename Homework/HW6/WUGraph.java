public class WUGraph {
    private int vertices;

    private LinkedList[] adjacencyList;

    public WUGraph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList();
        }
    }

    public int getVertices() {
        return vertices;
    }

    public void addEdge(int source, int target, int weight) {
        Edge nEdge = new Edge(source, target, weight);
        adjacencyList[source].insert(nEdge);
    }

    public int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    public void Union(int parent[], int x, int y) {
        parent[x] = y;

    }

    public static int isCycle(WUGraph graph) {
        int parent[] = new int[graph.getVertices()];

        for (int i = 0; i < parent.length; i++) {

        }
        return 0;
    }

    class LinkedList {
        Node head;

        static class Node {
            Object value;
            Node next;

            Node(Object obj) {
                value = obj;
                next = null;
            }
        }

        public void insert(Object data) {
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

}