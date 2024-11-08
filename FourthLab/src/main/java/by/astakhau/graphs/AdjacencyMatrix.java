package by.astakhau.graphs;

public interface AdjacencyMatrix {
    boolean hasVertex();
    boolean hasEdge(String firstVertex, String secondVertex);
    boolean isEmpty();

    int getVertexCount();
    int getEdgeCount();
    int getInVertexDegree(String name);
    int getOutVertexDegree(String name);

    void addVertex(String name);
    void addEdge(String FromVertex, String ToVertex);
    void removeVertex(String name);
    void removeEdge(String FromVertex, String ToVertex);
    void clear();

    VertexIterator getVertexIterator(int startPoint);
    EdgeIterator getEdgeIterator(int startX, int startY);
    ConstEdgeIterator getConstEdgeIterator(int startX, int startY);
    ConstVertexIterator getConstVertexIterator(int startPoint);
}
