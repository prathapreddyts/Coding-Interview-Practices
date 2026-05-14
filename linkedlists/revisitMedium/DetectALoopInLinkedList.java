package linkedlists.revisitMedium;

public class DetectALoopInLinkedList {
    public boolean hasCycle(ListNode head) {
        if (head != null & head.next == head) {
            return true;
        }
        if (head == null) {
            return true;
        }
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                return true;
            }
        }
        return false;

    }
}
