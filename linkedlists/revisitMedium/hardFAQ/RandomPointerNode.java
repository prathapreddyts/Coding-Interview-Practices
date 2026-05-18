package linkedlists.revisitMedium.hardFAQ;

public class RandomPointerNode {
    public int val;
    public RandomPointerNode next;
    public RandomPointerNode random;

    public RandomPointerNode() {
        val = 0;
        next = null;
        random = null;
    }

    public RandomPointerNode(int val) {
        this.val = val;
        next = null;
        random = null;
    }

    public RandomPointerNode(int val, RandomPointerNode next, RandomPointerNode random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}

