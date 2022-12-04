public class WUGraph {
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

}