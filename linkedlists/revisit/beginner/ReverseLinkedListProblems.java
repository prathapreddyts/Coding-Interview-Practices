package linkedlists.revisit.beginner;

import linkedlists.revisit.ListNode;

public class ReverseLinkedListProblems {
    // ===================== BASIC =====================

    // LC 206 - Reverse entire linked list (iterative)
    public ListNode reverseListIterative(ListNode head) {
        ListNode currentHead = head;
        ListNode revHead = null;
        while (currentHead != null) {
            ListNode nextNode = currentHead.next;
            currentHead.next = revHead;
            revHead = currentHead;
            currentHead = nextNode;

        }
        return revHead;
    }
    // ===================== MEDIUM =====================

    // LC 92 - Reverse linked list from position left to right
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head; // No reversal needed for an empty list or if left == right
        }
        ListNode current = head;
        ListNode previous = null;
        // Move `current` to the `left` position and `previous` to the node before `left`
        for (int i = 1; i < left; i++) {
            previous = current;
            current = current.next;
        }
        ListNode newHead = null; // Head of the reversed portion
        ListNode newTail = current; // Tail of the reversed portion (initially `current`)
        // Reverse the sublist from `left` to `right`
        for (int i = left; i <= right; i++) {
            ListNode next = current.next;
            current.next = newHead;
            newHead = current;
            current = next;
        }
        // Connect the reversed portion back to the list
        newTail.next = current; // Connect the tail of the reversed portion to the node after `right`
        if (previous != null) {
            previous.next = newHead; // Connect the node before `left` to the head of the reversed portion
        } else {
            head = newHead; // Update the head if the reversal starts at the first node
        }
        return head; // Return the updated list
    }

    // LC 25 - Reverse nodes in k-group
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = getLengthofLinkedList(head);
        ListNode newHead = null;
        ListNode currentNode = head;
        ListNode newTail = head;
        while (length >= k) {
            int grpCount = 0;
            ListNode oldHead = currentNode;
            ListNode revHead = null;
            while (grpCount < k && currentNode != null) {
                ListNode nextNode = currentNode.next;
                currentNode.next = revHead;
                revHead = currentNode;
                currentNode = nextNode;
                grpCount++;
            }
            if (newHead == null) {
                newHead = revHead;
            } else {
                newTail.next = revHead;
            }
            newTail = oldHead;
            length = length - k;
        }
        if (currentNode != null) {
            newTail.next = currentNode;
        }
        return newHead;
    }

    // LC 24 - Swap nodes in pairs (reverse in groups of 2)
    public ListNode swapPairs(ListNode head) {
        return null;
    }

    // LC 61 - Rotate list by k places to the right
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int len = getLengthofLinkedList(head);
        k = k % len;
        // No rotation needed
        if (k == 0) {
            return head;
        }
        ListNode currentNode = head;
        // Reach old tail
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        // Make circular
        currentNode.next = head;
        // Move to new tail
        int steps = len - k;
        while (steps > 0) {
            currentNode = currentNode.next;
            steps--;
        }
        // currentNode is new tail
        ListNode newTail = currentNode;
        // New head
        ListNode newHead = newTail.next;
        // Break cycle
        newTail.next = null;
        return newHead;
    }

    public int getLengthofLinkedList(ListNode head) {
        ListNode currentNode = head;
        int count = 0;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }

    public ListNode rotateRightIterative(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int len = getLengthofLinkedList(head);
        k = k % len;
        if (k == 0) {
            return head;
        }
        // Reverse entire list
        head = reverseBetweenTwoNodesIndex(head, 1, len);
        // Reverse first k nodes
        head = reverseBetweenTwoNodesIndex(head, 1, k);
        // Reverse remaining nodes
        head = reverseBetweenTwoNodesIndex(head, k + 1, len);
        return head;
    }

    public ListNode reverseBetweenTwoNodesIndex(ListNode head, int start, int end) {
        ListNode currentNode = head;
        ListNode previousNode = null;
        // Reach start position
        for (int i = 1; i < start; i++) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        ListNode newTail = currentNode;
        ListNode revHead = null;
        // Reverse sublist
        for (int i = start; i <= end; i++) {
            ListNode nextNode = currentNode.next;
            currentNode.next = revHead;
            revHead = currentNode;
            currentNode = nextNode;
        }
        // Connect tail of reversed list
        newTail.next = currentNode;
        // Connect previous part
        if (previousNode != null) {
            previousNode.next = revHead;
            return head;
        }
        // If reversing from head
        return revHead;
    }

    public ListNode getReverseLinkedList(ListNode head) {
        ListNode currentNode = head;
        ListNode revHead = null;
        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = revHead;
            revHead = currentNode;
            currentNode = nextNode;
        }
        return revHead;
    }

    // LC 2130 - Maximum twin sum of a linked list
    // Uses: find middle + reverse second half + compute max twin sum
    public int pairSum(ListNode head) {
        return 0;
    }
    // ===================== HARD / ADVANCED =====================

    // LC 2074 - Reverse nodes in even-length groups
    public ListNode reverseEvenLengthGroups(ListNode head) {
        return null;
    }

    // LC 1721 - Swapping nodes in a linked list (kth from start & end)
    public ListNode swapNodes(ListNode head, int k) {
        return null;
    }

    // LC 328 - Odd Even linked list (group odd/even index nodes)
    public ListNode oddEvenList(ListNode head) {
        ListNode currentNode = head;
        ListNode evenHead = null;
        ListNode evenTail = null;
        ListNode oddHead = null;
        ListNode oddTail = null;
        while (currentNode != null) {
            ListNode newNode = new ListNode(currentNode.val);
            // Even value node
            if (currentNode.val % 2 == 0) {
                if (evenHead == null) {
                    evenHead = newNode;
                    evenTail = newNode;
                } else {
                    evenTail.next = newNode;
                    evenTail = newNode;
                }

            }
            // Odd value node
            else {
                if (oddHead == null) {
                    oddHead = newNode;
                    oddTail = newNode;
                } else {
                    oddTail.next = newNode;
                    oddTail = newNode;
                }
            }
            currentNode = currentNode.next;
        }
        // If no odd nodes
        if (oddHead == null) {
            return evenHead;
        }
        // Connect odd list with even list
        oddTail.next = evenHead;
        return oddHead;
    }

    public ListNode oddEvenList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        // Save even head
        ListNode evenHead = evenNode;
        while (evenNode != null && evenNode.next != null) {
            // Connect odd nodes
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
            // Connect even nodes
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }
        // Attach even list after odd list
        oddNode.next = evenHead;
        return head;
    }

}
