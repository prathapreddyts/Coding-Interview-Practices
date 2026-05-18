package linkedlists.revisitMedium.hardFAQ;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode listNode1, ListNode listNode2) {
        ListNode currentNode1 = listNode1;
        ListNode currentNode2 = listNode2;
        ListNode newHead = null;
        ListNode newTail = null;
        int carry = 0;
        while (currentNode1 != null || currentNode2 != null) {
            int val1 = 0;
            int val2 = 0;
            if (currentNode1 != null) {
                val1 = currentNode1.val;
            }
            if (currentNode2 != null) {
                val2 = currentNode2.val;
            }
            int sum = val1 + val2 + carry;
            int digit = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(digit);
            if (newHead == null) {
                newHead = newNode;
                newTail = newNode;

            } else {
                newTail.next = newNode;
                newTail = newNode;
            }
            if (currentNode1 != null) {
                currentNode1 = currentNode1.next;
            }
            if (currentNode2 != null) {
                currentNode2 = currentNode2.next;
            }
        }
        if (carry != 0) {
            ListNode lastNode = new ListNode(carry);
            newTail.next = lastNode;
            newTail = lastNode;
        }
        return newHead;
    }
}
