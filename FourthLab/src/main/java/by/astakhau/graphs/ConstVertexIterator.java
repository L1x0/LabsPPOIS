package by.astakhau.graphs;

import java.util.ArrayList;
import java.util.ListIterator;

public class ConstVertexIterator implements ConstIterator<String> {
    private int actualPoint;
    Graph graph;
    private ArrayList<ArrayList<String>> adjacencyMatrix;

    public ConstVertexIterator(int startPoint, Graph graph) {
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
        return actualPoint - 1 >= 0;
    }

    @Override
    public String previous() {
        actualPoint--;
        return this.adjacencyMatrix.get(0).get(actualPoint);
    }
}
