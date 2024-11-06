package by.astakhau.graphs;

public class ConstEdgeIterator implements ConstIterator<String> {

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
