package linkedlists.revisit.beginner;

import linkedlists.revisit.ListNode;

public class MiddleNode {

    public ListNode secondMiddleOfLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }

    public ListNode firstMiddleOfLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }
}
