package graphs.tuf.traversals;

import java.util.Iterator;

public class Pair {
    public int node;
    public Iterator<Integer> iterator;

    public Pair(int node, Iterator<Integer> iterator) {
        this.node = node;
        this.iterator = iterator;
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public Iterator<Integer> getIterator() {
        return iterator;
    }

    public void setIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }
}
