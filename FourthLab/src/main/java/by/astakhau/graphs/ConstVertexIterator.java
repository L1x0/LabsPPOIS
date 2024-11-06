package by.astakhau.graphs;

import java.util.ListIterator;

public class ConstVertexIterator implements ConstIterator<String> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public String next() {
        return "";
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public String previous() {
        return "";
    }
}
