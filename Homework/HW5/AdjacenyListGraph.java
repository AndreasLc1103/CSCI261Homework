package Homework.HW5;

public class AdjacenyListGraph {
    int vertex;
    LinkedList list[];

    public AdjacenyListGraph(int vertex) {
        this.vertex = vertex;
        list = new LinkedList[vertex];
        for (int i = 0; i < vertex; i++) {
            list[i] = new LinkedList();
        }
    }

    public void addEdge(int source, int destination) {

        // add edge
        list[source].insert(destination);

        // add back edge ((for undirected)
        list[destination].insert(source);
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

}
