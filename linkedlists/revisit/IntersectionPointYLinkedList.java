package linkedlists.revisit;

public class IntersectionPointYLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = getLength(headA);
        int bLength = getLength(headB);
        ListNode currentHeadA = headA;
        ListNode currentHeadB = headB;
        int diffLength = Math.abs(aLength - bLength);
        // Move longer list ahead
        if (aLength > bLength) {
            while (diffLength > 0) {
                currentHeadA = currentHeadA.next;
                diffLength--;
            }
        } else {

            while (diffLength > 0) {
                currentHeadB = currentHeadB.next;
                diffLength--;
            }
        }
        // Compare nodes
        while (currentHeadA != null && currentHeadB != null) {
            if (currentHeadA == currentHeadB) {
                return currentHeadA;
            }
            currentHeadA = currentHeadA.next;
            currentHeadB = currentHeadB.next;
        }
        return null;
    }

    public int getLength(ListNode current) {
        int len = 0;
        while (current != null) {
            len++;
            current = current.next;
        }
        return len;
    }
}
