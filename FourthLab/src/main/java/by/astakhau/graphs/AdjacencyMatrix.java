package by.astakhau.graphs;

public interface AdjacencyMatrix {
    boolean hasVertex();
    boolean hasEdge(String firstVertex, String secondVertex);
    boolean isEmpty();

    int getVertexCount();
    int getEdgeCount();
    int getVertexDegree();
    int getEdgeDegree();

    void addVertex();
    void addEdge(String FromVertex, String ToVertex);
    void removeVertex();
    void removeEdge(String FromVertex, String ToVertex);
    void clear();

    VertexIterator getVertexIterator();
    EdgeIterator getEdgeIterator();
    ConstEdgeIterator getConstEdgeIterator();
    ConstVertexIterator getConstVertexIterator();
}
