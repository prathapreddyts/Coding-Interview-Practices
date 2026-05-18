package linkedlists.revisitMedium.hardFAQ;

public class ReOrderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode currentNode = head;
        ListNode middleElement = getMiddleElement(currentNode);
        ListNode secondHalf = middleElement.next;
        ListNode reverseHead = reverseList(secondHalf);
        middleElement.next = null;
        ListNode firstHalf = head;
        while (reverseHead != null) {
            ListNode firstNext = firstHalf.next;
            ListNode secondNext = reverseHead.next;
            firstHalf.next = reverseHead;
            reverseHead.next = firstNext;
            firstHalf = firstNext;
            reverseHead = secondNext;
        }
    }

    public ListNode getMiddleElement(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode revHead = null;
        ListNode currentNode = head;
        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = revHead;
            revHead = currentNode;
            currentNode = nextNode;
        }
        return revHead;
    }
}
