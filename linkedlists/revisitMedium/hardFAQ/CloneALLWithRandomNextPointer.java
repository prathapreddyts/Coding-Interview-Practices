package linkedlists.revisitMedium.hardFAQ;

public class CloneALLWithRandomNextPointer {
    public ListNode copyRandomList(ListNode head) {
        if (head == null) {
            return null;
        }
        createRandomLinkedList(head);
        ListNode currentNode = head;
        updateRandomPointer(currentNode);
        return separateLinkedList(head);
    }

    private void updateRandomPointer(ListNode currentNode) {
        while (currentNode != null) {
            if (currentNode.random != null) {
                currentNode.next.random = currentNode.random.next;
            }
            currentNode = currentNode.next.next;
        }
    }

    public void createRandomLinkedList(ListNode currentNode) {
        while (currentNode != null) {
            ListNode temp = currentNode.next;
            ListNode newNode = new ListNode(currentNode.val);
            currentNode.next = newNode;
            newNode.next = temp;
            currentNode = temp;
        }
    }

    private ListNode separateLinkedList(ListNode head) {
        ListNode newHead = null;
        ListNode tail = null;
        ListNode currentNode = head;
        while (currentNode != null) {
            ListNode clonedNode = currentNode.next;
            // Restore original list
            currentNode.next = clonedNode.next;
            // Isolate cloned node
            clonedNode.next = null;
            // Build cloned list
            if (newHead == null) {
                newHead = clonedNode;
                tail = clonedNode;
            } else {
                tail.next = clonedNode;
                tail = clonedNode;
            }
            currentNode = currentNode.next;
        }
        return newHead;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode random;

    ListNode() {
        val = 0;
        next = null;
        random = null;
    }

    ListNode(int val) {
        this.val = val;
        next = null;
        random = null;
    }

    ListNode(int val, ListNode next, ListNode random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}

