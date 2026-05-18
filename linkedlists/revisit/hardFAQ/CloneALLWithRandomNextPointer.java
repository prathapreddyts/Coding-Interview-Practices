package linkedlists.revisit.hardFAQ;

public class CloneALLWithRandomNextPointer {
    public RandomPointerNode copyRandomList(RandomPointerNode head) {
        if (head == null) {
            return null;
        }
        createRandomLinkedList(head);
        RandomPointerNode currentNode = head;
        updateRandomPointer(currentNode);
        return separateLinkedList(head);
    }

    private void updateRandomPointer(RandomPointerNode currentNode) {
        while (currentNode != null) {
            if (currentNode.random != null) {
                currentNode.next.random = currentNode.random.next;
            }
            currentNode = currentNode.next.next;
        }
    }

    public void createRandomLinkedList(RandomPointerNode currentNode) {
        while (currentNode != null) {
            RandomPointerNode temp = currentNode.next;
            RandomPointerNode newNode = new RandomPointerNode(currentNode.val);
            currentNode.next = newNode;
            newNode.next = temp;
            currentNode = temp;
        }
    }

    private RandomPointerNode separateLinkedList(RandomPointerNode head) {
        RandomPointerNode newHead = null;
        RandomPointerNode tail = null;
        RandomPointerNode currentNode = head;
        while (currentNode != null) {
            RandomPointerNode clonedNode = currentNode.next;
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
