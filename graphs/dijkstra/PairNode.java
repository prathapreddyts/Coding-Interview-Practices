package graphs.dijkstra;

import java.util.Comparator;

public class PairNode implements Comparator<PairNode> {
    public int node;
    public int distance;

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "PairNode{" +
                "node=" + node +
                ", distance=" + distance +
                '}';
    }

    @Override
    public int compare(PairNode pairNode1, PairNode pairNode2) {
        if (pairNode1.distance == pairNode2.distance) {
            return pairNode1.node - pairNode2.node;
        }
        return pairNode1.distance - pairNode2.distance;
    }
}
