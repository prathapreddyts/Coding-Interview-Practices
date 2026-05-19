package linkedlists.revisit.hardFAQ;

public class ReverseNodesInKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = null;
        ListNode traverseNode = head;
        ListNode newTail = head;
        int len = getLengthOflinkedList(head);
        while (len >= k) {
            ListNode revhead = null;
            ListNode oldHead = traverseNode;
            int i = 0;
            while (i < k) {
                ListNode nextNode = traverseNode.next;
                traverseNode.next = revhead;
                revhead = traverseNode;
                traverseNode = nextNode;
                i++;
            }
            if (newHead == null) {
                newHead = revhead;
            } else {
                newTail.next = revhead;
            }
            newTail = oldHead;
            len = len - k;

        }
        if (newTail != null) {
            newTail.next = traverseNode;
        }
        return newHead;

    }

    public int getLengthOflinkedList(ListNode head) {
        ListNode currentNode = head;
        int count = 0;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }
}

