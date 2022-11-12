package Homework.HW5;

public class AdjacencyMatrixGraph {
    private boolean adjacencyMatrix[][];
    private int numVertex;
    private boolean directed;

    public AdjacencyMatrixGraph(int numVertex, boolean directed) {
        this.numVertex = numVertex;
        adjacencyMatrix = new boolean[numVertex][numVertex];
        this.directed = directed;
    }

    public void addEdge(int i, int j) {
        if (directed) {
            adjacencyMatrix[i][j] = true;
        } else {
            adjacencyMatrix[i][j] = true;
            adjacencyMatrix[j][i] = true;
        }
    }

    public void removeEdge(int i, int j) {
        if (directed) {
            adjacencyMatrix[i][j] = false;
        } else {
            adjacencyMatrix[i][j] = false;
            adjacencyMatrix[j][i] = false;
        }
    }

    public boolean readMatrix(int i, int j) {
        return adjacencyMatrix[i][j];
    }

    public int length() {
        return numVertex;
    }

}
