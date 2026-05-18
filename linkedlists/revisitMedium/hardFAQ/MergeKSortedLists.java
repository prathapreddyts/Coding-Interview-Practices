package linkedlists.revisitMedium.hardFAQ;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode mergedList = lists[0];
        for (int i = 1; i < lists.length; i++) {
            mergedList =
                    mergeTwoLists(mergedList,
                            lists[i]);
        }
        return mergedList;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode currentNode1 = list1;
        ListNode currentNode2 = list2;
        ListNode newHead = null;
        ListNode newTail = null;
        // Initialize head
        if (currentNode1.val < currentNode2.val) {
            newHead = currentNode1;
            currentNode1 = currentNode1.next;

        } else {
            newHead = currentNode2;
            currentNode2 = currentNode2.next;
        }
        newTail = newHead;
        // Merge both lists
        while (currentNode1 != null &&
                currentNode2 != null) {
            if (currentNode1.val <
                    currentNode2.val) {
                newTail.next = currentNode1;
                currentNode1 = currentNode1.next;

            } else {
                newTail.next = currentNode2;
                currentNode2 = currentNode2.next;
            }
            newTail = newTail.next;
        }
        // Remaining nodes
        if (currentNode1 != null) {
            newTail.next = currentNode1;
        }
        if (currentNode2 != null) {
            newTail.next = currentNode2;
        }
        return newHead;
    }

    public ListNode mergeKListsUsingPriortyQues(ListNode[] lists) {
        ListNode head = null;
        ListNode tail = null;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (ListNode list : lists) {
            while (list != null) {
                priorityQueue.add(list.val);
                list = list.next;
            }
        }
        while (!priorityQueue.isEmpty()) {
            ListNode newNode = new ListNode(priorityQueue.poll());
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }
}
