package by.astakhau.graphs;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class VertexIterator implements ListIterator<String> {
    private int actualPoint;
    Graph graph;
    private ArrayList<ArrayList<String>> adjacencyMatrix;

    public VertexIterator(int startPoint, Graph graph) {
        this.actualPoint = startPoint;
        this.graph = graph;
        this.adjacencyMatrix = graph.getAdjacencyMatrix();
    }

    public VertexIterator(Graph graph) {
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

    @Override
    public int nextIndex() {
        if (this.hasNext()) {
            return actualPoint + 1;
        }
        throw new NoSuchElementException("No more elements");
    }

    @Override
    public int previousIndex() {
        if (this.hasPrevious()) {
            return actualPoint - 1;
        }
        throw new NoSuchElementException("It is first element");
    }

    @Override
    public void remove() {
        graph.removeVertex(this.adjacencyMatrix.get(0).get(actualPoint));
        this.adjacencyMatrix = graph.getAdjacencyMatrix();
    }

    @Override
    public void set(String s) {
        this.adjacencyMatrix.get(0).set(actualPoint, s);
        this.adjacencyMatrix.get(actualPoint).set(0, s);

        graph.setAdjacencyMatrix(this.adjacencyMatrix);
    }

    @Override
    public void add(String s) {
        graph.addVertex(s, actualPoint);
    }
}
