package by.astakhau.graphs;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Graph implements AdjacencyMatrix {
    private ArrayList<ArrayList<String>> adjacencyMatrix;

    public void setAdjacencyMatrix(ArrayList<ArrayList<String>> adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public Graph() {
        adjacencyMatrix = new ArrayList<>();
        adjacencyMatrix.add(new ArrayList<>());

        adjacencyMatrix.get(0).add("L");
    }

    public Graph(Graph g) {
        this.adjacencyMatrix = g.getAdjacencyMatrix();
    }

    public ArrayList<ArrayList<String>> getAdjacencyMatrix() {
        return this.adjacencyMatrix;
    }

    @Override
    public boolean hasVertex() {
        return !this.adjacencyMatrix.get(0).isEmpty();
    }

    @Override
    public boolean hasEdge(String firstVertex, String secondVertex) {
        if (!this.hasVertex()) {
            return false;
        } else {
            for (int i = 1; i < this.adjacencyMatrix.size(); i++) {
                for (int j = 1; j < this.adjacencyMatrix.get(i).size(); j++) {
                    if (this.adjacencyMatrix.get(i).get(j).equals("1")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.hasVertex();
    }

    @Override
    public int getVertexCount() {
        if (!this.hasVertex()) {
            throw new NoSuchElementException("Graph has no vertex");
        }
        return this.adjacencyMatrix.size() - 1;
    }

    @Override
    public int getEdgeCount() {
        if (!this.hasVertex()) {
            throw new NoSuchElementException("Graph has no vertex");
        }

        int count = 0;

        for (int i = 1; i < this.adjacencyMatrix.size(); i++) {
            for (int j = 1; j < this.adjacencyMatrix.get(i).size(); j++) {
                if (this.adjacencyMatrix.get(i).get(j).equals("1")) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int getInVertexDegree(String name) {
        getVertexException(name);

        int count = 0;

        for (int i = 1; i < this.adjacencyMatrix.size(); i++) {
            if (this.adjacencyMatrix.get(i).get(this.adjacencyMatrix.indexOf(name)).equals("1")) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int getOutVertexDegree(String name) {
        getVertexException(name);

        int count = 0;
        for (int i = 1; i < this.adjacencyMatrix.size(); i++) {
            if (this.adjacencyMatrix.get(this.adjacencyMatrix.indexOf(name)).get(i).equals("1"))
                count++;
        }
        return count;
    }

    private void getVertexException(String name) {
        if (!this.hasVertex()) {
            throw new NoSuchElementException("Graph has no vertex");
        }

        boolean found = false;

        for (int i = 1; i < this.adjacencyMatrix.size(); i++) {
            if (this.adjacencyMatrix.get(i).get(0).equals(name)) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw new NoSuchElementException("Graph has no vertex " + name);
        }
    }

    @Override
    public void addVertex(String name) {
        this.adjacencyMatrix.add(new ArrayList<>());
        this.adjacencyMatrix.get(this.adjacencyMatrix.size() - 1).add(name);
        this.adjacencyMatrix.get(0).add(this.adjacencyMatrix.get(0).size() - 1, name);


        for (int i = 1; i < this.adjacencyMatrix.size() - 1; i++) {
            this.adjacencyMatrix.get(i).add(this.adjacencyMatrix.get(i).size() - 1, "0");
        }

        while (this.adjacencyMatrix.get(adjacencyMatrix.size() - 1).size() != adjacencyMatrix.get(0).size()) {
            this.adjacencyMatrix
                    .get(adjacencyMatrix.size() - 1)
                    .add(this.adjacencyMatrix.get(0).size() - 1, "0");
        }
    }

    public void addVertex(String name, int index) {
        this.adjacencyMatrix.add(new ArrayList<>());
        this.adjacencyMatrix.get(index).add(name);
        this.adjacencyMatrix.get(0).add(index, name);


        for (int i = 1; i < this.adjacencyMatrix.size() - 1; i++) {
            this.adjacencyMatrix.get(i).add(index, "0");
        }

        while (this.adjacencyMatrix.get(index).size() != adjacencyMatrix.get(0).size()) {
            this.adjacencyMatrix
                    .get(index)
                    .add(index, "0");
        }
    }

    @Override
    public void addEdge(String FromVertex, String ToVertex) {
        if (!this.hasVertex()) {
            throw new NoSuchElementException("Graph has no vertex");
        }
        getVertexException(FromVertex);
        getVertexException(ToVertex);

        int firstIndex = 0;
        int secondIndex = 0;

        for (int i = 1; i < this.adjacencyMatrix.size(); i++) {
            if (this.adjacencyMatrix.get(i).get(0).equals(FromVertex)) {
                firstIndex = i;
                break;
            }
        }

        for (int i = 1; i < this.adjacencyMatrix.get(0).size(); i++) {
            if (this.adjacencyMatrix.get(0).get(i).equals(ToVertex)) {
                secondIndex = i;
                break;
            }
        }

        this.adjacencyMatrix.get(firstIndex).set(secondIndex, "1");
    }

    @Override
    public void removeVertex(String name) {
        if (!this.hasVertex()) {
            throw new NoSuchElementException("Graph has no vertex");
        }
        getVertexException(name);

        for (int i = 1; i < this.adjacencyMatrix.size(); i++) {
            if (this.adjacencyMatrix.get(i).get(0).equals(name)) {
                this.adjacencyMatrix.remove(i);
                break;
            }
        }

        this.adjacencyMatrix.get(0).remove(adjacencyMatrix.get(0).indexOf(name));
    }

    @Override
    public void removeEdge(String FromVertex, String ToVertex) {
        if (!this.hasVertex()) {
            throw new NoSuchElementException("Graph has no vertex");
        }
        getVertexException(FromVertex);
        getVertexException(ToVertex);

        int firstIndex = 0;
        int secondIndex = 0;

        for (int i = 1; i < this.adjacencyMatrix.size(); i++) {
            if (this.adjacencyMatrix.get(i).get(0).equals(FromVertex)) {
                firstIndex = i;
                break;
            }
        }

        for (int i = 1; i < this.adjacencyMatrix.get(0).size(); i++) {
            if (this.adjacencyMatrix.get(0).get(i).equals(ToVertex)) {
                secondIndex = i;
                break;
            }
        }

        this.adjacencyMatrix.get(firstIndex).set(secondIndex, "0");
    }

    @Override
    public void clear() {
        this.adjacencyMatrix.clear();
    }

    @Override
    public VertexIterator getVertexIterator(int startPoint) {
        return new VertexIterator(startPoint, this);
    }

    @Override
    public EdgeIterator getEdgeIterator(int startX, int startY) {
        return new EdgeIterator(startX, startY, this);
    }

    @Override
    public ConstEdgeIterator getConstEdgeIterator(int startX, int startY) {
        return new ConstEdgeIterator(startX, startY, this);
    }

    @Override
    public ConstVertexIterator getConstVertexIterator(int startPoint) {
        return new ConstVertexIterator(startPoint, this);
    }

    public IteratorOverIncidentVertices getIteratorOverIncidentVertices(String name) {
        return new IteratorOverIncidentVertices(name, this);
    }
}