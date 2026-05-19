package linkedlists.revisit.beginner;

import linkedlists.revisit.ListNode;

public class ReverseLinkedList {
    public ListNode reverseLinkedList(ListNode head) {
        ListNode revHead = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = revHead;
            revHead = current;
            current = nextNode;
        }
        return revHead;
    }
}
