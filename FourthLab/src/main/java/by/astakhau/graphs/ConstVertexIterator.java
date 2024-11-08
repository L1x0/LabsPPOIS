package by.astakhau.graphs;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ConstVertexIterator implements ConstIterator<String> {
    private int actualPoint;
    Graph graph;
    private ArrayList<ArrayList<String>> adjacencyMatrix;

    public ConstVertexIterator(int startPoint, Graph graph) {
        if (startPoint <= 0) {
            throw new IllegalArgumentException("startPoint must be greater than zero");
        }

        this.actualPoint = startPoint;
        this.graph = graph;
        this.adjacencyMatrix = graph.getAdjacencyMatrix();
    }

    public ConstVertexIterator(Graph graph) {
        this.graph = graph;
        this.adjacencyMatrix = graph.getAdjacencyMatrix();
    }

    @Override
    public boolean hasNext() {
        return actualPoint + 1 <= adjacencyMatrix.size() - 1;
    }

    @Override
    public String next() {
        actualPoint++;
        return this.adjacencyMatrix.get(0).get(actualPoint);
    }

    @Override
    public boolean hasPrevious() {
        return actualPoint - 1 >= 1;
    }

    @Override
    public String previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }

        actualPoint--;
        return this.adjacencyMatrix.get(0).get(actualPoint);
    }
}
