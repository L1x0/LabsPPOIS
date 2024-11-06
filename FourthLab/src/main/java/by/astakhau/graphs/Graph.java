package by.astakhau.graphs;

import java.util.ArrayList;

public class Graph implements AdjacencyMatrix{
    private ArrayList<ArrayList<String>> adjacencyMatrix;

    public Graph() {}

    public Graph(Graph g) {
        this.adjacencyMatrix = g.getAdjacencyMatrix();
    }

    public ArrayList<ArrayList<String>> getAdjacencyMatrix() {
        return this.adjacencyMatrix;
    }

    @Override
    public boolean hasVertex() {
        return false;
    }

    @Override
    public boolean hasEdge(String firstVertex, String secondVertex) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getVertexCount() {
        return 0;
    }

    @Override
    public int getEdgeCount() {
        return 0;
    }

    @Override
    public int getVertexDegree() {
        return 0;
    }

    @Override
    public int getEdgeDegree() {
        return 0;
    }

    @Override
    public void addVertex() {

    }

    @Override
    public void addEdge(String FromVertex, String ToVertex) {

    }

    @Override
    public void removeVertex() {

    }

    @Override
    public void removeEdge(String FromVertex, String ToVertex) {

    }

    @Override
    public void clear() {

    }

    @Override
    public VertexIterator getVertexIterator() {
        return null;
    }

    @Override
    public EdgeIterator getEdgeIterator() {
        return null;
    }

    @Override
    public ConstEdgeIterator getConstEdgeIterator() {
        return null;
    }

    @Override
    public ConstVertexIterator getConstVertexIterator() {
        return null;
    }
}
