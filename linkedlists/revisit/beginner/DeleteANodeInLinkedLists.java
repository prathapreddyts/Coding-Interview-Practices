package linkedlists.revisit.beginner;

import linkedlists.revisit.ListNode;

public class DeleteANodeInLinkedLists {
    public ListNode deleteNode(ListNode head, ListNode node) {
        if (head == null) {
            return head;
        }
        if (head == node) {
            return head.next;
        }
        ListNode currentNode = head;
        ListNode previousNode = null;
        while (currentNode != null) {
            if (currentNode == node) {
                previousNode.next = currentNode.next;
                break;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;

        }
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }
        if (fastNode == null) {
            return head.next;
        }
        ListNode previousNode = null;
        while (fastNode != null) {
            previousNode = slowNode;
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        previousNode.next = slowNode.next;
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode currentNode = head;
        while (currentNode != null && currentNode.next != null) {
            if (currentNode.val == currentNode.next.val) {
                currentNode.next = currentNode.next.next;

            } else {
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    public ListNode deleteMiddle(ListNode head) {
        // Empty or single node
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slowNode = head;
        ListNode fastNode = head;
        ListNode previousNode = null;
        while (fastNode != null && fastNode.next != null) {
            previousNode = slowNode;
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        // Delete middle node
        previousNode.next = slowNode.next;
        return head;
    }

    public ListNode removeCycle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        // Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return head;
        }
        // Find cycle start
        ListNode startNode = head;
        while (startNode != slow) {
            startNode = startNode.next;
            slow = slow.next;
        }
        // Find last node in cycle
        int count=1;
        while (slow.next != startNode) {
            slow = slow.next;
            count++;
        }
        // Break cycle
        slow.next = null;
        return head;
    }

    public ListNode deleteTail(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        ListNode currentNode = head;
        ListNode previous = null;
        while (currentNode.next != null) {
            previous = currentNode;
            currentNode = currentNode.next;
        }
        previous.next = null;
        return head;
    }

    public int getLengthOfLinkedList(ListNode head) {
        ListNode currentNode = head;
        int count = 0;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }
}
