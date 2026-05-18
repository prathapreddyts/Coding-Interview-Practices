package linkedlists.revisit;

public class StartingPointInLinkedList {
    public ListNode findStartingPoint(ListNode head) {
        if (head == null && head.next == null) {
            return head;
        }
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                break;
            }
        }
        //if no cycle detected fast pointer at end or it might be pointing null
        if (fastNode == null || fastNode.next == null) {
            return null;
        }
        ListNode startNode = head;
        while (startNode != slowNode.next) {
            slowNode = slowNode.next;
            startNode = startNode.next;
        }
        return startNode;

    }
}
