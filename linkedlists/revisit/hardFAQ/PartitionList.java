package linkedlists.revisit.hardFAQ;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode smallerHead = null;
        ListNode smallerTail = null;
        ListNode greaterHead = null;
        ListNode greaterTail = null;
        ListNode currentNode = head;
        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = null;
            if (currentNode.val < x) {
                if (smallerHead == null) {
                    smallerHead = currentNode;
                    smallerTail = currentNode;

                } else {
                    smallerTail.next = currentNode;
                    smallerTail = currentNode;
                }

            } else {
                if (greaterHead == null) {
                    greaterHead = currentNode;
                    greaterTail = currentNode;

                } else {
                    greaterTail.next = currentNode;
                    greaterTail = currentNode;
                }
            }
            currentNode = nextNode;
        }
        // Connect both lists
        if (smallerTail != null) {
            smallerTail.next = greaterHead;
        }
        // If no smaller nodes exist
        if (smallerHead == null) {
            return greaterHead;
        }
        return smallerHead;
    }
}
